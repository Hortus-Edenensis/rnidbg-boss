package com.ss.android.download.api.model;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u {
    public String b;
    public String fx;
    public String nr;
    public String pn;
    public String u;

    /* JADX INFO: renamed from: com.ss.android.download.api.model.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0841u {
        private String b;
        private String fx;
        private String nr;
        private String pn;
        private String u;

        public C0841u b(String str) {
            this.pn = str;
            return this;
        }

        public C0841u fx(String str) {
            this.b = str;
            return this;
        }

        public C0841u nr(String str) {
            this.nr = str;
            return this;
        }

        public C0841u u(String str) {
            this.u = str;
            return this;
        }

        public u u() {
            return new u(this);
        }
    }

    public u(C0841u c0841u) {
        this.nr = "";
        this.u = c0841u.u;
        this.nr = c0841u.nr;
        this.fx = c0841u.fx;
        this.b = c0841u.b;
        this.pn = c0841u.pn;
    }
}
