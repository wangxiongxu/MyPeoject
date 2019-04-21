package com.wangxu.example.wnag.geeknews.basefrager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangxu.example.wnag.geeknews.base.BasePresenter;
import com.wangxu.example.wnag.geeknews.base.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFrager<V extends BaseView,P extends BasePresenter> extends Fragment implements BaseView{

    protected P basePresenter;
    private Unbinder bind;
    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(initFlater(), null);
        bind = ButterKnife.bind(this,inflate);
        basePresenter = initPresenter();
        if (basePresenter != null) {
            basePresenter.getLong((V)this);
        }
        initView(inflate);
        return inflate;

    }

    protected abstract P initPresenter();

    protected abstract void initView(View view) ;

    protected abstract int initFlater();

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
        if (basePresenter != null) {
            basePresenter=null;
        }

    }
}
