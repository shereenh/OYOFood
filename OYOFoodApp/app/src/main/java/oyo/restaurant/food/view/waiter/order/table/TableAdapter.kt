package oyo.restaurant.food.view.waiter.order.table

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import oyo.restaurant.food.R
import oyo.restaurant.food.databinding.TableItemBinding

class TableAdapter(data: ArrayList<TableEntity>): RecyclerView.Adapter<TableAdapter.ViewHolder>() {

    private var tableList = arrayListOf<TableEntity>()

    init {
        tableList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val inflatedView = parent.inflate(R.layout.table_item, false)  //executes the extension function
        val inflater = LayoutInflater.from(parent.context)
        val binding  = TableItemBinding.inflate(inflater)
        return TableAdapter.ViewHolder(binding)
    }

    override fun getItemCount() = tableList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tableItem = tableList[position]
        holder.binding.table = tableItem
    }


    class ViewHolder(mBinding: TableItemBinding): RecyclerView.ViewHolder(mBinding.root){
        var binding = mBinding
    }
}