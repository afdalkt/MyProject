package com.afdal.aplikasifootballmatchschedule

import android.view.View
import java.text.SimpleDateFormat

fun View.visible(){
    visibility = View.VISIBLE
}

fun View.invisible(){
    visibility = View.INVISIBLE
}

//Date
fun String.formatDate(fromDateFormat: String = "dd/MM/yy",
                      toDateFormat: String = "E, dd MMM yyyy") : String{
    val date = SimpleDateFormat(fromDateFormat).parse(this)
    val dateFormatter = SimpleDateFormat(toDateFormat)
    return dateFormatter.format(date)
}