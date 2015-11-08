package com.example.hilman.wisatalombok;

import java.util.ArrayList;

/**
 * Created by HILMAN on 6/25/2015.
 */
public class PaketTour {
    private String title, thumbnailUrl;
    private String harga;
    private ArrayList<String> tempat;
    private String  kodePaket;

    public PaketTour(){

    }
    public PaketTour(String title, String thumbnailUrl, String harga, ArrayList<String> tempat, String kodePaket) {
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.harga = harga;
        this.tempat = tempat;
        this.kodePaket = kodePaket;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public void setTempat(ArrayList<String> tempat) {
        this.tempat = tempat;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getHarga() {
        return harga;
    }

    public ArrayList<String> getTempat() {
        return tempat;
    }

    public String getKodePaket() {
        return kodePaket;
    }

    public void setKodePaket(String kodePaket) {
        this.kodePaket = kodePaket;
    }
}
