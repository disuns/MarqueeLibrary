package com.disun.library.marqueelibrary

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable

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