package com.jorge_diaz.leagues.view.league

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jorge_diaz.leagues.R
import com.jorge_diaz.leagues.databinding.FragmentLeagueBinding
import com.jorge_diaz.leagues.di.LeaguesApplication
import com.jorge_diaz.leagues.model.league.League
import com.jorge_diaz.leagues.model.team.Team
import com.jorge_diaz.leagues.viewmodel.league.LeagueViewModel
import javax.inject.Inject
import javax.inject.Named

class LeagueFragment(private val leagueName: String, private val listener: (Team) -> Unit) :
    Fragment() {

    @field:[Inject Named("leagueViewModelFactory")]
    lateinit var leagueViewModelFactory: ViewModelProvider.Factory

    private lateinit var leagueViewModel: LeagueViewModel
    private lateinit var binding: FragmentLeagueBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_league, container, false
        )

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpInjection()
        setUpBindings()
        setUpView()
    }

    private fun setUpInjection() {
        (activity!!.applicationContext as LeaguesApplication).component.inject(this)
    }

    private fun setUpBindings() {
        setUpLeagueViewModel()
    }

    private fun setUpLeagueViewModel() {
        leagueViewModel =
            ViewModelProvider(this, leagueViewModelFactory).get(LeagueViewModel::class.java)

        binding.leagueModel = leagueViewModel
    }

    private fun setUpView() {
        setUpTeamsListUpdate(leagueName)
        setUpTeamClickListener()
    }

    private fun setUpTeamsListUpdate(leagueName: String) {
        leagueViewModel.callLeague(leagueName)
        leagueViewModel.getLeague().observe(viewLifecycleOwner, Observer { league: League ->
            leagueViewModel.setTeamsInRecyclerAdapter(league.teams)
        })
    }

    private fun setUpTeamClickListener() {
        leagueViewModel.getTeam().observe(viewLifecycleOwner, Observer { team: Team ->
            listener(team)
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(leagueName: String, listener: (Team) -> Unit) =
            LeagueFragment(leagueName, listener)
    }
}
