package com.example.myrestaurants.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myrestaurants.models.Restaurant;
import com.example.myrestaurants.ui.RestaurantDetailFragment;

import java.util.ArrayList;

public class RestaurantsPagerAdapter extends FragmentStateAdapter {
    private ArrayList<Restaurant> mRestaurants;

    public RestaurantsPagerAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<Restaurant> restaurants) {
        super(fragmentActivity);
        mRestaurants = restaurants;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return RestaurantDetailFragment.newInstance(mRestaurants.get(position));
    }

    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return mRestaurants.get(position).getName();
//    }
//

}