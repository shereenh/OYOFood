package oyo.restaurant.food.view.waiter.order

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import oyo.restaurant.food.view.waiter.order.OrderEntity

class OrderPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {

//    var mFragmentList = mutableListOf<Fragment>()
//    var mFragmentTitleList = mutableListOf<String>()

    var mTabs = mutableListOf<OrderEntity>()

    override fun getItem(position: Int): Fragment {
        return mTabs[position].fragment
    }

    override fun getCount(): Int {
        return mTabs.size
    }

//    fun addFragment(fragment: Fragment, title: String){
//        mFragmentList.add(fragment)
//        mFragmentTitleList.add(title)
//    }

    fun addTab(order: OrderEntity){
        mTabs.add(order)
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        return mTabs[position].title
    }
}