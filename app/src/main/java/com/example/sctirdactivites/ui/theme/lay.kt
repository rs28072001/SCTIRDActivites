package com.example.sctirdactivites.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun Bootcamp () {
    RowLayout()
}

@Preview
@Composable
fun RowLayout(){
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment =Alignment.Bottom
    ) {
        Text(text = "One Item.")
        Text(text = "Two Item.")
        Text(text = "Three Item.")

    }
}
