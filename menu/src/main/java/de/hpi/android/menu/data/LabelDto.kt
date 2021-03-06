package de.hpi.android.menu.data

import de.hpi.android.core.data.Dto
import de.hpi.android.core.data.Id

data class LabelDto(
    override val id: Id<LabelDto>,
    val title: String
): Dto<LabelDto>
