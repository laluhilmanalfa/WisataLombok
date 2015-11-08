package com.example.hilman.wisatalombok;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class listArtikel extends ActionBarActivity {


    ListView listView;
    List<ArtikelObjek> listPaket1 = new ArrayList<ArtikelObjek>();
    CustomListArtikel adapter1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_artikel);

        listView = (ListView) findViewById(R.id.list);
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        databaseHelper.getWritableDatabase();
        int jumlahArtikel = databaseHelper.getAllArtikel().size();
        for(int a  = 0 ; a <jumlahArtikel;a++){
            String [] splitArtikel  = databaseHelper.getAllArtikel().get(a).split("##");
            ArtikelObjek artikel = new ArtikelObjek(splitArtikel[0],splitArtikel[1],splitArtikel[2],splitArtikel[3]);
            listPaket1.add(artikel);
        }

        adapter1 = new CustomListArtikel(this,listPaket1);
        listView.setAdapter(adapter1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ArtikelObjek clickedDetail = (ArtikelObjek) parent.getItemAtPosition(position);
                Intent intent = new Intent(listArtikel.this, artikel.class);
                intent.putExtra("Paket", clickedDetail.getLinkUrl());
                intent.putExtra("Judul", clickedDetail.getJudul());

                startActivity(intent);



            }
        });







    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.





        return super.onOptionsItemSelected(item);
    }
}
