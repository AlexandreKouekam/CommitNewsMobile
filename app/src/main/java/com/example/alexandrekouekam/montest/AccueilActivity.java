package com.example.alexandrekouekam.montest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;


public class AccueilActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        Bundle b = getIntent().getExtras();
        WebView lWebView = (WebView)findViewById(R.id.webView);
        lWebView.getSettings().setJavaScriptEnabled(true);
        lWebView.loadUrl("file:///android_asset/accueil.html");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickButton(View view){
        Intent intent = new Intent(this, SelectionActivity.class);
        startActivity(intent);
    }

    public void articleAV(View view){
        Intent intent = new Intent(this, SelectionActivity.class);
        intent.putExtra(SelectionActivity.LISTE,1);
        startActivity(intent);
        finish();
    }

    public void articleC(View view){
        Intent intent = new Intent(this, SelectionActivity.class);
        intent.putExtra(SelectionActivity.LISTE,2);
        startActivity(intent);
        finish();
    }

    public void articleW(View view){
        Intent intent = new Intent(this, SelectionActivity.class);
        intent.putExtra(SelectionActivity.LISTE,3);
        startActivity(intent);
        finish();
    }

    public void accueil(View view){
        Intent intent = new Intent(this, AccueilActivity.class);
        startActivity(intent);
    }


}
