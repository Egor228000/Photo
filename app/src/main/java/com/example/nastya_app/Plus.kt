package com.example.nastya_app

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.MediaStore
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import androidx.navigation.NavController
import java.io.ByteArrayOutputStream

@Composable
fun Plus(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val context = LocalContext.current

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.image1),
                contentDescription = "Image 1",
                modifier = Modifier
                    .clickable {
                        shareImage(context, R.drawable.image1)
                    }
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(R.drawable.image2),
                contentDescription = "Image 2",
                modifier = Modifier
                    .clickable {
                        shareImage(context, R.drawable.image2)
                    }
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(R.drawable.image3),
                contentDescription = "Image 3",
                modifier = Modifier
                    .clickable {
                        shareImage(context, R.drawable.image3)
                    }
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}


fun shareImage(context: Context, drawabled: Int){
    val outputStream = ByteArrayOutputStream()
    val bitmap: Bitmap = BitmapFactory.decodeResource(context.resources, drawabled)
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
    val path: String = MediaStore.Images.Media.insertImage(context.contentResolver, bitmap, "Image", null)
    val imageUri: Uri = Uri.parse(path)
    val intent = intent(intent.AC=)
}