package com.example.raindrop.fragments;


import android.view.View;

import androidx.fragment.app.Fragment;

import com.example.raindrop.models.Datum;

import java.util.List;

public class PredictionFragment extends Fragment implements View.OnClickListener {

    public static Fragment newInstance(List<Datum> list) {
        PredictionFragment fragment = new PredictionFragment();
        return fragment;
    }

    @Override
    public void onClick(View v) {

    }
}
