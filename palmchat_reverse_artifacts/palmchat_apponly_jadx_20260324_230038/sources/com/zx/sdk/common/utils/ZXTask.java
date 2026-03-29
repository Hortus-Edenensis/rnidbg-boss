package com.zx.sdk.common.utils;

import com.zx.a.I8b7.e2;
import com.zx.a.I8b7.g3;
import com.zx.a.I8b7.r3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZXTask implements Runnable {
    private a errorCallback;
    private Runnable r;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
    }

    public ZXTask(Runnable runnable, a aVar) {
        this.r = runnable;
        this.errorCallback = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Runnable runnable = this.r;
            if (runnable != null) {
                runnable.run();
            }
        } catch (Throwable th) {
            a aVar = this.errorCallback;
            if (aVar != null) {
                ((r3) aVar).f16856a.c.onMessage("MESSAGE_ON_ZXID_RECEIVED", e2.a(10008, th.getMessage()));
                StringBuilder sb = new StringBuilder();
                sb.append("ZXCore start failed: ");
                g3.a(th, sb);
            }
        }
    }
}
