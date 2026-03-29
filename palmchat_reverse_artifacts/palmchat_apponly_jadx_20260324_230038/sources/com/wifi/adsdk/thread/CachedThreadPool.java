package com.wifi.adsdk.thread;

import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class CachedThreadPool {
    public void execute(Runnable runnable) {
        Executors.newCachedThreadPool().execute(runnable);
    }
}
