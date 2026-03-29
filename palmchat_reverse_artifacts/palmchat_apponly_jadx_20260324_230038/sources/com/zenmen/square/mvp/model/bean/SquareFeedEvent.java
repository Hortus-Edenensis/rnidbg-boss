package com.zenmen.square.mvp.model.bean;

import defpackage.ds0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareFeedEvent implements ds0.a {
    public static final int EVENT_ADD = 1;
    public static final int EVENT_ADD_MARK = 4;
    public static final int EVENT_DELETE = 3;
    public static final int EVENT_UPDATE = 2;
    public int eventType;
    public SquareFeed feed;
}
