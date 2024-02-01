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
import com.nerdware.knecpastpapers.model.Ict_parent;
import java.util.List;

public class Ict_parent_adapter extends RecyclerView.Adapter<Ict_parent_adapter.ViewHolder> {

    List<Ict_parent> ictParents;
    Context context;


    public Ict_parent_adapter(List<Ict_parent> ictParents, Context context) {
        this.ictParents = ictParents;
        this.context = context;
    }

    @NonNull
    @Override
    public Ict_parent_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ict_recycler, parent, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(ictParents.get(position).getTitle());
        Ict_child_adapter ictChildAdapter;
        ictChildAdapter = new Ict_child_adapter(ictParents.get(position).getChildList(),context);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(ictChildAdapter);
        ictChildAdapter.notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return ictParents.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.ict_recycler);
            textView = itemView.findViewById(R.id.ict_title);

        }
    }

}
