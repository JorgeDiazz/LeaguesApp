package com.jorge_diaz.leagues.viewmodel.league

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jorge_diaz.leagues.R
import com.jorge_diaz.leagues.model.league.ILeagueObservable
import com.jorge_diaz.leagues.model.league.League
import com.jorge_diaz.leagues.model.team.Team
import com.jorge_diaz.leagues.view.league.RecyclerTeamsAdapter
import com.squareup.picasso.Picasso
import javax.inject.Inject

open class LeagueViewModel @Inject constructor(private val leagueObservable: ILeagueObservable) :
    ViewModel() {

    private var recyclerTeamsAdapter: RecyclerTeamsAdapter? = null

    fun callLeague(leagueName: String) {
        leagueObservable.callLeague(leagueName)
    }

    fun getLeague(): MutableLiveData<League> {
        return leagueObservable.getLeague()
    }

    fun setTeamsInRecyclerAdapter(teams: List<Team>) {
        recyclerTeamsAdapter!!.submitList(teams)
    }

    fun getRecyclerTeamsAdapter(): RecyclerTeamsAdapter? {
        recyclerTeamsAdapter =
            RecyclerTeamsAdapter(
                this,
                R.layout.rv_item_team
            )
        return recyclerTeamsAdapter
    }

    fun getTeam(): MutableLiveData<Team> {
        return leagueObservable.getTeam()
    }

    fun getTeamAt(position: Int): Team? {
        val teams: List<Team>? = recyclerTeamsAdapter?.teams
        return teams?.get(position)
    }

    fun onTeamClick(position: Int) {
        val teamClicked: Team = recyclerTeamsAdapter?.teams!![position]
        leagueObservable.callTeam(teamClicked)
    }


    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, imageUrl: String?) {
            imageUrl?.let {
                if (it.isNotEmpty())
                    Picasso.get().load(it).into(imageView)
            }
        }

    }

}