package com.example.raindrop.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

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

    public FtRecyclerViewAdapter(Context context, List<Datum> list) {

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
        holder.bindData(list.get(position));
    }




    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {
        TextView homeTeam, awayTeam, competition, federation;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            homeTeam = itemView.findViewById(R.id.home_team);
            awayTeam = itemView.findViewById(R.id.away_team);
            competition = itemView.findViewById(R.id.competition);
            federation = itemView.findViewById(R.id.federation);
        }

        public void bindData(Datum datum) {
            homeTeam.setText(datum.getHomeTeam());
            awayTeam.setText(datum.getAwayTeam());
            competition.setText(datum.getCompetitionCluster());
            federation.setText(datum.getFederation());
        }
    }


 }