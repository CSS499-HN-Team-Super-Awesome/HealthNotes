package edu.udayton.cps499.healthnotes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Node;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Queue;

public class PrescriptionsActivity extends AppCompatActivity {
    //VARS
    private static final String TAG = "PrescActivity";

    //create example data
    //load lists with default test data
    private ArrayList<Provider> providerList = new ArrayList<>();
    private ArrayList<Prescription> scriptList = new ArrayList<>();


    @RequiresApi(api = Build.VERSION_CODES.O)
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

        //ArrayList<Prescription> listToTake = buildScriptTakeList(scriptList);

        initRecyclerView(); //initialize the recyclerview

    } //end onCreate

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void initArrayList() {
        providerList.add(new Provider("Dr.", "John Doe", "Some St", "Dayton", "Ohio",
                "45420", "9375551212", "Cardiologist"));
        providerList.add(new Provider("Dr.", "Jane Doe", "This Way", "Kettering", "Ohio",
                "45429", "9375552121", "General Practice"));
        providerList.add(new Provider("NP.", "Joseph Doe", "Answer Blvd", "Springboro", "Ohio",
                "45066", "9371234567", "Neurology"));
        providerList.add(new Provider("Dr.", "Janet Doe", "Special Ave", "Dayton", "Ohio",
                "45420", "9377654321", "Psychiatrist"));

        /* type, int amountQty, String amountUnit, boolean asDirected, String amountOtherDirection,
        int timingInterval, int timingAmount, boolean durationLimited, int durationInDays,
        boolean isAsNeeded, String asNeededFor, String notes)*/
        //LocalDateTime cal = LocalDateTime.of(2020, 3, 17, 0,0,0);
        scriptList.add(new Prescription("Amlodipine", "10mg", "1 pill once a day",
                LocalDateTime.of(2019,4,1,0,0,0), providerList.get(0), new PrescriptionsInstruction(1, 1, "Pill",
                false, null, 2, 1, false, -1, false, "", "") ) );
        scriptList.add(new Prescription("Amoxicillin", "500mg", "1 pill three times a day",
                LocalDateTime.of(2020,3,25,0,0,0), providerList.get(1), new PrescriptionsInstruction(1, 1, "Pill", false,
                null, 2, 3, false, -1, false, null, "" ) ) );
        scriptList.add(new Prescription("Oxycodone", "5-325mg", "1 pill every 4 hrs as needed for pain.",
                LocalDateTime.of(2019, 12, 5,0,0,0), providerList.get(2), new PrescriptionsInstruction(1, 1, "Pill",
                false, null, 1, 4, false, -1, true, "pain", "Take with food.")) );
        scriptList.add(new Prescription("Sertraline", "50mg", "1 pill once a day",
                LocalDateTime.of(2020,2,1,0,0,0), providerList.get(3), new PrescriptionsInstruction(1, 1, "Pill", false,
                null, 2, 1, false, -1, false, "", "") ) );
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView.LayoutManager mLayoutManager = new
                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        RecyclerView recyclerView = findViewById(R.id.prescriptionsListRecyclerView);
        PrescriptionsRecyclerViewAdapter adapter = new PrescriptionsRecyclerViewAdapter(this, providerList, scriptList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private ArrayList<Prescription> buildScriptTakeList(ArrayList<Prescription> sourceList){

        int hoursToFigure = 36; //number of hours to build the list for.
        ArrayList<Prescription> listToTake = new ArrayList<>();
        Queue<Prescription> hourlyQueue = null;
        Queue<Prescription> xPerDayQueue = null;
        Queue<Prescription> everyXDaysQueue = null;
        Queue<Prescription> asDirectedQueue = null;


        for (int x = 0; x < sourceList.size(); x++) {
            LocalDateTime dateLastTaken = sourceList.get(x).getScriptLastTakenDate();
            LocalDateTime dateToTake;
            LocalDateTime dateCurrent = LocalDateTime.now();

            Prescription currentScript = sourceList.get(x);
            PrescriptionsInstruction instructions = currentScript.getScriptInstruction();

            //act based on whether next use is within 36hours of now.
            //timed intervals
//            private final int EVERYHOURS = 1;
//            private final int TIMESPERDAY = 2;
//            private final int EVERYXDAYS = 3;
//            private final int ASDIRECTED = 99;
            //If instructions are for hourly
            if ( (instructions.getTimingInterval() == 1)  ){
                int hoursRemaining = hoursToFigure;
                while (hoursRemaining > instructions.getTimingAmount()) {
                    // If dateLastTaken is null or it plus the timingAmt is still less than the current date set next take to right now
                    if (dateLastTaken == null || ( dateCurrent.compareTo(currentScript.getScriptLastTakenDate().
                            plusHours(instructions.getTimingAmount())) >= 0) ) {

                        currentScript.setScriptNextTakeDate(dateCurrent);

                    }
                    // If not then set to lastTaken Plus 4 hours

                    else {

                        currentScript.setScriptNextTakeDate(currentScript.getScriptLastTakenDate().plusHours(instructions.getTimingAmount()));

                    }

                    hoursRemaining -= instructions.getTimingAmount();

                    hourlyQueue.add(currentScript);
                    listToTake.add(currentScript);
                } //end while
            } //end if

            //if timesper day
            else if (instructions.getTimingInterval() == 2) {

            }
            //if everyXdays

            else if (instructions.getTimingInterval() == 3) {

            }else {
                //to implement later
            }




            if (dateLastTaken == null){ //new never taken before

            } else {

            }
        }//end for

        Prescription[] arrayToTake = new Prescription[listToTake.size()];
        for (int x = 0; x < arrayToTake.length; x++){
            arrayToTake[x] = listToTake.get(x);
        }
        Arrays.sort(arrayToTake);
        for (int x = 0; x < arrayToTake.length; x++){
            listToTake.set(x, arrayToTake[x]);
        }

        return listToTake;

    }//endbuildScriptTakeList

}//end PrescriptionsActivity Class
