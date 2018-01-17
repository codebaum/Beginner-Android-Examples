package com.codebaum.beginnerandroidexamples.examples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.widget.TextView;

import com.codebaum.beginnerandroidexamples.R;

import java.util.UUID;

import butterknife.*;

/**
 * Basic example of updating text and utilizing string resources.
 */
public class ActivityLifecycleActivity extends AppCompatActivity {

    private static final String KEY_SAVED_LOGS = "KEY_SAVED_LOGS";

    private static final String TAG = ActivityLifecycleActivity.class.getSimpleName();

    private String uuid;

    @BindView(R.id.tv_logs_value)
    TextView logsView;

    private boolean usingGoodBehavior;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_lifecycle);

        ButterKnife.bind(this);

        setTitle(R.string.activity_lifecycle);

        // generate a random string in order to identify Activity instances in our logs
        uuid = UUID.randomUUID().toString().substring(0, 8);

        if (savedInstanceState != null) {
            String formerLogs = savedInstanceState.getString(KEY_SAVED_LOGS);
            logsView.setText(formerLogs);
        }

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
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (usingGoodBehavior) {
            outState.putString(KEY_SAVED_LOGS, logsView.getText().toString());
        }
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

        usingGoodBehavior = view.isChecked();

        addLogMessage(usingGoodBehavior ? "Using good behavior." : "Using bad behavior.");
    }

    private void addLogMessage(String message) {
        String currentLogs = logsView.getText().toString();
        String newMessage = uuid + " - " + message;
        String newLogs = currentLogs + "\n" + newMessage;
        logsView.setText(newLogs);

        Log.d(TAG, "log: " + newMessage);
    }
}
