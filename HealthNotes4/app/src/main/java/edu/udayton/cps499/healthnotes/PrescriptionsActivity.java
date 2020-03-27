package edu.udayton.cps499.healthnotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class PrescriptionsActivity extends AppCompatActivity {
    //VARS
    private static final String TAG = "PrescActivity";

    //create example data
    //load lists with default test data
    private ArrayList<Provider> providerList = new ArrayList<>();
    private ArrayList<Prescription> scriptList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescriptions);

        Button homeBtn = findViewById(R.id.homeButton);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(PrescriptionsActivity.this, HomeActivity.class);
                startActivity(homeIntent);
            }
        });

        //initialize the ArrayLists
        initArrayList(); //<---adding items to the ArrayLists breaks the program

        initRecyclerView(); //initialize the recyclerview

    } //end onCreate

    private void initArrayList() {
        providerList.add(new Provider("Dr.", "John Doe", 123, "Some St", "Dayton",
                "45420", "9375551212", "Cardiologist"));
        providerList.add(new Provider("Dr.", "Jane Doe", 321, "This Way", "Kettering",
                "45429", "9375552121", "General Practice"));
        providerList.add(new Provider("NP.", "Joseph Doe", 42, "Answer Blvd", "Springboro",
                "45066", "9371234567", "Neurology"));
        providerList.add(new Provider("Dr.", "Janet Doe", 88, "Special Ave", "Dayton",
                "45420", "9377654321", "Psychiatrist"));

        scriptList.add(new Prescription("Amlodipine", "10mg", "1 pill once a day",
                "2019,4,1", 0 ) );
        scriptList.add(new Prescription("Amoxicillin", "500mg", "1 pill three times a day",
                "2020,3,20", 1 ) );
        scriptList.add(new Prescription("Oxycodone", "5-325mg", "1 pill every 4 hrs as needed",
                "2019,3,17", 2 ) );
        scriptList.add(new Prescription("Sertraline", "50mg", "1 pill once a day",
                "2019,4,15", 3 ) );

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerviewr");

        RecyclerView recyclerView = findViewById(R.id.prescriptionsListRecyclerView);
        PrescriptionsRecyclerViewAdapter adapter = new PrescriptionsRecyclerViewAdapter(this, providerList, scriptList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}//end PrescriptionsActivity Class
