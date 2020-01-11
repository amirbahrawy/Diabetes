package com.example.android.diabetes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LogIn extends AppCompatActivity {

    private EditText EmailLogin;
    private EditText Password;
    private TextView LoginBtn;
    private TextView signupe;
    private FirebaseAuth firebaseAuth;
    private String email;
    private String password;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (firebaseAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
    }
    }

    private void initView() {
        EmailLogin = (EditText) findViewById(R.id.Email_login);
        Password = (EditText) findViewById(R.id.Password);
        LoginBtn = (TextView) findViewById(R.id.Login_btn);
        signupe = (TextView) findViewById(R.id.signupe);
        signupe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SignUp.class));
                finish();
            }
        });
        firebaseAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progress);
        progressBar.setVisibility(View.INVISIBLE);
    }
    public void Login(View view) {
        progressBar.setVisibility(View.VISIBLE);
        email=EmailLogin.getText().toString().trim();
        password=Password.getText().toString().trim();
        if (email.isEmpty()){
            EmailLogin.setError("please enter your email");
            EmailLogin.requestFocus();
            progressBar.setVisibility(View.INVISIBLE);
            return;
        }
        if (password.length()<6){
            Toast.makeText(this, "Password is too short", Toast.LENGTH_SHORT).show();
            Password.requestFocus();
            progressBar.setVisibility(View.INVISIBLE);
            return;
        }
        signInUser(email,password);
    }

    private void signInUser(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.INVISIBLE);
                        if (task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            finish();
                        }
                        else {
                            Toast.makeText(LogIn.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
