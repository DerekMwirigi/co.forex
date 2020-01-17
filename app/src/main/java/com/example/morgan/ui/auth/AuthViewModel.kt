package com.example.morgan.ui.auth

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.morgan.models.auth.SignIn
import com.example.morgan.models.auth.SignInRes
import com.example.morgan.models.auth.SignUp
import com.example.morgan.models.generic.Resource
import com.example.morgan.storage.auth.AuthRepository

class AuthViewModel  (application: Application) : AndroidViewModel(application) {
    private val signInObservable = MediatorLiveData<Resource<SignInRes>>()
    private val signUpObservable = MediatorLiveData<Resource<SignInRes>>()
    var authRepository: AuthRepository = AuthRepository(application)
    init {
        signInObservable.addSource(authRepository.signInObservable) { data -> signInObservable.setValue(data) }
        signUpObservable.addSource(authRepository.signUpObservable) { data -> signUpObservable.setValue(data) }
    }

    fun observeSignIn(): LiveData<Resource<SignInRes>> {
        return signInObservable
    }

    fun observeSignUp(): LiveData<Resource<SignInRes>> {
        return signUpObservable
    }

    fun signIn(signIn: SignIn){
        authRepository.signIn(signIn)
    }

    fun signUp(signUp: SignUp){
        authRepository.signUp(signUp)
    }
}