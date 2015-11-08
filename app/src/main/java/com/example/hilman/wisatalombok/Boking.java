package com.example.hilman.wisatalombok;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.example.hilman.wisatalombok.JSONParser;

import android.app.DatePickerDialog;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.DatePicker;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import android.widget.AdapterView.OnItemSelectedListener;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import android.text.InputType;

import java.util.ArrayList;

import java.util.Calendar;

import java.util.List;

import java.util.Locale;

import android.view.View.OnClickListener;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.hilman.wisatalombok.DatabaseHelper;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;


public class Boking extends ActionBarActivity implements View.OnClickListener {


    private Calendar calendar;
    private DatePickerDialog datePickerDialogs;
    private SimpleDateFormat dateFormat;

    TextView labelHotel ;
    Button submit;

    String detail;
    String nama;
    String email;
    String noHP;
    String namaPaket;
    String namaHotel;

    ToggleButton togel;

    TextView labelKelasHotel;

    EditText pesan;

    Spinner kelasHotel;
    EditText namaWisatawan;
    EditText emailWisatawan;
    EditText noHPWisatawan;
    Spinner paketWisata;
    Spinner hotel;
    RadioButton radioButtonDiner ;
    EditText tanggal ;
    EditText peserta;
    EditText jumlahRanjang ;
    RadioGroup tambahRanjang;

    RadioButton statusHotel ;
    RadioButton statusRanjang;

    Activity aktivitas = this;
    DatabaseHelper database;

    JSONParser jsonParser = new JSONParser();
    EditText contentForm ;
    private static final String TAG_SUCCESS = "success";

    private EditText tanggalAcara;

    ArrayList<String> hargaTranportasi ;
    ArrayList<String> tiketWisata;
    ArrayList<String> restorant;
    ArrayList<String> listHotel ;
    ArrayList<String> listKelasHotel;
    RadioButton privateBoat;
    RadioButton publicBoat;

    TextView teks ;
    String kelasHotil;

    Button kirim ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boking);
        teks = (TextView) findViewById(R.id.INFO);
        setTitle("Boking Paket Wisata");
        database =  new DatabaseHelper(getApplicationContext());
        database.getWritableDatabase();
        hargaTranportasi = database.getAllHargaTransportasi();
        tiketWisata = database.getAllTempatWisata();
        listHotel = database.getAllHotel();
        listKelasHotel = database.getAllKelasHotel();
        paketWisata = (Spinner) findViewById(R.id.SpinnerPaketWisata);
        hotel = (Spinner) findViewById(R.id.SpinnerPilihHotel);
        dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        tanggalAcara = (EditText) findViewById(R.id.tanggal);
        tanggalAcara.setInputType(InputType.TYPE_NULL);
        setDateTimeField();
        labelHotel = (TextView)findViewById(R.id.PilihHotelLabel);
        kirim = (Button) findViewById(R.id.kirim);
        kirim.setVisibility(View.GONE);
        pesan = (EditText) findViewById(R.id.pesan);
        ArrayList<String> labelPaketWisata = new ArrayList<String>();
        labelPaketWisata.add("Paket 4 Hari 3 Malam A ");
        labelPaketWisata.add("Paket 4 Hari 3 Malam B ");
        labelPaketWisata.add("Paket 4 Hari 3 Malam C ");
        labelPaketWisata.add("Paket 3 Hari 2 Malam A ");
        labelPaketWisata.add("Paket 3 Hari 2 Malam B ");
        labelPaketWisata.add("Paket 3 Hari 2 Malam C ");
        labelPaketWisata.add("Paket 3 Hari 2 Malam D ");
        labelPaketWisata.add("Paket 2 Hari 1 Malam A ");
        labelPaketWisata.add("Paket 2 Hari 1 Malam B ");
        ArrayAdapter<String> adapterPaketWisata = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,labelPaketWisata);

        paketWisata.setAdapter(adapterPaketWisata);





        final ArrayList<String> daftartHotel = database.getAllHotel();

        ArrayList<String> labelHotel = new ArrayList<String>();
        for(int r = 0 ; r < daftartHotel.size(); r++){

            String [] namaHotel = daftartHotel.get(r).split("#");
            labelHotel.add(namaHotel[0]);
        }

        ArrayAdapter<String> adapterHotel = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,labelHotel );
        hotel.setAdapter(adapterHotel);

        kelasHotel =(Spinner) findViewById(R.id.SpinnerKelasHotel) ;
        labelKelasHotel = (TextView) findViewById(R.id.PilihKelasHotelLabel);

        final  ArrayList<String> kelasHotelLabel   = new ArrayList<String>();
        AdapterView.OnItemSelectedListener item = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                kelasHotelLabel.clear();
                ArrayList<String> daftarHargaHotel = database.getAllKelasHotel();
                ArrayList<String> labelKelasHotel = new ArrayList<String>();
                
                for(int a = 0; a <daftarHargaHotel.size(); a++ ){
                    String [] kelasHotel = daftarHargaHotel.get(a).split("#");
                    if(hotel.getSelectedItem().toString().equals(kelasHotel[0])){
                        labelKelasHotel.add(kelasHotel[1] +" Rp."+ kelasHotel[3]+"/malam");
                    }
                }
                ArrayAdapter<String> adapterHotels = new ArrayAdapter<String>(aktivitas,android.R.layout.simple_spinner_dropdown_item,labelKelasHotel);
                kelasHotel.setAdapter(adapterHotels);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };


      /*  ArrayAdapter<String> adapterHotels = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,kelasHotelLabel);
        kelasHotel.setAdapter(adapterHotels);*/

        hotel.setOnItemSelectedListener(item);

        labelKelasHotel = (TextView) findViewById(R.id.PilihKelasHotelLabel);
        namaWisatawan =(EditText) findViewById(R.id.Nama);

        emailWisatawan =(EditText) findViewById(R.id.Email);
        noHPWisatawan =(EditText) findViewById(R.id.Handphone);
        radioButtonDiner = (RadioButton) findViewById(R.id.radioDiner);
        tanggal = (EditText) findViewById(R.id.tanggal);
        peserta = (EditText) findViewById(R.id.JumlahPeserta);
        jumlahRanjang = (EditText) findViewById(R.id.jumlahTambahRanjang);
        tambahRanjang = (RadioGroup) findViewById(R.id.tambahRanjangLabel);


       submit = (Button)findViewById(R.id.ButtonOK);
      Button  kirim = (Button)findViewById(R.id.kirim);
        kirim.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //  Toast.makeText(this , "Ajukan umpan balik: ", Toast.LENGTH_SHORT).show();
             openDialog();
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



    public String getFormat(int hour, int min) {
        String format = "";
        if (hour == 0) {
            hour += 12;
            format = "AM";
        } else if (hour == 12) {
            format = "PM";
        } else if (hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }
        return format;
    }

    void setDateTimeField() {
        tanggalAcara.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        datePickerDialogs = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                tanggalAcara.setText(dateFormat.format(newDate.getTime()));
            }

             public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                if (year < Calendar.YEAR)
                    view.updateDate(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);

                if (monthOfYear < Calendar.MONTH && year == Calendar.YEAR)
                    view.updateDate(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);

                if (dayOfMonth < Calendar.DAY_OF_MONTH && year == Calendar.YEAR && monthOfYear == Calendar.YEAR)
                    view.updateDate(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);

            }


        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

    }
    public void onClick(View view) {
        if(view == tanggalAcara) {
            datePickerDialogs.show();
        }
    }
    public void onToggleClicked(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            hotel.setVisibility(View.VISIBLE);
            labelHotel.setVisibility(View.VISIBLE);

        } else {
            // Disable vibrate
            hotel.setVisibility(View.GONE);
            labelHotel.setVisibility(View.GONE);

        }
    }

    public void sendMessage(View view) {
        // Do something in response to button



    }
    public void eror(View view){
      //  namaWisatawan.setError(" maad nama anda jelek");
    }
    public void setHotel(View view){
        hotel.setVisibility(View.VISIBLE);
        labelHotel.setVisibility(View.VISIBLE);
        labelKelasHotel.setVisibility(View.VISIBLE);
        kelasHotel.setVisibility(View.VISIBLE);
        tambahRanjang.setVisibility(View.VISIBLE);
        jumlahRanjang.setVisibility(View.VISIBLE);
      //  namaWisatawan.setError(" maad nama anda jelek");

    }
    public void setNonHotel(View view){
        hotel.setVisibility(View.GONE);
        labelHotel.setVisibility(View.GONE);
        labelKelasHotel.setVisibility(View.GONE);
        kelasHotel.setVisibility(View.GONE);
        tambahRanjang.setVisibility(View.GONE);
        jumlahRanjang.setVisibility(View.GONE);

    }

    public void setRanjang(View view){
         jumlahRanjang.setVisibility(View.VISIBLE);
    }
    public void setNonRanjang(View view){
        jumlahRanjang.setVisibility(View.GONE);
    }



    class Send extends AsyncTask<String, String, String> {
        ProgressDialog pDialog;
        private Activity activity;

        String status = "";
        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog.setMessage("Kirim Permintaan");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        public Send(Activity activity) {
            this.activity = activity;
            pDialog = new ProgressDialog(activity);
        }


        /**
         * Creating product
         * */
        protected String doInBackground(String... args) {


            String url = "http://tunjukinui.com/jangandihapus/email.php";

            String nama = namaWisatawan.getText().toString();
            String email = emailWisatawan.getText().toString();
            String noHp = noHPWisatawan.getText().toString();
            String namaHotel = hotel.getSelectedItem().toString() + kelasHotel.getSelectedItem().toString();
            String paketWisatas = paketWisata.getSelectedItem().toString();
            String Tanggal = tanggal.getText().toString();
            String jumlahPeserta  = peserta.getText().toString();
            String Diner = "";
            String request = pesan.getText().toString();


            if(radioButtonDiner.isChecked()){
                 Diner = "ya";
            }
            else{
                 Diner = "tidak";
            }

            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("nama", nama));
            params.add(new BasicNameValuePair("email", email));
            params.add(new BasicNameValuePair("noHp", noHp));
            params.add(new BasicNameValuePair("namaHotel", namaHotel));
            params.add(new BasicNameValuePair("Diner", Diner));
            params.add(new BasicNameValuePair("paketWisata", paketWisatas));
            params.add(new BasicNameValuePair("Tanggal", Tanggal));
            params.add(new BasicNameValuePair("jumlahPeserta", jumlahPeserta));
            params.add(new BasicNameValuePair("detail", detail));
            params.add(new BasicNameValuePair("pesan", request));


            // getting JSON Object
            // Note that create product url accepts POST method
            JSONObject json = jsonParser.makeHttpRequest(url,
                    "POST", params);


            Log.d("Create Response", json.toString());

            // check for success tag
            try {
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {


                    status = "berhasil";
                } else {

                    status = "failed";
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once done
            pDialog.dismiss();
            if(status.equals("berhasil")){



                final AlertDialog alertDialog = new AlertDialog.Builder(activity).create();

                alertDialog.setMessage("Pemesanan Anda Sudah Terkirim");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Boking.this, InformasiPembayaran.class);
                        startActivity(intent);
                    }
                });
                alertDialog.show();
            }
            else{
                final AlertDialog alertDialog = new AlertDialog.Builder(activity).create();

                alertDialog.setMessage("Pemesanan Anda Belum Terkirim \n Silahkan Coba lagi");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.cancel();
                    }
                });
                alertDialog.show();

            }


        }
    }

    public void ok(View view){

        boolean benar = true;
        String nama = namaWisatawan.getText().toString();
        String email = emailWisatawan.getText().toString();
        String noHp = noHPWisatawan.getText().toString();
        String namaHotel = hotel.getSelectedItem().toString() + kelasHotel.getSelectedItem().toString();
        String paketWisatas = paketWisata.getSelectedItem().toString();
        String tanggalWisata = tanggal.getText().toString();
        String jumlahPeserta  = peserta.getText().toString();
        String Diner = "";
        String jumlahTambahRanjang = jumlahRanjang.getText().toString();
        if(radioButtonDiner.isChecked()){
            Diner = "ya";
        }
        else{
            Diner = "tidak";
        }

        if(nama.equals("")){
            namaWisatawan.setError("Silahkan masukan nama anda");
            benar= false;
        }
        if(email.equals("")){
            emailWisatawan.setError("Silahkan masukan E-mail anda ");
            benar = false;
        }
        else{
            if(!email.contains("@")|| !email.contains(".")){
                emailWisatawan.setError("Format email salah");
                benar = false;
            }

        }
        if(noHp.equals("")){
            noHPWisatawan.setError("Silahkan masukan no Hp Anda");
            benar = false;
        }
        else if(noHp.length()>12){
            noHPWisatawan.setError("No HO tidak boleh lebih dari 12");
            benar = false;
        }
        else if(noHp.length()<10){
            noHPWisatawan.setError("No HO tidak boleh kurang dari 10");
            benar = false;
        }
        else{


        }
        if(jumlahPeserta.equals("")){
            peserta.setError("Silahkan masukan jumlah peserta");
            benar = false;
        }
        statusHotel = (RadioButton) findViewById(R.id.radioHotel);
        statusRanjang  = (RadioButton) findViewById(R.id.tamhahRanjang);
        if(statusRanjang.isChecked() && statusHotel.isChecked()){
            if(jumlahTambahRanjang.equals("")){
                benar = false;
                jumlahRanjang.setError("Silahkan masukan jumlah ranjang tambahan");
            }
            else{
                if(Integer.parseInt(jumlahTambahRanjang) > Integer.parseInt(jumlahPeserta)/3){
                    benar  = false;
                    jumlahRanjang.setError("Jumlah ranjang melebihi batas");
                }
            }


        }
        if(tanggal.getText().toString().isEmpty()){
            tanggal.setError("Silahkan masukan tanggal perjalanan anda");
            benar = false;
        }


        TextView perpax = (TextView)findViewById(R.id.perpax);
        TextView total = (TextView) findViewById(R.id.total);
        TextView teksLunch = (TextView) findViewById(R.id.lunch);
        TextView teksDinner = (TextView) findViewById(R.id.dinner);
        TextView teksTransport = (TextView) findViewById(R.id.transport);
        TextView teksOther = (TextView) findViewById(R.id.other);
        TextView teksHotel = (TextView) findViewById(R.id.hotel);

        if(benar){
            int hargaHotel = 0;
            int ekstraBed = 0;
            int margin = (Integer.parseInt(database.getAllMargin().get(0))) ;
            String status="low";
            String bulan = tanggal.getText().toString().split("-")[1];
            if(bulan.equals("12") || bulan.equals("01")){
              status = "peak";
            }
            else if(bulan.equals("07") || bulan.equals("08")){
                status = "high";
            }
            else{
                status = "low";
            }

            ArrayList<String> listHargaHotel = database.getAllKelasHotel();
            for(int m  =  0 ; m <listHargaHotel.size(); m++){
                String [] splitHarga = listHargaHotel.get(m).split("#");
                if(kelasHotel.getSelectedItem().toString().equals(splitHarga[1]+ " Rp."+splitHarga[3]+"/malam")){
                 //  ekstraBed= hargaHotel=Integer.parseInt(splitHarga[6]);
                    if(status.equals("peak")){
                        hargaHotel=Integer.parseInt(splitHarga[5]);
                        ekstraBed= Integer.parseInt(splitHarga[8]);
                    }
                    else if(status.equals("high")){
                        hargaHotel=Integer.parseInt(splitHarga[4]);
                        ekstraBed= Integer.parseInt(splitHarga[7]);
                    }
                    else{
                        hargaHotel=Integer.parseInt(splitHarga[3]);
                        ekstraBed= Integer.parseInt(splitHarga[6]);
                    }


                }
            }

            teks.setText(""+hargaHotel+" "+ ekstraBed);
            int costHotel = 0;
            int jumlahKamar = 0;
            int totalPeserta= Integer.parseInt(jumlahPeserta);
            int ranjangTambahan=0;
            // dengan hotel
            if(statusHotel.isChecked()) {
                // ambil dari database berdasarkan tanggal dan nama dan kelas hotel
                if (!jumlahTambahRanjang.equals("")) {
                    ranjangTambahan = Integer.parseInt(jumlahTambahRanjang);
                    int kamarRanjang = ranjangTambahan;
                    int kamar = (totalPeserta - (3 * ranjangTambahan));
                    if (kamar % 2 == 0) {
                        kamar = kamar / 2;
                    } else {
                        if (kamar == 1) kamar = 1;
                        else {
                            kamar = (kamar / 2) + 1;
                        }
                    }
                    jumlahKamar = kamarRanjang + kamar;
                    costHotel = (jumlahKamar * hargaHotel) + (ranjangTambahan * ekstraBed );
                    // total.setText(costHotel+"");
                }
                else {
                    jumlahKamar = 0;
                    if (totalPeserta % 2 == 0) {
                        jumlahKamar = totalPeserta / 2;
                    } else {
                        if (totalPeserta == 1) jumlahKamar = 1;
                        else {
                            jumlahKamar = (totalPeserta / 2) + 1;
                        }

                    }
                    costHotel = hargaHotel * jumlahKamar;

                }
            }
            // tanpa hotel
                else{
                    costHotel=0;
                }
            int hargaMakan = 60000;
            int hargaBoatPink = 500000;
            int hargaBoatTrawangan = 600000;
            int boatPink = 0;
            int boatTrawangan = 0;

                if(paketWisatas.contains("Paket 4 Hari 3 Malam")){
                    int air = Integer.parseInt(jumlahPeserta) * 2000 * 4;
                    int guide = 100000 * 4;
                    int ganci = Integer.parseInt(jumlahPeserta) * 5000 ;
                    if(paketWisatas.equals("Paket 4 Hari 3 Malam A ")){
                        int lunch  = 2 * hargaMakan;
                        int costTrawangan = 0;
                        int penumpang = Integer.parseInt(jumlahPeserta);
                         if(penumpang%12==0){
                             costTrawangan = (penumpang/12) * hargaBoatTrawangan;
                         }
                        else{
                             costTrawangan = ((penumpang/12)+1) * hargaBoatTrawangan;
                         }
                        // 3 kali makan malam
                        int dinner = 0;
                        if(radioButtonDiner.isChecked()){
                            dinner = 3 * hargaMakan;
                        }
                        //======= menentukan biaya untuk tiket wisata Paket 4 Hari 3 Malam A
                        int narmada = 0 ;
                        int puraLingsar = 0;
                        for(int b  = 0 ; b < tiketWisata.size(); b++){
                            String [] tiket = tiketWisata.get(b).split("#");
                            String namaTempat = tiket[0]; int harga = Integer.parseInt(tiket[1]);
                            if(namaTempat.equals("Narmada")){
                                narmada = harga;
                            }
                            if(namaTempat.equals("Pura Lingsar")){
                                puraLingsar = harga;
                            }
                        }
                        narmada = narmada * totalPeserta;
                        puraLingsar= puraLingsar * totalPeserta;
                        String hasil = "";
                        int transport1 =0;
                        int transport2 =0;
                        int transport3 =0;
                        int transport4 =0;
                        for(int a  = 0 ; a < hargaTranportasi.size(); a++){
                            String [] harga = hargaTranportasi.get(a).split("#");
                            String tujuan = harga [0];
                            int std =Integer.parseInt(harga [1]);
                            int shorte =Integer.parseInt(harga [2]);
                            int longe =Integer.parseInt(harga [3]);
                            int hiace13 =Integer.parseInt(harga [4]);
                            int bus25 =Integer.parseInt(harga [5]);
                            int bus29 =Integer.parseInt(harga [6]);
                            int bus31 =Integer.parseInt(harga [7]);
                            int bus49 =Integer.parseInt(harga [8]);
                            int peserta =Integer.parseInt(jumlahPeserta);
                            if(peserta<=5){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =std;
                                }
                                if(tujuan.equals("SASAK")){
                                    transport2 =std;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport3 =std;

                                }
                                if(tujuan.equals("CO")){
                                    transport4 =std;
                                }

                            }
                            else if(peserta>5 && peserta<=9 ){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =shorte;
                                }
                                if(tujuan.equals("SASAK")){
                                    transport2 =shorte;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport3 =shorte;
                                }
                                if(tujuan.equals("CO")){
                                    transport4 =shorte;
                                }

                            }
                            else if(peserta >= 10 && peserta < 13){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =longe;
                                }
                                if(tujuan.equals("SASAK")){
                                    transport2 =longe;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport3 =longe;
                                }
                                if(tujuan.equals("CO")){
                                    transport4 =longe;
                                }


                            }
                            else if(peserta==13){

                                if(tujuan.equals("APT-CI")){
                                    transport1 =hiace13;
                                }
                                if(tujuan.equals("SASAK")){
                                    transport2 =hiace13;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport3 =hiace13;
                                }
                                if(tujuan.equals("CO")){
                                    transport4 =hiace13;
                                }

                            }
                            else if(peserta >13 && peserta <=25){

                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus25;
                                }
                                if(tujuan.equals("SASAK")){
                                    transport2 =bus25;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport3 =bus25;
                                }
                                if(tujuan.equals("CO")){
                                    transport4 =bus25;
                                }

                            }
                            else if(peserta >25 && peserta <=29){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus29;
                                }
                                if(tujuan.equals("SASAK")){
                                    transport2 =bus29;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport3 =bus29;
                                }
                                if(tujuan.equals("CO")){
                                    transport4 =bus29;
                                }

                            }
                            else if(peserta >29 && peserta <=31){

                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus31;
                                }
                                if(tujuan.equals("SASAK")){
                                    transport2 =bus31;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport3 =bus31;
                                }
                                if(tujuan.equals("CO")){
                                    transport4 =bus31;
                                }
                            }

                            else if(peserta >31 && peserta <=49){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus49;
                                }
                                if(tujuan.equals("SASAK")){
                                    transport2 =bus49;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport3 =bus49;
                                }
                                if(tujuan.equals("CO")){
                                    transport4 =bus49;
                                }
                            }
                            else{

                            }
                        }
                        labelKelasHotel.setText(costHotel+"");
                        int totalLunch = lunch * totalPeserta;
                        int totalDinner = dinner * totalPeserta;
                        int totalTransport = transport1+transport2+transport3+transport4;
                        int totalBayar = puraLingsar+narmada+ totalLunch+totalDinner+totalTransport+guide+air+ganci + (costHotel * 3) + costTrawangan;
                        int bayarplusmargin =(( margin +100) * totalBayar)/100;
                        int perpaxBayar = bayarplusmargin / totalPeserta;
                    //    total.setText("RP."+totalBayar+" + kalau margin"+bayarplusmargin + "dengan margin " +( margin));
                        perpax.setText("RP. "+perpaxBayar+"/orang" + "RP " + bayarplusmargin + "untuk biaya totaln plus margin"+ "RP " + totalBayar+" untuk baiay toal tanpa margin"  );
                        teksLunch.setText("Rp. " + totalLunch + "untuk baiay makan siang");
                        teksDinner.setText("Rp. " + totalDinner+"untuk biaya makan malam");
                        teksTransport.setText("Rp. " + totalTransport+" untk transport 4 hari\n" + transport1+ "unukt hari 1 \n"+ transport2 + "untuk hari 2\n"+transport3+"untuk hari 3" + transport4+ "untuk hari 4");
                        teksOther.setText("Rp. " + guide +" untuk biaya guide \n" +
                                          "RP. " + air+ " untuk biaya air \n" +
                                          "Rp. " + ganci+" untuk baiaya ganci\n" +
                                          "Rp. " + costTrawangan + "untuk biaya boat menuju trawangan\n" +
                                          "Rp. "+ (ekstraBed * ranjangTambahan) + "untuk" + jumlahTambahRanjang+"ekstrabed" );
                        teksHotel.setText("RP. "+ (costHotel * 3 ) +" untuk " + jumlahKamar+" kamar"+" dan " + ranjangTambahan+" ekstrabed selama 3 hari");
                        kirim.setVisibility(View.VISIBLE);
                      //  openDialog();
                        detail =  "\n\n\n\nBiaya total tanpa margin = Rp. "+totalBayar + "\n" +
                                          "Biaya total dengan margin = Rp. "+bayarplusmargin+" dengan margin "+ margin+"\n" +
                                          "Biaya perorang = Rp." +perpaxBayar+"\n" +
                                          "Biaya makan siang = Rp."+ totalLunch +" untuk 2 kali makan untuk " +totalPeserta + " orang \n" +
                                          "Biaya untuk dinner = Rp."+ totalDinner+" untuk 3 kali makan untuk " + totalPeserta+ " orang \n" +
                                          "Biaya Total Transportasi = Rp. " + totalTransport +"  \n" +
                                          "          Transportasi hari pertama Chekcin  = Rp. "+ transport1 +"\n" +
                                          "          Transportasi hari kedua Sasak = Rp. "+ transport2 +"\n" +
                                          "          Transportasi hari ketiga Sasak = Rp.  "+ transport3 +"\n" +
                                          "          Transportasi hari ketiga Sasak = Rp. "+ transport4 +"\n" +
                                          "Biaya untuk hotel = Rp. " + (costHotel * 3) +" untuk " + jumlahKamar+ " kamar dan  "+ ranjangTambahan+ " Ekstrabed selama 3 hari \n" +
                                          "Biaya untuk guide = Rp. " +guide +" untuk "+ totalPeserta +" orang\n" +
                                          "Biaya untuk air = Rp. " +air +" untuk "+ totalPeserta +" orang\n" +
                                          "Biaya untuk ganci = Rp. " +ganci +" untuk "+ totalPeserta +" orang\n" +
                                          "Biaya untuk menuju ke trawangan = Rp. " +costTrawangan +" untuk "+ totalPeserta +" orang\n" +
                                          ""    ;

                    }

                    else
                    if(paketWisatas.equals("Paket 4 Hari 3 Malam B ")){
                        // cost untuk boat ke pink
                        int costPink = 0;
                        int penumpang = Integer.parseInt(jumlahPeserta);
                        if(penumpang%10==0){
                            costPink = (penumpang/10) * hargaBoatPink;
                        }
                        else{
                            costPink = ((penumpang/10)+1) * hargaBoatPink;
                        }
                        //=============== untuk biaya boat trawangan
                        int costTrawangan = 0;
                        if(penumpang%12==0){
                            costTrawangan = (penumpang/12) * hargaBoatTrawangan;
                        }
                        else{
                            costTrawangan = ((penumpang/12)+1) * hargaBoatTrawangan;
                        }
                        //============
                        int lunch  = 3 * hargaMakan;
                        int dinner = 0;
                        if(radioButtonDiner.isChecked()){
                            dinner = 3 * hargaMakan;
                        }
                        // ============= untuk menentukan transportasi Paket 4 Hari 3 Malam B
                        String hasil = "";
                        int transport1 =0;
                        int transport2 =0;
                        int transport3 =0;
                        int transport4 =0;
                        for(int a  = 0 ; a < hargaTranportasi.size(); a++){
                            String [] harga = hargaTranportasi.get(a).split("#");
                            String tujuan = harga [0];
                            int std =Integer.parseInt(harga [1]);
                            int shorte =Integer.parseInt(harga [2]);
                            int longe =Integer.parseInt(harga [3]);
                            int hiace13 =Integer.parseInt(harga [4]);
                            int bus25 =Integer.parseInt(harga [5]);
                            int bus29 =Integer.parseInt(harga [6]);
                            int bus31 =Integer.parseInt(harga [7]);
                            int bus49 =Integer.parseInt(harga [8]);
                            int peserta =Integer.parseInt(jumlahPeserta);
                            if(peserta<=5){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =std;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =std;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport3 =std;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport4 =std;
                                }

                            }
                            else if(peserta>5 && peserta<=9 ){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =shorte;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =shorte;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport3 =shorte;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport4 =shorte;
                                }

                            }
                            else if(peserta >9 && peserta < 13){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =longe;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =longe;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport3 =longe;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport4 =longe;
                                }
                            }
                            else if(peserta==13){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =hiace13;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =hiace13;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport3 =hiace13;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport4 =hiace13;
                                }
                            }
                            else if(peserta >13 && peserta <=25){

                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus25;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =bus25;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport3 =bus25;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport4 =bus25;
                                }

                            }
                            else if(peserta >25 && peserta <=29){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus29;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =bus29;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport3 =bus29;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport4 =bus29;
                                }

                            }
                            else if(peserta >29 && peserta <=31){

                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus31;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =bus31;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport3 =bus31;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport4 =bus31;
                                }
                            }

                            else if(peserta >31 && peserta <=49){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus49;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =bus49;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport3 =bus49;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport4 =bus49;
                                }
                            }
                            else{

                            }
                        }

                        int totalLunch = lunch * totalPeserta;
                        int totalDinner = dinner * totalPeserta;
                        int totalTransport = transport1+transport2+transport3+transport4;
                        int totalBayar = totalLunch+totalDinner+totalTransport+guide+air+ganci+costPink+costTrawangan + (costHotel *3);

                        int bayarplusmargin =(( margin +100) * totalBayar)/100;
                        int perpaxBayar = bayarplusmargin / totalPeserta;
                        //total.setText("RP."+totalBayar+" + kalau margin"+bayarplusmargin + "dengan margin " +( margin));
                        perpax.setText("RP. "+perpaxBayar+"/orang" + "RP " + bayarplusmargin + "untuk biaya totaln plus margin"+ "RP " + totalBayar+" untuk baiay toal tanpa margin"  );
                        teksLunch.setText("Rp. " + totalLunch + "untuk baiay makan siang");
                        teksDinner.setText("Rp. " + totalDinner+"untuk biaya makan malam");
                        teksTransport.setText("Rp. " + totalTransport+" untk transport 4 hari\n" + transport1+ "unukt hari 1 \n"+ transport2 + "untuk hari 2\n"+transport3+"untuk hari 3" + transport4+ "untuk hari 4" );
                        teksOther.setText("Rp. " + guide +" untuk biaya guide \n" +
                                "RP. " + air+ " untuk biaya air \n" +
                                "Rp. " + ganci+" untuk biaya ganci\n" +
                                "Rp. " + costTrawangan + "untuk biaya boatTrawangan\nt" +
                                "Rp. " + costPink + "untuk biaya boat pantai pink \n" +
                                "Rp. "+ (ekstraBed * ranjangTambahan) + "untuk" + jumlahTambahRanjang+"ekstrabed");
                        teksHotel.setText("RP. "+ (costHotel * 3 ) +" untuk " + jumlahKamar+" kamar"+" dan " + ranjangTambahan+" ekstrabed selama 3 hari");


                        kirim.setVisibility(View.VISIBLE);
                        detail =  "\n\n\n\nBiaya total tanpa margin = Rp. "+totalBayar + "\n" +
                                "Biaya total dengan margin = Rp. "+bayarplusmargin+" dengan margin "+ margin+"\n" +
                                "Biaya perorang = Rp." +perpaxBayar+"\n" +
                                "Biaya makan siang = Rp."+ totalLunch +" untuk 3 kali makan untuk " +totalPeserta + " orang \n" +
                                "Biaya untuk dinner = Rp."+ totalDinner+" untuk 3 kali makan untuk " + totalPeserta+ " orang \n" +
                                "Biaya Total Transportasi = Rp. " + totalTransport +"  \n" +
                                "          Transportasi hari pertama Chekcin  = Rp. "+ transport1 +"\n" +
                                "          Transportasi hari kedua Pink = Rp. "+ transport2 +"\n" +
                                "          Transportasi hari ketiga Terawangan = Rp.  "+ transport3 +"\n" +
                                "          Transportasi hari ketiga Sasak-CO = Rp. "+ transport4 +"\n" +
                                "Biaya untuk hotel = Rp. " + (costHotel * 3) +" untuk " + jumlahKamar+ " kamar dan  "+ ranjangTambahan+ " Ekstrabed selama 3 hari \n" +
                                "Biaya untuk guide = Rp. " +guide +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk air = Rp. " +air +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk ganci = Rp. " +ganci +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk kapal menuju pink = Rp. " +costPink +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk kapal menuju ke trawangan = Rp. " +costTrawangan +" untuk "+ totalPeserta +" orang\n" +
                                ""    ;
                    }
                    else if(paketWisatas.equals("Paket 4 Hari 3 Malam C ")){
                        int lunch  = 3 * hargaMakan;
                        int dinner = 0;
                        if(radioButtonDiner.isChecked()) {
                            dinner = 3 * hargaMakan;
                        }

                        int tiketWaterfall = 0;
                        for(int b  = 0 ; b < tiketWisata.size(); b++){
                            String [] tiket = tiketWisata.get(b).split("#");
                            String namaTempat = tiket[0]; int harga = Integer.parseInt(tiket[1]);
                            if(namaTempat.equals("Sendang Gile")){
                                tiketWaterfall = harga;
                            }

                        }

                        // cost untuk boat ke pink
                        int costPink = 0;
                        int penumpang = Integer.parseInt(jumlahPeserta);
                        if(penumpang%10==0){
                            costPink = (penumpang/10) * hargaBoatPink;
                        }
                        else{
                            costPink = ((penumpang/10)+1) * hargaBoatPink;
                        }
                        // ============= untuk menentukan transportasi Paket 4 Hari 3 Malam A
                        String hasil = "";
                        int transport1 =0;
                        int transport2 =0;
                        int transport3 =0;
                        int transport4 =0;

                        for(int a  = 0 ; a < hargaTranportasi.size(); a++){
                            String [] harga = hargaTranportasi.get(a).split("#");
                            String tujuan = harga [0];
                            int std =Integer.parseInt(harga [1]);
                            int shorte =Integer.parseInt(harga [2]);
                            int longe =Integer.parseInt(harga [3]);
                            int hiace13 =Integer.parseInt(harga [4]);
                            int bus25 =Integer.parseInt(harga [5]);
                            int bus29 =Integer.parseInt(harga [6]);
                            int bus31 =Integer.parseInt(harga [7]);
                            int bus49 =Integer.parseInt(harga [8]);
                            int peserta =Integer.parseInt(jumlahPeserta);
                            if(peserta<=5){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =std;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =std;
                                }
                                if(tujuan.equals("WATERFALL")){
                                    transport3 =std;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport4 =std;
                                }

                            }
                            else if(peserta>5 && peserta<=9 ){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =shorte;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =shorte;
                                }
                                if(tujuan.equals("WATERFALL")){
                                    transport3 =shorte;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport4 =shorte;
                                }

                            }
                            else if(peserta >9 && peserta < 13){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =longe;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =longe;
                                }
                                if(tujuan.equals("WATERFALL")){
                                    transport3 =longe;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport4 =longe;
                                }
                            }
                            else if(peserta==13){

                                if(tujuan.equals("APT-CI")){
                                    transport1 =hiace13;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =hiace13;
                                }
                                if(tujuan.equals("WATERFALL")){
                                    transport3 =hiace13;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport4 =hiace13;
                                }
                            }
                            else if(peserta >13 && peserta <=25){

                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus25;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =bus25;
                                }
                                if(tujuan.equals("WATERFALL")){
                                    transport3 =bus25;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport4 =bus25;
                                }

                            }
                            else if(peserta >25 && peserta <=29){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus29;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =bus29;
                                }
                                if(tujuan.equals("WATERFALL")){
                                    transport3 =bus29;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport4 =bus29;
                                }

                            }
                            else if(peserta >29 && peserta <=31){

                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus31;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =bus31;
                                }
                                if(tujuan.equals("WATERFALL")){
                                    transport3 =bus31;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport4 =bus31;
                                }
                            }

                            else if(peserta >31 && peserta <=49){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus49;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =bus49;
                                }
                                if(tujuan.equals("WATERFALL")){
                                    transport3 =bus49;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport4 =bus49;
                                }
                            }
                            else{

                            }
                        }
                        int totalLunch = lunch * totalPeserta;
                        int totalDinner = dinner * totalPeserta;
                        int totalTransport = transport1+transport2+transport3+transport4;
                        int tiketWisata = (totalPeserta * tiketWaterfall);
                        int totalBayar = totalLunch+totalDinner+totalTransport+guide+air+ganci+costPink + (costHotel  * 3)+tiketWisata;
                        int bayarplusmargin =(( margin +100) * totalBayar)/100;
                        int perpaxBayar = bayarplusmargin / totalPeserta;
                        //total.setText("RP."+totalBayar+" + kalau margin"+bayarplusmargin + "dengan margin " +( margin));
                        perpax.setText("RP. "+perpaxBayar+"/orang" + "RP " + bayarplusmargin + "untuk biaya totaln plus margin"+ "RP " + totalBayar+" untuk baiay toal tanpa margin"  );
                        teksLunch.setText("Rp. " + totalLunch + "untuk baiay makan siang");
                        teksDinner.setText("Rp. " + totalDinner+"untuk biaya makan malam");
                        teksTransport.setText("Rp. " + totalTransport+" untk transport 4 hari\n" + transport1+ "unukt hari 1 \n"+ transport2 + "untuk hari 2\n"+transport3+"untuk hari 3" + transport4+ "untuk hari 4" );
                        teksOther.setText("Rp. " + guide +" untuk biaya guide \n" +
                                "RP. " + air+ " untuk biaya air \n" +
                                "Rp. " + ganci+" untuk biaya ganci\n" +
                                "Rp. " + costPink + "untuk biaya boat pantai pink"+
                                "Rp. " + tiketWisata+" untuk biaya tiket wisata waterfall  untuk " + totalPeserta +" peserta"+
                                "Rp. "+ (ekstraBed * ranjangTambahan) + "untuk" + jumlahTambahRanjang+"ekstrabed" );
                        teksHotel.setText("RP. "+ (costHotel * 3 ) +" untuk " + jumlahKamar+" kamar"+" dan " + ranjangTambahan+" ekstrabed selama 3 hari");




                        kirim.setVisibility(View.VISIBLE);
                        detail =  "\n\n\n\nBiaya total tanpa margin = Rp. "+totalBayar + "\n" +
                                "Biaya total dengan margin = Rp. "+bayarplusmargin+" dengan margin "+ margin+"\n" +
                                "Biaya perorang = Rp." +perpaxBayar+"\n" +
                                "Biaya makan siang = Rp."+ totalLunch +" untuk 3 kali makan untuk " +totalPeserta + " orang \n" +
                                "Biaya untuk dinner = Rp."+ totalDinner+" untuk 3 kali makan untuk " + totalPeserta+ " orang \n" +
                                "Biaya Total Transportasi = Rp. " + totalTransport +"  \n" +
                                "          Transportasi hari pertama Chekcin  = Rp. "+ transport1 +"\n" +
                                "          Transportasi hari kedua Pink = Rp. "+ transport2 +"\n" +
                                "          Transportasi hari ketiga Waterfall = Rp.  "+ transport3 +"\n" +
                                "          Transportasi hari ketiga Sasak-CO = Rp. "+ transport4 +"\n" +
                                "Biaya untuk hotel = Rp. " + (costHotel * 3) +" untuk " + jumlahKamar+ " kamar dan  "+ ranjangTambahan+ " Ekstrabed selama 3 hari \n" +
                                "Biaya untuk guide = Rp. " +guide +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk air = Rp. " +air +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk ganci = Rp. " +ganci +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk tiket wisata waterfall  = Rp. " +tiketWisata +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk kapal menuju pink = Rp. " +costPink +" untuk "+ totalPeserta +" orang\n" +
                                ""    ;


                    }







                }
                else if(paketWisatas.contains("Paket 3 Hari 2 Malam")){
                    int air = Integer.parseInt(jumlahPeserta) * 2000 * 3;
                    int guide = 100000 * 3;
                    int ganci = Integer.parseInt(jumlahPeserta) * 5000 ;
                    int slowBoat = 0;
                    if(paketWisatas.equals("Paket 3 Hari 2 Malam A ")){

                        //=========
                        int lunch  = 2 * hargaMakan;
                        int dinner = 0;
                        if(radioButtonDiner.isChecked()){
                            dinner = 2 * hargaMakan;
                        }
                        int costTrawangan = 0;
                        int penumpang = Integer.parseInt(jumlahPeserta);
                        if(penumpang%12==0){
                            costTrawangan = (penumpang/12) * hargaBoatTrawangan;
                        }
                        else{
                            costTrawangan = ((penumpang/12)+1) * hargaBoatTrawangan;
                        }

                        String hasil = "";
                        int transport1 =0;
                        int transport2 =0;
                        int transport3 =0;

                        for(int a  = 0 ; a < hargaTranportasi.size(); a++){
                            String [] harga = hargaTranportasi.get(a).split("#");
                            String tujuan = harga [0];
                            int std =Integer.parseInt(harga [1]);
                            int shorte =Integer.parseInt(harga [2]);
                            int longe =Integer.parseInt(harga [3]);
                            int hiace13 =Integer.parseInt(harga [4]);
                            int bus25 =Integer.parseInt(harga [5]);
                            int bus29 =Integer.parseInt(harga [6]);
                            int bus31 =Integer.parseInt(harga [7]);
                            int bus49 =Integer.parseInt(harga [8]);
                            int peserta =Integer.parseInt(jumlahPeserta);
                            if(peserta<=5){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =std;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport2 =std;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport3 =std;
                                }

                            }
                            else if(peserta>5 && peserta<=9 ){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =shorte;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport2 =shorte;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport3 =shorte;
                                }

                            }
                            else if(peserta > 9 && peserta < 13){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =longe;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport2 =longe;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport3 =longe;
                                }

                            }
                            else if(peserta==13){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =hiace13;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport2 =hiace13;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport3 =hiace13;
                                }

                            }
                            else if(peserta >13 && peserta <=25){

                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus25;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport2 =bus25;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport3 =bus25;
                                }

                            }
                            else if(peserta >25 && peserta <=29){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus29;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport2 =bus29;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport3 =bus29;
                                }

                            }
                            else if(peserta >29 && peserta <=31){

                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus31;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport2 =bus31;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport3 =bus31;
                                }
                            }

                            else if(peserta >31 && peserta <=49){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus49;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport2 =bus49;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport3 =bus49;
                                }
                            }
                            else{

                            }
                        }

                        int totalLunch = lunch * totalPeserta;
                        int totalDinner = dinner * totalPeserta;
                        int totalTransport = transport1+transport2+transport3;
                        int totalBayar = totalLunch+totalDinner+totalTransport+guide+air+ganci+costTrawangan  + (costHotel * 2);
                        int bayarplusmargin =(( margin +100) * totalBayar)/100;
                        int perpaxBayar = bayarplusmargin / totalPeserta;
                        //total.setText("RP."+totalBayar+" + kalau margin"+bayarplusmargin + "dengan margin " +( margin));
                        perpax.setText("RP. "+perpaxBayar+"/orang" + "RP " + bayarplusmargin + "untuk biaya totaln plus margin"+ "RP " + totalBayar+" untuk baiay toal tanpa margin"  );
                        teksLunch.setText("Rp. " + totalLunch + "untuk baiay makan siang");
                        teksDinner.setText("Rp. " + totalDinner+"untuk biaya makan malam");
                        teksTransport.setText("Rp. " + totalTransport+" untk transport 4 hari\n" + transport1+ "unukt hari 1 \n"+ transport2 + "untuk hari 2\n"+transport3+"untuk hari 3" );
                        teksOther.setText("Rp. " + guide +" untuk biaya guide \n" +
                                "RP. " + air+ " untuk biaya air \n" +
                                "Rp. " + ganci+" untuk biaya ganci\n" +
                                "Rp. " + costTrawangan + "untuk biaya boat pantai pink"+
                                "Rp. "+ (ekstraBed * ranjangTambahan) + "untuk" + jumlahTambahRanjang+"ekstrabed" );
                        teksHotel.setText("RP. "+ (costHotel * 2 ) +" untuk " + jumlahKamar+" kamar"+" dan " + ranjangTambahan+" ekstrabed selama 3 hari");


                        kirim.setVisibility(View.VISIBLE);


                        detail =  "\n\n\n\nBiaya total tanpa margin = Rp. "+totalBayar + "\n" +
                                "Biaya total dengan margin = Rp. "+bayarplusmargin+" dengan margin "+ margin+"\n" +
                                "Biaya perorang = Rp." +perpaxBayar+"\n" +
                                "Biaya makan siang = Rp."+ totalLunch +" untuk 2 kali makan untuk " +totalPeserta + " orang \n" +
                                "Biaya untuk dinner = Rp."+ totalDinner+" untuk 2 kali makan untuk " + totalPeserta+ " orang \n" +
                                "Biaya Total Transportasi = Rp. " + totalTransport +"  \n" +
                                "          Transportasi hari pertama Chekcin  = Rp. "+ transport1 +"\n" +
                                "          Transportasi hari kedua Terawangan = Rp. "+ transport2 +"\n" +
                                "          Transportasi hari ketiga Sasak = Rp.  "+ transport3 +"\n" +
                                "Biaya untuk hotel = Rp. " + (costHotel * 2) +" untuk " + jumlahKamar+ " kamar dan  "+ ranjangTambahan+ " Ekstrabed selama 2 hari \n" +
                                "Biaya untuk guide = Rp. " +guide +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk air = Rp. " +air +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk ganci = Rp. " +ganci +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk kapal menuju ke trawangan = Rp. " +costTrawangan +" untuk "+ totalPeserta +" orang\n" +
                                ""    ;


                    }

                    else if(paketWisatas.equals("Paket 3 Hari 2 Malam B ")){
                        int costTrawangan = 0;
                        int penumpang = Integer.parseInt(jumlahPeserta);
                        if(penumpang%12==0){
                            costTrawangan = (penumpang/12) * hargaBoatTrawangan;
                        }
                        else{
                            costTrawangan = ((penumpang/12)+1) * hargaBoatTrawangan;
                        }
                        int lunch  = 2 * hargaMakan;
                        int dinner = 0;
                        if(radioButtonDiner.isChecked()){
                            dinner = 2 * hargaMakan;
                        }
                        //======= menentukan biaya untuk tiket wisata Paket 3 Hari 2 Malam A
                        int narmada = 0 ;
                        int puraLingsar = 0;
                        for(int b  = 0 ; b < tiketWisata.size(); b++){
                            String [] tiket = tiketWisata.get(b).split("#");
                            String namaTempat = tiket[0]; int harga = Integer.parseInt(tiket[1]);
                            if(namaTempat.equals("Narmada")){
                                narmada = harga;
                            }
                            if(namaTempat.equals("Pura Lingsar")){
                                puraLingsar = harga;
                            }
                        }

                        // ============= untuk menentukan transportasi Paket 3 Hari 2 Malam A
                        String hasil = "";
                        int transport1 =0;
                        int transport2 =0;
                        int transport3 =0;

                        for(int a  = 0 ; a < hargaTranportasi.size(); a++){
                            String [] harga = hargaTranportasi.get(a).split("#");
                            String tujuan = harga [0];
                            int std =Integer.parseInt(harga [1]);
                            int shorte =Integer.parseInt(harga [2]);
                            int longe =Integer.parseInt(harga [3]);
                            int hiace13 =Integer.parseInt(harga [4]);
                            int bus25 =Integer.parseInt(harga [5]);
                            int bus29 =Integer.parseInt(harga [6]);
                            int bus31 =Integer.parseInt(harga [7]);
                            int bus49 =Integer.parseInt(harga [8]);
                            int peserta =Integer.parseInt(jumlahPeserta);
                            if(peserta<=5){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =std;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport2 =std;
                                }
                                if(tujuan.equals("CITY-CO")){
                                    transport3 =std;
                                }

                            }
                            else if(peserta>5 && peserta<=9 ){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =shorte;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport2 =shorte;
                                }
                                if(tujuan.equals("CITY-CO")){
                                    transport3 =shorte;
                                }

                            }
                            else if(peserta >9 && peserta < 13){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =longe;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport2 =longe;
                                }
                                if(tujuan.equals("CITY-CO")){
                                    transport3 =longe;
                                }


                            }
                            else if(peserta==13){

                                if(tujuan.equals("APT-CI")){
                                    transport1 =hiace13;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport2 =hiace13;
                                }
                                if(tujuan.equals("CITY-CO")){
                                    transport3 =hiace13;
                                }


                            }
                            else if(peserta >13 && peserta <=25){

                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus25;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport2 =bus25;
                                }
                                if(tujuan.equals("CITY-CO")){
                                    transport3 =bus25;
                                }

                            }
                            else if(peserta >25 && peserta <=29){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus29;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport2 =bus29;
                                }
                                if(tujuan.equals("CITY-CO")){
                                    transport3 =bus29;
                                }

                            }
                            else if(peserta >29 && peserta <=31){

                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus31;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport2 =bus31;
                                }
                                if(tujuan.equals("CITY-CO")){
                                    transport3 =bus31;
                                }
                            }

                            else if(peserta >31 && peserta <=49){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus49;
                                }
                                if(tujuan.equals("TRAWANGAN")){
                                    transport2 =bus49;
                                }
                                if(tujuan.equals("CITY-CO")){
                                    transport3 =bus49;
                                }
                            }
                            else{

                            }
                        }
                        int totalLunch = lunch * totalPeserta;
                        int totalDinner = dinner * totalPeserta;
                        int totalTransport = transport1+transport2+transport3;
                        int totalTempatWisata = (totalPeserta * narmada) + (totalPeserta * puraLingsar);
                        int totalBayar = totalLunch+totalDinner+totalTransport+guide+air+ganci+totalTempatWisata+(costHotel*2) + costTrawangan;

                        int bayarplusmargin =(( margin +100) * totalBayar)/100;
                        int perpaxBayar = bayarplusmargin / totalPeserta;
                        //total.setText("RP."+totalBayar+" + kalau margin"+bayarplusmargin + "dengan margin " +( margin));
                        perpax.setText("RP. "+perpaxBayar+"/orang" + "RP " + bayarplusmargin + "untuk biaya totaln plus margin"+ "RP " + totalBayar+" untuk baiay toal tanpa margin"  );
                        teksLunch.setText("Rp. " + totalLunch + "untuk baiay makan siang");
                        teksDinner.setText("Rp. " + totalDinner+"untuk biaya makan malam");
                        teksTransport.setText("Rp. " + totalTransport+" untk transport 4 hari\n" + transport1+ "unukt hari 1 \n"+ transport2 + "untuk hari 2\n"+transport3+"untuk hari 3" );
                        teksOther.setText("Rp. " + guide +" untuk biaya guide \n" +
                                "RP. " + air+ " untuk biaya air \n" +
                                "Rp. " + ganci+" untuk biaya ganci\n" +
                                "Rp. " + costTrawangan + "untuk biaya boat pantai pin\nk" +
                                "Rp. "+ totalTempatWisata + "untuk biaya tiket narmada dan lingsar"+
                                "Rp. "+ (ekstraBed * ranjangTambahan) + "untuk" + jumlahTambahRanjang+"ekstrabed");
                        teksHotel.setText("RP. "+ (costHotel * 2 ) +" untuk " + jumlahKamar+" kamar"+" dan " + ranjangTambahan+" ekstrabed selama 3 hari");


                        kirim.setVisibility(View.VISIBLE);


                        detail =  "\n\n\n\nBiaya total tanpa margin = Rp. "+totalBayar + "\n" +
                                "Biaya total dengan margin = Rp. "+bayarplusmargin+" dengan margin "+ margin+"\n" +
                                "Biaya perorang = Rp." +perpaxBayar+"\n" +
                                "Biaya makan siang = Rp."+ totalLunch +" untuk 2 kali makan untuk " +totalPeserta + " orang \n" +
                                "Biaya untuk dinner = Rp."+ totalDinner+" untuk 2 kali makan untuk " + totalPeserta+ " orang \n" +
                                "Biaya Total Transportasi = Rp. " + totalTransport +"  \n" +
                                "          Transportasi hari pertama Chekcin  = Rp. "+ transport1 +"\n" +
                                "          Transportasi hari kedua Terawangan = Rp. "+ transport2 +"\n" +
                                "          Transportasi hari ketiga City = Rp.  "+ transport3 +"\n" +
                                "Biaya untuk hotel = Rp. " + (costHotel * 2) +" untuk " + jumlahKamar+ " kamar dan  "+ ranjangTambahan+ " Ekstrabed selama 2 hari \n" +
                                "Biaya untuk guide = Rp. " +guide +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk air = Rp. " +air +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk ganci = Rp. " +ganci +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk tike Wisata narmada dan pura lingsar = Rp. " + totalTempatWisata +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk kapal menuju ke trawangan = Rp. " +costTrawangan +" untuk "+ totalPeserta +" orang\n" +
                                ""    ;

                    }

                    else if(paketWisatas.equals("Paket 3 Hari 2 Malam C ")){
                        //=============== untuk makanan
                        int lunch  = 2 * hargaMakan;
                        int dinner = 0;
                        if(radioButtonDiner.isChecked()){
                            dinner = 2 * hargaMakan;
                        }
                        int tiketWaterfall = 0;
                        for(int b  = 0 ; b < tiketWisata.size(); b++){
                            String [] tiket = tiketWisata.get(b).split("#");
                            String namaTempat = tiket[0]; int harga = Integer.parseInt(tiket[1]);
                            if(namaTempat.equals("Sendang Gile")){
                                tiketWaterfall = harga;
                            }

                        }

                        String hasil = "";
                        int transport1 =0;
                        int transport2 =0;
                        int transport3 =0;

                        for(int a  = 0 ; a < hargaTranportasi.size(); a++){
                            String [] harga = hargaTranportasi.get(a).split("#");
                            String tujuan = harga [0];
                            int std =Integer.parseInt(harga [1]);
                            int shorte =Integer.parseInt(harga [2]);
                            int longe =Integer.parseInt(harga [3]);
                            int hiace13 =Integer.parseInt(harga [4]);
                            int bus25 =Integer.parseInt(harga [5]);
                            int bus29 =Integer.parseInt(harga [6]);
                            int bus31 =Integer.parseInt(harga [7]);
                            int bus49 =Integer.parseInt(harga [8]);
                            int peserta =Integer.parseInt(jumlahPeserta);
                            if(peserta<=5){
                                if(tujuan.equals("APT-SASAK")){
                                    transport1 =std;
                                }
                                if(tujuan.equals("WATERFALL")){
                                    transport2 =std;
                                }
                                if(tujuan.equals("CO")){
                                    transport3 =std;
                                }

                            }
                            else if(peserta>5 && peserta<=9 ){
                                if(tujuan.equals("APT-SASAK")){
                                    transport1 =shorte;
                                }
                                if(tujuan.equals("WATERFALL")){
                                    transport2 =shorte;
                                }
                                if(tujuan.equals("CO")){
                                    transport3 =shorte;
                                }

                            }
                            else if(peserta >9  && peserta < 13){

                                if(tujuan.equals("APT-SASAK")){
                                    transport1 =longe;
                                }
                                if(tujuan.equals("WATERFALL")){
                                    transport2 =longe;
                                }
                                if(tujuan.equals("CO")){
                                    transport3 =longe;
                                }

                            }
                            else if(peserta==13){
                                if(tujuan.equals("APT-SASAK")){
                                    transport1 =hiace13;
                                }
                                if(tujuan.equals("WATERFALL")){
                                    transport2 =hiace13;
                                }
                                if(tujuan.equals("CO")){
                                    transport3 =hiace13;
                                }



                            }
                            else if(peserta >13 && peserta <=25){

                                if(tujuan.equals("APT-SASAK")){
                                    transport1 =bus25;
                                }
                                if(tujuan.equals("WATERFALL")){
                                    transport2 =bus25;
                                }
                                if(tujuan.equals("CO")){
                                    transport3 =bus25;
                                }

                            }
                            else if(peserta >25 && peserta <=29){
                                if(tujuan.equals("APT-SASAK")){
                                    transport1 =bus29;
                                }
                                if(tujuan.equals("WATERFALL")){
                                    transport2 =bus29;
                                }
                                if(tujuan.equals("CO")){
                                    transport3 =bus25;
                                }

                            }
                            else if(peserta >29 && peserta <=31){

                                if(tujuan.equals("APT-SASAK")){
                                    transport1 =bus31;
                                }
                                if(tujuan.equals("WATERFALL")){
                                    transport2 =bus31;
                                }
                                if(tujuan.equals("CO")){
                                    transport3 =bus31;
                                }
                            }

                            else if(peserta >31 && peserta <=49){
                                if(tujuan.equals("APT-SASAK")){
                                    transport1 =bus49;
                                }
                                if(tujuan.equals("WATERFALL")){
                                    transport2 =bus49;
                                }
                                if(tujuan.equals("CO")){
                                    transport3 =bus49;
                                }
                            }
                            else{

                            }
                        }
                        int totalLunch = lunch * totalPeserta;
                        int totalDinner = dinner * totalPeserta;
                        int totalTransport = transport1+transport2+transport3;
                        int tiketWisata = (tiketWaterfall * totalPeserta);
                        int totalBayar = totalLunch+totalDinner+totalTransport+guide+air+ganci+(costHotel *2) + tiketWisata;

                        int bayarplusmargin =(( margin +100) * totalBayar)/100;
                        int perpaxBayar = bayarplusmargin / totalPeserta;
                        //total.setText("RP."+totalBayar+" + kalau margin"+bayarplusmargin + "dengan margin " +( margin));
                        perpax.setText("RP. "+perpaxBayar+"/orang" + "RP " + bayarplusmargin + "untuk biaya totaln plus margin"+ "RP " + totalBayar+" untuk baiay toal tanpa margin"  );
                        teksLunch.setText("Rp. " + totalLunch + "untuk baiay makan siang");
                        teksDinner.setText("Rp. " + totalDinner+"untuk biaya makan malam");
                        teksTransport.setText("Rp. " + totalTransport+" untk transport 4 hari\n" + transport1+ "unukt hari 1 \n"+ transport2 + "untuk hari 2\n"+transport3+"untuk hari 3" );
                        teksOther.setText("Rp. " + guide +" untuk biaya guide \n" +
                                "RP. " + air+ "untk biaya air \n" +
                                "Rp. " + ganci+" untuk biaya ganci\n" +
                                "Rp. " +tiketWisata +" untuk biaya tiket wisata waterfall dengan  " + totalPeserta+ " orang"+
                                "Rp. "+ (ekstraBed * ranjangTambahan) + "untuk" + jumlahTambahRanjang+"ekstrabed" );
                        teksHotel.setText("RP. "+ (costHotel * 2 ) +" untuk " + jumlahKamar+" kamar"+" dan " + ranjangTambahan+" ekstrabed selama 3 hari");



                        kirim.setVisibility(View.VISIBLE);

                        detail =  "\n\n\n\nBiaya total tanpa margin = Rp. "+totalBayar + "\n" +
                                "Biaya total dengan margin = Rp. "+bayarplusmargin+" dengan margin "+ margin+"\n" +
                                "Biaya perorang = Rp." +perpaxBayar+"\n" +
                                "Biaya makan siang = Rp."+ totalLunch +" untuk 2 kali makan untuk " +totalPeserta + " orang \n" +
                                "Biaya untuk dinner = Rp."+ totalDinner+" untuk 2 kali makan untuk " + totalPeserta+ " orang \n" +
                                "Biaya Total Transportasi = Rp. " + totalTransport +"  \n" +
                                "          Transportasi hari pertama Apt - Sasak  = Rp. "+ transport1 +"\n" +
                                "          Transportasi hari kedua Waterfal = Rp. "+ transport2 +"\n" +
                                "          Transportasi hari ketiga Check Out = Rp.  "+ transport3 +"\n" +
                                "Biaya untuk hotel = Rp. " + (costHotel * 2) +" untuk " + jumlahKamar+ " kamar dan  "+ ranjangTambahan+ " Ekstrabed selama 2 hari \n" +
                                "Biaya untuk guide = Rp. " +guide +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk air = Rp. " +air +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk ganci = Rp. " +ganci +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk tiket Wisata Waterfall = Rp. " + tiketWisata +" untuk "+ totalPeserta +" orang\n" +
                                ""    ;

                    }

                    if(paketWisatas.equals("Paket 3 Hari 2 Malam D ")){
                        // =========== untuk makan
                        int lunch  = 2 * hargaMakan;
                        int dinner = 0;
                        if(radioButtonDiner.isChecked()){
                            dinner = 2 * hargaMakan;
                        }
                        // cost untuk boat ke pink
                        int costPink = 0;
                        int penumpang = Integer.parseInt(jumlahPeserta);
                        if(penumpang%10==0){
                            costPink = (penumpang/10) * hargaBoatPink;
                        }
                        else{
                            costPink = ((penumpang/10)+1) * hargaBoatPink;
                        }
                        // ============= untuk menentukan transportasi Paket 3 Hari 2 Malam A
                        String hasil = "";
                        int transport1 =0;
                        int transport2 =0;
                        int transport3 =0;

                        for(int a  = 0 ; a < hargaTranportasi.size(); a++){
                            String [] harga = hargaTranportasi.get(a).split("#");
                            String tujuan = harga [0];
                            int std =Integer.parseInt(harga [1]);
                            int shorte =Integer.parseInt(harga [2]);
                            int longe =Integer.parseInt(harga [3]);
                            int hiace13 =Integer.parseInt(harga [4]);
                            int bus25 =Integer.parseInt(harga [5]);
                            int bus29 =Integer.parseInt(harga [6]);
                            int bus31 =Integer.parseInt(harga [7]);
                            int bus49 =Integer.parseInt(harga [8]);
                            int peserta =Integer.parseInt(jumlahPeserta);
                            if(peserta<=5){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =std;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =std;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport3 =std;
                                }

                            }
                            else if(peserta>5 && peserta<=9 ){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =shorte;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =shorte;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport3 =shorte;
                                }

                            }
                            else if(peserta >9 && peserta < 13){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =longe;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =longe;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport3 =longe;
                                }

                            }
                            else if(peserta==13){

                                if(tujuan.equals("APT-CI")){
                                    transport1 =hiace13;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =hiace13;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport3 =hiace13;
                                }
                            }
                            else if(peserta >13 && peserta <=25){

                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus25;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =bus25;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport3 =shorte;
                                }

                            }
                            else if(peserta >25 && peserta <=29){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus29;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =bus29;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport3 =bus29;
                                }

                            }
                            else if(peserta >29 && peserta <=31){

                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus31;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =bus31;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport3 =bus31;
                                }
                            }

                            else if(peserta >31 && peserta <=49){
                                if(tujuan.equals("APT-CI")){
                                    transport1 =bus49;
                                }
                                if(tujuan.equals("PINK")){
                                    transport2 =bus49;
                                }
                                if(tujuan.equals("SASAK-CO")){
                                    transport3 =bus49;
                                }
                            }
                            else{

                            }
                        }

                        int totalLunch = lunch * totalPeserta;
                        int totalDinner = dinner * totalPeserta;
                        int totalTransport = transport1+transport2+transport3;
                        int totalBayar = totalLunch+totalDinner+totalTransport+guide+air+ganci+(costHotel * 2)+costPink;

                        int bayarplusmargin =(( margin +100) * totalBayar)/100;
                        int perpaxBayar = bayarplusmargin / totalPeserta;
                        //total.setText("RP."+totalBayar+" + kalau margin"+bayarplusmargin + "dengan margin " +( margin));
                        perpax.setText("RP. "+perpaxBayar+"/orang" + "RP " + bayarplusmargin + "untuk biaya totaln plus margin"+ "RP " + totalBayar+" untuk baiay toal tanpa margin"  );
                        teksLunch.setText("Rp. " + totalLunch + "untuk baiay makan siang");
                        teksDinner.setText("Rp. " + totalDinner+"untuk biaya makan malam");
                        teksTransport.setText("Rp. " + totalTransport+" untk transport 4 hari\n" + transport1+ "unukt hari 1 \n"+ transport2 + "untuk hari 2\n"+transport3+"untuk hari 3" );
                        teksOther.setText("Rp. " + guide +" untuk biaya guide \n" +
                                "RP. " + air+ " untuk biaya air \n" +
                                "Rp. " + ganci+" untuk biaya ganci\n" +
                                "Rp. " + costPink + "untuk biaya boat ke pantai  pink"+
                                "Rp. "+ (ekstraBed * ranjangTambahan) + "untuk" + jumlahTambahRanjang+"ekstrabed" );
                        teksHotel.setText("RP. "+ (costHotel * 2 ) +" untuk " + jumlahKamar+" kamar"+" dan " + ranjangTambahan+" ekstrabed selama 3 hari");





                        kirim.setVisibility(View.VISIBLE);

                        detail =  "\n\n\n\nBiaya total tanpa margin = Rp. "+totalBayar + "\n" +
                                "Biaya total dengan margin = Rp. "+bayarplusmargin+" dengan margin "+ margin+"\n" +
                                "Biaya perorang = Rp." +perpaxBayar+"\n" +
                                "Biaya makan siang = Rp."+ totalLunch +" untuk 2 kali makan untuk " +totalPeserta + " orang \n" +
                                "Biaya untuk dinner = Rp."+ totalDinner+" untuk 2 kali makan untuk " + totalPeserta+ " orang \n" +
                                "Biaya Total Transportasi = Rp. " + totalTransport +"  \n" +
                                "          Transportasi hari pertama Chekcin  = Rp. "+ transport1 +"\n" +
                                "          Transportasi hari kedua Pink = Rp. "+ transport2 +"\n" +
                                "          Transportasi hari ketiga Sasak - CO = Rp.  "+ transport3 +"\n" +
                                "Biaya untuk hotel = Rp. " + (costHotel * 2) +" untuk " + jumlahKamar+ " kamar dan  "+ ranjangTambahan+ " Ekstrabed selama 2 hari \n" +
                                "Biaya untuk guide = Rp. " +guide +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk air = Rp. " +air +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk ganci = Rp. " +ganci +" untuk "+ totalPeserta +" orang\n" +
                                "Biaya untuk kapal menuju pink = Rp. " +costPink +" untuk "+ totalPeserta +" orang\n" +

                                ""    ;
                    }


                   //======= batas untuk 2 hari 2 malem








            }
            else if (paketWisatas.contains("Paket 2 Hari 1 Malam")){
                    int air = Integer.parseInt(jumlahPeserta) * 2000 * 2;
                    int guide = 100000 * 2;
                    int ganci = Integer.parseInt(jumlahPeserta) * 5000 ;
                    int slowBoat = 0;
                if(paketWisatas.equals("Paket 2 Hari 1 Malam A ")){

                    int costTrawangan = 0;
                    int penumpang = Integer.parseInt(jumlahPeserta);
                    if(penumpang%12==0){
                        costTrawangan = (penumpang/12) * hargaBoatTrawangan;
                    }
                    else{
                        costTrawangan = ((penumpang/12)+1) * hargaBoatTrawangan;
                    }
                    // ==     ===================== untuk makan
                    int lunch  = 2 * hargaMakan;
                    int dinner = 0;
                    if(radioButtonDiner.isChecked()){
                        dinner = 1 * hargaMakan;
                    }
                    //======= menentukan biaya untuk tiket wisata Paket 2 Hari 1 Malam A
                    int narmada = 0 ;
                    int puraLingsar = 0;
                    for(int b  = 0 ; b < tiketWisata.size(); b++){
                        String [] tiket = tiketWisata.get(b).split("#");
                        String namaTempat = tiket[0]; int harga = Integer.parseInt(tiket[1]);
                        if(namaTempat.equals("Narmada")){
                            narmada = harga;
                        }
                        if(namaTempat.equals("Pura Lingsar")){
                            puraLingsar = harga;
                        }
                    }
                    // ============= untuk menentukan transportasi Paket 2 Hari 1 Malam A
                    String hasil = "";
                    int transport1 =0;
                    int transport2 =0;
                    for(int a  = 0 ; a < hargaTranportasi.size(); a++){
                        String [] harga = hargaTranportasi.get(a).split("#");
                        String tujuan = harga [0];
                        int std =Integer.parseInt(harga [1]);
                        int shorte =Integer.parseInt(harga [2]);
                        int longe =Integer.parseInt(harga [3]);
                        int hiace13 =Integer.parseInt(harga [4]);
                        int bus25 =Integer.parseInt(harga [5]);
                        int bus29 =Integer.parseInt(harga [6]);
                        int bus31 =Integer.parseInt(harga [7]);
                        int bus49 =Integer.parseInt(harga [8]);
                        int peserta =Integer.parseInt(jumlahPeserta);
                        if(peserta<=5){
                            if(tujuan.equals("APT-CITY")){
                                transport1 =std;
                            }
                            if(tujuan.equals("TRAWANGAN-CO")){
                                transport2 =std;
                            }

                        }
                        else if(peserta>5 && peserta<=9 ){
                            if(tujuan.equals("APT-CITY")){
                                transport1 =shorte;
                            }
                            if(tujuan.equals("TRAWANGAN-CO")){
                                transport2 =shorte;
                            }

                        }
                        else if(peserta >9 && peserta < 13){

                            if(tujuan.equals("APT-CITY")){
                                transport1 =longe;
                            }
                            if(tujuan.equals("TRAWANGAN-CO")){
                                transport2 =longe;
                            }

                        }
                        else if(peserta==13){

                            if(tujuan.equals("APT-CITY")){
                                transport1 =hiace13;
                            }
                            if(tujuan.equals("TRAWANGAN-CO")){
                                transport2 =hiace13;
                            }


                        }
                        else if(peserta >13 && peserta <=25){

                            if(tujuan.equals("APT-CITY")){
                                transport1 =bus25;
                            }
                            if(tujuan.equals("TRAWANGAN-CO")){
                                transport2 =bus25;
                            }

                        }
                        else if(peserta >25 && peserta <=29){
                            if(tujuan.equals("APT-CITY")){
                                transport1 =bus29;
                            }
                            if(tujuan.equals("TRAWANGAN-CO")){
                                transport2 =bus29;
                            }

                        }
                        else if(peserta >29 && peserta <=31){

                            if(tujuan.equals("APT-CITY")){
                                transport1 =bus31;
                            }
                            if(tujuan.equals("TRAWANGAN-CO")){
                                transport2 =bus31;
                            }
                        }

                        else if(peserta >31 && peserta <=49){
                            if(tujuan.equals("APT-CITY")){
                                transport1 =bus49;
                            }
                            if(tujuan.equals("TRAWANGAN-CO")){
                                transport2 =bus49;
                            }
                        }
                        else{

                        }
                    }
                    int totalLunch = lunch * totalPeserta;
                    int totalDinner = dinner * totalPeserta;
                    int totalTransport = transport1+transport2;
                    int totalTempatWisata = (totalPeserta * narmada) + (totalPeserta * puraLingsar);
                    int totalBayar = totalLunch+totalDinner+totalTransport+guide+air+ganci + totalTempatWisata+(costHotel)+ costTrawangan;
                    int bayarplusmargin =(( margin +100) * totalBayar)/100;
                    int perpaxBayar = bayarplusmargin / totalPeserta;

                    //total.setText("RP."+totalBayar+" + kalau margin"+bayarplusmargin + "dengan margin " +( margin));
                    perpax.setText("RP. "+perpaxBayar+"/orang" + "RP " + bayarplusmargin + "untuk biaya totaln plus margin"+ "RP " + totalBayar+" untuk baiay toal tanpa margin"  );
                    teksLunch.setText("Rp. " + totalLunch + "untuk baiay makan siang");
                    teksDinner.setText("Rp. " + totalDinner+"untuk biaya makan malam");
                    teksTransport.setText("Rp. " + totalTransport+" untk transport 4 hari\n" + transport1+ "unukt hari 1 \n"+ transport2 + "untuk hari 2" );
                    teksOther.setText("Rp. " + guide +" untuk biaya guide \n" +
                            "RP. " + air+ " untuk biaya air \n" +
                            "Rp. " + ganci+" untuk biaya ganci\n" +
                            "Rp. " + costTrawangan + "untuk biaya  boat ke trawangan\n" +
                            "Rp. "+ totalTempatWisata+"untuk biaya  tiket tempat wisata"+
                            "Rp. "+ (ekstraBed * ranjangTambahan) + "untuk" + jumlahTambahRanjang+"ekstrabed" );
                    teksHotel.setText("RP. "+ (costHotel * 1 ) +" untuk " + jumlahKamar+" kamar"+" dan " + ranjangTambahan+" ekstrabed selama 1 hari");





                    kirim.setVisibility(View.VISIBLE);

                    detail =  "\n\n\n\nBiaya total tanpa margin = Rp. "+totalBayar + "\n" +
                            "Biaya total dengan margin = Rp. "+bayarplusmargin+" dengan margin "+ margin+"\n" +
                            "Biaya perorang = Rp." +perpaxBayar+"\n" +
                            "Biaya makan siang = Rp."+ totalLunch +" untuk 2 kali makan untuk " +totalPeserta + " orang \n" +
                            "Biaya untuk dinner = Rp."+ totalDinner+" untuk 1 kali makan untuk " + totalPeserta+ " orang \n" +
                            "Biaya Total Transportasi = Rp. " + totalTransport +"  \n" +
                            "          Transportasi hari pertama Airpot - CIty  = Rp. "+ transport1 +"\n" +
                            "          Transportasi hari kedua Terawangan - CO = Rp. "+ transport2 +"\n" +
                            "Biaya untuk hotel = Rp. " + (costHotel) +" untuk " + jumlahKamar+ " kamar dan  "+ ranjangTambahan+ " Ekstrabed selama 1 hari \n" +
                            "Biaya untuk guide = Rp. " +guide +" untuk "+ totalPeserta +" orang\n" +
                            "Biaya untuk air = Rp. " +air +" untuk "+ totalPeserta +" orang\n" +
                            "Biaya untuk ganci = Rp. " +ganci +" untuk "+ totalPeserta +" orang\n" +
                            "Biaya untuk kapal menuju ke trawangan = Rp. " +costTrawangan +" untuk "+ totalPeserta +" orang\n" +
                            "Biaya untuk tike Wisata narmada dan pura lingsar = Rp. " + totalTempatWisata +" untuk "+ totalPeserta +" orang\n" +
                            ""    ;

                }
                else{
                    int lunch  = 2 * hargaMakan;
                    int dinner = 0;
                    if(radioButtonDiner.isChecked()){
                        dinner = 1 * hargaMakan;
                    }
                    //=========== menentukan biaya untuk makan siang dan malam Paket 2 Hari 1 Malam B
                    int narmada = 0 ;
                    int puraLingsar = 0;
                    for(int b  = 0 ; b < tiketWisata.size(); b++){
                        String [] tiket = tiketWisata.get(b).split("#");
                        String namaTempat = tiket[0]; int harga = Integer.parseInt(tiket[1]);
                        if(namaTempat.equals("Narmada")){
                            narmada = harga;
                        }
                        if(namaTempat.equals("Pura Lingsar")){
                            puraLingsar = harga;
                        }
                    }
                    //=========== menentukan biaya untuk makan siang dan malam Paket 2 Hari 1 Malam B
                    String hasil = "";
                    int transport1 =0;
                    int transport2 =0;
                    for(int a  = 0 ; a < hargaTranportasi.size(); a++){
                        String [] harga = hargaTranportasi.get(a).split("#");
                        String tujuan = harga [0];
                        int std =Integer.parseInt(harga [1]);
                        int shorte =Integer.parseInt(harga [2]);
                        int longe =Integer.parseInt(harga [3]);
                        int hiace13 =Integer.parseInt(harga [4]);
                        int bus25 =Integer.parseInt(harga [5]);
                        int bus29 =Integer.parseInt(harga [6]);
                        int bus31 =Integer.parseInt(harga [7]);
                        int bus49 =Integer.parseInt(harga [8]);
                        int peserta =Integer.parseInt(jumlahPeserta);
                        if(peserta<=5){
                            if(tujuan.equals("APT-CITY")){
                                transport1 =std;
                            }
                            if(tujuan.equals("SASAK-CO")){
                                transport2 =std;
                            }

                        }
                        else if(peserta>5 && peserta<=9 ){
                            if(tujuan.equals("APT-CITY")){
                                transport1 =shorte;
                            }
                            if(tujuan.equals("SASAK-CO")){
                                transport2 =shorte;
                            }

                        }
                        else if(peserta > 9 && peserta < 13){
                            if(tujuan.equals("APT-CITY")){
                                transport1 =longe;
                            }
                            if(tujuan.equals("SASAK-CO")){
                                transport2 =longe;
                            }

                        }
                        else if(peserta==13){
                            if(tujuan.equals("APT-CITY")){
                                transport1 =hiace13;
                            }
                            if(tujuan.equals("SASAK-CO")){
                                transport2 =hiace13;
                            }

                        }
                        else if(peserta >13 && peserta <=25){

                            if(tujuan.equals("APT-CITY")){
                                transport1 =bus25;
                            }
                            if(tujuan.equals("SASAK-CO")){
                                transport2 =bus25;
                            }

                        }
                        else if(peserta >25 && peserta <=29){
                            if(tujuan.equals("APT-CITY")){
                                transport1 =bus29;
                            }
                            if(tujuan.equals("SASAK-CO")){
                                transport2 =bus29;
                            }

                        }
                        else if(peserta >29 && peserta <=31){

                            if(tujuan.equals("APT-CITY")){
                                transport1 =bus31;
                            }
                            if(tujuan.equals("SASAK-CO")){
                                transport2 =bus31;
                            }
                        }

                        else if(peserta >31 && peserta <=49){
                            if(tujuan.equals("APT-CITY")){
                                transport1 =bus49;
                            }
                            if(tujuan.equals("SASAK-CO")){
                                transport2 =bus49;
                            }
                        }
                        else{

                        }
                    }
                    int totalLunch = lunch * totalPeserta;
                    int totalDinner = dinner * totalPeserta;
                    int totalTransport = transport1+transport2;
                    int totalTempatWisata = (totalPeserta * narmada) + (totalPeserta * puraLingsar);
                    int totalBayar = totalLunch+totalDinner+totalTransport+guide+air+ganci+costHotel+totalTempatWisata;

                    int bayarplusmargin =(( margin +100) * totalBayar)/100;
                    int perpaxBayar = bayarplusmargin / totalPeserta;

                    //total.setText("RP."+totalBayar+" + kalau margin"+bayarplusmargin + "dengan margin " +( margin));
                    perpax.setText("RP. "+perpaxBayar+"/orang" + "RP " + bayarplusmargin + "untuk biaya totaln plus margin"+ "RP " + totalBayar+" untuk baiay toal tanpa margin"  );
                    teksLunch.setText("Rp. " + totalLunch + "untuk baiay makan siang");
                    teksDinner.setText("Rp. " + totalDinner+"untuk biaya makan malam");
                    teksTransport.setText("Rp. " + totalTransport+" untk transport 4 hari\n" + transport1+ "unukt hari 1 \n"+ transport2 + "untuk hari 2" );
                    teksOther.setText("Rp. " + guide +" untuk biaya guide \n" +
                            "RP. " + air+ " untuk biaya air \n" +
                            "Rp. " + ganci+" untuk biaya ganci\n" +
                            "Rp. " + totalTempatWisata + "untuk biaya  tiket tempat wisata"+
                            "Rp. "+ (ekstraBed * ranjangTambahan) + "untuk" + jumlahTambahRanjang+"ekstrabed" );
                    teksHotel.setText("RP. "+ (costHotel * 1 ) +" untuk " + jumlahKamar+" kamar"+" dan " + ranjangTambahan+" ekstrabed selama 1 hari");




                    kirim.setVisibility(View.VISIBLE);

                    detail =  "\n\n\n\nBiaya total tanpa margin = Rp. "+totalBayar + "\n" +
                            "Biaya total dengan margin = Rp. "+bayarplusmargin+" dengan margin "+ margin+"\n" +
                            "Biaya perorang = Rp." +perpaxBayar+"\n" +
                            "Biaya makan siang = Rp."+ totalLunch +" untuk 2 kali makan untuk " +totalPeserta + " orang \n" +
                            "Biaya untuk dinner = Rp."+ totalDinner+" untuk 1 kali makan untuk " + totalPeserta+ " orang \n" +
                            "Biaya Total Transportasi = Rp. " + totalTransport +"  \n" +
                            "          Transportasi hari pertama Airport - City  = Rp. "+ transport1 +"\n" +
                            "          Transportasi hari kedua Sasak - CO = Rp. "+ transport2 +"\n" +
                            "Biaya untuk hotel = Rp. " + (costHotel) +" untuk " + jumlahKamar+ " kamar dan  "+ ranjangTambahan+ " Ekstrabed selama 1 hari \n" +
                            "Biaya untuk guide = Rp. " +guide +" untuk "+ totalPeserta +" orang\n" +
                            "Biaya untuk air = Rp. " +air +" untuk "+ totalPeserta +" orang\n" +
                            "Biaya untuk ganci = Rp. " +ganci +" untuk "+ totalPeserta +" orang\n" +
                            "Biaya untuk tike Wisata narmada dan pura lingsar = Rp. " + totalTempatWisata +" untuk "+ totalPeserta +" orang\n" +
                            ""    ;
                }

            }
            else{

            }


        }
        else{

        }

    }

    public void erorNama(){

    }
    public void erorEmail(){

    }
    public void erorNoHp(){

    }
    public void erorTambahRanjang(){

    }

    public void openDialog(){
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);


        String nama = namaWisatawan.getText().toString();
        String email = emailWisatawan.getText().toString();
        String noHp = noHPWisatawan.getText().toString();
        String namaHotel =  kelasHotel.getSelectedItem().toString();
        String paketWisatas = paketWisata.getSelectedItem().toString();
        String Tanggal = tanggal.getText().toString();
        String jumlahPeserta  = peserta.getText().toString();
        String Diner = "";
        if(radioButtonDiner.isChecked()){
            Diner = "ya";
        }
        else{
            Diner = "tidak";
        }



        alertDialogBuilder.setTitle("Konfirmasi");
        alertDialogBuilder.setMessage
        (       "Nama : "+ nama+" \n" +
                "Email : "+ email+" \n" +
                "No Hp : "+ noHp+" \n" +
                "Nama Hotel : "+ namaHotel+" \n" +
                "Paket Wisata : "+ paketWisatas+" \n" +
                "Tanggal : "+ Tanggal+" \n" +
                "Jumlah peserta : "+ jumlahPeserta+" \n" +
                "Diner : "+ Diner+" \n\n\n\n" +

         "Kirim pemesanan");

                alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        new Send(aktivitas).execute();
              //          Toast.makeText(aktivitas, "You clicked yes button", Toast.LENGTH_LONG).show();
                    }
                });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {



            }
        });

        AlertDialog  alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
    public void kirim(){

    }


}
