package com.example.uastravel.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.uastravel.R;
import com.example.uastravel.activities.BookPacketActivity;
import com.example.uastravel.classes.Paket;
import com.example.uastravel.classes.PaketViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaketWisata extends Fragment {
    DatabaseReference mDatabase;
    FirebaseRecyclerAdapter<Paket, PaketViewHolder> mAdapter;
    RecyclerView mRecycler;
    LinearLayoutManager mManager;
    // Required empty public constructor

    public PaketWisata() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmPaent
        View view = inflater.inflate(R.layout.fragment_paket_wisata, container, false);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mRecycler = view.findViewById(R.id.list_paket);
        mRecycler.setHasFixedSize(true);

        mManager = new LinearLayoutManager(getContext());
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);
        Query query = getQuery(mDatabase);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Paket>()
                .setQuery(query, Paket.class).build();

        mAdapter = new FirebaseRecyclerAdapter<Paket, PaketViewHolder>(options) {
            @Override
            public PaketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new PaketViewHolder(inflater.inflate(R.layout.item_paket, parent, false));
            }

            @Override
            protected void onBindViewHolder(@NonNull PaketViewHolder paketViewHolder, int i, @NonNull Paket paket) {
                paketViewHolder.bindToPaket(paket, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), BookPacketActivity.class);
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
        Query query = mDatabase.child("paket");
        return query;
    }

}
