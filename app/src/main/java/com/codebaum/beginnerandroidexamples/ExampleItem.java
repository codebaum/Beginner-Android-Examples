package com.codebaum.beginnerandroidexamples;

import android.support.annotation.StringRes;

import com.codebaum.beginnerandroidexamples.examples.WhyKotlinActivity;
import com.codebaum.beginnerandroidexamples.examples.HelloWorldActivity;
import com.codebaum.beginnerandroidexamples.examples.ExplicitIntentActivity;
import com.codebaum.beginnerandroidexamples.examples.ImplicitIntentActivity;
import com.codebaum.beginnerandroidexamples.examples.HelloKotlinActivity;
import com.codebaum.beginnerandroidexamples.examples.WhyNotJavaActivity;

/**
 * Created on 1/7/18.
 */
enum ExampleItem {

    HELLO_WORLD(R.string.hello_world, HelloWorldActivity.class),
    EXPLICIT_INTENT(R.string.explicit_intent, ExplicitIntentActivity.class),
    IMPLICIT_INTENT(R.string.implicit_intent, ImplicitIntentActivity.class),
    ACTIVITY_LIFECYCLE(R.string.explicit_intent, ExplicitIntentActivity.class),
    FRAGMENTS(R.string.implicit_intent, ImplicitIntentActivity.class),
    HELLO_KOTLIN(R.string.hello_kotlin, HelloKotlinActivity.class),
    WHY_KOTLIN(R.string.why_kotlin, WhyKotlinActivity.class),
    WHY_NOT_JAVA(R.string.why_not_java, WhyNotJavaActivity.class);

    @StringRes
    private final int titleResId;
    private final Class intentClass;

    ExampleItem(int titleResId, Class intentClass) {
        this.titleResId = titleResId;
        this.intentClass = intentClass;
    }

    public int getTitleResId() {
        return titleResId;
    }

    public Class getIntentClass() {
        return intentClass;
    }
}
