package edu.udayton.cps499.healthnotes;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;

public class PrescriptionsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "PrescRecViewAdapter";

    private ArrayList<Provider> providerList = new ArrayList<Provider>();
    private ArrayList<Prescription> scriptList = new ArrayList<Prescription>();
    //load lists with default test data
//    private ArrayList<Provider> providerList = new ArrayList<Provider> () {
//        {
//            add(new Provider("Dr.", "John Doe", 123, "Some St", "Dayton",
//                    "45420", "9375551212", "Cardiologist"));
//            add(new Provider("Dr.", "Jane Doe", 321, "This Way", "Kettering",
//                    "45429", "9375552121", "General Practice"));
//            add(new Provider("NP.", "Joseph Doe", 42, "Answer Blvd", "Springboro",
//                    "45066", "9371234567", "Neurology"));
//            add(new Provider("Dr.", "Janet Doe", 88, "Special Ave", "Dayton",
//                    "45420", "9377654321", "Psychiatrist"));
//        }};
//
//    private ArrayList<Prescription> scriptList = new ArrayList<Prescription>() {
//        {
//            add(new Prescription("Amlodipine", "10mg", "1 pill once a day",
//                    "2020,3,20", 0 ) );
//            add(new Prescription("Amoxicillin", "500mg", "1 pill three times a day",
//                    "2020,3,20", 1 ) );
//            add(new Prescription("Oxycodone", "5-325mg", "1 pill every 4 hrs as needed",
//                    "2020,3,20", 2 ) );
//            add(new Prescription("Sertraline", "50mg", "1 pill once a day",
//                    "2020,3,20", 3 ) );
//
//        }};
    private Context mContext;
    //end build test object list


    public PrescriptionsRecyclerViewAdapter(Context mContext, ArrayList<Provider> providerList, ArrayList<Prescription> scriptList) {
        this.providerList = providerList;
        this.scriptList = scriptList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prescription_listitem_default, parent, false);
         ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder");

        TextView date = holder.itemView.findViewById(R.id.takeAtDateTextView);
        TextView name = holder.itemView.findViewById(R.id.nameTextView);
        TextView instructions = holder.itemView.findViewById(R.id.instructionsTextView);

        Prescription item = scriptList.get(position);

        date.setText(item.getDatePrescribed().toString());
        name.setText(item.getName());
        instructions.setText(item.getInstructions());
    }

    @Override
    public int getItemCount() {
        return scriptList.size();
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
            takeNextTextView = takeNextTextView.findViewById(R.id.takeAtLabelTextView);
            nameTextView = nameTextView.findViewById(R.id.nameTextView);
            instructionsTextView = instructionsTextView.findViewById(R.id.instructionsTextView);
            takeBtn = takeBtn.findViewById(R.id.takeButton);
            notesBtn = notesBtn.findViewById(R.id.notesButton);
            infoBtn = infoBtn.findViewById(R.id.infoButton);



        }//end ViewHolder
    }


}//end Adapter class
