package com.codebaum.beginnerandroidexamples.examples.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.codebaum.beginnerandroidexamples.R

/**
 * Created on 1/7/18.
 */
class HelloKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_hello_world)

        val textView = findViewById<TextView>(R.id.textView)
        textView.setText(R.string.hello_kotlin)
    }
}