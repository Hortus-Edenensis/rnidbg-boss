package com.zenmen.palmchat.circle.bean;

import defpackage.ds0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleWarnEvent implements ds0.a {
    public String content;
    public String roomId;
    public String toUid;

    public CircleWarnEvent(String str, String str2, String str3) {
        this.roomId = str;
        this.toUid = str2;
        this.content = str3;
    }
}
