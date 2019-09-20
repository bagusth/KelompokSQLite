package com.example.kelompoksqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DashboardActivity extends AppCompatActivity {

    ImageView imageLihatData;
    ImageView imageInputData;
    ImageView imageInformasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        imageLihatData = findViewById(R.id.imageLihatData);
        imageInputData = findViewById(R.id.imageInputData);
        imageInformasi = findViewById(R.id.imageInformasi);

        imageLihatData.setOnClickListener(new Listener());
        imageInputData.setOnClickListener(new Listener());
        imageInformasi.setOnClickListener(new Listener());


    }

    class Listener implements View .OnClickListener{
        Intent intent;
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.imageLihatData:
                    intent = new Intent(DashboardActivity.this, ListDataActivity.class);
                    break;
                case R.id.imageInputData:
                    intent = new Intent(DashboardActivity.this, InputDataActivity.class);
                    break;
                case R.id.imageInformasi:
                    intent = new Intent(DashboardActivity.this, informasi_activity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}