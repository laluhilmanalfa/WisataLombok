package com.example.hilman.wisatalombok;

/**
 * Created by HILMAN on 8/3/2015.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public  class PembayaranInfo extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PembayaranInfo newInstance(int sectionNumber) {
        PembayaranInfo fragment = new PembayaranInfo();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PembayaranInfo() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.pembayaran, container, false);
        TextView sampai3 = (TextView) rootView.findViewById(R.id.sampai3);
        TextView norek = (TextView) rootView.findViewById(R.id.norek);
        TextView sampaiselesai = (TextView) rootView.findViewById(R.id.sampaiselesai);

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




        Button toboking  = (Button) rootView.findViewById(R.id.booknow);
        toboking.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //  Toast.makeText(this , "Ajukan umpan balik: ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), Boking.class);
                startActivity(intent);
            }
        });
        return rootView;


    }

}
