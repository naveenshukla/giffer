package com.example.naveen.videoplayer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
/**
 * Created by Naveen on 22-12-2015.
 */
public class DownloadFileFromURL extends AsyncTask<String , String, String>  {
    public final static String EXTRA_MESSAGE = "com.example.naveen.videoplayer.MESSAGE";
    private Context context;
    private  String filename1;
    private  ProgressBar progressBar;
    public DownloadFileFromURL(Context context,ProgressBar progressBar){
        this.context = context;
        this.progressBar = progressBar;
    }
    @Override
    protected void onPreExecute(){
        progressBar.setVisibility(View.VISIBLE);
        super.onPreExecute();
        File appDirectory = new File(
                Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyApp/");
        if (!appDirectory.exists())
            Log.d("appDir created: ", appDirectory.mkdir() + "");
        if(appDirectory.exists()){
            Log.d("appcreate","appDirectory already exists...");
        }
    }
    @Override
    protected String doInBackground(String... f_url) {
        int count;
        try {
            URL url = new URL(f_url[0]);
            URLConnection conection = url.openConnection();
            conection.connect();
            filename1 = f_url[1];
            Log.d("appcreate",f_url[0]);
            Log.d("appcreate",f_url[1]);
            // getting file length
            int lenghtOfFile = conection.getContentLength();

            // input stream to read file - with 8k buffer
            InputStream input = new BufferedInputStream(url.openStream(), 8192);

            // Output stream to write file
            String filename = "/sdcard/MyApp/" + filename1 + ".gif";
            Log.d("appcreate",filename);
            OutputStream output = new FileOutputStream(filename);
            byte data[] = new byte[2048];
            long total = 0;
            while ((count = input.read(data)) != -1) {
                total += count;
                // publishing the progress....
                // After this onProgressUpdate will be called
                publishProgress(""+(int)((total*100)/lenghtOfFile));

                // writing data to file
                output.write(data, 0, count);
            }

            // flushing output
            output.flush();

            // closing streams
            output.close();
            input.close();

        } catch (Exception e) {
            Log.e("Error: ", e.getMessage());
        }

        return null;
    }
    protected void onPostExecute(String file_url) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(context, "File Downloaded ...", Toast.LENGTH_LONG).show();
        String message = filename1;
        Intent intent = new Intent(context,gifview.class);
        intent.putExtra(EXTRA_MESSAGE,message);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);


    }
}

