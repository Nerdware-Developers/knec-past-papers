package com.nerdware.knecpastpapers.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.nerdware.knecpastpapers.Activities.PdfView;
import com.nerdware.knecpastpapers.Interstitial.Build_Inter;
import com.nerdware.knecpastpapers.Interstitial.Ict_Inter;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Building_child;

import java.util.List;

public class Building_child_adapter extends RecyclerView.Adapter<Building_child_adapter.ViewHolder> {

    List<Building_child> buildingChildren;
    Context context;
    private int totalClickCounter = 0;
    private static final int AD_DISPLAY_INTERVAL = 3;

    public Building_child_adapter(List<Building_child> buildingChildren, Context context) {
        this.buildingChildren = buildingChildren;
        this.context = context;
    }

    @NonNull
    @Override
    public Building_child_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.building_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Building_child buildingChild = buildingChildren.get(position);

        holder.imageView.setImageResource(buildingChildren.get(position).getImg());

        holder.itemView.setOnClickListener(v -> {
            totalClickCounter++;
            String folderName = "Building";
            String fileName = buildingChild.getFileName();
            Intent intent = new Intent(v.getContext(), PdfView.class);
            intent.putExtra("FOLDER_NAME",folderName);
            intent.putExtra("FILE_NAME",fileName);
            v.getContext().startActivity(intent);

            if (totalClickCounter % AD_DISPLAY_INTERVAL ==0) {

                if (Build_Inter.minterstitialAd != null) {
                    Build_Inter.minterstitialAd.show((Activity) context);
                    Build_Inter.minterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            Build_Inter.minterstitialAd = null;
                            Build_Inter.loadads((Activity) context);
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                            super.onAdFailedToShowFullScreenContent(adError);
                            Build_Inter.minterstitialAd = null;
                            Build_Inter.loadads((Activity) context);
                        }
                    });
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return buildingChildren.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

      ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.building_image);
        }
    }
}
