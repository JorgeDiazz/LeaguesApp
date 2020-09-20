package com.jorge_diaz.leagues.model.event

import com.google.gson.annotations.SerializedName

data class EventList(
    @SerializedName("events") val events: List<Event>
)