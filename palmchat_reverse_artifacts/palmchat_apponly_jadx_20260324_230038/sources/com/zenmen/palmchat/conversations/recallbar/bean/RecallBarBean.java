package com.zenmen.palmchat.conversations.recallbar.bean;

import defpackage.ir5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class RecallBarBean {
    private String actionUrl;
    private String button;
    private long expireTime;
    private String icon;
    private String text;
    private int type;

    public String getActionUrl() {
        return this.actionUrl;
    }

    public String getButton() {
        return this.button;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getText() {
        return this.text;
    }

    public int getType() {
        return this.type;
    }

    public boolean isExpire() {
        return ir5.c(true) > this.expireTime;
    }

    public void setActionUrl(String str) {
        this.actionUrl = str;
    }

    public void setButton(String str) {
        this.button = str;
    }

    public void setExpireTime(long j) {
        this.expireTime = j;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
