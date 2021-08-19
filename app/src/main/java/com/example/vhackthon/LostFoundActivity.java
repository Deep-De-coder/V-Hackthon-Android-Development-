package com.example.vhackthon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.vhackthon.Adapters.LostFoundFragmentAdapter;
import com.example.vhackthon.Adapters.LostFoundItemAdapter;
import com.example.vhackthon.GetterSetterClasses.LostFoundItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LostFoundActivity extends AppCompatActivity {

    //layouts
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    EditText title;


    //fragment pager adapter
    LostFoundFragmentAdapter lostFoundFragmentAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_lost_found);

        //layouts
        toolbar=findViewById(R.id.tool);
        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.pager);
        title = findViewById(R.id.titlename);
        title.setKeyListener(null);

        //setting toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Lost & Found");



        //fragment pager adapter
        lostFoundFragmentAdapter=new LostFoundFragmentAdapter(getSupportFragmentManager());

        viewPager.setAdapter(lostFoundFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }

}