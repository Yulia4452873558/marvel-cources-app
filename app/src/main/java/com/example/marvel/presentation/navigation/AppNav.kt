package com.example.marvel.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.marvel.domain.model.Hero

@Composable
fun AppNavigation() {
    val selectedHero = remember {
        mutableStateOf(Hero("", "", "", Color.White))
    }
    val navController = rememberNavController()
    NavGraph(navController, selectedHero = selectedHero)
}
