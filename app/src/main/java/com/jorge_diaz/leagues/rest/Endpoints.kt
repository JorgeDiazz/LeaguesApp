package com.jorge_diaz.leagues.rest

import com.jorge_diaz.leagues.model.league.League
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Endpoints {

    @GET("api/v1/json/{apiKey}/search_all_teams.php")
    fun getLeague(@Path("apiKey") apiKey: Int, @Query("l") leagueName: String): Call<League>
}