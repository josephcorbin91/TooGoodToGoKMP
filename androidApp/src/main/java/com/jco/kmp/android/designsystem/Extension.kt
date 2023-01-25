package com.jco.tgtg.core.designsystem

import android.content.Context
import android.widget.Toast
import androidx.compose.ui.graphics.Color

fun generateRandomColor(): Color  {
    val lowerColorBound = 0
    val upperColorBound = 256
    val randomRed = (lowerColorBound..upperColorBound).random()
    val randomBlue = (lowerColorBound..upperColorBound).random()
    val randomGreen = (lowerColorBound..upperColorBound).random()
    return Color(randomRed, randomGreen, randomBlue)
}

fun Context.showToast(text: String) = Toast.makeText(this, text, Toast.LENGTH_LONG).show()