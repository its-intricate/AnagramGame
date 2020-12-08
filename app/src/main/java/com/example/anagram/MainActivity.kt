package com.example.anagram

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity: AppCompatActivity() {

    var scrambledWord: TextView? = null
    var inputtedWord: EditText? = null
    var validate: Button? = null
    var correctWord: String? = null
    var currentWord: String? = null
    val anagram = Anagram()
    var targetLock: ImageView? = null
    var targetUnlock: ImageView? = null
    var count: Int = 0
    var lockId = intArrayOf(R.id.lock1, R.id.lock2, R.id.lock3 )
    var unlockId = intArrayOf(R.id.unlock1, R.id.unlock2, R.id.unlock3 )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scrambledWord = findViewById<View>(R.id.textView) as TextView
        inputtedWord = findViewById<View>(R.id.editText) as EditText
        validate = findViewById<View>(R.id.submit_button) as Button
        validate!!.setOnClickListener{validate()}
        newGame()
    }

    private fun validate() {
        val w: String = inputtedWord!!.text.toString().toUpperCase(Locale.ROOT)
        if (correctWord.equals(w)) {
            Toast.makeText(this, "Congratulations ! You found the word $correctWord", Toast.LENGTH_LONG).show()
            targetLock = findViewById<View>(lockId[count]) as ImageView
            targetUnlock = findViewById<View>(unlockId[count]) as ImageView
            targetLock!!.visibility = View.INVISIBLE
            targetUnlock!!.visibility = View.VISIBLE
            count++
            if (count <= 2) {
                newGame()
            } else {
                var endGame = findViewById<View>(R.id.end) as TextView
                inputtedWord!!.visibility = View.GONE
                validate!!.visibility = View.GONE
                endGame.visibility = View.VISIBLE
            }
        } else {
            Toast.makeText(this, "Retry !", Toast.LENGTH_SHORT).show()
            inputtedWord!!.setText("")
        }
    }


    private fun newGame() {
        correctWord = anagram.randomWord()
        if (correctWord.equals(currentWord)){
            newGame()
        }
        currentWord = correctWord
        scrambledWord!!.text = anagram.shuffleWord(correctWord!!)
        inputtedWord!!.setText("")
    }
}
