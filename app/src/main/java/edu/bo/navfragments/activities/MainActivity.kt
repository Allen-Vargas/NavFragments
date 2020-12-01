package edu.bo.navfragments.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import edu.bo.navfragments.R
import edu.bo.navfragments.fragments.AddPostFragment
import edu.bo.navfragments.fragments.HomeFragment
import edu.bo.navfragments.fragments.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val homeFragment = HomeFragment()
    private val searchFragment = SearchFragment()
    private val addPostFragment = AddPostFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(homeFragment)
        bottom_navigation.selectedItemId = R.id.home
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(homeFragment)
                R.id.addPost -> replaceFragment(addPostFragment)
                R.id.search -> replaceFragment(searchFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container,fragment)
                commit()
            }
}