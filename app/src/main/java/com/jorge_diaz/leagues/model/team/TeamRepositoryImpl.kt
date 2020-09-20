package com.jorge_diaz.leagues.model.team

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.jorge_diaz.leagues.rest.Endpoints
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamRepositoryImpl @Inject constructor(
    val context: Context,
    private val endpoints: Endpoints
) : ITeamRepository {



}