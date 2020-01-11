package com.example.android.diabetes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
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

public class SignUp extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private TextView signupBtn;
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initView();
    }

    private void initView() {
        Email = (EditText) findViewById(R.id.Email);
        Password = (EditText) findViewById(R.id.Password);
        signupBtn = (TextView) findViewById(R.id.signup_btn);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });
        firebaseAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progress);
        progressBar.setVisibility(View.INVISIBLE);
    }
    public void Register() {
        final String email=Email.getText().toString().trim();
        final String pass=Password.getText().toString().trim();

        if (email.isEmpty()){
            Email.setError("email is required");
            Email.requestFocus();
            return;
        }
        else  if (pass.isEmpty()){
            Password.setError("pass is required");
            Password.requestFocus();
            return;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.setError("enter a vaild mail");
            Email.requestFocus();
            return;
        }
        else if (pass.length()<8){
            Password.setError("pass is too short");
            Password.requestFocus();
            return;
        }
        else {
            progressBar.setVisibility(View.VISIBLE);
            firebaseAuth.createUserWithEmailAndPassword(email,pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                progressBar.setVisibility(View.INVISIBLE);
                                Toast.makeText(SignUp.this, "Done but must complete your profile", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),Personal_Info_Activity.class));
                                finish();
                            }
                            else {
                                progressBar.setVisibility(View.INVISIBLE);
                                Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }
    }
}
