package com.mine.virtualstudy.adapters;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.mine.virtualstudy.databinding.ItemGuideBinding;

import java.util.List;

public class GuideBookAdapter extends RecyclerView.Adapter<GuideBookAdapter.ViewHolder>{

    private Activity mActivity;
    private List<Integer> list;

    public GuideBookAdapter (Activity mActivity) {
        this.mActivity = mActivity;
    }

    public void setMyList(List<Integer> myList) {
        this.list = myList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemGuideBinding binding = ItemGuideBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(GuideBookAdapter.ViewHolder holder, int position) {
        Integer current = list.get(position);
        Glide.with(holder.mBinding.cardImage.getContext()).load(current).into(holder.mBinding.cardImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemGuideBinding mBinding;

        public ViewHolder(@NonNull ItemGuideBinding binding) {
            super(binding.getRoot());

            mBinding = binding;
        }
    }
}
