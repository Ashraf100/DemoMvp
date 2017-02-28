package com.ace.burning.demomvp.View;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ace.burning.demomvp.Model.AllTask;
import com.ace.burning.demomvp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Drac Android on 2/27/2017.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<AllTask> event;

    public DataAdapter(ArrayList<AllTask> event) {
        this.event = event;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.event_title.setText(event.get(i).getTitle());
        viewHolder.event_date.setText(event.get(i).getDate());
        viewHolder.event_venue.setText(event.get(i).getVenue());
        viewHolder.event_time.setText(event.get(i).getTime());
        viewHolder.event_description.setText(event.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return event.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
         @BindView(R.id.event_time) TextView event_time;
         @BindView(R.id.event_venue) TextView event_venue;
         @BindView(R.id.event_description) TextView event_description;
         @BindView(R.id.event_date) TextView event_date;
         @BindView(R.id.event_title) TextView event_title;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);

        }
    }

}