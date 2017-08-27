package com.sandeepysv.hospitalmanagementsystem;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import static android.R.attr.data;

public class NearBy extends AppCompatActivity implements View.OnClickListener {

    Button btnFinish;
    String address;
    private TextView get_place;
    int PLACE_PICKER_REQUEST = 1,day,month,year,hour,min;
    Intent info,mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mIntent = getIntent();
        day = mIntent.getIntExtra("day", 0);
        month = mIntent.getIntExtra("month", 0);
        year = mIntent.getIntExtra("year", 0);
        hour = mIntent.getIntExtra("hour", 0);
        min = mIntent.getIntExtra("min", 0);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnFinish = (Button)findViewById(R.id.finish);
        btnFinish.setOnClickListener(this);
        get_place = (TextView)findViewById(R.id.textView);
        get_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                Intent intent;

                try {
                    intent = builder.build(NearBy.this);
                    startActivityForResult(intent,PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data) {

        boolean isAnHospital = false;
        info = data;

        if(requestCode == PLACE_PICKER_REQUEST)
        {
            if(resultCode == RESULT_OK)
            {
                Place place = PlacePicker.getPlace(this, data);
                for (int i : place.getPlaceTypes()) {
                    if (i == Place.TYPE_DOCTOR || i == Place.TYPE_HEALTH || i == Place.TYPE_HOSPITAL) {
                        isAnHospital = true;
                        break;
                    }
                }
                    address = String.format("Place : \n\n%s",place.getAddress());
                    get_place.setText(address);
                    Toast.makeText(NearBy.this,"Tap on the Place to Choose Again !",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onClick(View view) {

        Place place = PlacePicker.getPlace(this, info);
        address = String.format("Booking Details :\n\nPlace : \n\n%s\n\nDate & Time : \n\n%d/%d/%d\n%d : %d\n\n",place.getAddress(),day,month,year,hour,min);
        get_place.setText(address);
        Toast.makeText(NearBy.this,"Booking Successful !",Toast.LENGTH_SHORT).show();
    }
}
