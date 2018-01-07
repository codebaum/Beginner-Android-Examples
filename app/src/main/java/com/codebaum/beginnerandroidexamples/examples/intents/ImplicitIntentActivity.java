package com.codebaum.beginnerandroidexamples.examples.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.codebaum.beginnerandroidexamples.R;
import com.codebaum.beginnerandroidexamples.examples.TitledActivity;

/**
 * https://developer.android.com/training/basics/intents/sending.html
 */
public class ImplicitIntentActivity extends TitledActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_implicit_intent);

        Button buttonWebsite = findViewById(R.id.button_website);
        buttonWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri website = Uri.parse("https://www.meetup.com/Lubbock-Software-Development-Meetup");
                Intent intent = new Intent(Intent.ACTION_VIEW, website);
                startActivity(intent);
            }
        });

        Button mapsButton = findViewById(R.id.button_maps);
        mapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:0,0?q=1215+Ave+J,+Lubbock,+Texas");
                Intent intent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(intent);
            }
        });
    }
}
