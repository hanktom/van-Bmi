package com.tom.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.tom.bmi.databinding.ActivityMainBinding

//The Controller, handle data changed state, UI, flow
class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
    private lateinit var binding : ActivityMainBinding
    val fragments = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFragments()
        binding.bottomNavBar.setOnItemReselectedListener { item ->
            when(item.itemId) {
                R.id.action_guess -> {
                    supportFragmentManager.beginTransaction().run {
                        replace(R.id.my_container, fragments[0])
                    }
                }
                R.id.action_bmi -> {

                }
                R.id.action_camera -> {

                }
            }
        }
    }

    private fun initFragments() {
        fragments.add(0, GuessFragment())
        /*val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.my_container, guess1to10Fragment)
        transaction.commit()*/
        //Kotlin way
        supportFragmentManager.beginTransaction().run {
            add(R.id.my_container, fragments[0])
            commit()
        }


    }

}
