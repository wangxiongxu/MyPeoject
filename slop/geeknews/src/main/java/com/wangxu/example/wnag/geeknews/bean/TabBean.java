package com.wangxu.example.wnag.geeknews.bean;

public class TabBean {
    private String tab;
    private String url;

    public TabBean(String tab, String url) {
        this.tab = tab;
        this.url = url;
    }

    public TabBean() {
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "TabBean{" +
                "tab='" + tab + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
