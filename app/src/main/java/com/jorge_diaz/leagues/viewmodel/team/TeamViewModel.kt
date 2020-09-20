package com.jorge_diaz.leagues.viewmodel.team

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jorge_diaz.leagues.R
import com.jorge_diaz.leagues.model.team.ITeamObservable
import com.jorge_diaz.leagues.model.team.Team
import com.jorge_diaz.leagues.view.RecyclerTeamsAdapter
import com.squareup.picasso.Picasso
import javax.inject.Inject

class TeamViewModel @Inject constructor(private val teamObservable: ITeamObservable) : ViewModel() {



}