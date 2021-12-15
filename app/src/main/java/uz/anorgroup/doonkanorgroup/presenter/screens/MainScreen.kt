package uz.anorgroup.doonk.presenter.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.anorgroup.doonk.R
import uz.anorgroup.doonk.databinding.MainScreenBinding
import uz.anorgroup.doonkanorgroup.presenter.adapters.PageAdapter

class MainScreen : Fragment(R.layout.main_screen) {
    private val pageAdapter: PageAdapter? = null

    private val bind by viewBinding(MainScreenBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}