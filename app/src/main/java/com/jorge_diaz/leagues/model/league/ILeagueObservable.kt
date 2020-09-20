package com.jorge_diaz.leagues.model.league

import androidx.lifecycle.MutableLiveData
import com.jorge_diaz.leagues.model.team.Team

interface ILeagueObservable {

    fun callLeague(leagueName: String)

    fun getLeague(): MutableLiveData<League>

    fun callTeam(team: Team)

    fun getTeam(): MutableLiveData<Team>
}