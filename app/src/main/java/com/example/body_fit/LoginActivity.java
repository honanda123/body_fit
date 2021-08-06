package com.example.body_fit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText inputEmail,inputPassword;
    TextView regisHere;
    Button btnLogin;
    ProgressDialog loadBar;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        regisHere = findViewById(R.id.regisHere);
        btnLogin = findViewById(R.id.btnLogin);
        loadBar = new ProgressDialog(this);


        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(view->{
            loginUser();
        });
        regisHere.setOnClickListener(view ->{
            startActivity(new Intent(LoginActivity.this,RegistrasiActivity.class));

        });
    }

    private void loginUser() {
        String email = inputEmail.getText().toString();
        String pass = inputPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            inputEmail.setError("Email Cannot Be Empty");
            inputEmail.requestFocus();
        }else if(TextUtils.isEmpty(pass)){
            inputPassword.setError("Password Cannot Be Empty");
            inputPassword.requestFocus();
        }else{
            loadBar.setTitle("Login");
            loadBar.setMessage("Please Wait, While We Are Login");
            loadBar.show();
            mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(LoginActivity.this,"User Login Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }else {
                        Toast.makeText(LoginActivity.this,"Login Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        inputPassword.setText("");
                        inputEmail.setText("");
                    }
                    loadBar.dismiss();
                }
            });

        }
    }
}