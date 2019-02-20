package com.example.dell.udaan2k19;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class TechnicalEvent extends Fragment implements EventCatagoryClicked{

    ArrayList list;
    RecyclerView recyclerView;
    EventCatagoryAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sub_catagory_event_list,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        list = new ArrayList<>();
        recyclerView = getActivity().findViewById(R.id.recycler_view_for_catagory);


        list.add(new EventCatagory(R.drawable.arcamera));
        list.add(new EventCatagory(R.drawable.registerd));
        list.add(new EventCatagory(R.drawable.arcamera));
        list.add(new EventCatagory(R.drawable.registerd));

        adapter = new EventCatagoryAdapter(list,getActivity(),this);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(manager);

        recyclerView.setAdapter(adapter);

    }


    @Override
    public void respondOnClickEvent(EventCatagory obj) {
        Toast.makeText(getActivity()," clicked ", Toast.LENGTH_SHORT).show();
    }
}
