package uz.anorgroup.doonkanorgroup.presenter.screens

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.anorgroup.doonkanorgroup.R
import uz.anorgroup.doonkanorgroup.databinding.ScreenTripDetalisBinding

@AndroidEntryPoint
class TripDetalisScreen : Fragment(R.layout.screen_trip_detalis) {
    private val bind by viewBinding(ScreenTripDetalisBinding::bind)
}