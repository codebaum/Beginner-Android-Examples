package com.codebaum.beginnerandroidexamples.examples;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codebaum.beginnerandroidexamples.R;
import com.codebaum.beginnerandroidexamples.darksky.DarkSky;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter for showing a list of examples.
 * <p>
 * https://developer.android.com/training/material/lists-cards.html
 */
public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.ViewHolder> {

    private final List<DarkSky> exampleItems = new ArrayList<>();

    private final Callback itemSelectedCallback;

    /**
     * Constructor for setting up the adapter.
     *
     * @param exampleItems         list of examples
     * @param itemSelectedCallback callback to use to communicate which example has been selected
     */
    WeatherListAdapter(List<DarkSky> exampleItems, Callback itemSelectedCallback) {
        this.exampleItems.addAll(exampleItems);
        this.itemSelectedCallback = itemSelectedCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // inflate the layout for a row
        LinearLayout exampleItemLayout =
                (LinearLayout) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_example_list, parent, false);

        // create a new ViewHolder with the inflated layout
        return new ViewHolder(exampleItemLayout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        // Get the corresponding example.
        DarkSky item = exampleItems.get(position);

        String requestTitle = holder.itemView.getContext().getString(R.string.requested_location,
                Double.parseDouble(item.getLatitude()), Double.parseDouble(item.getLongitude()));

        // Set the title view with the string resource id.
        holder.titleView.setText(requestTitle);
    }

    /**
     * Allows for communication with parent activity.
     */
    interface Callback {
        /**
         * Called when an example is selected.
         *
         * @param position index of the example in the list.
         */
        void onItemSelected(int position);
    }

    @Override
    public int getItemCount() {
        return exampleItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleView;

        ViewHolder(View itemView) {
            super(itemView);

            // store the reference to our title view
            titleView = itemView.findViewById(R.id.title);

            // invoke our callback when this example has been selected
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemSelectedCallback.onItemSelected(getAdapterPosition());
                }
            });
        }
    }
}
