package com.tom.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tom.bmi.databinding.ActivityMainBinding
import kotlin.concurrent.thread

//The Controller, handle data changed state, UI, flow
class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
    private lateinit var binding : ActivityMainBinding
    val fragments = mutableListOf<Fragment>()
    lateinit var database : TranDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFragments()
        binding.bottomNavBar.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.action_guess -> {
                    supportFragmentManager.beginTransaction().run {
                        replace(R.id.my_container, fragments[0])
                    }
                    true
                }
                R.id.action_bmi -> {
                    true
                }
                R.id.action_camera -> {
                    true
                }
                else -> true
            }
        }
        //insert database
        val t1 = Transaction(1, "hank", "20220315", 3000, 1)
        database = Room.databaseBuilder(this,
                            TranDatabase::class.java, "trans.db")
            .build()
        thread {
            database.transactionDao().insert(t1)
        }

    }

    private fun initFragments() {
        fragments.add(0, GuessFragment())
        /*val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.my_container, guess1to10Fragment)
        transaction.commit()*/
        //Kotlin way
        val p = Person("Hank", 66.5f, 1.7f)
        val bundle = Bundle().apply {
            putString("NAME", "Hank")
            putParcelable("PERSON", p)
        }
        fragments[0].arguments = bundle
        supportFragmentManager.beginTransaction().run {
            add(R.id.my_container, fragments[0])
            commit()
        }
    }

    fun changeFragment(num: Int) {

    }
}
