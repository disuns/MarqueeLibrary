package com.disun.library.marqueelibrary

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView

class MarqueeXmlView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var text: String = "흐르는 텍스트"
    private var textSize: Float = 48f
    private var textColor: Int = Color.BLACK
    private var speed: Float = 2f
    private var textX = 0f

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.MarqueeXmlView, 0, 0).apply {
            try {
                text = getString(R.styleable.MarqueeXmlView_text) ?: text
                textSize = getDimension(R.styleable.MarqueeXmlView_textSize, textSize)
                textColor = getColor(R.styleable.MarqueeXmlView_textColor, textColor)
                speed = getFloat(R.styleable.MarqueeXmlView_speed, speed)
            } finally {
                recycle()
            }
        }
        paint.textSize = textSize
        paint.color = textColor
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText(text, textX, height / 2f, paint)
    }

    fun startFlowing() {
        val animator = ValueAnimator.ofFloat(width.toFloat(), -paint.measureText(text))
        animator.duration = (5000 / speed).toLong()
        animator.repeatCount = ValueAnimator.INFINITE
        animator.addUpdateListener {
            textX = it.animatedValue as Float
            invalidate()
        }
        animator.start()
    }
}