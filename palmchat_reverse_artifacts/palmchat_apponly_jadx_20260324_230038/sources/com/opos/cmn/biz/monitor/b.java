package com.opos.cmn.biz.monitor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7845a;
    public final boolean b;
    public final long c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f7846a = true;
        private boolean b;
        private long c;

        public a a(boolean z) {
            this.f7846a = z;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    private b(a aVar) {
        this.f7845a = aVar.f7846a;
        this.b = aVar.b;
        this.c = aVar.c;
    }
}
