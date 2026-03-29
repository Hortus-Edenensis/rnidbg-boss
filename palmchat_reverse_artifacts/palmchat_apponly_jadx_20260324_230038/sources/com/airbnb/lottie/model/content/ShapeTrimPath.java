package com.airbnb.lottie.model.content;

import defpackage.dd;
import defpackage.ko0;
import defpackage.np0;
import defpackage.q16;
import defpackage.u83;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ShapeTrimPath implements np0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2523a;
    public final Type b;
    public final dd c;
    public final dd d;
    public final dd e;
    public final boolean f;

    /* JADX INFO: compiled from: SearchBox */
    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i);
        }
    }

    public ShapeTrimPath(String str, Type type, dd ddVar, dd ddVar2, dd ddVar3, boolean z) {
        this.f2523a = str;
        this.b = type;
        this.c = ddVar;
        this.d = ddVar2;
        this.e = ddVar3;
        this.f = z;
    }

    @Override // defpackage.np0
    public ko0 a(u83 u83Var, com.airbnb.lottie.model.layer.a aVar) {
        return new q16(aVar, this);
    }

    public dd b() {
        return this.d;
    }

    public String c() {
        return this.f2523a;
    }

    public dd d() {
        return this.e;
    }

    public dd e() {
        return this.c;
    }

    public Type f() {
        return this.b;
    }

    public boolean g() {
        return this.f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.c + ", end: " + this.d + ", offset: " + this.e + "}";
    }
}
