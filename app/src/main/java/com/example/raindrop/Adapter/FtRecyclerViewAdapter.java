package com.example.raindrop.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.raindrop.R;
import com.example.raindrop.SearchPrediction;
import com.example.raindrop.models.Datum;


import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FtRecyclerAdapter extends RecyclerView.Adapter<FtRecyclerAdapter.MyHolder>{
    private Context context;
    private List<Datum> list;
    public FtRecyclerAdapter(Context context, List<Datum> list) {
        this.context = context;
        this.list = list;
    }




    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.gif_strip,parent,false);

        return  new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, @SuppressLint("RecyclerView") int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.view_pager)
        List<Datum> data;
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.search_button)
        ImageButton searchButton;



        public MyHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }
}
