package com.codebaum.beginnerandroidexamples.examples

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.codebaum.beginnerandroidexamples.R

// similar to ButterKnife (view injection library for java)
import kotlinx.android.synthetic.main.activity_example_hello_world.*

/**
 * Basic example of using Kotlin code.
 */
class HelloKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_hello_world)

        setTitle(R.string.hello_kotlin)

        // where is the findViewById? See "apply plugin: 'kotlin-android-extensions'" in app build.gradle
        textView2.setText(R.string.hello_kotlin)

        // using property access syntax, syntactic sugar for getters/setters
        val text = resources.getString(R.string.hello_kotlin)
        textView4.text = text
    }
}