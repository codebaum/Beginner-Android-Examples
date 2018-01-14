package com.codebaum.beginnerandroidexamples.examples

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.codebaum.beginnerandroidexamples.R
import com.codebaum.beginnerandroidexamples.data.KotlinVideoGame
import com.codebaum.beginnerandroidexamples.utils.quickToast
import kotlinx.android.synthetic.main.activity_why_kotlin.*

/**
 * Created on 1/7/18.
 */
class WhyKotlinActivity : AppCompatActivity() {

    private var neverNullVar: String = "alice"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_why_kotlin)

        setTitle(R.string.why_kotlin)

        // 1. no more findViewById -- see HelloKotlinActivity

        // 2. null safety (simple example, but often we don't know where values come from)
        neverNullVar = "bob"
        textView.text = neverNullVar

        // 3. extension functions (and lambdas)
        button_toast.setOnClickListener {
            quickToast("This is my Kotlin toast!")
        }

        // 4. built-in data class implementation
        val game = KotlinVideoGame("Madden", "EA", 90)
        val updatedGame = game.copy(reviewScore = 88)
        button_video_game.setOnClickListener {
            quickToast("Review Score: ${updatedGame.reviewScore}")
        }

        // 5. smart casts
        // 6. coroutines
    }
}