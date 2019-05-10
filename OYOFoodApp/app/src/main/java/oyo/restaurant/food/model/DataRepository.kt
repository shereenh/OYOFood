package oyo.restaurant.food.model

import android.content.Context
import androidx.lifecycle.LiveData
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import oyo.restaurant.food.model.response.StarterVegResponse
import oyo.restaurant.food.model.room.ODao
import oyo.restaurant.food.model.room.ODatabase
import oyo.restaurant.food.model.room.entity.StarterVeg
import oyo.restaurant.food.model.utils.SingletonHolder

class DataRepository private constructor(mContext: Context): SharedPrefRepository(mContext) {

    companion object: SingletonHolder<DataRepository, Context>(::DataRepository)

    private var startersVegJson = mContext.applicationContext.assets.open("starters_veg.json")

    private var dao : ODao = ODatabase.getInstance(mContext)!!.dao()
    private var startersVegLive = dao.getStartersVeg()

    init {
        if(checkFirstTime()){
            insertAssetsData()
        }
    }

    fun insertAssetsData(){

        val objectString: String = startersVegJson.bufferedReader().use { it.readText() }
        val objectArray = Gson().fromJson(objectString, StarterVegResponse::class.java)

        if(objectArray!= null){
            for( item in objectArray.starters_veg){
                insertStarterVeg(StarterVeg(item.id, item.name, item.price))
            }
        }

    }

    private fun insertStarterVeg(starterVeg: StarterVeg){
        GlobalScope.launch {
            val action = async(Dispatchers.IO) {
                dao.insertStartersVeg(starterVeg)
            }
            action.await()
        }
    }

    public fun getStartersVeg():LiveData<List<StarterVeg>>{
        return dao.getStartersVeg()
    }

    //        startersVegJson.use { inputStream ->
//            JsonReader(inputStream.reader()).use{ jsonReader ->
//                val data = object : TypeToken<StarterVegResponse>(){}.type
//                val starterVegRes: StarterVegResponse = Gson().fromJson(jsonReader,data)
//            }
//        }

}