package com.example.fragment_test2.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.fragment_test2.fragment.Sub_Fragment_1
import com.example.fragment_test2.fragment.Sub_Fragment_2
import com.example.fragment_test2.fragment.Sub_Fragment_3

// 상단 뷰페이저
@Suppress("DEPRECATION")
class ViewAdapter_3(fm : FragmentManager)  : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {

        return if(position == 0){
            Sub_Fragment_1()
        } else if(position == 1) {
            Sub_Fragment_2()
        } else {
            Sub_Fragment_3()
        }

    }

    override fun getCount(): Int {
        return 3
    }
}


