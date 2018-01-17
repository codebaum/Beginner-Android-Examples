package com.codebaum.beginnerandroidexamples.examples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.codebaum.beginnerandroidexamples.R;
import com.codebaum.beginnerandroidexamples.helpers.BlueFragment;
import com.codebaum.beginnerandroidexamples.helpers.RedFragment;

import butterknife.*;

/**
 *
 */
public class FragmentsActivity extends AppCompatActivity {

    @Nullable
    @BindView(R.id.container_fragment)
    FrameLayout containerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        ButterKnife.bind(this);

        setTitle(R.string.fragments);

        // Check that the activity is using the layout version with
        // the container_fragment FrameLayout
        if (containerLayout != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            RedFragment firstFragment = new RedFragment();

            getSupportFragmentManager().beginTransaction().add(R.id.container_fragment, firstFragment).commit();
        }
    }

    @Optional
    @OnClick(R.id.btn_change_fragments)
    void onChangeFragmentsButtonClicked() {

        Fragment newFragment;

        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.container_fragment);
        if (currentFragment instanceof RedFragment) {
            newFragment = new BlueFragment();
        } else {
            newFragment = new RedFragment();
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_fragment, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
