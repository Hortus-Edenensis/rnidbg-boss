package com.beizi.ad.internal.a;

import com.beizi.ad.internal.e.n;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends com.beizi.ad.internal.b.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4357a;
    private String b;
    private String c;
    private String d;

    public String a() {
        return this.f4357a;
    }

    public long b() {
        return n.c(this.b);
    }

    public long c() {
        return n.c(this.c);
    }

    public String d() {
        return this.d;
    }

    public String toString() {
        return "{\"spaceId\":\"" + this.f4357a + "\",\"cacheTime\":\"" + this.b + "\",\"expireTime\":\"" + this.c + "\",\"requestId\":\"" + this.d + "\"}";
    }

    public void a(String str) {
        this.f4357a = str;
    }

    public void b(long j) {
        this.c = String.valueOf(j);
    }

    public void a(long j) {
        this.b = String.valueOf(j);
    }

    public void b(String str) {
        this.d = str;
    }
}
