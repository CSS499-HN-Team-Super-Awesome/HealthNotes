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

        Button prescriptionBtn = (Button) findViewById(R.id.prescriptionButton);
        Button medCareBtn = (Button) findViewById(R.id.medicalCareButton);
        Button medConditionBtn = (Button) findViewById(R.id.medicalConditionsButton);

        //onClick of Prescription Button
        prescriptionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openPrescriptionsActivity();
            }
        });

        //onClick of Medical Care button
        medCareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSubHome1Activity();
            }
        });

        //onclick of Medical Conditions button
        medConditionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // DOESN'T EXIST YET
//                openSubHome2Activity();
            }
        });
    }//end onCreate

    // Navigates from Home -> Prescriptions
    public void openPrescriptionsActivity() {
        Intent intent = new Intent(this, PrescriptionsActivity.class);
        startActivity(intent);

    } // end openPrescriptionsActivity

    // Navigates from Home -> SubHome1
    public void openSubHome1Activity() {
        Intent intent = new Intent(this, SubHome1Activity.class);
        startActivity(intent);

    } // end openSubHome1Activity

    // DOESN'T EXIST YET.
//    // Navigates from Home -> SubHome2
//    public void openSubHome2Activity() {
//        Intent intent = new Intent(this, SubHome2Activity.class);
//        startActivity(intent);
//
//    } // end openSubHome2Activity

}//end homeActivity class
