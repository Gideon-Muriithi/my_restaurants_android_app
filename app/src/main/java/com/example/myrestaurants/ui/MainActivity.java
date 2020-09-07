package com.example.myrestaurants.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myrestaurants.Constants;
import com.example.myrestaurants.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.find_restaurant_button)  Button findRestaurantsButton;
    @BindView(R.id.user_input) EditText locationEditText;
    @BindView(R.id.restaurants_textView)  TextView restaurantsTextView;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;


    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
        restaurantsTextView.setTypeface(ostrichFont);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        findRestaurantsButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view == findRestaurantsButton) {
            String location = locationEditText.getText().toString();

            if(!(location).equals("")) {
                addToSharedPreferences(location);
            }

            Intent intent = new Intent(MainActivity.this, Restaurants.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }

    private void addToSharedPreferences(String location) {
        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
    }
}