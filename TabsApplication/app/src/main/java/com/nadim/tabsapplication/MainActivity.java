package com.nadim.tabsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton floatingActionButton;
    private TabsFragmentStatePageAdapter tabsFragmentStatePageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewPager);
        floatingActionButton = findViewById(R.id.fab);

        tabsFragmentStatePageAdapter = new TabsFragmentStatePageAdapter(getSupportFragmentManager());
        tabsFragmentStatePageAdapter.addFragment(new HomeFragment(), "Home");
        tabsFragmentStatePageAdapter.addFragment(new NewsFragment(), "News");
        tabsFragmentStatePageAdapter.addFragment(new ProfileFragment(), "Profile");

        viewPager.setAdapter(tabsFragmentStatePageAdapter);
        tabLayout.setVisibility(View.VISIBLE);
        tabLayout.setupWithViewPager(viewPager);

    }
}