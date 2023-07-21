package com.example.sctirdactivites

import DistrictCardsFlowchartSCF
import WomenFlowchartSCF
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
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
                    icon = {Icon(Icons.Default.AccountBox, contentDescription = "AccountBox", tint = Color.Blue,) },
                    label = {Text(text = "Login") },
                    selected = false,
                    onClick = { navHostController.navigate(ScreenNav.WelcomeActivity.route) }
                )
                NavigationDrawerItem(
                    icon = {Icon(Icons.Default.Notifications, contentDescription = "Notifications", tint = Color.Red,) },
                    label = {Text(text = "Notifications") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                NavigationDrawerItem(
                    icon = {Icon(Icons.Default.Settings, contentDescription = "Settings", tint = Color.DarkGray,) },
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
                ProjectsView(navController: NavController)
            }
        }
    }
}



@Composable
fun NavigationView(){
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = ScreenNav.TitleBar.route) {
        composable(ScreenNav.TitleBar.route){TitleBar(navHostController)}
        composable(ScreenNav.WelcomeActivity.route){WelcomeActivity()}
        composable(ScreenNav.DistrictCardsFlowchartSCF.route){DistrictCardsFlowchartSCF()}
        composable(ScreenNav.WomenFlowchartSCF.route){WomenFlowchartSCF()}

    }
}

sealed class ScreenNav(val route: String) {
    object TitleBar : ScreenNav("First")
    object WelcomeActivity : ScreenNav("Second")
    object DistrictCardsFlowchartSCF : ScreenNav("Third")
    object WomenFlowchartSCF : ScreenNav("Forth")


}
