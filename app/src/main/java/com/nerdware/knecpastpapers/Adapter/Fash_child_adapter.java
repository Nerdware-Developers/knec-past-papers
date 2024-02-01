package com.nerdware.knecpastpapers.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
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
import com.nerdware.knecpastpapers.Interstitial.Fash_Inter;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Fash_child;

import java.util.List;

public class Fash_child_adapter extends RecyclerView.Adapter<Fash_child_adapter.ViewHolder> {

    List<Fash_child> fashChildren;
    Context context;
    private int totalClickCounter = 0;
    private static final int AD_DISPLAY_INTERVAL = 3;

    public Fash_child_adapter(List<Fash_child> fashChildren, Context context) {
        this.fashChildren = fashChildren;
        this.context = context;
    }

    @NonNull
    @Override
    public Fash_child_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fash_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fash_child fashChild = fashChildren.get(position);

        holder.imageView.setImageResource(fashChildren.get(position).getImage());
        holder.itemView.setOnClickListener(v -> {
            totalClickCounter++;

            String folderName = "fashion";
            String fileName = fashChild.getFileName();
            Intent intent = new Intent(v.getContext(), PdfView.class);
            intent.putExtra("FOLDER_NAME", folderName);
            intent.putExtra("FILE_NAME", fileName);
            v.getContext().startActivity(intent);

            if (totalClickCounter % AD_DISPLAY_INTERVAL == 0) {
                // Show the interstitial ad after every 2 clicks
                if (Fash_Inter.minterstitialAd != null) {
                    Fash_Inter.minterstitialAd.show((Activity) context);
                    Fash_Inter.minterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            Fash_Inter.minterstitialAd = null;
                            Fash_Inter.loadads((Activity) context);
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                            super.onAdFailedToShowFullScreenContent(adError);
                            Fash_Inter.minterstitialAd = null;
                            Fash_Inter.loadads((Activity) context);
                        }
                    });
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return fashChildren.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.fash_image);
        }
    }
}
