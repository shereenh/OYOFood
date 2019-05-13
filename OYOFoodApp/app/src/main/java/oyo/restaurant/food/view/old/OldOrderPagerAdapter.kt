package oyo.restaurant.food.view.old

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class OldOrderPagerAdapter(fm: FragmentManager, mNumOfTabs: Int): FragmentStatePagerAdapter(fm) {

    var numOfTabs: Int = mNumOfTabs

    override fun getItem(position: Int): Fragment {
        return OldOrderFragment.newInstance(position)
    }

    override fun getCount(): Int {
        return numOfTabs
    }
}