package com.dicoding.footballapp.match

import com.dicoding.footballapp.api.ApiRespository
import com.dicoding.footballapp.api.TheSportDBApi
import com.dicoding.footballapp.model.EventResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MatchPresenter (private val view: MatchView,
                      private val apiRespository: ApiRespository,
                      private val gson: Gson){

    fun getLast15Events(eventId: Int?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRespository
                .doRequest(TheSportDBApi.last15Events(eventId)),
                EventResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showEventsList(data.events)
            }
        }
    }

    fun getNext15Events(eventId: Int?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRespository
                .doRequest(TheSportDBApi.next15Events(eventId)),
                EventResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showEventsList(data.events)
            }
        }
    }
}