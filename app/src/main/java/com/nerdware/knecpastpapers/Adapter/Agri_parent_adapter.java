package com.nerdware.knecpastpapers.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Agri_parent;
import com.nerdware.knecpastpapers.model.Auto_parent;

import java.util.List;

public class Agri_parent_adapter extends RecyclerView.Adapter<Agri_parent_adapter.ViewHolder> {

    List<Agri_parent> agriParents;
    Context context;

    public Agri_parent_adapter(List<Agri_parent> agriParents, Context context) {
        this.agriParents = agriParents;
        this.context = context;
    }

    @NonNull
    @Override
    public Agri_parent_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.agri_recycler, parent, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(agriParents.get(position).getTitle());
        Agri_child_adapter agriChildAdapter;
        agriChildAdapter = new Agri_child_adapter(agriParents.get(position).getChildList(),context);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(agriChildAdapter);
        agriChildAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return agriParents.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.auto_recycler);
            textView = itemView.findViewById(R.id.auto_title);

        }
    }
}
