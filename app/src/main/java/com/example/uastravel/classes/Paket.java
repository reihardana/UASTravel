package com.example.uastravel.classes;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Paket {
    public String nama, lokasi, harga;

    public Paket(){
    }

    public Paket(String nama, String lokasi, String harga) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.harga = harga;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("nama", nama);
        result.put("lokasi", lokasi);
        result.put("harga", harga);
        return result;
    }
}
