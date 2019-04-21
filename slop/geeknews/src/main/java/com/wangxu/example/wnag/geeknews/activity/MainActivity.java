package com.wangxu.example.wnag.geeknews.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import com.wangxu.example.wnag.geeknews.R;
import com.wangxu.example.wnag.geeknews.base.BaseActinity;
import com.wangxu.example.wnag.geeknews.contract.Contract;
import com.wangxu.example.wnag.geeknews.fragerment.Fragabout;
import com.wangxu.example.wnag.geeknews.fragerment.Fragcollector;
import com.wangxu.example.wnag.geeknews.fragerment.Fraggank;
import com.wangxu.example.wnag.geeknews.fragerment.Fragrare;
import com.wangxu.example.wnag.geeknews.fragerment.Fragselect;
import com.wangxu.example.wnag.geeknews.fragerment.Fragsetting;
import com.wangxu.example.wnag.geeknews.fragerment.Fragvtex;
import com.wangxu.example.wnag.geeknews.fragerment.Fragwechat;
import com.wangxu.example.wnag.geeknews.fragerment.Fragzhihu;
import com.wangxu.example.wnag.geeknews.presenter.Presenter;

import java.util.ArrayList;

public class MainActivity extends BaseActinity<Presenter, Contract.View> {


    private Toolbar mTool;
    private FrameLayout mFrame;
    private LinearLayout mLl;
    private NavigationView mNa;
    private DrawerLayout mDl;
    private TextView tv;
    private ArrayList<Fragment> fragments;
    private ArrayList<Integer> integers;
    private FragmentManager fm;
    private final int ZHIHU =0;
    private final int WECHAT =1;
    private final int GANK =2;
    private final int RARE =3;
    private final int COLLECTOR =4;
    private final int SETTING =5;
    private final int ABOUT =6;
    private final int SELECT =7;
    private final int VTEX =8;

    private int lasttitle=0;
    private MaterialSearchView searchView;
    private MenuItem mSearchItem;
    private Fragwechat fragwechat;
    private Fraggank fraggank;

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initListener() {
        super.initListener();
        mNa.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() != R.id.info && item.getItemId() != R.id.select){
                    item.setChecked(true);
                    switch (item.getItemId()) {
                        case R.id.zhihu:
                            tv.setText(integers.get(ZHIHU));
                            mSearchItem.setVisible(false);
                            FragmentTransaction fragmentTransaction = fm.beginTransaction();
                            Fragment fragment = fragments.get(ZHIHU);
                            if (fragment.isAdded() == false) {
                                fragmentTransaction.add(R.id.frame,fragment);
                            }
                            fragmentTransaction.hide(fragments.get(lasttitle));
                            fragmentTransaction.show(fragment);
                            lasttitle=ZHIHU;
                            fragmentTransaction.commit();
                            break;
                        case R.id.weChat:
                            tv.setText(integers.get(WECHAT));
                            mSearchItem.setVisible(true);
                            FragmentTransaction fragmentTransaction1 = fm.beginTransaction();
                            Fragment fragment1 = fragments.get(WECHAT);
                            if (fragment1.isAdded() == false) {
                                fragmentTransaction1.add(R.id.frame,fragment1);
                            }
                            fragmentTransaction1.hide(fragments.get(lasttitle));
                            fragmentTransaction1.show(fragment1);
                            lasttitle=WECHAT;
                            fragmentTransaction1.commit();
                            break;
                        case R.id.gank:
                            tv.setText(integers.get(GANK));
                            mSearchItem.setVisible(true);
                            FragmentTransaction fragmentTransaction2 = fm.beginTransaction();
                            Fragment fragment2= fragments.get(GANK);
                            if (fragment2.isAdded() == false) {
                                fragmentTransaction2.add(R.id.frame,fragment2);
                            }
                            fragmentTransaction2.hide(fragments.get(lasttitle));
                            fragmentTransaction2.show(fragment2);
                            lasttitle=GANK;
                            fragmentTransaction2.commit();
                            break;
                        case R.id.rare:
                            tv.setText(integers.get(RARE));
                            mSearchItem.setVisible(false);
                            FragmentTransaction fragmentTransaction3 = fm.beginTransaction();
                            Fragment fragment3= fragments.get(RARE);
                            if (fragment3.isAdded() == false) {
                                fragmentTransaction3.add(R.id.frame,fragment3);
                            }
                            fragmentTransaction3.hide(fragments.get(lasttitle));
                            fragmentTransaction3.show(fragment3);
                            lasttitle=RARE;
                            fragmentTransaction3.commit();
                            break;
                        case R.id.collector:
                            tv.setText(integers.get(COLLECTOR));
                            mSearchItem.setVisible(false);
                            FragmentTransaction fragmentTransaction4 = fm.beginTransaction();
                            Fragment fragment4= fragments.get(COLLECTOR);
                            if (fragment4.isAdded() == false) {
                                fragmentTransaction4.add(R.id.frame,fragment4);
                            }
                            fragmentTransaction4.hide(fragments.get(lasttitle));
                            fragmentTransaction4.show(fragment4);
                            lasttitle=COLLECTOR;
                            fragmentTransaction4.commit();
                            break;
                        case R.id.setting:
                            tv.setText(integers.get(SETTING));
                            mSearchItem.setVisible(false);
                            FragmentTransaction fragmentTransaction5 = fm.beginTransaction();
                            Fragment fragment5= fragments.get(SETTING);
                            if (fragment5.isAdded() == false) {
                                fragmentTransaction5.add(R.id.frame,fragment5);
                            }
                            fragmentTransaction5.hide(fragments.get(lasttitle));
                            fragmentTransaction5.show(fragment5);
                            lasttitle=SETTING;
                            fragmentTransaction5.commit();
                            break;
                        case R.id.about:
                            tv.setText(integers.get(ABOUT));
                            mSearchItem.setVisible(false);
                            FragmentTransaction fragmentTransaction6 = fm.beginTransaction();
                            Fragment fragment6 = fragments.get(ABOUT);
                            if (fragment6.isAdded() == false) {
                                fragmentTransaction6.add(R.id.frame,fragment6);
                            }
                            fragmentTransaction6.hide(fragments.get(lasttitle));
                            fragmentTransaction6.show(fragment6);
                            lasttitle=ABOUT;
                            fragmentTransaction6.commit();
                            break;
                        case R.id.select:
                            tv.setText(integers.get(SELECT));
                            mSearchItem.setVisible(false);
                            FragmentTransaction fragmentTransaction7 = fm.beginTransaction();
                            Fragment fragment7 = fragments.get(SELECT);
                            if (fragment7.isAdded() == false) {
                                fragmentTransaction7.add(R.id.frame,fragment7);
                            }
                            fragmentTransaction7.hide(fragments.get(lasttitle));
                            fragmentTransaction7.show(fragment7);
                            lasttitle=SELECT;
                            fragmentTransaction7.commit();
                            break;
                        case R.id.vtex:
                            tv.setText(integers.get(VTEX));
                            mSearchItem.setVisible(false);
                            FragmentTransaction fragmentTransaction8 = fm.beginTransaction();
                            Fragment fragment8 = fragments.get(VTEX);
                            if (fragment8.isAdded() == false) {
                                fragmentTransaction8.add(R.id.frame,fragment8);
                            }
                            fragmentTransaction8.hide(fragments.get(lasttitle));
                            fragmentTransaction8.show(fragment8);
                            lasttitle=VTEX;
                            fragmentTransaction8.commit();
                            break;

                    }
                    mDl.closeDrawer(Gravity.LEFT);
                }else {
                    item.setChecked(false);
                }


                return false;
            }
        });

    }

    @Override
    protected void initView() {
        super.initView();

        mTool = (Toolbar) findViewById(R.id.tool);
        mFrame = (FrameLayout) findViewById(R.id.frame);
        mLl = (LinearLayout) findViewById(R.id.ll);
        mNa = (NavigationView) findViewById(R.id.na);
        mDl = (DrawerLayout) findViewById(R.id.dl);
        tv = (TextView)findViewById(R.id.tv);
        searchView = findViewById(R.id.search_view);
        setSupportActionBar(mTool);
    }

    @Override
    protected void initData() {
        super.initData();
        fragments = new ArrayList<>();
        fragments.add(new Fragzhihu());
        fragwechat = new Fragwechat();
        fragments.add(fragwechat);
        fraggank = new Fraggank();
        fragments.add(fraggank);
        fragments.add(new Fragrare());
        fragments.add(new Fragcollector());
        fragments.add(new Fragsetting());
        fragments.add(new Fragabout());
        fragments.add(new Fragselect());
        fragments.add(new Fragvtex());
        integers = new ArrayList<>();
        integers.add(R.string.zhihu);
        integers.add(R.string.wechat);
        integers.add(R.string.gank);
        integers.add(R.string.rare);
        integers.add(R.string.collector);
        integers.add(R.string.setting);
        integers.add(R.string.about);
        integers.add(R.string.select);
        integers.add(R.string.vtex);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDl, mTool, R.string.select, R.string.select);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.whrit));
        mDl.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        fm = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.frame,fragments.get(0));

        fragmentTransaction.commit();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuu, menu);

        mSearchItem = menu.findItem(R.id.action_search);
        searchView.setMenuItem(mSearchItem);
        mSearchItem.setVisible(false);

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //22 aif (lasttitle==)
                if (fragwechat.isVisible()) {
                    fragwechat.getFkeng(query);
                }
                if (fraggank.isVisible()) {
                    fraggank.getFkeng(query);
                }
                return false;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

}
