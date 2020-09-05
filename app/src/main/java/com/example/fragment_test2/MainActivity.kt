package com.example.fragment_test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.fragment_test.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottom_navi.setOnNavigationItemSelectedListener(this)

    }


    override fun onNavigationItemSelected(p0: MenuItem): Boolean {


        when (p0.itemId) {
            R.id.home -> {
                var homeFragment = HomeFragment()
                supportFragmentManager.beginTransaction().replace(R.id.framelayout, homeFragment)
                    .commit()
                return true
            }
            R.id.search -> {
                var searchFragment = SearchFragment()
                supportFragmentManager.beginTransaction().replace(R.id.framelayout, searchFragment)
                    .commit()
                return true
            }
            R.id.rating -> {
                var ratingFragment = RatingFragment()
                supportFragmentManager.beginTransaction().replace(R.id.framelayout, ratingFragment)
                    .commit()
                return true
            }
            R.id.social -> {
                var socialFragment = SocialFragment()
                supportFragmentManager.beginTransaction().replace(R.id.framelayout, socialFragment)
                    .commit()
                return true
            }
            R.id.mypage -> {
                var mypageFragment = MypageFragment()
                supportFragmentManager.beginTransaction().replace(R.id.framelayout, mypageFragment)
                    .commit()
                return true
            }


        }

        return false
    }


}
