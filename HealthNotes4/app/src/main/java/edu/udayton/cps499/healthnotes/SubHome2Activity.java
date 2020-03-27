package edu.udayton.cps499.healthnotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SubHome2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_home2);

        Button medConditionsBtn = (Button) findViewById(R.id.medicalConditionsButton);
        Button notesBtn = (Button) findViewById(R.id.notesButton);

        //onClick of Medical Conditions Button
        medConditionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // DOESN'T EXIST YET
//                openMedicalConditionsActivity();
            }
        });

        //onClick of Notes button
        notesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // DOESN'T EXIST YET
//                openNotesActivity();
            }
        });
    } //end onCreate

    // DOESN'T EXIST YET
//    // Navigates from SubHome2 -> Medical Conditions
//    public void openMedicalConditionsActivity() {
//        Intent intent = new Intent(this, MedicalConditionsActivity.class);
//        startActivity(intent);
//
//    } // end openMedicalConditionsActivity
//
//    // Navigates from SubHome2 -> Notes
//    public void openNotesActivity() {
//        Intent intent = new Intent(this, NotesActivity.class);
//        startActivity(intent);
//
//    } // end openNotesActivity

} //end SubHome2Activity class
