package com.example.uastravel.classes;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uastravel.R;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class HotelViewHolder extends RecyclerView.ViewHolder {
    StorageReference storageReference = FirebaseStorage.getInstance().getReference();
    public TextView txt_nama;
    public TextView txt_harga;
    public TextView txt_lokasi;
    public CircleImageView url_gambar;
    public CardView card_htl;

    public HotelViewHolder(View itemView) {
        super(itemView);
        txt_nama = itemView.findViewById(R.id.namaHotel);
        txt_harga = itemView.findViewById(R.id.hargaHotel);
        txt_lokasi = itemView.findViewById(R.id.lokasiHotel);
        url_gambar = itemView.findViewById(R.id.gambarHotel);
        card_htl = itemView.findViewById(R.id.cardHotel);
    }

    public void bindToHotel (Hotel hotel, View.OnClickListener onClickListener) {
        txt_nama.setText(hotel.nama);
        txt_harga.setText(hotel.harga);
        txt_lokasi.setText(hotel.lokasi);
        Picasso.get().load(hotel.gambar).into(url_gambar);
        card_htl.setOnClickListener(onClickListener);
    }
}
