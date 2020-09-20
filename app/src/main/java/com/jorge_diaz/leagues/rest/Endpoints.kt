package com.jorge_diaz.leagues.rest

import com.jorge_diaz.leagues.model.event.EventList
import com.jorge_diaz.leagues.model.league.League
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Endpoints {

    @GET("api/v1/json/{apiKey}/search_all_teams.php")
    fun getLeague(@Path("apiKey") apiKey: String, @Query("l") leagueName: String): Call<League>

    @GET("api/v1/json/{apiKey}/eventsnext.php")
    fun getEvents(@Path("apiKey") apiKey: String, @Query("id") idTeam: Int): Call<EventList>

}