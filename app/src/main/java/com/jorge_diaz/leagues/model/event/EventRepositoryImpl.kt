package com.jorge_diaz.leagues.model.event

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.jorge_diaz.leagues.rest.Endpoints
import com.jorge_diaz.leagues.utils.RestUtils.Companion.API_KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventRepositoryImpl @Inject constructor(
    val context: Context,
    private val endpoints: Endpoints
) : IEventRepository {

    private val events = MutableLiveData<List<Event>>()

    override fun callEventsAPI(idTeam: Int) {
        val call = endpoints.getEvents(API_KEY, idTeam)
        call.enqueue(EventsAPIResponse())
    }

    inner class EventsAPIResponse : Callback<EventList> {
        override fun onResponse(call: Call<EventList>, response: Response<EventList>) {
            if (response.isSuccessful) {
                events.postValue(response.body()!!.events)
            } else {
                Toast.makeText(context, "Events API response is unsuccessful!", Toast.LENGTH_LONG)
                    .show()
                events.postValue(emptyList())
            }
        }

        override fun onFailure(call: Call<EventList>, throwable: Throwable) {
            Toast.makeText(context, "Error getting events data: $throwable", Toast.LENGTH_LONG).show()
            events.postValue(emptyList())
        }

    }

    override fun getEvents(): MutableLiveData<List<Event>> {
        return events
    }

}