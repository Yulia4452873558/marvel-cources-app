package com.example.marvel.presentation.screens.start

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.marvel.R
import com.example.marvel.domain.model.Hero
import com.example.marvel.mock.startScreenViewModel
import com.example.marvel.presentation.screens.start.components.Header
import com.example.marvel.presentation.screens.start.components.HeroSlider
import com.example.marvel.presentation.theme.MarvelTheme

@Composable
fun StartScreen(
    onHeroClick: (Hero) -> Unit = {},
    viewModel: StartViewModel
) {

    val state = viewModel.heroStateFlow.collectAsState().value

    val heroBackColor = remember {
        mutableStateOf(Color.White)
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Icon(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .align(Alignment.BottomEnd),
            tint = heroBackColor.value,
            painter = painterResource(id = R.drawable.hero_back),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(27.dp))
            Header()
            if (state.heroes?.isEmpty()!!) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else {
                Spacer(modifier = Modifier.height(20.dp))
                HeroSlider(
                    list = state.heroes,
                    onHeroClick = onHeroClick,
                    onScroll = { color ->
                        heroBackColor.value = color
                    }
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun StartScreenPreview() {
    MarvelTheme {
        Scaffold {
            StartScreen(
                viewModel = startScreenViewModel, onHeroClick = {}
            )
        }
    }
}
