package com.codebaum.beginnerandroidexamples;

import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter for showing a list of examples.
 *
 * https://developer.android.com/training/material/lists-cards.html
 */
public class ExampleListAdapter extends RecyclerView.Adapter<ExampleListAdapter.ViewHolder> {

    private final List<ExampleItem> exampleItems = new ArrayList<>();

    private final Callback itemSelectedCallback;

    /**
     * Constructor for setting up the adapter.
     *
     * @param exampleItems         list of examples
     * @param itemSelectedCallback callback to use to communicate which example has been selected
     */
    ExampleListAdapter(List<ExampleItem> exampleItems, Callback itemSelectedCallback) {
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
        ExampleItem example = exampleItems.get(position);

        // Get the string resource id of the title.
        int itemTitleResId = example.getTitleResId();

        // Set the title view with the string resource id.
        holder.titleView.setText(itemTitleResId);
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
