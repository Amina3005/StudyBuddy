package com.mine.virtualstudy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mine.virtualstudy.databinding.FragmentDiscoveryBinding;

public class DiscoveryFragment extends Fragment {

    private FragmentDiscoveryBinding mBinding;

    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentDiscoveryBinding.inflate(inflater, container, false);

        return mBinding.getRoot();
    }
}
