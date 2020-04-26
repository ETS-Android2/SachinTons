package com.adityay.sachintons.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adityay.sachintons.R;
import com.adityay.sachintons.adapters.TabAdapter;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends Fragment {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        setupTabAdapter();
        return view;
    }

    private void setupTabAdapter() {
        TabAdapter tabAdapter = new TabAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        tabAdapter.addFragment(new CenturyFragment(), "Centuries");
        tabAdapter.addFragment(new PostsFragment(), "Posts");
        tabAdapter.addFragment(new AboutFragment(), "About");

        viewPager.setAdapter(tabAdapter);
        viewPager.setOffscreenPageLimit(tabAdapter.getCount());
        tabLayout.setupWithViewPager(viewPager);
    }


    public void reloadFragment() {
        if(viewPager.getAdapter() != null) {
            Fragment fragment = (Fragment) viewPager.getAdapter().instantiateItem(viewPager, viewPager.getCurrentItem());
            fragment.onResume();
        }
    }

    public ViewPager getViewPager() {
        return viewPager;
    }

}
