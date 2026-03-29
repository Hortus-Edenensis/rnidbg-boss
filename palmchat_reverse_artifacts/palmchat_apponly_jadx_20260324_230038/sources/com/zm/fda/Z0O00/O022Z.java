package com.zm.fda.Z0O00;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class O022Z {
    public static final int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16659a;
    public long b;
    public String c;

    /* JADX INFO: compiled from: SearchBox */
    public static class ZZ00Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final O022Z f16660a = new O022Z();

        public ZZ00Z a(int i) {
            this.f16660a.f16659a = i;
            return this;
        }

        public ZZ00Z a(long j) {
            this.f16660a.b = j;
            return this;
        }

        public ZZ00Z a(String str) {
            this.f16660a.c = str;
            return this;
        }

        public O022Z a() {
            return this.f16660a;
        }
    }

    public boolean a() {
        return this.f16659a == 0;
    }

    public O022Z() {
    }
}
