package com.nerdware.knecpastpapers.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Auto_parent;
import java.util.List;

public class Auto_parent_adapter extends RecyclerView.Adapter<Auto_parent_adapter.ViewHolder> {

    List<Auto_parent> autoParents;
    Context context;
    Activity activity;

    public Auto_parent_adapter(List<Auto_parent> autoParents, Context context) {
        this.autoParents = autoParents;
        this.context = context;
    }

    @NonNull
    @Override
    public Auto_parent_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.autorecycler, parent, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull Auto_parent_adapter.ViewHolder holder, int position) {

        holder.textView.setText(autoParents.get(position).getTitle());
        Auto_child_adapter autoChildAdapter;
        autoChildAdapter = new Auto_child_adapter(autoParents.get(position).getChildList(),context);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(autoChildAdapter);
        autoChildAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return autoParents.size();
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
