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
import android.widget.LinearLayout
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
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                orientation = LinearLayout.VERTICAL
                topPadding = dip(16)
                leftPadding = dip(16)
                rightPadding = dip(16)

                swipeRefresh = swipeRefreshLayout {
                    setColorSchemeResources(colorAccent,
                        android.R.color.holo_green_light,
                        android.R.color.holo_orange_light,
                        android.R.color.holo_red_light)

                    relativeLayout {
                        lparams(width = matchParent, height = wrapContent)

                        listEvent = recyclerView {
                            lparams(width = matchParent, height = wrapContent)
                            layoutManager = LinearLayoutManager(context)
                        }

                        progressBar = progressBar {
                        }.lparams{
                            centerHorizontally()
                        }
                    }
                }
            }
        }
    }
}