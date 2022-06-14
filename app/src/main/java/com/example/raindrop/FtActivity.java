package com.example.raindrop;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.raindrop.Adapter.FpPagerAdapter;
import com.example.raindrop.Adapter.FtRecyclerViewAdapter;
import com.example.raindrop.fragments.PredictionFragment;

import com.example.raindrop.models.Datum;
import com.example.raindrop.models.Response;
import com.example.raindrop.network.FpApi;
import com.example.raindrop.network.FpClient;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

public class FtActivity extends AppCompatActivity {
    Button get_data;
    EditText edit_text1;
    ListView lvp;
    List<Datum> data;





     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_ft);

         get_data=findViewById(R.id.get_data);
         edit_text1=findViewById(R.id.edit_text1);
         lvp=findViewById(R.id.lvp);

         get_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Toast.makeText(FtActivity.this, "clicked", Toast.LENGTH_SHORT).show();
              }
            });
         ButterKnife.bind(this);



         FpApi fpApi = FpClient.getClient();
         Call<Response> call = fpApi.getPrediction();
            call.enqueue(new retrofit2.Callback<Response>() {
                             @Override
                             public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                                 if (response.isSuccessful()) {
                                     Response response1 = response.body();
                                      data = response1.getData();
                                 }

                             }

                             @Override
                             public void onFailure(Call<Response> call, Throwable t) {
                                 Toast.makeText(FtActivity.this, "Error", Toast.LENGTH_SHORT).show();

                             }
                         }
            );




            List<Fragment> fragments = new ArrayList<>();
            List<String> titles = new ArrayList<>();
            fragments.add(PredictionFragment.newInstance(data));
            titles.add("Prediction");


         Intent intent = new Intent(FtActivity.this, FtActivity.class);






     }

    @Override
    protected void onResume() {
        super.onResume();

    }


}


