package com.opos.mobad.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f8595a;
    public final String b;
    public final String c;
    public final int d;
    public final String e;
    public final long f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final String j;
    public final int k;
    public final boolean l;
    public final String m;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f8596a;
        private String b;
        private String c;
        private int d;
        private String e;
        private boolean g;
        private boolean h;
        private int i;
        private String j;
        private int k;
        private long f = 0;
        private boolean l = false;
        private String m = "";

        public a a(int i) {
            this.d = i;
            return this;
        }

        public a b(int i) {
            this.i = i;
            return this;
        }

        public a c(int i) {
            this.k = i;
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public a c(String str) {
            this.e = str;
            return this;
        }

        public a d(String str) {
            this.j = str;
            return this;
        }

        public a a(boolean z) {
            this.f8596a = z;
            return this;
        }

        public a b(boolean z) {
            this.g = z;
            return this;
        }

        public a c(boolean z) {
            this.h = z;
            return this;
        }

        public e a() {
            return new e(this);
        }
    }

    private e(a aVar) {
        this.f8595a = aVar.f8596a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
    }
}
