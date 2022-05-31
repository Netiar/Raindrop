package com.example.raindrop;

import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;

public class FtActivity extends AppCompatActivity {
    @BindView(R.id.viewName)TextView mViewname;
    @BindView(R.id.viewCountry)TextView mViewcountry;
    @BindView(R.id.listView) ListView mListView;

    private String[] mCountries = {"England", "Spain", "Italy", "Germany", "France", "Portugal", "Scotland"};
    private String[] mLeagues = {"Premier League", "La liga", "Serie A", "Bundesliga", "Ligue 1", "Primeira Liga", "Scottish Premiership"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ft);

        ButterKnife.bind(this);
        mViewname.setText(getIntent().getStringExtra("name"));
        mViewcountry.setText(getIntent().getStringExtra("country"));
        mListView.setAdapter(new CustomAdapter(this, mCountries, mLeagues));
    }
}
