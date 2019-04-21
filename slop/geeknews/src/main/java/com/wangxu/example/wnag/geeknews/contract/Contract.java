package com.wangxu.example.wnag.geeknews.contract;

import com.wangxu.example.wnag.geeknews.base.BaseView;

public interface Contract {
    interface View extends BaseView {
        void getIfView();
    }
    interface ZhuHuView extends BaseView {
        void getIfView();
    }
    interface WechatView extends BaseView {
        void getIfView();
    }
    interface VtexView extends BaseView {
        void getIfView();
    }
}
