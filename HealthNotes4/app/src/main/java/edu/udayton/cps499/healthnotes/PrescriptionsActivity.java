/*
    Course: CPS 499-14  Spring 2020 Semester @ The University of Dayton
    Author: Michael Graham
    Instructor Tom Ongwere
 */
package edu.udayton.cps499.healthnotes;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import org.w3c.dom.Text;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class PrescriptionsActivity extends AppCompatActivity implements
        PrescriptionsRecyclerViewAdapter.OnNoteListener, View.OnClickListener {

    //VARS
    private static final String TAG = "PrescActivity";
    private static final String DATABASE_NAME = "HealthNotesManager";
    private static final String TABLE_PROVIDERS = "Providers";
    private static final String TABLE_PRESCRIPTIONS = "Prescriptions";
    Dialog myDialog;

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

        //Set Dialog for the take popup
        myDialog = new Dialog(this);


        ImageButton homeBtn = findViewById(R.id.homeButton);
        TextView listBtn = findViewById(R.id.listButton);
        TextView editBtn = findViewById(R.id.editButton);
        TextView addBtn = findViewById(R.id.addButton);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Home Button Clicked");

                Intent homeIntent = new Intent(PrescriptionsActivity.this, HomeActivity.class);
                startActivity(homeIntent);
            }
        });

        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "List Button Clicked");

            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Edit Button Clicked");

            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Add Button Clicked");

                addScript();

            }
        });

        //initialize the ArrayLists
        initArrayList(); //<---adding items to the ArrayLists breaks the program


//        Log.d(TAG, "buildScriptSourceList");
//        buildScriptSourceList();

        Log.d(TAG, "buildScriptTakeList");
        buildScriptTakeList(scriptList);

        Log.d(TAG, "initRecyclerView");
        initRecyclerView(); //initialize the recyclerview

    } //end onCreate


    /*
    Method pulls all prescriptions from the DB and puts them into the list of scripts
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void buildScriptSourceList() {
        //trying to catch initial db being empty
        try {
            String query = "Select*FROM " + TABLE_PRESCRIPTIONS;
            DatabaseHelper dbHandler = new DatabaseHelper(this);
            List<Prescription> tempList = dbHandler.getAllPrescriptions();

            for (Prescription script: tempList) {
                scriptList.add(script);
            }
        } //end try and if there is an error popp to add
        catch ( Exception e ) {
            addScript();
        }


    }

    private void addScript() {
        Intent intent = new Intent(this, PrescriptionsAdd01BasicInfo.class);
        startActivity(intent);
    }


    /*
    Method was built to create test data for the Prescription activities.  This will no longer be needed once
      persistent memory is setup in the form of a persistent database within the app.
     */
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
        PrescriptionsRecyclerViewAdapter adapter = new PrescriptionsRecyclerViewAdapter(this, scriptList, scriptListToTake, this);
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
                currentScript.setId( x );//set id as key value to the index of the medicine from source list of prescribed medicines


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

    @Override
    public void onNoteClick(int position) {
        Log.d(TAG, "Prescription element position: " + position + " was clicked");

        Intent takeIntent = new Intent(this, PrescriptionTake.class);
//        takeIntent.putExtra("scriptList", scriptList);
//        takeIntent.putExtra("scriptListToTake", scriptListToTake);
        takeIntent.putExtra( "takeIndex", position);
        startActivity(takeIntent);


    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "Prescription element onClick");

    }


//    public int takeDialogPop () {
//
//    }


}//end PrescriptionsActivity Class
