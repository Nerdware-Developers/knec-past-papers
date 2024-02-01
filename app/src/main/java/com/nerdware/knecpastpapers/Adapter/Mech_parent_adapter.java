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
import com.nerdware.knecpastpapers.model.Agri_parent;
import com.nerdware.knecpastpapers.model.Mech_parent;

import java.util.List;

public class Mech_parent_adapter extends RecyclerView.Adapter<Mech_parent_adapter.ViewHolder> {

    List<Mech_parent> mechParents;
    Context context;

    public Mech_parent_adapter(List<Mech_parent> mechParents, Context context) {
        this.mechParents = mechParents;
        this.context = context;
    }

    @NonNull
    @Override
    public Mech_parent_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mech_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(mechParents.get(position).getTitle());
        Mech_child_adapter mechChildAdapter;
        mechChildAdapter = new Mech_child_adapter(mechParents.get(position).getChildList(),context);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(mechChildAdapter);
        mechChildAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mechParents.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.mech_recycler);
            textView = itemView.findViewById(R.id.mech_title);

        }
    }
}
