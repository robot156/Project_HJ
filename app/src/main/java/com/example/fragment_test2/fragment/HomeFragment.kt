package com.example.fragment_test.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.fragment_test2.Adapter.RecyclerAdapter_2
import com.example.fragment_test2.Adapter.ViewAdapter_3
import com.example.fragment_test2.R
import com.example.fragment_test2.RecyclerView.Beer


class HomeFragment : Fragment() {


    lateinit var event_vp: ViewPager
    var beerList = arrayListOf<Beer>()


    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_home, container, false)


        event_vp = view.findViewById(R.id.event_vp) as ViewPager
        event_vp.adapter = ViewAdapter_3(childFragmentManager)
        event_vp.setCurrentItem(0)

        val recyclerView = view.findViewById<RecyclerView>(R.id.alcohol_rv)
        val recyclerAdapter = RecyclerAdapter_2(activity!!.applicationContext, beerList)
        val layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = recyclerAdapter



        return view

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        beerList.add(Beer("recyclerview_beer_icon", "맥주1"))
        beerList.add(Beer("recyclerview_beer_icon", "맥주2"))
        beerList.add(Beer("recyclerview_beer_icon", "맥주3"))
        beerList.add(Beer("recyclerview_beer_icon", "맥주4"))
        beerList.add(Beer("recyclerview_beer_icon", "맥주5"))
        beerList.add(Beer("recyclerview_beer_icon", "맥주6"))
        beerList.add(Beer("recyclerview_beer_icon", "맥주7"))
        beerList.add(Beer("recyclerview_beer_icon", "맥주8"))
        beerList.add(Beer("recyclerview_beer_icon", "맥주9"))
        beerList.add(Beer("recyclerview_beer_icon", "맥주10"))


    }
}
