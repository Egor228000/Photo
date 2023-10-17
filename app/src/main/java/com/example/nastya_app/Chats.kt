package com.example.nastya_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import java.net.URLEncoder

@Composable
fun Chats(navController: NavController){
/*    val one_photo = "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/3.jpeg?alt=media&token=a9c0976e-7774-486c-a58e-1c96c040e66c"
    val two_photo ="https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/c4e76138cf8b06b4700109d112563b79.jpeg?alt=media&token=18588927-6e12-48d8-81a0-926d8cd5e6c2"
    val free_photo ="https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/b252688e26d038f2271ab651705640e9.jpeg?alt=media&token=08a04a44-1d83-4d91-952b-f0703d9c2245"
    val for_photo = "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/997f19ca25e99aaee58cbaa7ed86d004.jpeg?alt=media&token=a0e57e2e-ee12-4533-8cc7-520352c1618f"*/



    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())) {
        TopAppBar(Modifier.fillMaxWidth(1f), backgroundColor = Color.White) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Chats",
                    style = TextStyle(
                        fontSize = 17.sp,
                        lineHeight = 22.sp,
                        fontFamily = FontFamily(Font(R.font.comfortaa)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    )
                )
            }

        }
        CardChat(
            navController,
            avatar =   R.drawable.asd,
            "James",
            "Thank you! That was very helpful!",
        )
        CardChat(
            navController,
            avatar = R.drawable.c4e76138cf8b06b4700109d112563b79,
            "Will Kenny",
            "I know... I’m trying to get the funds.",

        )
        CardChat(
            navController,
            avatar = R.drawable.b252688e26d038f2271ab651705640e9,
            "Beth Williams",
            "I’m looking for tips around capturing    the milky way. I have a 6D with a 24-100mm...",

        )
        CardChat(
            navController,
            avatar = R.drawable.gfsdg,
            "Rev Shawn",
            "Wanted to ask if you’re available for a portrait shoot next week.",
        )


    }
}

@Composable
fun CardChat(navController: NavController, avatar: Int, name: String, dis: String){
    Row(modifier = Modifier.
    fillMaxWidth(1f)
        .clickable { navController.navigate("chat/$avatar/$name/$dis")}.padding(start = 16.dp)) {
        Image(painter = painterResource(id = avatar), contentDescription = "",
            modifier = Modifier
                .padding(10.dp)
                .width(64.dp)
                .height(64.dp)
                .clip(shape = RoundedCornerShape(50)),
            contentScale = ContentScale.Crop)
        Column(Modifier.padding(start = 7.dp, top = 15.dp)) {
            Text(
                text = name,
                style = TextStyle(
                    fontSize = 13.sp,
                    lineHeight = 18.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )

            Text(
                text = dis,
                style = TextStyle(
                    fontSize = 13.sp,
                    lineHeight = 18.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
        }

    }
    Divider(Modifier.fillMaxWidth(1f).height(1.dp))

}