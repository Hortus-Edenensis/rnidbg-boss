package com.bytedance.pangle.log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u {
    private long b;
    private String fx;
    private String nr;
    private long pn;
    private String u;

    private u(String str, String str2, String str3) {
        this.u = str;
        this.nr = str2;
        this.fx = str3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.pn = jCurrentTimeMillis;
        this.b = jCurrentTimeMillis;
        ZeusLogger.i(this.u, this.nr + String.format(" watcher[%s]-start", str3));
    }

    public static u u(String str, String str2, String str3) {
        return new u(str, str2, str3);
    }

    public long u(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.pn;
        long jCurrentTimeMillis2 = System.currentTimeMillis() - this.b;
        ZeusLogger.i(this.u, this.nr + String.format(" watcher[%s]-%s cost=%s, total=%s", this.fx, str, Long.valueOf(jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis2)));
        return jCurrentTimeMillis2;
    }

    public long u() {
        return System.currentTimeMillis() - this.b;
    }
}
