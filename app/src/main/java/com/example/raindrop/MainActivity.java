package com.example.raindrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public  class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.button)
    Button mClickButton;
    @BindView(R.id.textView)
    TextView mTextView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        mClickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mName = mTextView.getText().toString();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("mName", mName);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onClick(View v) {

    }
}