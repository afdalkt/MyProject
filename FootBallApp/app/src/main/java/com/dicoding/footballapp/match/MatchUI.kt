package com.dicoding.footballapp.match

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.dicoding.footballapp.R
import org.jetbrains.anko.*

class MatchUI : AnkoComponent<ViewGroup>{
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(5)
                orientation = LinearLayout.VERTICAL
                gravity = Gravity.CENTER_HORIZONTAL

                textView {
                    id = R.id.eventDate
                    textSize = 14f
                }.lparams{

                }

                linearLayout{
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(3)
                    orientation = LinearLayout.HORIZONTAL

                    textView {
                        id = R.id.homeTeamName
                        textSize = 16f
                        gravity = Gravity.RIGHT
                        textColorResource = android.R.color.black
                    }.lparams{
                        topMargin = dip(5)
                        weight = 1.35F
                    }

                    textView {
                        id = R.id.homeTeamScore
                        textSize = 20f
                        textColorResource = android.R.color.holo_red_dark
                    }.lparams{
                        topMargin = dip(5)
                        weight = 0.1F
                    }

                    textView {
                        textResource = R.string.separator
                        textSize = 16f
                    }.lparams{
                        topMargin = dip(5)
                        weight = 0.1F
                    }

                    textView {
                        id = R.id.awayTeamScore
                        textSize = 16f
                        textColorResource = android.R.color.black
                    }.lparams{
                        topMargin = dip(5)
                        weight = 0.1F
                    }

                    textView {
                        id = R.id.awayTeamName
                        textSize = 16f
                        textColorResource = android.R.color.black
                    }.lparams{
                        topMargin = dip(5)
                        weight = 1.35F
                    }
                }
            }
        }
    }

    companion object {
        val eventDate = 1
        val homeTeamName = 2
        val homeTeamScore = 3
        val awayTeamName = 4
        val awayTeamScore = 5
    }
}