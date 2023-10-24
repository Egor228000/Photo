package com.example.nastya_app

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.valentinilk.shimmer.shimmer
import java.net.URLEncoder

data class searchCarding(val navController: NavController.Companion, val kartinka: String, val id: String)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Search(navController: NavController) {

    val searchList = listOf(
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/8b0b64b3459aea4b86d252f4cc3d7c6b.jpeg?alt=media&token=4cc386a1-9681-4b71-8c07-2161c27084ff",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/2.jpeg?alt=media&token=2275d453-7ea6-4c53-a88c-379f4c610bf3",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/280dc8d5df563073f32bcf62e294ad52.jpeg?alt=media&token=629701c4-8266-482e-bbc0-bf29484b2a46",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/554422494f7a6c8e1d131680601e1181.jpeg?alt=media&token=e90ee34c-fabd-4842-9eab-2c1115c95fed",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/cat1.jpeg?alt=media&token=9c5228ae-2a1a-4627-8221-d0f15418a35a",
            "cat"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/415c5e7fa94da42b224cae2325b3a76c.jpeg?alt=media&token=804d2853-a80d-4bcc-822b-9b899f1e1eac",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/43284911ddd810c9ccd74557dad570e3.jpeg?alt=media&token=a4d8b577-325a-4237-9a79-293acfd83177",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/cat5.jpg?alt=media&token=cf6fc954-7ddc-4f8a-b2bc-0539c1881637",
            "cat"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/8e769651b712805a9bef750622f70715.jpeg?alt=media&token=f00e801d-4fcb-406d-9f53-b2d52e4bb59f",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/8fa0a2e9e675b21a3761ec0a3fb60550.jpeg?alt=media&token=eedb8ce0-64c5-4888-a2a6-df4afb722182",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/9ae21b810926c8c72281d86e749056b1.jpeg?alt=media&token=abf56b31-b21b-4f4d-bd7a-d5308aa42d92",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/cat2.jpg?alt=media&token=b96f5d8d-3825-483a-9522-ede5cdfaba93",
            "cat"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/9b28775798cc1b3ab178317c4dd6b957.jpeg?alt=media&token=b4223856-66b0-4f15-a02a-0f4a19d4c7a1",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/3625f2c33e46ed3718c98165b3ade364.jpeg?alt=media&token=58d13944-aead-4a8a-a4e0-3f3b80be2c4a",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/7021698deb3b73f50dedc04984a3199b.jpeg?alt=media&token=193979d7-cb00-44b8-b29c-b9e50d698b90",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/cat9.jpg?alt=media&token=c8850e4c-eb0e-49a7-9653-a5d7b95a9263",
            "cat"
        ),
        searchCarding(
            navController = NavController,
            "https://proprikol.ru/wp-content/uploads/2019/07/kartinki-sobachki-7.jpg",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/sobaka1.jpeg?alt=media&token=b910e213-8e82-4e22-b61b-7ee08ecd9730",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/sobaka10.jpg?alt=media&token=76cae2cd-5802-4d7e-a7f8-16c4ee4fe67f",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/sobaka2.jpg?alt=media&token=af9c2c94-21cd-42ba-baea-4ba0e3df5d38",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/cat3.jpeg?alt=media&token=2a5e74d7-e89c-4874-beb1-ab03f3ab16b1",
            "cat"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/sobaka3.jpg?alt=media&token=dfd53cee-bacd-492e-8eb3-0f8f118cd47c",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/sobaka4.jpg?alt=media&token=c46ea6d6-052b-40b8-9804-c228a949ac5b",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/sobaka5.jpg?alt=media&token=ce21a610-fb78-4222-975e-6a1036ec220e",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/cat6.jpg?alt=media&token=4c2e689b-8c8f-419f-b2ac-d7ff44f380f8",
            "cat"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/cat7.jpg?alt=media&token=a5892b0e-c062-483e-b2d6-9d23c9fb3477",
            "cat"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/sobaka6.jpg?alt=media&token=ba3fad6d-8f4f-45ca-b787-098402061b44",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/sobaka7.jpeg?alt=media&token=9acad6ef-42ea-49b5-b6b0-c1a163094a86",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/cat8.jpg?alt=media&token=3c949c4d-e592-4d72-8716-56073ce83ae3",
            "cat"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/sobaka8.jpg?alt=media&token=e7b41903-1cd2-4a39-ab08-624b02e7786b",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/sobaka9.jpg?alt=media&token=934b0d10-a4d8-434b-a1a8-98a69e649be0",
            "dog"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/cat4.jpg?alt=media&token=fe401ad2-cedf-409d-9c85-a6887b81320a",
            "cat"
        ),
        searchCarding(
            navController = NavController,
            "https://firebasestorage.googleapis.com/v0/b/sanatoriums.appspot.com/o/s1200.webp?alt=media&token=93c82678-94f1-4218-99af-b8974d128a59",
            "dog"
        ),


        )
    var search by remember {
        mutableStateOf("")
    }
    val filteredList = searchList.filter { item ->
        item.id.contains(search.lowercase(), ignoreCase = true)
    }





    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 0.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Text(
            text = "Search",
            style = TextStyle(
                fontSize = 36.sp,
                fontFamily = FontFamily(Font(R.font.comfortaa)),
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
            ),
            modifier = Modifier.padding(start = 16.dp, top = 50.dp)
        )

        OutlinedTextField(
            value = search,
            onValueChange = { newValue -> search = newValue },
            modifier = Modifier
                .padding(start = 16.dp, top = 20.dp, end = 16.dp)
                .fillMaxWidth(1f)
                .height(52.dp)
                .border(width = 2.dp, Color.Black),
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = false,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            shape = RoundedCornerShape(0),
            singleLine = true,
            placeholder = { Text(text = "dogs") }
        )
        Text(
            text = "ALL RESULTS",
            style = TextStyle(
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontWeight = FontWeight(900),
                color = Color(0xFF000000),
                letterSpacing = 0.52.sp,
            ),
            modifier = Modifier.padding(start = 16.dp, top = 30.dp)
        )

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(100.dp),
            contentPadding = PaddingValues(16.dp),
            verticalItemSpacing = 16.dp,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.heightIn(0.dp, 3000.dp)

        ) {

            items(filteredList) { item ->

                val context = LocalContext.current
                SubcomposeAsyncImage(
                    model = item.kartinka,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(107.dp)
                        .height(107.dp)
                        .padding(10.dp)
                        .combinedClickable(
                            onClick = {
                                navController.navigate(
                                    "image/${
                                        URLEncoder.encode(
                                            item.kartinka,
                                            "UTF-8"
                                        )
                                    }"
                                )
                            },
                            onLongClick = {
                                val sendIntent: Intent = Intent().apply {
                                    action = Intent.ACTION_SEND
                                    putExtra(Intent.EXTRA_TEXT, item.kartinka)
                                    type = "text/plain"
                                }
                                val shareIntent = Intent.createChooser(sendIntent, null)
                                context.startActivity(shareIntent)
                            },
                        )


                )
                {

                    val state = painter.state
                    if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                        Box(
                            modifier = Modifier.shimmer()
                                .background(Color.Gray)
                        ) {

                        }
                    } else {
                        SubcomposeAsyncImageContent()
                    }
                }

            }
        }


        OutlinedButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(16.dp)
                .height(52.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF000000),
                    shape = RoundedCornerShape(size = 6.dp)
                )
        ) {
            Text(
                text = "SEE MORE",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold))
                ),
                fontWeight = FontWeight(900),
                textAlign = TextAlign.Center,
                letterSpacing = 0.52.sp
            )
        }
    }
}




