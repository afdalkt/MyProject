package com.afdal.aplikasifootballmatchschedule.presenter

import com.afdal.aplikasifootballmatchschedule.api.ApiRepository
import com.afdal.aplikasifootballmatchschedule.api.TheSportDBApi
import com.afdal.aplikasifootballmatchschedule.model.EventResponse
import com.afdal.aplikasifootballmatchschedule.view.MatchView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MatchPresenter(private val view: MatchView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson){

    fun getLast15Events(eventId: Int?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
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
            val data = gson.fromJson(apiRepository
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