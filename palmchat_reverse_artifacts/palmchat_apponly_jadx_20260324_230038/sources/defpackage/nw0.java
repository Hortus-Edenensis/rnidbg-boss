package defpackage;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class nw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f19629a;
    public final String b;
    public final List<byte[]> c;
    public final String d;
    public Integer e;
    public Integer f;
    public Object g;
    public final int h;
    public final int i;
    public String j;

    public nw0(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public List<byte[]> a() {
        return this.c;
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.d;
    }

    public Object d() {
        return this.g;
    }

    public byte[] e() {
        return this.f19629a;
    }

    public int f() {
        return this.h;
    }

    public int g() {
        return this.i;
    }

    public String h() {
        return this.b;
    }

    public boolean i() {
        return this.h >= 0 && this.i >= 0;
    }

    public void j(String str) {
        this.j = str;
    }

    public void k(Integer num) {
        this.f = num;
    }

    public void l(Integer num) {
        this.e = num;
    }

    public void m(Object obj) {
        this.g = obj;
    }

    public nw0(byte[] bArr, String str, List<byte[]> list, String str2, int i, int i2) {
        this.f19629a = bArr;
        this.b = str;
        this.c = list;
        this.d = str2;
        this.h = i2;
        this.i = i;
    }
}
