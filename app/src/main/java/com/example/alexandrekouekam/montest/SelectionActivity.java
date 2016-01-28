package com.example.alexandrekouekam.montest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class SelectionActivity extends Activity implements AdapterView.OnItemClickListener {

    private ListView listView;
    public static final String LISTE = "liste";
    private int category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        listView = (ListView) findViewById(R.id.liste);
        listView.setOnItemClickListener(this);

        selectList( getIntent().getExtras().getInt(LISTE));
    }

    private void selectList(int liste) {
        category = liste;
        String[] list = getResources().getStringArray(getResources().getIdentifier("listeb"+ liste,"array",getPackageName()));
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.element,list);
        listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void accueil(View view){
        Intent intent = new Intent(this, AccueilActivity.class);
        startActivity(intent);
    }

    public void articleAV(View view){
       // Intent intent = new Intent(this, SelectionActivity.class);
       // startActivity(intent);
        selectList(1);
        int pos = 1;
    }

    public void articleC(View view){
        // Intent intent = new Intent(this, SelectionActivity.class);
        // startActivity(intent);
        selectList(2);
        int pos = 2;
    }
    public void articleW(View view){
        // Intent intent = new Intent(this, SelectionActivity.class);
        // startActivity(intent);
        selectList(3);
        int pos = 3;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ArticlesActivity.class);
        Bundle b = new Bundle();
        b.putInt("article.html", position+category*3-3); //Your id
        intent.putExtras(b); //Put your id to your next Intent
        startActivity(intent);
        finish();
    }


/*
    public void onClickGrand(View view){
        ImageView ImageView = (ImageView) findViewById(R.id.ImageView);
        ImageView.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
    }*/
}
