package com.raulespim.lent.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.raulespim.lent.utils.LentType

data class Lent(
    val lentType: LentType,
)

data class LentDay(
    val day: Int,
    @StringRes val title: Int,
    @DrawableRes val image: Int,
    @StringRes val description: Int
)
