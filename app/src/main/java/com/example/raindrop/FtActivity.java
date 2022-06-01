package com.example.raindrop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import Adapter.FtAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FtActivity extends AppCompatActivity {

    @BindView(R.id.countryTextView) TextView mCountryTextView;
    @BindView(R.id.listView) ListView mListView;

    private String[] Countries = new String[] {"England", "Spain", "Italy", "Germany", "France", "Portugal", "Scotland"};
    private Object countries;

//    private String[] mLeagues = {"Premier League", "La liga", "Serie A", "Bundesliga", "Ligue 1", "Primeira Liga", "Scottish Premiership"};




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ft);
        ButterKnife.bind(this);

        Intent intent= getIntent();
        String country = intent.getStringExtra("country");
        mCountryTextView.setText("Here are all the countries." );





        FtAdapter adapter = new FtAdapter(this, Countries);
        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(FtActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });


        mListView = (ListView) findViewById(R.id.listView);
        mCountryTextView = (TextView) findViewById(R.id.countryTextView);
        mCountryTextView.setText(country);




    }
}
