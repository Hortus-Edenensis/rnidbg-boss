package com.heytap.msp.mobad.api;

import com.opos.mobad.f.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ProxyManager {
    private static volatile e sAdManager;

    private ProxyManager() {
    }

    public static e getInstance() {
        if (sAdManager == null) {
            synchronized (ProxyManager.class) {
                if (sAdManager == null) {
                    sAdManager = new e();
                }
            }
        }
        return sAdManager;
    }
}
