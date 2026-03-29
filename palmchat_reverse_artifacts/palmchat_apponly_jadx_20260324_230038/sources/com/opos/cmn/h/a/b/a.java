package com.opos.cmn.h.a.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8022a;
    public final String b;
    public final String c;

    /* JADX INFO: renamed from: com.opos.cmn.h.a.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0672a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f8023a;
        private String b;
        private String c;

        public C0672a a(String str) {
            this.f8023a = str;
            return this;
        }

        public C0672a b(String str) {
            this.b = str;
            return this;
        }

        public C0672a c(String str) {
            this.c = str;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }

    private a(C0672a c0672a) {
        this.f8022a = c0672a.f8023a;
        this.b = c0672a.b;
        this.c = c0672a.c;
    }
}
