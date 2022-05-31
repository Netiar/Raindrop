package com.example.raindrop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onClick(View v) {


    }
}