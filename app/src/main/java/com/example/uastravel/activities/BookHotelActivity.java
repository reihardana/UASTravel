package com.example.uastravel.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uastravel.R;
import com.squareup.picasso.Picasso;

public class BookHotelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_hotel);
        TextView nama, lokasi, harga, pay;
        ImageView gambar;
        String namaHotel = getIntent().getStringExtra("NAMA_HOTEL");
        String lokasiHotel = getIntent().getStringExtra("LOKASI_HOTEL");
        String hargaHotel = getIntent().getStringExtra("HARGA_HOTEL");
        String gambarHotel = getIntent().getStringExtra("GAMBAR_HOTEL");

        nama = findViewById(R.id.bNama);
        lokasi = findViewById(R.id.bLokasi);
        harga = findViewById(R.id.bHarga);
        gambar = findViewById(R.id.bGambar);
        pay = findViewById(R.id.pay);

        nama.setText(namaHotel);
        lokasi.setText(lokasiHotel);
        harga.setText(hargaHotel);
        pay.setText("Booking " + hargaHotel);
        Picasso.get().load(gambarHotel).into(gambar);
    }
}
