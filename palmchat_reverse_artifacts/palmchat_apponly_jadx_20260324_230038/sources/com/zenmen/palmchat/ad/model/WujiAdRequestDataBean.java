package com.zenmen.palmchat.ad.model;

import com.zenmen.palmchat.ad.model.WifiAdRequestDataBean;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class WujiAdRequestDataBean implements Serializable {
    private WifiAdRequestDataBean.AppInfo appInfo;
    private int channelId;
    private String clientReqId;
    private int di;
    private WifiAdRequestDataBean.ExtInfo extInfo;
    private int limit;
    private int pos;
    private String template;

    public WifiAdRequestDataBean.AppInfo getAppInfo() {
        return this.appInfo;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public String getClientReqId() {
        return this.clientReqId;
    }

    public int getDi() {
        return this.di;
    }

    public WifiAdRequestDataBean.ExtInfo getExtInfo() {
        return this.extInfo;
    }

    public int getLimit() {
        return this.limit;
    }

    public int getPos() {
        return this.pos;
    }

    public String getTemplate() {
        return this.template;
    }

    public WujiAdRequestDataBean setAppInfo(WifiAdRequestDataBean.AppInfo appInfo) {
        this.appInfo = appInfo;
        return this;
    }

    public void setChannelId(int i) {
        this.channelId = i;
    }

    public void setClientReqId(String str) {
        this.clientReqId = str;
    }

    public void setDi(int i) {
        this.di = i;
    }

    public WujiAdRequestDataBean setExtInfo(WifiAdRequestDataBean.ExtInfo extInfo) {
        this.extInfo = extInfo;
        return this;
    }

    public void setLimit(int i) {
        this.limit = i;
    }

    public void setPos(int i) {
        this.pos = i;
    }

    public void setTemplate(String str) {
        this.template = str;
    }
}
