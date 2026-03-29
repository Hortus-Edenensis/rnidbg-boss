package com.opos.cmn.module.ui.c.b;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8073a;
    private boolean b;
    private Object[] c;

    public b(String str, boolean z, Object[] objArr) {
        this.f8073a = str;
        this.b = z;
        this.c = objArr;
    }

    public String a() {
        return this.f8073a;
    }

    public boolean b() {
        return this.b;
    }

    public Object[] c() {
        return this.c;
    }

    public String toString() {
        return "ToastParams{pkgName='" + this.f8073a + "', gbClick=" + this.b + ", objects=" + Arrays.toString(this.c) + '}';
    }
}
