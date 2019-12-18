package com.example.uastravel.classes;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Hotel {
    public String nama, lokasi, harga, gambar;

    public Hotel(){
    }

    public Hotel(String nama, String lokasi, String harga, String gambar) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.harga = harga;
        this.gambar = gambar;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("nama", nama);
        result.put("lokasi", lokasi);
        result.put("harga", harga);
        result.put("gambar", gambar);
        return result;
    }
}
