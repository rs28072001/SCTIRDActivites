package com.example.sctirdactivites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.sctirdactivites.ui.theme.SCTIRDActivitesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SCTIRDActivitesTheme {
                BoxWithConstraints(
                    contentAlignment= Alignment.TopCenter,
                    modifier = Modifier.fillMaxSize().background(color = Color(0xFFFFFFFF)))
                {
                    WelcomeActivity()
                }
            }
            }
        }
}

