package com.example.dell.udaan2k19;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;


import java.util.ArrayList;

public class EventCatagoryAdapter extends  RecyclerView.Adapter<EventCatagoryAdapter.ViewHolder>{

    private ArrayList<EventCatagory> dlist;
    private Context dcontext;


    public EventCatagoryAdapter(ArrayList<EventCatagory> dlist, Context dcontext) {
        this.dlist = dlist;
        this.dcontext = dcontext;

    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater li=LayoutInflater.from(dcontext);

        View v = li.inflate(R.layout.event_catagory_view,viewGroup,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final EventCatagory obj = dlist.get(i);

        viewHolder.iv.setImageResource(obj.getImage());

    }

    @Override
    public int getItemCount() {
        return dlist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.event_catagory_image_view);
        }
    }

}
