package com.mbobiosio.recyclerviewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mbobiosio.recyclerviewdemo.R;

/**
 * Created by kodenerd on 3/13/18.
 */

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

    private static final String TAG = PeopleAdapter.class.getSimpleName();

    private String[] names;
    private final ListItemClickListener onclickListener;

    public PeopleAdapter(String[] names, ListItemClickListener onclickListener){
        this.names = names;
        this.onclickListener = onclickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mName.setText(names[position]);


    }
    @Override
    public int getItemCount() {
        return names.length;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mName;

        public ViewHolder(View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.name);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            int itemIndex = getAdapterPosition();
            onclickListener.onItemClick(itemIndex);
        }
    }

    public interface ListItemClickListener {
        void onItemClick(int itemIndex);
    }
}
