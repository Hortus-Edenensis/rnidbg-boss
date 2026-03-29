package com.vivo.push.util;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class h implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f11302a;

    public h(String str) {
        this.f11302a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(this.f11302a);
        thread.setDaemon(true);
        return thread;
    }
}
