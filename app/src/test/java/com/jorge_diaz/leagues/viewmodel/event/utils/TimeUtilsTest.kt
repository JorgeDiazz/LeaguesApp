package com.jorge_diaz.leagues.viewmodel.event.utils

import com.jorge_diaz.leagues.utils.TimeUtils
import org.junit.Test

class TimeUtilsTest {
    @Test
    fun getDateFormatted_isCorrect() {
        val strTimestamp1 = "2020-10-18T00:00:00+00:00"
        val correctDateFormatted1 = "18-10-2020 00:00"

        assert(correctDateFormatted1 == TimeUtils.getDateFormatted(strTimestamp1))

        val strTimestamp2 = "2020-09-26T11:00:00+00:00"
        val correctDateFormatted2 = "26-09-2020 11:00"

        assert(correctDateFormatted2 == TimeUtils.getDateFormatted(strTimestamp2))

        val strTimestamp3 = "2020-09-26T16:30:00+00:00"
        val correctDateFormatted3 = "26-09-2020 16:30"

        assert(correctDateFormatted3 == TimeUtils.getDateFormatted(strTimestamp3))
    }

    @Test
    fun parseToUnixTimestamp_isCorrect() {
        val strTimestamp1 = "2020-10-18T00:00:00+00:00"
        val correctUnixTimestamp1: Long = 1602997200000

        assert(correctUnixTimestamp1 == TimeUtils.parseToUnixTimestamp(strTimestamp1))

        val strTimestamp2 = "2020-09-26T11:00:00+00:00"
        val correctUnixTimestamp2: Long = 1601136000000

        assert(correctUnixTimestamp2 == TimeUtils.parseToUnixTimestamp(strTimestamp2))

        val strTimestamp3 = "2020-09-26T16:30:00+00:00"
        val correctUnixTimestamp3: Long = 1601155800000

        assert(correctUnixTimestamp3 == TimeUtils.parseToUnixTimestamp(strTimestamp3))
    }

}