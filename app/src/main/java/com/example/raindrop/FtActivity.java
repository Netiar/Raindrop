package com.example.raindrop;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FtActivity extends AppCompatActivity {

    @BindView(R.id.listView) ListView mListView;

    private String[] mCountries = {"England", "Spain", "Italy", "Germany", "France", "Portugal", "Scotland"};
    private String[] mLeagues = {"Premier League", "La liga", "Serie A", "Bundesliga", "Ligue 1", "Primeira Liga", "Scottish Premiership"};




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ft);

        ButterKnife.bind(this);

    }
}
