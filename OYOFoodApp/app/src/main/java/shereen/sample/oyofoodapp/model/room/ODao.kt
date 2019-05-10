package shereen.sample.oyofoodapp.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import shereen.sample.oyofoodapp.model.room.entity.StarterVeg
import shereen.sample.oyofoodapp.model.utils.TABLE_STARTERS_VEG

@Dao
interface ODao {

    @Insert(onConflict = REPLACE)
    fun insertStartersVeg(starterVeg: StarterVeg)

    @Query("SELECT * FROM " + TABLE_STARTERS_VEG)
    fun getStartersVeg():LiveData<List<StarterVeg>>

}