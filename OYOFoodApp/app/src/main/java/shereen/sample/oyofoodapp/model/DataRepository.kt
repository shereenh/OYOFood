package shereen.sample.oyofoodapp.model

import android.content.Context
import android.util.JsonReader
import android.util.Log
import androidx.lifecycle.LiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import shereen.sample.oyofoodapp.model.response.StarterVegResponse
import shereen.sample.oyofoodapp.model.room.ODao
import shereen.sample.oyofoodapp.model.room.ODatabase
import shereen.sample.oyofoodapp.model.room.entity.StarterVeg
import shereen.sample.oyofoodapp.model.utils.LOGGER
import shereen.sample.oyofoodapp.model.utils.SingletonHolder

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