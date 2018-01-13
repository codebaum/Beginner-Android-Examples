package com.codebaum.beginnerandroidexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Helper class for showing off {@link AppCompatActivity#startActivityForResult(Intent, int)}
 */
public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        ButterKnife.bind(this);

        setTitle(R.string.finish);
    }

    @OnClick(R.id.button_ok)
    void onOKButtonClicked() {
        setResult(RESULT_OK);
        finish();
    }

    @OnClick(R.id.button_cancel)
    void onCancelButtonClicked() {
        setResult(RESULT_CANCELED);
        finish();
    }
}
