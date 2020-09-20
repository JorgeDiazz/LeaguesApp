package com.jorge_diaz.leagues.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.jorge_diaz.leagues.model.league.ILeagueObservable
import com.jorge_diaz.leagues.model.league.ILeagueRepository
import com.jorge_diaz.leagues.model.league.LeagueObservable
import com.jorge_diaz.leagues.model.league.LeagueRepositoryImpl
import com.jorge_diaz.leagues.model.event.IEventObservable
import com.jorge_diaz.leagues.model.event.IEventRepository
import com.jorge_diaz.leagues.model.event.EventObservable
import com.jorge_diaz.leagues.model.event.EventRepositoryImpl
import com.jorge_diaz.leagues.rest.Endpoints
import com.jorge_diaz.leagues.rest.ServiceBuilder
import com.jorge_diaz.leagues.viewmodel.league.LeagueViewModelFactory
import com.jorge_diaz.leagues.viewmodel.event.EventViewModelFactory
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
    @Named("leagueViewModelFactory")
    fun provideLeagueViewModelFactory(leagueViewModelFactory: LeagueViewModelFactory): ViewModelProvider.Factory =
        leagueViewModelFactory

    @Provides
    @Named("eventViewModelFactory")
    fun provideEventViewModelFactory(eventViewModelFactory: EventViewModelFactory): ViewModelProvider.Factory =
        eventViewModelFactory


    @Provides
    @Singleton
    fun provideEndpoints(): Endpoints = ServiceBuilder.buildService(Endpoints::class.java)

    @Provides
    fun provideILeagueRepository(context: Context, endpoints: Endpoints): ILeagueRepository =
        LeagueRepositoryImpl(
            context,
            endpoints
        )

    @Provides
    fun provideILeagueObservable(leagueRepository: ILeagueRepository): ILeagueObservable =
        LeagueObservable(leagueRepository)


    @Provides
    fun provideIEventRepository(context: Context, endpoints: Endpoints): IEventRepository =
        EventRepositoryImpl(
            context,
            endpoints
        )

    @Provides
    fun provideIEventObservable(eventRepository: IEventRepository): IEventObservable =
        EventObservable(eventRepository)

}