package com.nerdware.knecpastpapers.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Pop_item;
import java.util.List;

public class Popular_adapter extends RecyclerView.Adapter<Popular_adapter.ViewHolder> {

    List<Pop_item> popItemList;
    Context context;

    public Popular_adapter(List<Pop_item> popItemList, Context context) {
        this.popItemList = popItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public Popular_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pop_item, parent, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView.setImageResource(popItemList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return popItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView  = itemView.findViewById(R.id.popImage);
        }
    }
}
