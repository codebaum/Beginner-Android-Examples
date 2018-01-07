package com.codebaum.beginnerandroidexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codebaum.beginnerandroidexamples.examples.TitledActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 1/7/18.
 */

public class ExampleListActivity extends AppCompatActivity implements ExampleListAdapter.Callback {

    private List<ExampleItem> exampleItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples_list);

        exampleItems = new ArrayList<>();
        exampleItems.add(ExampleItem.HELLO_WORLD);
        exampleItems.add(ExampleItem.HELLO_LUBBOCK);
        exampleItems.add(ExampleItem.HELLO_RESOURCES);
        exampleItems.add(ExampleItem.EXPLICIT_INTENT);
        exampleItems.add(ExampleItem.IMPLICIT_INTENT);
        exampleItems.add(ExampleItem.HELLO_KOTLIN);

        // Starting from API 26 (Oreo, 8.0), it's no longer necessary to cast this.
        RecyclerView list = (RecyclerView) findViewById(R.id.list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);

        ExampleListAdapter adapter = new ExampleListAdapter(exampleItems, this);
        list.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(int position) {
        ExampleItem exampleItem = exampleItems.get(position);
        Class intentClass = exampleItem.getIntentClass();
        Intent intent = new Intent(this, intentClass);
        intent.putExtra(TitledActivity.KEY_TITLE_RES_ID, exampleItem.getTitleResId());
        startActivity(intent);
    }
}
