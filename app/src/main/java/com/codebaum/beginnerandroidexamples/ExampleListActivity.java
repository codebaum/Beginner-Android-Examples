package com.codebaum.beginnerandroidexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Shows a list of examples. Each example launches a new activity.
 */
public class ExampleListActivity extends AppCompatActivity implements ExampleListAdapter.Callback {

    private List<ExampleItem> exampleItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples_list);

        // build our list of examples
        exampleItems = new ArrayList<>();
        exampleItems.add(ExampleItem.HELLO_WORLD);
        exampleItems.add(ExampleItem.BASIC_VIEWS);
        exampleItems.add(ExampleItem.EXPLICIT_INTENT);
        exampleItems.add(ExampleItem.IMPLICIT_INTENT);
        exampleItems.add(ExampleItem.ACTIVITY_LIFECYCLE);
        exampleItems.add(ExampleItem.FRAGMENTS);
        exampleItems.add(ExampleItem.HELLO_KOTLIN);
        exampleItems.add(ExampleItem.WHY_NOT_JAVA);
        exampleItems.add(ExampleItem.WHY_KOTLIN);
        exampleItems.add(ExampleItem.ADVANCED_DETAILS);
        exampleItems.add(ExampleItem.ADVANCED_LIST);

        // Starting from API 26 (Oreo, 8.0), it's no longer necessary to cast this.
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);

        // RecyclerView requires a layout manager.
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // RecyclerView requires an adapter.
        ExampleListAdapter adapter = new ExampleListAdapter(exampleItems, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(int position) {

        // Get our example from the list.
        ExampleItem exampleItem = exampleItems.get(position);

        // Get our class object from the example.
        Class intentClass = exampleItem.getIntentClass();

        // Set up our intent to explicity open the associated class.
        Intent intent = new Intent(this, intentClass);

        // Start our example's activity.
        startActivity(intent);
    }
}
