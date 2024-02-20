package com.learning.whatsappclone.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.learning.whatsappclone.presentation.view.main.CallsFragment
import com.learning.whatsappclone.presentation.view.main.ChatsFragment
import com.learning.whatsappclone.presentation.view.main.StatusFragment

class TabPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ChatsFragment()
            1 -> StatusFragment()
            2 -> CallsFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}