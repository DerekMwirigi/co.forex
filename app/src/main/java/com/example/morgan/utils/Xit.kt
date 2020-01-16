package com.example.morgan.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.morgan.models.generic.Status


object Xit {
    fun makeFullScreen(activity: Activity) {
        try {
            activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            if (activity.actionBar != null) {
                activity.actionBar?.hide()
            }
        } catch (x: Exception) {
            x.printStackTrace()
        }


    }
     fun setState (status: Status, message: String?, avi: View, context: Context?, activity: FragmentActivity?){
        if(status== Status.LOADING){
            avi.visibility = View.VISIBLE
            activity?.window?.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        }else if(status== Status.ERROR||status== Status.SUCCESS){
            avi.visibility = View.GONE
            activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        }
        if(status== Status.ERROR){
            if(message!=null) {
                avi?.let { Toast.makeText(context,message, Toast.LENGTH_LONG).show() }
            }
        }
    }

    fun openFragment (activity: FragmentActivity,fragment: Fragment, name: String?, resourceId: Int) {
//        if (activity?.supportFragmentManager.backStackEntryCount > 0) {
//            if (activity?.supportFragmentManager.getBackStackEntryAt(activity?.supportFragmentManager.backStackEntryCount - 1).name == name) {
//                return
//            }
//        }
        if (name != null) {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(resourceId, fragment)
                ?.addToBackStack(name)
                ?.commit()
        } else {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(resourceId, fragment)
                ?.commit()
        }
    }
}