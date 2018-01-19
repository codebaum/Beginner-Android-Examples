package com.codebaum.beginnerandroidexamples.examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

import com.codebaum.beginnerandroidexamples.R;
import com.codebaum.beginnerandroidexamples.data.JavaVideoGame;
import com.codebaum.beginnerandroidexamples.helpers.SmartCast;
import com.codebaum.beginnerandroidexamples.utils.JavaUtils;

/**
 * Java code to be compared against examples in {@link WhyKotlinActivity}
 */
@SuppressWarnings({"ConstantConditions", "FieldCanBeLocal"})
public class WhyNotJavaActivity extends AppCompatActivity {

    private String nullableVar = "java";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_why_kotlin);

        setTitle(R.string.why_not_java);

        // 1. must use findViewById or view injection library
        TextView textView = findViewById(R.id.textView);

        // 2. results in "if (x != null) { ... }" in lots of places
        if (nullableVar != null) {
            String formattedText = getString(R.string.string_and_length, nullableVar, nullableVar.length());
            textView.setText(formattedText);
        } else {
            textView.setText(R.string.null_variable);
        }

        // 3. no extension functions (custom util classes require knowing about them)
        // 4. no lambdas support     (can be added with "retrolambda" or targeting later java versions)
        Button button = findViewById(R.id.button_toast);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JavaUtils.quickToast(WhyNotJavaActivity.this, "This is my Java toast!");
            }
        });

        // 5. manual data class implementations
        JavaVideoGame game = new JavaVideoGame("Madden", "EA", 90);
        final JavaVideoGame updatedGame = new JavaVideoGame(game.getName(), game.getPublisher(), 88);
        Button buttonVideoGame = findViewById(R.id.button_video_game);
        buttonVideoGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JavaUtils.quickToast(WhyNotJavaActivity.this, "Review Score: " + updatedGame.getReviewScore());
            }
        });

        // 6. redundant casting
        SmartCast smartCast = SmartCast.Companion.getRandom();
        if (smartCast instanceof SmartCast.SubSmartCast1) {
            ((SmartCast.SubSmartCast1) smartCast).returnTest1String();
        } else if (smartCast instanceof SmartCast.SubSmartCast2) {
            ((SmartCast.SubSmartCast2) smartCast).returnTest2String();
        } else if (smartCast instanceof SmartCast.SubSmartCast3) {
            ((SmartCast.SubSmartCast3) smartCast).returnTest3String();
        }
    }
}
