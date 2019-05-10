package oyo.restaurant.food.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import oyo.restaurant.food.model.room.entity.StarterVeg
import oyo.restaurant.food.model.utils.TABLE_STARTERS_VEG

@Dao
interface ODao {

    @Insert(onConflict = REPLACE)
    fun insertStartersVeg(starterVeg: StarterVeg)

    @Query("SELECT * FROM " + TABLE_STARTERS_VEG)
    fun getStartersVeg():LiveData<List<StarterVeg>>

}