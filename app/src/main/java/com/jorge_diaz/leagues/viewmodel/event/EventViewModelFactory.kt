package com.jorge_diaz.leagues.viewmodel.event

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class EventViewModelFactory @Inject constructor(private val myViewModelProvider: Provider<EventViewModel>) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return myViewModelProvider.get() as T
    }
}