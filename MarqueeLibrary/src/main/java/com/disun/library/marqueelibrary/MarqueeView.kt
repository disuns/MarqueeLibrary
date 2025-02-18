package com.disun.library.marqueelibrary

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import androidx.core.animation.doOnEnd
import androidx.core.content.res.ResourcesCompat
import com.disun.library.marqueelibrary.databinding.MarqueeViewBinding
import kotlin.math.max

class MarqueeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr : Int= 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding: MarqueeViewBinding = MarqueeViewBinding.inflate(LayoutInflater.from(context), this, true)

    private var animator: ValueAnimator? = null
    var marqueeTextDuration: Long = 10L

    var marqueeRepeatCount: Int = 0
    var marqueeLeft: Boolean = true

    var marqueeText : String = ""
        set(value) {
            field = value
            binding.tvText.text = value
        }

    var marqueeTextSize: Float = binding.tvText.textSize
        set(value) {
            field = value
            binding.tvText.setTextSize(TypedValue.COMPLEX_UNIT_PX, value)
        }

    init {
        isClickable = false
        isFocusable = false
        attrs?.let {
            context.obtainStyledAttributes(it, R.styleable.MarqueeView).use { typedArray ->
                if(typedArray.hasValue(R.styleable.MarqueeView_backgroundColor)){
                    val backGroundColor = typedArray.getColor(R.styleable.MarqueeView_backgroundColor, 0)
                    binding.hsMarquee.setBackgroundColor(backGroundColor)
                }

                if(typedArray.hasValue(R.styleable.MarqueeView_marqueeHeight)){
                    val height = typedArray.getDimensionPixelSize(R.styleable.MarqueeView_marqueeHeight, binding.hsMarquee.height)

                    val layoutParams = binding.hsMarquee.layoutParams
                    layoutParams.height = height
                    binding.hsMarquee.layoutParams = layoutParams
                }

                if (typedArray.hasValue(R.styleable.MarqueeView_textColor)) {
                    val textColor = typedArray.getColor(R.styleable.MarqueeView_textColor, binding.tvText.currentTextColor)
                    binding.tvText.setTextColor(textColor)
                }

                if (typedArray.hasValue(R.styleable.MarqueeView_textSize)) {
                    val textSize = typedArray.getDimension(R.styleable.MarqueeView_textSize, binding.tvText.textSize)
                    binding.tvText.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize)
                    marqueeTextSize = textSize
                }
                val fontResId = typedArray.getResourceId(R.styleable.MarqueeView_marqueeFontStyle, 0)
                if(fontResId != 0){
                    try {
                        val typeface = ResourcesCompat.getFont(context, fontResId)
                        binding.tvText.typeface = typeface
                    } catch (e:Exception){
                        e.printStackTrace()
                    }
                }

                marqueeLeft = typedArray.getBoolean(R.styleable.MarqueeView_textDirLeft, true)

            }
        }
        binding.hsMarquee.setOnTouchListener{ _, _ -> true }
    }

    fun startMarqueeAnimation() {
        stopMarqueeAnimation()
        if(marqueeText.isEmpty()) return

        binding.tvText.postDelayed({
            binding.hsMarquee.visibility = View.VISIBLE
            val viewWidth = binding.tvText.width
            val containerWidth = binding.hsMarquee.width

            val initialTranslationX : Float
            val finalTranslationX : Float

            if(marqueeLeft){
                initialTranslationX = containerWidth.toFloat()+ (binding.tvText.width / 2).toFloat()
                finalTranslationX = -viewWidth.toFloat()
            } else {
                initialTranslationX = -viewWidth.toFloat()
                finalTranslationX = containerWidth.toFloat()+ (binding.tvText.width / 2).toFloat()
            }

            val ratio = if(containerWidth != 0 )viewWidth.toFloat() / containerWidth.toFloat() else 1f
            val scrollDurationMultiPlier = max(1f, ratio)
            val totalDuration = (scrollDurationMultiPlier * marqueeTextDuration * 1000).toLong()

            animator = ValueAnimator.ofFloat(initialTranslationX, finalTranslationX).apply {
                duration = totalDuration
                interpolator = LinearInterpolator()
                repeatCount = if(marqueeRepeatCount == 0) ValueAnimator.INFINITE else marqueeRepeatCount-1

                addUpdateListener { animation->
                    binding.tvText.translationX = animation.animatedValue as Float
                }

                doOnEnd {
                    stopMarqueeAnimation()
                }
                start()
            }
        },100)
    }
    fun startMarqueeAnimation(text: String, repeatCount: Int = 0, duration: Long = 10L) {
        marqueeText = text
        marqueeRepeatCount = repeatCount
        marqueeTextDuration = duration
        startMarqueeAnimation()
    }

    fun stopMarqueeAnimation() {
        animator?.let {
            if(it.isRunning){
                it.cancel()
            }
            binding.tvText.text = ""
            binding.hsMarquee.visibility = View.INVISIBLE
        }
        animator = null
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        stopMarqueeAnimation()
    }

    fun setMarqueeBackgroundColor(color: Int) {
        binding.hsMarquee.setBackgroundColor(color)
    }

    fun setMarqueeHeight(height: Int) {
        val layoutParams = binding.hsMarquee.layoutParams
        layoutParams.height = height
        binding.hsMarquee.layoutParams = layoutParams
    }

    fun setMarqueeTextColor(color: Int) {
        binding.tvText.setTextColor(color)
    }

    fun setMArqueeeTextSize(textSizePx: Float) {
        marqueeTextSize = textSizePx
    }
}