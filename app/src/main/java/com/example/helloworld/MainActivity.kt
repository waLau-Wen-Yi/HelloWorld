package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var rollImage :ImageView //Make an kt ImageView variable late-initialized

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN //Hide status bar
        rollImage = findViewById(R.id.dice_image) //Assign xml vector graphics

        val rollBtn :Button = findViewById(R.id.rollBtn) //Make kt variable from xml id
        val rollStatus :TextView = findViewById(R.id.rollStatus)
        rollBtn.setOnClickListener { //Make element echos
            rollDice(rollStatus, rollImage)
        }
    }

    private fun rollDice(rollStatus: TextView, rollImage: ImageView) {
        Toast.makeText(applicationContext, "Dice rolled", Toast.LENGTH_LONG).show()
        val num:Int = (1..6).random() //Make random integers
        val drawableResource = when (num) { //Assign kt variable to xml vectors with switch
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        rollImage.setImageResource(drawableResource)
        rollStatus.text = num.toString()
    }
}