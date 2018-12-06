package com.dicoding.footballapp.match

import com.dicoding.footballapp.model.Event

interface MatchView {
    fun showLoading()
    fun hideLoading()
    fun showEventsList(data: List<Event>)
}