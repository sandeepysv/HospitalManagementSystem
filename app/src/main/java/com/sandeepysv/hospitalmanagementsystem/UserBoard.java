package com.sandeepysv.hospitalmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import br.com.bloder.magic.view.MagicButton;

public class UserBoard extends AppCompatActivity {

    MagicButton btnbook,btncancel,btnchange,btnlogout;
    private FirebaseAuth auth;
    private TextView txtWelcome;

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
        Toast.makeText(UserBoard.this,"Press BACK again to Exit",Toast.LENGTH_SHORT).show();
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
        setContentView(R.layout.activity_user_board);

        auth = FirebaseAuth.getInstance();
        btnbook = (MagicButton)findViewById(R.id.usr_book_apt);
        btncancel = (MagicButton)findViewById(R.id.usr_cancel_apt);
        btnchange = (MagicButton)findViewById(R.id.usr_change_pass);
        btnlogout = (MagicButton)findViewById(R.id.usr_logout);

        txtWelcome = (TextView)findViewById(R.id.usr_welcome);

        if(auth.getCurrentUser() != null) {
            String uname = auth.getCurrentUser().getEmail();
            txtWelcome.setText("Welcome,\n"+uname+"!");
        }

        btnbook.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserBoard.this,BookAppointment.class));
            }
        });

        btncancel.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserBoard.this,CancelAppointment.class));
            }
        });

        btnchange.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserBoard.this,DashBoard.class));
            }
        });

        btnlogout.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                if(auth.getCurrentUser() == null)
                {
                    startActivity(new Intent(UserBoard.this,MainActivity.class));
                    finish();
                }
            }
        });

    }
}
