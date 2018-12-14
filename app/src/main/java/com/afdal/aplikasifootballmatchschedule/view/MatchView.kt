package com.afdal.aplikasifootballmatchschedule.view

import com.afdal.aplikasifootballmatchschedule.model.Event

interface MatchView {
    fun showLoading()
    fun hideLoading()
    fun showEventsList(data: List<Event>)
}