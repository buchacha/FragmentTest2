package com.example.fragmenttest2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    public MyFragmentPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Bundle args = new Bundle();
        args.putInt("POS", position + 1);

        if (position == 0) {
            Fragment fragment = new Fragment1();
            fragment.setArguments(args);
            return fragment;
        } else if (position == 1){
            Fragment fragment = new Fragment2();
            fragment.setArguments(args);
            return fragment;
        } else {
            Fragment fragment = new Fragment3();
            fragment.setArguments(args);
            return fragment;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }

}
