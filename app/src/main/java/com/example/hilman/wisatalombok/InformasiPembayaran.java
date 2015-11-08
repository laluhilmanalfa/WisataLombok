package com.example.hilman.wisatalombok;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class InformasiPembayaran extends ActionBarActivity {

   /* @Override
    public void onBackPressed() {
        Intent intent = new Intent(InformasiPembayaran.this, HOME.class);
        startActivity(intent);
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi_pembayaran);

        TextView sampai3 = (TextView) findViewById(R.id.sampai3);
        TextView norek = (TextView) findViewById(R.id.norek);
        TextView sampaiselesai = (TextView) findViewById(R.id.sampaiselesai);

        sampai3.setText("1. Setelah melakukan reservasi, pastikan anda menerima konfirmasi dari kami karena didalam konfirmasi tersebut tertera informasi batas waktu pembayaran (tanggal jatuh tempo) dan detail pembayaran anda.\n" +
                "2. Lakukan pembayaran deposite atau pembayaran penuh sebelum tanggal jatuh tempo yang kami tetapkan agar tidak terjadi pembatalan reservasi. Ini juga bertujuan untuk meyakinkan kami bahwa anda memang serius akan menggunakan layanan kami dan bukan pengunjung fiktif. \n" +
                "3. Pembayaran dapat dilakukan melalui Rekening Bank :\n");
        norek.setText(" BNI : 0146268928 A/N BADI \n" +
                " MANDIRI : 161-00-0186903-6 A/N BADI A.Md.\n" +
                " BCA : 232 035 165 3 A/N BADI\n");
        sampaiselesai.setText("4. Pembayaran juga bisa dilakukan melalui XL TUNAI atau Western Union dengan Nomor XL Tunai tujuan dibawah ini : Nomor XL Tunai : 0818547455\n" +
                "5. Mohon konfirmasikan pembayaran anda via email, phone, sms, BBM, atau chating jika anda telah melakukan pembayaran tagihan.\n" +
                "6. Setelah pembayaran anda kami konfirmasi, maka kami akan mengirimkan voucher via email atau fax sebagai bukti pembayaran anda sudah kami terima sekaligus sebagai tanda jadi. Mohon voucher tersebut dibawa ke Lombok sebagai bukti bahwa anda-lah yang menjadi klient kami.\n" +
                "7. Untuk pembayaran sisa tagihan bisa dilakukan saat tiba di Lombok. Pembayaran bisa melalui Cash ke Guide/sopir, atau langsung ke kantor kami.\n" +
                "8. Kami akan mengirimkan Payment receipt beserta voucher via email, Facebook, atau BBM sebagai tanda bukti pembayaran anda sekaligus tanda bukti Bapak/Ibu akan mendapatkan service terbaik kami, GreenChili Travel – Lombok Indonesia.\n\n");

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
