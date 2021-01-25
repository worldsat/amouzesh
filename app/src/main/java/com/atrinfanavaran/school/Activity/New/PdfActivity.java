package com.atrinfanavaran.school.Activity.New;

import android.os.Bundle;
import android.os.Environment;

import androidx.appcompat.app.AppCompatActivity;

import com.atrinfanavaran.school.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.File;

public class PdfActivity extends AppCompatActivity {
//    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String SAMPLE_FILE = "resume2.pdf";
    PDFView pdfView;
    Integer pageNumber = 0;
    String pdfFileName,folderName,fileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
//        WebView webView=new WebView(this);
//
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.setWebViewClient(new WebViewClient());
//        webView.getSettings().setBuiltInZoomControls(true);
//        webView.getSettings().setTextZoom(150);
//        webView.getSettings().setDisplayZoomControls(false);
//        webView.setHapticFeedbackEnabled(false);

//        webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + url);
        folderName=getIntent().getStringExtra("folderName");
        fileName=getIntent().getStringExtra("fileName");
        pdfView= (PDFView)findViewById(R.id.pdfView);
        displayFromAsset(SAMPLE_FILE);



    }
    private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;
        File root = new File(Environment.getExternalStorageDirectory() + folderName, fileName);
        pdfView.fromFile(root)
                .defaultPage(pageNumber)
                .enableSwipe(true)

                .swipeHorizontal(false)
//                .onPageChange(this)
                .enableAnnotationRendering(true)
//                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }
}