package com.dicoding.footballapp.main

import com.dicoding.footballapp.api.ApiRespository
import com.dicoding.footballapp.api.TheSportDBApi
import com.dicoding.footballapp.model.TeamResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter (private val view: MainView,
                     private val apiRespository: ApiRespository,
                     private val gson: Gson){

    fun getTeamList(league: String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRespository
                .doRequest(TheSportDBApi.getTeams(league)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }
}