package com.wangxu.example.wnag.geeknews.presenter;

import com.wangxu.example.wnag.geeknews.base.BasePresenter;
import com.wangxu.example.wnag.geeknews.contract.Contract;
import com.wangxu.example.wnag.geeknews.model.Model;
import com.wangxu.example.wnag.geeknews.model.WechatModel;

public class WechatPresenter extends BasePresenter<Contract.WechatView>{
    Contract.WechatView view;
    @Override
    protected void initModel() {
        WechatModel wechatModel = new WechatModel();
        list.add(wechatModel);
    }


    public void getPrensenter() {

    }
}
