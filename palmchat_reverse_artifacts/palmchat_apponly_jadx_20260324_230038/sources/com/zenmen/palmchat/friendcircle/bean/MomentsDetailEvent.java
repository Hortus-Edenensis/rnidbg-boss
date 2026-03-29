package com.zenmen.palmchat.friendcircle.bean;

import com.zenmen.palmchat.greendao.model.Feed;
import defpackage.ds0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class MomentsDetailEvent implements ds0.a {
    public static final int EVENT_ADD = 1;
    public static final int EVENT_DELETE = 3;
    public static final int EVENT_PUBLISH = 0;
    public static final int EVENT_UPDATE = 2;
    public int eventType;
    public Feed feed;
    public Long feedId;
}
