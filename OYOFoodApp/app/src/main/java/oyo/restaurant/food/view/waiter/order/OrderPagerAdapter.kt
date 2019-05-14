package oyo.restaurant.food.view.waiter.order

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import oyo.restaurant.food.view.waiter.order.OrderEntity

class OrderPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {

    var mTabs = mutableListOf<OrderEntity>()

    override fun getItem(position: Int): Fragment {
        return mTabs[position].fragment!!
    }

    override fun getCount(): Int {
        return mTabs.size
    }

    fun addTab(order: OrderEntity){
        mTabs.add(order)
    }

    fun clearTabs(){
        mTabs.clear()
    }

    fun setTab(tabId: Long, title: String){
        for(i in 0 until mTabs.size){
            if(tabId.equals(mTabs[i].id)){
                mTabs[i].title = title
            }
        }
    }

    fun removeTab(tabId: Long){

        var index = -1
        for(i in 0 until mTabs.size){
            if(tabId.equals(mTabs[i].id)){
                index = i
            }
        }

        if(index != -1){
            mTabs.removeAt(index)
        }
        notifyDataSetChanged()
    }

//    fun removeFragment(position: Int): CharSequence {
//        mFragmentTitleList.remove(position)
//        mFragmentList.remove(position)
//        notifyDatasetChanged()
//    }


    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        return mTabs[position].title
    }
}