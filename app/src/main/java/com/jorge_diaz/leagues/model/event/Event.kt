package com.jorge_diaz.leagues.model.event

import com.google.gson.annotations.SerializedName
import com.jorge_diaz.leagues.utils.TimeUtils

data class Event(
    @SerializedName("idEvent") val idEvent: Int,
    @SerializedName("strEvent") val strEvent: String,
    @SerializedName("strLeague") val strLeague: String,
    @SerializedName("strTimestamp") val strTimestamp: String
) {
    companion object {
        fun sortEventsByDate(events: List<Event>): List<Event> {
            return events.sortedBy { TimeUtils.parseToUnixTimestamp(it.strTimestamp) }
        }
    }
}

