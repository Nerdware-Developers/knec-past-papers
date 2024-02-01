package com.nerdware.knecpastpapers.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.nerdware.knecpastpapers.R;
import java.io.File;
import java.io.IOException;

public class PdfView extends AppCompatActivity {
    private PDFView pdfView;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);

        MobileAds.initialize(this);
        AdView pdff = findViewById(R.id.pdf);
        AdView pdff1 = findViewById(R.id.pdf2);
        AdRequest adRequest = new AdRequest.Builder().build();
        pdff.loadAd(adRequest);
        pdff1.loadAd(adRequest);
        AdView adView =  new AdView(this);
        adView.setAdSize(AdSize.BANNER);

        ImageView imageView = findViewById(R.id.pdf_back);
        pdfView = findViewById(R.id.view);
        progressBar = findViewById(R.id.progress_bar);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        String folderName = getIntent().getStringExtra("FOLDER_NAME");
        String fileName = getIntent().getStringExtra("FILE_NAME");
        progressBar.setVisibility(View.VISIBLE);

        try {
            final File localFile = File.createTempFile("temp", ".pdf");

            StorageReference reference = FirebaseStorage.getInstance().getReference().child(folderName + "/" + fileName);

            reference.getFile(localFile).addOnSuccessListener(taskSnapshot -> {
                progressBar.setVisibility(View.GONE);
                displayPdf(localFile);
            }).addOnFailureListener(e -> {
                progressBar.setVisibility(View.GONE);
                // Handle the error when file download fails
            });
        } catch (IOException e) {
            e.printStackTrace();
            // Handle file creation error
        }
    }

    private void displayPdf(File localFile) {
        pdfView.fromFile(localFile)
                .onLoad(nbPages -> {
                    // PDF loaded successfully
                })
                .onPageError((page, t) -> {
                    // Handle PDF page error
                    t.printStackTrace();
                })
                .load();
    }
}
