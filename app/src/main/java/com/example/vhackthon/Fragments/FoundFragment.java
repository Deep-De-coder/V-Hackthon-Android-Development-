package com.example.vhackthon.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vhackthon.Adapters.LostFoundItemAdapter;
import com.example.vhackthon.GetterSetterClasses.LostFoundItem;
import com.example.vhackthon.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class FoundFragment extends Fragment {

    RecyclerView recyclerView;


    //array list of lostfounditem
    ArrayList<LostFoundItem> list;

    //database reference
    DatabaseReference reference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_found, container, false);
        recyclerView = view.findViewById(R.id.rv);

        //database reference
        reference = FirebaseDatabase.getInstance().getReference().child("LostFoundItem");

        return view;
    }



    @Override
    public void onStart() {
        super.onStart();
        Query checkType=reference.orderByChild("type").equalTo("found");
        checkType.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    list = new ArrayList<>();
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        list.add(ds.getValue(LostFoundItem.class));
                    }
                    LostFoundItemAdapter adapterClass = new LostFoundItemAdapter(list);
                    recyclerView.setAdapter(adapterClass);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}