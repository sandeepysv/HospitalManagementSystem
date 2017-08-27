package com.sandeepysv.hospitalmanagementsystem;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin;
    EditText input_email,input_password;
    TextView btnSignup,btnForgotPass;
    private ProgressBar progressBar;

    RelativeLayout activity_main;

    private FirebaseAuth auth;

    boolean twice;

    @Override
    public void onBackPressed() {

        if(twice == true)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);
        }
        twice = true;
        //super.onBackPressed();
        Toast.makeText(MainActivity.this,"Press BACK again to Exit",Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                twice = false;
            }
        },3000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //View
        btnLogin = (Button)findViewById(R.id.login_btn_login);
        input_email = (EditText)findViewById(R.id.login_email);
        input_password = (EditText)findViewById(R.id.login_password);
        btnSignup = (TextView)findViewById(R.id.login_btn_signup);
        btnForgotPass = (TextView)findViewById(R.id.login_btn_forgot_password);
        activity_main = (RelativeLayout)findViewById(R.id.activity_main);

        btnSignup.setOnClickListener(this);
        btnForgotPass.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

        //Init Firebase Auth
        auth = FirebaseAuth.getInstance();

        //Check already Session , if Ok->Dashboard
        if(auth.getCurrentUser() != null)
            startActivity(new Intent(MainActivity.this,UserBoard.class));
    }

    private void loginUser(String email, final String password) {

        auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            if(password.length() < 8)
                            {
                                Toast.makeText(MainActivity.this,"Invalid Password!",Toast.LENGTH_LONG).show();
                            }
                            else {
                                startActivity(new Intent(MainActivity.this, UserBoard.class));
                            }
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.login_btn_forgot_password)
        {
            startActivity(new Intent(MainActivity.this,ForgotPassword.class));
        }
        else if(view.getId() == R.id.login_btn_signup)
        {
            startActivity(new Intent(MainActivity.this,SignUp.class));
        }
        else if(view.getId() == R.id.login_btn_login)
        {
            progressBar = (ProgressBar)findViewById(R.id.progressBar);
            progressBar.setVisibility(View.VISIBLE);

            if((input_email.getText().toString().length() < 8) && (input_password.getText().toString().length() < 8))
            {
                Toast.makeText(MainActivity.this,"Invalid Credentials!",Toast.LENGTH_SHORT).show();
            }
            loginUser(input_email.getText().toString(),input_password.getText().toString());
        }
    }
}