package com.example.uastravel.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.uastravel.R;
import com.example.uastravel.activities.ProfileActivity;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ImageView logout, booked, hotel, homePkt1, homePkt2, homePkt3, homePkt4;
    private FirebaseAuth auth;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        logout = view.findViewById(R.id.logout);
        booked = view.findViewById(R.id.booked);
        homePkt1 = view.findViewById(R.id.homePkt1);
        homePkt2 = view.findViewById(R.id.homePkt2);
        homePkt3 = view.findViewById(R.id.homePkt3);
        homePkt4 = view.findViewById(R.id.homePkt4);

        hotel = view.findViewById(R.id.hotel);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ProfileActivity.class));
            }
        });
        booked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ProfileActivity.class));
            }
        });
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ProfileActivity.class));
            }
        });
        homePkt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new PaketWisata();

            }
        });
        return view;
    }
}
