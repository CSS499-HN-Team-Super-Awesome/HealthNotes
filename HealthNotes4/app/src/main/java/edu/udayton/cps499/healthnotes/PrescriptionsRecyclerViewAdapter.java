/*
    Course: CPS 499-14  Spring 2020 Semester @ The University of Dayton
    Author: Michael Graham
    Instructor Tom Ongwere

 */

package edu.udayton.cps499.healthnotes;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class PrescriptionsRecyclerViewAdapter extends RecyclerView.Adapter<PrescriptionsRecyclerViewAdapter.ViewHolder> {
    //declare interface


    //vars
    private static final String TAG = "PrescRecViewAdapter";

    //constants
    private final int DEFAULT = 0;
    private final int DUENOW = 1;
    private final int OVERDUE = 2;

    private final int MINUTESTOPAD = 30; //used to flag items not overdue if still within x minutes of take time

    private ArrayList<Prescription> scriptList = new ArrayList<>();
    private ArrayList<Prescription> scriptListToTake = new ArrayList<>();
    private ArrayList<Prescription> scriptsTakeList = new ArrayList<>();
    private Context mContext;

    private SimpleDateFormat sdfYMDhms = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
    private SimpleDateFormat sdfMD12Hour = new SimpleDateFormat("MMM dd hh:mm aa");
    private SimpleDateFormat sdf12HourTime = new SimpleDateFormat("hh:mm aa");

    private OnNoteListener mOnNoteListener;


    public PrescriptionsRecyclerViewAdapter(Context mContext, ArrayList<Prescription> scriptList,
                                            ArrayList<Prescription> listToTake, OnNoteListener onNoteListener) {
        this.scriptList = scriptList;
        this.scriptListToTake = listToTake;
        this.mContext = mContext;
        this.mOnNoteListener = onNoteListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "viewType: " + viewType);

        View view;
        if ( viewType == 1 ) { //due now = green
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prescription_listitem_green_style3, parent, false);
        }
        else if ( viewType == 2 ){ //overdue = red
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prescription_listitem_red_style3, parent, false);
        }
        else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prescription_listitem_default_style3, parent, false);
        }

        //ViewHolder holder = new ViewHolder(view, mOnNoteListener);
        return new ViewHolder(view, mOnNoteListener);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int getItemViewType(int position) {
        if (scriptListToTake.get(position).isOverdue()) { //if before X minutes ago
            return OVERDUE;
        }
        else if (scriptListToTake.get(position).isDue()) {
            return DUENOW;
        }
        else {
            return DEFAULT;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder");

        //set TextViews
        TextView dateTextView = holder.itemView.findViewById(R.id.takeAtDateTextView);
        TextView nameTextView = holder.itemView.findViewById(R.id.nameTextView);
        TextView instructions = holder.itemView.findViewById(R.id.instructionsTextView);

        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        LocalDateTime nextTakeDate = scriptListToTake.get(position).getScriptNextTakeDate();

        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);
        DateTimeFormatter formmat2 = DateTimeFormatter.ofPattern("MMM dd hh:mm a", Locale.ENGLISH);

        String displayScriptScheduledDate = formmat2.format(nextTakeDate);
        String displayScriptScheduledTime = formmat1.format(nextTakeDate);
        String displayScriptDue = "";

//        int dayToTake = nextTakeDate.getDayOfMonth();
//        int dayNow = LocalDateTime.now().getDayOfMonth();

//        if ( nextTakeDate.getDayOfMonth() == LocalDateTime.now().getDayOfMonth() ) {
//            displayScriptDue += "Today at: " + displayScriptScheduledTime;
//        }
//        else if ( nextTakeDate.getDayOfMonth() == LocalDateTime.now().plusDays(1).getDayOfMonth() ) {
//            displayScriptDue += "Tomorrow at: " + displayScriptScheduledTime;
//        }
//        else if ( nextTakeDate.getDayOfMonth() == LocalDateTime.now().minusDays(1).getDayOfMonth() )  {
//            displayScriptDue += "Yesterday at: " + displayScriptScheduledTime;
//        }
//        else {
            displayScriptDue += displayScriptScheduledDate;
//        }

        dateTextView.setText(displayScriptDue);
        nameTextView.setText(scriptListToTake.get(position).getScriptName());
        instructions.setText(scriptListToTake.get(position).getScriptInstruction().toString());

    }


    @Override
    public int getItemCount() {
        return scriptListToTake.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        OnNoteListener mOnNoteListener;

        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);

            this.mOnNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }//end ViewHolder

        @Override
        public void onClick(View v) {

            Log.d(TAG, "onClick: " + getAdapterPosition());
            mOnNoteListener.onNoteClick(getAdapterPosition());
        }
    }//end ViewHolder Method

    public interface OnNoteListener {
        void onNoteClick(int position);
    }
}//end Adapter class
