package com.example.nastya_app

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController

@Composable
fun Login(navController: NavController){
    


    val context = LocalContext.current
    val store = UserStore(context)

    val email = store.getAccetToken_1.collectAsState(initial = "")

    val password = store.getAccetToken_2.collectAsState(initial = "")

    var emailid by remember {
        mutableStateOf("")
    }
    var passwordid by remember {
        mutableStateOf("")
    }


    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {


        IconButton(onClick = {navController.popBackStack()}) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = ""
            )
        }

        Text(
            text = "Log in",
            style = TextStyle(
                fontSize = 36.sp,
                fontFamily = FontFamily(Font(R.font.comfortaa)),
                fontWeight = FontWeight(400),
                color = Color(0xFF000000)
            )
            , modifier = Modifier.padding(start = 16.dp)
        )
        OutlinedTextField(
            value = emailid,
            onValueChange = { emailid = it },
            modifier = Modifier
                .padding(start = 16.dp, top = 50.dp, end = 16.dp)
                .fillMaxWidth(1f)
                .height(52.dp)
                .border(width = 2.dp, Color.Black),
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = false,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            shape = RoundedCornerShape(0 ),
            placeholder = { Text(text = "Email")}
        )

        OutlinedTextField(
            value = passwordid,
            onValueChange = { passwordid = it },
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
            shape = RoundedCornerShape(0 ),
            singleLine = true,
            placeholder = { Text(text = "Password")}
        )





        Button(onClick = {
            if (emailid == email.value && passwordid == password.value){
                navController.navigate("menu")
            }else{
                Toast.makeText(context,"Invalid email or password",Toast.LENGTH_SHORT).show()

            }
                         },
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(16.dp)
                .height(52.dp),
            colors =  ButtonDefaults.buttonColors(Color.Black)) {
            Text(
                text = "LOG IN",
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



