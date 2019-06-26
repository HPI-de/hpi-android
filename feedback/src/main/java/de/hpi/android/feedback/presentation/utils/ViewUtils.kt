package de.hpi.android.feedback.presentation.utils

import android.graphics.Bitmap
import android.os.Build
import android.os.Handler
import android.view.PixelCopy
import android.view.Window
import java.io.File
import java.io.IOException
import kotlin.coroutines.suspendCoroutine

suspend fun Window.createScreenshot(): Bitmap {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        suspendCoroutine { cont ->
            val bitmap = Bitmap.createBitmap(decorView.width, decorView.height, Bitmap.Config.ARGB_8888)
            PixelCopy.request(this, bitmap, { copyResult: Int ->
                cont.resumeWith(
                    if (copyResult == PixelCopy.SUCCESS)
                        Result.success(bitmap)
                    else Result.failure(Exception("Error taking screenshot, error code: $copyResult"))
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
 * @throws IOException - in case of input/output error
 */
fun Bitmap.asTemporaryFile(): File {
    val file = createTempFile(suffix = ".png")
    this.compress(Bitmap.CompressFormat.PNG, 100, file.outputStream())
    // -> %userprofile%\Documents\AndroidStudio\DeviceExplorer\emulator-5554\data\user\0\de.hpi.android.debug\cache
    return file
}