package com.mshack.incubateind.inconnect;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Varsha on 20-01-2019.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder>{

    ArrayList<Task> mComplaintDetails;

    public TaskAdapter(ArrayList<Task> mComplaintDetails) {
        this.mComplaintDetails = mComplaintDetails;
    }

    @Override
    public final TaskAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_task, parent, false);

        TaskAdapter.ViewHolder vh = new TaskAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Read from the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("It worked", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Failed", "Failed to read value.", error.toException());
            }
        });
        holder.mSubject.setText(mComplaintDetails.get(position).getTaskName());


    }

    @Override
    public int getItemCount() {
        return mComplaintDetails.size() ;
        //return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mSubject;//, mDesc, mDate, mTime, mReportedTo;
        public ViewHolder(View itemView) {
            super(itemView);

            mSubject = (TextView) itemView.findViewById(R.id.task_name);
//            mDesc = (TextView) itemView.findViewById(R.id.description);
//            mDate = (TextView) itemView.findViewById(R.id.date);
//            mTime = (TextView) itemView.findViewById(R.id.time);
//            mReportedTo = (TextView) itemView.findViewById(R.id.reported_to);

            /*
            mSubject.setText("1");
            mDesc.setText("1");
            mDate.setText("1");
            mTime.setText("1");
            mReportedTo.setText("1");
            */
        }
    }
}