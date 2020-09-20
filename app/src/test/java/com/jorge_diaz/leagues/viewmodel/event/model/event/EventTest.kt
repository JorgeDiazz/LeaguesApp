package com.jorge_diaz.leagues.viewmodel.event.model.event

import com.jorge_diaz.leagues.model.event.Event
import org.junit.Test

class EventTest {

    @Test
    fun sortEventsByDate_isDescendingOrderCorrect() {
        val event1 = Event(1, "strEvent1", "strLeague1", "2020-10-18T00:00:00+00:00")
        val event2 = Event(2, "strEvent2", "strLeague1", "2020-09-26T11:00:00+00:00")
        val event3 = Event(3, "strEvent3", "strLeague1", "2020-09-26T16:30:00+00:00")
        val event4 = Event(4, "strEvent4", "strLeague1", "2020-10-04T00:00:00+00:00")
        val event5 = Event(5, "strEvent5", "strLeague1", "2020-09-30T23:00:00+00:00")

        val events: List<Event> = listOf(event1, event2, event3, event4, event5)

        val sortedEvents = Event.sortEventsByDate(events)
        val correctSortedEvents: List<Event> = listOf(event2, event3, event5, event4, event1)

        sortedEvents.zip(correctSortedEvents)
            .forEach { (sortedEvent, correctEvent) -> assert(sortedEvent == correctEvent) }
    }
}