package com.example.morgan.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.transition.Visibility
import com.example.morgan.R
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.flContents, SigninFragment.newInstance())
                .commitNow()
        }
        btSignIn.setOnClickListener { showFragment("signIn") }
        btSignUp.setOnClickListener { showFragment("signUp") }
    }
    private fun showFragment(fragment: String){
        when(fragment){
            "signIn"->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.flContents, SigninFragment.newInstance())
                    .commitNow()
            }
            "signUp"->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.flContents, SignupFragment.newInstance())
                    .commitNow()
            }
        }
    }
}
