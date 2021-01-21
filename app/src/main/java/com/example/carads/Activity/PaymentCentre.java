package com.example.carads.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.carads.Adapter.AdapterCentre;
import com.example.carads.Adapter.AdapterNotification;
import com.example.carads.Models.ModelCentre;
import com.example.carads.Models.ModelNotification;
import com.example.carads.R;

import java.util.ArrayList;

public class PaymentCentre extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterCentre adapterCentre;
    ArrayList<ModelCentre> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_centre);
        init();
    }

    GridLayoutManager gridLayoutManager;
    private void init() {
        arrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler);
        gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        for (int i = 0; i < 10; i++) {
            ModelCentre item = new ModelCentre();
            item.setId(i+"");

            arrayList.add(item);
        }
        adapterCentre = new AdapterCentre(this,arrayList);
        recyclerView.setAdapter(adapterCentre);
    }


}