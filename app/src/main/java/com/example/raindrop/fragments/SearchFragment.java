package com.example.raindrop.fragments;

import android.app.appsearch.SearchResults;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import com.example.raindrop.models.Response;


import com.example.raindrop.Constants;
import com.example.raindrop.R;
import com.example.raindrop.SearchPrediction;
import com.example.raindrop.network.FpApi;
import com.example.raindrop.network.FpClient;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;

import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {


    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.search_button)
    Button search;
    FpApi fpApi;
    public SearchFragment() {
        // Required empty public constructor
    }


    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();

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
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        fpApi = FpClient.getClient();
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Response> call = fpApi.getPrediction();
                call.enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        Intent intent = new Intent(getContext(), SearchPrediction.class);
                        intent.putExtra("Response", String.valueOf(response.body()));
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {

                    }
                });

            }
        });

    }
}