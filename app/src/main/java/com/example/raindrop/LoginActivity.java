package com.example.raindrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.username)
    EditText mName;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.loginbtn)
    MaterialButton mLoginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        mLoginButton.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if(TextUtils.isEmpty(mName.getText().toString())){
            mName.setError("Name is Required");
        }else if(TextUtils.isEmpty(mPassword.getText().toString())){
            mPassword.setError("Name is Required");
        }else {
            //capture the user input data
            String name = mName.getText().toString();
            String password = mPassword.getText().toString();

            Intent intent = new Intent(LoginActivity.this, FtActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("password", password);

            startActivity(intent);
        }
    }




    }





