package com.example.nastya_app

import android.app.Activity
import android.app.Activity.*
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun Chat(navController: NavController, avatar: Int, name: String, dis: String) {
    var messages by rememberSaveable { mutableStateOf(emptyList<String>()) }
    var messageToSend by remember { mutableStateOf("") }

    var selectedImageUri by remember { mutableStateOf(emptyList<Uri?>()) }/*var selectedImageUris by remember {
        mutableStateOf<List<Uri>>(emptyList())
    }*/
    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> selectedImageUri = listOf(uri) }
    )
    /*val multiplePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(),
        onResult = { uris -> selectedImageUris = uris }
    )*/
    var file by remember {
        mutableStateOf(false)
    }


    Column {
        TopAppBar(Modifier.fillMaxWidth(1f), backgroundColor = Color.White) {
            Column(horizontalAlignment = Alignment.Start,
            ) {
                IconButton(onClick = { navController.popBackStack() },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                        contentDescription = ""
                    )
                }
            }
            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 50.dp)) {




                Text(
                    text = name,
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


    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())) {
        Column {

            LeftMessage(avatar,
                "Really love your most recent photo. I’ve been trying to capture the same thing for a few months and would love some tips!")



            selectedImageUri.forEach {uri ->
                RightMessageImage(avatar = avatar, mesage = uri.toString())
            }
            messages.forEach { message ->
                RightMessage(avatar = R.drawable.gfsdg, mesage = message)

            }
        }









        }

    }
    Column(
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.weight(1f))
        TextField(
            value = messageToSend,
            onValueChange = { messageToSend = it },
            leadingIcon = {
                IconButton(onClick = {
                    singlePhotoPickerLauncher.launch(
                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                    )
                    file = true
                }) {
                    Icon(painter = painterResource(id = R.drawable.baseline_attach_file_24),
                        contentDescription = "")

                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    if (messageToSend.isNotEmpty()) {
                        messages = messages.plus(messageToSend)
                        messageToSend = ""
                    }
                }, enabled = messageToSend.isNotEmpty()) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_send_24),
                        contentDescription = ""
                    )

                }
            },
            modifier = Modifier
                .fillMaxWidth(1f)
                .background(Color.White),
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = false,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Send
            ),
        )

    }
}


@Composable
fun LeftMessage(avatar: Int, mesage: String) {
    Row(horizontalArrangement = Arrangement.Start,
     modifier = Modifier
         .fillMaxWidth()
         .padding(10.dp)) {
        Image(painter = painterResource(id = avatar), contentDescription = "",
            modifier = Modifier
                .padding(10.dp)
                .width(34.dp)
                .height(34.dp)
                .clip(shape = RoundedCornerShape(50)),
            contentScale = ContentScale.Crop)
        Card(
            Modifier
                .width(299.dp)
                .fillMaxHeight(1f)
                .padding(start = 10.dp, top = 10.dp) ,
            shape = RoundedCornerShape(size = 0.dp),
            backgroundColor = Color(0x08000000),
            elevation = 0.dp

        ) {
            Column(Modifier.padding(16.dp)) {
                Text(
                    text = mesage,
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
    }
    Spacer(modifier = Modifier.padding(top = 24.dp))

}
@Composable
fun RightMessage(avatar: Int, mesage: String) {
    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    Row(horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)) {

        Card(
            Modifier
                .width(299.dp)
                .fillMaxHeight(1f)
                .padding(start = 10.dp, top = 10.dp) ,
            shape = RoundedCornerShape(size = 0.dp),
            backgroundColor = Color(0x08000000),
            elevation = 0.dp

        ) {
            Column(Modifier.padding(16.dp)) {

                    Text(
                        text = mesage,
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
        Image(painter = painterResource(id = avatar), contentDescription = "",
            modifier = Modifier
                .padding(10.dp)
                .width(34.dp)
                .height(34.dp)
                .clip(shape = RoundedCornerShape(50)),
            contentScale = ContentScale.Crop)
    }
    Spacer(modifier = Modifier.padding(top = 24.dp))
}
@Composable
fun RightMessageImage(avatar: Int, mesage: String) {
    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    Row(horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)) {

        Card(
            Modifier
                .width(299.dp)
                .fillMaxHeight(1f)
                .padding(start = 10.dp, top = 10.dp) ,
            shape = RoundedCornerShape(size = 0.dp),
            backgroundColor = Color(0x08000000),
            elevation = 0.dp

        ) {
            Column(Modifier.padding(16.dp)) {

                AsyncImage(
                    model = mesage,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .height(150.dp),
                    contentScale = ContentScale.Crop,
                )
            }

        }
        Image(painter = painterResource(id = avatar), contentDescription = "",
            modifier = Modifier
                .padding(10.dp)
                .width(34.dp)
                .height(34.dp)
                .clip(shape = RoundedCornerShape(50)),
            contentScale = ContentScale.Crop)
    }
    Spacer(modifier = Modifier.padding(top = 24.dp))
}