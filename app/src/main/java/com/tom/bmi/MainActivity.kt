package com.tom.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.tom.bmi.databinding.ActivityMainBinding

//The Controller, handle data changed state, UI, flow
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    val game = NumberGame()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun guess(view: View) {
        val num = binding.number.text.toString().toInt()
        val state = game.guess(num)
        val message = when(state) {
            NumberGame.GameState.BIGGER -> getString(R.string.bigger)
            NumberGame.GameState.SMALLER -> getString(R.string.smaller)
            NumberGame.GameState.BINGO -> getString(R.string.bingo)
            else -> getString(R.string.somehting_goes_wrong)
        }
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.dialog_title))
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok) ) { d, w ->
                if (game.end) game.reset()
                updateUI()
            }
            .show()
        updateUI()
    }

    private fun updateUI() {
        binding.tvCounter.text = game.counter.toString()
    }
}