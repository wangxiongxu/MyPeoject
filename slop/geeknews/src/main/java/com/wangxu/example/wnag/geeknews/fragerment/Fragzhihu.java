package com.wangxu.example.wnag.geeknews.fragerment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionButton;
import com.wangxu.example.wnag.geeknews.R;
import com.wangxu.example.wnag.geeknews.activity.RiLiActivity;
import com.wangxu.example.wnag.geeknews.base.BasePresenter;
import com.wangxu.example.wnag.geeknews.basefrager.BaseFrager;
import com.wangxu.example.wnag.geeknews.frag.zhuju.FragReMen;
import com.wangxu.example.wnag.geeknews.frag.zhuju.FragRibao;
import com.wangxu.example.wnag.geeknews.frag.zhuju.FragZhuanLan;
import com.wangxu.example.wnag.geeknews.presenter.ZhuHuPresenter;
import com.wangxu.example.wnag.geeknews.vpadap.ZhuHuVpadap;

import java.util.ArrayList;

public class Fragzhihu extends BaseFrager {
    private View view;
    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<String> strings;
    private ArrayList<Fragment> fragments;



    @Override
    protected BasePresenter initPresenter() {
        ZhuHuPresenter zhuHuPresenter = new ZhuHuPresenter();
        zhuHuPresenter.getPrensenter();
        return null;
    }



    @Override
    protected void initView(View view) {
        mTab = (TabLayout) view.findViewById(R.id.tab);
        mVp = (ViewPager) view.findViewById(R.id.vp);

        strings = new ArrayList<>();
        fragments = new ArrayList<>();
        strings.add("日报");
        strings.add("专栏");
        strings.add("热门");
        fragments.add(new FragRibao());
        fragments.add(new FragZhuanLan());
        fragments.add(new FragReMen());

        getData();
    }

    private void getData() {
        ZhuHuVpadap zhuHuVpadap = new ZhuHuVpadap(getChildFragmentManager(), strings, fragments);
        mVp.setAdapter(zhuHuVpadap);
        mTab.setupWithViewPager(mVp);

    }

    @Override
    protected int initFlater() {
        return R.layout.layout_zhihu;
    }

}
