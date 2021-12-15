package uz.anorgroup.doonkanorgroup.presenter.screens.pages

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.anorgroup.doonkanorgroup.R
import uz.anorgroup.doonkanorgroup.data.OrdersInfo
import uz.anorgroup.doonkanorgroup.databinding.PageSearchBinding
import uz.anorgroup.doonkanorgroup.presenter.adapters.OrdersAdapter

@AndroidEntryPoint
class SearchPage : Fragment(R.layout.page_search) {
    private val bind by viewBinding(PageSearchBinding::bind)
    private var adapter: OrdersAdapter? = null
    private val list = ArrayList<OrdersInfo>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        load()
        adapter = OrdersAdapter()
        bind.recykler.adapter = adapter
        bind.recykler.layoutManager = LinearLayoutManager(requireContext())
        adapter?.submitList(list)
        adapter?.notifyDataSetChanged()

    }

    private fun load() {
        for (i in 0 until 7) {
            list.add(
                OrdersInfo(
                    "ООО “ТРАНСФЕРT”",
                    "08:30",
                    "Автостанция “Котельники” метро Котельники; микр...",
                    "21:30",
                    "13 м. 0 мин",
                    "Санкт - Петербург",
                    "1799 руб",
                    "7"
                )
            )
        }
    }

}