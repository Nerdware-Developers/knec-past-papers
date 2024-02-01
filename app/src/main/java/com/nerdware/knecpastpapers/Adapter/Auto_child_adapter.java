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
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.nerdware.knecpastpapers.Activities.PdfView;
import com.nerdware.knecpastpapers.Interstitial.Auto_Inter;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Auto_child;

import java.util.List;

public class Auto_child_adapter extends RecyclerView.Adapter<Auto_child_adapter.ViewHolder> {

    private final List<Auto_child> auto_childList;
    private final Context context;
    private int totalClickCounter = 0;
    private static final int AD_DISPLAY_INTERVAL = 3;

    public Auto_child_adapter(List<Auto_child> auto_childList, Context context) {
        this.auto_childList = auto_childList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.auto_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Auto_child autoChild = auto_childList.get(position);

        holder.imageView.setImageResource(autoChild.getImg());

        holder.itemView.setOnClickListener(v -> {
            totalClickCounter++;

            String folderName = "Automotive";
            String fileName = autoChild.getFileName();
            Intent intent = new Intent(v.getContext(), PdfView.class);
            intent.putExtra("FOLDER_NAME", folderName);
            intent.putExtra("FILE_NAME", fileName);
            v.getContext().startActivity(intent);

            if (totalClickCounter % AD_DISPLAY_INTERVAL == 0) {
                // Show the interstitial ad after every 2 clicks
                if (Auto_Inter.minterstitialAd != null) {
                    Auto_Inter.minterstitialAd.show((Activity) context);
                    Auto_Inter.minterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            Auto_Inter.minterstitialAd = null;
                            Auto_Inter.loadads((Activity) context);
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                            super.onAdFailedToShowFullScreenContent(adError);
                            Auto_Inter.minterstitialAd = null;
                            Auto_Inter.loadads((Activity) context);
                        }
                    });
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return auto_childList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.auto_name);
        }
    }
}
