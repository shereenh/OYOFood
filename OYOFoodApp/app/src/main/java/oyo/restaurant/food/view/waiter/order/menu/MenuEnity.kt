package oyo.restaurant.food.view.waiter.order.menu

class MenuEnity(var isChecked: Boolean,
                var foodName: String,
                var quantity: String,
                var notes: String){

    constructor(foodName: String) : this(false, foodName, "0", "")
}