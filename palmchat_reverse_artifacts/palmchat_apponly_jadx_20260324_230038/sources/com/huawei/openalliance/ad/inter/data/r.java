package com.huawei.openalliance.ad.inter.data;

import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class r {
    private final Set<String> Code;
    private String I;
    private final int V;
    private String Z;

    public r(Set<String> set, int i, String str, String str2) {
        this.Code = set;
        this.V = i;
        this.I = str;
        this.Z = str2;
    }

    public final Set<String> Code() {
        return this.Code;
    }

    public String I() {
        return this.I;
    }

    public final int V() {
        return this.V;
    }

    public String Z() {
        return this.Z;
    }
}
