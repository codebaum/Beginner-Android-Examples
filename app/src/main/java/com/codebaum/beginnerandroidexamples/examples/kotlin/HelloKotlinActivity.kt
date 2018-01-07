package com.codebaum.beginnerandroidexamples.examples.kotlin

import android.os.Bundle
import android.widget.TextView
import com.codebaum.beginnerandroidexamples.R
import com.codebaum.beginnerandroidexamples.examples.TitledActivity

/**
 * Created on 1/7/18.
 */
class HelloKotlinActivity : TitledActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_hello_world)

        val textView = findViewById<TextView>(R.id.textView)
        textView.setText(R.string.hello_kotlin)
    }
}