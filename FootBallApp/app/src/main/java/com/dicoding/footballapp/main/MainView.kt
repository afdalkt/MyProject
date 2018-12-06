package com.dicoding.footballapp.main

import com.dicoding.footballapp.model.Event
import com.dicoding.footballapp.model.Team

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}