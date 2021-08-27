package com.mine.virtualstudy.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mine.virtualstudy.databinding.ItemExamsBinding;

import java.util.List;

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ViewHolder> {

    private Activity mActivity;
    private List<Integer> list;

    public ExamAdapter (Activity mActivity) {
        this.mActivity = mActivity;
    }

    public void setMyList(List<Integer> myList) {
        this.list = myList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemExamsBinding binding = ItemExamsBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Integer current = list.get(position);
        Glide.with(holder.mBinding.cardImage.getContext()).load(current).into(holder.mBinding.cardImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemExamsBinding mBinding;

        public ViewHolder(@NonNull ItemExamsBinding binding) {
            super(binding.getRoot());

            mBinding = binding;
        }
    }
}
