package com.codebaum.beginnerandroidexamples.examples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.widget.TextView;

import com.codebaum.beginnerandroidexamples.R;

import butterknife.*;

/**
 * Basic example of updating text and utilizing string resources.
 */
public class ActivityLifecycleActivity extends AppCompatActivity {

    @BindView(R.id.tv_logs_value)
    TextView logsView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_lifecycle);

        ButterKnife.bind(this);

        setTitle(R.string.activity_lifecycle);

        addLogMessage("onCreate() called");
    }

    @Override
    protected void onStart() {
        super.onStart();

        addLogMessage("onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();

        addLogMessage("onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();

        addLogMessage("onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();

        addLogMessage("onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        addLogMessage("onDestroy() called");
    }

    @OnCheckedChanged(R.id.switch_good_behavior)
    void onGoodBehaviorCheckedChanged(SwitchCompat view) {
        addLogMessage(view.isChecked() ? "Using good behavior." : "Using bad behavior.");

        // TODO: 1/16/18 handle good behavior and rotating app 
    }

    private void addLogMessage(String message) {
        String currentLogs = logsView.getText().toString();
        StringBuilder sb = new StringBuilder(currentLogs);
        sb.append("\n");
        sb.append(message);
        String newLogs = sb.toString();
        logsView.setText(newLogs);
    }
}
