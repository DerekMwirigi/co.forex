package com.example.morgan.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.morgan.R
import com.example.morgan.models.main.home.HomeOptionPrimary
import com.example.morgan.utils.OnRecyclerViewItemClick
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    companion object {
        fun newInstance() = HomeFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @SuppressLint("WrongConstant")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mcvInfo.setOnClickListener {  }
        setUpUi()
    }

    private fun setUpUi (){
        var homeOptionsPrimary = listOf(
            HomeOptionPrimary(1, "Services", "", R.drawable.ic_local_laundry_service_24dp),
            HomeOptionPrimary(2, "Locate", "", R.drawable.ic_location_on_24dp)
        )
        rvHomeOptionsPrimary.adapter = HomeOptionPrimaryAdapter(homeOptionsPrimary, object : OnRecyclerViewItemClick {
            override fun onClickListener(position: Int) {
                when(position){
                    //1-> openView(BillingFragment.newInstance(), "BillingFragment")
                }
            }
            override fun onLongClickListener(position: Int) {
            }
        })
        rvHomeOptionsPrimary.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.HORIZONTAL, false)
        rvHomeOptionsPrimary.itemAnimator = DefaultItemAnimator()
    }
}