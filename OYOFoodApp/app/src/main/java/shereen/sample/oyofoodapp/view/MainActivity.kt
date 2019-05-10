package shereen.sample.oyofoodapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import shereen.sample.oyofoodapp.R
import shereen.sample.oyofoodapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var mViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

}
