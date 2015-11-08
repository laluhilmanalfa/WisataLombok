package com.example.hilman.wisatalombok;

/**
 * Created by HILMAN on 6/24/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class DatabaseHelper extends SQLiteOpenHelper {


    // Database name in phone
    private String FILENAME = "WisataLombok.db";

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, "FILENAME", null, 1);
    }


    // membuat tabel tabel sql lite
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "";
        query = "CREATE TABLE `TempatWisata` (`Nama` TEXT, `Tiket` INTEGER);";
        db.execSQL(query);
        query = "CREATE TABLE `Hotel` (`KodeHotel` TEXT, `Nama` TEXT);";
        db.execSQL(query);
        query = "CREATE TABLE `KelasHotel` (`KodeHotel` TEXT, `KelasHotel` TEXT, `Bintang` INTEGER, `Low` INTEGER , `High` INTEGER , `Peak` INTEGER , `Extralow` INTEGER , `Extrahigh` INTEGER , `Extrapeak` INTEGER);";
        db.execSQL(query);
        query = "CREATE TABLE `Margin` (`BesarMargin` INTEGER);";
        db.execSQL(query);
        query = "CREATE TABLE `InfoUpdateServers` (`TempatWisata` TEXT,`Hotel` TEXT,`KelasHotel` TEXT,`Margin` TEXT,`Artikel` TEXT ,`Galery` TEXT ,`HargaTransportasi` TEXT);";
        db.execSQL(query);
        query = "CREATE TABLE `InfoUpdateSQLlite` (`TempatWisata` TEXT,`Hotel` TEXT,`KelasHotel` TEXT,`Margin` TEXT,`Artikel` TEXT ,`Galery` TEXT ,`HargaTransportasi` TEXT);";
        db.execSQL(query);
        query = "CREATE TABLE `Artikel` (`judul` TEXT, `linkGambar` TEXT, `linkArtikel` TEXT, `sinopsis` TEXT);";
        db.execSQL(query);
        query = "CREATE TABLE `Galery` (`paket` TEXT, `linkGambar` TEXT);";
        db.execSQL(query);
        //INSERT INTO `HargaTransportasi`(`Jurusan`, `STD`, `SHORTE`, `LONGE`, `HIACE13`, `BUS25`, `BUS29`, `BUS31`, `BUS49`) VALUES
        query = "CREATE TABLE `HargaTransportasi` (`Jurusan` TEXT, `STD` INTEGER, `SHORTE` INTEGER, `LONGE` INTEGER, `HIACE13` INTEGER, `BUS25` INTEGER, `BUS29` INTEGER, `BUS31` INTEGER, `BUS49` INTEGER);";
        db.execSQL(query);



    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {


    }


    //(`TempatWisata` TEXT,`Hotel` TEXT,`KelasHotel` TEXT,`Margin` TEXT,`Artikel` TEXT ,`Galery` TEXT ,`HargaTransportasi` TEXT);";
    public ArrayList<String> getAllInfoUpdateServers() {
        ArrayList<String> hasil = new ArrayList<String>();
        String fetchdata = "select * from InfoUpdateServers";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(fetchdata, null);
        if (cursor.moveToFirst()) {
            do {
                hasil.add(cursor.getString(0));
                hasil.add(cursor.getString(1));
                hasil.add(cursor.getString(2));
                hasil.add(cursor.getString(3));
                hasil.add(cursor.getString(4));
                hasil.add(cursor.getString(5));
                hasil.add(cursor.getString(6));
            } while (cursor.moveToNext());
        }
        return hasil;
    }

    public ArrayList<String> getAllInfoUpdateSQLlite() {
        ArrayList<String> hasil = new ArrayList<String>();
        String fetchdata = "select * from InfoUpdateSQLlite";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(fetchdata, null);
        if (cursor.moveToFirst()) {
            do {
                hasil.add(cursor.getString(0));
                hasil.add(cursor.getString(1));
                hasil.add(cursor.getString(2));
                hasil.add(cursor.getString(3));
                hasil.add(cursor.getString(4));
                hasil.add(cursor.getString(5));
                hasil.add(cursor.getString(6));
            } while (cursor.moveToNext());
        }
        return hasil;
    }


    //   query = "CREATE TABLE `Galery` (`paket` TEXT, `linkGambar` TEXT);";



    public ArrayList<String> getAllGalery() {
        ArrayList<String> result = new ArrayList<String>();
        String query = "SELECT * from Galery;";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                result.add(cursor.getString(0)+"##"+cursor.getString(1));
            } while (cursor.moveToNext());
        }
        return result;
    }



    public ArrayList<String> getAllHotel() {
        ArrayList<String> result = new ArrayList<String>();
        String query = "SELECT * from Hotel;";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                result.add(cursor.getString(0)+"#"+cursor.getString(1));
            } while (cursor.moveToNext());
        }
        return result;
    }


    //query = "CREATE TABLE `Artikel` (`judul` TEXT, `linkGambar` TEXT, `linkArtikel` TEXT, `sinopsis` TEXT);";
    public ArrayList<String> getAllArtikel() {
        ArrayList<String> result = new ArrayList<String>();
        String query = "SELECT * from Artikel;";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                result.add(cursor.getString(0)+"##"+cursor.getString(1)+"##"+cursor.getString(2)+"##"+cursor.getString(3));
            } while (cursor.moveToNext());
        }
        return result;
    }


    public ArrayList<String> getAllRestoran() {
        ArrayList<String> result = new ArrayList<String>();
        String query = "SELECT * from Restoran;";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                result.add(cursor.getString(0)+"#"+cursor.getInt(1));
            } while (cursor.moveToNext());
        }
        return result;
    }


    public ArrayList<String> getAllTempatWisata() {
        ArrayList<String> result = new ArrayList<String>();
        String query = "SELECT * from TempatWisata;";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                result.add(cursor.getString(0)+"#"+cursor.getInt(1));
            } while (cursor.moveToNext());
        }
        return result;
    }

    public ArrayList<String> getAllKelasHotel() {
        ArrayList<String> result = new ArrayList<String>();
        String query = "SELECT * from KelasHotel;";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
       //      (`KodeHotel` TEXT, `KelasHotel` TEXT, `Bintang` INTEGER, `Low` INTEGER , `High` INTEGER , `Peak` INTEGER , `Extralow` INTEGER , `Extrahigh` INTEGER , `Extrapeak` INTEGER);";
                result.add(cursor.getString(0)+"#"+cursor.getString(1) + "#"+ cursor.getInt(2)+ "#"+ cursor.getInt(3)+ "#"+ cursor.getInt(4)+ "#"+ cursor.getInt(5)+"#"+ cursor.getInt(6) +"#"+ cursor.getInt(7) +"#"+ cursor.getInt(8));
            } while (cursor.moveToNext());
        }
        return result;
    }

    // untuk kelas hotel yang baru
    public ArrayList<String> getAllKelasHotelnew() {
        ArrayList<String> result = new ArrayList<String>();
        String query = "SELECT * from KelasHotel;";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                // query = "CREATE TABLE `KelasHotel` (`KodeHotel` TEXT, `KelasHotel` TEXT, `Bintang` INTEGER, `Low` INTEGER , `High` INTEGER , `Peak` INTEGER , `Extralow` INTEGER);";
                result.add(cursor.getString(0)+"#"+cursor.getString(1) + "#"+ cursor.getInt(2)+ "#"+ cursor.getInt(3)+ "#"+ cursor.getInt(4)+ "#"+ cursor.getInt(5)+ "#"+ cursor.getInt(6) + "#"+ cursor.getInt(7)+ "#"+ cursor.getInt(8));
            } while (cursor.moveToNext());
        }
        return result;
    }



    public ArrayList<String> getAllHargaTransportasi() {
        ArrayList<String> result = new ArrayList<String>();
        String query = "SELECT * from HargaTransportasi;";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);


        if (cursor.moveToFirst()) {
            do {
                result.add(cursor.getString(0)+"#"+cursor.getString(1) + "#"+ cursor.getInt(2)+ "#"+ cursor.getInt(3)+ "#"+ cursor.getInt(4)+ "#"+ cursor.getInt(5)+ "#"+ cursor.getInt(6)+ "#"+ cursor.getInt(7)+ "#"+ cursor.getInt(8));
            } while (cursor.moveToNext());
        }
        return result;
    }


    public ArrayList<String> getAllMargin() {
        ArrayList<String> result = new ArrayList<String>();
        String query = "SELECT * from Margin;";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                result.add(cursor.getInt(0)+"");
            } while (cursor.moveToNext());
        }
        return result;
    }




    //(`TempatWisata` TEXT,`Hotel` TEXT,`KelasHotel` TEXT,`Margin` TEXT,`Artikel` TEXT ,`Galery` TEXT ,`HargaTransportasi` TEXT);";
    public void insertInfoUpdateServer( String TempatWisata,String Hotel ,String KelasHotel ,String Margin ,String Artikel, String Galery,String HargaTransportasi, boolean isUpdateServer) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TempatWisata", TempatWisata);
        values.put("Hotel", Hotel);
        values.put("KelasHotel", KelasHotel);
        values.put("Margin", Margin);
        values.put("Artikel", Artikel);
        values.put("Galery", Galery);
        values.put("HargaTransportasi", HargaTransportasi);
        if(isUpdateServer) {

            sqLiteDatabase.insert("InfoUpdateServers", null, values);
        }
        else{
            sqLiteDatabase.insert("InfoUpdateSQLlite", null, values);
        }
    }

    public void insertHotel ( String kodeHotel, String namaHotel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("KodeHotel", kodeHotel);
        values.put("Nama", namaHotel);

        sqLiteDatabase.insert("Hotel", null, values);
    }

    public void insertTempatWisata ( String namaTempatWisata, int tiket) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Nama", namaTempatWisata);
        values.put("Tiket", tiket);

        sqLiteDatabase.insert("TempatWisata", null, values);
    }




//query = "CREATE TABLE `Artikel` (`judul` TEXT, `linkGambar` TEXT, `linkArtikel` TEXT, `sinopsis` TEXT);";
    public void insertArtikel ( String judul, String linkGambar, String linkArtikel, String sinopsis) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("judul", judul);
        values.put("linkGambar", linkGambar);
        values.put("linkArtikel", linkArtikel);
        values.put("sinopsis", sinopsis);

        sqLiteDatabase.insert("Artikel", null, values);
    }



    public void insertTransportasi ( String kendaraan, int harga) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Nama", kendaraan);
        values.put("Harga", harga);
        sqLiteDatabase.insert("Transportasi", null, values);
    }

 //   query = "CREATE TABLE `Galery` (`paket` TEXT, `linkGambar` TEXT);";
    public void insertGalery ( String paket, String linkGambar ) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("paket", paket);
        values.put("linkGambar", linkGambar);

        sqLiteDatabase.insert("Galery", null, values);
    }


    //(`KodeHotel` TEXT, `KelasHotel` TEXT, `Bintang` INTEGER, `Low` INTEGER , `High` INTEGER , `Peak` INTEGER , `Extrabed` INTEGER);";
    public void insertKelasHotel ( String kodeHotel, String kelasHotel, int bintang, int low, int high, int peak, int extralow, int extrahigh, int extrapeak) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("KodeHotel", kodeHotel);
        values.put("KelasHotel", kelasHotel);
        values.put("Bintang", bintang);
        values.put("Low", low);
        values.put("High", high);
        values.put("Peak", peak);
        values.put("Extralow", extralow);
        values.put("Extrahigh", extrahigh);
        values.put("Extrapeak", extrapeak);
        sqLiteDatabase.insert("KelasHotel", null, values);
    }


    // untuk kelas hotel yang baru
    public void insertNewKelasHotel ( String kodeHotel, String kelasHotel, int bintang, int low, int high, int peak, int extralow, int extrahigh, int extrapeak) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("KodeHotel", kodeHotel);
        values.put("KelasHotel", kelasHotel);
        values.put("Bintang", bintang);
        values.put("Low", low);
        values.put("High", high);
        values.put("Peak", peak);
        values.put("Extralow", extralow);
        values.put("Extrahigh", extrahigh);
        values.put("Extrapeak", extrapeak);
        sqLiteDatabase.insert("KelasHotel", null, values);
    }

    public void insertmargin(int margin){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("BesarMargin", margin);
        sqLiteDatabase.insert("Margin", null, value);
    }


//    query = "CREATE TABLE `HargaTransportasi` (`Jurusan` TEXT, `STD` INTEGER, `SHORTE` INTEGER, `LONGE` INTEGER, `HIACE13` INTEGER, `BUS25` INTEGER, `BUS29` INTEGER, `BUS31` INTEGER, `BUS49` INTEGER);";
    public void insertHargaTransportasi(String jurusan, int std, int shorte, int longe, int hiace13, int bus25, int bus29,int bus31, int bus49){
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues value = new ContentValues();
            value.put("Jurusan", jurusan);
            value.put("STD", std);
            value.put("SHORTE", shorte);
            value.put("LONGE", longe);
            value.put("HIACE13", hiace13);
            value.put("BUS25", bus25);
            value.put("BUS29", bus29);
            value.put("BUS31", bus31);
            value.put("BUS49", bus49);

            sqLiteDatabase.insert("HargaTransportasi", null, value);
    }


    public void deleterecord(String namatabel)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("delete from "+ namatabel);
    }


}