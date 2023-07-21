package com.example.sctirdactivites

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun SignInActivity(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFFFFFFF)
            ),
    ) {
        OrangeBackGroundCircle()
        LoginForm()
        //LoginScreen()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LoginForm(){
    Column{
    Text(text = "Subhash Chandra Foundation",
        color = Color.White,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(horizontal = 5.dp)
    )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Item(text = "◉ Health ◉")
            Item(text = "◉ Education ◉")
            Item(text = "◉ Agriculture ◉")
            Item(text = "◉ Rural Development ◉")
            Item(text = "◉ Sports and Youth Development ◉")
            Item(text = "◉ Women Empowerment & Life-Skill Development ◉")
        }
        Text(text = "Welcome !",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            textDecoration =  TextDecoration.Underline,
            modifier = Modifier.padding(horizontal = 25.dp,vertical = 25.dp)
        )
        LoginTextField()

    }}

@Composable
fun LoginTextField() {

}


