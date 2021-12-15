package uz.anorgroup.doonkanorgroup.presenter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.anorgroup.doonkanorgroup.R
import uz.anorgroup.doonkanorgroup.data.ChatData
import uz.anorgroup.doonkanorgroup.databinding.ChatItemBinding

class ChatAdapter : ListAdapter<ChatData, ChatAdapter.HistoryVH>(MyDifUtils) {
    private var itemListener: ((ChatData) -> Unit)? = null

    object MyDifUtils : DiffUtil.ItemCallback<ChatData>() {
        override fun areItemsTheSame(oldItem: ChatData, newItem: ChatData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ChatData, newItem: ChatData): Boolean {
            return oldItem == newItem
        }
    }

    inner class HistoryVH(view: View) : RecyclerView.ViewHolder(view) {
        private val bind by viewBinding(ChatItemBinding::bind)

//        init {
//            bind.item.setOnClickListener {
//                getItem(absoluteAdapterPosition)?.let { it1 -> itemListener?.invoke(it1) }
//            }
//        }

        fun load() {
            val value = getItem(absoluteAdapterPosition) as ChatData
            value.let {
                bind.chatText.text = it.chatText
                bind.date.text = it.date
                bind.placeName.text = it.placeName
                bind.senderPlace.text = it.senderPlace
                bind.time.text = it.time
            }
        }
    }

    override fun onBindViewHolder(holder: HistoryVH, position: Int) {
        holder.load()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryVH =
        HistoryVH(LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false))
}