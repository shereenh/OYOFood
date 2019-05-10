package shereen.sample.oyofoodapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import shereen.sample.oyofoodapp.model.DataRepository

class MainViewModel(application: Application):AndroidViewModel(application) {

    private val mRepository : DataRepository = DataRepository.getInstance(application.applicationContext)


}