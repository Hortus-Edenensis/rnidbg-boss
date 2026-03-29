package com.opos.cmn.an.f.b.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7761a;
    public final Object b;
    public final Throwable c;
    public final int d;
    public final long e;
    public final String f;
    public final long g;
    public final int h;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7762a;
        private Object b;
        private Throwable c;
        private int d;
        private long e = 0;
        private String f = "";
        private long g = 0;
        private int h = 1;

        public b a(int i) {
            this.d = i;
            return this;
        }

        public b b(int i) {
            this.h = i;
            return this;
        }

        public b a(long j) {
            this.e = j;
            return this;
        }

        public b b(long j) {
            this.g = j;
            return this;
        }

        public b a(Object obj) {
            this.b = obj;
            return this;
        }

        public b b(String str) {
            this.f = str;
            return this;
        }

        public b a(String str) {
            this.f7762a = str;
            return this;
        }

        public b a(Throwable th) {
            this.c = th;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    private d(b bVar) {
        this.f7761a = bVar.f7762a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
    }
}
