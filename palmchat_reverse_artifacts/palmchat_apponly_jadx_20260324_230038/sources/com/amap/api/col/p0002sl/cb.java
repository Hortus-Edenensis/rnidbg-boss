package com.amap.api.col.p0002sl;

import android.graphics.PointF;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class cb implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2667a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final boolean f;
    public PointF g;
    public int h;
    public boolean i;
    private String j;

    public cb(int i, int i2, int i3, int i4) {
        this.f2667a = 0;
        this.h = -1;
        this.i = false;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = !cs.a(i, i2, i3);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public cb clone() {
        return new cb(this);
    }

    public final void a() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append("-");
        sb.append(this.c);
        sb.append("-");
        sb.append(this.d);
        if (this.f && z.i == 1) {
            sb.append("-1");
        }
        this.j = sb.toString();
    }

    public final String b() {
        return this.j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cb)) {
            return false;
        }
        cb cbVar = (cb) obj;
        return this.b == cbVar.b && this.c == cbVar.c && this.d == cbVar.d && this.e == cbVar.e;
    }

    public final int hashCode() {
        return (this.b * 7) + (this.c * 11) + (this.d * 13) + this.e;
    }

    public final String toString() {
        return this.b + "-" + this.c + "-" + this.d + "-" + this.e;
    }

    public cb(cb cbVar) {
        this.f2667a = 0;
        this.h = -1;
        this.i = false;
        this.b = cbVar.b;
        this.c = cbVar.c;
        this.d = cbVar.d;
        this.e = cbVar.e;
        this.g = cbVar.g;
        this.f2667a = cbVar.f2667a;
        this.f = !cs.a(r0, r1, r2);
        a();
    }
}
