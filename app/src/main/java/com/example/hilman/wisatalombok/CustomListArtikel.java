package com.example.hilman.wisatalombok;

import android.widget.BaseAdapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.graphics.drawable.DrawableWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hilman.wisatalombok.PaketTour;
import com.example.hilman.wisatalombok.AppController;



import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import java.util.List;
import com.example.hilman.wisatalombok.ArtikelObjek;

import com.squareup.picasso.Picasso;


/**
 * Created by HILMAN on 7/28/2015.
 */
public class CustomListArtikel extends BaseAdapter{

    private Activity activity;
    private LayoutInflater inflater;
    private List<ArtikelObjek> daftarArtikel;


    public CustomListArtikel(Activity activity, List<ArtikelObjek> daftarArtikel) {
        this.activity = activity;
        this.daftarArtikel = daftarArtikel;
    }

    @Override
    public int getCount() {
        return daftarArtikel.size();
    }

    @Override
    public Object getItem(int location) {
        return daftarArtikel.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_artikel, null);

        ImageView thumbNail = (ImageView) convertView.findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.title);

        TextView sinopsis = (TextView) convertView.findViewById(R.id.sinopsis);
        Context context = activity.getApplicationContext();
        ArtikelObjek artikel = daftarArtikel.get(position);
        Picasso.with(context).load(artikel.getUrlGambar()).error(R.drawable.ic_action_banyak_orang).into(thumbNail);
        title.setText(artikel.getJudul());
        sinopsis.setText(artikel.sinopsis);
        return convertView;
    }

}
