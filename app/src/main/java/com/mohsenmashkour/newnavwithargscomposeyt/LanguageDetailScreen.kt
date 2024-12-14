package com.mohsenmashkour.newnavwithargscomposeyt

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LangDetailScreen(
    languages: Languages,
    difficulty: Difficulty
){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = languages.name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(text = languages.usage, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(text = languages.id.toString(), fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(text = difficulty.toString(), fontWeight = FontWeight.Bold, fontSize = 20.sp)
    }
}