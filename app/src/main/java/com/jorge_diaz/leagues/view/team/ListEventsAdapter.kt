package com.jorge_diaz.leagues.view.team

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.jorge_diaz.leagues.BR
import com.jorge_diaz.leagues.databinding.ListItemEventBinding
import com.jorge_diaz.leagues.model.event.Event
import com.jorge_diaz.leagues.viewmodel.event.EventViewModel

class ListEventsAdapter(
    private val eventViewModel: EventViewModel,
    context: Context,
    var events: List<Event>,
    private val resource: Int
) :
    ArrayAdapter<Event>(context, 0, events) {


    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup): View {
        return setUpBinding(position, viewGroup)
    }

    private fun setUpBinding(position: Int, viewGroup: ViewGroup): View {
        val binding: ListItemEventBinding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            resource,
            viewGroup,
            false
        )

        binding.setVariable(BR.event_model, eventViewModel)
        binding.setVariable(BR.position, position)
        binding.executePendingBindings()

        return binding.root
    }

    override fun getCount(): Int {
        return events.size
    }

    fun submitList(events: List<Event>) {
        this.events = events
        notifyDataSetChanged()
    }

}