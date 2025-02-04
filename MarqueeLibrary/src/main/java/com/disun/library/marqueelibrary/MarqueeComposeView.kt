package com.disun.library.marqueelibrary

import android.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat.animate
import java.lang.reflect.Modifier

@Composable
fun MarqueeComposeView(
    text: String,
    textSize: TextUnit = 16.sp,
    textColor: Int = Color.BLACK,
    speed: Float = 2f
) {
//    val density = LocalDensity.current
//    var textX by remember { mutableFloatStateOf(0f) }
//    val textMeasurer = rememberTextMeasurer()
//
//    LaunchedEffect(Unit) {
//        val textWidth = with(density) { textMeasurer.measure(AnnotatedString(text)).size.width.toFloat() }
//        while (true) {
//            textX = textWidth
//            animate(
//                initialValue = textWidth,
//                targetValue = -textWidth,
//                animationSpec = infiniteRepeatable(
//                    animation = tween((5000 / speed).toInt(), easing = LinearEasing)
//                )
//            ) { value, _ ->
//                textX = value
//            }
//        }
//    }
//
//    Canvas(modifier = Modifier.fillMaxWidth()) {
//        drawText(
//            textMeasurer = textMeasurer,
//            text = text,
//            topLeft = Offset(textX, size.height / 2),
//            style = TextStyle(fontSize = textSize, color = textColor)
//        )
//    }
}