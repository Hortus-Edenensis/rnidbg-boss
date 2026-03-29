package com.tide.host.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class n0 {
    public static void a(String str, String str2, int i, String str3, long j, int i2, int i3) {
        r0 r0Var = new r0(str, str2, i, str3);
        r0Var.a("duration", Long.valueOf(j));
        r0Var.a("result", Integer.valueOf(i2));
        r0Var.a("code", Integer.valueOf(i3));
        e0.a().onEvent("td_unzip_result", str, r0Var.b);
    }
}
