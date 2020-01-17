package com.example.morgan.models.forex

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Currency {
    constructor(id: Int?, name: String, symbol: String?) {
        this.id = id
        this.name = name
        this.symbol = symbol
    }

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("symbol")
    @Expose
    var symbol: String? = null
}