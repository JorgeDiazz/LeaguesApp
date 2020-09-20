package com.jorge_diaz.leagues.viewmodel.league

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class LeagueViewModelFactory @Inject constructor(private val myViewModelProvider: Provider<LeagueViewModel>) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return myViewModelProvider.get() as T
    }
}