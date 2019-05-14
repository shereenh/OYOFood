package oyo.restaurant.food.model.utils

import oyo.restaurant.food.view.waiter.order.menu.MenuEnity

const val LOGGER = "OYO LOGGER"

const val SP_FILENAME = "oyo_sp"
const val SP_FIRST_TIME = "first_time"



const val DATABASE_NAME = "oyo.db"

const val TABLE_LIVE_ORDERS = "live_orders"
const val TABLE_HISTORY = "history"
const val TABLE_STARTERS_VEG = "starters_veg"

val tableList = arrayListOf("None","Table 1", "Table 2", "Table 3", "Table 4", "Table 5")

val startersVegList = arrayListOf<MenuEnity>(MenuEnity("Mushroom Manchurian"),
    MenuEnity("Veg Manchurian"), MenuEnity("Gobi Chilli"))

val startersNonVegList = arrayListOf(MenuEnity("Chicken 65"),
    MenuEnity("Chilli Chicken"), MenuEnity("Chicken Kebab"))

val sandwichList = arrayListOf(MenuEnity("Veg Sandwich"),
    MenuEnity("Chicken Sandwich"), MenuEnity("Stuffed Veg Sandwich"))

val mainCourseVegList = arrayListOf(MenuEnity("Kadai Veg"), MenuEnity("Chana Masala"),
    MenuEnity("Green Peas Masala"))



