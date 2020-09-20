package com.jorge_diaz.leagues.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.jorge_diaz.leagues.model.league.ILeagueObservable
import com.jorge_diaz.leagues.model.league.ILeagueRepository
import com.jorge_diaz.leagues.model.league.LeagueObservable
import com.jorge_diaz.leagues.model.league.LeagueRepositoryImpl
import com.jorge_diaz.leagues.model.team.ITeamObservable
import com.jorge_diaz.leagues.model.team.ITeamRepository
import com.jorge_diaz.leagues.model.team.TeamObservable
import com.jorge_diaz.leagues.model.team.TeamRepositoryImpl
import com.jorge_diaz.leagues.rest.Endpoints
import com.jorge_diaz.leagues.rest.ServiceBuilder
import com.jorge_diaz.leagues.viewmodel.league.LeagueViewModelFactory
import com.jorge_diaz.leagues.viewmodel.team.TeamViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule(private var leaguesApplication: LeaguesApplication) {

    @Provides
    @Singleton
    fun provideApp(): LeaguesApplication = leaguesApplication

    @Provides
    @Singleton
    fun provideContext(): Context = leaguesApplication.applicationContext

    @Provides
    @Singleton
    @Named("leagueViewModelFactory")
    fun provideLeagueViewModelFactory(leagueViewModelFactory: LeagueViewModelFactory): ViewModelProvider.Factory =
        leagueViewModelFactory

    @Provides
    @Singleton
    @Named("teamViewModelFactory")
    fun provideTeamViewModelFactory(teamViewModelFactory: TeamViewModelFactory): ViewModelProvider.Factory =
        teamViewModelFactory


    @Provides
    @Singleton
    fun provideEndpoints(): Endpoints = ServiceBuilder.buildService(Endpoints::class.java)

    @Provides
    @Singleton
    fun provideILeagueRepository(context: Context, endpoints: Endpoints): ILeagueRepository =
        LeagueRepositoryImpl(
            context,
            endpoints
        )

    @Provides
    @Singleton
    fun provideILeagueObservable(leagueRepository: ILeagueRepository): ILeagueObservable =
        LeagueObservable(leagueRepository)


    @Provides
    @Singleton
    fun provideITeamRepository(context: Context, endpoints: Endpoints): ITeamRepository =
        TeamRepositoryImpl(
            context,
            endpoints
        )

    @Provides
    @Singleton
    fun provideITeamObservable(teamRepository: ITeamRepository): ITeamObservable =
        TeamObservable(teamRepository)

}