package com.jorge_diaz.leagues.viewmodel.event

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jorge_diaz.leagues.R
import com.jorge_diaz.leagues.model.event.Event
import com.jorge_diaz.leagues.model.event.Event.Companion.sortEventsByDate
import com.jorge_diaz.leagues.model.event.IEventObservable
import com.jorge_diaz.leagues.utils.TimeUtils.Companion.getDateFormatted
import com.jorge_diaz.leagues.view.team.ListEventsAdapter
import javax.inject.Inject

class EventViewModel @Inject constructor(
    private val eventObservable: IEventObservable,
    private val context: Context
) : ViewModel() {

    private var listEventsAdapter: ListEventsAdapter? = null


    fun callEvents(idTeam: Int) {
        eventObservable.callEvents(idTeam)
    }

    fun getEvents(): MutableLiveData<List<Event>> {
        return eventObservable.getEvents()
    }

    fun setEventsInListAdapter(events: List<Event>) {
        val sortedEvents = sortEventsByDate(events)
        listEventsAdapter?.submitList(sortedEvents)
    }

    fun getListEventsAdapter(): ListEventsAdapter? {
        listEventsAdapter =
            ListEventsAdapter(
                this,
                context,
                emptyList(),
                R.layout.list_item_event
            )

        return listEventsAdapter
    }

    fun getEventAt(position: Int): Event? {
        val events: List<Event> = listEventsAdapter!!.events
        return events[position]
    }

    fun getEventDateAt(position: Int): String {
        val currentStrTimestamp = listEventsAdapter?.events?.get(position)?.strTimestamp

        if (currentStrTimestamp.isNullOrEmpty()) {
            return context.getString(R.string.date_unknown)
        }

        return getDateFormatted(currentStrTimestamp)
    }

}