package com.mohsenmashkour.newnavwithargscomposeyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.mohsenmashkour.newnavwithargscomposeyt.ui.theme.NewNavWithArgsComposeYtTheme
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewNavWithArgsComposeYtTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = LangHomeRoute,
                        Modifier.padding(innerPadding)
                    ) {
                        composable<LangHomeRoute> {
                            LanguageListScreen(
                                onLangClick = { language, difficulty ->
                                    navController.navigate(
                                        LangDetailsRoute(
                                            language, difficulty
                                        )
                                    )
                                }
                            )
                        }
                        composable<LangDetailsRoute>(
                            typeMap = mapOf(
                                typeOf<Languages>() to CustomNavType.LanguageType,
                                typeOf<Difficulty>() to NavType.EnumType(Difficulty::class.java)
                            )
                        ) {
                            val arguments = it.toRoute<LangDetailsRoute>()
                            LangDetailScreen(
                                languages = arguments.language,
                                difficulty = arguments.difficulty
                            )

                        }
                    }
                }
            }
        }
    }
}

@Serializable
data object LangHomeRoute

@Serializable
data class LangDetailsRoute(
    val language: Languages,
    val difficulty: Difficulty
)




