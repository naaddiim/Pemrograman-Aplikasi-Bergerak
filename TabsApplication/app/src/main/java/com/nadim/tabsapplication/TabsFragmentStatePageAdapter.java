package com.nadim.tabsapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabsFragmentStatePageAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> fragmentListTitle = new ArrayList<>();

    public TabsFragmentStatePageAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentListTitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentListTitle.get(position);
    }
}
