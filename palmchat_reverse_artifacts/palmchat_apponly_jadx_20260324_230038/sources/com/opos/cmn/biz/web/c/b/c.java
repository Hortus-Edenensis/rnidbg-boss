package com.opos.cmn.biz.web.c.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7912a;
    public final boolean b;
    public final String c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private String b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f7913a = true;
        private String c = "";

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public a a(boolean z) {
            this.f7913a = z;
            return this;
        }

        public c a() {
            if (this.c == null) {
                this.c = "";
            }
            return new c(this);
        }
    }

    private c(a aVar) {
        this.b = aVar.f7913a;
        this.c = aVar.b;
        this.f7912a = aVar.c;
    }

    public String toString() {
        return "JsCommonInitParams{, businessType=" + this.f7912a + "forceJsInit=" + this.b + ", jsSign=" + this.c + '}';
    }
}
