package com.nerdware.knecpastpapers.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.agriChild;

import java.util.List;

public class Agri_child_adapter extends RecyclerView.Adapter<Agri_child_adapter.ViewHolder> {

    List<agriChild> agriChildList;
    Context context;

    public Agri_child_adapter(List<agriChild> agriChildList, Context context) {
        this.agriChildList = agriChildList;
        this.context = context;
    }

    @NonNull
    @Override
    public Agri_child_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.agri_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(agriChildList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return agriChildList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.agri_image);
        }
    }
}
