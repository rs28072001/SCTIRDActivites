package com.example.sctirdactivites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController


@Composable
fun ProjectsView(navController: NavController) {
    val cardItems = listOf(
        CardItem("Youth & Sports Development", R.drawable.sports),
        CardItem("Women Empowerment", R.drawable.women),
        CardItem("Agriculture Sector", R.drawable.planet_earth),
        CardItem("   Recent Activities ", R.drawable.activity)
    )

    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(cardItems.size) { index ->
            val cardItem = cardItems[index]
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    //.shadow(6.dp)
                    .clickable {onItemClick(navController, cardItem)},
                shape = RoundedCornerShape(40.dp),
                colors = CardDefaults.cardColors(Color(0xFFE7F9FF)),
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



fun onItemClick(navController: NavController, cardItem: CardItem) {
    when (cardItem.name) {
        "Youth & Sports Development" -> navController.navigate(ScreenNav.TitleBar.route)
        "Women Empowerment" -> navController.navigate(ScreenNav.WelcomeActivity.route)
        "Agriculture Sector" -> navController.navigate(ScreenNav.DistrictCardsFlowchartSCF.route)
        "Recent Activities" -> navController.navigate(ScreenNav.WomenFlowchartSCF.route)
        else -> {
            // Handle other cases if needed
        }
    }
}

data class CardItem(val name: String, val imageResId: Int)







