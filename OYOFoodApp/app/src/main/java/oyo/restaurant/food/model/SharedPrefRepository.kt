package oyo.restaurant.food.model

import android.content.Context
import android.content.SharedPreferences
import oyo.restaurant.food.model.utils.SP_FILENAME
import oyo.restaurant.food.model.utils.SP_FIRST_TIME

abstract class SharedPrefRepository(mContext: Context) {

    private val prefs : SharedPreferences = mContext.applicationContext.getSharedPreferences(SP_FILENAME, 0)

    init {

    }


    fun checkFirstTime(): Boolean{
        val firstTime =  prefs.getBoolean(SP_FIRST_TIME, true)
        if(firstTime){
            putSharedPref(SP_FIRST_TIME, false)
        }

        return firstTime
    }

    fun putSharedPref(key: String, value: Any) {

        val editor = prefs.edit()
        if (value is String) {
            editor.putString(key, value)
        } else if (value is Int) {
            editor.putInt(key, value)
        } else if (value is Long) {

        } else if (value is Float) {

        } else if (value is Boolean) {
            editor.putBoolean(key, value)
        }
        editor.apply()
    }
}