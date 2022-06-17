package com.example.raindrop.ui;

import android.app.appsearch.SearchResults;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.raindrop.Adapter.FirebaseViewHolder;
import com.example.raindrop.Adapter.FtRecyclerViewAdapter;
import com.example.raindrop.Constants;
import com.example.raindrop.R;
import com.example.raindrop.models.Datum;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedFtActivity extends AppCompatActivity {

    private DatabaseReference mRaindropReference;
    private FirebaseRecyclerAdapter<Datum, FirebaseViewHolder> mFirebaseAdapter;

    @BindView(R.id.lvp)
    RecyclerView mRecyclerView;
    FtRecyclerViewAdapter adapter;
    Button get_data;
    EditText edit_text1;
    List<Datum> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ft);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mRaindropReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_RAINDROP)
                .child(uid);

        setUpFirebaseAdapter();
        showData(); 
    }



    private void setUpFirebaseAdapter() {
        FirebaseRecyclerOptions<Datum> options =
                new FirebaseRecyclerOptions.Builder<Datum>()
                        .setQuery(mRaindropReference, Datum.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Datum, FirebaseViewHolder>(options) {
            @NonNull
            @Override
            public FirebaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater .from(parent.getContext()).inflate(R.layout.activity_ft, parent, false);
                return new FirebaseViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull FirebaseViewHolder holder, int position, @NonNull Datum model) {
                FirebaseViewHolder viewHolder = (FirebaseViewHolder) holder;
                viewHolder.bindView(Datum.class, model);

            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mFirebaseAdapter.stopListening();
    }

    private void showData() {
        mFirebaseAdapter.startListening();

    }
}
