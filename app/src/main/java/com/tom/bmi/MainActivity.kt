package com.tom.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.tom.bmi.databinding.ActivityMainBinding

//The Controller, handle data changed state, UI, flow
class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
    private lateinit var binding : ActivityMainBinding
    val viewModel by viewModels<GuessViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.counter.observe(this) {
            binding.tvCounter.setText(it.toString())
        }
        viewModel.gameState.observe(this) { state ->
            val message = when(state) {
                GuessViewModel.GameState.BIGGER -> getString(R.string.bigger)
                GuessViewModel.GameState.SMALLER -> getString(R.string.smaller)
                GuessViewModel.GameState.BINGO -> getString(R.string.bingo)
                GuessViewModel.GameState.INIT -> "START!"
                else -> getString(R.string.somehting_goes_wrong)
            }
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.dialog_title))
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok) ) { d, w ->
                    if (state == GuessViewModel.GameState.BINGO)
                        viewModel.reset()
                }
                .show()
        }
    }

    fun guess(view: View) {
        val num = binding.number.text.toString().toInt()
        viewModel.guess(num)
    }
}
