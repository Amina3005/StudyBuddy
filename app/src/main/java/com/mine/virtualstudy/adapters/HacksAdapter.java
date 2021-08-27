package com.mine.virtualstudy.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mine.virtualstudy.databinding.ItemHacksBinding;

import java.util.List;

public class  HacksAdapter extends RecyclerView.Adapter<HacksAdapter.ViewHolder> {

    private Activity mActivity;
    private List<Integer> list;

    public HacksAdapter (Activity mActivity) { this.mActivity = mActivity; }


    public void setMyList(List<Integer> myList) {
        this.list = myList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemHacksBinding binding = ItemHacksBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Integer current = list.get(position);
        Glide.with(holder.mBinding.cardImage.getContext()).load(current).into(holder.mBinding.cardImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemHacksBinding mBinding;

        public ViewHolder(@NonNull ItemHacksBinding binding) {
            super(binding.getRoot());

            mBinding = binding;
        }
    }
}
