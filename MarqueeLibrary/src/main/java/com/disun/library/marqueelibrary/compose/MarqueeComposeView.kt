package com.disun.library.marqueelibrary.compose

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.motion.widget.Animatable

@SuppressLint("RememberReturnType")
@Composable
fun MarqueeComposeView(
    text: String,
    duration: Int = 5000,
    repeatCount: Int = Int.MAX_VALUE
) {
//    var textWidth by remember { mutableIntStateOf(0) }
//    var parentWidth by remember { mutableIntStateOf(0) }
//
//    val animatableX = remember { Animatable(0f) }
//
//    LaunchedEffect(text) {
//        repeat(repeatCount) {
//            animatableX.snapTo(parentWidth.toFloat())
//            animatableX.animateTo(-textWidth.toFloat(), animationSpec = tween(durationMillis = duration))
//            delay(100) // 반복 간 딜레이
//        }
//    }
//
//    Box(modifier = Modifier.layout { measurable, constraints ->
//        val placeable = measurable.measure(constraints)
//        textWidth = placeable.width
//        parentWidth = constraints.maxWidth
//        layout(constraints.maxWidth, placeable.height) {
//            placeable.placeRelative(0, 0)
//        }
//    }) {
//        BasicText(
//            text = text,
//            fontSize = 24.sp,
//            modifier = Modifier.offset { IntOffset(animatableX.value.roundToInt(), 0) }
//        )
//    }
}