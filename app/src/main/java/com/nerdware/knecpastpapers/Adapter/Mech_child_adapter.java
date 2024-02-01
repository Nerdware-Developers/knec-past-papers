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
import com.nerdware.knecpastpapers.Interstitial.Mech_Inter;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Mech_child;

import java.util.List;

public class Mech_child_adapter extends RecyclerView.Adapter<Mech_child_adapter.ViewHolder> {

    List<Mech_child> mechChildList;
    Context context;
    private int counter = 0;
    private static final int AD_DISPLAY_INTERVAL = 3;


    public Mech_child_adapter(List<Mech_child> mechChildList, Context context) {
        this.mechChildList = mechChildList;
        this.context = context;
    }

    @NonNull
    @Override
    public Mech_child_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mech_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Mech_child mechChild = mechChildList.get(position);
        holder.imageView.setImageResource(mechChildList.get(position).getImg());

        holder.itemView.setOnClickListener(v -> {
            counter++;

            String folderName = "Mechanical";
            String fileName = mechChild.getFileName();
            Intent intent = new Intent(v.getContext(), PdfView.class);
            intent.putExtra("FOLDER_NAME", folderName);
            intent.putExtra("FILE_NAME", fileName);
            v.getContext().startActivity(intent);

            if (counter % AD_DISPLAY_INTERVAL == 0) {
                // Show the interstitial ad after every 2 clicks
                // Show the interstitial ad after every 2 clicks
                if (Mech_Inter.minterstitialAd != null) {
                    Mech_Inter.minterstitialAd.show((Activity) context);
                    Mech_Inter.minterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            Mech_Inter.minterstitialAd = null;
                            Mech_Inter.loadads((Activity) context);
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                            super.onAdFailedToShowFullScreenContent(adError);
                            Mech_Inter.minterstitialAd = null;
                            Mech_Inter.loadads((Activity) context);
                        }
                    });
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mechChildList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.mech_image);
        }
    }
}
