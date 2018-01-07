package com.codebaum.beginnerandroidexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.codebaum.beginnerandroidexamples.examples.helloworld.HelloLubbockActivity;
import com.codebaum.beginnerandroidexamples.examples.helloworld.HelloResourcesActivity;
import com.codebaum.beginnerandroidexamples.examples.helloworld.HelloWorldActivity;
import com.codebaum.beginnerandroidexamples.examples.intents.ExplicitIntentActivity;
import com.codebaum.beginnerandroidexamples.examples.intents.ImplicitIntentActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 1/7/18.
 */

public class ExampleListActivity extends AppCompatActivity implements ExampleListAdapter.Callback {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples_list);

        List<String> exampleItems = new ArrayList<>();
        exampleItems.add("Hello, World!");
        exampleItems.add("Hello, Lubbock!");
        exampleItems.add("Hello, Resources!");
        exampleItems.add("Explicit Intent");
        exampleItems.add("Implicit Intent");

        // Starting from API 26 (Oreo, 8.0), it's no longer necessary to cast this.
        RecyclerView list = (RecyclerView) findViewById(R.id.list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);

        ExampleListAdapter adapter = new ExampleListAdapter(exampleItems, this);
        list.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(int position) {
        Intent intent;
        switch (position) {
            case 0:
                intent = new Intent(this, HelloWorldActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(this, HelloLubbockActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, HelloResourcesActivity.class);
                startActivity(intent);
            case 3:
                intent = new Intent(this, ExplicitIntentActivity.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(this, ImplicitIntentActivity.class);
                startActivity(intent);
                break;
            default:
                Toast.makeText(this, "Error: invalid item", Toast.LENGTH_SHORT).show();
        }
    }
}
