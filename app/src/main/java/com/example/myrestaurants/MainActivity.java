package com.example.myrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.find_restaurant_button)  Button findRestaurantsButton;
    @BindView(R.id.user_input) EditText locationEditText;
    @BindView(R.id.restaurants_textView)  TextView restaurantsTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
        restaurantsTextView.setTypeface(ostrichFont);

        findRestaurantsButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == findRestaurantsButton) {
            //                Toast.makeText(MainActivity.this, "By Gideon", Toast.LENGTH_LONG).show();

            String location = locationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, profile_page.class);
            intent.putExtra("location", location);
            startActivity(intent);

//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_SEND);
//                intent.putExtra(Intent.EXTRA_TEXT, "Working");
//                intent.setType("text/plain");
//                startActivity(intent);
        }
    }
}