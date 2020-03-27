package edu.udayton.cps499.healthnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class PrescriptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescriptions);

        //create example data
        ArrayList<Provider> providerList = new ArrayList<>();
        providerList.add(new Provider("Dr.", "John Doe", 123, "Some St", "Dayton",
                "45420", "9375551212", "Cardiologist"));
        providerList.add(new Provider("Dr.", "Jane Doe", 321, "This Way", "Kettering",
                "45429", "9375552121", "General Practice"));
        providerList.add(new Provider("NP.", "Joseph Doe", 42, "Answer Blvd", "Springboro",
                "45066", "9371234567", "Neurology"));
        providerList.add(new Provider("Dr.", "Janet Doe", 88, "Special Ave", "Dayton",
                "45420", "9377654321", "Psychiatrist"));

        ArrayList<Prescription> scriptList = new ArrayList<>();
        //String name, String strength, String instructions, Date datePrescribed, Provider provider
        scriptList.add(new Prescription("Amlodipine", "10mg", "1 pill once a day",
                new Date(2019,4,1), 0 ) );
        scriptList.add(new Prescription("Amoxicillin", "500mg", "1 pill three times a day",
                new Date(2020,3,20), 1 ) );
        scriptList.add(new Prescription("Oxycodone", "5-325mg", "1 pill every 4 hrs as needed",
                new Date(2019,3,17), 2 ) );
        scriptList.add(new Prescription("Sertraline", "50mg", "1 pill once a day",
                new Date(2019,4,15), 3 ) );
        //end build test object list







    } //end onCreate



}//end PrescriptionsActivity Class
