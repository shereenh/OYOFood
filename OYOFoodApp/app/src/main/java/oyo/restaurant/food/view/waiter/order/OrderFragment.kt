package oyo.restaurant.food.view.waiter.order


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.fragment_order.*
import kotlinx.android.synthetic.main.fragment_order.view.*
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.sandwich_burger_menu.view.*
import kotlinx.android.synthetic.main.starter_non_veg_menu.view.*
import kotlinx.android.synthetic.main.starter_veg_menu.view.*
import oyo.restaurant.food.view.waiter.order.menu.MenuAdapter
import oyo.restaurant.food.view.waiter.order.menu.MenuEnity
import oyo.restaurant.food.view.waiter.order.table.TableAdapter
import oyo.restaurant.food.view.waiter.order.table.TableEntity
import java.util.*


class OrderFragment : Fragment(), AdapterView.OnItemSelectedListener {

    lateinit var rootView: View

    companion object{
        fun newInstance(orderId: Long): OrderFragment {
            val fragment = OrderFragment()
            val args = Bundle()
            args.putLong("orderId", orderId)
            fragment.arguments = args
            return fragment
        }
    }

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(oyo.restaurant.food.R.layout.fragment_order, container, false)

        init()
        listeners()
        return rootView
    }

    fun init(){

        val orderId = arguments!!.getLong("orderId", 0)
        rootView.fragNum.text = orderId.toString()

        val tableList = arrayListOf("None","Table 1", "Table 2", "Table 3", "Table 4", "Table 5")
        rootView.tableSpinner.onItemSelectedListener = this
        val adapter = ArrayAdapter(activity, android.R.layout.simple_spinner_item, tableList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        rootView.tableSpinner.adapter = adapter

        initMenus()

    }

    fun initMenus(){
        rootView.menuRecycler_1.layoutManager = LinearLayoutManager(activity)
        rootView.menuRecycler_1.addItemDecoration(DividerItemDecoration(Objects.requireNonNull(context), DividerItemDecoration.VERTICAL))
        val startersVegList = arrayListOf<MenuEnity>(MenuEnity("Mushroom Manchurian"),
            MenuEnity("Veg Manchurian"), MenuEnity("Gobi Chilli"))
        val adapter1 = MenuAdapter(startersVegList)
        rootView.menuRecycler_1.adapter = adapter1

        rootView.menuRecycler_2.layoutManager = LinearLayoutManager(activity)
        rootView.menuRecycler_2.addItemDecoration(DividerItemDecoration(Objects.requireNonNull(context), DividerItemDecoration.VERTICAL))
        val startersNonVegList = arrayListOf<MenuEnity>(MenuEnity("Chicken 65"),
            MenuEnity("Chilli Chicken"), MenuEnity("Chicken Kebab"))
        val adapter2 = MenuAdapter(startersNonVegList)
        rootView.menuRecycler_2.adapter = adapter2

        rootView.menuRecycler_3.layoutManager = LinearLayoutManager(activity)
        rootView.menuRecycler_3.addItemDecoration(DividerItemDecoration(Objects.requireNonNull(context), DividerItemDecoration.VERTICAL))
        val sandwichList = arrayListOf<MenuEnity>(MenuEnity("Veg Sandwich"),
            MenuEnity("Chicken Sandwich"), MenuEnity("Stuffed Veg Sandwich"))
        val adapter3 = MenuAdapter(sandwichList)
        rootView.menuRecycler_3.adapter = adapter3
    }

    fun listeners(){
        rootView.showMenu.setOnClickListener{
            rootView.initialLinearLayout.visibility = View.GONE
            rootView.menuLinearLayout.visibility = View.VISIBLE
        }

        rootView.editButton.setOnClickListener{
            rootView.menuLinearLayout.visibility = View.GONE
            rootView.initialLinearLayout.visibility = View.VISIBLE
        }
    }


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        Toast.makeText(activity, " selected " + Integer.toString(position), Toast.LENGTH_SHORT).show()
        rootView.showMenu.isEnabled = position!=0
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

}



//        tableRecycler.addItemDecoration(
//            DividerItemDecoration(
//                Objects.requireNonNull(context),
//                DividerItemDecoration.VERTICAL
//            ))

//        rootView.tableRecycler.layoutManager = LinearLayoutManager(activity,  LinearLayoutManager.HORIZONTAL, false)
//
//
//        val tableList = arrayListOf(TableEntity("T1"), TableEntity("t2"),
//            TableEntity("t3"), TableEntity("t4"), TableEntity("t5"), TableEntity("t6"),
//            TableEntity("t7"), TableEntity("t8")
//        )
//        var adapter = TableAdapter(tableList)
//        rootView.tableRecycler.adapter = adapter
