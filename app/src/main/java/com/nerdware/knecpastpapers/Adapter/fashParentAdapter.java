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
import com.nerdware.knecpastpapers.model.fashParent;

import java.util.List;

public class fashParentAdapter extends RecyclerView.Adapter<fashParentAdapter.ViewHolder> {

    List<fashParent> fashParents;
    Context context;

    public fashParentAdapter(List<fashParent> fashParents, Context context) {
        this.fashParents = fashParents;
        this.context = context;
    }

    @NonNull
    @Override
    public fashParentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fashion_recycler, parent, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(fashParents.get(position).getTitle());
        Fash_child_adapter fashChildAdapter;
        fashChildAdapter = new Fash_child_adapter(fashParents.get(position).getChildList(),context);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(fashChildAdapter);
        fashChildAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return fashParents.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.fash_recycler);
            textView = itemView.findViewById(R.id.fash_title);

        }
    }
}
