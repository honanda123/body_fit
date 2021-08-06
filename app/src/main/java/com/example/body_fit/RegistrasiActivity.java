package com.example.body_fit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrasiActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText email, password, name;
    private String Name,Email,Password;
    private TextView loginHere;
    private Button btnRegist;
    private ProgressBar loadBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        email = (EditText) findViewById(R.id.regEmail);
        password = (EditText) findViewById(R.id.regPassword);
        name = (EditText) findViewById(R.id.regName);
        loginHere = (TextView) findViewById(R.id.loginHere);
        btnRegist = (Button) findViewById(R.id.btnRegis);
        loadBar = new ProgressBar(this);
//for authentication using FirebaseAuth
        mAuth = FirebaseAuth.getInstance();
        btnRegist.setOnClickListener((View.OnClickListener) this);

        loginHere.setOnClickListener(view ->{
            startActivity(new Intent(RegistrasiActivity.this,LoginActivity.class));

        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.loginHere:
//                startActivity(new Intent(RegistrasiActivity.this,LoginActivity.class));
//                break;
            case R.id.btnRegis:
                RegisterUser();
                break;
        }
    }

    private void RegisterUser() {
        Email = email.getText().toString().trim();
        Name = name.getText().toString().trim();
        Password = password.getText().toString().trim();

        if (Name.isEmpty()){
            name.setError("Full Name is required");
            name.requestFocus();
            return;
        }
        if (Email.isEmpty()){
            email.setError("Full Name is required");
            email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            email.setError("Please provide valid email");
        }
        if (Password.isEmpty()){
            password.setError("Full Name is required");
            password.requestFocus();
            return;
        }
        if (Password.length() < 8){
            password.setError("Min password length should be 8 characters!");
            password.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            User user = new User(Email, Password, Name);


                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).push()
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(RegistrasiActivity.this, "User has been registered successfully",Toast.LENGTH_LONG).show();
                                        loadBar.setVisibility(View.VISIBLE);

                                        //redirect to login acc
                                        startActivity(new Intent(RegistrasiActivity.this, LoginActivity.class));
                                    }else{
                                        Toast.makeText(RegistrasiActivity.this, "Failed to register! Try again",Toast.LENGTH_LONG).show();
                                        loadBar.setVisibility(View.GONE);

                                    }
                                }
                            });

                        }else {
                            Toast.makeText(RegistrasiActivity.this, "Failed to register!",Toast.LENGTH_LONG).show();
                            loadBar.setVisibility(View.GONE);
                            System.out.println("onComplete: " + task.getException().getMessage());

                        }
                    }
                });

    }
}