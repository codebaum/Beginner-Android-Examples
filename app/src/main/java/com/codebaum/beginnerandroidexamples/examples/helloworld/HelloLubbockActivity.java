package com.codebaum.beginnerandroidexamples.examples.helloworld;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.codebaum.beginnerandroidexamples.R;
import com.codebaum.beginnerandroidexamples.examples.TitledActivity;

/**
 * Created on 1/7/18.
 */

public class HelloLubbockActivity extends TitledActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_hello_world);

        TextView textView = findViewById(R.id.textView);
        textView.setText("Hello, Lubbock!");
    }
}
