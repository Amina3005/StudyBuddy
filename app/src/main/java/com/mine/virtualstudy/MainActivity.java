package com.mine.virtualstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.mine.virtualstudy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Activity mActivity;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
    }

    public static void start (Activity activity) {
        Intent intent = new Intent(activity,MainActivity.class);
        activity.startActivity(intent);
    }
}