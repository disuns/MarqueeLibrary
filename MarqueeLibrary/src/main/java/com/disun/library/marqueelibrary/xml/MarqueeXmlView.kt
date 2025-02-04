package com.disun.library.marqueelibrary.xml

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.TextView
import com.disun.library.marqueelibrary.R

class MarqueeXmlView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : HorizontalScrollView(context, attrs) {

    private var textView: TextView
    private var animator: ValueAnimator? = null

    var marqueeDuration: Int = 5000 // 기본 5초
    var repeatCount: Int = ValueAnimator.INFINITE

    init {
        inflate(context, R.layout.marquee_xml_view, this)
        textView = findViewById(R.id.custom_text)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.MarqueeXmlView)
            marqueeDuration = typedArray.getInt(R.styleable.MarqueeXmlView_duration, 5000)
            repeatCount = typedArray.getInt(R.styleable.MarqueeXmlView_repeatCount, ValueAnimator.INFINITE)
            typedArray.recycle()
        }
    }

    fun startMarquee(text: String) {
        textView.text = text
        visibility = View.VISIBLE

        val viewWidth = textView.width
        val containerWidth = width

        val initialX = containerWidth.toFloat()
        val finalX = -viewWidth.toFloat()

        animator?.cancel()
        animator = ValueAnimator.ofFloat(initialX, finalX).apply {
            duration = marqueeDuration.toLong()
            repeatCount = this@MarqueeXmlView.repeatCount
            addUpdateListener { textView.translationX = it.animatedValue as Float }
            start()
        }
    }

    fun stopMarquee() {
        animator?.cancel()
        textView.text = ""
        visibility = View.INVISIBLE
    }
}