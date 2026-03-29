package com.zenmen.palmchat.ad.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class WifiAdReqBean implements Serializable {
    private String appId;
    private String ed;
    private String et;
    private String pid;
    private String sign;
    private String st;

    public String getAppId() {
        return this.appId;
    }

    public String getEd() {
        return this.ed;
    }

    public String getEt() {
        return this.et;
    }

    public Map<String, String> getMap() {
        HashMap map = new HashMap();
        map.put("appId", getAppId());
        map.put("pid", getPid());
        map.put("ed", getEd());
        map.put("et", getEt());
        map.put("st", getSt());
        return map;
    }

    public String getPid() {
        return this.pid;
    }

    public String getSign() {
        return this.sign;
    }

    public String getSt() {
        return this.st;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setEd(String str) {
        this.ed = str;
    }

    public void setEt(String str) {
        this.et = str;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setSt(String str) {
        this.st = str;
    }
}
