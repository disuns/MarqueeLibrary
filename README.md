
## MarqueeLibrary
---
[![](https://jitpack.io/v/disuns/MarqueeLibrary.svg)](https://jitpack.io/#disuns/MarqueeLibrary)

A customizable Android library providing marquee functionality.

## ## Installation
---
### 1. Add JitPack Repository

Add the following to your project's `settings.gradle.kts` (root directory)
```kotlin
maven { url = uri("https://jitpack.io") }
```

### 2. Add Library Dependency

Add the following to `build.gradle.kts` (app module)
```kotlin
implementation("com.github.disun:MarqueeLibrary:1.0.3")
```

### 3. Usage

#### Using in XML

You can add `com.disun.library.marqueelibrary.MarqueeView` in XML and configure its attributes
```kotlin
<com.disun.library.marqueelibrary.MarqueeView
    android:id="@+id/marqueeView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:marqueeHeight="100dp"
    app:textColor="#0000ff"
    app:backgroundColor="#ff0000"
    app:textSize="50sp"
    app:textDirLeft="false"
    app:marqueeFontStyle="" />
```

- **marqueeHeight**: Height of the marquee view
- **textColor**: Color of the displayed text
- **backgroundColor**: Background color of the marquee view
- **textSize**: Size of the displayed text
- **textDirLeft**: Text scrolling direction (default = `true`, moves from right to left)
- **marqueeFontStyle**: Font style settings
#### Using in Code
```kotlin
val marqueeView: MarqueeView = findViewById(R.id.marqueeView)

marqueeView.marqueeText = "This is a marquee text."
marqueeView.marqueeTextDuration = 5L
marqueeView.marqueeRepeatCount = 1

marqueeView.startMarqueeAnimation()
```

- **marqueeText**: The text to be displayed
- **marqueeTextDuration**: Speed (higher value means slower speed)
- **marqueeRepeatCount**: Number of times the animation repeats (`0` means infinite loop)
