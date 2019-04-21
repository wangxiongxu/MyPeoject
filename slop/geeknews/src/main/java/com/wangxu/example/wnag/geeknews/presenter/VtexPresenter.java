package com.wangxu.example.wnag.geeknews.presenter;

import com.wangxu.example.wnag.geeknews.base.BasePresenter;
import com.wangxu.example.wnag.geeknews.contract.Contract;
import com.wangxu.example.wnag.geeknews.model.Model;
import com.wangxu.example.wnag.geeknews.model.VtexModel;

public class VtexPresenter extends BasePresenter<Contract.VtexView>{
    Contract.VtexView vtexView;
    @Override
    protected void initModel() {
        VtexModel vtexModel = new VtexModel();
        list.add(vtexModel);
    }


    public void getPrensenter() {

    }
}
