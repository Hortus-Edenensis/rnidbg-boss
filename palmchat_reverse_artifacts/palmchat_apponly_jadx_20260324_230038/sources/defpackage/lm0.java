package defpackage;

import javax.net.SocketFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class lm0 {
    public String c;
    public int d;
    public SocketFactory f;
    public String g;
    public String h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f19029a = 240000;
    public long b = 720000;
    public boolean e = true;

    public lm0(String str, int i) {
        f(str, i);
    }

    public String a() {
        return this.c;
    }

    public long b() {
        return this.f19029a;
    }

    public long c() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public SocketFactory e() {
        return this.f;
    }

    public final void f(String str, int i) {
        this.c = str;
        this.d = i;
        this.f = new ld1();
    }

    public void g(String str, String str2, String str3) {
        this.g = str;
        this.h = str3;
    }

    public void h(long j, long j2) {
        this.f19029a = j;
        this.b = j2;
    }
}
