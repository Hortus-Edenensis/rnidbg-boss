package com.baidu.location.c;

import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3505a = 0;
    public String b = null;
    public String c = null;
    public int d = 0;
    public long e = 0;
    public int f = Integer.MAX_VALUE;
    public int g = Integer.MAX_VALUE;

    public String toString() {
        return String.format(Locale.CHINA, "%d,%s,%s,%d,%d,%d", Integer.valueOf(this.f3505a), this.b, this.c, Integer.valueOf(this.d), Long.valueOf(this.e), Integer.valueOf(this.f));
    }
}
