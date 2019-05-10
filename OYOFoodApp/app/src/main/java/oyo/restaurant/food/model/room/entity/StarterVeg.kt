package oyo.restaurant.food.model.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import oyo.restaurant.food.model.utils.TABLE_STARTERS_VEG

@Entity(tableName = TABLE_STARTERS_VEG)
class StarterVeg(
    @PrimaryKey
    var id: String,
    var name: String,
    var price: Int)