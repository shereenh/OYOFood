package oyo.restaurant.food.model.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import oyo.restaurant.food.model.utils.TABLE_LIVE_ORDERS
import oyo.restaurant.food.model.utils.TABLE_STARTERS_VEG

@Entity(tableName = TABLE_LIVE_ORDERS)
class LiveOrder(
    @PrimaryKey
    var id: Long,
    var title: String,
    var state: Int)