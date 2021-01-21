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
import com.example.carads.Models.ModelNotification;
import com.example.carads.R;

import java.util.ArrayList;


public class FragmentNotification extends Fragment {

    RecyclerView recyclerView;
    AdapterNotification adapterNotification;
    ArrayList<ModelNotification> arrayList;

    public FragmentNotification() {
        // Required empty public constructor
    }

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_notification, container, false);
        init();
        return view;
    }

    GridLayoutManager gridLayoutManager;
    private void init() {
        arrayList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recycler);
        gridLayoutManager = new GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        for (int i = 0; i < 10; i++) {
            ModelNotification item = new ModelNotification();
            item.setId(i+"");

            arrayList.add(item);
        }
        adapterNotification = new AdapterNotification(getActivity(),arrayList);
        recyclerView.setAdapter(adapterNotification);
    }
    Context context;
    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }
}