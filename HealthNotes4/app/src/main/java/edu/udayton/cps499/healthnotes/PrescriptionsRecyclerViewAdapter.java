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
    //vars
    private static final String TAG = "PrescRecViewAdapter";

    private ArrayList<Provider> providers = new ArrayList<Provider>();
    private ArrayList<Prescription> scripts = new ArrayList<Prescription>();
    private Context mContext;

    private SimpleDateFormat sdfYMDhms = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");


    public PrescriptionsRecyclerViewAdapter(Context mContext, ArrayList<Provider> providerList, ArrayList<Prescription> listToTake) {
        this.providers = providerList;
        this.scripts = listToTake;
        this.mContext = mContext;
    }

//    public PrescriptionsRecyclerViewAdapter(Context mContext, ArrayList<Provider> providerList, ArrayList<Prescription> scriptList) {
//        this.providers = providerList;
//        this.scripts = scriptList;
//        this.mContext = mContext;
//    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prescription_listitem_default, parent, false);
         ViewHolder holder = new ViewHolder(view);
        return holder;
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
        LocalDateTime dateTime = scripts.get(position).getDatePrescribed();
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm", Locale.ENGLISH);

        String displayDate = formmat1.format(dateTime);

        dateTextView.setText(displayDate);
        nameTextView.setText(scripts.get(position).getName());
        instructions.setText(scripts.get(position).getScriptInstruction().toString());
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
