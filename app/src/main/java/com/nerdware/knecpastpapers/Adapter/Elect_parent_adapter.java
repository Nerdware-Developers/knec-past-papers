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
import com.nerdware.knecpastpapers.model.Elect_parent;

import java.util.List;

public class Elect_parent_adapter extends RecyclerView.Adapter<Elect_parent_adapter.ViewHolder> {

    List<Elect_parent> electParents;
    Context context;

    public Elect_parent_adapter(List<Elect_parent> electParents, Context context) {
        this.electParents = electParents;
        this.context = context;
    }

    @NonNull
    @Override
    public Elect_parent_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.elctrical_recycler, parent, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(electParents.get(position).getTitle());
        Elect_child_adapter electChildAdapter;
        electChildAdapter = new Elect_child_adapter(electParents.get(position).getChildList(),context);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(electChildAdapter);
        electChildAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return electParents.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.electrical_recycler);
            textView = itemView.findViewById(R.id.electrical_title);

        }
    }
}
