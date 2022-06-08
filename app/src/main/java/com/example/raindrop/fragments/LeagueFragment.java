package com.example.raindrop.fragments;

import android.app.appsearch.SearchResults;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;


import com.example.raindrop.Constants;
import com.example.raindrop.FtActivity;
import com.example.raindrop.R;
import com.example.raindrop.models.Leagues;
import com.example.raindrop.network.ElenaApi;
import com.example.raindrop.network.ElenaClient;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class LeagueFragment extends Fragment {

    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.search_button)
    Button search;
    ElenaApi elenaApi;
    public LeagueFragment() {
        // Required empty public constructor
    }


    public static LeagueFragment newInstance() {
        LeagueFragment fragment = new LeagueFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_league, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        try {
            elenaApi = ElenaClient.getClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Leagues> call = elenaApi.getLeagues(searchView.getQuery().toString());
                call.enqueue(new Callback<Leagues>() {

                    @Override
                    public void onResponse(Call<Leagues> call, Response<Leagues> response) {
                        Intent intent = new Intent(getContext(), FtActivity.class);
                        intent.putExtra("Response", String.valueOf(response.body()));
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<Leagues> call, Throwable t) {

                    }




                });

            }
        });

    }
}

