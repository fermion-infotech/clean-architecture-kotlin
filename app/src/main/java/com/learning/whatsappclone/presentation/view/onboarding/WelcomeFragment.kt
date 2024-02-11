package com.learning.whatsappclone.presentation.view.onboarding

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.learning.whatsappclone.databinding.FragmentWelcomeBinding
import com.learning.whatsappclone.presentation.widget.loader.LoaderUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragment : Fragment() {

    private var mBinding: FragmentWelcomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerListeners()
    }

    private fun registerListeners() {
        mBinding?.apply {
            agreeAndContinue.setOnClickListener {
                LoaderUtil.showLoader(childFragmentManager)
                Handler(Looper.getMainLooper()).postDelayed({
                    LoaderUtil.hideLoader(childFragmentManager)
                    it.findNavController()
                        .navigate(WelcomeFragmentDirections.actionWelcomeFragmentToMobileNumberFragment())
                }, 3000)

            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}