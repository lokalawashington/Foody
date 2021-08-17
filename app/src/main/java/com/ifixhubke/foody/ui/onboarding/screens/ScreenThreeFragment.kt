package com.ifixhubke.foody.ui.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.ifixhubke.foody.R
import com.ifixhubke.foody.databinding.FragmentScreenThreeBinding

class ScreenThreeFragment : Fragment() {
    private lateinit var binding: FragmentScreenThreeBinding
    private lateinit var viewPager2: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentScreenThreeBinding.inflate(inflater, container, false)

        //val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)


        return binding.root
    }

}