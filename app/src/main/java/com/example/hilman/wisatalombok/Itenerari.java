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
public  class Itenerari extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    static String paket;
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a nic ew instance of this fragment for the given section
     * number.
     */
    public static Itenerari newInstance(int sectionNumber, String pakets) {
        Itenerari fragment = new Itenerari();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        paket=pakets;
        return fragment;
    }

    public Itenerari() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.itenerary, container, false);
        if(paket.equals("Tour Lombok 4 Hari 3 Malam (A)")){

            rootView = inflater.inflate(R.layout.iter43a, container, false);
            TextView labelHari1 = (TextView) rootView.findViewById(R.id.labelHari1);
            labelHari1.setText("HARI 01 : KEDATANGAN – TRANSFER HOTEL");
            TextView hari1 = (TextView) rootView.findViewById(R.id.hari1);
            hari1.setText("Tiba di Bandara International Lombok (BIL), peserta di sambut oleh Guide kami dan langsung diantar ke Hotel untuk Check In dan acara bebas.\n\n");

            TextView labelHari2 = (TextView) rootView.findViewById(R.id.labelHari2);
            labelHari2.setText("Hari 02: SASAK & KUTE TOUR (BL)");
            TextView hari2 = (TextView) rootView.findViewById(R.id.hari2);
            hari2.setText("High Light Program :  Suku sasak – rumah adat Lombok | Budaya dan hasil kerajinan khas Lombok | Keindahan Pantai Kuta Lombok \n\n" +
                            "Sarapan pagi di hotel dan selanjutnya peserta akan mengikuti Sasak & Kute Tour mengunjungi destinasi : \n" +
                            "1. Banyumulek Desa Pusat Pengrajin Tembikar Tanah Liat. \n" +
                            "2. Sukerare Desa Pusat Pengrajin Tenunan Tangan & Ikat khas Lombok \n"+
                            "3. Rambitan Desa adat Suku Sasak \n"+
                            "4. Makan Siang di Kuta Indah Restaurant \n "+
                            "5. Pantai Kute & Tanjung Aan dengan pantainya yang indah dan pasir merica. \n"+
                            "6. Kembali ke Hotel \n\n"
            );
            TextView labelHari3 = (TextView) rootView.findViewById(R.id.labelHari3);
            labelHari3.setText("HARI 03 : GILI TRAWANGAN (BL)");
            TextView hari3 = (TextView) rootView.findViewById(R.id.hari3);
            hari3.setText("High Light Program : Bukit Malimbu | Perjalanan Menggunakan Perahu | Berenang, Snorkeling, Diving & Glassbottom Boat | Keliling Pulau Pakai Cidomo | Baun Pusuk – Hutan Kera \n\n" +
                            "Sarapan pagi di HOTEL dan selanjutnya peserta akan mengikuti Gili Trawangan Tour dan mengunjungi : \n" +
                            "1. Bukit Malimbu dengan pemandangan gunung Agung Bali dan gugusan Gili – Gili yang indah. \n" +
                            "2. Pelabuhan Bangsal dan naik boat selama 40 menit \n"+
                            "3. Gili Trawangan pulau kecil dengan beragam aktivitas wisata bahari : berenang, snorkeling, glass bottom boat, short diving, keliling pulau dengan cidomo (biaya sendiri) \n"+
                            "4. Sore hari kembali ke Bangsal untuk selanjutnya mengunjungi Hutan Lindung Pusuk dengan pemandangan lembah yang indah dan Kera – Kera hutan yang berjejer di sepanjang  jalan \n "+
                            "5. Selanjutnya mengunjungi Kota Mataram & Cakranegara untuk berbelanja oleh – oleh khas Lombok (Mutiara Air Laut & Air Tawar, Kaos Lombok, Makanan khas Lombok, Obat – Obatan khas NTB ), makan siang termasuk dan tour selesai. \n"+
                            "6. Kembali ke Hotel \n\n"
            );
            TextView labelHari4 = (TextView) rootView.findViewById(R.id.labelHari4);
            labelHari4.setText("HARI 04 : TRANSFER AIRPORT (B)");
            TextView hari4 = (TextView) rootView.findViewById(R.id.hari4);
            hari4.setText("Makan pagi di HOTEL, acara bebas sampai waktunya diantar kembali ke Airport untuk perjalanan selanjutnya. \n\n");

            Button toboking  = (Button) rootView.findViewById(R.id.booknow);
            toboking.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    //  Toast.makeText(this , "Ajukan umpan balik: ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), Boking.class);
                    startActivity(intent);
                }
            });


        }
        else if(paket.equals("Tour Lombok 4 Hari 3 Malam (B)")){

            rootView = inflater.inflate(R.layout.iter43b, container, false);
            TextView labelHari1 = (TextView) rootView.findViewById(R.id.labelHari1);
            labelHari1.setText("HARI 01 : KEDATANGAN – TRANSFER HOTEL");
            TextView hari1 = (TextView) rootView.findViewById(R.id.hari1);
            hari1.setText("Tiba di Bandara International Lombok (BIL), peserta di sambut oleh Guide kami dan langsung diantar ke Hotel untuk Check In dan acara bebas.\n\n");

            TextView labelHari2 = (TextView) rootView.findViewById(R.id.labelHari2);
            labelHari2.setText("HARI 02 : PINK BEACH TOUR");
            TextView hari2 = (TextView) rootView.findViewById(R.id.hari2);
            hari2.setText("High Light Program :Perjalanan menggunakan perahu | Melihat spot terumbu karang tercantik di Indonesia Berenang dan Snorkeling dengan bebas | Pulau Pasir yang Langka \n\n" +
                            "Sarapan pagi di HOTEL dan selanjutnya peserta akan mengikuti Pink Beach Tour, mengunjungi destinasi wisata : \n" +
                            "1. Pelabuhan Tanjung Luar dengan jarak tempuh dari Senggigi/Mataram sekitar 2.5 Jam perjalanan. \n" +
                            "2. Naik boat kayu sekitar 30 Menit dan menyisiri pesisir pantai dengan view yang sangat indah \n"+
                            "3. Pink Beach, sebuah pantai cantik di daerah Jerowaru Lombok Timur dengan beragam aktifitas wisata bahari : berenang, snorkeling dll (Biaya Alat snorkeling IDR 50.000 per pax lengkap dengan pemandu snorkeling). \n"+
                            "4. Sore hari mampir di Pulau Pasir yang unik, sebuah pulau yang terbentuk ketika air laut surut. Abadikan moment indah dan photo2 narsis anda disini dengan Latar Pulau Maringkik dan Gili kecil yang cantik. \n "+
                            "5. Selanjutnya kembali ke Pelabuhan Tanjung Luar \n"+
                            "6. Next, melanjutkan perjalanan kembali ke HOTEL selama kurang lebih 2.5 Jam perjalanan \n"+
                            "7. Makan Malam di Lokal Restauran (Jika mengambil paket include dinner) \n"+
                            "8. Tour selesai (Makan siang termasuk dengan menu lunch box atau nasi Kotak) \n\n"
            );
            TextView labelHari3 = (TextView) rootView.findViewById(R.id.labelHari3);
            labelHari3.setText("HARI 03 : GILI TRAWANGAN (BL)");
            TextView hari3 = (TextView) rootView.findViewById(R.id.hari3);
            hari3.setText("High Light Program : Bukit Malimbu | Perjalanan Menggunakan Perahu | Berenang, Snorkeling, Diving & Glassbottom Boat | Keliling Pulau Pakai Cidomo | Baun Pusuk – Hutan Kera \n\n" +
                            "Sarapan pagi di HOTEL dan selanjutnya peserta akan mengikuti Gili Trawangan Tour dan mengunjungi : \n" +
                            "1. Bukit Malimbu dengan pemandangan gunung Agung Bali dan gugusan Gili – Gili yang indah. \n" +
                            "2. Pelabuhan Bangsal dan naik boat selama 40 menit \n"+
                            "3. Gili Trawangan pulau kecil dengan beragam aktivitas wisata bahari : berenang, snorkeling, glass bottom boat, short diving, keliling pulau dengan cidomo (biaya sendiri) \n"+
                            "4. Sore hari kembali ke Bangsal untuk selanjutnya mengunjungi Hutan Lindung Pusuk dengan pemandangan lembah yang indah dan Kera – Kera hutan yang berjejer di sepanjang  jalan \n "+
                            "5. Selanjutnya mengunjungi Kota Mataram & Cakranegara untuk berbelanja oleh – oleh khas Lombok (Mutiara Air Laut & Air Tawar, Kaos Lombok, Makanan khas Lombok, Obat – Obatan khas NTB ), makan siang termasuk dan tour selesai. \n"+
                            "6. Kembali ke Hotel \n\n"
            );
            TextView labelHari4 = (TextView) rootView.findViewById(R.id.labelHari4);
            labelHari4.setText("Hari 04: SASAK & KUTE TOUR – TRANSFER AIRPORT (BL)");
            TextView hari4 = (TextView) rootView.findViewById(R.id.hari4);
            hari4.setText("High Light Program :  Suku sasak – rumah adat Lombok | Budaya dan hasil kerajinan khas Lombok | Keindahan Pantai Kuta Lombok \n\n" +
                            "Sarapan pagi di hotel dan selanjutnya peserta akan mengikuti Sasak & Kute Tour mengunjungi destinasi : \n" +
                            "1. Banyumulek Desa Pusat Pengrajin Tembikar Tanah Liat. \n" +
                            "2. Sukerare Desa Pusat Pengrajin Tenunan Tangan & Ikat khas Lombok \n"+
                            "3. Rambitan Desa adat Suku Sasak \n"+
                            "4. Makan Siang di Kuta Indah Restaurant \n "+
                            "5. Pantai Kute & Tanjung Aan dengan pantainya yang indah dan pasir merica. \n"+
                            "6. Kembali ke Hotel \n\n"
            );

            Button toboking  = (Button) rootView.findViewById(R.id.booknow);
            toboking.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    //  Toast.makeText(this , "Ajukan umpan balik: ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), Boking.class);
                    startActivity(intent);
                }
            });

        }
        else if(paket.equals("Tour Lombok 4 Hari 3 Malam (C)")){

            rootView = inflater.inflate(R.layout.iter43c, container, false);
            TextView labelHari1 = (TextView) rootView.findViewById(R.id.labelHari1);
            labelHari1.setText("HARI 01 : KEDATANGAN – TRANSFER HOTEL");
            TextView hari1 = (TextView) rootView.findViewById(R.id.hari1);
            hari1.setText("Tiba di Bandara International Lombok (BIL), peserta di sambut oleh Guide kami dan langsung diantar ke Hotel untuk Check In dan acara bebas.\n\n");

            TextView labelHari2 = (TextView) rootView.findViewById(R.id.labelHari2);
            labelHari2.setText("HARI 02 : PINK BEACH TOUR");
            TextView hari2 = (TextView) rootView.findViewById(R.id.hari2);
            hari2.setText("High Light Program :Perjalanan menggunakan perahu | Melihat spot terumbu karang tercantik di Indonesia Berenang dan Snorkeling dengan bebas | Pulau Pasir yang Langka \n\n" +
                            "Sarapan pagi di HOTEL dan selanjutnya peserta akan mengikuti Pink Beach Tour, mengunjungi destinasi wisata : \n" +
                            "1. Pelabuhan Tanjung Luar dengan jarak tempuh dari Senggigi/Mataram sekitar 2.5 Jam perjalanan. \n" +
                            "2. Naik boat kayu sekitar 30 Menit dan menyisiri pesisir pantai dengan view yang sangat indah \n"+
                            "3. Pink Beach, sebuah pantai cantik di daerah Jerowaru Lombok Timur dengan beragam aktifitas wisata bahari : berenang, snorkeling dll (Biaya Alat snorkeling IDR 50.000 per pax lengkap dengan pemandu snorkeling). \n"+
                            "4. Sore hari mampir di Pulau Pasir yang unik, sebuah pulau yang terbentuk ketika air laut surut. Abadikan moment indah dan photo2 narsis anda disini dengan Latar Pulau Maringkik dan Gili kecil yang cantik. \n "+
                            "5. Selanjutnya kembali ke Pelabuhan Tanjung Luar \n"+
                            "6. Next, melanjutkan perjalanan kembali ke HOTEL selama kurang lebih 2.5 Jam perjalanan \n"+
                            "7. Makan Malam di Lokal Restauran (Jika mengambil paket include dinner) \n"+
                            "8. Tour selesai (Makan siang termasuk dengan menu lunch box atau nasi Kotak) \n\n"
            );
            TextView labelHari3 = (TextView) rootView.findViewById(R.id.labelHari3);
            labelHari3.setText("HARI 03 : SENDANG GILA WATERFALL (BL)");
            TextView hari3 = (TextView) rootView.findViewById(R.id.hari3);
            hari3.setText("High Light Program : Bukit Malimbu | Air Terjun Sendang Gile | Pusuk Pass Hutan (Kera) \n\n" +
                            "Sarapan pagi di HOTEL dan selanjutnya peserta akan mengikuti  Sendang Gile Waterfall Tour,  mengunjungi : \n" +
                            "1. Bukit Malimbu dengan pemandangan Gunung Agung Bali dan gugusan Gili – Gili yang indah. \n" +
                            "2. Senaru Desa di kaki Gunung Rinjani sebelah utara dan mengunjungi Air Terjun Sendang Gile \n"+
                            "3. Bayan Desa dengan peninggalan Masjid Kuno\n"+
                            "4. Pusuk pass Hutan lindung dengan pemandangan lembah yang indah dan kera hutan yang berjejer di sepanjang pinggir jalan \n "+
                            "5. Makan siang termasuk dan tour selesai. \n"+
                            "6. Kembali ke Hotel \n\n"
            );
            TextView labelHari4 = (TextView) rootView.findViewById(R.id.labelHari4);
            labelHari4.setText("Hari 04: SASAK & KUTE TOUR – TRANSFER AIRPORT (BL)");
            TextView hari4 = (TextView) rootView.findViewById(R.id.hari4);
            hari4.setText("High Light Program :  Suku sasak – rumah adat Lombok | Budaya dan hasil kerajinan khas Lombok | Keindahan Pantai Kuta Lombok \n\n" +
                            "Sarapan pagi di hotel dan selanjutnya peserta akan mengikuti Sasak & Kute Tour mengunjungi destinasi : \n" +
                            "1. Banyumulek Desa Pusat Pengrajin Tembikar Tanah Liat. \n" +
                            "2. Sukerare Desa Pusat Pengrajin Tenunan Tangan & Ikat khas Lombok \n"+
                            "3. Rambitan Desa adat Suku Sasak \n"+
                            "4. Makan Siang di Kuta Indah Restaurant \n "+
                            "5. Pantai Kute & Tanjung Aan dengan pantainya yang indah dan pasir merica. \n"+
                            "6. Kembali ke Hotel \n\n"
            );

            Button toboking  = (Button) rootView.findViewById(R.id.booknow);
            toboking.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    //  Toast.makeText(this , "Ajukan umpan balik: ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), Boking.class);
                    startActivity(intent);
                }
            });

        }
        else if(paket.equals("Tour Lombok 3 Hari 2 Malam (A)")){

            rootView = inflater.inflate(R.layout.iter32a, container, false);
            TextView labelHari1 = (TextView) rootView.findViewById(R.id.labelHari1);
            labelHari1.setText("HARI 01 : KEDATANGAN – TRANSFER HOTEL");
            TextView hari1 = (TextView) rootView.findViewById(R.id.hari1);
            hari1.setText("Tiba di Bandara International Lombok (BIL), peserta di sambut oleh Guide kami dan langsung diantar ke Hotel untuk Check In dan acara bebas.\n\n");

            TextView labelHari2 = (TextView) rootView.findViewById(R.id.labelHari2);
            labelHari2.setText("HARI 02. GILI TRAWANGAN TOUR (BL)");
            TextView hari2 = (TextView) rootView.findViewById(R.id.hari2);
            hari2.setText("High Light Program : \n" +
                            "1. Bukit Malimbu \n" +
                            "2. Perjalanan Menggunakan Perahu \n" +
                            "3. Berenang, Snorkeling, Diving & Glassbottom Boat \n" +
                            "4. Keliling Pulau Pakai Cidomo \n" +
                            "5. Baun Pusuk – Hutan Kera \n\n" +

                            "Sarapan pagi di HOTEL dan selanjutnya peserta akan mengikuti Gili Trawangan Tour mengunjungi: \n" +
                            "1. Bukit Malimbu dengan pemandangan gunung Agung Bali dan gugusan Gili – Gili yang indah. \n" +
                            "2. Pelabuhan Bangsal dan naik boat selama 40 menit \n"+
                            "3. Gili Trawangan pulau kecil dengan beragam aktivitas wisata bahari : berenang, snorkeling, glass bottom boat, short diving, keliling pulau dengan cidomo (biaya sendiri) \n"+
                            "4. Sore hari kembali ke Bangsal untuk selanjutnya mengunjungi Hutan Lindung Pusuk dengan pemandangan lembah yang indah dan Kera – Kera hutan yang berjejer di sepanjang  jalan \n "+
                            "5. Selanjutnya mengunjungi Kota Mataram & Cakranegara untuk berbelanja oleh – oleh khas Lombok (Mutiara Air Laut & Air Tawar, Kaos Lombok, Makanan khas Lombok, Obat – Obatan khas NTB ), makan siang termasuk dan tour selesai. \n"+
                            "6. Kembali ke Hotel \n\n"
            );
            TextView labelHari3 = (TextView) rootView.findViewById(R.id.labelHari3);
            labelHari3.setText("HARI 03 : SASAK & KUTE TOUR – TRANSFER AIRPORT (BL)");
            TextView hari3 = (TextView) rootView.findViewById(R.id.hari3);
            hari3.setText("High Light Program : \n " +
                            "1. Suku sasak – rumah adat Lombok \n" +
                            "2. Budaya dan hasil kerajinan khas Lombok n" +
                            "3. Keindahan Pantai Kuta Lombok\n\n" +

                            "Sarapan pagi di HOTEL dan selanjutnya peserta akan mengikuti Sasak & Kute Tour mengunjungi : \n" +
                            "1. Banyumulek Desa Pusat Pengrajin Tembikar Tanah Liat \n" +
                            "2. Sukerare Desa Pusat Pengrajin Tenunan Tangan & Ikat khas Lombok \n"+
                            "3. Rambitan Desa adat Suku Sasak \n"+
                            "4. Pantai Kute & Tanjung Aan dengan pantainya yang indah dan pasir merica. Makan siang termasuk dan tour selesai, \n"+
                            "5. Selanjutnya peserta langsung di antar ke Airport untuk penerbangan ke tujuan selanjutnya. \n\n"

            );
            Button toboking  = (Button) rootView.findViewById(R.id.booknow);
            toboking.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    //  Toast.makeText(this , "Ajukan umpan balik: ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), Boking.class);
                    startActivity(intent);
                }
            });

        }
        else if(paket.equals("Tour Lombok 3 Hari 2 Malam (B)")){

            rootView = inflater.inflate(R.layout.iter32b, container, false);
            TextView labelHari1 = (TextView) rootView.findViewById(R.id.labelHari1);
            labelHari1.setText("HARI 01 : KEDATANGAN – TRANSFER HOTEL");
            TextView hari1 = (TextView) rootView.findViewById(R.id.hari1);
            hari1.setText("Tiba di Bandara International Lombok (BIL), peserta di sambut oleh Guide kami dan langsung diantar ke Hotel untuk Check In dan acara bebas.\n\n");

            TextView labelHari2 = (TextView) rootView.findViewById(R.id.labelHari2);
            labelHari2.setText("HARI 02. GILI TRAWANGAN TOUR (BL)");
            TextView hari2 = (TextView) rootView.findViewById(R.id.hari2);
            hari2.setText("High Light Program : \n" +
                            "1. Bukit Malimbu \n" +
                            "2. Perjalanan Menggunakan Perahu \n" +
                            "3. Berenang, Snorkeling, Diving & Glassbottom Boat \n" +
                            "4. Keliling Pulau Pakai Cidomo \n" +
                            "5. Baun Pusuk – Hutan Kera \n\n" +

                            "Sarapan pagi di HOTEL dan selanjutnya peserta akan mengikuti Gili Trawangan Tour mengunjungi: \n" +
                            "1. Bukit Malimbu dengan pemandangan gunung Agung Bali dan gugusan Gili – Gili yang indah. \n" +
                            "2. Pelabuhan Bangsal dan naik boat selama 40 menit \n"+
                            "3. Gili Trawangan pulau kecil dengan beragam aktivitas wisata bahari : berenang, snorkeling, glass bottom boat, short diving, keliling pulau dengan cidomo (biaya sendiri) \n"+
                            "4. Sore hari kembali ke Bangsal untuk selanjutnya mengunjungi Hutan Lindung Pusuk dengan pemandangan lembah yang indah dan Kera – Kera hutan yang berjejer di sepanjang  jalan. Makan siang termasuk dan tour selesai. \n"+
                            "5. Kembali ke Hotel \n\n"
            );
            TextView labelHari3 = (TextView) rootView.findViewById(R.id.labelHari3);
            labelHari3.setText("HARI 03 : CITY TOUR – TRANSFER AIRPORT (BL)");
            TextView hari3 = (TextView) rootView.findViewById(R.id.hari3);
            hari3.setText("High Light Program : \n " +
                            "1. Taman Narmada \n" +
                            "2. Pura Lingsar n" +
                            "3. Kota Mataram & Pusat Oleh-oleh\n\n" +

                            "Sarapan pagi di HOTEL dan selanjutnya peserta akan mengikuti City Tour, mengunjungi :\n" +
                            "1. Taman Narmada sebagai replika Gunung Rinjani \n" +
                            "2. Lingsar Pura Muslim Waktu Telu \n"+
                            "3. Kota Mataram ke pasar Cakranegara tempat Kaos Lombok, Mutiara dan oleh oleh Lombok seperti: madu, telur asin, dodol nangka, dll. \n"+
                            "4. Makan siang di lokal Rastaurant. \n"+
                            "5. Usai makan siang diantar ke airport untuk penerbangan ke tujuan berikutnya. \n" +
                            "6. Tour selesai. \n\n"

            );
            Button toboking  = (Button) rootView.findViewById(R.id.booknow);
            toboking.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    //  Toast.makeText(this , "Ajukan umpan balik: ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), Boking.class);
                    startActivity(intent);
                }
            });

        }
        else if(paket.equals("Tour Lombok 3 Hari 2 Malam (C)")){

            rootView = inflater.inflate(R.layout.iter32c, container, false);


            TextView labelHari1 = (TextView) rootView.findViewById(R.id.labelHari1);
            labelHari1.setText("HARI 02. GILI TRAWANGAN TOUR (BL)");
            TextView hari1 = (TextView) rootView.findViewById(R.id.hari1);
            hari1.setText("High Light Program : \n" +
                            "1. Bukit Malimbu \n" +
                            "2. Perjalanan Menggunakan Perahu \n" +
                            "3. Berenang, Snorkeling, Diving & Glassbottom Boat \n" +
                            "4. Keliling Pulau Pakai Cidomo \n" +
                            "5. Baun Pusuk – Hutan Kera \n\n" +

                            "Sarapan pagi di HOTEL dan selanjutnya peserta akan mengikuti Gili Trawangan Tour mengunjungi: \n" +
                            "1. Bukit Malimbu dengan pemandangan gunung Agung Bali dan gugusan Gili – Gili yang indah. \n" +
                            "2. Pelabuhan Bangsal dan naik boat selama 40 menit \n"+
                            "3. Gili Trawangan pulau kecil dengan beragam aktivitas wisata bahari : berenang, snorkeling, glass bottom boat, short diving, keliling pulau dengan cidomo (biaya sendiri) \n"+
                            "4. Sore hari kembali ke Bangsal untuk selanjutnya mengunjungi Hutan Lindung Pusuk dengan pemandangan lembah yang indah dan Kera – Kera hutan yang berjejer di sepanjang  jalan. Makan siang termasuk dan tour selesai. \n"+
                            "5. Kembali ke Hotel \n\n"
            );
            TextView labelHari2 = (TextView) rootView.findViewById(R.id.labelHari2);
            labelHari2.setText("HARI 03 : CITY TOUR – TRANSFER AIRPORT (BL)");
            TextView hari2 = (TextView) rootView.findViewById(R.id.hari2);
            hari2.setText("High Light Program : \n " +
                            "1. Bukit Malimbu \n" +
                            "2. Air Terjun Sendang Gile \n" +
                            "3. Pusuk Pass Hutan (Kera) \n\n" +

                            "Sarapan pagi di HOTEL dan selanjutnya peserta akan mengikuti  Sendang Gile Waterfall Tour,  mengunjungi :\n" +
                            "1. Bukit Malimbu dengan pemandangan Gunung Agung Bali dan gugusan Gili – Gili yang indah. \n" +
                            "2. Senaru Desa di kaki Gunung Rinjani sebelah utara dan mengunjungi Air Terjun Sendang Gile \n"+
                            "3. Bayan Desa dengan peninggalan Masjid Kuno \n"+
                            "4. Pusuk pass Hutan lindung dengan pemandangan lembah yang indah dan kera hutan yang berjejer di sepanjang pinggir jalan \n"+
                            "5. Makan siang termasuk dan tour selesai.\n" +
                            "6. Kembali ke HOTEL \n\n"

            );
            TextView labelHari3 = (TextView) rootView.findViewById(R.id.labelHari3);
            labelHari1.setText("HARI 03 : KEBERANGKATAN – TRANSFER AIRPORT (B)");
            TextView hari3 = (TextView) rootView.findViewById(R.id.hari3);
            hari1.setText("Sarapan pagi di HOTEL dan acara bebas sampai waktu penjemputan untuk diantar ke Bandara Internasional Lombok untuk penerbangan ke tujuan selanjutnya..\n\n");


            Button toboking  = (Button) rootView.findViewById(R.id.booknow);
            toboking.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    //  Toast.makeText(this , "Ajukan umpan balik: ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), Boking.class);
                    startActivity(intent);
                }
            });
        }
        else if(paket.equals("Tour Lombok 3 Hari 2 Malam (D)")){

            rootView = inflater.inflate(R.layout.iter32b, container, false);
            TextView labelHari1 = (TextView) rootView.findViewById(R.id.labelHari1);
            labelHari1.setText("HARI 01 : KEDATANGAN – TRANSFER HOTEL");
            TextView hari1 = (TextView) rootView.findViewById(R.id.hari1);
            hari1.setText("Tiba di Bandara International Lombok (BIL), peserta di sambut oleh Guide kami dan langsung diantar ke Hotel untuk Check In dan acara bebas.\n\n");

            TextView labelHari2 = (TextView) rootView.findViewById(R.id.labelHari2);
            labelHari2.setText("HARI 02. GILI TRAWANGAN TOUR (BL)");
            TextView hari2 = (TextView) rootView.findViewById(R.id.hari2);
            hari2.setText("High Light Program : \n" +
                            "1. Bukit Malimbu \n" +
                            "2. Perjalanan Menggunakan Perahu \n" +
                            "3. Berenang, Snorkeling, Diving & Glassbottom Boat \n" +
                            "4. Keliling Pulau Pakai Cidomo \n" +
                            "5. Baun Pusuk – Hutan Kera \n\n" +

                            "Sarapan pagi di HOTEL dan selanjutnya peserta akan mengikuti Gili Trawangan Tour mengunjungi: \n" +
                            "1. Bukit Malimbu dengan pemandangan gunung Agung Bali dan gugusan Gili – Gili yang indah. \n" +
                            "2. Pelabuhan Bangsal dan naik boat selama 40 menit \n"+
                            "3. Gili Trawangan pulau kecil dengan beragam aktivitas wisata bahari : berenang, snorkeling, glass bottom boat, short diving, keliling pulau dengan cidomo (biaya sendiri) \n"+
                            "4. Sore hari kembali ke Bangsal untuk selanjutnya mengunjungi Hutan Lindung Pusuk dengan pemandangan lembah yang indah dan Kera – Kera hutan yang berjejer di sepanjang  jalan. Makan siang termasuk dan tour selesai. \n"+
                            "5. Kembali ke Hotel \n\n"
            );
            TextView labelHari3 = (TextView) rootView.findViewById(R.id.labelHari3);
            labelHari3.setText("HARI 03 : CITY TOUR – TRANSFER AIRPORT (BL)");
            TextView hari3 = (TextView) rootView.findViewById(R.id.hari3);
            hari3.setText("High Light Program : \n " +
                            "1. Taman Narmada \n" +
                            "2. Pura Lingsar n" +
                            "3. Kota Mataram & Pusat Oleh-oleh\n\n" +

                            "Sarapan pagi di HOTEL dan selanjutnya peserta akan mengikuti City Tour, mengunjungi :\n" +
                            "1. Taman Narmada sebagai replika Gunung Rinjani \n" +
                            "2. Lingsar Pura Muslim Waktu Telu \n"+
                            "3. Kota Mataram ke pasar Cakranegara tempat Kaos Lombok, Mutiara dan oleh oleh Lombok seperti: madu, telur asin, dodol nangka, dll. \n"+
                            "4. Makan siang di lokal Rastaurant. \n"+
                            "5. Usai makan siang diantar ke airport untuk penerbangan ke tujuan berikutnya. \n" +
                            "6. Tour selesai. \n\n"

            );

            Button toboking  = (Button) rootView.findViewById(R.id.booknow);
            toboking.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    //  Toast.makeText(this , "Ajukan umpan balik: ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), Boking.class);
                    startActivity(intent);
                }
            });

        }
        else if(paket.equals("Tour Lombok 2 Hari 1 Malam (A)")){

            rootView = inflater.inflate(R.layout.iter21a, container, false);
            TextView labelHari1 = (TextView) rootView.findViewById(R.id.labelHari1);
            labelHari1.setText("HARI 01 : KEDATANGAN – CITY TOUR (L)");
            TextView hari1 = (TextView) rootView.findViewById(R.id.hari1);
            hari1.setText("High Light Program : \n " +
                            "1. Taman Narmada \n" +
                            "2. Pura Lingsar n" +
                            "3. Kota Mataram & Pusat Oleh-oleh\n\n" +

                            "Tiba di Bandara International Lombok (BIL), peserta di sambut oleh Guide kami dan dan selanjutnya peserta akan mengikuti City Tour, mengunjungi :\n" +
                            "1. Taman Narmada sebagai replika Gunung Rinjani \n" +
                            "2. Lingsar Pura Muslim Waktu Telu \n"+
                            "3. Kota Mataram ke pasar Cakranegara tempat Kaos Lombok, Mutiara dan oleh oleh Lombok seperti: madu, telur asin, dodol nangka, dll. \n"+
                            "4. Makan siang di lokal Rastaurant. \n"+

                            "5. Balik ke HOTEL \n\n"

            );


            TextView labelHari2 = (TextView) rootView.findViewById(R.id.labelHari2);
            labelHari2.setText("Hari 02: GILI TRAWANGAN TOUR – TRANSFER AIRPORT (BL)");
            TextView hari2 = (TextView) rootView.findViewById(R.id.hari2);
            hari2.setText("High Light Program : \n" +
                            "1. Bukit Malimbu \n" +
                            "2. Perjalanan Menggunakan Perahu \n" +
                            "3. Berenang, Snorkeling, Diving & Glassbottom Boat \n" +
                            "4. Keliling Pulau Pakai Cidomo \n" +
                            "5. Baun Pusuk – Hutan Kera \n\n" +

                            "Sarapan pagi di HOTEL dan selanjutnya peserta akan mengikuti Gili Trawangan Tour mengunjungi: \n" +
                            "1. Bukit Malimbu dengan pemandangan gunung Agung Bali dan gugusan Gili – Gili yang indah. \n" +
                            "2. Pelabuhan Bangsal dan naik boat selama 40 menit \n"+
                            "3. Gili Trawangan pulau kecil dengan beragam aktivitas wisata bahari : berenang, snorkeling, glass bottom boat, short diving, keliling pulau dengan cidomo (biaya sendiri) \n"+
                            "4. Sore hari kembali ke Bangsal untuk selanjutnya mengunjungi Hutan Lindung Pusuk dengan pemandangan lembah yang indah dan Kera – Kera hutan yang berjejer di sepanjang  jalan. Makan siang termasuk dan tour selesai. \n" +
                            "5. Selanjutnya peserta diantar ke airport untuk penerbangan ke tujuan berikutnya."+
                            "6. Tour Selesai. \n\n"
            );

            Button toboking  = (Button) rootView.findViewById(R.id.booknow);
            toboking.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    //  Toast.makeText(this , "Ajukan umpan balik: ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), Boking.class);
                    startActivity(intent);
                }
            });

        }
        else if(paket.equals("Tour Lombok 2 Hari 1 Malam (B)")){

            rootView = inflater.inflate(R.layout.iter21a, container, false);
            TextView labelHari1 = (TextView) rootView.findViewById(R.id.labelHari1);
            labelHari1.setText("HARI 01 : KEDATANGAN – CITY TOUR (L)");
            TextView hari1 = (TextView) rootView.findViewById(R.id.hari1);
            hari1.setText("High Light Program : \n " +
                            "1. Taman Narmada \n" +
                            "2. Pura Lingsar n" +
                            "3. Kota Mataram & Pusat Oleh-oleh\n\n" +

                            "Tiba di Bandara International Lombok (BIL), peserta di sambut oleh Guide kami dan dan selanjutnya peserta akan mengikuti City Tour, mengunjungi :\n" +
                            "1. Taman Narmada sebagai replika Gunung Rinjani \n" +
                            "2. Lingsar Pura Muslim Waktu Telu \n"+
                            "3. Kota Mataram ke pasar Cakranegara tempat Kaos Lombok, Mutiara dan oleh oleh Lombok seperti: madu, telur asin, dodol nangka, dll. \n"+
                            "4. Makan siang di lokal Rastaurant. \n"+

                            "5. Balik ke HOTEL \n\n"

            );


            TextView labelHari2 = (TextView) rootView.findViewById(R.id.labelHari2);
            labelHari2.setText("HARI 02 : SASAK & KUTE TOUR – TRANSFER AIRPORT (BL)");
            TextView hari2 = (TextView) rootView.findViewById(R.id.hari2);
            hari2.setText("High Light Program : \n " +
                            "1. Suku sasak – rumah adat Lombok \n" +
                            "2. Budaya dan hasil kerajinan khas Lombok n" +
                            "3. Keindahan Pantai Kuta Lombok\n\n" +

                            "Sarapan pagi di HOTEL, lalu peserta dijemput oleh Tour Guide kami untuk mengikuti Sasak & Kute Tour, mengunjungi : \n" +
                            "1. Sukerare Desa pusat pengrajin tenunan tangan & ikat khas Lombok \n" +
                            "2. Rambitan Desa adat Suku Sasak\n"+
                            "3. Pantai Kute dan Tanjung Aan dengan pantainya yang indah dan pasir mericanya."+
                            "4. Banyumulek desa pusat pengrajin tembikar tanah liat \n"+
                            "5. Kota Mataram dan Cakranegara untuk berkesempatan berbelanja oleh – oleh khas Lombok ( mutiara air laut dan air tawar, kaos lombok, Makanan khas Lombok, Obat- obatan khas NTB ).\n" +
                            "6. Pasar seni Sesela untuk melihat kerajinan Cukli ( Ukiran kayu, rotan dan ketak ).\n" +
                            "7. Makan siang termasuk dan tour selesai \n" +
                            "8. Selanjutnya peserta langsung di antar ke Airport untuk tujuan selanjutnya. \n\n"

            );
            Button toboking  = (Button) rootView.findViewById(R.id.booknow);
            toboking.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    //  Toast.makeText(this , "Ajukan umpan balik: ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), Boking.class);
                    startActivity(intent);
                }
            });


        }








        return rootView;
    }
}

