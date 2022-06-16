package com.example.raindrop.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raindrop.FtActivity;
import com.example.raindrop.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Create extends AppCompatActivity implements View.OnClickListener {
//    SharedPreferences sharedPreferences;
//    SharedPreferences.Editor editor;

    @BindView(R.id.nameEditText)
    EditText mName;
    @BindView(R.id.emailEditText)
    EditText mEmail;
    @BindView(R.id.passwordEditText)
    EditText mPassword;
    @BindView(R.id.createUserButton)
    Button mCreateButton;
    @BindView(R.id.loginTextView)
    TextView mLoginTextView;

    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createac);

//        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        editor = sharedPreferences.edit();

        ButterKnife.bind(this);

        mCreateButton.setOnClickListener(this);

        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

        mAuthListener();


    }

    @Override
    public void onClick(View v) {

        if (v == mCreateButton) {
            createUser();

        }
    }

    public void createUser() {
        String name = mName.getText().toString();
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();


        } else {

            Log.d("createUser",email);

//            editor.putString("name", name);
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Create.this, "User created", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                            }
                            else
                            {
                                Toast.makeText(Create.this, "User not created" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });



            }




    }

    public void mAuthListener() {
        mAuthListener = firebaseAuth -> {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user != null) {
                // User is signed in
                Intent intent = new Intent(Create.this, FtActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();

                Toast.makeText(Create.this, "signed in", Toast.LENGTH_SHORT).show();
            } else {
                // User is signed out
                Toast.makeText(Create.this, "signed out", Toast.LENGTH_SHORT).show();
            }
        };


    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}