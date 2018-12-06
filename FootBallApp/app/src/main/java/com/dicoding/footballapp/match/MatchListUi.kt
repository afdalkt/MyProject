package com.dicoding.footballapp.match

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.dicoding.footballapp.R
import com.dicoding.footballapp.R.color.colorAccent
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class MatchListUi : AnkoComponent<Context> {
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var listEvent: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun createView(ui: AnkoContext<Context>): View {
        return with(ui) {
            relativeLayout {
                lparams(width = matchParent, height = wrapContent)
                topPadding = dip(16)
                leftPadding = dip(3)
                rightPadding = dip(3)

                progressBar = progressBar {
                    id = R.id.progressBar
                }.lparams {
                    centerHorizontally()
                }

                swipeRefresh = swipeRefreshLayout {
                    id = R.id.swipeRefresh
                    setColorSchemeResources(
                        colorAccent,
                        android.R.color.holo_green_light,
                        android.R.color.holo_orange_light,
                        android.R.color.holo_red_light)

                    listEvent = recyclerView {
                        id = R.id.listEvent
                        lparams(width = matchParent, height = wrapContent)
                        layoutManager = LinearLayoutManager(ctx)
                    }

                }
            }


        }
    }
}