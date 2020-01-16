package com.example.morgan.models.main.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class HomeOptionPrimary {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("label")
    @Expose
    var label: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("image")
    @Expose
    var image: Any? = null

    constructor(id: Int?, label: String?, description: String?, image: Any?) {
        this.id = id
        this.label = label
        this.description = description
        this.image = image
    }
}