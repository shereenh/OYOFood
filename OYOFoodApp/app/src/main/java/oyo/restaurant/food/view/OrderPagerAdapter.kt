package oyo.restaurant.food.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class OrderPagerAdapter(fm: FragmentManager, mNumOfTabs: Int): FragmentStatePagerAdapter(fm) {

    var numOfTabs: Int = mNumOfTabs

    override fun getItem(position: Int): Fragment {
        return OrderFragment.newInstance(position)
    }

    override fun getCount(): Int {
        return numOfTabs
    }
}