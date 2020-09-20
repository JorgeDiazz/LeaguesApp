package com.jorge_diaz.leagues.view.league

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.jorge_diaz.leagues.BR
import com.jorge_diaz.leagues.model.team.Team
import com.jorge_diaz.leagues.viewmodel.league.LeagueViewModel

class RecyclerTeamsAdapter(
    private val teamViewModel: LeagueViewModel,
    private val resource: Int
) :
    RecyclerView.Adapter<RecyclerTeamsAdapter.TeamViewHolder>() {

    var teams: List<Team>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return TeamViewHolder(binding)
    }

    override fun getItemCount() = teams?.size ?: 0

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teamViewModel, position)
    }

    override fun getItemViewType(position: Int): Int {
        return resource
    }

    fun submitList(teams: List<Team>) {
        this.teams = teams
        notifyDataSetChanged()
    }

    inner class TeamViewHolder(private var binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(teamViewModel: LeagueViewModel, position: Int) {
            binding.setVariable(BR.league_model, teamViewModel)
            binding.setVariable(BR.position, position)
            binding.executePendingBindings()
        }
    }
}