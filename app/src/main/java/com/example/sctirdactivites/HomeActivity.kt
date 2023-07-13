package com.example.sctirdactivites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun HomeActivity() {
    Scaffold(
        topBar={ HomeActivityTopAppBar()},
        content={ innerPadding ->Box(
                Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )
        }
    )
}


@Composable
fun HomeActivityTopAppBar(){
}

@Composable
fun HomeActivityContent(){
}