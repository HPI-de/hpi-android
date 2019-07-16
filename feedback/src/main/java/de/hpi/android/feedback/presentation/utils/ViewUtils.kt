package de.hpi.android.feedback.presentation.utils

import android.graphics.Bitmap
import android.os.Build
import android.os.Handler
import android.view.PixelCopy
import android.view.Window
import java.io.File
import java.io.IOException
import kotlin.coroutines.suspendCoroutine

/**
 * @throws IOException - in case of failure to take screenshot
 */
@Suppress("DEPRECATION")
suspend fun Window.createScreenshot(): Bitmap {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        suspendCoroutine { cont ->
            val bitmap = Bitmap.createBitmap(decorView.width, decorView.height, Bitmap.Config.ARGB_8888)
            PixelCopy.request(this, bitmap, { copyResult: Int ->
                cont.resumeWith(
                    if (copyResult == PixelCopy.SUCCESS)
                        Result.success(bitmap)
                    else
                        Result.failure(IOException("Failed to take screenshot, result code: $copyResult"))
                )
            }, Handler())
        }
    } else {
        val view = decorView.rootView
        view.isDrawingCacheEnabled = true
        val bitmap = Bitmap.createBitmap(view.drawingCache)
        view.isDrawingCacheEnabled = false
        bitmap
    }
}

/**
 * @throws IOException - in case of file writing error
 */
fun Bitmap.asTempFile(filenamePrefix: String): File {
    val file = createTempFile(prefix = filenamePrefix, suffix = ".png")
    compress(Bitmap.CompressFormat.PNG, 100, file.outputStream())
    return file
}

private const val LOG_LINES_MAX = 2000
private const val LOG_READ_CMD = "logcat -b main,system,crash,events -t $LOG_LINES_MAX -v threadtime printable"

/**
 * @throws IOException - in case of log reading error
 */
internal fun saveCurrentLog(filenamePrefix: String): File {
    val file = createTempFile(prefix = filenamePrefix, suffix = ".log")
    Runtime.getRuntime().exec(LOG_READ_CMD)
        .inputStream
        .bufferedReader()
        .use { input ->
            file
                .bufferedWriter()
                .use { output ->
                    input.copyTo(output)
                }
        }
    return file
}
