package com.ifixhubke.foody.ui.onboarding.screens

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.ifixhubke.foody.R
import com.ifixhubke.foody.databinding.FragmentScreenOneBinding
import com.ifixhubke.foody.databinding.FragmentScreenThreeBinding

class ScreenOneFragment : Fragment() {

    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_screen_one, container, false)

        val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewPager)
        button = view.findViewById(R.id.buttonNext1)

        button.setOnClickListener {
            viewPager?.currentItem = 1
        }

        return view
    }
}