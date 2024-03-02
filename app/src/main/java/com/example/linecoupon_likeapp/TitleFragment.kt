package com.example.linecoupon_likeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.linecoupon_likeapp.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    companion object {
        fun newInstance() = TitleFragment()
    }

    private var _binding: FragmentTitleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTitleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.replaceFragment(R.id.container, CouponLikeBeforeFragment())
        }

        binding.settingButton.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.replaceFragment(R.id.container, SettingFragment())
        }
    }
}