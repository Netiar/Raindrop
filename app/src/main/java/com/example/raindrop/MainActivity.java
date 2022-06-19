package com.example.raindrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.raindrop.ui.Create;

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


        mClickButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == mClickButton) {
            Intent intent = new Intent(MainActivity.this, Create.class);
            startActivity(intent);
        }

        YoYo.with(Techniques.SlideInDown)
                .duration(700)
                .repeat(5)
                .playOn(findViewById(R.id.textView));

    }
}