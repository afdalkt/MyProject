package com.dicoding.footballapp.model

import com.google.gson.annotations.SerializedName

class Event (
    @SerializedName("idEvent")
    var eventId: Int? = null,

    @SerializedName("strDate")
    var eventDate: String? = null,

    // Home
    @SerializedName("idHomeTeam")
    var homeTeamId: String? = null,

    @SerializedName("strHomeTeam")
    var homeTeam: String? = null,

    @SerializedName("intHomeScore")
    var homeScore: String? = null,

    // Away
    @SerializedName("idAwayTeam")
    var awayTeamId: String? = null,

    @SerializedName("strAwayTeam")
    var awayTeam: String? = null,

    @SerializedName("intAwayScore")
    var awayScore: String? = null
)