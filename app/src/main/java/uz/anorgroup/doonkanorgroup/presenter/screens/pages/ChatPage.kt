package uz.anorgroup.doonkanorgroup.presenter.screens.pages

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.anorgroup.doonkanorgroup.R
import uz.anorgroup.doonkanorgroup.data.ChatData
import uz.anorgroup.doonkanorgroup.databinding.PageChatBinding
import uz.anorgroup.doonkanorgroup.presenter.adapters.ChatAdapter

@AndroidEntryPoint
class ChatPage : Fragment(R.layout.page_chat) {
    private val bind by viewBinding(PageChatBinding::bind)
    private var adapter: ChatAdapter? = null
    private val list = ArrayList<ChatData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        load()
        adapter = ChatAdapter()
        bind.recykler.adapter = adapter
        bind.recykler.layoutManager = LinearLayoutManager(requireContext())
        adapter?.submitList(list)
        adapter?.notifyDataSetChanged()

    }

    private fun load() {
        for (i in 0 until 12) {
            list.add(
                ChatData(
                    "23.06.2021", "22:16",
                    "Муроджон Турсунов",
                    "Москва", "Санкт - Петербург", "Нархи нечпул арзонрок киберасизми?"
                )
            )
        }
    }
}