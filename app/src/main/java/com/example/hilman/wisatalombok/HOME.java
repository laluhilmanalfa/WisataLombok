package com.example.hilman.wisatalombok;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.view.Window;

import android.widget.Button;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.example.hilman.wisatalombok.JSONParser;
import java.util.ArrayList;
import com.example.hilman.wisatalombok.DatabaseHelper;

public class HOME extends ActionBarActivity {

    ImageView listArtikel;
    ImageView paketWisata;
    ImageView bookingWisata;
    DatabaseHelper databaseHelper;
    TextView teks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Wisata Lombok");
        setContentView(R.layout.activity_home);
        databaseHelper = new DatabaseHelper(getApplicationContext());
        databaseHelper.getWritableDatabase();
        new ProgressTask(HOME.this).execute();
        
        listArtikel = (ImageView)findViewById(R.id.imageButton1);
        listArtikel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //  Toast.makeText(this , "Ajukan umpan balik: ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HOME.this, listArtikel.class);
                startActivity(intent);
            }
        });


        paketWisata = (ImageView)findViewById(R.id.imageButton2);
        bookingWisata = (ImageView)findViewById(R.id.imageButton3);
        paketWisata.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
              //  Toast.makeText(this , "Ajukan umpan balik: ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HOME.this, PaketWisata.class);
                startActivity(intent);
            }
        });
        bookingWisata.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //  Toast.makeText(this , "Ajukan umpan balik: ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HOME.this, Boking.class);
                startActivity(intent);
            }
        });
       /* TextView boking = (TextView) findViewById(R.id.boking);
        boking.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //  Toast.makeText(this , "Ajukan umpan balik: ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HOME.this, Boking.class);
                startActivity(intent);
            }
        });*/

         teks = (TextView) findViewById(R.id.home);


        /*teks.setText("Hotel " + databaseHelper.getAllHotel().size()+" kelasHotel "+ databaseHelper.getAllKelasHotel().size()+" restoran "+ databaseHelper.getAllRestoran().size() + "t wisata " + databaseHelper.getAllTempatWisata().size()+
  "margin" + databaseHelper.getAllMargin().size() + "paketWista  " + databaseHelper.getAllPaketWisata().size()+ " transportasi " + databaseHelper.getAllTransportasi().size()
        );*/



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

    private class ProgressTask extends AsyncTask<String, Void, Boolean> {
        private ProgressDialog dialog;
        private Context context;
        private HOME activity;
        boolean update;
        String tes = "";

        public ProgressTask(HOME activity) {
            this.activity = activity;
            context = activity;
            dialog = new ProgressDialog(context);
        }
        protected void onPreExecute() {
            this.dialog.setMessage("Sedang mengambil data...");
            this.dialog.show();
            this.dialog.setCancelable(false);
        }
        @Override
        protected void onPostExecute(final Boolean success) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }

            /*if(databaseHelper.getAllInfoUpdateServers().size()!=0) {
                ArrayList<String> printhotel = databaseHelper.getAllHotel();

                String hasil  = "";
                for(int a  =  0 ; a < databaseHelper.getAllInfoUpdateServers().size(); a++){
                    hasil = hasil + a+ " "+ databaseHelper.getAllInfoUpdateServers().get(a);
                }
                teks.setText(hasil);
            }*/

            if(update){


               // teks.setText("tidak uptodate gara gara" + tes);
            }
            else
            {
              // teks.setText("update");

            }
            if(databaseHelper.getAllKelasHotel()!=null || databaseHelper.getAllKelasHotel().size()>0){
            /*teks.setText("jumlah data "+databaseHelper.getAllKelasHotel().size());*/
            }
            databaseHelper.close();

        }

        @Override
        protected Boolean doInBackground(String... arg0) {

            String infoUpdate= "http://tunjukinui.com/tes/waktu.php";
            String infoHotel= "http://tunjukinui.com/tes/hotel.php";
            String infoKelasHotel= "http://tunjukinui.com/tes/kelashotel.php";
            String infoTempatWisata= "http://tunjukinui.com/tes/tempatwisata.php";
            String infoRestoran= "http://tunjukinui.com/tes/restoran.php";
            String infoMargin= "http://tunjukinui.com/tes/margin.php";
            String infoHargaTransportasi ="http://tunjukinui.com/tes/hargatransportasi.php";
            String infoTransportasi= "http://tunjukinui.com/tes/transportasi.php";
            String infoGalery = "http://tunjukinui.com/tes/galery.php";
            String infoartikel = "http://tunjukinui.com/tes/artikel.php";
            databaseHelper.deleterecord("InfoUpdateServers");
            JSONtoDBInfoUpdateServer(infoUpdate, true);
            update = false;
            databaseHelper.deleterecord("Margin");
            JSONtoDBMargin(infoMargin);
            if(databaseHelper.getAllHotel().size() ==0){
                JSONtoDBHotel(infoHotel);
                JSONtoDBKelasHote(infoKelasHotel);
                JSONtoDBInfoUpdateServer(infoUpdate, false);
                JSONtoDBTempatWisata(infoTempatWisata);
                JSONtoDBHargaTransportasi(infoHargaTransportasi);
                JSONtoDBGalery(infoGalery);
                JSONtoDBArtikel(infoartikel);
            }
            else{
                /*databaseHelper.deleterecord("Hotel");
                JSONtoDBHotel(infoHotel);
                databaseHelper.deleterecord("KelasHotel");
                JSONtoDBKelasHote(infoKelasHotel);
                databaseHelper.deleterecord("Galery");
                JSONtoDBGalery(infoGalery);
                databaseHelper.deleterecord("Margin");
                JSONtoDBMargin(infoMargin);
                databaseHelper.deleterecord("Artikel");
                JSONtoDBArtikel(infoartikel);
*/

                //`InfoUpdateServers` (`TempatWisata``Hotel`KelasHotel``Margin``Artikel``Galery``HargaTransportasi`);";
                ArrayList<String> server = databaseHelper.getAllInfoUpdateServers();
                ArrayList<String> lokal = databaseHelper.getAllInfoUpdateSQLlite();
                for(int a = 0; a <server.size();a++){
                    //tempatWisata
                    if(!server.get(0).equals(lokal.get(0)))
                    {   databaseHelper.deleterecord("TempatWisata");
                        JSONtoDBTempatWisata(infoTempatWisata);
                        update = true;
                        tes = "tempat wisata";
                    }
                    //Hotel
                    if(!server.get(1).equals(lokal.get(1)))
                    {
                        databaseHelper.deleterecord("Hotel");
                        JSONtoDBHotel(infoHotel);
                        update = true;
                        tes = "hotel";
                    }
                    //KelasHotel
                    if(!server.get(2).equals(lokal.get(2)))
                    {
                        databaseHelper.deleterecord("KelasHotel");
                        JSONtoDBKelasHote(infoKelasHotel);
                        update = true;
                        tes = "kelashotel";
                    }
                    //Margin
                    /*if(!server.get(3).equals(lokal.get(3)))
                    {
                        databaseHelper.deleterecord("Margin");
                        JSONtoDBMargin(infoMargin);
                        update = true;
                    }*/
                    //artikel
                    if(!server.get(4).equals(lokal.get(4)))
                    {
                        databaseHelper.deleterecord("Artikel");
                        JSONtoDBArtikel(infoartikel);
                        update = true;
                        tes = "artikel";
                    }
                    //Galery
                    if(!server.get(5).equals(lokal.get(5)))
                    {
                        databaseHelper.deleterecord("Galery");
                        JSONtoDBGalery(infoGalery);
                        update = true;
                        tes = "galery";
                    }
                    // hargatransportasi
                    if(!server.get(6).equals(lokal.get(6)))
                    {
                        databaseHelper.deleterecord("HargaTransportasi");
                        JSONtoDBHargaTransportasi(infoHargaTransportasi);
                        tes = "transportasi";
                        update = true;
                    }
                    if(update){
                        databaseHelper.deleterecord("InfoUpdateSQLlite");
                        JSONtoDBInfoUpdateServer(infoUpdate,false);
                    }
                }

            }

            return null;
        }
        private void JSONtoDBInfoUpdateServer(String url, boolean isUpdateServer) {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            databaseHelper.getWritableDatabase();

            JSONParser jParser = new JSONParser();
            JSONArray json = jParser.getJSONFromUrl(url);
            generateDatabaseInfoUpdateServer(json, isUpdateServer);

        }
        private void JSONtoDBHotel(String url) {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            databaseHelper.getWritableDatabase();

            JSONParser jParser = new JSONParser();
            JSONArray json = jParser.getJSONFromUrl(url);
            generateDatabaseHotel(json);

        }

        private void JSONtoDBKelasHote(String url) {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            databaseHelper.getWritableDatabase();

            JSONParser jParser = new JSONParser();
            JSONArray json = jParser.getJSONFromUrl(url);
            generateDatabaseKelasHotel(json);

        }


        private void JSONtoDBTempatWisata(String url) {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            databaseHelper.getWritableDatabase();

            JSONParser jParser = new JSONParser();
            JSONArray json = jParser.getJSONFromUrl(url);
            generateDatabaseTempatWisata(json);

        }

        private void JSONtoDBMargin(String url) {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            databaseHelper.getWritableDatabase();

            JSONParser jParser = new JSONParser();
            JSONArray json = jParser.getJSONFromUrl(url);
            generateDatabaseMargin(json);

        }
        private void JSONtoDBGalery(String url) {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            databaseHelper.getWritableDatabase();

            JSONParser jParser = new JSONParser();
            JSONArray json = jParser.getJSONFromUrl(url);
            generateDatabaseGalery(json);

        }

        private void JSONtoDBArtikel(String url) {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            databaseHelper.getWritableDatabase();

            JSONParser jParser = new JSONParser();
            JSONArray json = jParser.getJSONFromUrl(url);
            generateDatabaseArtikel(json);

        }


        private void JSONtoDBTransportasi(String url) {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            databaseHelper.getWritableDatabase();

            JSONParser jParser = new JSONParser();
            JSONArray json = jParser.getJSONFromUrl(url);
            generateDatabaseTransportasi(json);

        }

        private void JSONtoDBHargaTransportasi(String url) {
            databaseHelper = new DatabaseHelper(getApplicationContext());
            databaseHelper.getWritableDatabase();

            JSONParser jParser = new JSONParser();
            JSONArray json = jParser.getJSONFromUrl(url);
            generateDatabaseHargaTransportasi(json);

        }

        private void generateDatabaseInfoUpdateServer(JSONArray data, boolean isUpdateServer) {

            if (data != null) {
                for (int i = 0; i <data.length(); i++) {
                    try {
                        int id = i + 1;


                        JSONObject obj = data.getJSONObject(i);
                        String tiketwisata = obj.getString("tempatwisata");
                        String hotel = obj.getString("hotel");
                        String kelashotel = obj.getString("kelashotel");
                        String margin = obj.getString("margin");
                        String artikel = obj.getString("artikel");
                        String galery = obj.getString("galery");
                        String hargatransportasi = obj.getString("hargatransportasi");
              // ( String TempatWisata,String Hotel ,String KelasHotel ,String Margin ,String Artikel, String Galery,String HargaTransportasi, boolean isUpdateServer) {
                  databaseHelper.insertInfoUpdateServer(tiketwisata,hotel,kelashotel,margin,artikel,galery,hargatransportasi, isUpdateServer);




                    } catch (JSONException e) {
                        Log.e("ErrorDBBuku", e.toString());
                    }

                }
            }
        }



        private void generateDatabaseMargin(JSONArray data) {

            if (data != null) {
                for (int i = 0; i <data.length(); i++) {
                    try {
                        int id = i + 1;
                        JSONObject obj = data.getJSONObject(i);
                        int margin = Integer.parseInt(obj.getString("Margin"));

                        databaseHelper.insertmargin(margin);


                    } catch (JSONException e) {
                        Log.e("ErrorDBBuku", e.toString());
                    }

                }
            }
        }
        private void generateDatabaseTempatWisata(JSONArray data) {

            if (data != null) {
                for (int i = 0; i <data.length(); i++) {
                    try {
                        int id = i + 1;
                        JSONObject obj = data.getJSONObject(i);
                        String namaTempatWisata = obj.getString("Nama");
                        int tiket = Integer.parseInt(obj.getString("Tiket"));

                        databaseHelper.insertTempatWisata(namaTempatWisata, tiket);


                    } catch (JSONException e) {
                        Log.e("ErrorDBBuku", e.toString());
                    }

                }
            }
        }

        private void generateDatabaseHotel(JSONArray data) {

            if (data != null) {
                for (int i = 0; i <data.length(); i++) {
                    try {
                        int id = i + 1;
                        JSONObject obj = data.getJSONObject(i);
                        String kodeHotel = obj.getString("KodeHotel");
                        String namaHotel = obj.getString("Nama");
                        databaseHelper.insertHotel(kodeHotel, namaHotel);


                    } catch (JSONException e) {
                        Log.e("ErrorDBBuku", e.toString());
                    }

                }
            }
        }

        private void generateDatabaseTransportasi(JSONArray data) {

            if (data != null) {
                for (int i = 0; i <data.length(); i++) {
                    try {
                        int id = i + 1;
                        JSONObject obj = data.getJSONObject(i);
                        String nama = obj.getString("Nama");
                        int  harga= Integer.parseInt(obj.getString("Harga"));
                        databaseHelper.insertTransportasi(nama, harga);


                    } catch (JSONException e) {
                        Log.e("ErrorDBBuku", e.toString());
                    }

                }
            }
        }
        private void generateDatabaseHargaTransportasi(JSONArray data) {

            if (data != null) {
                for (int i = 0; i <data.length(); i++) {
                    try {
                        int id = i + 1;
                        JSONObject obj = data.getJSONObject(i);
                        String jurusan = obj.getString("Jurusan");
                        int  std= Integer.parseInt(obj.getString("Std"));
                        int  shorte= Integer.parseInt(obj.getString("Shorte"));
                        int  longe= Integer.parseInt(obj.getString("Longe"));
                        int  hiace13= Integer.parseInt(obj.getString("Hiace13"));
                        int  bus25= Integer.parseInt(obj.getString("Bus25"));
                        int  bus29= Integer.parseInt(obj.getString("Bus29"));
                        int  bus31= Integer.parseInt(obj.getString("Bus31"));
                        int  bus49= Integer.parseInt(obj.getString("Bus49"));

                        databaseHelper.insertHargaTransportasi(jurusan,std,shorte,longe,hiace13,bus25,bus29,bus31,bus49);


                    } catch (JSONException e) {
                        Log.e("ErrorDBBuku", e.toString());
                    }

                }
            }
        }



        private void generateDatabaseKelasHotel(JSONArray data) {

            if (data != null) {
                for (int i = 0; i <data.length(); i++) {
                    try {
                        int id = i + 1;

                        //String kodeHotel, String kelasHotel, int bintang, int low, int high, int peak, int extrabed
                        JSONObject obj = data.getJSONObject(i);
                        String kodeHotel = obj.getString("KodeHotel");
                        String namaHotel = obj.getString("KelasHotel");
                        int bintang =Integer.parseInt(obj.getString("Bintang")) ;
                        int low =Integer.parseInt(obj.getString("Low")) ;
                        int high =Integer.parseInt(obj.getString("High")) ;
                        int peak =Integer.parseInt(obj.getString("Peak")) ;
                        int extralow =Integer.parseInt(obj.getString("Extralow")) ;
                        int extrahigh =Integer.parseInt(obj.getString("Extrahigh")) ;
                        int extrapeak =Integer.parseInt(obj.getString("Extrapeak")) ;
                        databaseHelper.insertKelasHotel(kodeHotel, namaHotel, bintang,low,high,peak,extralow,extrahigh,extrapeak);


                    } catch (JSONException e) {
                        Log.e("ErrorDBBuku", e.toString());
                    }

                }
            }
        }

        //query = "CREATE TABLE `Artikel` (`judul` TEXT, `linkGambar` TEXT, `linkArtikel` TEXT, `sinopsis` TEXT);";
        private void generateDatabaseArtikel(JSONArray data) {

            if (data != null) {
                for (int i = 0; i <data.length(); i++) {
                    try {
                        int id = i + 1;
                        JSONObject obj = data.getJSONObject(i);


                        String judul = obj.getString("Judul");
                        String linkGambar = obj.getString("LinkGambar");
                        String linkArtikel = obj.getString("LinkArtikel");
                        String sinopsis = obj.getString("Sinopsis");


                        databaseHelper.insertArtikel(judul, linkGambar,linkArtikel, sinopsis);


                    } catch (JSONException e) {
                        Log.e("ErrorDBBuku", e.toString());
                    }

                }
            }
        }


        private void generateDatabaseGalery(JSONArray data) {

            if (data != null) {
                for (int i = 0; i <data.length(); i++) {
                    try {
                        int id = i + 1;
                        JSONObject obj = data.getJSONObject(i);


                        String paket = obj.getString("Paket");
                        String linkGambar = obj.getString("LinkGambar");



                        databaseHelper.insertGalery(paket, linkGambar);


                    } catch (JSONException e) {
                        Log.e("ErrorDBBuku", e.toString());
                    }

                }
            }
        }


    }

}
