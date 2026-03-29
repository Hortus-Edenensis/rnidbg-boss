package com.opos.exoplayer.core.text.ttml;

import android.text.Layout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class TtmlStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8347a;
    private int b;
    private boolean c;
    private int d;
    private boolean e;
    private int f = -1;
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private int j = -1;
    private float k;
    private String l;
    private TtmlStyle m;
    private Layout.Alignment n;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    public int a() {
        int i = this.h;
        if (i == -1 && this.i == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.i == 1 ? 2 : 0);
    }

    public TtmlStyle b(int i) {
        this.d = i;
        this.e = true;
        return this;
    }

    public TtmlStyle c(int i) {
        this.j = i;
        return this;
    }

    public TtmlStyle d(boolean z) {
        com.opos.exoplayer.core.util.a.b(this.m == null);
        this.i = z ? 1 : 0;
        return this;
    }

    public int e() {
        if (this.c) {
            return this.b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public boolean f() {
        return this.c;
    }

    public int g() {
        if (this.e) {
            return this.d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public boolean h() {
        return this.e;
    }

    public String i() {
        return this.l;
    }

    public Layout.Alignment j() {
        return this.n;
    }

    public int k() {
        return this.j;
    }

    public float l() {
        return this.k;
    }

    public TtmlStyle a(float f) {
        this.k = f;
        return this;
    }

    public TtmlStyle b(String str) {
        this.l = str;
        return this;
    }

    public TtmlStyle c(boolean z) {
        com.opos.exoplayer.core.util.a.b(this.m == null);
        this.h = z ? 1 : 0;
        return this;
    }

    public String d() {
        return this.f8347a;
    }

    public TtmlStyle a(int i) {
        com.opos.exoplayer.core.util.a.b(this.m == null);
        this.b = i;
        this.c = true;
        return this;
    }

    public TtmlStyle b(boolean z) {
        com.opos.exoplayer.core.util.a.b(this.m == null);
        this.g = z ? 1 : 0;
        return this;
    }

    public boolean c() {
        return this.g == 1;
    }

    public TtmlStyle a(Layout.Alignment alignment) {
        this.n = alignment;
        return this;
    }

    public boolean b() {
        return this.f == 1;
    }

    public TtmlStyle a(TtmlStyle ttmlStyle) {
        return a(ttmlStyle, true);
    }

    private TtmlStyle a(TtmlStyle ttmlStyle, boolean z) {
        if (ttmlStyle != null) {
            if (!this.c && ttmlStyle.c) {
                a(ttmlStyle.b);
            }
            if (this.h == -1) {
                this.h = ttmlStyle.h;
            }
            if (this.i == -1) {
                this.i = ttmlStyle.i;
            }
            if (this.f8347a == null) {
                this.f8347a = ttmlStyle.f8347a;
            }
            if (this.f == -1) {
                this.f = ttmlStyle.f;
            }
            if (this.g == -1) {
                this.g = ttmlStyle.g;
            }
            if (this.n == null) {
                this.n = ttmlStyle.n;
            }
            if (this.j == -1) {
                this.j = ttmlStyle.j;
                this.k = ttmlStyle.k;
            }
            if (z && !this.e && ttmlStyle.e) {
                b(ttmlStyle.d);
            }
        }
        return this;
    }

    public TtmlStyle a(String str) {
        com.opos.exoplayer.core.util.a.b(this.m == null);
        this.f8347a = str;
        return this;
    }

    public TtmlStyle a(boolean z) {
        com.opos.exoplayer.core.util.a.b(this.m == null);
        this.f = z ? 1 : 0;
        return this;
    }
}
