package com.example.raindrop;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;


import com.example.raindrop.Adapter.ElenaPagerAdapter;
import com.example.raindrop.fragments.LeagueFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

public class FtActivity extends AppCompatActivity {


    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    private String[] Countries = new String[] {"England", "Spain", "Italy", "Germany", "France", "Portugal", "Scotland"};
    private String[] mLeagues = {"Premier League", "La liga", "Serie A", "Bundesliga", "Ligue 1", "Primeira Liga", "Scottish Premiership"};
    private ListView mListView;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ft);
        ButterKnife.bind(this);


        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Countries);
        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener((parent, view, position, id) -> {
            String item = ((TextView) view).getText().toString();
            Toast.makeText(FtActivity.this, item, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(FtActivity.this, FtActivity.class);
            intent.putExtra("country", item);
            startActivity(intent);
        });

        tabLayout.setupWithViewPager(viewPager);
        List<Fragment> fragments = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        fragments.add(LeagueFragment.newInstance());

    }









}
