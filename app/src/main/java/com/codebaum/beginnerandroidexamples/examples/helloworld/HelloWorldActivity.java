package com.codebaum.beginnerandroidexamples.examples.helloworld;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.codebaum.beginnerandroidexamples.R;
import com.codebaum.beginnerandroidexamples.examples.TitledActivity;

/**
 * Created on 1/7/18.
 */

public class HelloWorldActivity extends TitledActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_hello_world);
    }
}
