package com.ifixhubke.foody.ui.onboarding.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

//pass three arguments list,fragmentManager and lifecycle
//the class will extend a fragmentStateAdapter
class BlankClass (list: ArrayList<Fragment>, fragmentManager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager, lifecycle){

        //create a list variable
        private val fragmentList: ArrayList<Fragment> = list

    //return the size of the fragmentList
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    //return the position of the fragmentList
    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}