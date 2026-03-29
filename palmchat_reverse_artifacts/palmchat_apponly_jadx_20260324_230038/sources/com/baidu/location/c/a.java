package com.baidu.location.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3471a;
    public long b;
    public int c;
    public int d;
    public int e;
    public int f;
    public long g;
    public int h;
    public char i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public String n;
    public String o;
    public String p;
    public boolean q;

    public a() {
        this.f3471a = -1;
        this.b = -1L;
        this.c = -1;
        this.d = -1;
        this.e = Integer.MAX_VALUE;
        this.f = Integer.MAX_VALUE;
        this.g = 0L;
        this.h = -1;
        this.i = '0';
        this.j = Integer.MAX_VALUE;
        this.k = false;
        this.l = 0;
        this.m = 0;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = false;
        this.g = System.currentTimeMillis();
    }

    public boolean a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.g;
        return jCurrentTimeMillis - j > 0 && jCurrentTimeMillis - j < 3000;
    }

    public boolean b() {
        return this.f3471a > -1 && this.b > 0;
    }

    public boolean c() {
        return this.f3471a == -1 && this.b == -1 && this.d == -1 && this.c == -1;
    }

    public boolean d() {
        return this.f3471a > -1 && this.b > -1 && this.d == -1 && this.c == -1;
    }

    public boolean e() {
        return this.f3471a > -1 && this.b > -1 && this.d > -1 && this.c > -1;
    }

    public a(int i, long j, int i2, int i3, int i4, char c, int i5) {
        this.e = Integer.MAX_VALUE;
        this.f = Integer.MAX_VALUE;
        this.g = 0L;
        this.j = Integer.MAX_VALUE;
        this.k = false;
        this.l = 0;
        this.m = 0;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = false;
        this.f3471a = i;
        this.b = j;
        this.c = i2;
        this.d = i3;
        this.h = i4;
        this.i = c;
        this.g = System.currentTimeMillis();
        this.j = i5;
    }

    public boolean a(a aVar) {
        if (this.f3471a != aVar.f3471a || this.b != aVar.b || this.d != aVar.d || this.c != aVar.c) {
            return false;
        }
        String str = this.o;
        if (str == null || !str.equals(aVar.o)) {
            return this.o == null && aVar.o == null;
        }
        return true;
    }

    public a(a aVar) {
        this(aVar.f3471a, aVar.b, aVar.c, aVar.d, aVar.h, aVar.i, aVar.j);
        this.g = aVar.g;
        this.n = aVar.n;
        this.l = aVar.l;
        this.p = aVar.p;
        this.m = aVar.m;
        this.o = aVar.o;
        this.k = aVar.k;
    }
}
