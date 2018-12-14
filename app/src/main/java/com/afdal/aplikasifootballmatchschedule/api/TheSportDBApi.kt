package com.afdal.aplikasifootballmatchschedule.api

import android.net.Uri
import com.afdal.aplikasifootballmatchschedule.BuildConfig

object TheSportDBApi {
    fun last15Events(eventId: Int?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.TSDB_API_KEY)
            .appendPath("eventspastleague.php")
            .appendQueryParameter("id", eventId.toString())
            .build()
            .toString()
    }

    fun next15Events(eventId: Int?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.TSDB_API_KEY)
            .appendPath("eventsnextleague.php")
            .appendQueryParameter("id", eventId.toString())
            .build()
            .toString()
    }
}