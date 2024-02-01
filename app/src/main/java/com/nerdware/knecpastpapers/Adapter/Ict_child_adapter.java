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
import com.nerdware.knecpastpapers.Interstitial.Ict_Inter;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Ict_child;
import java.util.List;

public class Ict_child_adapter extends RecyclerView.Adapter<Ict_child_adapter.ViewHolder> {

    List<Ict_child> ictChildren;
    Context context;
    private int totalClickCounter = 0;
    private static final int AD_DISPLAY_INTERVAL = 3;

    public Ict_child_adapter(List<Ict_child> ictChildren, Context context) {
        this.ictChildren = ictChildren;
        this.context = context;

    }

    @NonNull
    @Override
    public Ict_child_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ict_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Ict_child ictChild = ictChildren.get(position);

        holder.imageView.setImageResource(ictChildren.get(position).getImg());

        holder.itemView.setOnClickListener(v -> {
            totalClickCounter++;

            String folderName = "ict";
            String fileName = ictChild.getFileName();
            Intent intent = new Intent(v.getContext(), PdfView.class);
            intent.putExtra("FOLDER_NAME", folderName);
            intent.putExtra("FILE_NAME", fileName);
            v.getContext().startActivity(intent);

            if (totalClickCounter % AD_DISPLAY_INTERVAL == 0) {

                // Show the interstitial ad after every 2 clicks
                if (Ict_Inter.minterstitialAd != null) {
                    Ict_Inter.minterstitialAd.show((Activity) context);
                    Ict_Inter.minterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            Ict_Inter.minterstitialAd = null;
                            Ict_Inter.loadads((Activity) context);
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                            super.onAdFailedToShowFullScreenContent(adError);
                            Ict_Inter.minterstitialAd = null;
                            Ict_Inter.loadads((Activity) context);
                        }
                    });
                }
            }

        });
    }
    @Override
    public int getItemCount() {
        return ictChildren.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ict_image);
        }
    }
}
