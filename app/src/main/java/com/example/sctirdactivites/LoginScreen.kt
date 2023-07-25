package com.example.sctirdactivites


import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sctirdactivites.ui.theme.Orange

@Composable
fun WelcomeActivity(navHostController: NavController) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                OrangeBackGroundCircle()
                Spacer(Modifier.height(25.dp))
                StyledText("Subhash Chandra Foundation",horizontalPadding = 1.dp)
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    //horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Spacer(Modifier.height(10.dp))

                }
            }

        Column(
            modifier = Modifier.fillMaxSize().padding(0.dp),
            verticalArrangement = Arrangement.Bottom,
        ) {
            DisplayItems()
            Spacer(Modifier.height(40.dp))
            MainImage(Modifier.height(190.dp))
            Spacer(Modifier.height(40.dp))
            SimpleOutlinedTextFieldSample()
            Spacer(Modifier.height(40.dp))
            PasswordTextField()
            Spacer(Modifier.height(40.dp))
            LoginButton(onClick = {navHostController.navigate(ScreenNav.UiDashboard.route)})
            Spacer(Modifier.height(20.dp))
            SignUpText()
            Spacer(Modifier.height(10.dp))
        }
    }


@Composable
fun StyledText(str: String,horizontalPadding: Dp) {
    Text(
    text = "$str",
    style = TextStyle(
        fontFamily= FontFamily(Font(R.font.poppins_bold)),
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 2.sp,
        textAlign = TextAlign.Center),
    color = Color(0xFFFFFFFF),
    modifier = Modifier.padding(horizontal = horizontalPadding)
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
        Item(text = "◉ Health ◉")
        Item(text = "◉Education◉")
        Item(text = "◉ Agriculture ◉")
        Item(text = "◉ Rural Development ◉")
        Item(text = "◉ Sports and Youth Development ◉")
        Item(text = "◉Women Empowerment & Life-Skill Development◉")
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
fun RoundedBorderedImage(
    imageModifier: Modifier = Modifier,
    borderColor: Color = Orange,
    borderWidth: Dp = 2.dp,
    cornerRadius: Dp = 18.dp,
    contentDescription: String,
    painter: Painter,
    contentScale: ContentScale = ContentScale.Crop,
) {
    Box(
        modifier = imageModifier
            .clip(RoundedCornerShape(cornerRadius))
            .border(borderWidth, borderColor)
            .fillMaxWidth()
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            contentScale = contentScale,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun MainImage(imageHeight: Modifier = Modifier) {
    RoundedBorderedImage(
        imageModifier = Modifier
            .fillMaxWidth() // Adjusts the width to match the parent width
            .then(imageHeight)
            .padding(horizontal = 16.dp),
        painter = painterResource(id = R.drawable.mainview),
        contentDescription = "MainView"
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
        colors = ButtonDefaults.buttonColors(Orange)
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 22.dp),
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



@Composable
fun SimpleOutlinedTextFieldSample() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        textStyle = TextStyle(color = Orange, fontWeight = FontWeight.Bold),
        label = { Text("Phone Number" , ) },
        trailingIcon = {
            Icon(imageVector = Icons.Default.Phone,
                contentDescription = "Phone Icon") },
        placeholder = { Text(text = "Enter your Mobile Number") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.padding(horizontal = 50.dp)
    )
}

@Composable
fun PasswordTextField() {
    var password by rememberSaveable { mutableStateOf("") }
    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        trailingIcon = {
            Icon(imageVector = Icons.Default.Lock,
                contentDescription = "Person Icon") },
        placeholder = { Text(text = "Enter your Password") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier.padding(horizontal = 50.dp)

    )
}


@Composable
fun OrangeBackGroundCircle() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
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