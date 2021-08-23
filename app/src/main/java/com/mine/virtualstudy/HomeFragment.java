package com.mine.virtualstudy;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.mine.virtualstudy.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding mBinding;
    private GuideBookAdapter adapter;
    private HacksAdapter hacksAdapter;
    private NewsAdapter newsAdapter;
    private Activity mActivity;


    private List<Integer> list; //books
    private List<Integer> mList; //hacks
    private List<Integer> newsList;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity = getActivity();
        adapter = new GuideBookAdapter(mActivity);
        hacksAdapter = new HacksAdapter(mActivity);
        newsAdapter = new NewsAdapter(mActivity);

        initNews();
        initGuideBook();
        initHacks();

    }

    public void initNews() {
        newsList = new ArrayList<>();
        newsList.add(R.drawable.imggg);
        newsList.add(R.drawable.news2);
        newsList.add(R.drawable.news3);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false);
        mBinding.viewPager.setAdapter(newsAdapter);
    }

    public void initGuideBook() {
        list = new ArrayList<>();
        list.add(R.drawable.book1);
        list.add(R.drawable.book2);
        list.add(R.drawable.book3);
        list.add(R.drawable.book4);
        list.add(R.drawable.book5);
        list.add(R.drawable.imggg);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false);
        mBinding.recyclerView.setLayoutManager(layoutManager);
        adapter.setMyList(list);
        mBinding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void initHacks() {
        mList = new ArrayList<>();
        mList.add(R.drawable.hack1);
        mList.add(R.drawable.hack2);
        mList.add(R.drawable.hack3);
        mList.add(R.drawable.hack4);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false);
        mBinding.hacksRecyclerView.setLayoutManager(layoutManager);
        hacksAdapter.setMyList(mList);
        mBinding.hacksRecyclerView.setAdapter(hacksAdapter);
        hacksAdapter.notifyDataSetChanged();
    }

}
