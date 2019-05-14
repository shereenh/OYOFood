package oyo.restaurant.food.view.waiter.order

import androidx.fragment.app.Fragment

class OrderEntity(var id: Long = 0L,
                  var title: String,
                  var fragment: Fragment?,
                  var state: Int) {

    constructor(id: Long, title: String) : this(id, title, null, 0)
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