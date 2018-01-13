package com.codebaum.beginnerandroidexamples.examples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.codebaum.beginnerandroidexamples.R;

/**
 * Created on 1/7/18.
 */

public class HelloWorldActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_hello_world);

        setTitle("Hello, World");

        // Change the value of the second TextView by updating the text value with a String.
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText("Hello, Lubbock!");

        // Change the value of the second TextView by updating the text value with a string resource id.
        TextView textView4 = findViewById(R.id.textView4);
        textView4.setText(R.string.hello_lubbock);
    }
}
