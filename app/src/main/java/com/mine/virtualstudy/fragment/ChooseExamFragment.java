package com.mine.virtualstudy.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mine.virtualstudy.R;
import com.mine.virtualstudy.adapters.ExamAdapter;
import com.mine.virtualstudy.databinding.FragmentChooseExamBinding;

import java.util.ArrayList;
import java.util.List;

public class ChooseExamFragment extends Fragment {

    private FragmentChooseExamBinding mBinding;
    private ExamAdapter mAdapter;
    private Activity mActivity;
    private List<Integer> list;

    public static ChooseExamFragment newInstance() {
        ChooseExamFragment fragment = new ChooseExamFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mBinding = FragmentChooseExamBinding.inflate(getLayoutInflater());

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity = getActivity();

        initExams();
    }

    private void initExams() {
        mAdapter = new ExamAdapter(mActivity);

        list = new ArrayList<>();
        list.add(R.drawable.ielts);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false);
        mBinding.examRv.setLayoutManager(layoutManager);
        mAdapter.setMyList(list);
        mBinding.examRv.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
