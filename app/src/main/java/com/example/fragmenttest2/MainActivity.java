package com.example.fragmenttest2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Adapter;

import com.google.android.material.tabs.TabLayout;

// https://medium.com/@droidbyme/android-material-design-tabs-tab-layout-with-swipe-884085ae80ff
// https://guides.codepath.com/android/ViewPager-with-FragmentPagerAdapter
// https://guides.codepath.com/android/creating-and-using-fragments#fragment-lifecycle
// https://github.com/udacity/ud839_ViewPager_Example/tree/quiz/app/src/main/java/com/example/android/viewpager

// https://medium.com/@droidbyme/android-material-design-tabs-tab-layout-with-swipe-884085ae80ff

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private TabAdapter mAdapter;


    private int[] tabIcons = {
            R.drawable.baseline_star_black_48,
            R.drawable.baseline_home_black_48,
            R.drawable.baseline_notifications_black_48
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(viewPager);

        // Create an adapter that knows which fragment should be shown on each page
        mAdapter = new TabAdapter(getSupportFragmentManager());

        mAdapter.addFragment(new Fragment1(), "Tab 1", tabIcons[0]);
        mAdapter.addFragment(new Fragment2(), "Tab 2", tabIcons[1]);
        mAdapter.addFragment(new Fragment3(), "Tab 3", tabIcons[2]);

        // Set the adapter onto the view pager
        viewPager.setAdapter(mAdapter);

        highLightCurrentTab(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                highLightCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void highLightCurrentTab(int position) {
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            assert tab != null;
            tab.setCustomView(null);
            tab.setCustomView(mAdapter.getTabView(i, this));
        }

        TabLayout.Tab tab = mTabLayout.getTabAt(position);
        assert tab != null;
        tab.setCustomView(null);
        tab.setCustomView(mAdapter.getSelectedTabView(position, this));
    }
}
