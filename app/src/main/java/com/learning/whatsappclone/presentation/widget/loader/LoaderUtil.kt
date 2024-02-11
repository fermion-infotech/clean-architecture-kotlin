package com.learning.whatsappclone.presentation.widget.loader

import androidx.fragment.app.FragmentManager

object LoaderUtil {

    private const val LOADER_TAG = "LoaderFragment"

    fun showLoader(fragmentManager: FragmentManager) {
        if (fragmentManager.findFragmentByTag(LOADER_TAG) == null) {
            val loaderFragment = LoaderFragment()
            loaderFragment.show(fragmentManager, LOADER_TAG)
        }
    }

    fun hideLoader(fragmentManager: FragmentManager) {
        val loaderFragment = fragmentManager.findFragmentByTag(LOADER_TAG) as? LoaderFragment
        loaderFragment?.dismissAllowingStateLoss()
    }
}
