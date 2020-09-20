package com.jorge_diaz.leagues.di

import com.jorge_diaz.leagues.MainActivity
import com.jorge_diaz.leagues.view.league.LeagueFragment
import com.jorge_diaz.leagues.view.team.TeamFragment
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(leagueFragment: LeagueFragment)
    fun inject(teamFragment: TeamFragment)
}