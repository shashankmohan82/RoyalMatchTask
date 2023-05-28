package com.task.royalmatch;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import java.util.Objects;

public class FrontendFragment extends Fragment implements BottomNavigationRoyal.OnNavigationItemSelectedListener{

    private BottomNavigationRoyal mBottomNavigationView;
    private ViewPager2 mViewPager2;
    private FragmentPagerAdapter mFragmentPagerAdapter;
    private MenuItem previousMenuItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_frontend, container, false);


        mBottomNavigationView = v.findViewById(R.id.nav_view);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();

        mViewPager2 = v.findViewById(R.id.viewpager);

        mBottomNavigationView.setCircleColor(Color.TRANSPARENT);
        mBottomNavigationView.setDarkIcon(true);
//        mBottomNavigationView.backgroundShape = BottomNavigationView.Sha.RoundedRectangle;
        // Object of ViewPager2Adapter
        // this will passes the
        // context to the constructor
        // of ViewPager2Adapter
        //ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this);

        // adding the adapter to viewPager2
        // to show the views in recyclerview
        if(mViewPager2 == null){
            Log.d("pager","null");
        }
        mViewPager2.setAdapter(new FragmentPagerAdapter(this));


        Log.d("mBottomNav",mBottomNavigationView.getMenu().size()+"");


        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (previousMenuItem != null) {
                    previousMenuItem.setChecked(false);
                }
                else {
                    mBottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                mBottomNavigationView.getMenu().getItem(position).setChecked(true);
                previousMenuItem = mBottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        return v;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment selectedFragment = null;

        if(item.getItemId() == R.id.navigation_home){
            mViewPager2.setCurrentItem(0);
        }
        else if(item.getItemId() == R.id.navigation_dashboard){
            mViewPager2.setCurrentItem(1);
        }
        else if(item.getItemId() == R.id.navigation_notifications){
            mViewPager2.setCurrentItem(2);
        }
        return false;
    }

}
