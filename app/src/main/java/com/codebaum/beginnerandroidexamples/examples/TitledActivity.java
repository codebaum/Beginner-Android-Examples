package com.codebaum.beginnerandroidexamples.examples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created on 1/7/18.
 */

public abstract class TitledActivity extends AppCompatActivity {

    public static final String KEY_TITLE_RES_ID = "KEY_TITLE_RES_ID";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int title = getIntent().getIntExtra(KEY_TITLE_RES_ID, -1);
        if (title != -1) {
            setTitle(title);
        } else {
            Toast.makeText(this, "Unable to set title. Closing activity.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
