package com.example.hilman.wisatalombok;

/**
 * Created by HILMAN on 7/28/2015.
 */
public class ArtikelObjek {

    String judul;
    String urlGambar;
    String linkUrl;
    String sinopsis;


    public ArtikelObjek(String judul, String urlGambar, String linkUrl, String sinopsis) {
        this.judul = judul;
        this.urlGambar = urlGambar;
        this.linkUrl = linkUrl;
        this.sinopsis = sinopsis;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setUrlGambar(String urlGambar) {
        this.urlGambar = urlGambar;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getJudul() {
        return judul;
    }

    public String getUrlGambar() {
        return urlGambar;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public String getSinopsis() {
        return sinopsis;
    }
}
