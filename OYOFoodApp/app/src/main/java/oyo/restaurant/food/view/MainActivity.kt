package oyo.restaurant.food.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import oyo.restaurant.food.R
import oyo.restaurant.food.view.waiter.WaiterActivity
import oyo.restaurant.food.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var mViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        waiterButton.setOnClickListener{
            startActivity(Intent(this@MainActivity, WaiterActivity::class.java))
        }
    }



}
