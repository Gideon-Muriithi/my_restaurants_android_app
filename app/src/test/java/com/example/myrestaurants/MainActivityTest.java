package com.example.myrestaurants;

import android.os.Build;
import android.widget.TextView;

import com.example.myrestaurants.ui.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;


@RunWith(RobolectricTestRunner.class)
@Config(maxSdk = Build.VERSION_CODES.P)

public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
//        activity = ActivityTestRule(MainActivity.class)

    }

    @Test
    public void validateTextViewContent() {
        TextView appNameTextView = activity.findViewById(R.id.restaurants_textView);
        assertEquals("My Restaurants", appNameTextView.getText().toString());
    }
}
