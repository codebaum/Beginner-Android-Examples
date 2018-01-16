package com.codebaum.beginnerandroidexamples.examples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.codebaum.beginnerandroidexamples.R;

/**
 * Basic example of updating text and utilizing string resources.
 */
public class HelloWorldActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_hello_world);

        setTitle(R.string.hello_world);

        // Change the value of the second TextView by updating the text value with a String.
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText("Hello, Lubbock!"); // we see a warning because this should be a localized string.

        // Change the value of the second TextView by updating the text value with a string resource id.
        TextView textView4 = findViewById(R.id.textView4);
        textView4.setText(R.string.hello_lubbock);

        // same as above, except we get the string from our resources first and then pass it to the TextView.
        String text = getResources().getString(R.string.hello_lubbock);
        textView4.setText(text);
    }
}
