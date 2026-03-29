package com.bytedance.embedapplog;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c implements Callable<h> {
    private Long nr;
    private final bq u;

    public c(bq bqVar, Long l) {
        this.u = bqVar;
        this.nr = l;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public h call() {
        Future futureU = ja.u(new Callable<h>() { // from class: com.bytedance.embedapplog.c.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public h call() {
                try {
                    return c.this.u.u();
                } catch (Exception e) {
                    bg.nr("__kiteFingerTask#future call error " + e.getMessage());
                    return new h();
                }
            }
        });
        try {
            return this.nr.longValue() > 0 ? (h) futureU.get(this.nr.longValue(), TimeUnit.SECONDS) : (h) futureU.get();
        } catch (TimeoutException e) {
            bg.nr("__kiteFingerTask# collection timed out" + e.getMessage());
            return new h();
        }
    }
}
