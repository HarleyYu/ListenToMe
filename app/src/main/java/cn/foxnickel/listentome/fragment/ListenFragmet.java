package cn.foxnickel.listentome.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;
import cn.foxnickel.listentome.R;
import cn.foxnickel.listentome.adapter.ListenPagerAdapter;

/**
 * Created by Administrator on 2017/3/3.
 */

public class ListenFragmet extends Fragment {
    private View mRootView;
    private BGABanner mBanneer;
    private View mExerciseView, mExamView;
    private List<View> mViewList;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_listen, container, false);
        initPicBanner();
        initViewPager(inflater, container);
        return mRootView;
    }

    /*初始化图片Banner*/
    private void initPicBanner() {
        mBanneer = (BGABanner) mRootView.findViewById(R.id.pic_banner);
        mBanneer.setData(R.drawable.pic4, R.drawable.pic4, R.drawable.pic4);
    }

    /*初始化试题选择ViewPager*/
    private void initViewPager(LayoutInflater inflater, @Nullable ViewGroup container) {
        mViewList = new ArrayList<>();
        mExerciseView = inflater.inflate(R.layout.exercise, container, false);
        mExamView = inflater.inflate(R.layout.exam, container, false);

        mViewList.add(mExerciseView);
        mViewList.add(mExamView);

        ListenPagerAdapter listenPagerAdapter = new ListenPagerAdapter(mViewList);

        mViewPager = (ViewPager) mRootView.findViewById(R.id.viewPager);
        mViewPager.setAdapter(listenPagerAdapter);

        mTabLayout = (TabLayout) mRootView.findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
