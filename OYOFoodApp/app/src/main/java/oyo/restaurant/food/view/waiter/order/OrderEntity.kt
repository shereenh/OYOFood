package oyo.restaurant.food.view.waiter.order

import androidx.fragment.app.Fragment

class OrderEntity(var id: Long,
                  var title: String,
                  var fragment: Fragment,
                  var state: Int) {
}


/*
states:
        0 -> tab created
        1 -> table selected
        2 -> order made
        3 -> order confirmed
        4 -> order placed to chef & served
        5 -> bill

*/