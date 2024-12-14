package com.mohsenmashkour.newnavwithargscomposeyt

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LanguageListScreen(
    onLangClick: (Languages, Difficulty) -> Unit
){
    LazyColumn(
        Modifier.fillMaxSize()
    ) {
        items(languages_data.keys.toList()){language->
            Text(text = language.name,
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable {
                        onLangClick(language, languages_data[language]!!)
                    }, fontWeight = FontWeight.Bold, fontSize = 26.sp
            )
            HorizontalDivider(Modifier.fillMaxWidth().padding(horizontal = 16.dp))
        }
    }
}
val languages_data = mapOf(
    Languages(1, "Python", "Web Development, Data Science, Machine Learning") to Difficulty.EASY,
    Languages(2, "Java", "Enterprise Applications, Android Development") to Difficulty.MEDIUM,
    Languages(3, "Kotlin", "Android Development, Multiplatform Development") to Difficulty.MEDIUM,
    Languages(4, "JavaScript", "Web Development, Server-side with Node.js") to Difficulty.EASY,
    Languages(5, "C++", "Game Development, System Programming") to Difficulty.HARD,
    Languages(6, "Swift", "iOS Development, macOS Development") to Difficulty.MEDIUM,
    Languages(7, "Go", "Cloud Applications, Server-side Development") to Difficulty.MEDIUM,
    Languages(8, "Ruby", "Web Development, Scripting") to Difficulty.EASY,
    Languages(9, "C#", "Game Development (Unity), Windows Applications") to Difficulty.MEDIUM,
    Languages(10, "Rust", "System Programming, WebAssembly") to Difficulty.HARD

)