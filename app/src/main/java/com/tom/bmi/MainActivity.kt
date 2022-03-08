package com.tom.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.tom.bmi.databinding.ActivityMainBinding

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
        AlertDialog.Builder(this)
            .setTitle("Guess")
            .setMessage(game.guess(num))
            .setPositiveButton("OK" ) {d , w ->
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