package de.hpi.android.core.presentation.utils

import android.content.Context
import android.text.format.DateUtils
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId

fun Context.formatDateTimeRelative(dateTime: LocalDateTime): CharSequence {
    val seconds = dateTime.atZone(ZoneId.systemDefault()).toEpochSecond()
    return DateUtils.getRelativeDateTimeString(this, seconds, 0, DateUtils.WEEK_IN_MILLIS, 0)
}
