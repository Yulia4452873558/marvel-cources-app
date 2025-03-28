package com.example.marvel.mock

import android.annotation.SuppressLint
import androidx.compose.ui.graphics.Color
import com.example.marvel.domain.model.Hero

@SuppressLint("SuspiciousIndentation")
fun getMockHeroes(): List<Hero> {
  val list: List<Hero> = listOf(
      Hero(
          heroNameResId = "R.string.deadpool_name",
          heroDescriptionResId = "R.string.deadpool_quote",
          heroColor = Color(0xFF740308),
          heroImageResId ="https://iili.io/JMnAfIV.png"
      ),
      Hero(
          heroNameResId = "R.string.icon_man_name",
          heroDescriptionResId = "R.string.icon_man_quote",
          heroColor = Color(0xFFC18511),
          heroImageResId = "https://iili.io/JMnuDI2.png"
      ),
      Hero(
          heroNameResId = "R.string.spider_man_name",
          heroDescriptionResId = "R.string.spider_man_quote",
          heroColor = Color(0xFF0000FF),
          heroImageResId = "https://iili.io/JMnuyB9.png"
      )
  )
    return list
}
