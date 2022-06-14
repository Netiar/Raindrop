package com.example.raindrop.fragments;


import androidx.fragment.app.Fragment;

import com.example.raindrop.models.Datum;

import java.util.List;

public class PredictionFragment extends Fragment{

    public static Fragment newInstance(List<Datum> list) {
        PredictionFragment fragment = new PredictionFragment();
        return fragment;
    }
}
