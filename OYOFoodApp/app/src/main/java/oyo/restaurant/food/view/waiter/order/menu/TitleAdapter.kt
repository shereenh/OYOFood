package oyo.restaurant.food.view.waiter.order.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import oyo.restaurant.food.databinding.TitleItemBinding

class TitleAdapter(data: ArrayList<TitleEntity>): RecyclerView.Adapter<TitleAdapter.ViewHolder>() {

    private var titleList = arrayListOf<TitleEntity>()

    init {
        titleList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TitleItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount() = titleList.size

    override fun onBindViewHolder(holder: TitleAdapter.ViewHolder, position: Int) {
        val titleItem = titleList[position]
        holder.binding.title = titleItem
    }

    class ViewHolder(mBinding: TitleItemBinding) : RecyclerView.ViewHolder(mBinding.root){
        var binding = mBinding
    }
}