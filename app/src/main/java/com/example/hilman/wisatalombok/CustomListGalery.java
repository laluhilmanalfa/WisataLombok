package com.example.hilman.wisatalombok;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by HILMAN on 7/28/2015.
 */
public class CustomListGalery extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<String> daftarGalery;

    public CustomListGalery(Activity activity, List<String> daftarArtikel) {
        this.activity = activity;
        this.daftarGalery = daftarArtikel;
    }

    @Override
    public int getCount() {
        return daftarGalery.size();
    }
    @Override
    public Object getItem(int location) {
        return daftarGalery.get(location);
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
            convertView = inflater.inflate(R.layout.custom_galery, null);
        ImageView thumbNail = (ImageView) convertView.findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView sinopsis = (TextView) convertView.findViewById(R.id.sinopsis);
        Context context = activity.getApplicationContext();
        String artikel = daftarGalery.get(position);
        Picasso.with(context).load(artikel).error(R.drawable.ic_action_banyak_orang).into(thumbNail);
        return convertView;
    }

}

