package com.zenmen.palmchat.circle.bean;

import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class CircleNoticeList {
    private List<CircleNoticeItem> detailVOList;

    public List<CircleNoticeItem> getDetailVOList() {
        return this.detailVOList;
    }

    public void setDetailVOList(List<CircleNoticeItem> list) {
        this.detailVOList = list;
    }
}
