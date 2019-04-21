package com.wangxu.example.wnag.geeknews.presenter;

import com.wangxu.example.wnag.geeknews.base.BasePresenter;
import com.wangxu.example.wnag.geeknews.contract.Contract;
import com.wangxu.example.wnag.geeknews.model.Model;
import com.wangxu.example.wnag.geeknews.model.ZhiHuModel;

public class ZhuHuPresenter extends BasePresenter<Contract.ZhuHuView>{
    Contract.View view;
    private ZhiHuModel model;

    @Override
    protected void initModel() {
        model = new ZhiHuModel();
        list.add(model);
    }


    public void getPrensenter() {

    }
}
