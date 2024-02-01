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
import com.nerdware.knecpastpapers.Interstitial.Elect_Inter;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Elect_child;

import org.w3c.dom.Text;

import java.util.List;

public class Elect_child_adapter extends RecyclerView.Adapter<Elect_child_adapter.ViewHolder> {

    private final List<Elect_child> elect_childList;
    private final Context context;
    private int totalClickCounter = 0;
    private static final int AD_DISPLAY_INTERVAL = 3;

    public Elect_child_adapter(List<Elect_child> elect_childList, Context context){
        this.elect_childList = elect_childList;
        this.context = context;

    }

    @NonNull
    @Override
    public Elect_child_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.elect_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull Elect_child_adapter.ViewHolder holder, int position) {

        Elect_child electChild = elect_childList.get(position);

        holder.imageView.setImageResource(electChild.getImg());

        holder.itemView.setOnClickListener(v -> {
            totalClickCounter ++;
            String folderName = "EE";
            String fileName = electChild.getFileName();
            Intent intent = new Intent(v.getContext(), PdfView.class);
            intent.putExtra("FOLDER_NAME", folderName);
            intent.putExtra("FILE_NAME", fileName);
            v.getContext().startActivity(intent);

            if (totalClickCounter % AD_DISPLAY_INTERVAL == 0){
                //
                if (Elect_Inter.minterstitialAd != null){
                    Elect_Inter.minterstitialAd.show((Activity) context);
                    Elect_Inter.minterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            Elect_Inter.minterstitialAd = null;
                            Elect_Inter.loadads((Activity) context);
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                            super.onAdFailedToShowFullScreenContent(adError);
                            Elect_Inter.minterstitialAd = null;
                            Elect_Inter.loadads((Activity) context);
                        }
                    });
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return elect_childList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

       ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.elect_image);

        }
    }
}
