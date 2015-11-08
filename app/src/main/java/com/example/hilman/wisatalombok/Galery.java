package com.example.hilman.wisatalombok;

/**
 * Created by HILMAN on 7/30/2015.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public  class Galery extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static   final String ARG_SECTION_NUMBER = "section_number";

    ListView listView;
    CustomListGalery adapter1;
    List<String> listGalery = new ArrayList<String>();
    static String paket;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static Galery newInstance(int sectionNumber, String pakets) {
        Galery fragment = new Galery();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        paket = pakets;
        return fragment;
    }

    public Galery() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_galery, container, false);
        DatabaseHelper databaseHelper = new DatabaseHelper(getActivity().getApplicationContext());
        databaseHelper.getWritableDatabase();
        listView = (ListView) rootView.findViewById(R.id.list);
        ArrayList<String> listGalery  = databaseHelper.getAllGalery();
        ArrayList<String> listForGalery  = new ArrayList<>();


        for(int ii = 0 ; ii < listGalery.size(); ii++){
            String [] splitGalery = listGalery.get(ii).split("##");

            if(paket.equals("Tour Lombok 4 Hari 3 Malam (A)")){
                if(splitGalery[0].equals("4h3ma")){
                    listForGalery.add(splitGalery[1]);

                }
            }
            else if(paket.equals("Tour Lombok 4 Hari 3 Malam (B)")){
                if(splitGalery[0].equals("4h3mb")){
                    listForGalery.add(splitGalery[1]);
                }

            }
            else if(paket.equals("Tour Lombok 4 Hari 3 Malam (C)")){
                if(splitGalery[0].equals("4h3mc")){
                    listForGalery.add(splitGalery[1]);
                }

            }
            else if(paket.equals("Tour Lombok 3 Hari 2 Malam (A)")){
                if(splitGalery[0].equals("3h2ma")){
                    listForGalery.add(splitGalery[1]);

                }

            }else if(paket.equals("Tour Lombok 3 Hari 2 Malam (B)")){
                if(splitGalery[0].equals("3h2mb")){
                    listForGalery.add(splitGalery[1]);

                }

            }else if(paket.equals("Tour Lombok 3 Hari 2 Malam (C)")){
                if(splitGalery[0].equals("3h2mc")){
                    listForGalery.add(splitGalery[1]);
                }

            }else if(paket.equals("Tour Lombok 3 Hari 2 Malam (D)")){
                if(splitGalery[0].equals("3h2md")){
                    listForGalery.add(splitGalery[1]);
                }

            }else if(paket.equals("Tour Lombok 2 Hari 1 Malam (A)")){
                if(splitGalery[0].equals("2h1ma")){
                    listForGalery.add(splitGalery[1]);
                }

            }else if(paket.equals("Tour Lombok 2 Hari 1 Malam (B)")){
                if(splitGalery[0].equals("2h1mb")){
                    listForGalery.add(splitGalery[1]);
                }

            }


        }

        adapter1 = new CustomListGalery(getActivity(),listForGalery);
        listView.setAdapter(adapter1);

        return rootView;
    }


}