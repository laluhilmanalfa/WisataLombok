package com.example.hilman.wisatalombok;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;


import com.example.hilman.wisatalombok.DatabaseHelper;
import java.util.Timer;
import android.content.Intent;
import java.util.TimerTask;
public class splash extends Activity {


    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        databaseHelper = new DatabaseHelper(getApplicationContext());
        databaseHelper.getWritableDatabase();


        TimerTask task = new TimerTask() {

            @Override
            public void run() {

                Intent intent = new Intent(splash.this, HOME.class);
                intent.putExtra("Paket", "splash");
                startActivity(intent);
                finish();

            }
        };


        Timer t = new Timer();
        t.schedule(task, 3000);






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
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




}
