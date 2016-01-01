package com.example.naveen.videoplayer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

public class gifview extends AppCompatActivity {
    WebView mWebView;
    String filename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifview);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab3);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(gifview.this, Menu.class);
                startActivity(intent1);
            }
        });
        Intent intent = getIntent();
        filename = intent.getStringExtra(DownloadFileFromURL.EXTRA_MESSAGE);
        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.getSettings().setAllowFileAccess(true);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        String base = Environment.getExternalStorageDirectory().getAbsolutePath().toString();
        String imagePath = "file://"+ base + "/MyApp/" + filename + ".gif";
        Log.d("appcreate", imagePath);
        String html = "<html><head></head><body style=\"text-align:center\"><img src=\"" + imagePath + "\"/></body></html>";
        mWebView.loadDataWithBaseURL("", html, "text/html","utf-8", "");
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        String name = pref.getString("Name",null);
    }
    public void gotIt(View v){
        Intent intent = new Intent(gifview.this ,MainActivity.class);
        startActivity(intent);
    }
}
