package com.jorge_diaz.leagues

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jorge_diaz.leagues.UIutils.FragmentUtils.Companion.addFragment
import com.jorge_diaz.leagues.UIutils.FragmentUtils.Companion.replaceFragment
import com.jorge_diaz.leagues.di.LeaguesApplication
import com.jorge_diaz.leagues.model.team.Team
import com.jorge_diaz.leagues.view.league.LeagueFragment
import com.jorge_diaz.leagues.view.team.TeamFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_league.*


class MainActivity : AppCompatActivity() {

    private var existActiveFragment: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpInjection()
        setUpView()
    }

    private fun setUpInjection() {
        (applicationContext as LeaguesApplication).component.inject(this)
    }

    private fun setUpView() {
        setUpBottomNavigationView()
        setUpLeagueFragment(Team.AvailableTeams.LALIGA.strName)
    }

    private fun setUpBottomNavigationView() {
        bnv_main_activity.itemIconTintList = null

        bnv_main_activity.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.btn_laliga -> {
                    setUpLeagueFragment(Team.AvailableTeams.LALIGA.strName)
                    true
                }
                R.id.btn_premier_league -> {
                    setUpLeagueFragment(Team.AvailableTeams.PREMIER_LEAGUE.strName)
                    true
                }
                R.id.btn_bundesliga -> {
                    setUpLeagueFragment(Team.AvailableTeams.BUNDESLIGA.strName)
                    true
                }
                else -> false
            }
        }
    }

    private fun setUpLeagueFragment(leagueName: String) {
        val leagueFragment = LeagueFragment.newInstance(leagueName) { team: Team ->
            setUpTeamDetailFragment(team)
        }

        replaceFragment(leagueFragment, R.id.fragment_container)
    }

    private fun setUpTeamDetailFragment(team: Team) {
        setUpTeamDetailFragmentVisibilities()

        val teamFragment = TeamFragment.newInstance(team)
        addFragment(teamFragment, R.id.fragment_container)
        existActiveFragment = true
    }

    private fun setUpTeamDetailFragmentVisibilities() {
        bnv_main_activity.visibility = View.INVISIBLE
        main_toolbar.visibility = View.GONE
    }

    override fun onBackPressed() {
        if (existActiveFragment) {
            setUpMainActivityVisibilities()
            existActiveFragment = false
        } else {
            super.onBackPressed()
        }
    }

    private fun setUpMainActivityVisibilities() {
        main_toolbar.visibility = View.VISIBLE
        bnv_main_activity.visibility = View.VISIBLE
    }
}