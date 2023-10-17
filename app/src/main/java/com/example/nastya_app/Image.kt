package com.example.nastya_app

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import kotlinx.coroutines.launch

@Composable
fun Image(navController: NavController, kartinka: String){
    val initialScale = 1f
    val scale = remember { Animatable(initialScale) }

    val coroutineScope = rememberCoroutineScope()
    Box(
        Modifier
        .fillMaxSize()
        .background(Color.White)
        .pointerInput(Unit) {
            detectTransformGestures { _, pan, gestureZoom, _ ->
                coroutineScope.launch {
                    when {
                        gestureZoom != 1f -> scale.animateTo(scale.value * gestureZoom)
                        pan.x != 0f || pan.y != 0f -> {
                            // Handle panning/dragging if needed
                        }
                    }
                }
            }
        }) {

        SubcomposeAsyncImage(
            model = kartinka,
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(1f).graphicsLayer(scaleX = scale.value, scaleY = scale.value)
                .pointerInput(Unit) {
                    detectTapGestures {
                        coroutineScope.launch {
                            scale.animateTo(initialScale)
                        }
                    }
                }

        ) {

            val state = painter.state
            if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                CircularProgressIndicator(
                    color = Color.White,
                    backgroundColor = Color.Black,
                    strokeWidth = 5.dp
                )
            } else {
                SubcomposeAsyncImageContent()
            }
        }
        Column(horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { navController.popBackStack()}) {
                Icon(painter = painterResource(id = R.drawable.baseline_close_24),
                    contentDescription = "")

            }
        }

    }
}