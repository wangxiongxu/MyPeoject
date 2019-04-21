package com.wangxu.example.wnag.geeknews.bean;

import java.io.Serializable;

//王旭 1808
public class FramhtmlBean implements Serializable  {
    private String tuPianurl;
    private String title;
    private String pingLun;
    private String xinXi;

    public FramhtmlBean(String tuPianurl, String title, String pingLun, String xinXi) {
        this.tuPianurl = tuPianurl;
        this.title = title;
        this.pingLun = pingLun;
        this.xinXi = xinXi;
    }

    public FramhtmlBean() {
    }

    public String getTuPianurl() {
        return tuPianurl;
    }

    public void setTuPianurl(String tuPianurl) {
        this.tuPianurl = tuPianurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPingLun() {
        return pingLun;
    }

    public void setPingLun(String pingLun) {
        this.pingLun = pingLun;
    }

    public String getXinXi() {
        return xinXi;
    }

    public void setXinXi(String xinXi) {
        this.xinXi = xinXi;
    }

    @Override
    public String toString() {
        return "FramhtmlBean{" +
                "tuPianurl='" + tuPianurl + '\'' +
                ", title='" + title + '\'' +
                ", pingLun='" + pingLun + '\'' +
                ", xinXi='" + xinXi + '\'' +
                '}';
    }
}
