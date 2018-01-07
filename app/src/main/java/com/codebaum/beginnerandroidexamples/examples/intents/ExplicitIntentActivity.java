package com.codebaum.beginnerandroidexamples.examples.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.codebaum.beginnerandroidexamples.R;
import com.codebaum.beginnerandroidexamples.examples.TitledActivity;
import com.codebaum.beginnerandroidexamples.examples.helloworld.HelloWorldActivity;

/**
 * Created on 1/7/18.
 */
public class ExplicitIntentActivity extends TitledActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_explicit_intent);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExplicitIntentActivity.this, HelloWorldActivity.class);
                intent.putExtra(KEY_TITLE_RES_ID, R.string.hello_world);
                startActivity(intent);

                // Pay attention to the Up/Back actions after clicking this button.
            }
        });
    }
}
