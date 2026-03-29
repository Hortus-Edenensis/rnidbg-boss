package com.qq.e.comm.util;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f10448a;
    private final StringBuilder b = new StringBuilder();
    private long c;

    public void a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f10448a;
        this.c += jElapsedRealtime;
        StringBuilder sb = this.b;
        sb.append(jElapsedRealtime);
        sb.append(",");
    }

    public void b() {
        a();
        c();
    }

    public void c() {
        this.f10448a = SystemClock.elapsedRealtime();
    }

    public String toString() {
        int length = this.b.length();
        if (length <= 0) {
            return "";
        }
        StringBuilder sbDeleteCharAt = this.b.deleteCharAt(length - 1);
        sbDeleteCharAt.append(":");
        sbDeleteCharAt.append(this.c);
        return sbDeleteCharAt.toString();
    }
}
