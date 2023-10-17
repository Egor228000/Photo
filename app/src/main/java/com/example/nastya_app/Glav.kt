package com.example.nastya_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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

@Composable
fun Glav(navController: NavController){
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
        Box {

            Image(
                painter = painterResource(id = R.drawable.fon),
                contentDescription = "image description",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(0.88f)
            )



                Column(Modifier.padding(start = 60.dp, top = 250.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "image description",
                        modifier = Modifier.size(38.dp)

                    )
                }
            Row {
                Column(Modifier.padding(start = 60.dp, top = 250.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_two),
                        contentDescription = "image description",
                        modifier = Modifier.size(38.dp)

                    )
                }
                Text(
                    text = "photo",
                    style = TextStyle(
                        fontSize = 48.sp,
                        fontFamily = FontFamily(Font(R.font.comfortaa)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(start = 30.dp, top = 225.dp)
                )

            }

            /*
            Image(
                painter = painterResource(id = R.drawable.Union),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )*/

        }
        Row(
            Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {

            OutlinedButton(onClick = { navController.navigate("login")},
                modifier = Modifier
                    .border(
                        width = 2.dp, color = Color(0xFF000000),
                        shape = RoundedCornerShape(size = 6.dp)
                    )
                    .fillMaxWidth(0.4f)
                    .height(52.dp)
                    .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 6.dp))
            ) {
                Text(
                    text = "LOG IN",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontWeight = FontWeight(900),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.52.sp,
                    )
                )

            }
            Spacer(modifier = Modifier.padding(16.dp))
            Button(onClick = { navController.navigate("register") },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(Color.Black),
            shape = RoundedCornerShape(size = 6.dp)

            ) {
                Text(
                    text = "REGISTER",
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
        }




    }

}