package com.example.hilman.wisatalombok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by HILMAN on 8/3/2015.
 */
public  class Info extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static Info newInstance(int sectionNumber) {
        Info fragment = new Info();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public Info() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.info, container, false);
        TextView info1 = (TextView) rootView.findViewById(R.id.aturan1);
        TextView header = (TextView) rootView.findViewById(R.id.headerAturan);
        TextView info2 = (TextView) rootView.findViewById(R.id.aturan2);
        info1.setText("1. Minimal Peserta Tour 2 Orang.\n" +
                "2. Angka 2-3 orang, 4-5 orang dan seterusnya menunjukkan jumlah peserta tour, semakin banyak jumlah peserta maka harga paket tour per orang semakin murah.\n" +
                "3. Harga diatas untuk PRIVATE TOUR (tidak digabung dengan tamu lainnya)\n" +
                "4. Mobil yang digunakan : Suzuki APV Arena, Toyota Avanza, KIA Pregio, Isuzu Elf dan Bus sampai 50 Seat. Pemakaian mobil tergantung persediaan pada saat pemesanan dan jumlah peserta. \n" +
                "5. Paket Tour hanya berlaku untuk wisatawan domestic dan pemegang KIMS atau KITAS\n" +
                "6. Waktu untuk Check In HOTEL adalah 14.00 dan waktu untuk Check Out adalah 12.00\n" +
                "");
        header.setText("Ketentuan harga untuk anak-anak(3-11 tahun)");
        info2.setText("1. Sekamar dengan orang tua (1 dewasa + 1 Anak) dihitung sama dengan harga dewasa\n" +
                "2. Sekamar dengan orang tua (2 dewasa + 1 Anak) menggunakan extra bed dihitung 75% dari harga dewasa .\n" +
                "3. Sekamar dengan orang tua (2 dewasa + 1 anak) tanpa extra bed dihitung 50% dari harga dewasa dan tidak termasuk makan pagi.\n" +
                "4. Maksimal 1 anak (3-11) sekamar dengan orang tua (dengan penambahan 1 extra bed). \n" +
                "5. Bayi / Infant (0-3 tahun) tidak dikenakan biaya \n" +
                "");


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

