package com.example.morgan.ui.order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.morgan.R
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.llMiddle, HistoryOrdersFragment.newInstance())
                .commitNow()
        }else{
            val bundle: Bundle? = intent.extras
            bundle?.let {
                bundle.apply {
                    var fragmentOption: Int = get("fragmentOption") as Int
//                    Toast.makeText(this, "fragmentOption:" + fragmentOption, Toast.LENGTH_LONG).show()
                    when(fragmentOption){
                        0->{
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.llMiddle, NewOrderFragment.newInstance())
                                .commitNow()
                        }
                        1->{
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.llMiddle, HistoryOrdersFragment.newInstance())
                                .commitNow()
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        supportFragmentManager.beginTransaction()
            .replace(R.id.llMiddle, HistoryOrdersFragment.newInstance())
            .commitNow()
    }
}
