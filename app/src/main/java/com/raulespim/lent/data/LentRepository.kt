package com.raulespim.lent.data

import com.raulespim.lent.R
import com.raulespim.lent.model.LentDay

object LentRepository {

    val saintMichaelArchangelLentDayList = (1..40).mapIndexed { index, day ->
        LentDay(
            day = day,
            title = R.string.lent_day_title,
            image = when (day) {
                1 -> R.drawable.saint_michael_archangel_day1
                2 -> R.drawable.saint_michael_archangel_day2
                3 -> R.drawable.saint_michael_archangel_day3
                else -> R.drawable.saint_michael_archangel_day2
            },
            description = when (day) {
                1 -> R.string.description_day1_saint_michael_archangel
                2 -> R.string.description_day2_saint_michael_archangel
                3  -> R.string.description_day3_saint_michael_archangel
                4  -> R.string.description_day4_saint_michael_archangel
                5  -> R.string.description_day5_saint_michael_archangel
                6  -> R.string.description_day6_saint_michael_archangel
                7  -> R.string.description_day7_saint_michael_archangel
                8  -> R.string.description_day8_saint_michael_archangel
                9  -> R.string.description_day9_saint_michael_archangel
                10 -> R.string.description_day10_saint_michael_archangel
                11 -> R.string.description_day11_saint_michael_archangel
                12 -> R.string.description_day12_saint_michael_archangel
                13 -> R.string.description_day13_saint_michael_archangel
                14 -> R.string.description_day14_saint_michael_archangel
                15 -> R.string.description_day15_saint_michael_archangel
                16 -> R.string.description_day16_saint_michael_archangel
                17 -> R.string.description_day17_saint_michael_archangel
                18 -> R.string.description_day18_saint_michael_archangel
                19 -> R.string.description_day19_saint_michael_archangel
                20 -> R.string.description_day20_saint_michael_archangel
                21 -> R.string.description_day21_saint_michael_archangel
                22 -> R.string.description_day22_saint_michael_archangel
                23 -> R.string.description_day23_saint_michael_archangel
                24 -> R.string.description_day24_saint_michael_archangel
                25 -> R.string.description_day25_saint_michael_archangel
                26 -> R.string.description_day26_saint_michael_archangel
                27 -> R.string.description_day27_saint_michael_archangel
                28 -> R.string.description_day28_saint_michael_archangel
                29 -> R.string.description_day29_saint_michael_archangel
                30 -> R.string.description_day30_saint_michael_archangel
                31 -> R.string.description_day31_saint_michael_archangel
                32 -> R.string.description_day32_saint_michael_archangel
                33 -> R.string.description_day33_saint_michael_archangel
                34 -> R.string.description_day34_saint_michael_archangel
                35 -> R.string.description_day35_saint_michael_archangel
                36 -> R.string.description_day36_saint_michael_archangel
                37 -> R.string.description_day37_saint_michael_archangel
                38 -> R.string.description_day38_saint_michael_archangel
                39 -> R.string.description_day39_saint_michael_archangel
                40 -> R.string.description_day40_saint_michael_archangel
                else -> R.string.description_day2_saint_michael_archangel
            }
        )
    }
}