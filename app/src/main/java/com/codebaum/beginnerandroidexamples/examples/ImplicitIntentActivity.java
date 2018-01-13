package com.codebaum.beginnerandroidexamples.examples;

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

    private static final String WEBSITE_URL = "https://www.meetup.com/Lubbock-Software-Development-Meetup";

    private static final String LOCATION_SEARCH_STRING = "geo:0,0?q=1215+Ave+J,+Lubbock,+Texas";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_implicit_intent);

        setTitle(R.string.implicit_intent);

        Button buttonWebsite = findViewById(R.id.button_website);
        buttonWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri website = Uri.parse(WEBSITE_URL);
                Intent intent = new Intent(Intent.ACTION_VIEW, website);
                startActivity(intent);
            }
        });

        Button mapsButton = findViewById(R.id.button_maps);
        mapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse(LOCATION_SEARCH_STRING);
                Intent intent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(intent);
            }
        });
    }
}
