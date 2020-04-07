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
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class PrescriptionsActivity extends AppCompatActivity {
    //VARS
    private static final String TAG = "PrescActivity";

    //create example data
    //load lists with default test data
    private ArrayList<Provider> providerList = new ArrayList<>();
    private ArrayList<Prescription> scriptList = new ArrayList<>();
    private ArrayList<Prescription> scriptListToTake = new ArrayList<>();


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescriptions);

        ImageButton homeBtn = findViewById(R.id.homeButton);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(PrescriptionsActivity.this, HomeActivity.class);
                startActivity(homeIntent);
            }
        });

        //initialize the ArrayLists
        initArrayList(); //<---adding items to the ArrayLists breaks the program

        buildScriptTakeList(scriptList);

        //ArrayList<Prescription> listToTake = buildScriptTakeList(scriptList);

        initRecyclerView(); //initialize the recyclerview

    } //end onCreate

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void initArrayList() {
        Log.d(TAG, "initArrayList");
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

        //OncePerDays(all options)
        scriptList.add(new Prescription("OnePerDayMorning", "10mg", "1 pill once a day",
                LocalDateTime.of(2019,4,1,0,0,1), providerList.get(0), new PrescriptionsInstruction(1, 1, "Pill",
                false, null, 2, 1, false, -1, false, "", "", new int[] {1,0,0,0,0,0}) ) );
//        scriptList.add(new Prescription("OnePerDayMidmorning", "10mg", "1 pill once a day",
//                LocalDateTime.of(2019,4,1,0,0,1), providerList.get(0), new PrescriptionsInstruction(1, 1, "Pill",
//                false, null, 2, 1, false, -1, false, "", "", new int[] {2,0,0,0,0,0}) ) );
        scriptList.add(new Prescription("OnePerDayAfternoon", "10mg", "1 pill once a day",
                LocalDateTime.of(2019,4,1,0,0,1), providerList.get(0), new PrescriptionsInstruction(1, 1, "Pill",
                false, null, 2, 1, false, -1, false, "", "", new int[] {3,0,0,0,0,0}) ) );
//        scriptList.add(new Prescription("OnePerDayMidafternoon", "10mg", "1 pill once a day",
//                LocalDateTime.of(2019,4,1,0,0,1), providerList.get(0), new PrescriptionsInstruction(1, 1, "Pill",
//                false, null, 2, 1, false, -1, false, "", "", new int[] {4,0,0,0,0,0}) ) );
        scriptList.add(new Prescription("OnePerDayEvening", "10mg", "1 pill once a day",
                LocalDateTime.of(2019,4,1,0,0,1), providerList.get(0), new PrescriptionsInstruction(1, 1, "Pill",
                false, null, 2, 1, false, -1, false, "", "", new int[] {5,0,0,0,0,0}) ) );

//        scriptList.add(new Prescription("OnePerDayNight", "50mg", "1 pill once a day",
//                LocalDateTime.of(2020,2,1,0,0,1), providerList.get(3), new PrescriptionsInstruction(1, 1, "Pill", false,
//                null, 2, 1, false, -1, false, "", "", new int[] {6,0,0,0,0,0}) ) );

        //Pill three times a day
        scriptList.add(new Prescription("OnePill3XperDay", "500mg", "1 pill three times a day",
                LocalDateTime.of(2020,3,25,0,0,1), providerList.get(1), new PrescriptionsInstruction(1, 1, "Pill", false,
                null, 2, 3, false, -1, false, null, "", new int[] {1,0,0,0,0,0} ) ) );

        //Pill three times a day
//        scriptList.add(new Prescription("OnePill4XperDay", "400mg", "1 pill three times a day",
//                LocalDateTime.of(2020,3,25,0,0,1), providerList.get(1), new PrescriptionsInstruction(1, 1, "Pill", false,
//                null, 2, 4, false, -1, false, null, "", new int[] {1,0,0,0,0,0} ) ) );


        scriptList.add(new Prescription("Every4Hours", "5mg", "1 pill every 4 hrs as needed for pain.",
                LocalDateTime.of(2019, 12, 5,0,0,1), providerList.get(2), new PrescriptionsInstruction(1, 1, "Pill",
                false, null, 1, 4, false, -1, true, "pain", "Take with food.", new int[] {1,0,0,0,0,0})) );
//        scriptList.add(new Prescription("Every6Hours", "5mg", "1 pill every 4 hrs as needed for pain.",
//                LocalDateTime.of(2020, 4, 6,15,0,1), providerList.get(2), new PrescriptionsInstruction(1, 1, "Pill",
//                false, null, 1, 6, false, -1, true, "pain", "Take with food.", new int[] {1,0,0,0,0,0})) );

    }//end initArray

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView.LayoutManager mLayoutManager = new
                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        RecyclerView recyclerView = findViewById(R.id.prescriptionsListRecyclerView);
        PrescriptionsRecyclerViewAdapter adapter = new PrescriptionsRecyclerViewAdapter(this, providerList, scriptListToTake);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void buildScriptTakeList(ArrayList<Prescription> sourceList){

        int hoursToFigure = 18; //number of hours to build the list for.
        //ArrayList<Prescription> listToTake = new ArrayList<>();
        LocalDateTime dateCurrent = LocalDateTime.now();
        LocalDateTime dateLimit = dateCurrent.plusHours(hoursToFigure);

        for (int x = 0; x < sourceList.size(); x++) {
            LocalDateTime dateToTake = LocalDateTime.of(2010, 1, 1,0, 0, 0);

            Prescription currentScript = new Prescription(sourceList.get(x));

            //while next take falls within the next hoursToFigure hours
            Boolean done = false;
            int failOutLoopCount = 0;

            while ( !done && (failOutLoopCount < 10) ) {
                failOutLoopCount++;
                Prescription scriptToAdd = new Prescription(currentScript);
                dateToTake = scriptToAdd.calcScriptNextTakeDate();
                scriptToAdd.setScriptNextTakeDate(dateToTake);
                currentScript.setScriptNextTakeDate(dateToTake);

                Log.d(TAG, "while loop init dateToTake: " + dateToTake + " scriptToAdd-DateToTake: " + scriptToAdd.getScriptNextTakeDate() );

                //if within the next hoursToFigure
                if (dateToTake.isBefore(dateLimit)) {
                    Log.d(TAG, "Current plus hours to figure: " + dateLimit);
                    Log.d(TAG, "Adding " + scriptToAdd.getScriptName() + "to ListTBT at " + dateToTake);

                    scriptListToTake.add(scriptToAdd);
                } else { //if not then flag as done
                    Log.d(TAG, "Done adding to scriptListToTake");
                    done = true;
                }
            }//end while

        }//end for loop

        //sort listToTake (will use selection sort)
        for (int i = 0; i < (scriptListToTake.size() - 1); i++) {
            int lowestIndex = i;
            for (int j = i + 1; j < scriptListToTake.size(); j++) {
                //if date in index j comes before the date at index i set lowest index to j
                if ( scriptListToTake.get(j).getScriptNextTakeDate().isBefore(scriptListToTake.get(lowestIndex).getScriptNextTakeDate())){
                    lowestIndex = j;
                }//end if
            }//end inner for loop
            //swap
            Prescription temp = new Prescription(scriptListToTake.get(i));
            scriptListToTake.set(i, new Prescription(scriptListToTake.get(lowestIndex)));
            scriptListToTake.set(lowestIndex, new Prescription(temp));
        }//end outer for loop

    }//end buildScriptTakeList

}//end PrescriptionsActivity Class
