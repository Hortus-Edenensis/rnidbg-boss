package com.zenmen.palmchat.router;

import defpackage.yn2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public enum PagerRouterManager {
    mInstance;

    private yn2 router;

    public static yn2 getRouter() {
        return mInstance.router;
    }

    public static void init(yn2 yn2Var) {
        mInstance.router = yn2Var;
    }
}
