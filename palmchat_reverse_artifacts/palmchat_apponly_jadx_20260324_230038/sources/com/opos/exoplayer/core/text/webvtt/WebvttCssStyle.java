package com.opos.exoplayer.core.text.webvtt;

import android.text.Layout;
import com.opos.exoplayer.core.util.y;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class WebvttCssStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8353a;
    private String b;
    private List<String> c;
    private String d;
    private String e;
    private int f;
    private boolean g;
    private int h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private float o;
    private Layout.Alignment p;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    public WebvttCssStyle() {
        a();
    }

    private static int a(int i, String str, String str2, int i2) {
        if (str.isEmpty() || i == -1) {
            return i;
        }
        if (str.equals(str2)) {
            return i + i2;
        }
        return -1;
    }

    public int b() {
        int i = this.l;
        if (i == -1 && this.m == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.m == 1 ? 2 : 0);
    }

    public WebvttCssStyle c(boolean z) {
        this.m = z ? 1 : 0;
        return this;
    }

    public WebvttCssStyle d(String str) {
        this.e = y.d(str);
        return this;
    }

    public String e() {
        return this.e;
    }

    public int f() {
        if (this.g) {
            return this.f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public boolean g() {
        return this.g;
    }

    public int h() {
        if (this.i) {
            return this.h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean i() {
        return this.i;
    }

    public Layout.Alignment j() {
        return this.p;
    }

    public int k() {
        return this.n;
    }

    public float l() {
        return this.o;
    }

    public int a(String str, String str2, String[] strArr, String str3) {
        if (this.f8353a.isEmpty() && this.b.isEmpty() && this.c.isEmpty() && this.d.isEmpty()) {
            return str2.isEmpty() ? 1 : 0;
        }
        int iA = a(a(a(0, this.f8353a, str, 1073741824), this.b, str2, 2), this.d, str3, 4);
        if (iA == -1 || !Arrays.asList(strArr).containsAll(this.c)) {
            return 0;
        }
        return iA + (this.c.size() * 4);
    }

    public WebvttCssStyle b(int i) {
        this.h = i;
        this.i = true;
        return this;
    }

    public void c(String str) {
        this.d = str;
    }

    public boolean d() {
        return this.k == 1;
    }

    public WebvttCssStyle a(int i) {
        this.f = i;
        this.g = true;
        return this;
    }

    public WebvttCssStyle b(boolean z) {
        this.l = z ? 1 : 0;
        return this;
    }

    public boolean c() {
        return this.j == 1;
    }

    public WebvttCssStyle a(boolean z) {
        this.k = z ? 1 : 0;
        return this;
    }

    public void b(String str) {
        this.b = str;
    }

    public void a() {
        this.f8353a = "";
        this.b = "";
        this.c = Collections.emptyList();
        this.d = "";
        this.e = null;
        this.g = false;
        this.i = false;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.p = null;
    }

    public void a(String str) {
        this.f8353a = str;
    }

    public void a(String[] strArr) {
        this.c = Arrays.asList(strArr);
    }
}
