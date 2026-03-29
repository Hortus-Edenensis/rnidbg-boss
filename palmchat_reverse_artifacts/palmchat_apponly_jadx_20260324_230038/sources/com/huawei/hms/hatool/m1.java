package com.huawei.hms.hatool;

import defpackage.pm1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class m1 {
    private static m1 b = new m1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f6777a = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f6778a;
        String b;
        long c = 0;

        public a() {
        }

        public void a(long j) {
            m1.this.f6777a.c = j;
        }

        public void b(String str) {
            m1.this.f6777a.f6778a = str;
        }

        public void a(String str) {
            m1.this.f6777a.b = str;
        }
    }

    public static m1 d() {
        return b;
    }

    public long b() {
        return this.f6777a.c;
    }

    public String c() {
        return this.f6777a.f6778a;
    }

    public String a() {
        return this.f6777a.b;
    }

    public void a(String str, String str2) {
        long jB = b();
        String strC = w0.c(str, str2);
        if (strC == null || strC.isEmpty()) {
            v.e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (jB == 0) {
            jB = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - jB <= com.heytap.mcssdk.constant.a.g) {
            return;
        }
        String strD = pm1.d(16);
        String strA = h0.a(strC, strD);
        this.f6777a.a(jB);
        this.f6777a.b(strD);
        this.f6777a.a(strA);
    }
}
