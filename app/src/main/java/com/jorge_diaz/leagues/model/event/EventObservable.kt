package com.jorge_diaz.leagues.model.event

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class EventObservable @Inject constructor(private var eventRepository: IEventRepository) :
    BaseObservable(), IEventObservable {

    override fun callEvents(idTeam: Int) {
        eventRepository.callEventsAPI(idTeam)
    }

    override fun getEvents(): MutableLiveData<List<Event>> {
        return eventRepository.getEvents()
    }


}