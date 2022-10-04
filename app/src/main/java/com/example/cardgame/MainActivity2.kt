package com.example.cardgame

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    lateinit var ivcardleft: ImageView
    lateinit var ivcardright: ImageView
    val listOfcards = mutableListOf<Card>()
    lateinit var scoreViewleft: TextView
    lateinit var scoreViewright: TextView
    var  scoreLeft = 0
    var scoreright = 0
    var leftcard : Card? = null
    var rightcard :Card? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        ivcardleft = findViewById(R.id.ivcardleft)
        ivcardright = findViewById(R.id.ivcardright)
        val deal = findViewById<Button>(R.id.Deal)
        scoreViewleft =findViewById(R.id.scoreleft)
        scoreViewright= findViewById(R.id.scoreright)

        val intent = intent
        val name1 = intent.getStringExtra("Name1")
        val name2 = intent.getStringExtra("name2")

        val playername1 = findViewById<TextView>(R.id.name1)
        val playername2 = findViewById<TextView>(R.id.name2)

        playername1.text ="name:"+name1
        playername2.text= "name:"+name2

        deck()




        deal.setOnClickListener() {
            rndcardivcardright()
            rndcardivcardleft()
            score()



        }


    }
    fun score(){
        if (leftcard == null) {
            return
        }
        if (rightcard==null){
            return
        }
        if (leftcard!!.value >= rightcard!!.value){
            scoreLeft++
           scoreViewleft.text = scoreLeft.toString()

        }
        else{
            if ( rightcard!!.value >=leftcard!!.value){
                scoreright++
               scoreViewright.text=scoreright.toString()
            }
        }


    }



    fun rndcardivcardleft() {
        val randomindex = Random.nextInt(listOfcards.size)

        leftcard = listOfcards[randomindex]

        ivcardleft.setImageResource(leftcard!!.image)

    }
    fun rndcardivcardright() {
        val randomindex = Random.nextInt(listOfcards.size)

        rightcard = listOfcards[randomindex]

        ivcardright.setImageResource(rightcard!!.image)
    }

    open class Card(var value: Int,var  image: Int)

    fun deck() {

        val card2 = Card(1, R.drawable.cards_2_diamond_svg)
        val card3 = Card(2, R.drawable._19px_playing_card_club_3_svg)
        val card4 = Card(3, R.drawable._19px_playing_card_club_4_svg)
        val card5 = Card(4, R.drawable._200px_playing_card_club_5_svg)
        val card6 = Card(5, R.drawable.playing_card_spade_6_svg)
        val card7 = Card(6, R.drawable._200px_playing_card_spade_7_svg)
        val card8 = Card(7, R.drawable.playing_card_spade_8_svg)
        val card9 = Card(8, R.drawable._200px_playing_card_club_9_svg)
        val card10 = Card(9, R.drawable._200px_playing_card_spade_10_svg)

        listOfcards.add(card2)
        listOfcards.add(card3)
        listOfcards.add(card4)
        listOfcards.add(card5)
        listOfcards.add(card6)
        listOfcards.add(card7)
        listOfcards.add(card8)
        listOfcards.add(card9)
        listOfcards.add(card10)

        listOfcards.shuffle()


    }
}




