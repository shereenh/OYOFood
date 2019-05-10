package shereen.sample.oyofoodapp.model.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import shereen.sample.oyofoodapp.model.utils.TABLE_STARTERS_VEG

@Entity(tableName = TABLE_STARTERS_VEG)
class StarterVeg(
    @PrimaryKey
    var id: String,
    var name: String,
    var price: Int)