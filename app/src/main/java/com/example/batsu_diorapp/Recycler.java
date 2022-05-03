package com.example.batsu_diorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Recycler extends AppCompatActivity {
    RecyclerView customRecycler;
    RecyclerView.LayoutManager layoutManager;
    List<Item> itemList;
    MyCustomAdapter myCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        customRecycler = findViewById(R.id.CustRecycler);
        layoutManager = new LinearLayoutManager(this);
        customRecycler.setLayoutManager(layoutManager);
        itemList=new ArrayList<>();
        itemList=fillTheList();
        myCustomAdapter=new MyCustomAdapter(this,itemList);
        customRecycler.setAdapter(myCustomAdapter);
    }

    private List<Item> fillTheList() {
        List<Item> itemList =new ArrayList<>();
        itemList.add(new Item(R.drawable.force,"Air Force",150,"Best Air Force ever"));
        itemList.add(new Item(R.drawable.jordan,"Air Jordan",180,"Best Air Jordan ever"));
        itemList.add(new Item(R.drawable.allstar,"All Star",100,"Best All Star shoes"));
        itemList.add(new Item(R.drawable.heels,"High Heels",80,"Beautiful high heels for girls"));
        itemList.add(new Item(R.drawable.light,"High Heels light",120,"Beautiful high heels for beauty"));

        return itemList;

    }
}