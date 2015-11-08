package com.example.hilman.wisatalombok;

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

/**
 * Created by HILMAN on 6/25/2015.
 */
public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<PaketTour> daftarPaket;
 /*   ImageLoader imageLoader = AppController.getInstance().getImageLoader();*/

    public CustomListAdapter(Activity activity, List<PaketTour> daftarPaket) {
        this.activity = activity;
        this.daftarPaket = daftarPaket;
    }

    @Override
    public int getCount() {
        return daftarPaket.size();
    }

    @Override
    public Object getItem(int location) {
        return daftarPaket.get(location);
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
            convertView = inflater.inflate(R.layout.list_row, null);

       /* if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);*/
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView rating = (TextView) convertView.findViewById(R.id.rating);
        TextView Tempat = (TextView) convertView.findViewById(R.id.genre);
        TextView Harga = (TextView) convertView.findViewById(R.id.releaseYear);
        ImageView thumbNail = (ImageView) convertView.findViewById(R.id.thumbnail);

        // getting movie data for the row
        PaketTour paket = daftarPaket.get(position);

        // thumbnail image
      //  thumbNail.setImageUrl(paket.getThumbnailUrl(), imageLoader);

        thumbNail.setImageResource(R.drawable.paket21b);
        if(paket.getTitle().equals("Tour Lombok 4 Hari 3 Malam (A)")){
            thumbNail.setImageResource(R.drawable.paket43a);
        }
        if(paket.getTitle().equals("Tour Lombok 4 Hari 3 Malam (B)")){
            thumbNail.setImageResource(R.drawable.paket43b);
        }

        if(paket.getTitle().equals("Tour Lombok 4 Hari 3 Malam (C)")){
            thumbNail.setImageResource(R.drawable.paket43c);
        }

        if(paket.getTitle().equals("Tour Lombok 3 Hari 2 Malam (A)")){
            thumbNail.setImageResource(R.drawable.paket32a);
        }
        if(paket.getTitle().equals("Tour Lombok 3 Hari 2 Malam (B)")){
            thumbNail.setImageResource(R.drawable.paket32b);
        }
        if(paket.getTitle().equals("Tour Lombok 3 Hari 2 Malam (C)")){
            thumbNail.setImageResource(R.drawable.paket32c);
        }
        if(paket.getTitle().equals("Tour Lombok 3 Hari 2 Malam (D)")){
            thumbNail.setImageResource(R.drawable.paket32d);
        }
        if(paket.getTitle().equals("Tour Lombok 2 Hari 1 Malam (A)")){
            thumbNail.setImageResource(R.drawable.paket21a);
        }
        if(paket.getTitle().equals("Tour Lombok 2 Hari 1 Malam (B)")){
            thumbNail.setImageResource(R.drawable.paket21b);
        }

        title.setText(paket.getTitle());

        // rating
        rating.setText("Kode Paket : " + paket.getKodePaket());

        // genre
        String genreStr = "";
        for (String str : paket.getTempat()) {
            genreStr += str + ", ";
        }
        genreStr = genreStr.length() > 0 ? genreStr.substring(0,
                genreStr.length() - 2) : genreStr;
        Tempat.setText(genreStr);

        // release year
        Harga.setText(String.valueOf(paket.getHarga()));

        return convertView;
    }

}