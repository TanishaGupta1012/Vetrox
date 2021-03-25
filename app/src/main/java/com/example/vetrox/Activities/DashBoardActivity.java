package com.example.vetrox.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.VolumeShaper;
import android.media.session.MediaSessionManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vetrox.R;

import java.util.Locale;

public class DashBoardActivity extends AppCompatActivity {
    Button btn_consult, btn_buy_product, changeLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoadLocale();
        setContentView(R.layout.activity_dash_board);

        btn_consult = findViewById(R.id.btn_consult);
        btn_buy_product = findViewById(R.id.btn_buy_product);
        changeLanguage = findViewById(R.id.changeLanguage);

        btn_consult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoardActivity.this,ConsultNowActivity.class));
            }
        });

        btn_buy_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoardActivity.this,BuyProductActivity.class));
            }
        });
        
        changeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("hi");
                recreate();
                setLocale("en");
                recreate();
                setLocale("hi");
                recreate();
            }
        });

    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("settings",MODE_PRIVATE).edit();
        editor.putString("my_lang",lang);
        editor.apply();

    }

    public void LoadLocale(){
        SharedPreferences sharedPreferences = getSharedPreferences("settings", Activity.MODE_PRIVATE);
        String language = sharedPreferences.getString("my_lang","");
        setLocale(language);
    }
}
