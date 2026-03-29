package com.opos.cmn.func.a.a.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7917a;
    public final long b;

    /* JADX INFO: renamed from: com.opos.cmn.func.a.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0662a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f7918a = true;
        private long b = 0;

        public a a() {
            if (this.b <= 0) {
                this.b = com.opos.cmn.func.a.b.a.a.a() ? 173525665583603712L : 183259052372135936L;
            }
            return new a(this);
        }
    }

    private a(C0662a c0662a) {
        this.f7917a = c0662a.f7918a;
        this.b = c0662a.b;
    }

    public String toString() {
        return "AppTraceConfig{enableTrace=" + this.f7917a + ", traceConfigId=" + this.b + '}';
    }
}
