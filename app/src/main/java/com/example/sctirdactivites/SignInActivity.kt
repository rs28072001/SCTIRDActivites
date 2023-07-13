package com.example.sctirdactivites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun SignInActivity(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFFFFF)
    ),
    ) {
        OrangeBackGroundCircle()
        LoginForm()
    }
}

@Composable
fun LoginForm(){
    Column{
    Text(text = "Subhash Chandra Foundation",
        color = Color.White,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
    )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Item(text = "◉Health◉")
            Item(text = "◉Education◉")
            Item(text = "◉Agriculture◉")
            Item(text = "◉Rural Development◉")
            Item(text = "◉Sports and Youth Development◉")
            Item(text = "◉Women Empowerment & Life-Skill Development◉")
        }
}}


@Preview
@Composable
fun OrangeBackGroundCircle() {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.backgroundcurveorange_svg),
            contentDescription = "Orange Half Circle background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth(),
//            .offset(y = (-115).dp)
        )
    }
}