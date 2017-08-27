package com.sandeepysv.hospitalmanagementsystem;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import br.com.bloder.magic.view.MagicButton;
import java.util.Calendar;

public class BookAppointmentTime extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener {

    MagicButton btnset;
    int day,month,year,hour,minute;
    int dayFinal,monthFinal,yearFinal,hourFinal,minuteFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment_time);

        btnset = (br.com.bloder.magic.view.MagicButton)findViewById(R.id.usr_set);

        btnset.setMagicButtonClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(BookAppointmentTime.this,BookAppointmentTime.this,year,month,day);
            datePickerDialog.show();
         }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        yearFinal = i;
        monthFinal = i1+1;
        dayFinal = i2;

        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(BookAppointmentTime.this,BookAppointmentTime.this,hour,minute, DateFormat.is24HourFormat(this));
        timePickerDialog.show();

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        hourFinal = i;
        minuteFinal = i1;
        Intent intent = new Intent(BookAppointmentTime.this, NearBy.class);

        intent.putExtra("day",dayFinal);
        intent.putExtra("month",monthFinal);
        intent.putExtra("year",yearFinal);
        intent.putExtra("hour",hourFinal);
        intent.putExtra("min",minuteFinal);

        startActivity(intent);
    }
}
