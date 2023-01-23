package com.fstrateg.sellena;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<TaskItem> taskModelArrayList;

    public TaskAdapter(Context context, ArrayList<TaskItem> data)
    {
        this.context=context;
        this.taskModelArrayList=data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rowitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TaskItem item=taskModelArrayList.get(position);
        holder.textUi.setText(item.Text);
        holder.progresUi.setProgress(item.Progress);
        holder.textProgUi.setText(item.Progress.toString()+"%");
    }

    @Override
    public int getItemCount() {
        return taskModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView textUi;
        private TextView textProgUi;
        private ProgressBar progresUi;
        public ViewHolder(View itemView)
        {
            super(itemView);
            textUi=itemView.findViewById(R.id.textViewRow);
            progresUi = itemView.findViewById(R.id.progress_bar);
            textProgUi = itemView.findViewById(R.id.textProgressRow);
        }
    }
}
