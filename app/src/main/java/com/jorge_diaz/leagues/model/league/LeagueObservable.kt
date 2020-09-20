package com.jorge_diaz.leagues.model.league

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.jorge_diaz.leagues.model.team.Team
import javax.inject.Inject

class LeagueObservable @Inject constructor(private var leagueRepository: ILeagueRepository) :
    BaseObservable(), ILeagueObservable {
    // Repository connection
    override fun callLeague(leagueName: String) {
        leagueRepository.callLeagueAPI(leagueName)
    }

    override fun callTeam(team: Team) {
        leagueRepository.callTeamClicked(team)
    }

    // ViewModel connection
    override fun getLeague(): MutableLiveData<League> {
        return leagueRepository.getLeague()
    }

    override fun getTeam(): MutableLiveData<Team> {
        return leagueRepository.getTeamClicked()
    }


}