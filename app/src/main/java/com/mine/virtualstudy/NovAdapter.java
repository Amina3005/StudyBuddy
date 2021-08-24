package com.mine.virtualstudy;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mine.virtualstudy.databinding.ItemHacksBinding;
import com.mine.virtualstudy.databinding.ItemNewsBinding;

import java.util.List;

public class NovAdapter extends RecyclerView.Adapter<NovAdapter.ViewHolder> {

    private Activity mActivity;
    private List<Integer> list;

    public NovAdapter (Activity mActivity) { this.mActivity = mActivity; }


    public void setMyList(List<Integer> myList) {
        this.list = myList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemNewsBinding binding = ItemNewsBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Integer current = list.get(position);
        Glide.with(holder.mBinding.imageView.getContext()).load(current).into(holder.mBinding.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemNewsBinding mBinding;

        public ViewHolder(@NonNull ItemNewsBinding binding) {
            super(binding.getRoot());

            mBinding = binding;
        }
    }

}
