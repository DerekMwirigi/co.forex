package com.example.morgan.models.auth

import com.example.morgan.models.user.User
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class SignInRes : Serializable {
    @SerializedName("success")
    @Expose
    var success: Boolean? = null

    @SerializedName("status_code")
    @Expose
    var status_code: Int? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("errors")
    @Expose
    var errors: Array<String>? = null

    @SerializedName("data")
    @Expose
    var data: User? = null
}