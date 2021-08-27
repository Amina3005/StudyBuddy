package com.mine.virtualstudy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mine.virtualstudy.databinding.FragmentExamsBinding;

public class ExamsFragment extends Fragment {

    private FragmentExamsBinding mBinding;


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentExamsBinding.inflate(inflater, container, false);

        return mBinding.getRoot();
    }
}
