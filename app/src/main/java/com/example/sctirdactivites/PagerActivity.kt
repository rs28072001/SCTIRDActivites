package com.example.sctirdactivites

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
@ExperimentalFoundationApi
fun PagerActivity(){
    val state = rememberPagerState(0,1.toFloat())
    VerticalPager(
        pageCount = 10,
        state = state,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        Box(
            modifier = Modifier
                .padding(10.dp)
                .background(Color.Blue)
                .fillMaxWidth()
                .aspectRatio(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(text = page.toString(), fontSize = 32.sp)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun PagerPreview(){
    Box() {
        PagerActivity()
    }
}