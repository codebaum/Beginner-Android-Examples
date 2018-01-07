package com.codebaum.beginnerandroidexamples.examples.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.codebaum.beginnerandroidexamples.R;

/**
 * https://developer.android.com/training/basics/intents/sending.html
 */
public class ImplicitIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_implicit_intent);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String meetupUrl = "https://www.meetup.com/Lubbock-Software-Development-Meetup";
                Uri meetupUri = Uri.parse(meetupUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, meetupUri);
                startActivity(intent);

                // Pay attention to the Up/Back actions after clicking this button.
            }
        });
    }
}
