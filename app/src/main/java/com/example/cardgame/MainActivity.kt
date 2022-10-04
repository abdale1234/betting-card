package com.example.cardgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var playername1: TextView
    lateinit var playername2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playername1 = findViewById(R.id.spelare1text)
        playername2 = findViewById(R.id.spelare2text)

        val button = findViewById<Button>(R.id.button)


        button.setOnClickListener() {
            val playername1 = playername1.text.toString()
            val playername2 = playername2.text.toString()

            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
            intent.putExtra("Name1", playername1)
            intent.putExtra("name2", playername2)
            startActivity(intent)
        }

    }


}