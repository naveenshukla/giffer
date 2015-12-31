package com.example.naveen.videoplayer;

import android.app.Activity;
import android.app.SearchManager;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.content.ClipboardManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.SearchView;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   public final static String EXTRA_MESSAGE = "com.example.naveen.videoplayer.MESSAGE";
    public final static String EXTRA_MESSAGE2 = "com.example.naveen.videoplayer.MESSAGE2";
    String myresponse;
    ScrollView scrollView;
    WebView web_view;
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10,
            textView11,textView12,textView13,textView14,textView15,textView16,textView17,textView18,textView19,textView20,
            textView21,textView22,textView23,textView24,textView25;
    List<String> allids = new ArrayList<String>();
    List<String> allthumbnails = new ArrayList<String>();
    List<String> alltitles = new ArrayList<String>();
    NetworkImageView mNetworkImageView, mNetworkImageView2, mNetworkImageView3, mNetworkImageView4, mNetworkImageView5,
            mNetworkImageView6, mNetworkImageView7, mNetworkImageView8,mNetworkImageView9,mNetworkImageView10,mNetworkImageView11,
    mNetworkImageView12,mNetworkImageView13,mNetworkImageView14,mNetworkImageView15,mNetworkImageView16,mNetworkImageView17,
            mNetworkImageView18,mNetworkImageView19,mNetworkImageView20,mNetworkImageView21,mNetworkImageView22,
            mNetworkImageView23,mNetworkImageView24,mNetworkImageView25;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView = (ScrollView)findViewById(R.id.scrollView_main);
        scrollView.setVisibility(View.GONE);
        SearchView searchView = (SearchView)findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(hello);
        web_view = (WebView)findViewById(R.id.web_view2);
        web_view.setVisibility(View.GONE);
        textView1 = (TextView)findViewById(R.id.text_view1);
        textView2 = (TextView)findViewById(R.id.text_view2);
        textView3 = (TextView)findViewById(R.id.text_view3);
        textView4 = (TextView)findViewById(R.id.text_view4);
        textView5 = (TextView)findViewById(R.id.text_view5);
        textView6 = (TextView)findViewById(R.id.text_view6);
        textView7 = (TextView)findViewById(R.id.text_view7);
        textView8 = (TextView)findViewById(R.id.text_view8);
        textView9 = (TextView)findViewById(R.id.text_view9);
        textView10 = (TextView)findViewById(R.id.text_view10);
        textView11= (TextView)findViewById(R.id.text_view11);
        textView12 = (TextView)findViewById(R.id.text_view12);
        textView13 = (TextView)findViewById(R.id.text_view13);
        textView14 = (TextView)findViewById(R.id.text_view14);
        textView15 = (TextView)findViewById(R.id.text_view15);
        textView16 = (TextView)findViewById(R.id.text_view16);
        textView17 = (TextView)findViewById(R.id.text_view17);
        textView18 = (TextView)findViewById(R.id.text_view18);
        textView19 = (TextView)findViewById(R.id.text_view19);
        textView20= (TextView)findViewById(R.id.text_view20);
        textView21 = (TextView)findViewById(R.id.text_view21);
        textView22 = (TextView)findViewById(R.id.text_view22);
        textView23 = (TextView)findViewById(R.id.text_view23);
        textView24= (TextView)findViewById(R.id.text_view24);
        textView25 = (TextView)findViewById(R.id.text_view25);


        mNetworkImageView = (NetworkImageView) findViewById(R.id.networkImageView);
        mNetworkImageView2 = (NetworkImageView) findViewById(R.id.networkImageView2);
        mNetworkImageView3 = (NetworkImageView) findViewById(R.id.networkImageView3);
        mNetworkImageView4 = (NetworkImageView) findViewById(R.id.networkImageView4);
        mNetworkImageView5 = (NetworkImageView) findViewById(R.id.networkImageView5);
        mNetworkImageView6 = (NetworkImageView) findViewById(R.id.networkImageView6);
        mNetworkImageView7 = (NetworkImageView) findViewById(R.id.networkImageView7);
        mNetworkImageView8 = (NetworkImageView) findViewById(R.id.networkImageView8);
        mNetworkImageView9 = (NetworkImageView) findViewById(R.id.networkImageView9);
        mNetworkImageView10 = (NetworkImageView) findViewById(R.id.networkImageView10);
        mNetworkImageView11 = (NetworkImageView) findViewById(R.id.networkImageView11);
        mNetworkImageView12 = (NetworkImageView) findViewById(R.id.networkImageView12);
        mNetworkImageView13 = (NetworkImageView) findViewById(R.id.networkImageView13);
        mNetworkImageView14 = (NetworkImageView) findViewById(R.id.networkImageView14);
        mNetworkImageView15 = (NetworkImageView) findViewById(R.id.networkImageView15);
        mNetworkImageView16 = (NetworkImageView) findViewById(R.id.networkImageView16);
        mNetworkImageView17 = (NetworkImageView) findViewById(R.id.networkImageView17);
        mNetworkImageView18= (NetworkImageView) findViewById(R.id.networkImageView18);
        mNetworkImageView19 = (NetworkImageView) findViewById(R.id.networkImageView19);
        mNetworkImageView20 = (NetworkImageView) findViewById(R.id.networkImageView20);
        mNetworkImageView21 = (NetworkImageView) findViewById(R.id.networkImageView21);
        mNetworkImageView22 = (NetworkImageView) findViewById(R.id.networkImageView22);
        mNetworkImageView23 = (NetworkImageView) findViewById(R.id.networkImageView23);
        mNetworkImageView24 = (NetworkImageView) findViewById(R.id.networkImageView24);
        mNetworkImageView25 = (NetworkImageView) findViewById(R.id.networkImageView25);


        mNetworkImageView.setOnClickListener(this);
        mNetworkImageView2.setOnClickListener(this);
        mNetworkImageView3.setOnClickListener(this);
        mNetworkImageView4.setOnClickListener(this);
        mNetworkImageView5.setOnClickListener(this);
        mNetworkImageView6.setOnClickListener(this);
        mNetworkImageView7.setOnClickListener(this);
        mNetworkImageView8.setOnClickListener(this);
        mNetworkImageView9.setOnClickListener(this);
        mNetworkImageView10.setOnClickListener(this);
        mNetworkImageView11.setOnClickListener(this);
        mNetworkImageView12.setOnClickListener(this);
        mNetworkImageView13.setOnClickListener(this);
        mNetworkImageView14.setOnClickListener(this);
        mNetworkImageView15.setOnClickListener(this);
        mNetworkImageView16.setOnClickListener(this);
        mNetworkImageView17.setOnClickListener(this);
        mNetworkImageView18.setOnClickListener(this);
        mNetworkImageView19.setOnClickListener(this);
        mNetworkImageView20.setOnClickListener(this);
        mNetworkImageView21.setOnClickListener(this);
        mNetworkImageView22.setOnClickListener(this);
        mNetworkImageView23.setOnClickListener(this);
        mNetworkImageView24.setOnClickListener(this);
        mNetworkImageView25.setOnClickListener(this);
    }
    SearchView.OnQueryTextListener hello = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            web_view.loadUrl("file:///android_asset/webview.html");
            scrollView.setVisibility(View.GONE);
            web_view.setVisibility(View.VISIBLE);
            query = query.replaceAll(" ", "+");
            String url = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=25&" +
                    "q=" + query + "&type=video&key=AIzaSyBhPb7UAjmMWhZ2RnC6CG38luvOyGWZHR8";
            //final TextView textView = (TextView)findViewById(R.id.textView);
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            myresponse = response;
                            try {
                                JSONObject mainObject = new JSONObject(myresponse);
                                JSONArray cast = mainObject.getJSONArray("items");
                                Log.d("appcreate", String.valueOf(cast.length()));
                                for (int i = 0; i < cast.length(); i++) {
                                    JSONObject user = cast.getJSONObject(i);
                                    String idname = user.getString("id");
                                    JSONObject subobject = new JSONObject(idname);
                                    String key = subobject.getString("videoId");
                                    allids.add(key);
                                    String snippet = user.getString("snippet");
                                    JSONObject snippetobject = new JSONObject(snippet);
                                    String title = snippetobject.getString("title");
                                    alltitles.add(title);
                                    String thumbnails = snippetobject.getString("thumbnails");
                                    JSONObject thumbnailobject = new JSONObject(thumbnails);
                                    String url = thumbnailobject.getString("default");
                                    JSONObject urlobject = new JSONObject(url);
                                    String thumbnailurl = urlobject.getString("url");
                                    allthumbnails.add(thumbnailurl);
                                }
                                ImageLoader mImageLoader;
                                final String IMAGE_URL = allthumbnails.get(0).toString();
                                mImageLoader = MySingleton.getInstance(getApplicationContext()).getImageLoader();
                                Log.d("appcreate", "success...");
                                for (int i = 0; i < 25; i++) {
                                    Log.d("appcreate", allthumbnails.get(i).toString());
                                }
                                mNetworkImageView.setImageUrl(allthumbnails.get(0).toString(), mImageLoader);
                                mNetworkImageView2.setImageUrl(allthumbnails.get(1).toString(), mImageLoader);
                                mNetworkImageView3.setImageUrl(allthumbnails.get(2).toString(), mImageLoader);
                                mNetworkImageView4.setImageUrl(allthumbnails.get(3).toString(), mImageLoader);
                                mNetworkImageView5.setImageUrl(allthumbnails.get(4).toString(), mImageLoader);
                                mNetworkImageView6.setImageUrl(allthumbnails.get(5).toString(), mImageLoader);
                                mNetworkImageView7.setImageUrl(allthumbnails.get(6).toString(), mImageLoader);
                                mNetworkImageView8.setImageUrl(allthumbnails.get(7).toString(), mImageLoader);
                                mNetworkImageView9.setImageUrl(allthumbnails.get(8).toString(), mImageLoader);
                                mNetworkImageView10.setImageUrl(allthumbnails.get(9).toString(), mImageLoader);
                                mNetworkImageView11.setImageUrl(allthumbnails.get(10).toString(), mImageLoader);
                                mNetworkImageView12.setImageUrl(allthumbnails.get(11).toString(), mImageLoader);
                                mNetworkImageView13.setImageUrl(allthumbnails.get(12).toString(), mImageLoader);
                                mNetworkImageView14.setImageUrl(allthumbnails.get(13).toString(), mImageLoader);
                                mNetworkImageView15.setImageUrl(allthumbnails.get(14).toString(), mImageLoader);
                                mNetworkImageView16.setImageUrl(allthumbnails.get(15).toString(), mImageLoader);
                                mNetworkImageView17.setImageUrl(allthumbnails.get(16).toString(), mImageLoader);
                                mNetworkImageView18.setImageUrl(allthumbnails.get(17).toString(), mImageLoader);
                                mNetworkImageView19.setImageUrl(allthumbnails.get(18).toString(), mImageLoader);
                                mNetworkImageView20.setImageUrl(allthumbnails.get(19).toString(), mImageLoader);
                                mNetworkImageView21.setImageUrl(allthumbnails.get(20).toString(), mImageLoader);
                                mNetworkImageView22.setImageUrl(allthumbnails.get(21).toString(), mImageLoader);
                                mNetworkImageView23.setImageUrl(allthumbnails.get(22).toString(), mImageLoader);
                                mNetworkImageView24.setImageUrl(allthumbnails.get(23).toString(), mImageLoader);
                                mNetworkImageView25.setImageUrl(allthumbnails.get(24).toString(), mImageLoader);

                                textView1.setText(alltitles.get(0).toString());
                                textView2.setText(alltitles.get(1).toString());
                                textView3.setText(alltitles.get(2).toString());
                                textView4.setText(alltitles.get(3).toString());
                                textView5.setText(alltitles.get(4).toString());
                                textView6.setText(alltitles.get(5).toString());
                                textView7.setText(alltitles.get(6).toString());
                                textView8.setText(alltitles.get(7).toString());
                                textView9.setText(alltitles.get(8).toString());
                                textView10.setText(alltitles.get(9).toString());
                                textView11.setText(alltitles.get(10).toString());
                                textView12.setText(alltitles.get(11).toString());
                                textView13.setText(alltitles.get(12).toString());
                                textView14.setText(alltitles.get(13).toString());
                                textView15.setText(alltitles.get(14).toString());
                                textView16.setText(alltitles.get(15).toString());
                                textView17.setText(alltitles.get(16).toString());
                                textView18.setText(alltitles.get(17).toString());
                                textView19.setText(alltitles.get(18).toString());
                                textView20.setText(alltitles.get(19).toString());
                                textView21.setText(alltitles.get(20).toString());
                                textView22.setText(alltitles.get(21).toString());
                                textView23.setText(alltitles.get(22).toString());
                                textView24.setText(alltitles.get(23).toString());
                                textView25.setText(alltitles.get(24).toString());
                                web_view.setVisibility(View.GONE);
                                scrollView.setVisibility(View.VISIBLE);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });

// Retrieves an image specified by the URL, displays it in the UI.

// Access the RequestQueue through your singleton class.
            queue.add(stringRequest);
            return false;
        }
        @Override
        public boolean onQueryTextChange(String newText) {
            if (!newText.equals("")) {
                allids.clear();
                allthumbnails.clear();
                alltitles.clear();
                web_view.setVisibility(View.GONE);
                scrollView.setVisibility(View.GONE);
            }
            return false;
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v == mNetworkImageView){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(0);
            intent.putExtra(EXTRA_MESSAGE, message);
            String message2 = alltitles.get(0);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView2){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(1);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(1);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView3){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(2);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(2);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView4){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(3);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(3);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView5){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(4);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(4);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView6){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(5);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(5);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView7){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(6);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(6);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView8){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(7);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(7);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView9){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(8);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(8);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView10){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(9);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(9);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView11){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(10);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(10);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView12){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(11);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(11);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView13){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(12);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(12);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView14){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(13);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(13);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView15){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(14);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(14);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView16){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(15);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(15);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView17){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(16);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(16);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView18){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(17);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(17);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView19){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(18);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(18);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView20){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(19);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(19);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView21){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(20);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(20);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView22){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(21);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(21);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView23){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(22);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(22);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView24){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(23);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(23);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
        if(v == mNetworkImageView25){
            Intent intent = new Intent(getApplicationContext(),PlayVideo.class);
            String message = allids.get(24);
            intent.putExtra(EXTRA_MESSAGE,message);
            String message2 = alltitles.get(24);
            intent.putExtra(EXTRA_MESSAGE2,message2);
            startActivity(intent);
        }
    }
}
