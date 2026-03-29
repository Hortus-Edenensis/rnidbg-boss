package defpackage;

import net.lingala.zip4j.headers.HeaderSignature;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class qm1 extends dr6 {
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public long g;
    public long h;
    public String i = "";

    public qm1() {
        a(HeaderSignature.END_OF_CENTRAL_DIRECTORY);
    }

    public int b() {
        return this.b;
    }

    public long c() {
        return this.h;
    }

    public long d() {
        return this.g;
    }

    public int e() {
        return this.e;
    }

    public void f(String str) {
        if (str != null) {
            this.i = str;
        }
    }

    public void g(int i) {
        this.b = i;
    }

    public void h(int i) {
        this.c = i;
    }

    public void i(long j) {
        this.h = j;
    }

    public void j(long j) {
        this.g = j;
    }

    public void k(int i) {
        this.f = i;
    }

    public void l(int i) {
        this.e = i;
    }

    public void m(int i) {
        this.d = i;
    }
}
