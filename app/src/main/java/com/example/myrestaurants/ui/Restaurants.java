package com.example.myrestaurants.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrestaurants.Constants;
import com.example.myrestaurants.R;
import com.example.myrestaurants.adapters.RestaurantListAdapter;
import com.example.myrestaurants.models.Restaurant;
import com.example.myrestaurants.services.YelpService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Restaurants extends AppCompatActivity {
    @BindView(R.id.location_text_view)  TextView locationTextView;
    @BindView(R.id.textView)  TextView byName;
    @BindView(R.id.textView2)  TextView developer;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private RestaurantListAdapter mAdapter;
    public static final String TAG = Restaurants.class.getSimpleName();
    public ArrayList<Restaurant> mRestaurants = new ArrayList<>();

    private String mRecentAddress;
    private SharedPreferences mSharedPreferences;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        ButterKnife.bind(this);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");

        byName.setTypeface(typeface);
        developer.setTypeface(typeface);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        locationTextView.setText("Here are restaurants near you in zip code: " + location);

        getRestaurants(location);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentAddress = mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY, null);
        if (mRecentAddress != null) {
            getRestaurants(mRecentAddress);
        }

    }

    private void getRestaurants(String location) {
        final YelpService yelpService = new YelpService();
        YelpService.findRestaurants(location, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()) {
                    mRestaurants = yelpService.processResults(response);

                    Restaurants.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter =  new RestaurantListAdapter(getApplicationContext(), mRestaurants);
                            mRecyclerView.setAdapter(mAdapter);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Restaurants.this);
                            mRecyclerView.setLayoutManager(layoutManager);
                            mRecyclerView.setHasFixedSize(true);
                        }
                    });
                }
            }
        });
    }
}