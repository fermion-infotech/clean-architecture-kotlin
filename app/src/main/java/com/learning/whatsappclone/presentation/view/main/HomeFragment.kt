package com.learning.whatsappclone.presentation.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.learning.whatsappclone.databinding.FragmentHomeBinding
import com.learning.whatsappclone.presentation.adapter.TabPagerAdapter

class HomeFragment : Fragment() {
    private var mBinding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPagerAndTabLayout()
    }

    private fun setViewPagerAndTabLayout() {
        mBinding?.apply {
            val tabTitles = arrayOf("Chats", "Status", "Calls")
            val pagerAdapter = TabPagerAdapter(requireActivity())
            viewPager.adapter = pagerAdapter

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = tabTitles[position]
            }.attach()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}