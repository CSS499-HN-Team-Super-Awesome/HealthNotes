/*
    Course: CPS 499-14  Spring 2020 Semester @ The University of Dayton
    Author: Michael Graham
    Instructor Tom Ongwere

 */
package edu.udayton.cps499.healthnotes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;

import java.time.LocalDateTime;

public class PrescriptionsAdd01BasicInfo extends AppCompatActivity {
    private static final String TAG = "PrescriptionsAdd01";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescriptions_add01_basic_info);

        ImageButton homeBtn = findViewById(R.id.homeButton);
        Button addBtn = findViewById(R.id.addButton);
        Button cancelBtn = findViewById(R.id.cancelButton);
        ImageButton scriptPicture = findViewById(R.id.scriptImageButton);


        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Home Button Clicked");

                goHome();
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Add Button Clicked");

                EditText scriptNameText = findViewById(R.id.scriptNamePlainText);
                EditText scriptDatePrescribedText = findViewById(R.id.datePrescribed);
                EditText scriptDateTaken = findViewById(R.id.lastDateTaken);
                EditText scriptTimeText = findViewById(R.id.lastTakenTime);
                ImageButton scriptPicture = findViewById(R.id.scriptImageButton);
                EditText scriptNotes = findViewById(R.id.notesEditText);
                RadioButton everyXHoursButton = findViewById(R.id.freqEveryXHours);
                RadioButton xTimesADay = findViewById(R.id.freqXTimesPerDay);
                EditText intervalHours = findViewById(R.id.hoursEditText);
                EditText intervalDays = findViewById(R.id.xTimesADayEditText);
                EditText rxNumber = findViewById(R.id.rxNumberEditText);


                Prescription newScript = new Prescription(scriptNameText.toString());

                newScript.setScriptDatePrescribed( LocalDateTime.parse(scriptDatePrescribedText.toString()) );

                String dateTaken = scriptDateTaken.toString() + 'T' + scriptTimeText.toString();
                newScript.setScriptLastTakenDate( LocalDateTime.parse( dateTaken ));

//                newScript.setId(Integer.parseInt(rxNumber.toString()));

                if ( everyXHoursButton.isChecked() ) {
                    newScript.setScriptInstruction(new PrescriptionsInstruction(1, 1, "Pill", false, null, 1, Integer.parseInt(intervalHours.toString()),
                            false, -1, false, "", scriptNotes.toString(), new int[] {1,0,0,0,0,0}));
                } else {
                    newScript.setScriptInstruction(new PrescriptionsInstruction(1, 1, "Pill", false, null, 2, Integer.parseInt(intervalDays.toString()),
                            false, -1, false, "", scriptNotes.toString(), new int[] {1,0,0,0,0,0}));
                }
                //add coding for camera to take picture of script

                addScript(newScript);
            }
        });//end addbtn onClickListener

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        scriptPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity( intent );
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });//end camera onclicklistener

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void addScript(Prescription script) {

        DatabaseHelper dbHandler = new DatabaseHelper(this);
        dbHandler.addPrescription(script);


    }

    private void goHome() {
        Intent homeIntent = new Intent(PrescriptionsAdd01BasicInfo.this, HomeActivity.class);
        startActivity(homeIntent);
    }
}
