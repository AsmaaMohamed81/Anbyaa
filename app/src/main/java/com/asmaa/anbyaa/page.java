package com.asmaa.anbyaa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class page extends AppCompatActivity {
WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        web =(WebView)findViewById(R.id.web);

        Intent data= getIntent();
        int page = data.getExtras().getInt("page");
        page++;
        web.loadUrl("file:///android_asset/a"+page+".html");
    }
}
