package com.example.uastravel.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uastravel.R;
import com.example.uastravel.activities.BookHotelActivity;
import com.example.uastravel.classes.Hotel;
import com.example.uastravel.classes.HotelViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelFragment extends Fragment {
    DatabaseReference mDatabase;
    FirebaseRecyclerAdapter<Hotel, HotelViewHolder> mAdapter;
    RecyclerView mRecycler;
    LinearLayoutManager mManager;
    // Required empty public constructor

    public HotelFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmPaent
        View view = inflater.inflate(R.layout.fragment_hotel, container, false);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mRecycler = view.findViewById(R.id.list_hotel);
        mRecycler.setHasFixedSize(true);

        mManager = new LinearLayoutManager(getContext());
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);
        Query query = getQuery(mDatabase);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Hotel>()
                .setQuery(query, Hotel.class).build();

        mAdapter = new FirebaseRecyclerAdapter<Hotel, HotelViewHolder>(options) {
            @Override
            public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new HotelViewHolder(inflater.inflate(R.layout.item_hotel, parent, false));
            }

            @Override
            protected void onBindViewHolder(@NonNull HotelViewHolder hotelViewHolder, int i, @NonNull final Hotel hotel) {
                hotelViewHolder.bindToHotel(hotel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), BookHotelActivity.class);
                        intent.putExtra("NAMA_HOTEL", hotel.nama);
                        intent.putExtra("LOKASI_HOTEL", hotel.lokasi);
                        intent.putExtra("HARGA_HOTEL", hotel.harga);
                        intent.putExtra("GAMBAR_HOTEL", hotel.gambar);
                        startActivity(intent);
                    }
                });
            }
        };

        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAdapter != null) {
            mAdapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }

    private Query getQuery(DatabaseReference mDatabase) {
        Query query = mDatabase.child("hotel");
        return query;
    }

}
