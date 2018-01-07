package com.codebaum.beginnerandroidexamples;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * https://developer.android.com/training/material/lists-cards.html
 */
public class ExampleListAdapter extends RecyclerView.Adapter<ExampleListAdapter.ViewHolder> {

    interface Callback {
        void onItemSelected(int position);
    }

    private final List<String> exampleItems = new ArrayList<>();
    private final Callback itemSelectedCallback;

    public ExampleListAdapter(List<String> exampleItems, Callback itemSelectedCallback) {
        this.exampleItems.addAll(exampleItems);
        this.itemSelectedCallback = itemSelectedCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout exampleItemLayout =
                (LinearLayout) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_example_list, parent, false);

        return new ViewHolder(exampleItemLayout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String itemTitle = exampleItems.get(position);
        holder.titleView.setText(itemTitle);
    }

    @Override
    public int getItemCount() {
        return exampleItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemSelectedCallback.onItemSelected(getAdapterPosition());
                }
            });
        }
    }
}
