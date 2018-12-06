package com.dicoding.footballapp.match

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import com.dicoding.footballapp.R
import org.jetbrains.anko.*

class MatchActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MatchActivityUI().setContentView(this)
    }

    class MatchActivityUI : AnkoComponent<MatchActivity>{
        override fun createView(ui: AnkoContext<MatchActivity>): View {
            return with(ui){
                relativeLayout {
                    lparams(width = matchParent, height = wrapContent)

                    frameLayout {
                        id = R.id.fragmentHolder
                    }.lparams{
                        width = matchParent
                        height = wrapContent
                    }
                }.view()
            }
        }

    }
}