package com.wangxu.example.wnag.geeknews.fragerment;

import android.view.View;
import android.widget.Toast;

import com.wangxu.example.wnag.geeknews.R;
import com.wangxu.example.wnag.geeknews.base.BasePresenter;
import com.wangxu.example.wnag.geeknews.basefrager.BaseFrager;

public class Fraggank extends BaseFrager {
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int initFlater() {
        return R.layout.layout_gank;
    }

    public void getFkeng(String query) {
        Toast.makeText(getContext(),"a"+query,Toast.LENGTH_SHORT).show();
    }
}
