package de.hpi.android.core.presentation.utils

import android.content.Context
import android.text.format.DateUtils
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId

private const val SECOND_TO_MILLIS = 1000

fun Context.formatDateTimeRelative(dateTime: LocalDateTime): CharSequence {
    val millis = dateTime.atZone(ZoneId.systemDefault()).toEpochSecond() * SECOND_TO_MILLIS
    return DateUtils.getRelativeDateTimeString(this, millis, 0, DateUtils.WEEK_IN_MILLIS, 0)
}
