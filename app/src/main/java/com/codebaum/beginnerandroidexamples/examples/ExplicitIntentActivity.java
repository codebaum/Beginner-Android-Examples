package com.codebaum.beginnerandroidexamples.examples;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.codebaum.beginnerandroidexamples.FinishActivity;
import com.codebaum.beginnerandroidexamples.R;

/**
 * Created on 1/7/18.
 */
public class ExplicitIntentActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_1 = 1;
    public static final int REQUEST_CODE_2 = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_explicit_intent);

        setTitle(R.string.explicit_intent);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExplicitIntentActivity.this, HelloWorldActivity.class);
                startActivity(intent);

                // Note - you will see the following behavior on the Hello, World screen:
                //   clicking the up button will take you back to the Examples list
                //   clicking the back button will take you back to this screen.
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExplicitIntentActivity.this, FinishActivity.class);
                startActivityForResult(intent, REQUEST_CODE_1);
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExplicitIntentActivity.this, FinishActivity.class);
                startActivityForResult(intent, REQUEST_CODE_2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Activity.RESULT_OK = -1
        // Activity.RESULT_CANCELED = 0

        switch (requestCode) {
            case REQUEST_CODE_1:
                Toast.makeText(this, "requestCode: 1, resultCode: " + resultCode, Toast.LENGTH_SHORT).show();
                break;
            case REQUEST_CODE_2:
                Toast.makeText(this, "request code 2, resultCode: " + resultCode, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
