package oyo.restaurant.food.view.waiter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_waiter.*
import com.google.android.material.tabs.TabLayout
import oyo.restaurant.food.R
import oyo.restaurant.food.view.old.OldOrderPagerAdapter
import oyo.restaurant.food.view.waiter.order.OrderEntity
import oyo.restaurant.food.view.waiter.order.OrderFragment
import oyo.restaurant.food.view.waiter.order.OrderPagerAdapter
import oyo.restaurant.food.viewmodel.MainViewModel
import oyo.restaurant.food.viewmodel.OrderViewModel
import oyo.restaurant.food.viewmodel.WaiterViewModel


class WaiterActivity : AppCompatActivity() {

    lateinit var mWaiterViewModel : WaiterViewModel
    lateinit var mOrderViewModel: OrderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waiter)
        new()
        observers()
    }

    fun new(){

        mWaiterViewModel = ViewModelProviders.of(this).get(WaiterViewModel::class.java)
        mOrderViewModel = ViewModelProviders.of(this).get(OrderViewModel::class.java)
        mWaiterViewModel.setOrderAdapter(OrderPagerAdapter(supportFragmentManager))
        mWaiterViewModel.newOrder()

        frameLayout.adapter = mWaiterViewModel.getOrderAdapter()
        tabs.setupWithViewPager(frameLayout)
    }

    fun observers(){
        mOrderViewModel.orderLive.observe(this, Observer<OrderEntity> { order ->
            if(0L != order.id){
                mWaiterViewModel.changeTitle(order.id, order.title)
            }
        })

        mOrderViewModel.removeLive.observe(this, Observer<Long> { orderId ->
            if(0L != orderId){
                mWaiterViewModel.removeOrder(orderId)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.add-> {showToast("add selected")
                mWaiterViewModel.newOrder()
                if (tabs.tabCount == 4) {
                    tabs.tabMode = TabLayout.MODE_FIXED
                } else {
                    tabs.tabMode = TabLayout.MODE_SCROLLABLE
                }
            }
            R.id.clear -> {showToast("clear selected")
                mWaiterViewModel.clearOrders()}
            R.id.orderHistory -> showToast("history selected")
            R.id.settings -> showToast("settings selected")

        }
        return true
    }

    fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


    private inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.commit()
    }

    fun old(){
        tabs.addTab(tabs.newTab().setText("1"))
        tabs.addTab(tabs.newTab().setText("2"))
        tabs.addTab(tabs.newTab().setText("3"))

        var adapter = OldOrderPagerAdapter(supportFragmentManager, tabs.tabCount)

        frameLayout.adapter = adapter
        frameLayout.offscreenPageLimit = 1
        frameLayout.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))


        //Bonus Code : If your tab layout has more than 2 tabs then tab will scroll other wise they will take whole width of the screen
        if (tabs.tabCount == 2) {
            tabs.tabMode = TabLayout.MODE_FIXED
        } else {
            tabs.tabMode = TabLayout.MODE_SCROLLABLE
        }
    }
}
