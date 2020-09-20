package com.jorge_diaz.leagues.model.team

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class TeamObservable @Inject constructor(private var teamRepository: ITeamRepository) :
    BaseObservable(), ITeamObservable {


}