package com.disun.marqueelibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.disun.library.marqueelibrary.MarqueeView
import com.disun.marqueelibrary.ui.theme.MarqueeLibraryTheme

class MainActivity : ComponentActivity() {

    private lateinit var marqueeView: MarqueeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        marqueeView = findViewById(R.id.marqueeView)

        marqueeView.marqueeText = "This is a marquee text."
        marqueeView.marqueeTextDuration = 5L
        marqueeView.marqueeRepeatCount = 1

        marqueeView.startMarqueeAnimation()
//        enableEdgeToEdge()
//        setContent {
//            MarqueeLibraryTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
    }

    override fun onDestroy() {
        marqueeView.stopMarqueeAnimation()
        super.onDestroy()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MarqueeLibraryTheme {
        Greeting("Android")
    }
}