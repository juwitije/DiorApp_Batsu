package com.example.batsu_diorapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomerRVAdapter extends RecyclerView.Adapter<VH> {

    List<Customer> mList;

    public CustomerRVAdapter(List<Customer> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customerrow,parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        Customer student = mList.get(position);
        holder.tvName.setText(student.getStName());
        holder.tvPhone.setText(student.getStPhone());
        holder.tvFaculty.setText(student.getStFaculty());
        holder.tvEmail.setText(student.getStEmail());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

