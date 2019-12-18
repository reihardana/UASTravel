package com.example.uastravel.classes;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uastravel.R;

public class PaketViewHolder extends RecyclerView.ViewHolder {
    public TextView txt_nama;
    public TextView txt_harga;
    public TextView txt_lokasi;
    public CardView card_pkt;

    public PaketViewHolder(View itemView) {
        super(itemView);
        txt_nama = itemView.findViewById(R.id.namaPaket);
        txt_harga = itemView.findViewById(R.id.hargaPaket);
        txt_lokasi = itemView.findViewById(R.id.lokasiPaket);
        card_pkt = itemView.findViewById(R.id.cardPaket);
    }

    public void bindToPaket (Paket paket, View.OnClickListener onClickListener) {
        txt_nama.setText(paket.nama);
        txt_harga.setText(paket.harga);
        txt_lokasi.setText(paket.lokasi);
        card_pkt.setOnClickListener(onClickListener);
    }
}
