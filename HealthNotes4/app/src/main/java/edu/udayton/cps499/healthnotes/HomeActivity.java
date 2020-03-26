package edu.udayton.cps499.healthnotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button prescriptionBtn = (Button) findViewById(R.id.perscriptionButton);
        Button medCareBtn = (Button) findViewById(R.id.medicalCareButton);
        Button medConditionBtn = (Button) findViewById(R.id.medicalConditionsButton);

        //onClick of Prescription Button
        prescriptionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scriptIntent = new Intent(HomeActivity.this, PrescriptionsActivity.class);
                startActivity(scriptIntent);
            }
        });

        //onClick of Medical Care button
        medCareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //onclick of Medical Conditions button
        medConditionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }//end onCreate
}//end homeActivity class
