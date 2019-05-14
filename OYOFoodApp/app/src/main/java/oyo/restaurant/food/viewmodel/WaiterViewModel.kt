package oyo.restaurant.food.viewmodel

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import oyo.restaurant.food.view.waiter.order.OrderEntity
import oyo.restaurant.food.view.waiter.order.OrderFragment
import oyo.restaurant.food.view.waiter.order.OrderPagerAdapter

class WaiterViewModel(application: Application): MainViewModel(application) {

    var fragmentMap = HashMap<Long, Fragment>()
    var mTabViews = mutableListOf<OrderEntity>()
    lateinit var adapter : OrderPagerAdapter

    init {
        //check if liveTabs has values, if so then create fragments
    }

    fun setOrderAdapter(adapter: OrderPagerAdapter){
        this.adapter = adapter
    }

    fun getOrderAdapter() = adapter

    fun newOrder(){
        val orderId = (0..Long.MAX_VALUE).random()
        val order = OrderEntity(
            orderId,
            "new",
            OrderFragment.newInstance(orderId),
            0
        )
        mTabViews.add(order)
        fragmentMap[orderId] = order.fragment!!
        adapter.addTab(order)
        adapter.notifyDataSetChanged()
    }

    fun clearOrders(){
        mTabViews.clear()
        fragmentMap.clear()
        adapter.clearTabs()
        newOrder()
    }

    fun changeTitle(id: Long, title: String){
        adapter.setTab(id, title)
        adapter.notifyDataSetChanged()
    }

    fun removeOrder(id: Long){
        adapter.removeTab(id)
        adapter.notifyDataSetChanged()
    }


}