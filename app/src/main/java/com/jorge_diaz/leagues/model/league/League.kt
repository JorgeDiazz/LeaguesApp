package com.jorge_diaz.leagues.model.league

import com.google.gson.annotations.SerializedName
import com.jorge_diaz.leagues.model.team.Team

data class League(
    @SerializedName("teams") val teams: List<Team>
)