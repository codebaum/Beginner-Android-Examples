package com.codebaum.beginnerandroidexamples.examples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

import com.codebaum.beginnerandroidexamples.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Basic example of updating text and utilizing string resources.
 */
public class BasicViewsActivity extends AppCompatActivity {

    @BindView(R.id.tv_result_email)
    TextView emailResult;

    @BindView(R.id.tv_result_password)
    TextView passwordResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_views);

        setTitle(R.string.basic_views);

        final TextInputLayout emailInput = findViewById(R.id.input_email);
        final TextInputLayout passwordInput = findViewById(R.id.input_password);
        Button signInButton = findViewById(R.id.btn_sign_in);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getEditText().getText().toString();
                String password = passwordInput.getEditText().getText().toString();

                emailResult.setText(email);
                passwordResult.setText(password);
            }
        });
    }

    @OnClick(R.id.tv_header)
    void onHeaderClicked() {
        Toast.makeText(this, "You clicked the title!", Toast.LENGTH_LONG).show();
    }
}
