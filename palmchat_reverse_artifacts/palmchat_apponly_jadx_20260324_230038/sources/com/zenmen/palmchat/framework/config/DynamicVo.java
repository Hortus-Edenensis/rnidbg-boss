package com.zenmen.palmchat.framework.config;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class DynamicVo {
    private boolean enable;
    private String extra;
    private String info;
    private int status;

    public String getExtra() {
        return this.extra;
    }

    public String getInfo() {
        return this.info;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
