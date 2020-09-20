package com.jorge_diaz.leagues.model.event

import androidx.lifecycle.MutableLiveData

interface IEventRepository {

    fun callEventsAPI(idTeam: Int)

    fun getEvents(): MutableLiveData<List<Event>>
}