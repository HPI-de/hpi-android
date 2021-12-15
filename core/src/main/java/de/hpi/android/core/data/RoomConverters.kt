package de.hpi.android.core.data

import androidx.room.TypeConverter
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneOffset
import java.net.URL

class RoomConverters {
    @TypeConverter
    fun urlToString(url: URL): String {
        return url.toString()
    }

    @TypeConverter
    fun stringToUrl(string: String): URL {
        return URL(string)
    }

    @TypeConverter
    fun localDateTimeToLong(localDateTime: LocalDateTime): Long {
        // TODO: add nano second support
        return localDateTime.toEpochSecond(ZoneOffset.UTC)
    }

    @TypeConverter
    fun longToLocalDateTime(time: Long): LocalDateTime {
        // TODO: add nano second support
        return LocalDateTime.ofEpochSecond(time, 0, ZoneOffset.UTC)
    }
}
