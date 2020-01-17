package com.example.morgan.network


import com.example.morgan.models.auth.SignIn
import com.example.morgan.models.auth.SignUp
import com.example.morgan.models.auth.SignInRes
import retrofit2.Call
import retrofit2.http.*

interface EndpointApis {
    @POST("auth/sign-up")
    fun signUp (@Body signUp: SignUp?) : Call<SignInRes>

    @POST("auth/sign-in")
    fun signIn (@Body signIn: SignIn?) : Call<SignInRes>
}