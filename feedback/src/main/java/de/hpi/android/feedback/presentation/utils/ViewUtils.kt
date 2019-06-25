package de.hpi.android.feedback.presentation.utils

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import java.io.File
import java.io.IOException

fun View.createScreenshot(): Bitmap {
    clearFocus()
    isPressed = false

    // https://stackoverflow.com/questions/2801116/converting-a-view-to-bitmap-without-displaying-it-in-android
    val bitmap =
        if (layoutParams == null || measuredHeight <= 0) {
            val specWidth = View.MeasureSpec.makeMeasureSpec(0 /* any */, View.MeasureSpec.UNSPECIFIED)
            measure(specWidth, specWidth)
            Bitmap.createBitmap(
                measuredWidth, measuredHeight,
                Bitmap.Config.ARGB_8888
            )
        } else {
            Bitmap.createBitmap(
                layoutParams.width, layoutParams.height,
                Bitmap.Config.ARGB_8888
            )
        }

    val canvas = Canvas(bitmap)
    layout(this.left, this.top, this.right, this.bottom)
    background?.draw(canvas)
    draw(canvas)
    return bitmap
}

/**
 * @throws IOException - in case of input/output error
 */
fun Bitmap.asTemporaryFile(): File {
    val file = createTempFile(suffix = ".png")
    this.compress(Bitmap.CompressFormat.PNG, 100, file.outputStream())
    // -> %userprofile%\Documents\AndroidStudio\DeviceExplorer\emulator-5554\data\user\0\de.hpi.android.debug\cache
    return file
}