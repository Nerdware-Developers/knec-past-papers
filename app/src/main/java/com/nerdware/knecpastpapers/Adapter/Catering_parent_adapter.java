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
import com.nerdware.knecpastpapers.model.Catering_parent;

import java.util.List;

public class Catering_parent_adapter extends RecyclerView.Adapter<Catering_parent_adapter.ViewHolder> {

    List<Catering_parent> cateringParents;
    Context context;

    public Catering_parent_adapter(List<Catering_parent> cateringParents, Context context) {
        this.cateringParents = cateringParents;
        this.context = context;
    }

    @NonNull
    @Override
    public Catering_parent_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cateringrecycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(cateringParents.get(position).getTitle());
        Catering_child_adapter cateringChildAdapter;
        cateringChildAdapter = new Catering_child_adapter(cateringParents.get(position).getChildList(),context);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(cateringChildAdapter);
        cateringChildAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return cateringParents.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.catering_recycler);
            textView = itemView.findViewById(R.id.catering_title);

        }
    }
}
