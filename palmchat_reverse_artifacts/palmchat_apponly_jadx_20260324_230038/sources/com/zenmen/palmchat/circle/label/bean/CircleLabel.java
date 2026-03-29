package com.zenmen.palmchat.circle.label.bean;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class CircleLabel {
    public static final int FROM_GROUP_MINE = 1;
    public static final int FROM_GROUP_RECOMMEND = 2;
    public int curGroup;
    public String id;
    public boolean isChoose;
    public boolean isShowDel;
    public String labelName;
    public int originGroup;

    public CircleLabel(String str) {
        this.labelName = str;
    }
}
