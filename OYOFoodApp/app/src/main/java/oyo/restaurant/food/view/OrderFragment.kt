package oyo.restaurant.food.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import kotlinx.android.synthetic.main.fragment_order.view.*

class OrderFragment : Fragment() {

    lateinit var rootView: View
    var tab: Int = 0

    companion object{
        fun newInstance(tab: Int): OrderFragment {
            val fragment = OrderFragment()
            val args = Bundle()
            args.putInt("someInt", tab)
            fragment.arguments = args
            return fragment
        }
    }


    @Nullable
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(oyo.restaurant.food.R.layout.fragment_order, container, false)
        tab = arguments!!.getInt("someInt", 0)

        rootView.fragNum.text = tab.toString()
        return rootView
    }




}
