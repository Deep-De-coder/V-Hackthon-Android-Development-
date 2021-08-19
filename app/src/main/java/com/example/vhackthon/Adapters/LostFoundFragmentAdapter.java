package com.example.vhackthon.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.vhackthon.Fragments.FoundFragment;
import com.example.vhackthon.Fragments.LostFragment;

public class LostFoundFragmentAdapter extends FragmentPagerAdapter {
    public LostFoundFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                FoundFragment foundFragment = new FoundFragment();
                return foundFragment;

            case 1:
                LostFragment lostFragment = new LostFragment();
                return lostFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }


    //title  for fragments
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "FOUND ITEMS";
            case 1:
                return "LOST ITEMS";

            default:
                return null;
        }
    }
}
