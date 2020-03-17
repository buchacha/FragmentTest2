package com.example.fragmenttest2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

// https://medium.com/@droidbyme/android-material-design-tabs-tab-layout-with-swipe-884085ae80ff
// https://guides.codepath.com/android/ViewPager-with-FragmentPagerAdapter
// https://guides.codepath.com/android/creating-and-using-fragments#fragment-lifecycle
// https://github.com/udacity/ud839_ViewPager_Example/tree/quiz/app/src/main/java/com/example/android/viewpager

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        // Create an adapter that knows which fragment should be shown on each page
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);
    }
}
