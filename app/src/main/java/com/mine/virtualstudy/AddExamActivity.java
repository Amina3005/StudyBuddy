package com.mine.virtualstudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mine.virtualstudy.adapters.ExamAdapter;
import com.mine.virtualstudy.databinding.ActivityAddExamBinding;

import java.util.ArrayList;
import java.util.List;

public class AddExamActivity extends AppCompatActivity {

    private ActivityAddExamBinding mBinding;
    private ExamAdapter adapter;
    private List<Integer> list;
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

        adapter = new ExamAdapter(mActivity);

        initExam();
    }

    private void initExam() {
        list = new ArrayList<>();
        list.add(R.drawable.ielts);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false);
        mBinding.examRv.setLayoutManager(layoutManager);
        adapter.setMyList(list);
        mBinding.examRv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
