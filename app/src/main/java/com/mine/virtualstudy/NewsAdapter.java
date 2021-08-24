package com.mine.virtualstudy;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.mine.virtualstudy.databinding.ItemNewsBinding;

import java.util.List;

public class NewsAdapter extends PagerAdapter {

    private Activity mActivity;
    private List<Integer> list;

    public NewsAdapter (Activity mActivity) { this.mActivity = mActivity; }

    public void setMyList(List<Integer> myList) {
        this.list = myList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull  View view, @NonNull Object object) {
        return view == ((ImageView)object);
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        ItemNewsBinding binding = ItemNewsBinding.inflate(inflater, container, false);
        Integer current = list.get(position);
        Glide.with(binding.imageView.getContext()).load(current).into(binding.imageView);
        return current;
    }
}

