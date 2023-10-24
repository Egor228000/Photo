package com.example.nastya_app

import android.content.Intent
import android.widget.GridLayout
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.valentinilk.shimmer.shimmer
import java.net.URLEncoder

@Composable
fun Menu(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())) {
        Text(
            text = "Discover",
            style = TextStyle(
                fontSize = 36.sp,
                fontFamily = FontFamily(Font(R.font.comfortaa)),
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
            ),
            modifier = Modifier.padding(start = 16.dp, top = 30.dp)
        )
        Text(
            text = "WHAT’A NEW TODAY",
            style = TextStyle(
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontWeight = FontWeight(900),
                color = Color(0xFF000000),
                letterSpacing = 0.52.sp,
            ),
            modifier = Modifier.padding(start = 16.dp, top = 30.dp)
        )
        LazyRow() {
            items(1) {
                PostCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/2f04d7a9e41a9fbb7cbf791810e77d5b.jpeg?alt=media&token=a5b56022-082b-4874-a02a-8cd667d4593e",
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/34bf543b82df5ad4e302b820fa57046a.jpeg?alt=media&token=24335b7c-c463-4a31-9393-290d9119783d",
                    "Ridhwan Nordin",
                    "@ridzjcob"
                )
                PostCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/2c550d03adf1862487db06318a14f247.jpeg?alt=media&token=41c14f99-ba83-41f9-bd12-123de885410f",
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/fc63760fdf97104ec2918c60826228b2.jpeg?alt=media&token=4e23b700-3079-4984-8cab-8a383dff1bc4",
                    "Clem Onojeghuo",
                    "@clemono2"
                )
                PostCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/754c0b73e4b1c94ebd7af2fee8a70504.jpeg?alt=media&token=53d8de9a-1d9c-4051-a21c-f0c0ef8f7525",
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/66716c3c3d107981e2c201c0a1f0b156.jpeg?alt=media&token=007adcd2-1aa6-4c6f-9dc0-e238042498a6",
                    "Jon Tyson",
                    "@jontyson"
                )
                PostCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/d24ce49c7d3d0d87b079a49a32babbca.jpeg?alt=media&token=28607e88-0a2e-4f11-a49c-80c027f7dbc3",
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/0a7ccd22c8ced170b94e61e35c84fdab.jpeg?alt=media&token=0d137fa5-9c55-4c16-aade-945508c6deb9",
                    "Simon Zhu",
                    "@smnzhu"
                )
            }
        }
        Text(
            text = "BROWSE ALL",
            style = TextStyle(
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontWeight = FontWeight(900),
                color = Color(0xFF000000),
                letterSpacing = 0.52.sp,
            ), modifier = Modifier.padding(start = 16.dp, top = 50.dp)
        )
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            verticalItemSpacing = 16.dp,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.heightIn(0.dp, 3000.dp)

        ) {

            items(1) {
                SizeCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/1.jpeg?alt=media&token=2b4bef36-adea-46e1-bfa6-07263e3cee8c",
                    220.dp
                )

            }
            items(1){
                SizeCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/85fa51d58cd7dd6675ccd54c51b3ea4a.jpeg?alt=media&token=d7ef0232-af9a-47d4-a587-a1b8e1b517dd",
                    310.dp
                )

            }
            items(1){
                SizeCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/2d8c9f95c593542a65c0da55f2d8db5a.jpeg?alt=media&token=c4816390-bc98-4193-8db9-f1ffb093df93",
                    310.dp
                )

            }
            items(1){
                SizeCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/6131d6a78553b60c2124bbf5b0cab22c.jpeg?alt=media&token=873c0f93-ee6c-47a6-b69f-c1ba8147806e",
                    310.dp
                )

            }
            items(1){
                SizeCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/066f226af86c03ce102f958a33b3991a.jpeg?alt=media&token=61b9f192-cb71-4fd3-a88b-5d7bf014a3b0",
                    220.dp
                )

            }
            items(1){
                SizeCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/6579fa2e88a19be892239da2ab66a9d8.jpeg?alt=media&token=24c2389c-7934-43cb-8cef-820f27e48b44",
                    220.dp
                )

            }
            items(1){
                SizeCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/336758a67f3002be1eb780d612940cd3.jpeg?alt=media&token=c2b052b9-f88f-41f3-a01b-4b94ebecaeeb",
                    310.dp
                )

            }
            items(1){
                SizeCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/16c7eced8754d939b40d0f9e8ca2f550.jpeg?alt=media&token=e1c353be-5f6c-44e8-bb03-759a9f49b081",
                    310.dp
                )

            }
            items(1){
                SizeCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/e112275f9aa09dbb0b5f7994cfcc7c43.jpeg?alt=media&token=6831db0b-08ae-44f8-aa36-7f1ad9c890ad",
                    310.dp
                )

            }
            items(1){
                SizeCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/9eba158c8def917e830b08e60575866c.jpeg?alt=media&token=4789bddb-bc2a-4701-b5b3-89908ad842b2",
                    220.dp
                )

            }

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SizeCard(navController: NavController, kartinka: String, size_height: Dp){
    val context = LocalContext.current
    SubcomposeAsyncImage(
        model = kartinka,
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .width(167.dp)
            .height(size_height)
            .combinedClickable(
                onClick = { navController.navigate("image/${URLEncoder.encode(kartinka, "UTF-8")}")},
                onLongClick = {  val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, kartinka)
                    type = "text/plain"
                }
                    val shareIntent = Intent.createChooser(sendIntent, null)
                    context.startActivity(shareIntent)},
            )

    ) {

        val state = painter.state
        if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
            Box(modifier = Modifier.shimmer()
                .background(Color.Gray)
            ){

            }
        } else {
            SubcomposeAsyncImageContent()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostCard(navController: NavController, kartinka: String, avatar: String, name: String, email: String) {
    val context = LocalContext.current

    Column {
        SubcomposeAsyncImage(
            model = kartinka,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(343.dp)
                .padding(6.dp)
                .height(343.dp)
                .combinedClickable(
                    onClick = { navController.navigate("image/${URLEncoder.encode(kartinka, "UTF-8")}")},
                    onLongClick = {  val sendIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, kartinka)
                        type = "text/plain"
                    }
                        val shareIntent = Intent.createChooser(sendIntent, null)
                        context.startActivity(shareIntent)},
                )
        ) {
            Box {

            }
            val state = painter.state
            if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                Box(modifier = Modifier.shimmer()
                    .background(Color.Gray)
                ){

                }
            } else {
                SubcomposeAsyncImageContent()
            }
        }

        Row(Modifier.padding(start = 10.dp, top = 15.dp)) {
            SubcomposeAsyncImage(
                model = avatar,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 3.dp)
                    .clip(shape = RoundedCornerShape(50.dp))
                    .width(28.dp)
                    .height(28.dp)
            ) {
                Box {

                }
                val state = painter.state
                if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                    Box(modifier = Modifier.shimmer()
                        .background(Color.Gray)
                    ){

                    }
                } else {
                    SubcomposeAsyncImageContent()
                }
            }
            Column(Modifier.padding(start = 10.dp)) {
                Text(
                    text = name,
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000),
                    )
                )
                Text(
                    text = email,
                    style = TextStyle(
                        fontSize = 11.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontWeight = FontWeight(400),
                        color = Color(0xCC000000),
                    )
                )
            }


        }


    }
}
