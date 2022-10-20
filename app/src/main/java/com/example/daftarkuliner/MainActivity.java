package com.example.daftarkuliner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView reckuliner;
    private ArrayList<Kuliner> listKuliner;
    private KulinerAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reckuliner = findViewById(R.id.rec_kuliner);

        initData();
        setOnclickListener();

        reckuliner.setAdapter(new KulinerAdapter(listKuliner, listener));
        reckuliner.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setOnclickListener() {
        listener = new KulinerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("Gambar", listKuliner.get(position).getId_gambar());
                intent.putExtra("Nama", listKuliner.get(position).getNama());
                intent.putExtra("Deskripsi", listKuliner.get(position).getDeskripsi());
                intent.putExtra("Harga", listKuliner.get(position).getHarga());

                startActivity(intent);
            }
        };
    }

    private void initData() {
        this.listKuliner = new ArrayList<>();
        listKuliner.add(new Kuliner(R.drawable.pecel, "Pecel Lele", "15.000", "Nasi dengan lele yang di goreng dan disajikan dengan sambal."));
        listKuliner.add(new Kuliner(R.drawable.nasi, "Nasi Goreng Mercon", "14.500", "Nasi yang digoreng yang dicampur dengan minyak, cabai rawit, dan bumbu lainnya."));
        listKuliner.add(new Kuliner(R.drawable.ayam, "Ayam Geprek Keju", "20.000", "Ayam yang digeprek yang ditambahi keju."));
        listKuliner.add(new Kuliner(R.drawable.kari, "Kari Ayam", "17.500", "Daging ayam yang dierbus dalam bawang bombai, saus berbahan dasar tomat dan bumbu lainnya."));
        listKuliner.add(new Kuliner(R.drawable.tahu, "Tahu Bulat", "500", "Kacang kedelai yang dibuat menjadi sebuah tahu berbentuk bulat dengan isi kopong."));
        listKuliner.add(new Kuliner(R.drawable.salad, "Salad Buah", "12.000", "Makan yang terdiri dari buah-buahan yang dicampur dengan bahan lain seperti yogurt, keju , dll."));
    }

}