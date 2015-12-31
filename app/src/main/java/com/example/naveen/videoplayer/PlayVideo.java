package com.example.naveen.videoplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.*;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class PlayVideo extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private String message,message2,dur,text2,fps,filename;
    WebView webView;
    public final static String EXTRA_MESSAGE = "com.example.naveen.videoplayer.MESSAGE";
    private static final int RECOVERY_REQUEST = 1;
    ProgressBar progressBar;
    NetworkImageView networkImageView;
    Intent intent1;
    String url;
    Integer k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        Intent intent = getIntent();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1  = new Intent(PlayVideo.this, Menu.class);
                startActivity(intent1);

            }
        });
        webView = (WebView)findViewById(R.id.webView);
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        message2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        Log.d("appcreate", message);
        Log.d("appcreate", message2);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        intent1 = new Intent(getApplicationContext(),gifview.class);
        YouTubePlayerView youTubePlayer = (YouTubePlayerView)findViewById(R.id.youtube_player);
        youTubePlayer.initialize(Config.YOUTUBE_API_KEY, this);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText editText = (EditText)findViewById(R.id.editText);
                String text1 = editText.getText().toString();
                EditText editText1 = (EditText)findViewById(R.id.editText2);
                EditText editText2 = (EditText)findViewById(R.id.editText3);
                fps = editText2.getText().toString();
                EditText editText3 = (EditText)findViewById(R.id.editText4);
                text2 = editText1.getText().toString();
                filename = editText3.getText().toString();
                if(text1.equals("")||fps.equals("")||text2.equals("")||filename.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter Full Description...",Toast.LENGTH_LONG).show();
                }
                else {
                    String[] units = text1.split(":");
                    int minutes = Integer.parseInt(units[0]);
                    int seconds = Integer.parseInt(units[1]);
                    int duration = 60 * minutes + seconds;
                    dur = String.valueOf(duration);
                    url = "http://apilayer.net/api/capture" +
                            "?" + "access_key=7c0d8aa417c6255d3a17c3ee457099b2" +
                            "&url=https://www.youtube.com/watch?v=" + message + "&size=200x100" + "&start=" + dur +
                            "&duration=" + text2 + "&fps=" + fps;
                    Log.d("appcreate", url);
                    new DownloadFileFromURL(getApplicationContext(), progressBar).execute(url, filename);
                }
            }
        });
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if(!b){
            youTubePlayer.cueVideo(message);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }
}
