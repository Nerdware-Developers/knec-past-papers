package com.nerdware.knecpastpapers.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Building_parent;

import java.util.ArrayList;
import java.util.List;

public class Building_parent_adapter extends RecyclerView.Adapter<Building_parent_adapter.ViewHolder> {

    List<Building_parent> buildingParents;
    Context context;

    public Building_parent_adapter(ArrayList<Building_parent> buildingParents, Context context) {
        this.buildingParents = buildingParents;
        this.context = context;
    }

    @NonNull
    @Override
    public Building_parent_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.building_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(buildingParents.get(position).getTitle());
        Building_child_adapter buildingChildAdapter;
        buildingChildAdapter = new Building_child_adapter(buildingParents.get(position).getChildList(),context);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(buildingChildAdapter);
        buildingChildAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return buildingParents.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.building_recycler);
            textView = itemView.findViewById(R.id.building_title);

        }
    }
}
