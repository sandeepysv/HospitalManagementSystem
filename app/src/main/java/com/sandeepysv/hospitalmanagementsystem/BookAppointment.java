package com.sandeepysv.hospitalmanagementsystem;

import android.app.assist.AssistStructure;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class BookAppointment extends AppCompatActivity implements View.OnClickListener {

    RadioButton ch1,ch2,ch3,ch4,ch5,ch6,ch7,ch8,ch9,ch10,ch11,ch12,ch13,ch14,ch15;
    Button btnNext;

    List list = new ArrayList();
    static int i=0;
    boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        btnNext = (Button)findViewById(R.id.spec_next);
        ch1 = (RadioButton)findViewById(R.id.radiobutton_cardiologist);
        ch2 = (RadioButton)findViewById(R.id.radiobutton_dermatologist);
        ch3 = (RadioButton)findViewById(R.id.radiobutton_diabetologist);
        ch4 = (RadioButton)findViewById(R.id.radiobutton_endocrinologist);
        ch5 = (RadioButton)findViewById(R.id.radiobutton_ent);
        ch6 = (RadioButton)findViewById(R.id.radiobutton_gastroenterologist);
        ch7 = (RadioButton)findViewById(R.id.radiobutton_gynaecologist);
        ch8 = (RadioButton)findViewById(R.id.radiobutton_neurologist);
        ch9 = (RadioButton)findViewById(R.id.radiobutton_obstetrician);
        ch10 = (RadioButton)findViewById(R.id.radiobutton_oncologist);
        ch11 = (RadioButton)findViewById(R.id.radiobutton_ophthalmologist);
        ch12 = (RadioButton)findViewById(R.id.radiobutton_orthopaedist);
        ch13 = (RadioButton)findViewById(R.id.radiobutton_psychiatrist);
        ch14 = (RadioButton)findViewById(R.id.radiobutton_pulmonologist);
        ch15 = (RadioButton)findViewById(R.id.radiobutton_urologist);

        btnNext.setOnClickListener((View.OnClickListener) this);

        ch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((RadioButton)view).isChecked()) {
                    list.add(ch1.getTag());
                    flag=true;
                }
            }
        });

        ch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((RadioButton)view).isChecked()) {
                    list.add(ch2.getTag());
                    flag=true;
                }
            }
        });

        ch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((RadioButton)view).isChecked()) {
                    list.add(ch3.getTag());
                    flag=true;
                }
            }
        });

        ch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((RadioButton)view).isChecked()) {
                    list.add(ch4.getTag());
                    flag=true;
                }
            }
        });

        ch5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((RadioButton)view).isChecked()) {
                    list.add(ch5.getTag());
                    flag=true;
                }
            }
        });

        ch6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((RadioButton)view).isChecked()) {
                    list.add(ch6.getTag());
                    flag=true;
                }
            }
        });

        ch7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((RadioButton)view).isChecked()) {
                    list.add(ch7.getTag());
                    flag=true;
                }
            }
        });

        ch8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((RadioButton)view).isChecked()) {
                    list.add(ch8.getTag());
                    flag=true;
                }
            }
        });

        ch9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((RadioButton)view).isChecked()) {
                    list.add(ch9.getTag());
                    flag=true;
                }
            }
        });

        ch10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((RadioButton)view).isChecked()) {
                    list.add(ch10.getTag());
                    flag=true;
                }
            }
        });

        ch11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((RadioButton)view).isChecked()) {
                    list.add(ch11.getTag());
                    flag=true;
                }
            }
        });

        ch12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((RadioButton)view).isChecked()) {
                    list.add(ch12.getTag());
                    flag=true;
                }
            }
        });

        ch13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((RadioButton)view).isChecked()) {
                    list.add(ch13.getTag());
                    flag=true;
                }
            }
        });

        ch14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((RadioButton)view).isChecked()) {
                    list.add(ch14.getTag());
                    flag=true;
                }
            }
        });

        ch15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((RadioButton)view).isChecked()) {
                    list.add(ch15.getTag());
                    flag=true;
                }
            }
        });

    }

    public void onClick(View view) {

        if (view.getId() == R.id.spec_next) {
            if(flag == false)
            {
                Toast.makeText(BookAppointment.this,"No Specialist Selected !",Toast.LENGTH_SHORT).show();
            }
            else startActivity(new Intent(BookAppointment.this, BookAppointmentTime.class));
        }
    }
}

