package oyo.restaurant.food.view.waiter.order.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import oyo.restaurant.food.databinding.FoodItemBinding

class MenuAdapter(data: ArrayList<MenuEnity>): RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    private var menuList = arrayListOf<MenuEnity>()

    init {
        menuList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FoodItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount() = menuList.size

    override fun onBindViewHolder(holder: MenuAdapter.ViewHolder, position: Int) {
        val menuItem = menuList[position]
        holder.binding.food = menuItem
    }

    class ViewHolder(mBinding: FoodItemBinding) : RecyclerView.ViewHolder(mBinding.root){
        var binding = mBinding

    }
}