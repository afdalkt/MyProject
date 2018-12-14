package com.afdal.aplikasifootballmatchschedule.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.internal.BottomNavigationItemView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import com.afdal.aplikasifootballmatchschedule.R
import com.afdal.aplikasifootballmatchschedule.R.id.btnlast_match
import com.afdal.aplikasifootballmatchschedule.R.id.btnnext_match
import com.afdal.aplikasifootballmatchschedule.activity.fragment.LastMatchFragment
import com.afdal.aplikasifootballmatchschedule.activity.fragment.NextMatchFragment
import org.jetbrains.anko.*
import org.jetbrains.anko.design.bottomNavigationView

class MainActivity : AppCompatActivity() {

    //ToolBar Menu Start
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId){
            R.id.team -> {
                toast("Team")
                 true
            }
            R.id.match ->{
                toast("Match")
                true
            }else -> false
        }
        return super.onOptionsItemSelected(item)
    }
    //ToolBar Menu -->>Finish

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {

            frameLayout {
                id = R.id.fragment_holder
            }.lparams(width = matchParent, height = dip(0), weight = 1F)

            linearLayout {
                orientation = LinearLayout.VERTICAL
                lparams(matchParent, wrapContent)

                bottomNavigationView {
                    inflateMenu(R.menu.match_menu)
                }.setOnNavigationItemSelectedListener { item ->
                    when (item.itemId) {
                        btnlast_match -> {
                            loadLastMatchFragment(savedInstanceState)
                        }
                        btnnext_match -> {
                            loadNextMatchFragment(savedInstanceState)
                        }
                    }
                    true
                }
            }
        }
    }

    private fun loadLastMatchFragment(savedInstanceState: Bundle?){
        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_holder, LastMatchFragment(), LastMatchFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadNextMatchFragment(savedInstanceState: Bundle?){
        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_holder, NextMatchFragment(), NextMatchFragment::class.java.simpleName)
                .commit()
        }
    }
}