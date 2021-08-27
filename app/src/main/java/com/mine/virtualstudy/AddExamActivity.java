package com.mine.virtualstudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mine.virtualstudy.adapters.ExamAdapter;
import com.mine.virtualstudy.databinding.ActivityAddExamBinding;
import com.mine.virtualstudy.fragment.ChooseExamFragment;

import java.util.ArrayList;
import java.util.List;

public class AddExamActivity extends AppCompatActivity {

    private ActivityAddExamBinding mBinding;
    private Activity mActivity;

    public static void start (Activity activity) {
        Intent intent = new Intent(activity, AddExamActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityAddExamBinding.inflate(getLayoutInflater());

        setContentView(mBinding.getRoot());

        mActivity = this;

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(mBinding.containerFl.getId(), ChooseExamFragment.newInstance(), ChooseExamFragment.class.getSimpleName())
                    .commit();
        }

        getSupportFragmentManager().addOnBackStackChangedListener(() -> {
            Fragment fragment = getSupportFragmentManager().findFragmentById(mBinding.containerFl.getId());

            if (fragment.getTag().equals(ChooseExamFragment.class.getSimpleName())) {
                fragment.onResume();
            }
        });

    }
}
