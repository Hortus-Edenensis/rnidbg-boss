package com.amap.api.col.p0002sl;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class kk implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2944a;
    public String b;
    public int c;
    public int d;
    public long e;
    public long f;
    public int g;
    public boolean h;
    public boolean i;

    public kk() {
        this.f2944a = "";
        this.b = "";
        this.c = 99;
        this.d = Integer.MAX_VALUE;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.i = true;
    }

    private static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            ku.a(e);
            return 0;
        }
    }

    @Override // 
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract kk clone();

    public final int b() {
        return a(this.f2944a);
    }

    public final int c() {
        return a(this.b);
    }

    public String toString() {
        return "AmapCell{mcc=" + this.f2944a + ", mnc=" + this.b + ", signalStrength=" + this.c + ", asulevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newapi=" + this.i + '}';
    }

    public final void a(kk kkVar) {
        this.f2944a = kkVar.f2944a;
        this.b = kkVar.b;
        this.c = kkVar.c;
        this.d = kkVar.d;
        this.e = kkVar.e;
        this.f = kkVar.f;
        this.g = kkVar.g;
        this.h = kkVar.h;
        this.i = kkVar.i;
    }

    public kk(boolean z, boolean z2) {
        this.f2944a = "";
        this.b = "";
        this.c = 99;
        this.d = Integer.MAX_VALUE;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.h = z;
        this.i = z2;
    }
}
