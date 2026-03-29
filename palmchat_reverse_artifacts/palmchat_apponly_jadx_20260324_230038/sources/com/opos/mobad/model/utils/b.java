package com.opos.mobad.model.utils;

import android.os.SystemClock;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Long> f9108a = new ConcurrentHashMap();
    private Map<String, Integer> b = new ConcurrentHashMap();

    public void a(String str) {
        this.f9108a.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
    }

    public boolean b(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Long l = this.f9108a.get(str);
        Long lValueOf = Long.valueOf(l != null ? l.longValue() : 0L);
        Integer num = this.b.get(str);
        return jElapsedRealtime >= lValueOf.longValue() + ((long) Integer.valueOf(num != null ? num.intValue() : 0).intValue());
    }

    public void a(String str, int i) {
        this.b.put(str, Integer.valueOf(i));
    }
}
