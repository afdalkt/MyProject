package com.dicoding.footballapp.match

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.dicoding.footballapp.model.Event
import com.dicoding.footballapp.util.formatDate
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class MatchAdapter(private val events: List<Event>)
    :RecyclerView.Adapter<EventViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(MatchUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int){
        holder.bindItem(events[position])
    }
}

class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val eventDate: TextView = view.find(MatchUI.eventDate)
    private val homeTeamName: TextView = view.find(MatchUI.homeTeamName)
    private val homeTeamScore: TextView = view.find(MatchUI.homeTeamScore)
    private val awayTeamScore: TextView = view.find(MatchUI.awayTeamScore)
    private val awayTeamName: TextView = view.find(MatchUI.awayTeamName)

    fun bindItem(events: Event){
        eventDate.text = events.eventDate?.formatDate()
        homeTeamName.text = events.homeTeam
        homeTeamScore.text = events.homeScore
        awayTeamScore.text = events.awayScore
        awayTeamName.text = events.awayTeam
    }
}
