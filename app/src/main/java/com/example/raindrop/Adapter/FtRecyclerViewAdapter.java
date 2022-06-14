package com.example.raindrop.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.raindrop.FtActivity;
import com.example.raindrop.R;
import com.example.raindrop.models.Datum;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FtRecyclerViewAdapter extends RecyclerView.Adapter<FtRecyclerViewAdapter.MyHolder> {
    private Context context;
    private List<Datum> list;

    public FtRecyclerViewAdapter() {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.gif_strip, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {


        public MyHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}