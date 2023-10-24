package com.example.nastya_app

import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer
import java.net.URLEncoder

@Composable
fun Profile(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())) {

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()) {
            SubcomposeAsyncImage(
                model = "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/profile5.jpeg?alt=media&token=1cc5f2e3-d07a-4db5-87a9-2af06bb6a1cb",
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 80.dp)
                    .width(128.dp)
                    .height(128.dp)
                    .clip(shape = RoundedCornerShape(50))


            )
            {

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


            Text(
                text = "Jane",
                style = TextStyle(
                    fontSize = 36.sp,
                    fontFamily = FontFamily(Font(R.font.comfortaa)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),

                    textAlign = TextAlign.Center,
                )
            )
            Spacer(modifier = Modifier.padding(top =10.dp))
            Text(
                text = "San francisco, ca",
                style = TextStyle(
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    fontWeight = FontWeight(900),
                    color = Color(0xFF000000),

                    textAlign = TextAlign.Center,
                    letterSpacing = 0.52.sp,
                )
            )
            Button(onClick = { },
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(16.dp)
                    .height(52.dp),
                colors =  ButtonDefaults.buttonColors(Color.Black)) {
                Text(
                    text = "FOLLOW JANE",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontWeight = FontWeight(900),
                        color = Color(0xFFFFFFFF),

                        textAlign = TextAlign.Center,
                        letterSpacing = 0.52.sp,
                    )
                )

            }
            OutlinedButton(onClick = { navController.navigate("chats")},
                modifier = Modifier
                    .offset(y = -15.dp)
                    .fillMaxWidth(1f)
                    .padding(16.dp)
                    .height(52.dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xFF000000),
                        shape = RoundedCornerShape(size = 6.dp)
                    )
            ){
                Text(text = "MESSAGE",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold))),
                    fontWeight = FontWeight(900),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.52.sp
                )
            }
        }



        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            verticalItemSpacing = 16.dp,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.heightIn(0.dp, 3000.dp)

        ) {

            items(1) {
                SizeeCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/profile1.jpeg?alt=media&token=1bb64c14-c11d-4fbf-b354-5832deb8d8e8",
                    220.dp
                )

            }
            items(1){
                SizeeCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/profile2.jpeg?alt=media&token=3c4b13e7-58cf-493b-8ec3-3b09af3438a0",
                    310.dp
                )

            }
            items(1){
                SizeeCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/profile3.jpeg?alt=media&token=c73dd246-0a6e-4706-b2d7-9b5cf54cf1dd",
                    310.dp
                )

            }
            items(1){
                SizeeCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/profile4.jpeg?alt=media&token=77529ad3-eead-4447-9dc1-2d59f60c76b7",
                    310.dp
                )

            }
            items(1){
                SizeeCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/profile5.jpeg?alt=media&token=1cc5f2e3-d07a-4db5-87a9-2af06bb6a1cb",
                    310.dp
                )

            }
            items(1){
                SizeeCard(
                    navController,
                    "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/profile6.jpeg?alt=media&token=24a13c3c-5778-4669-8419-241adbfa25a8",
                    220.dp
                )

            }


        }
        OutlinedButton(onClick = { },
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(16.dp)
                .height(52.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF000000),
                    shape = RoundedCornerShape(size = 6.dp)
                )
        ){
            Text(text = "SEE MORE",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold))),
                fontWeight = FontWeight(900),
                textAlign = TextAlign.Center,
                letterSpacing = 0.52.sp
            )
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SizeeCard(navController: NavController, kartinka: String, size_height: Dp) {
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