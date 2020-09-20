package com.jorge_diaz.leagues.utils

import java.text.SimpleDateFormat
import java.util.*

class TimeUtils {

    companion object {
        const val TWO_SECONDS_IN_MILLIS = 2_000
        private const val STR_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
        private const val DATE_FORMAT = "dd-MM-yyyy HH:mm"

        fun getDateFormatted(strTimestamp: String): String {
            val parser = SimpleDateFormat(STR_DATE_FORMAT, Locale.getDefault())
            val formatter = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
            return formatter.format(parser.parse(strTimestamp))
        }

        fun parseToUnixTimestamp(strDate: String?): Long {
            return if (strDate.isNullOrEmpty() || strDate.indexOf(" ") > 0) {
                0
            } else {
                SimpleDateFormat(STR_DATE_FORMAT, Locale.getDefault()).parse(strDate).time
            }
        }
    }
}