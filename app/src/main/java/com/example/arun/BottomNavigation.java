package com.example.arun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.arun.fragments.FirstFragment;
import com.example.arun.fragments.SecondFragment;
import com.example.arun.fragments.ThirdFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigation extends AppCompatActivity {

    BottomNavigationView arun;

    Fragment firstFragment = new FirstFragment();
    Fragment secondFragment = new SecondFragment();
    Fragment thirdFragment = new ThirdFragment();

    Fragment active = thirdFragment;


    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        arun = findViewById(R.id.nav);

        fragmentManager.beginTransaction().add(R.id.frame, thirdFragment, "3").commit();
        fragmentManager.beginTransaction().add(R.id.frame, secondFragment, "2").hide(secondFragment).commit();
        fragmentManager.beginTransaction().add(R.id.frame, firstFragment, "1").hide(secondFragment).commit();


        arun.setSelectedItemId(R.id.menu_profile);

        arun.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.menu_games:
                        fragmentManager.beginTransaction().hide(active).show(firstFragment).commit();
                        active = firstFragment;
                        return true;
                    case R.id.menu_home:
                        fragmentManager.beginTransaction().hide(active).show(secondFragment).commit();
                        active = secondFragment;
                        return true;
                    case R.id.menu_profile:
                        fragmentManager.beginTransaction().hide(active).show(thirdFragment).commit();
                        active = thirdFragment;
                        return true;
                }

                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}