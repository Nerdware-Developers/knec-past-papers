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
import com.nerdware.knecpastpapers.model.Human_parent;
import java.util.List;

public class Human_parent_adapter extends RecyclerView.Adapter<Human_parent_adapter.ViewHolder> {

    List<Human_parent> humanParents;
    Context context;

    public Human_parent_adapter(List<Human_parent> humanParents, Context context) {
        this.humanParents = humanParents;
        this.context = context;
    }

    @NonNull
    @Override
    public Human_parent_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.human_recycler, parent, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(humanParents.get(position).getTitle());
        Human_child_adapter childAdapter;
        childAdapter = new Human_child_adapter(humanParents.get(position).getChildList(),context);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(childAdapter);
        childAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return humanParents.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.human_recycler);
            textView = itemView.findViewById(R.id.human_title);

        }
    }
}
