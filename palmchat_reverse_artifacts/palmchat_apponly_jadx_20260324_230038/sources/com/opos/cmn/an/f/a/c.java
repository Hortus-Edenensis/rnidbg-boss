package com.opos.cmn.an.f.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7748a;
    public final boolean b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7749a;
        private boolean b = true;

        public a a(String str) {
            this.f7749a = str;
            return this;
        }

        public a a(boolean z) {
            this.b = z;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    private c(a aVar) {
        this.f7748a = aVar.f7749a;
        this.b = aVar.b;
    }

    public String toString() {
        return "UploadParams{, businessType=" + this.f7748a + ", onlyWifi=" + this.b + '}';
    }
}
