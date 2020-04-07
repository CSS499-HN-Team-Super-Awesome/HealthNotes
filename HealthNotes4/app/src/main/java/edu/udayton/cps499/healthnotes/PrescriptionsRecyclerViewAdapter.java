package edu.udayton.cps499.healthnotes;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class PrescriptionsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //declare interface


    //vars
    private static final String TAG = "PrescRecViewAdapter";

    //constants
    private final int DEFAULT = 0;
    private final int DUENOW = 1;
    private final int OVERDUE = 2;

    private final int MINUTESTOPAD = 30; //used to flag items not overdue if still within x minutes of take time

    private ArrayList<Provider> providers = new ArrayList<Provider>();
    private ArrayList<Prescription> scripts = new ArrayList<Prescription>();
    private ArrayList<Prescription> scriptsTakeList = new ArrayList<Prescription>();
    private Context mContext;

    private SimpleDateFormat sdfYMDhms = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
    private SimpleDateFormat sdfMD12Hour = new SimpleDateFormat("MMM dd hh:mm aa");
    private SimpleDateFormat sdf12HourTime = new SimpleDateFormat("hh:mm aa");


    public PrescriptionsRecyclerViewAdapter(Context mContext, ArrayList<Provider> providerList, ArrayList<Prescription> listToTake) {
        this.providers = providerList;
        this.scripts = listToTake;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "viewType: " + viewType);

        View view;
        if ( viewType == 1 ) { //due now = green
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prescription_listitem_green, parent, false);
        }
        else if ( viewType == 2 ){ //overdue = red
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prescription_listitem_red, parent, false);
        }
        else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prescription_listitem_default, parent, false);
        }


//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prescription_listitem_default, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int getItemViewType(int position) {
        if (scripts.get(position).getScriptNextTakeDate().isBefore(LocalDateTime.now().minusMinutes(MINUTESTOPAD))) { //if before X minutes ago
            return OVERDUE;
        }
        else if (scripts.get(position).getScriptNextTakeDate().isBefore(LocalDateTime.now().plusMinutes(MINUTESTOPAD))) {
            return DUENOW;
        }
        else {
            return DEFAULT;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder");

        //set TextViews
        TextView dateTextView = holder.itemView.findViewById(R.id.takeAtDateTextView);
        TextView nameTextView = holder.itemView.findViewById(R.id.nameTextView);
        TextView instructions = holder.itemView.findViewById(R.id.instructionsTextView);

        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        LocalDateTime dateTime = scripts.get(position).getScriptNextTakeDate();

        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);
        DateTimeFormatter formmat2 = DateTimeFormatter.ofPattern("MMM dd hh:mm a", Locale.ENGLISH);

        String displayScriptScheduledDate = formmat2.format(dateTime);
        String displayScriptScheduledTime = formmat1.format(dateTime);
        String displayScriptDue = "";

        int dayToTake = dateTime.getDayOfMonth();
        int dayNow = LocalDateTime.now().getDayOfMonth();

        if ( dayNow == dayToTake ) {
            displayScriptDue += "Today at: " + displayScriptScheduledTime;
        }
        else if ( dayNow + 1 == dayToTake ) {
            displayScriptDue += "Tomorrow at: " + displayScriptScheduledTime;
        }
        else if ( dayNow - 1 == dayToTake )  {
            displayScriptDue += "Yesterday at: " + displayScriptScheduledTime;
        }
        else {
            displayScriptDue += displayScriptScheduledDate;
        }

        dateTextView.setText(displayScriptDue);
        nameTextView.setText(scripts.get(position).getScriptName());
        instructions.setText(scripts.get(position).getScriptInstruction().toString());

        //buttons


    }

    @Override
    public int getItemCount() {
        return scripts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView takeNextTextView;
        TextView nameTextView;
        TextView instructionsTextView;
        Button takeBtn;
        Button notesBtn;
        Button infoBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            assert takeNextTextView != null;
            takeNextTextView = itemView.findViewById(R.id.takeAtLabelTextView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            instructionsTextView = itemView.findViewById(R.id.instructionsTextView);
            takeBtn = itemView.findViewById(R.id.takeButton);
            notesBtn = itemView.findViewById(R.id.notesButton);
            infoBtn = itemView.findViewById(R.id.infoButton);

        }//end ViewHolder
    }//end ViewHolder Method


}//end Adapter class
