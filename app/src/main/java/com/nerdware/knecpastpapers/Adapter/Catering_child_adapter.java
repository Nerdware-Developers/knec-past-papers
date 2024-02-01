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
import com.nerdware.knecpastpapers.Interstitial.Auto_Inter;
import com.nerdware.knecpastpapers.Interstitial.Cater_Inter;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Catering_child;

import java.util.List;

public class Catering_child_adapter extends RecyclerView.Adapter<Catering_child_adapter.ViewHolder> {

    List<Catering_child> cateringChildren;
    Context context;
    private int totalClickCounter = 0;
    private static final int AD_DISPLAY_INTERVAL = 3;

    public Catering_child_adapter(List<Catering_child> cateringChildren, Context context) {
        this.cateringChildren = cateringChildren;
        this.context = context;
    }

    @NonNull
    @Override
    public Catering_child_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.catering_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Catering_child cateringChild = cateringChildren.get(position);

        holder.imageView.setImageResource(cateringChildren.get(position).getImg());

        holder.itemView.setOnClickListener(v -> {
            totalClickCounter++;

            String folderName = "Catering";
            String fileName = cateringChild.getFileName();
            Intent intent = new Intent(v.getContext(), PdfView.class);
            intent.putExtra("FOLDER_NAME", folderName);
            intent.putExtra("FILE_NAME", fileName);
            v.getContext().startActivity(intent);

            if (totalClickCounter % AD_DISPLAY_INTERVAL == 0) {
                // Show the interstitial ad after every 2 clicks
                if (Cater_Inter.minterstitialAd != null) {
                    Cater_Inter.minterstitialAd.show((Activity) context);
                    Cater_Inter.minterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            Cater_Inter.minterstitialAd = null;
                            Cater_Inter.loadads((Activity) context);
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                            super.onAdFailedToShowFullScreenContent(adError);
                            Cater_Inter.minterstitialAd = null;
                            Cater_Inter.loadads((Activity) context);
                        }
                    });
                }
            }

        });
    }

    @Override
    public int getItemCount() {
        return cateringChildren.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.catname);

        }
    }
}
