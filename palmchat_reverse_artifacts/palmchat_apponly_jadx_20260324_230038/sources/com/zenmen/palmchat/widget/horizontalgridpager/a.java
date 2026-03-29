package com.zenmen.palmchat.widget.horizontalgridpager;

import android.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16031a;
    public int[] b;
    public int[] c;
    public int d;
    public boolean e;
    public int[] f;
    public int g;
    public int h;
    public int i;

    /* JADX INFO: renamed from: com.zenmen.palmchat.widget.horizontalgridpager.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C1146a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16032a = 10;
        public int[] b = {5, 5, 5, 5};
        public int[] c = {R.drawable.presence_invisible, R.drawable.presence_online};
        public int d = 17;
        public int e = 0;
        public int[] f = {3, 4};
        public int g = 50;
        public boolean h = true;
        public int i;

        public a j() {
            return new a(this);
        }

        public C1146a k(int i, int i2) {
            int[] iArr = this.f;
            iArr[0] = i;
            iArr[1] = i2;
            return this;
        }

        public C1146a l(int i) {
            this.d = i;
            return this;
        }

        public C1146a m(int i, int i2, int i3, int i4) {
            int[] iArr = this.b;
            iArr[0] = i;
            iArr[1] = i2;
            iArr[2] = i3;
            iArr[3] = i4;
            return this;
        }

        public C1146a n(int i, int i2) {
            int[] iArr = this.c;
            iArr[0] = i;
            iArr[1] = i2;
            return this;
        }

        public C1146a o(int i) {
            this.f16032a = i;
            return this;
        }

        public C1146a p(boolean z) {
            this.h = z;
            return this;
        }

        public C1146a q(int i) {
            this.g = i;
            return this;
        }

        public C1146a r(int i) {
            this.i = i;
            return this;
        }
    }

    public int[] a() {
        return this.f;
    }

    public int b() {
        return this.d;
    }

    public int[] c() {
        return this.b;
    }

    public int[] d() {
        return this.c;
    }

    public int e() {
        return this.f16031a;
    }

    public int f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public int h() {
        return this.i;
    }

    public boolean i() {
        return this.e;
    }

    public a(C1146a c1146a) {
        this.f16031a = c1146a.f16032a;
        this.b = c1146a.b;
        this.c = c1146a.c;
        this.d = c1146a.d;
        this.g = c1146a.e;
        this.f = c1146a.f;
        this.h = c1146a.g;
        this.e = c1146a.h;
        this.i = c1146a.i;
    }
}
