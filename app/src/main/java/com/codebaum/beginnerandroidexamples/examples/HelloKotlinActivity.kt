package com.codebaum.beginnerandroidexamples.examples

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.codebaum.beginnerandroidexamples.R

// similar to ButterKnife (view injection library for java)
import kotlinx.android.synthetic.main.activity_example_hello_world.*

/**
 * Created on 1/7/18.
 */
class HelloKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_hello_world)

        setTitle(R.string.hello_kotlin)

        // where is the findViewById? See "apply plugin: 'kotlin-android-extensions'" in app build.gradle
        textView.setText(R.string.hello_kotlin)
        textView2.setText(R.string.hello_kotlin)
        textView3.setText(R.string.hello_kotlin)
        textView4.setText(R.string.hello_kotlin)
    }
}