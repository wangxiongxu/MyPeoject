package com.wangxu.example.wnag.geeknews.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView> {
   protected BaseView baseView;
   protected ArrayList<BaseModel> list=new ArrayList<>();
    public void getLong(V baseView) {
        this.baseView=baseView;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void onDestroy() {
        if (list.size() > 0) {
            for (BaseModel baseModel : list) {
                baseModel.onDestroy();
            }
            list.clear();
        }
    }
}
