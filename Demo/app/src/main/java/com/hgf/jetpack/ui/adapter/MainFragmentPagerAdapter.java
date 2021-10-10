package com.hgf.jetpack.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

/**
 * @author :huangguofeng
 * date    :2020/7/21
 * package :com.hgf.jetpack.ui.adapter
 * desc    :
 */
public class MainFragmentPagerAdapter extends FragmentStateAdapter {
    private List<Fragment> fragments;
    private Context context;

    public MainFragmentPagerAdapter(FragmentActivity fragmentActivity, List<Fragment> fragment) {
        super(fragmentActivity);
        fragments = fragment;
        context = fragmentActivity;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
