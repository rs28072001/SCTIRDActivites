package com.example.sctirdactivites

import DistrictCardsFlowchartSCF
import WomenFlowchartSCF
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.sctirdactivites.ui.theme.Bootcamp
import com.example.sctirdactivites.ui.theme.SCTIRDActivitesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SCTIRDActivitesTheme(darkTheme = false) {
                BoxWithConstraints(
                    contentAlignment= Alignment.TopCenter,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color(0xFFFFFFFF)))
                {
                    UiDashboard()
                    //HomeActivity()
                    //DrawerContent()
                }

            }
            }
        }
}

