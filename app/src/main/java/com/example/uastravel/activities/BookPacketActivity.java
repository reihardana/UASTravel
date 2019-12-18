package com.example.uastravel.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uastravel.R;
import com.squareup.picasso.Picasso;

public class BookPacketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_packet);
        TextView nama, lokasi, harga, pay;
        ImageView gambar;
        String namaPaket = getIntent().getStringExtra("NAMA_PAKET");
        String lokasiPaket = getIntent().getStringExtra("LOKASI_PAKET");
        String hargaPaket = getIntent().getStringExtra("HARGA_PAKET");
        String gambarPaket = getIntent().getStringExtra("GAMBAR_PAKET");

        nama = findViewById(R.id.bookNama);
        lokasi = findViewById(R.id.bookLokasi);
        harga = findViewById(R.id.bookHarga);
        gambar = findViewById(R.id.bookGambar);
        pay = findViewById(R.id.pay);

        nama.setText(namaPaket);
        lokasi.setText(lokasiPaket);
        harga.setText(hargaPaket);
        pay.setText("Booking " + hargaPaket);
        Picasso.get().load(gambarPaket).into(gambar);
    }
}
