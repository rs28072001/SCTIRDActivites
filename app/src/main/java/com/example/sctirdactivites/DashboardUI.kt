package com.example.sctirdactivites

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.sctirdactivites.ui.theme.Orange



@Composable
fun UiDashboard(navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        DashboardCircle()
        ProcessCircle(navHostController = navHostController)
    }
}
@Composable
fun ProcessCircle(navHostController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        CircularProgressbar3()
        Spacer(modifier = Modifier.height(0.dp))
        DashboardView(navHostController = navHostController)
        Spacer(modifier = Modifier.height(12.dp))
        //RegistrationButton(onClick = {})
    }
}
@Composable
fun DashboardView(navHostController: NavHostController) {
    val dashItems = listOf(
        CardItem("Send Your Report", R.drawable.sendreport),
        CardItem("See Report & Download", R.drawable.seereport),
        CardItem("Complete User Profile", R.drawable.id),
        CardItem("Complete Document KYC", R.drawable.kyc),
        CardItem("Register New Participant", R.drawable.adduser),
        CardItem("Participants Details", R.drawable.userlist)
    )

    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(dashItems.size) { index ->
            val cardItem = dashItems[index]
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    //.shadow(6.dp)
                    .clickable {onItemClick(cardItem,navHostController)},
                shape = RoundedCornerShape(40.dp),
                colors = CardDefaults.cardColors(Color(0xFFFAF1D5)),
                elevation  = CardDefaults.cardElevation(8.dp),
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val image = painterResource(id = cardItem.imageResId)
                    Image(
                        painter = image,
                        contentDescription = cardItem.name,
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = cardItem.name,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        ),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

fun onItemClick(cardItem: CardItem,navHostController: NavHostController) {
    when (cardItem.name) {
        "Send Your Report" -> navHostController.navigate(ScreenNav.SendDailyReport.route)
        "Complete User Profile" -> navHostController.navigate(ScreenNav.BasicDetails.route)
        "Complete Document KYC" -> navHostController.navigate(ScreenNav.DocumentKYC.route)
        "Register New Participant" -> navHostController.navigate(ScreenNav.RegisterParticipant.route)
        else -> {
            // Handle other cases if needed
        }
    }
}


@Composable
fun DashboardCircle() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),

        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.uibackground),
            contentDescription = "Orange Circle UI",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth(),
            //            .offset(y = (-115).dp)
        )
    }
}




@Composable
fun CircularProgressbar3(
    number: Float = 70f,
    numberStyle: TextStyle = TextStyle(
        //fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 38.sp,
        color = Color.White
    ),
    size: Dp = 180.dp,
    indicatorThickness: Dp = 28.dp,

    foregroundIndicatorColor: Color = Color(0xFFFFFDDC),
    backgroundIndicatorColor: Color = Orange.copy(alpha = 0.7f)
) {

    // It remembers the number value
    var numberR by remember { mutableStateOf(0f) }
    // Number Animation
    val animationDuration = 1000 // Replace with your desired duration in milliseconds
    val animationDelay = 0 // Replace with your desired delay in milliseconds

    // Number Animation
    val animateNumber = animateFloatAsState(
        targetValue = numberR,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        )
    )

    // This is to start the animation when the activity is opened
    LaunchedEffect(Unit) {
        numberR = number
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size = size)
    ) {
        Canvas(
            modifier = Modifier
                .size(size = size),

        ) {
            // Background circle
            drawCircle(
                color = backgroundIndicatorColor,
                radius = (size.toPx() / 1.9).toFloat(),
                style = Stroke(width = indicatorThickness.toPx(), cap = StrokeCap.Round)
            )
            val sweepAngle = (animateNumber.value / 100) * 360
            // Foreground circle
            drawArc(
                color = foregroundIndicatorColor,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(indicatorThickness.toPx(), cap = StrokeCap.Round)
            )
        }
        // Text that shows number inside the circle
        Text(
            text = "${(animateNumber.value).toInt()}%",
            style = numberStyle,
        )
    }

    Spacer(modifier = Modifier.height(32.dp))

    ButtonProgressbar {
        numberR = (1..100).random().toFloat()
    }
}

@Composable
private fun ButtonProgressbar(
    backgroundColor: Color = Color(0xFFD259DF),
    onClickButton: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp, vertical = 30.dp),
        onClick = {
            onClickButton()
        },
        colors = ButtonDefaults.buttonColors(backgroundColor)
    ) {
        Text(
            text = "Coach:Name  Progress:Value",
            color = Color.White,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}




