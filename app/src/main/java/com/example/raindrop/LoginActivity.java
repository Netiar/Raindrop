package com.example.raindrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.raindrop.databinding.ActivityLoginBinding;
import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.nameEditText)
    EditText mName;
    @BindView(R.id.passwordEditText)
    EditText mPassword;
    @BindView(R.id.loginButton)
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
       if(mName.getText().toString().equals("admin") && mPassword.getText().toString().equals("admin")){
            //correct
            Toast.makeText(this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
           }else
               //incorrect
               Toast.makeText(this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();


    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}