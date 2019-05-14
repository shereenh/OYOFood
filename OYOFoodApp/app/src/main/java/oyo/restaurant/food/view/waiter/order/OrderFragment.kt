package oyo.restaurant.food.view.waiter.order


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.fragment_order.view.*
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.menu_list.view.*
import oyo.restaurant.food.R
import oyo.restaurant.food.model.utils.*
import oyo.restaurant.food.view.waiter.order.menu.MenuAdapter
import oyo.restaurant.food.view.waiter.order.menu.TitleAdapter
import oyo.restaurant.food.view.waiter.order.menu.TitleEntity
import oyo.restaurant.food.viewmodel.OrderViewModel
import java.util.*


class OrderFragment : Fragment(), AdapterView.OnItemSelectedListener {

    lateinit var rootView: View
    lateinit var mOrderViewModel: OrderViewModel
    var position = 0

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

    private fun init(){

        activity?.let {
            mOrderViewModel = ViewModelProviders.of(it).get(OrderViewModel::class.java)
        }

        val orderId = arguments!!.getLong("orderId", 0)
        rootView.fragNum.text = orderId.toString()

        rootView.tableSpinner.onItemSelectedListener = this
        val adapter = ArrayAdapter(activity, android.R.layout.simple_spinner_item, tableList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        rootView.tableSpinner.adapter = adapter

        initMenus()

        val titleList = arrayListOf(TitleEntity(getString(R.string.starter_veg), startersVegList),
                    TitleEntity(getString(R.string.starters_non_veg), startersNonVegList))
        val titleAdapter = TitleAdapter(titleList)
        rootView.titleRecycler.adapter = titleAdapter

    }

    private fun initMenus(){
        rootView.menu1.menuText.text = getString(R.string.starter_veg)
        rootView.menu1.menuRecycler.layoutManager = LinearLayoutManager(activity)
        rootView.menu1.menuRecycler.addItemDecoration(DividerItemDecoration(Objects.requireNonNull(context), DividerItemDecoration.VERTICAL))
        val adapter1 = MenuAdapter(startersVegList)
        rootView.menu1.menuRecycler.adapter = adapter1

        rootView.menu2.menuText.text = getString(R.string.starters_non_veg)
        rootView.menu2.menuRecycler.layoutManager = LinearLayoutManager(activity)
        rootView.menu2.menuRecycler.addItemDecoration(DividerItemDecoration(Objects.requireNonNull(context), DividerItemDecoration.VERTICAL))
        val adapter2 = MenuAdapter(startersNonVegList)
        rootView.menu2.menuRecycler.adapter = adapter2

        rootView.menu3.menuText.text = getString(R.string.sandwich_burger)
        rootView.menu3.menuRecycler.layoutManager = LinearLayoutManager(activity)
        rootView.menu3.menuRecycler.addItemDecoration(DividerItemDecoration(Objects.requireNonNull(context), DividerItemDecoration.VERTICAL))
        val adapter3 = MenuAdapter(sandwichList)
        rootView.menu3.menuRecycler.adapter = adapter3

        rootView.menu4.menuText.text = getString(R.string.main_course_veg)
        rootView.menu4.menuRecycler.layoutManager = LinearLayoutManager(activity)
        rootView.menu4.menuRecycler.addItemDecoration(DividerItemDecoration(Objects.requireNonNull(context), DividerItemDecoration.VERTICAL))
        val adapter4 = MenuAdapter(mainCourseVegList)
        rootView.menu4.menuRecycler.adapter = adapter4
    }

    private fun listeners(){

        rootView.removeTab.setOnClickListener{
            mOrderViewModel.removeLiveTab(arguments!!.getLong("orderId", 0))
        }


        rootView.showMenu.setOnClickListener{
            rootView.initialLinearLayout.visibility = View.GONE
            rootView.menuLinearLayout.visibility = View.VISIBLE

            mOrderViewModel.setLiveOrderTitle(arguments!!.getLong("orderId", 0), tableList[position])
        }

        rootView.editButton.setOnClickListener{
            rootView.menuLinearLayout.visibility = View.GONE
            rootView.initialLinearLayout.visibility = View.VISIBLE
        }
    }


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        Toast.makeText(activity, " selected " + Integer.toString(position), Toast.LENGTH_SHORT).show()
        rootView.showMenu.isEnabled = position!=0
        this.position = position
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
