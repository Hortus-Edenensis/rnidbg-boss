package com.baidu.platform.comapi.util;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4235a;

    public b(String str) {
        this.f4235a = "BaiduMapSDK-" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f4235a);
    }
}
