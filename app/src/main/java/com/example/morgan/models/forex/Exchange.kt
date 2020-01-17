package com.example.morgan.models.forex

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Exchange {
    constructor(id: Int?, currency: Currency, buying: Double?, selling: Double?) {
        this.id = id
        this.currency = currency
        this.buying = buying
        this.selling = selling
    }

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("currency")
    @Expose
    var currency: Currency? = null

    @SerializedName("buying")
    @Expose
    var buying: Double? = null

    @SerializedName("selling")
    @Expose
    var selling: Double? = null
}