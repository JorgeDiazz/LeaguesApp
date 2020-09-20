package com.jorge_diaz.leagues.model.league

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.jorge_diaz.leagues.model.team.Team
import com.jorge_diaz.leagues.rest.Endpoints
import com.jorge_diaz.leagues.utils.RestUtils.Companion.API_KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LeagueRepositoryImpl @Inject constructor(
    val context: Context,
    private val endpoints: Endpoints
) : ILeagueRepository {

    private val league = MutableLiveData<League>()
    private val team = MutableLiveData<Team>()

    override fun getLeague(): MutableLiveData<League> {
        return league
    }

    override fun callLeagueAPI(leagueName: String) {
        val call = endpoints.getLeague(API_KEY, leagueName)
        call.enqueue(LeagueAPIResponse())
    }

    inner class LeagueAPIResponse : Callback<League> {
        override fun onResponse(call: Call<League>, response: Response<League>) {
            if (response.isSuccessful) {
                league.postValue(response.body()!!)
            } else {
                Toast.makeText(context, "League API response is unsuccessful!", Toast.LENGTH_LONG)
                    .show()
                league.postValue(League())
            }
        }

        override fun onFailure(call: Call<League>, throwable: Throwable) {
            Toast.makeText(context, "Error getting league data: $throwable", Toast.LENGTH_LONG).show()
            league.postValue(League())
        }

    }

    override fun getTeamClicked(): MutableLiveData<Team> {
        return team
    }

    override fun callTeamClicked(teamClicked: Team) {
        team.value = teamClicked
    }
}