package com.example.daftarkuliner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        ImageView Foto = findViewById(R.id.FotoImg);
        TextView namaTxt = findViewById(R.id.NamaTxt);
        TextView deskTxt = findViewById(R.id.DeskTxt);
        TextView hargaTxt = findViewById(R.id.HargaTxt);

        Intent intent = getIntent();
        int image = intent.getExtras().getInt("Gambar");
        String nama = intent.getExtras().getString("Nama");
        String deskripsi = intent.getExtras().getString("Deskripsi");
        String harga = intent.getExtras().getString("Harga");

        Foto.setImageResource(image);
        namaTxt.setText(nama);
        deskTxt.setText(deskripsi);
        hargaTxt.setText(harga);
    }
}
