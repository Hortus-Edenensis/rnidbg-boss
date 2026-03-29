package com.zenmen.square.mvp.model.bean;

import android.text.TextUtils;
import com.zenmen.listui.list.BaseBean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareBean implements BaseBean {
    public String bottomTips;
    public String reqId;
    public SquareUserPostStatisticsBean squareUserPostStatisticsBean;

    public boolean isBottomTip() {
        return !TextUtils.isEmpty(this.bottomTips);
    }
}
