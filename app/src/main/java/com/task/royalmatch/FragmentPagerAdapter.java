package com.task.royalmatch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.task.royalmatch.ui.dashboard.DashboardFragment;
import com.task.royalmatch.ui.home.HomeFragment;
import com.task.royalmatch.ui.notifications.NotificationsFragment;

public class FragmentPagerAdapter extends FragmentStateAdapter {

    private static final int mFragmentCount = 3;


    public FragmentPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){

            case 0:
                return new HomeFragment();
            case 1:
                return new DashboardFragment();
            case 2:
                return new NotificationsFragment();

        }
        return null;
    }

    @Override
    public int getItemCount() {
        return mFragmentCount;
    }
}
