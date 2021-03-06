package com.example.dell.udaan2k19;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dell.udaan2k19.R;

import java.util.ArrayList;

public class Home extends Fragment implements EventCatagoryClicked{

    ArrayList list;
    RecyclerView recyclerView;
    EventCatagoryAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)  {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle("toolbar");

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);


        toolbar.setTitle("toolbar");

        CollapsingToolbarLayout ctl = view.findViewById(R.id.collapsing_toolbar);

        ctl.setTitle("collapsing toolbar");

        // recylcer view starts

        recyclerView = view.findViewById(R.id.recycler_view);

        list = new ArrayList<>();

        list.add(new EventCatagory(R.drawable.home));
        list.add(new EventCatagory(R.drawable.arcamera));
        list.add(new EventCatagory(R.drawable.registerd));

        adapter=new EventCatagoryAdapter(list,getActivity(),this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

    }

    @Override
    public void respondOnClickEvent(EventCatagory obj) {
        switch (obj.getImage()) {
            case R.drawable.home:
                Toast.makeText(getActivity(),"you are in technical",Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.frame,new TechnicalEvent()).commit();
                break;
            case R.drawable.arcamera:
                Toast.makeText(getActivity(),"you are in non-technical",Toast.LENGTH_SHORT).show();
               getFragmentManager().beginTransaction().replace(R.id.frame,new NonTechnicalEvent()).commit();
                break;
            case R.drawable.registerd:
                Toast.makeText(getActivity(),"you are in cultural",Toast.LENGTH_SHORT).show();
               getFragmentManager().beginTransaction().replace(R.id.frame,new CulturalEvent()).commit();
                break;
        }



    }
}


