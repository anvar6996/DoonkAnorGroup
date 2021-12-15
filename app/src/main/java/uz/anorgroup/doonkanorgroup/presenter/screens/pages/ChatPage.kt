package uz.anorgroup.doonkanorgroup.presenter.screens.pages

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.anorgroup.doonkanorgroup.R
import uz.anorgroup.doonkanorgroup.databinding.ChatPageBinding

@AndroidEntryPoint
class ChatPage : Fragment(R.layout.chat_page) {
    private val bind by viewBinding(ChatPageBinding::bind)


}