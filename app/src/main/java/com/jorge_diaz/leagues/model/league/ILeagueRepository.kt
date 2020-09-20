package com.jorge_diaz.leagues.model.league

import androidx.lifecycle.MutableLiveData
import com.jorge_diaz.leagues.model.team.Team

interface ILeagueRepository {

    fun getLeague(): MutableLiveData<League>

    fun callLeagueAPI(leagueName: String)

    fun getTeamClicked(): MutableLiveData<Team>

    fun callTeamClicked(teamClicked: Team)
}