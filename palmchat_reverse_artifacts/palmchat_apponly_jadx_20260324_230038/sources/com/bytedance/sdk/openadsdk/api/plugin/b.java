package com.bytedance.sdk.openadsdk.api.plugin;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends Exception {
    private final int u;

    public b(int i, String str) {
        super(str);
        this.u = i;
    }

    public int u() {
        return this.u;
    }

    public b(int i, String str, Throwable th) {
        super(str, th);
        this.u = i;
    }
}
