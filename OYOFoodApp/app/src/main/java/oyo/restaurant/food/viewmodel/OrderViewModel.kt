package oyo.restaurant.food.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import oyo.restaurant.food.view.waiter.order.OrderEntity

class OrderViewModel(application: Application) : MainViewModel(application) {

    var orderLive = MutableLiveData<OrderEntity>()

    var removeLive = MutableLiveData<Long>()

    fun setLiveOrderTitle(id: Long, title: String){
        orderLive.value = OrderEntity(id, title)
    }

    fun removeLiveTab(id: Long){
        removeLive.value = id
    }




}