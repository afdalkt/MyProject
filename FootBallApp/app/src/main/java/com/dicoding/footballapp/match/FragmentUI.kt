package com.dicoding.footballapp.match

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import com.dicoding.footballapp.R
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class FragmentUI : AnkoComponent<MatchFragment>{
    lateinit var progressBar: ProgressBar
    lateinit var swipeRefresh: SwipeRefreshLayout
    lateinit var listEvent: RecyclerView

    override fun createView(ui: AnkoContext<MatchFragment>): View {
        return with(ui){
            relativeLayout {
                lparams(width = matchParent, height = matchParent)
                topPadding = dip(16)
                leftPadding = dip(3)
                rightPadding = dip(3)

                progressBar = progressBar {
                    id = View.generateViewId()
                }.lparams{
                    centerInParent()
                }

                swipeRefresh = swipeRefreshLayout {
                    id = View.generateViewId()
                    setColorSchemeResources(R.color.colorAccent,
                        android.R.color.holo_green_light,
                        android.R.color.holo_orange_light,
                        android.R.color.holo_red_light)

                    listEvent = recyclerView {
                        id = View.generateViewId()
                        lparams(width = matchParent, height = wrapContent)
                        layoutManager = LinearLayoutManager(ctx)
                    }
                }
            }
        }
    }
}