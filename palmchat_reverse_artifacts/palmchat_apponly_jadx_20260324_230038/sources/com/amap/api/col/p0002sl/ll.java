package com.amap.api.col.p0002sl;

import com.ss.android.ttvecamera.TECameraResult;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ll {
    public int l;
    public boolean n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2970a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public long e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public int k = TECameraResult.TER_CLOSE_CALLED;
    public short m = 0;
    public int o = 32767;
    public int p = Integer.MAX_VALUE;
    public int q = Integer.MAX_VALUE;
    public boolean r = true;
    public int s = 99;
    public long t = 0;

    public ll(int i, boolean z) {
        this.l = i;
        this.n = z;
    }

    private String e() {
        int i = this.l;
        return this.l + "#" + this.f2970a + "#" + this.b + "#0#" + a();
    }

    private String f() {
        return this.l + "#" + this.h + "#" + this.i + "#" + this.j;
    }

    public final long a() {
        return this.l == 5 ? this.e : this.d;
    }

    public final String b() {
        int i = this.l;
        if (i != 1) {
            if (i == 2) {
                return f();
            }
            if (i != 3 && i != 4 && i != 5) {
                return null;
            }
        }
        return e();
    }

    public final String c() {
        String strB = b();
        if (strB == null || strB.length() <= 0) {
            return "";
        }
        return (this.r ? 1 : 0) + "#" + strB;
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final ll clone() {
        ll llVar = new ll(this.l, this.n);
        llVar.f2970a = this.f2970a;
        llVar.b = this.b;
        llVar.c = this.c;
        llVar.d = this.d;
        llVar.e = this.e;
        llVar.f = this.f;
        llVar.g = this.g;
        llVar.h = this.h;
        llVar.i = this.i;
        llVar.j = this.j;
        llVar.k = this.k;
        llVar.m = this.m;
        llVar.o = this.o;
        llVar.p = this.p;
        llVar.q = this.q;
        llVar.r = this.r;
        llVar.s = this.s;
        llVar.t = this.t;
        return llVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof ll)) {
            ll llVar = (ll) obj;
            int i = llVar.l;
            if (i != 1) {
                return i != 2 ? i != 3 ? i != 4 ? i == 5 && this.l == 5 && llVar.c == this.c && llVar.e == this.e && llVar.q == this.q : this.l == 4 && llVar.c == this.c && llVar.d == this.d && llVar.b == this.b : this.l == 3 && llVar.c == this.c && llVar.d == this.d && llVar.b == this.b : this.l == 2 && llVar.j == this.j && llVar.i == this.i && llVar.h == this.h;
            }
            if (this.l == 1 && llVar.c == this.c && llVar.d == this.d && llVar.b == this.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode;
        int iHashCode2;
        int iHashCode3 = String.valueOf(this.l).hashCode();
        if (this.l == 2) {
            iHashCode = String.valueOf(this.j).hashCode() + String.valueOf(this.i).hashCode();
            iHashCode2 = String.valueOf(this.h).hashCode();
        } else {
            iHashCode = String.valueOf(this.c).hashCode() + String.valueOf(this.d).hashCode();
            iHashCode2 = String.valueOf(this.b).hashCode();
        }
        return iHashCode3 + iHashCode + iHashCode2;
    }
}
