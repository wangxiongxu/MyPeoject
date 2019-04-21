package com.wangxu.example.wnag.geeknews.adap.vtex;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.wangxu.example.wnag.geeknews.bean.FramhtmlBean;
import com.wangxu.example.wnag.geeknews.bean.TabBean;

import java.util.ArrayList;
import java.util.List;

public class VtexVpFrag extends FragmentStatePagerAdapter {
    private List<TabBean> tabBeans;
    private ArrayList<Fragment> strings;

    public VtexVpFrag(FragmentManager fm, List<TabBean> tabBeans, ArrayList<Fragment> strings) {
        super(fm);
        this.tabBeans = tabBeans;
        this.strings = strings;
    }

    @Override
    public Fragment getItem(int position) {
        return strings.get(position);
    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabBeans.get(position).getTab();
    }
}
