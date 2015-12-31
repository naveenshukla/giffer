package com.example.naveen.videoplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void goToSearch(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void getInfo(View v){
        Intent intent = new Intent(this, ActivityInfo.class);
        startActivity(intent);
    }
    public void exit(View v){
        finish();
        System.exit(0);
    }
}
