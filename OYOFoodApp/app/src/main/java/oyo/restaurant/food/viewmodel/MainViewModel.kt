package oyo.restaurant.food.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import oyo.restaurant.food.model.DataRepository

open class MainViewModel(application: Application):AndroidViewModel(application) {

    private val mRepository : DataRepository = DataRepository.getInstance(application.applicationContext)


}