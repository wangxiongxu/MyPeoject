package com.wangxu.example.wnag.geeknews.presenter;

import com.wangxu.example.wnag.geeknews.base.BasePresenter;
import com.wangxu.example.wnag.geeknews.contract.Contract;
import com.wangxu.example.wnag.geeknews.model.Model;

public class Presenter extends BasePresenter<Contract.View>{
    Contract.View view;
    @Override
    protected void initModel() {
        Model model = new Model();
        list.add(model);
    }


    public void getPrensenter() {

    }
}
