package com.example.batsu_diorapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class ShowCustomer extends AppCompatActivity {
    RecyclerView customerRV;
    List<Customer> mList;
    DbHelper dbHelper;
    CustomerRVAdapter customerRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_customer);
        customerRV = findViewById(R.id.customerRV);
        customerRV.setLayoutManager(new LinearLayoutManager(this));
        dbHelper = new DbHelper(this);
        mList = dbHelper.getData();
        customerRVAdapter = new CustomerRVAdapter(mList);
        customerRV.setAdapter(customerRVAdapter);
    }
}