package com.codebaum.beginnerandroidexamples;

import android.support.annotation.StringRes;

import com.codebaum.beginnerandroidexamples.examples.*;

/**
 * Created on 1/7/18.
 */
enum ExampleItem {

    HELLO_WORLD(R.string.hello_world, HelloWorldActivity.class),
    BASIC_VIEWS(R.string.basic_views, BasicViewsActivity.class),
    EXPLICIT_INTENT(R.string.explicit_intent, ExplicitIntentActivity.class),
    IMPLICIT_INTENT(R.string.implicit_intent, ImplicitIntentActivity.class),
    ACTIVITY_LIFECYCLE(R.string.activity_lifecycle, ActivityLifecycleActivity.class),
    FRAGMENTS(R.string.fragments, FragmentsActivity.class),
    HELLO_KOTLIN(R.string.hello_kotlin, HelloKotlinActivity.class),
    WHY_NOT_JAVA(R.string.why_not_java, WhyNotJavaActivity.class),
    WHY_KOTLIN(R.string.why_kotlin, WhyKotlinActivity.class),
    ADVANCED_DETAILS(R.string.advanced_details, WeatherDetailsActivity.class),
    ADVANCED_LIST(R.string.advanced_list, WeatherListActivity.class);

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
