package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import defpackage.cd;
import defpackage.dd;
import defpackage.fd;
import defpackage.ko0;
import defpackage.np0;
import defpackage.ql5;
import defpackage.u83;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ShapeStroke implements np0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2521a;

    @Nullable
    public final dd b;
    public final List<dd> c;
    public final cd d;
    public final fd e;
    public final dd f;
    public final LineCapType g;
    public final LineJoinType h;
    public final float i;
    public final boolean j;

    /* JADX INFO: compiled from: SearchBox */
    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i = a.f2522a[ordinal()];
            return i != 1 ? i != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i = a.b[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2522a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            b = iArr;
            try {
                iArr[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f2522a = iArr2;
            try {
                iArr2[LineCapType.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2522a[LineCapType.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2522a[LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ShapeStroke(String str, @Nullable dd ddVar, List<dd> list, cd cdVar, fd fdVar, dd ddVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f, boolean z) {
        this.f2521a = str;
        this.b = ddVar;
        this.c = list;
        this.d = cdVar;
        this.e = fdVar;
        this.f = ddVar2;
        this.g = lineCapType;
        this.h = lineJoinType;
        this.i = f;
        this.j = z;
    }

    @Override // defpackage.np0
    public ko0 a(u83 u83Var, com.airbnb.lottie.model.layer.a aVar) {
        return new ql5(u83Var, aVar, this);
    }

    public LineCapType b() {
        return this.g;
    }

    public cd c() {
        return this.d;
    }

    public dd d() {
        return this.b;
    }

    public LineJoinType e() {
        return this.h;
    }

    public List<dd> f() {
        return this.c;
    }

    public float g() {
        return this.i;
    }

    public String h() {
        return this.f2521a;
    }

    public fd i() {
        return this.e;
    }

    public dd j() {
        return this.f;
    }

    public boolean k() {
        return this.j;
    }
}
