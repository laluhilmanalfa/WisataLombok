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
import com.example.hilman.wisatalombok.PaketTour;

import com.example.hilman.wisatalombok.LruBitmapCache;
import com.example.hilman.wisatalombok.CustomListAdapter;
import com.example.hilman.wisatalombok.AppController;
import com.example.hilman.wisatalombok.PaketTour;

import com.example.hilman.wisatalombok.ArtikelObjek;
import com.example.hilman.wisatalombok.CustomListArtikel;



public class PaketWisata extends ActionBarActivity {

     List<PaketTour> listPaket = new ArrayList<PaketTour>();

     CustomListAdapter adapter;

    ListView listView;
    List<ArtikelObjek> listPaket1 = new ArrayList<ArtikelObjek>();
    CustomListArtikel adapter1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paket_wisata);

        listView = (ListView) findViewById(R.id.list);

/*
        for(int a = 0 ; a < 10; a++) {
            //  public PaketTour(String title, String thumbnailUrl, String harga, ArrayList<String> tempat) {
            ArrayList<String> tempat = new ArrayList<String>();
            tempat.add("Senggigi");
            PaketTour paket = new PaketTour("Tour Lombok 4 Hari 3 Malam (A)", "http://www.paketliburanlombok.com/wp-content/uploads/2014/05/Paket-Liburan-ke-Kuta-Lombok-400x260.jpg", "RP. 1.700.000",tempat );
            listPaket.add(paket);
        }
*/


        ArrayList<String> P4H3MA = new ArrayList<String>();
        P4H3MA.add("Gili Trawangan, Kuta Lombok, Malimbu, dll");
        ArrayList<String> P4H3MB = new ArrayList<String>();
        P4H3MB.add("Pink Beach, Gili Trawangan, Kuta Lombok");
        ArrayList<String> P4H3MC = new ArrayList<String>();
        P4H3MC.add(" Pink Beach, Sendang Gila & Tiu Kelep Waterfall, Kuta");
        ArrayList<String> P3H2MA = new ArrayList<String>();
        P3H2MA.add("Gili Trawangan, Kuta Surrounding, Dusun Sade, dll");
        ArrayList<String> P3H2MB = new ArrayList<String>();
        P3H2MB.add("Gili Trawangan, Hutan Pusuk, Taman Narmada");
        ArrayList<String> P3H2MC = new ArrayList<String>();
        P3H2MC.add("Kuta Lombok, Bayan Village, Malimbu, dll");
        ArrayList<String> P3H2MD = new ArrayList<String>();
        P3H2MD.add("Pink Beach, Pulau Pasir, Kuta Lombok");
        ArrayList<String> P2H1MA = new ArrayList<String>();
        P2H1MA.add("Gili Trawangan, Malimbu, Lingsar, dll");
        ArrayList<String> P2H1MB = new ArrayList<String>();
        P2H1MB.add("Taman Narmada, Pura Lingsar, Kuta Lombok, dll");


        PaketTour paket = new PaketTour("Tour Lombok 4 Hari 3 Malam (A)", "http://www.paketliburanlombok.com/wp-content/uploads/2014/05/Paket-Liburan-ke-Kuta-Lombok-400x260.jpg", "RP. 1.700.000",P4H3MA ,"PLL-4H3MA" );
        listPaket.add(paket);
        PaketTour paketa = new PaketTour("Tour Lombok 4 Hari 3 Malam (B)", "http://www.paketliburanlombok.com/wp-content/uploads/2014/05/Paket-Liburan-ke-Kuta-Lombok-400x260.jpg", "RP. 2.060.000",P4H3MB ,"PLL-4H3MB");
        listPaket.add(paketa);
        PaketTour paketb = new PaketTour("Tour Lombok 4 Hari 3 Malam (C)", "http://www.paketliburanlombok.com/wp-content/uploads/2014/05/Paket-Liburan-ke-Kuta-Lombok-400x260.jpg", "RP. 1.850.000",P4H3MC ,"PLL-4H3MC");
        listPaket.add(paketb);
        PaketTour paketc = new PaketTour("Tour Lombok 3 Hari 2 Malam (A)", "http://www.paketliburanlombok.com/wp-content/uploads/2014/05/Paket-Liburan-ke-Kuta-Lombok-400x260.jpg", "RP. 1.545.000",P3H2MA,"PLL-3H2MA" );
        listPaket.add(paketc);
        PaketTour paketd = new PaketTour("Tour Lombok 3 Hari 2 Malam (B)", "http://www.paketliburanlombok.com/wp-content/uploads/2014/05/Paket-Liburan-ke-Kuta-Lombok-400x260.jpg", "RP. 1.545.000",P3H2MB, "PLL-3H2MB" );
        listPaket.add(paketd);
        PaketTour pakete = new PaketTour("Tour Lombok 3 Hari 2 Malam (C)", "http://www.paketliburanlombok.com/wp-content/uploads/2014/05/Paket-Liburan-ke-Kuta-Lombok-400x260.jpg", "RP. 1.250.000",P3H2MC, "PLL-3H2MC" );
        listPaket.add(pakete);
        PaketTour paketf = new PaketTour("Tour Lombok 3 Hari 2 Malam (D)", "http://www.paketliburanlombok.com/wp-content/uploads/2014/05/Paket-Liburan-ke-Kuta-Lombok-400x260.jpg", "RP. 1.400.000",P3H2MD, "PLL-3H2MD" );
        listPaket.add(paketf);
        PaketTour paketg = new PaketTour("Tour Lombok 2 Hari 1 Malam (A)", "http://www.paketliburanlombok.com/wp-content/uploads/2014/05/Paket-Liburan-ke-Kuta-Lombok-400x260.jpg", "RP. 1.530.000",P2H1MA, "PLL-2H1MA" );
        listPaket.add(paketg);
        PaketTour paketh = new PaketTour("Tour Lombok 2 Hari 1 Malam (B)", "http://www.paketliburanlombok.com/wp-content/uploads/2014/05/Paket-Liburan-ke-Kuta-Lombok-400x260.jpg", "RP. 1.380.000",P2H1MB, "PLL-2H1MB" );
        listPaket.add(paketh);



        adapter = new CustomListAdapter(this, listPaket);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                PaketTour clickedDetail = (PaketTour) parent.getItemAtPosition(position);
                Intent intent = new Intent(PaketWisata.this, DetailPaket.class);
                intent.putExtra("Paket", clickedDetail.getTitle());
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
