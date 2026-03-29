package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import defpackage.dd;
import defpackage.jk4;
import defpackage.ko0;
import defpackage.np0;
import defpackage.rd;
import defpackage.u83;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class PolystarShape implements np0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2520a;
    public final Type b;
    public final dd c;
    public final rd<PointF, PointF> d;
    public final dd e;
    public final dd f;
    public final dd g;
    public final dd h;
    public final dd i;
    public final boolean j;
    public final boolean k;

    /* JADX INFO: compiled from: SearchBox */
    public enum Type {
        STAR(1),
        POLYGON(2);

        private final int value;

        Type(int i) {
            this.value = i;
        }

        public static Type forValue(int i) {
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, dd ddVar, rd<PointF, PointF> rdVar, dd ddVar2, dd ddVar3, dd ddVar4, dd ddVar5, dd ddVar6, boolean z, boolean z2) {
        this.f2520a = str;
        this.b = type;
        this.c = ddVar;
        this.d = rdVar;
        this.e = ddVar2;
        this.f = ddVar3;
        this.g = ddVar4;
        this.h = ddVar5;
        this.i = ddVar6;
        this.j = z;
        this.k = z2;
    }

    @Override // defpackage.np0
    public ko0 a(u83 u83Var, com.airbnb.lottie.model.layer.a aVar) {
        return new jk4(u83Var, aVar, this);
    }

    public dd b() {
        return this.f;
    }

    public dd c() {
        return this.h;
    }

    public String d() {
        return this.f2520a;
    }

    public dd e() {
        return this.g;
    }

    public dd f() {
        return this.i;
    }

    public dd g() {
        return this.c;
    }

    public rd<PointF, PointF> h() {
        return this.d;
    }

    public dd i() {
        return this.e;
    }

    public Type j() {
        return this.b;
    }

    public boolean k() {
        return this.j;
    }

    public boolean l() {
        return this.k;
    }
}
