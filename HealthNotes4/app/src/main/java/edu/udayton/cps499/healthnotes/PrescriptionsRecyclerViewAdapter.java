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

import java.util.ArrayList;

public class PrescriptionsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "PrescRecViewAdapter";

    private ArrayList<Provider> providers = new ArrayList<Provider>();
    private ArrayList<Prescription> scripts = new ArrayList<Prescription>();
    private Context mContext;


    public PrescriptionsRecyclerViewAdapter(Context mContext, ArrayList<Provider> providerList, ArrayList<Prescription> scriptList) {
        this.providers = providerList;
        this.scripts = scriptList;
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

        date.setText(scripts.get(position).getDatePrescribed().toString());
        name.setText(scripts.get(position).getName());
        instructions.setText(scripts.get(position).getInstructions());
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
    }


}//end Adapter class
