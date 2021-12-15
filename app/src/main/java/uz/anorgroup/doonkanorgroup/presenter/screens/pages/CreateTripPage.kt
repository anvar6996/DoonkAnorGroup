package uz.anorgroup.doonkanorgroup.presenter.screens.pages

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.anorgroup.doonkanorgroup.R
import uz.anorgroup.doonkanorgroup.databinding.PagePostBinding

@AndroidEntryPoint
class CreateTripPage : Fragment(R.layout.page_post) {
    private val bind by viewBinding(PagePostBinding::bind)
}