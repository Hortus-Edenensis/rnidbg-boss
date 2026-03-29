package com.ss.android.download.api.model;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    private String nr;
    private String u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private String nr;
        private String u;

        public u nr(String str) {
            this.nr = str;
            return this;
        }

        public u u(String str) {
            this.u = str;
            return this;
        }

        public b u() {
            return new b(this);
        }
    }

    public b(u uVar) {
        this.u = uVar.u;
        this.nr = uVar.nr;
    }

    public String u() {
        return this.u;
    }
}
