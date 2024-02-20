package com.learning.whatsappclone.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.learning.whatsappclone.R
import com.learning.whatsappclone.data.model.main.Chat
import com.learning.whatsappclone.databinding.ViewChatBinding

class ChatsRVAdapter(
    private val chatList: List<Chat>
) :
    RecyclerView.Adapter<ChatsRVAdapter.ChatViewHolder>() {
    inner class ChatViewHolder(private val binding: ViewChatBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(chats: Chat) {

            binding.apply {
                chat = chats
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.view_chat,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chat = chatList[position]
        holder.bind(chat)
    }

    override fun getItemCount(): Int {
        return chatList.size
    }
}