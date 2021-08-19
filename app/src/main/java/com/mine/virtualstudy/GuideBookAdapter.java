package com.mine.virtualstudy;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.mine.virtualstudy.databinding.ItemGuideBinding;

import java.util.List;

public class GuideBookAdapter extends RecyclerView.Adapter<GuideBookAdapter.ViewHolder>{

    private Activity mActivity;
    private RequestManager mGlide;

    public GuideBookAdapter (Activity mActivity, RequestManager mGlide) {
        this.mActivity = mActivity;
        this.mGlide = mGlide;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemGuideBinding binding = ItemGuideBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(GuideBookAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemGuideBinding mBinding;

        public ViewHolder(@NonNull ItemGuideBinding binding) {
            super(binding.getRoot());

            mBinding = binding;
        }
    }
}