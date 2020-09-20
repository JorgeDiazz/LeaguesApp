package com.jorge_diaz.leagues.model.team

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("idTeam") val idTeam: Int,
    @SerializedName("strTeam") val strTeam: String,
    @SerializedName("intFormedYear") val intFormedYear: Int,
    @SerializedName("idLeague") val idLeague: Int,
    @SerializedName("strStadium") val strStadium: String,
    @SerializedName("strWebsite") val strWebsite: String,
    @SerializedName("strFacebook") val strFacebook: String,
    @SerializedName("strTwitter") val strTwitter: String,
    @SerializedName("strInstagram") val strInstagram: String,
    @SerializedName("strYoutube") val strYoutube: String,
    @SerializedName("strDescriptionEN") val strDescriptionEN: String,
    @SerializedName("strTeamBadge") val strTeamBadge: String,
    @SerializedName("strTeamJersey") val strTeamJersey: String

)