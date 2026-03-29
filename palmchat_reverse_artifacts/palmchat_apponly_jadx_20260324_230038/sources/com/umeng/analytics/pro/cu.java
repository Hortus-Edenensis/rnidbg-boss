package com.umeng.analytics.pro;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class cu implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10914a;
    public final byte b;
    private final String c;
    private final boolean d;

    public cu(byte b, boolean z) {
        this.b = b;
        this.f10914a = false;
        this.c = null;
        this.d = z;
    }

    public boolean a() {
        return this.f10914a;
    }

    public String b() {
        return this.c;
    }

    public boolean c() {
        return this.b == 12;
    }

    public boolean d() {
        byte b = this.b;
        return b == 15 || b == 13 || b == 14;
    }

    public boolean e() {
        return this.d;
    }

    public cu(byte b) {
        this(b, false);
    }

    public cu(byte b, String str) {
        this.b = b;
        this.f10914a = true;
        this.c = str;
        this.d = false;
    }
}
