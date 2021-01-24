package com.example.carads.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carads.Adapter.AdapterNotification;
import com.example.carads.Adapter.AdapterService;
import com.example.carads.Models.ModelNotification;
import com.example.carads.Models.ModelService;
import com.example.carads.R;

import java.util.ArrayList;

public class FragmentServices extends Fragment {



    public FragmentServices() {
        // Required empty public constructor
    }


    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_services, container, false);
        init();
        return view;
    }


    RecyclerView recyclerView;
    AdapterService adapterService;
    ArrayList<ModelService> arrayList;

    GridLayoutManager gridLayoutManager;
    private void init() {
        arrayList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recycler);
        gridLayoutManager = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        for (int i = 0; i < 10; i++) {
            ModelService item = new ModelService();
            item.setId(i+"");

            arrayList.add(item);
        }
        adapterService = new AdapterService(getActivity(),arrayList);
        recyclerView.setAdapter(adapterService);
    }
    Context context;
    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }


}