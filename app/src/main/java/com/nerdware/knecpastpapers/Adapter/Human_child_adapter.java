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
import com.nerdware.knecpastpapers.Interstitial.Human_Inter;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Human_child;
import java.util.List;

public class Human_child_adapter extends RecyclerView.Adapter<Human_child_adapter.ViewHolder> {

    private final List<Human_child> humanChildren;
    private final Context context;
    private int totalClickCounter = 0;
    private  static  final  int AD_DISPLAY_INTERVAL = 3;


    public Human_child_adapter(List<Human_child> humanChildren, Context context) {
        this.humanChildren = humanChildren;
        this.context = context;
    }

    @NonNull
    @Override
    public Human_child_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.human_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Human_child humanChild = humanChildren.get(position);

       holder.imageView.setImageResource(humanChildren.get(position).getImage());

        holder.itemView.setOnClickListener(v ->{
            totalClickCounter++;

            String folderName = "Human resource";
            String fileName = humanChild.getFileName();
            Intent intent = new Intent(v.getContext(), PdfView.class);
            intent.putExtra("FOLDER_NAME", folderName);
            intent.putExtra("FILE_NAME", fileName);
            v.getContext().startActivity(intent);

            if (totalClickCounter % AD_DISPLAY_INTERVAL == 0) {
                if (Human_Inter.minterstitialAd != null) {
                        Human_Inter.minterstitialAd.show((Activity) context);
                        Human_Inter.minterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                Human_Inter.minterstitialAd = null;
                                Human_Inter.loadads((Activity) context);
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                                Human_Inter.minterstitialAd = null;
                                Human_Inter.loadads((Activity) context);
                            }
                        });
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return humanChildren.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.human_image);
        }
    }
}
