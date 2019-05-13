package oyo.restaurant.food.view.waiter

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import oyo.restaurant.food.view.waiter.order.OrderEntity

class WaiterViewModel(application: Application): AndroidViewModel(application) {

    var fragmentMap = HashMap<Long, Fragment>()

    var mTabViews = mutableListOf<OrderEntity>()

    init {
        //check if liveTabs has values, if so then create fragments
    }
//    var liveTabs =

}