package com.example.hilman.wisatalombok;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;




public class artikel extends ActionBarActivity {


    private WebView wv1;
    String paket;
    String judul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel);

        paket =(String) getIntent().getCharSequenceExtra("Paket");
        judul =(String) getIntent().getCharSequenceExtra("Judul");
        setTitle(judul);

        String url = paket;

        wv1=(WebView)findViewById(R.id.webView);
        wv1.setWebViewClient(new MyBrowser());




        wv1.getSettings().setLoadsImagesAutomatically(true);
      //  wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv1.getSettings().setBuiltInZoomControls(true);

        wv1.getSettings().setBuiltInZoomControls(true);
        wv1.getSettings().setSupportZoom(true);

        wv1.loadUrl(url);



    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }


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
