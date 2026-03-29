package com.opos.cmn.module.ui.b.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8066a;
    public final boolean b;
    public final boolean c;

    /* JADX INFO: renamed from: com.opos.cmn.module.ui.b.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0676a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8067a = 0;
        private boolean b;
        private boolean c;

        public C0676a b(boolean z) {
            this.c = z;
            return this;
        }

        public C0676a a(int i) {
            this.f8067a = i;
            return this;
        }

        public C0676a a(boolean z) {
            this.b = z;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }

    public a(C0676a c0676a) {
        this.f8066a = c0676a.f8067a;
        this.b = c0676a.b;
        this.c = c0676a.c;
    }
}
