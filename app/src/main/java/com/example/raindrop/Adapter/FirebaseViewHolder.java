package com.example.raindrop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.raindrop.Constants;
import com.example.raindrop.FtActivity;
import com.example.raindrop.R;
import com.example.raindrop.models.Datum;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



import java.util.ArrayList;
import java.util.List;

public class FirebaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContex;

    public FirebaseViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
        mContex = itemView.getContext();
        itemView.setOnClickListener(this);

    }

    public void bindData(Datum datum) {
        TextView homeTeam = mView.findViewById(R.id.home_team);
        TextView awayTeam = mView.findViewById(R.id.away_team);
        TextView competition = mView.findViewById(R.id.competition);
        TextView federation = mView.findViewById(R.id.federation);

        homeTeam.setText(datum.getHomeTeam());
        awayTeam.setText(datum.getAwayTeam());
        competition.setText(datum.getCompetitionCluster());
        federation.setText(datum.getFederation());

    }

    @Override
    public void onClick(View v) {
        final List<Datum> list  = new ArrayList<>();


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_RAINDROP).child(uid);

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Datum datum = snapshot.getValue(Datum.class);
                    list.add(datum);
                }
                Intent intent = new Intent(mContex, FtActivity.class);
                intent.putExtra("position", getAdapterPosition());
                intent.putExtra("list", (Parcelable) list);
                mContex.startActivity(intent);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

       }


    public void bindView(Class<Datum> datumClass, Datum model) {
    }
}