package com.codebaum.beginnerandroidexamples.utils

import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created on 1/14/18.
 */
fun AppCompatActivity.quickToast(message : String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}