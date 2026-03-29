package com.xiaomi.push;

import com.xiaomi.push.hw;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ht {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ia f11636a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ij f826a;

    public ht() {
        this(new hw.a());
    }

    public void a(hq hqVar, byte[] bArr) {
        try {
            this.f826a.a(bArr);
            hqVar.a(this.f11636a);
        } finally {
            this.f11636a.k();
        }
    }

    public ht(ic icVar) {
        ij ijVar = new ij();
        this.f826a = ijVar;
        this.f11636a = icVar.a(ijVar);
    }
}
