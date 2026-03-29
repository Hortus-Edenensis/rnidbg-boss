package com.tide.host.a;

import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class i0 extends b0 {
    public i0(int i, int i2, int i3, long j, String str, String str2) {
        this(i, str, str2);
        a("duration", Long.valueOf(j));
        a("result", Integer.valueOf(i2));
        a("code", Integer.valueOf(i3));
    }

    public i0(int i, String str, String str2) {
        super(str, (HashMap) null);
        a("upgrade_ver_code", Integer.valueOf(i));
        a("from", str2);
    }
}
