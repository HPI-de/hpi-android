package de.hpi.android.feedback.data

import de.hpi.android.core.data.Dto
import de.hpi.android.core.data.Id
import org.threeten.bp.ZonedDateTime
import java.io.File
import java.net.URI

data class FeedbackDto(
    val message: String,
    val meta: Metadata
) : Dto<FeedbackDto> {

    override val id: Id<FeedbackDto> = "" // empty, server creates the id

    data class Metadata(
        val screenUri: URI,
        val author: String, // TODO: replace with User reference
        val screenshot: File? = null,
        val log: String? = null
    ) {
        val timestamp: ZonedDateTime = ZonedDateTime.now()
    }
}