package com.example.sctirdactivites

import DistrictCardsFlowchartSCF
import WomenFlowchartSCF
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sctirdactivites.ui.theme.Orange
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TitleBar(navHostController: NavHostController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("SCF-IRD ACTIVITIES",color = Color.Black, modifier = Modifier.padding(16.dp))
                //Icon(Icons.Default.AccountCircle, contentDescription = "User", tint = Orange,)
                Divider()
                NavigationDrawerItem(
                    icon = {Icon(Icons.Default.AccountBox, contentDescription = "AccountBox", tint = Color.Blue) },
                    label = {Text(text = "Login") },
                    selected = false,
                    onClick = { navHostController.navigate(ScreenNav.WelcomeActivity.route) }
                )
                NavigationDrawerItem(
                    icon = {Icon(Icons.Default.Notifications, contentDescription = "Notifications", tint = Color.Red) },
                    label = {Text(text = "Notifications") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                NavigationDrawerItem(
                    icon = {Icon(Icons.Default.Settings, contentDescription = "Settings", tint = Color.DarkGray) },
                    label = {Text(text = "Settings") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )

            }
        },
    ) {
        Scaffold(
            topBar = { TopAppBar(title = { Text("Subhash Chandra Foundation",color = Orange, fontWeight = FontWeight.Bold) },
                    navigationIcon = {IconButton(onClick = {
                        scope.launch { drawerState.apply { if (isClosed) open() else close() } }
                    }){Icon(Icons.Filled.Menu, contentDescription = "Localized description", tint = Orange)}}
            , colors = TopAppBarDefaults.smallTopAppBarColors(Color.White),
            modifier = Modifier
                .shadow(8.dp)
                .zIndex(1f))},
            containerColor = Color.White,

            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text("Login") },
                    icon = { Icon(Icons.Filled.Person, contentDescription = "") },
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
                )
            }
        ) {// contentPadding ->
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(Modifier.height(100.dp))
                MainImage(Modifier.height(199.dp))
                Spacer(Modifier.height(60.dp))
                ProjectsView(navHostController)
            }
        }
    }
}



@Composable
fun NavigationView(){
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = ScreenNav.TitleBar.route) {
        composable(ScreenNav.TitleBar.route){TitleBar(navHostController)}
        composable(ScreenNav.WelcomeActivity.route){WelcomeActivity(navHostController)}
        composable(ScreenNav.DistrictCardsFlowchartSCF.route){DistrictCardsFlowchartSCF()}
        composable(ScreenNav.WomenFlowchartSCF.route){WomenFlowchartSCF()}
        composable(ScreenNav.UiDashboard.route){UiDashboard(navHostController)}
        composable(ScreenNav.SendDailyReport.route){SendDailyReport()}
        composable(ScreenNav.BasicDetails.route){BasicDetails()}
        composable(ScreenNav.RegisterParticipant.route){RegisterParticipant()}
        composable(ScreenNav.DocumentKYC.route){DocumentKYC()}


    }
}

sealed class ScreenNav(val route: String) {
    object TitleBar : ScreenNav("First")
    object WelcomeActivity : ScreenNav("Second")
    object DistrictCardsFlowchartSCF : ScreenNav("Third")
    object WomenFlowchartSCF : ScreenNav("Forth")
    object UiDashboard : ScreenNav("Five")
    object SendDailyReport : ScreenNav("Six")
    object BasicDetails : ScreenNav("Seven")
    object RegisterParticipant : ScreenNav("Eight")
    object DocumentKYC : ScreenNav("Nine")
}


@Composable
fun ProjectsView(navHostController: NavController) {
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
                    .clickable {onItemClick(cardItem, navHostController)},
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


fun onItemClick(cardItem: CardItem, navHostController: NavController) {
    when (cardItem.name) {
        "Youth & Sports Development" -> navHostController.navigate(ScreenNav.DistrictCardsFlowchartSCF.route)
        "Women Empowerment" -> navHostController.navigate(ScreenNav.WomenFlowchartSCF.route)
        //"Send Your Report" -> navHostController.navigate(ScreenNav.SendDailyReport.route)
        //"" -> navHostController.navigate(ScreenNav.WomenFlowchartSCF.route)
        //"" -> navHostController.navigate(ScreenNav.WomenFlowchartSCF.route)
        //"" -> navHostController.navigate(ScreenNav.WomenFlowchartSCF.route)
        // "Agriculture Sector" -> navHostController.navigate(ScreenNav.DistrictCardsFlowchartSCF.route)
        //"Recent Activities" -> navHostController.navigate(ScreenNav.WomenFlowchartSCF.route)
        else -> {
            // Handle other cases if needed
        }
    }
}


data class CardItem(val name: String, val imageResId: Int)




