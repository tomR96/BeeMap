package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.net.URL;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.content.Intent;

public class DetailsActivity extends AppCompatActivity {

    TextView markertxt;
    TextView markerdesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        markertxt=findViewById(R.id.marker);
        String title=getIntent().getStringExtra( "title" );
        markertxt.setText(title);
        //markerdesc=findViewById(R.id.desc);
      // String desc=getIntent().getStringExtra( "desc" );
       // markerdesc.setText(desc);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("BeeApp");


        ImageButton buttonCall = findViewById(R.id.btnCall);
        buttonCall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:123456789"));
                startActivity(intent);
            }
        });
        ImageButton simpleImageButton = (ImageButton)findViewById(R.id.Button);
        //Button button = findViewById(R.id.Button);
        simpleImageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToFacebookPage("localirishhoney.ie");
            }
        });
        ImageButton simpleImageButton2 = findViewById(R.id.website);
        simpleImageButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToWebsite("localirishhoney.ie");
            }
        });
        ImageButton emailbutton = findViewById(R.id.email);
        emailbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "tommyryan12@yahoo.ie"});
//need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });
    }
    private void goToFacebookPage(String id) {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wwww.facebook.com/" + id));
        startActivity(intent);

    }
    private void goToWebsite(String id) {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wwww.facebook.com/" + id));
        startActivity(intent);

    }



}