package com.example.morgan.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.morgan.R
import com.example.morgan.models.auth.SignUp
import com.example.morgan.storage.data.PrefrenceManager
import com.example.morgan.ui.MainActivity
import com.example.morgan.utils.Xit
import kotlinx.android.synthetic.main.signup_layout.*

class SignupFragment : Fragment() {
    private lateinit var viewModel: AuthViewModel
    companion object {
        fun newInstance() = SignupFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.signup_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        viewModel.observeSignUp().observe(this, Observer { data->
            run {
                Xit.setState(data.status, data.message, avi, context, activity)
                if(data.data?.status_code == 1){
                    PrefrenceManager(context!!).setLoginStatus(1)
                    startActivity(Intent(activity!!, MainActivity::class.java))
                    activity!!.finish()
                }
            }
        })
        btSignUp.setOnClickListener {  viewModel.signUp(verifyData())}
    }

    private fun verifyData () : SignUp {
        return SignUp(edtUserName.text.toString(), edtEmail.text.toString(), edtPassword.text.toString())
    }
}