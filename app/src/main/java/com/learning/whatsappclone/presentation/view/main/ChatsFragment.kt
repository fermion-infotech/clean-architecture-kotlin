package com.learning.whatsappclone.presentation.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.learning.whatsappclone.data.model.main.Chat
import com.learning.whatsappclone.data.utils.Resource
import com.learning.whatsappclone.databinding.FragmentChatsBinding
import com.learning.whatsappclone.presentation.adapter.ChatsRVAdapter
import com.learning.whatsappclone.presentation.viewmodel.MainViewModel
import com.learning.whatsappclone.presentation.widget.loader.LoaderUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatsFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModels()
    private var mBinding: FragmentChatsBinding? = null
    private var chatsRVAdapter : ChatsRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentChatsBinding.inflate(inflater,container,false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getChatsAndRegisterObserver()
    }

    private fun getChatsAndRegisterObserver(){
        /**
         * Registering observer which listens to getChats() api call
         */
        mainViewModel.chats.observe(viewLifecycleOwner){
            when(it){
                is Resource.Loading->{
                    println("Inside loading")
                    LoaderUtil.showLoader(childFragmentManager)
                }

                is Resource.Success->{
                    println("Inside success")
                    LoaderUtil.hideLoader(childFragmentManager)
                    setChatList(it.data?.chats)
                }

                is Resource.Error->{
                    LoaderUtil.hideLoader(childFragmentManager)
                }

                else -> {
                    LoaderUtil.hideLoader(childFragmentManager)
                }
            }
        }

        /**
         * getChats() api call
         */
        mainViewModel.getChats()
    }

    private fun setChatList(chats: List<Chat>?) {
        mBinding?.apply {
            chatsRV.layoutManager = LinearLayoutManager(requireActivity())
            chatsRV.addItemDecoration(
                DividerItemDecoration(
                    chatsRV.context,
                    DividerItemDecoration.VERTICAL
                )
            )
            chatsRVAdapter = chats?.let { ChatsRVAdapter(it) }
            chatsRV.adapter = chatsRVAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
        chatsRVAdapter = null
    }

}