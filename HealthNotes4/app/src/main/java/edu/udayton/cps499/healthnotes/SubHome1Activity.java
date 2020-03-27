package edu.udayton.cps499.healthnotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class SubHome1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_home1);

        Button appointmentsBtn = (Button) findViewById(R.id.appointmentsButton);
        Button doctorsBtn = (Button) findViewById(R.id.doctorsButton);
        Button medHistoryBtn = (Button) findViewById(R.id.medicalHistoryButton);

        //onClick of Appointments Button
        appointmentsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // DOESN'T EXIST YET
//                openAppointmentsActivity();
            }
        });

        //onClick of Doctors button
        doctorsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // DOESN'T EXIST YET
//                openDoctorsActivity();
            }
        });

        //onclick of Medical History button
        medHistoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // DOESN'T EXIST YET
//                openMedicalHistoryActivity();
            }
        });
    } //end onCreate

    // DOESN'T EXIST YET
//    // Navigates from SubHome1 -> Appointments
//    public void openAppointmentsActivity() {
//        Intent intent = new Intent(this, AppointmentsActivity.class);
//        startActivity(intent);
//
//    } // end openAppointmentsActivity
//
//    // Navigates from SubHome1 -> Doctors
//    public void openDoctorsActivity() {
//        Intent intent = new Intent(this, DoctorsActivity.class);
//        startActivity(intent);
//
//    } // end openDoctorsActivity
//
//    // Navigates from SubHome1 -> Medical History
//    public void openMedicalHistoryActivity() {
//        Intent intent = new Intent(this, MedicalHistoryActivity.class);
//        startActivity(intent);
//
//    } // end openMedicalHistoryActivity

} //end SubHome1Activity class
