package com.zenmen.find.bean;

import androidx.annotation.Keep;
import com.zenmen.listui.list.BaseBean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
@Keep
public class CheckDriftBean implements BaseBean {
    public String buyOptions;
    public boolean enoughBean;
    public long expireSeconds = 86400;
    public String freeContentTip;
    public int freeCount;
    public boolean freeStatus;
    public int priceBean;
    public boolean tipStatus;
    public int unlockBy;
    public int vipLevel;
    public String vipText;

    public int getValidHour() {
        return (int) (this.expireSeconds / 3600);
    }
}
