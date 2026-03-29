package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
import defpackage.dd;
import defpackage.ed;
import defpackage.fd;
import defpackage.id;
import defpackage.kd2;
import defpackage.ko0;
import defpackage.np0;
import defpackage.u83;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class a implements np0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2524a;
    public final GradientType b;
    public final ed c;
    public final fd d;
    public final id e;
    public final id f;
    public final dd g;
    public final ShapeStroke.LineCapType h;
    public final ShapeStroke.LineJoinType i;
    public final float j;
    public final List<dd> k;

    @Nullable
    public final dd l;
    public final boolean m;

    public a(String str, GradientType gradientType, ed edVar, fd fdVar, id idVar, id idVar2, dd ddVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<dd> list, @Nullable dd ddVar2, boolean z) {
        this.f2524a = str;
        this.b = gradientType;
        this.c = edVar;
        this.d = fdVar;
        this.e = idVar;
        this.f = idVar2;
        this.g = ddVar;
        this.h = lineCapType;
        this.i = lineJoinType;
        this.j = f;
        this.k = list;
        this.l = ddVar2;
        this.m = z;
    }

    @Override // defpackage.np0
    public ko0 a(u83 u83Var, com.airbnb.lottie.model.layer.a aVar) {
        return new kd2(u83Var, aVar, this);
    }

    public ShapeStroke.LineCapType b() {
        return this.h;
    }

    @Nullable
    public dd c() {
        return this.l;
    }

    public id d() {
        return this.f;
    }

    public ed e() {
        return this.c;
    }

    public GradientType f() {
        return this.b;
    }

    public ShapeStroke.LineJoinType g() {
        return this.i;
    }

    public List<dd> h() {
        return this.k;
    }

    public float i() {
        return this.j;
    }

    public String j() {
        return this.f2524a;
    }

    public fd k() {
        return this.d;
    }

    public id l() {
        return this.e;
    }

    public dd m() {
        return this.g;
    }

    public boolean n() {
        return this.m;
    }
}
