package com.codebaum.beginnerandroidexamples.examples.helloworld;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.codebaum.beginnerandroidexamples.R;

/**
 * https://developer.android.com/training/basics/supporting-devices/languages.html
 */
public class HelloResourcesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_hello_resources);
    }
}
