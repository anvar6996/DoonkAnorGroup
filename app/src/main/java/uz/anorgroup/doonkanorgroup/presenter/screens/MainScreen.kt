package uz.anorgroup.doonkanorgroup.presenter.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.anorgroup.doonkanorgroup.R
import uz.anorgroup.doonkanorgroup.databinding.ScreenMainBinding
import uz.anorgroup.doonkanorgroup.presenter.adapters.PageAdapter

@AndroidEntryPoint
class MainScreen : Fragment(R.layout.screen_main) {
    private val bind by viewBinding(ScreenMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pageAdapter = PageAdapter(childFragmentManager, lifecycle)
        bind.pager.adapter = pageAdapter

        bind.pager.isUserInputEnabled = false
        bind.tablayout.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.trip -> {
                    bind.pager.setCurrentItem(0, true)
                }
                R.id.search -> {
                    bind.pager.setCurrentItem(1, true)
                }
                R.id.create -> {
                    bind.pager.setCurrentItem(2, true)
                }
                R.id.chat -> {
                    bind.pager.setCurrentItem(3, true)
                }
                R.id.profile -> {
                    bind.pager.setCurrentItem(4, true)
                }
            }
            return@setOnItemSelectedListener true
        }
    }
}