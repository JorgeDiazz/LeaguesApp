package com.jorge_diaz.leagues.view.team

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jorge_diaz.leagues.R
import com.jorge_diaz.leagues.UIutils.FragmentUtils
import com.jorge_diaz.leagues.UIutils.FragmentUtils.Companion.removeFragmentFromStack
import com.jorge_diaz.leagues.databinding.FragmentTeamBinding
import com.jorge_diaz.leagues.di.LeaguesApplication
import com.jorge_diaz.leagues.model.event.Event
import com.jorge_diaz.leagues.model.team.Team
import com.jorge_diaz.leagues.utils.UrlUtils.Companion.formatUrl
import com.jorge_diaz.leagues.viewmodel.event.EventViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_team.*
import javax.inject.Inject
import javax.inject.Named


class TeamFragment(private val team: Team) :
    Fragment() {

    @field:[Inject Named("eventViewModelFactory")]
    lateinit var eventViewModelFactory: ViewModelProvider.Factory

    private lateinit var eventViewModel: EventViewModel
    private lateinit var binding: FragmentTeamBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_team, container, false
        )

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpInjection()
        setUpBindings()
        setUpView()
    }

    private fun setUpInjection() {
        (activity!!.applicationContext as LeaguesApplication).component.inject(this)
    }

    private fun setUpBindings() {
        setUpEventViewModel()
    }

    private fun setUpEventViewModel() {
        eventViewModel =
            ViewModelProvider(this, eventViewModelFactory).get(EventViewModel::class.java)

        binding.eventModel = eventViewModel
    }

    private fun setUpView() {
        setUpBackButtonPressedListener()
        setUpViewImages()
        setUpViewTextContent()
        setUpSocialNetworksClickListener()
        setUpEventsListUpdate(team.idTeam)
    }

    private fun setUpBackButtonPressedListener() {
        view!!.isFocusableInTouchMode = true
        view!!.requestFocus()
        view!!.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                removeFragmentFromStack(this)
                activity!!.onBackPressed()
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
    }

    private fun setUpViewImages() {
        Picasso.get().load(team.strTeamBadge).into(iv_team_badge)
        Picasso.get().load(team.strTeamJersey).into(iv_team_jersey)
    }

    private fun setUpViewTextContent() {
        tv_team_name.text = team.strTeam
        tv_team_name_header.text = team.strTeam
        tv_expandable_description.setContent(team.strDescriptionEN)
        tv_foundation_year.text = team.intFormedYear.toString()
        setUpWebsiteContent()
    }

    private fun setUpWebsiteContent() {
        if (team.strWebsite.isEmpty()) {
            tv_website_title.visibility = View.GONE
            tv_website.visibility = View.GONE
        } else {
            tv_website.text = team.strWebsite
        }
    }

    private fun setUpSocialNetworksClickListener() {
        var teamHasSocialNetwork = false

        if (team.strFacebook.isEmpty()) {
            ib_facebook.visibility = View.GONE
        } else {
            teamHasSocialNetwork = true
            ib_facebook.setOnClickListener {
                FragmentUtils.openLinkInBrowser(
                    this,
                    formatUrl(team.strFacebook)
                )
            }
        }

        if (team.strInstagram.isEmpty()) {
            ib_instagram.visibility = View.GONE
        } else {
            teamHasSocialNetwork = true
            ib_instagram.setOnClickListener {
                FragmentUtils.openLinkInBrowser(
                    this,
                    formatUrl(team.strInstagram)
                )
            }
        }

        if (team.strTwitter.isEmpty()) {
            ib_twitter.visibility = View.GONE
        } else {
            ib_twitter.setOnClickListener {
                teamHasSocialNetwork = true
                FragmentUtils.openLinkInBrowser(
                    this,
                    formatUrl(team.strTwitter)
                )
            }
        }

        if (team.strYoutube.isEmpty()) {
            ib_youtube.visibility = View.GONE
        } else {
            ib_youtube.setOnClickListener {
                teamHasSocialNetwork = true
                FragmentUtils.openLinkInBrowser(
                    this,
                    formatUrl(team.strYoutube)
                )
            }
        }

        if (!teamHasSocialNetwork) {
            tv_social_networks_title.visibility = View.GONE
        }
    }


    private fun setUpEventsListUpdate(idTeam: Int) {
        eventViewModel.callEvents(idTeam)
        eventViewModel.getEvents().observe(viewLifecycleOwner, Observer { events: List<Event> ->
            eventViewModel.setEventsInListAdapter(events)
        })
    }


    companion object {
        @JvmStatic
        fun newInstance(team: Team) =
            TeamFragment(team)
    }
}
