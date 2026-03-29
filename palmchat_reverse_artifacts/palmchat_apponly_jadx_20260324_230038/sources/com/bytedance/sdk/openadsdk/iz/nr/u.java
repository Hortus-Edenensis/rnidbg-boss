package com.bytedance.sdk.openadsdk.iz.nr;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private int nr = 0;
    public Map<Integer, Long> u = new ConcurrentHashMap();

    public boolean b(int i) {
        return i == this.nr;
    }

    public void fx(int i) {
        if (u(i)) {
            return;
        }
        this.nr |= i;
        try {
            this.u.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
        } catch (Exception unused) {
        }
    }

    public Long nr(int i) {
        try {
            if (u(i)) {
                return this.u.get(Integer.valueOf(i));
            }
        } catch (Exception unused) {
        }
        return -1L;
    }

    public void u() {
        this.nr = 0;
        try {
            this.u.clear();
        } catch (Exception unused) {
        }
    }

    public boolean u(int i) {
        return (this.nr & i) == i;
    }
}
