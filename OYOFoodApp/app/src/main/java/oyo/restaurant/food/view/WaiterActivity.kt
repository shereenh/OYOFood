package oyo.restaurant.food.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_waiter.*
import com.google.android.material.tabs.TabLayout
import oyo.restaurant.food.R


class WaiterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waiter)

//        supportFragmentManager.inTransaction {
//            replace(R.id.frameLayout, OrderFragment())
//        }

        tabs.addTab(tabs.newTab().setText("1"))
        tabs.addTab(tabs.newTab().setText("2"))
        tabs.addTab(tabs.newTab().setText("3"))

        var adapter = OrderPagerAdapter(supportFragmentManager, tabs.tabCount)

        frameLayout.adapter = adapter
        frameLayout.offscreenPageLimit = 1
        frameLayout.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))


        //Bonus Code : If your tab layout has more than 2 tabs then tab will scroll other wise they will take whole width of the screen
        if (tabs.tabCount == 2) {
            tabs.tabMode = TabLayout.MODE_FIXED
        } else {
            tabs.tabMode = TabLayout.MODE_SCROLLABLE
        }

    }

    private inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.commit()
    }
}
