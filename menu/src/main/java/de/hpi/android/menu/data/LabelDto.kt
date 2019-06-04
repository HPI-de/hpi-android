package de.hpi.android.menu.data

import de.hpi.android.core.data.Dto

data class LabelDto(
    override val id: String,
    val title: String
): Dto<LabelDto>
