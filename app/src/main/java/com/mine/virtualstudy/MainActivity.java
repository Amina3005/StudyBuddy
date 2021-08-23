package com.mine.virtualstudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.mine.virtualstudy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Activity mActivity;
    private ActivityMainBinding mBinding;
    private FragmentManager mFragmentManager;
    private Fragment fragment;

    public static void start (Activity activity) {
        Intent intent = new Intent(activity,MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        getSupportActionBar().hide();

        mFragmentManager = getSupportFragmentManager();

        mFragmentManager.beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        mBinding.bottomNavigation.setSelectedItemId(R.id.nav_home);
        mBinding.bottomNavigation.setOnItemSelectedListener(navListener);

        fragment = mFragmentManager.findFragmentById(R.id.fragment_container);
        if (mFragmentManager != null) {
            if (fragment instanceof HomeFragment) {
                mFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
            } else if (fragment instanceof ExamsFragment) {
                mFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
            } else if (fragment instanceof ProfileFragment) {
                mFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        } else
            mFragmentManager.beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }

    // bottom nav listener
    private NavigationBarView.OnItemSelectedListener navListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.nav_home:
                    fragment = new HomeFragment();
                    break;
                case R.id.nav_exam:
                    fragment = new ExamsFragment();
                    break;
                case R.id.nav_profile:
                    fragment = new ProfileFragment();
            }

            mFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;

        }
    };

    @Override
    public void onBackPressed() {
        FirebaseAuth.getInstance().signOut();
        super.onBackPressed();
    }
}