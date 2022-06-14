package com.example.raindrop.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.raindrop.Adapter.FtRecyclerViewAdapter;
import com.example.raindrop.R;
import com.example.raindrop.models.Response;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchPrediction extends AppCompatActivity {
    Response response;
    @BindView(R.id.search_results)
    RecyclerView searchResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchprediction);
        ButterKnife.bind(this);

        response = (Response) getIntent().getSerializableExtra("Response");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        searchResults.setLayoutManager(gridLayoutManager);
        searchResults.setAdapter(new FtRecyclerViewAdapter( this, response.getData()));


    }
}
