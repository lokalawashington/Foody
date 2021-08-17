package com.ifixhubke.foody.ui.onboarding.viewpagerfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.ifixhubke.foody.R
import com.ifixhubke.foody.ui.onboarding.adapter.BlankClass
import com.ifixhubke.foody.ui.onboarding.screens.ScreenOneFragment
import com.ifixhubke.foody.ui.onboarding.screens.ScreenThreeFragment
import com.ifixhubke.foody.ui.onboarding.screens.ScreenTwoFragment

class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)


        //create a list of fragments

        val fragmentList = arrayListOf<Fragment>(
            ScreenOneFragment(),
            ScreenTwoFragment(),
            ScreenThreeFragment()
        )

        //create an adapter variable then initialize the viewPagerAdapter
        val viewPager: ViewPager2 = view.findViewById(R.id.viewPager)

        val adapter =  BlankClass(

            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        viewPager?.adapter = adapter

        return view
    }
}