package edu.udayton.cps499.healthnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class PrescriptionTake extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription_take);

        ArrayList<Prescription> scriptList = (ArrayList<Prescription>) getIntent().getSerializableExtra("scriptList");
        ArrayList<Prescription> scriptListToTake = (ArrayList<Prescription>) getIntent().getSerializableExtra("scriptListToTake");
        int takeIndex = getIntent().getIntExtra("takeIndex", 0);


    }//end OnCreate



}//end Class
