package com.codebaum.beginnerandroidexamples;

import android.support.annotation.StringRes;

import com.codebaum.beginnerandroidexamples.examples.helloworld.HelloLubbockActivity;
import com.codebaum.beginnerandroidexamples.examples.helloworld.HelloResourcesActivity;
import com.codebaum.beginnerandroidexamples.examples.helloworld.HelloWorldActivity;
import com.codebaum.beginnerandroidexamples.examples.intents.ExplicitIntentActivity;
import com.codebaum.beginnerandroidexamples.examples.intents.ImplicitIntentActivity;
import com.codebaum.beginnerandroidexamples.examples.kotlin.HelloKotlinActivity;

/**
 * Created on 1/7/18.
 */
enum ExampleItem {

    HELLO_WORLD(R.string.hello_world, HelloWorldActivity.class),
    HELLO_LUBBOCK(R.string.hello_lubbock, HelloLubbockActivity.class),
    HELLO_RESOURCES(R.string.hello_resources, HelloResourcesActivity.class),
    EXPLICIT_INTENT(R.string.explicit_intent, ExplicitIntentActivity.class),
    IMPLICIT_INTENT(R.string.implicit_intent, ImplicitIntentActivity.class),
    HELLO_KOTLIN(R.string.hello_kotlin, HelloKotlinActivity.class);

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
