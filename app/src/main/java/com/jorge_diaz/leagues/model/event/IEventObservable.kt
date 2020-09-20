package com.jorge_diaz.leagues.model.event

import androidx.lifecycle.MutableLiveData

interface IEventObservable {

    fun callEvents(idTeam: Int)

    fun getEvents(): MutableLiveData<List<Event>>
}