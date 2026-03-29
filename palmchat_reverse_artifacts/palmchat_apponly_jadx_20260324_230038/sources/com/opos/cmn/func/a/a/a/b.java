package com.opos.cmn.func.a.a.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7919a;
    public final long b;
    public final a c;

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        CN,
        EU,
        SA,
        SEA
    }

    /* JADX INFO: renamed from: com.opos.cmn.func.a.a.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0663b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f7921a = true;
        private long b = 54883;
        private a c = null;

        public b a() {
            return new b(this);
        }
    }

    private b(C0663b c0663b) {
        this.f7919a = c0663b.f7921a;
        this.b = c0663b.b;
        this.c = c0663b.c;
    }

    public String toString() {
        return "CloudConfig{enableCloudConfig=" + this.f7919a + ", productId=" + this.b + ", areaCode=" + this.c + '}';
    }
}
