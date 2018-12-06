package com.dicoding.footballapp.match

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.dicoding.footballapp.R
import com.dicoding.footballapp.model.Event
import com.dicoding.footballapp.util.invisible
import com.dicoding.footballapp.util.visible
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.onRefresh

private const val LIST_LAST_MATCH = "lastMatch"
private const val LIST_NEXT_MATCH = "nextMatch"

class MatchFragment : Fragment(), MatchView{

    private val eventId: Int = 4328
    private var isLastMatch: Boolean =true
    private var isNextMatch: Boolean =true
    private var events: MutableList<Event> = mutableListOf()
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var listEvent: RecyclerView
    private lateinit var presenter: MatchPresenter
    private lateinit var adapter: MatchAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View? {

        val rootView = MatchListUi().createView(AnkoContext.create(ctx))
        progressBar = rootView.find(R.id.progressBar)
        swipeRefresh = rootView.find(R.id.swipeRefresh)
        swipeRefresh.onRefresh {
            getEventLists()
        }
        listEvent = rootView.find(R.id.listEvent) as RecyclerView
        listEvent.adapter = adapter

        return rootView
    }

    private fun getEventLists() {
        if (isLastMatch){
            presenter.getLast15Events(eventId)
        }else if (isNextMatch){
            presenter.getNext15Events(eventId)
        }
    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showEventsList(data: List<Event>) {
        swipeRefresh.isRefreshing = false
        events.clear()
        events.addAll(data)
        adapter.notifyDataSetChanged()
    }

    companion object {
        @JvmStatic
        fun lastInstance(isLastMatch: Boolean) = MatchFragment(). apply {
            arguments = Bundle().apply {
                putBoolean(LIST_LAST_MATCH, isLastMatch)
            }
        }

        @JvmStatic
        fun nextInstance(isNextMatch: Boolean) = MatchFragment(). apply {
            arguments = Bundle().apply {
                putBoolean(LIST_NEXT_MATCH, isNextMatch)
            }
        }

    }
}