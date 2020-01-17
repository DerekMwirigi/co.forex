package com.example.morgan.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.morgan.R
import com.example.morgan.models.forex.Currency
import com.example.morgan.models.forex.Exchange
import com.example.morgan.models.main.home.HomeOptionPrimary
import com.example.morgan.models.user.User
import com.example.morgan.storage.data.PrefrenceManager
import com.example.morgan.ui.forex.ExchangeAdapter
import com.example.morgan.ui.order.OrderActivity
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
        var user: User = PrefrenceManager(activity!!).getUserSession()!!
        tvUserName.text = user.userName
        tvCredentials.text = user.email
        var homeOptionsPrimary = listOf(
            HomeOptionPrimary(0, "New order", "", R.drawable.ic_playlist_add_24dp),
            HomeOptionPrimary(1, "My orders", "", R.drawable.ic_list_black_24dp),
            HomeOptionPrimary(2, "View rates exchanges", "", R.drawable.ic_pageview_24dp)
        )
        rvHomeOptionsPrimary.adapter = HomeOptionPrimaryAdapter(homeOptionsPrimary, object : OnRecyclerViewItemClick {
            override fun onClickListener(position: Int) {
                Toast.makeText(activity!!, "" + position, Toast.LENGTH_LONG).show()
                when(position){
                    0-> {
                        val intent = Intent(activity!!, OrderActivity::class.java)
                        intent.putExtra("fragmentOption", 0)
                        startActivity(intent)
                    }
                    1-> {
                        val intent = Intent(activity!!, OrderActivity::class.java)
                        intent.putExtra("fragmentOption", 1)
                        startActivity(intent)
                    }
                    2-> {
                        val intent = Intent(activity!!, OrderActivity::class.java)
                        intent.putExtra("fragmentOption", 1)
                        startActivity(intent)
                    }
                }
            }
            override fun onLongClickListener(position: Int) {
            }
        })
        rvHomeOptionsPrimary.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.HORIZONTAL, false)
        rvHomeOptionsPrimary.itemAnimator = DefaultItemAnimator()


        var exchangeModels = listOf(
            Exchange(1, Currency(1, "USD", "$"), 100.00, 120.00),
            Exchange(1, Currency(1, "USD", "$"), 100.00, 120.00),
            Exchange(1, Currency(1, "USD", "$"), 100.00, 120.00),
            Exchange(1, Currency(1, "USD", "$"), 100.00, 120.00),
            Exchange(1, Currency(1, "USD", "$"), 100.00, 120.00)
        )
        rvHomeTrendingExchange.adapter = ExchangeAdapter(exchangeModels, object :
            OnRecyclerViewItemClick {
            override fun onClickListener(position: Int) {

            }
            override fun onLongClickListener(position: Int) {
            }
        })
        rvHomeTrendingExchange.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.VERTICAL, false)
        rvHomeTrendingExchange.itemAnimator = DefaultItemAnimator()
    }
}