package shereen.sample.oyofoodapp.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import shereen.sample.oyofoodapp.model.utils.DATABASE_NAME
import shereen.sample.oyofoodapp.model.room.entity.StarterVeg

@Database(entities = arrayOf(StarterVeg::class), version = 1, exportSchema = false)
abstract class ODatabase: RoomDatabase() {

    abstract fun dao(): ODao

    companion object{
        private var INSTANCE: ODatabase? = null

        fun getInstance(context: Context): ODatabase? {
            if(INSTANCE == null){
                synchronized(ODatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ODatabase::class.java,
                        DATABASE_NAME
                    )
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}