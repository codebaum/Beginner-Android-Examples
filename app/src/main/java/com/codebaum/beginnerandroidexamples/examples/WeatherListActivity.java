package com.codebaum.beginnerandroidexamples.examples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codebaum.beginnerandroidexamples.R;
import com.codebaum.beginnerandroidexamples.darksky.DarkSky;
import com.codebaum.beginnerandroidexamples.utils.JavaUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.codebaum.beginnerandroidexamples.darksky.FirebaseConstants.NODE_REQUESTS;

/**
 *
 */
public class WeatherListActivity extends AppCompatActivity implements WeatherListAdapter.Callback {

    private static final String TAG = WeatherListActivity.class.getSimpleName();

    @BindView(R.id.list)
    RecyclerView recyclerView;

    private List<DarkSky> listOfRequests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_list);

        setTitle("Weather Request History");

        ButterKnife.bind(this);

        listOfRequests = new ArrayList<>();

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child(NODE_REQUESTS).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                listOfRequests.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    DarkSky darkSky = snapshot.getValue(DarkSky.class);
                    listOfRequests.add(darkSky);
                }

                if (listOfRequests.isEmpty()) {
                    JavaUtils.quickToast(WeatherListActivity.this, "No saved requests.");
                    finish();
                    return;
                }

                LinearLayoutManager layoutManager = new LinearLayoutManager(WeatherListActivity.this);
                recyclerView.setLayoutManager(layoutManager);

                WeatherListAdapter adapter = new WeatherListAdapter(listOfRequests, WeatherListActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onItemSelected(int position) {
        Intent intent = new Intent(this, WeatherDetailsActivity.class);
        intent.putExtra("test", listOfRequests.get(position));
        startActivity(intent);
    }
}
