package com.example.raindrop.fragments;


import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.example.raindrop.Adapter.FtRecyclerViewAdapter;
import com.example.raindrop.databinding.FragmentSearchBinding;
import com.example.raindrop.models.Datum;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PredictionFragment extends Fragment {
    FragmentSearchBinding binding;


    public static Fragment newInstance(List<Datum> data) {
        PredictionFragment fragment = new PredictionFragment();
        Bundle args = new Bundle();
        args.putSerializable("data", (Serializable) data);
        fragment.setArguments(args);
        return fragment;
    }

    ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(android.view.LayoutInflater inflater, android.view.ViewGroup container, Bundle savedInstanceState) {
        FragmentSearchBinding binding = FragmentSearchBinding.inflate(inflater, container, false);
        View v = binding.getRoot();
        List<Datum> data = (List<Datum>) getArguments().getSerializable("data");

        binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uid = user.getUid();
                DatabaseReference myRef = database.getReference("users/" + uid + "/predictions");
                myRef.setValue(data);


            }

        });
        return v;
    }
}

