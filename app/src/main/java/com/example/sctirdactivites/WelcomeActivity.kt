package com.example.sctirdactivites


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun WelcomeActivity() {
    Box(
        modifier=Modifier.fillMaxSize()
            .background(color = Color(0xFFFFFFFF)),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(15.dp))
            StyledText("Subhash Chandra Foundation")
            Spacer(Modifier.height(10.dp))
            DisplayItems()
            Spacer(Modifier.height(10.dp))
            TruckImage()
            LoginButton(onClick = {})
            Spacer(Modifier.height(20.dp))
            SignUpText()
            Spacer(Modifier.height(10.dp))
        }
    }
}

@Composable
fun StyledText(str: String) {
    Text(
    text = "$str",
    style = TextStyle(
        fontFamily= FontFamily(Font(R.font.poppins_bold)),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 33.sp,
        letterSpacing = 4.sp,
        textAlign = TextAlign.Center
    ),
    color = Color(0xFFFF8F27)
)
}
@Composable
fun DisplayItems() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Item(text = "Sports and Youth Development")
        Item(text = "Rural Development")
        Item(text = "Education")
        Item(text = "Women Empowerment and Life Skill Development")
        Item(text = "Agriculture")
        Item(text = "Health")
    }
}
@Composable
fun Item(text: String) {
    Text(
        text = text,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun TruckImage(){
    Image(
        painter = painterResource(id = R.drawable.landingpage_svg),
        contentDescription = "Truck",
        modifier = Modifier
            .fillMaxWidth() // Adjusts the width to match the parent width
            .height(400.dp),
        contentScale = ContentScale.FillWidth
    )
}
@Composable
fun LoginButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary,
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Login with Phone",
                style = TextStyle(
                    color = Color.White,
                    fontFamily= FontFamily(Font(R.font.poppins_bold)),
                    fontSize = 16.sp,
                )
            )
            Image(
                painter = painterResource(id = R.drawable.arrowtoright),
                contentDescription = "Arrow",
                contentScale = ContentScale.FillWidth
            )

        }

    }
}

@Composable
fun SignUpText(){
    val text = buildAnnotatedString {
        withStyle(style = SpanStyle(
            color = MaterialTheme.colorScheme.secondary,
            textDecoration = TextDecoration.None
            )) {
            append("Or Create An Account")
        }
    }
    fun handleClick() {
        println("Clickable text clicked!")
    }
    ClickableText(
        text = text,
        onClick = {handleClick()},
        modifier = Modifier.fillMaxWidth().padding(horizontal = 22.dp),
        style = TextStyle(
            fontFamily= FontFamily(Font(R.font.poppins_bold_italic)),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 22.sp,
            letterSpacing = 0.15.sp,
            textAlign = TextAlign.Start
        )
    )
}