package com.bytedance.embedapplog.util;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u {
    private final String b;
    private final String[] fx;
    private final String iz;
    private final String[] nr;
    private final String pn;
    private final String u;
    private final String x;

    /* JADX INFO: renamed from: com.bytedance.embedapplog.util.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0190u {
        private String b;
        private String[] fx;
        private String iz;
        private String[] nr;
        private String pn;
        private String u;
        private String x;

        public C0190u b(String str) {
            this.x = str;
            return this;
        }

        public C0190u fx(String str) {
            this.pn = str;
            return this;
        }

        public C0190u nr(String[] strArr) {
            this.fx = strArr;
            return this;
        }

        public C0190u u(String str) {
            this.u = str;
            return this;
        }

        public C0190u nr(String str) {
            this.b = str;
            return this;
        }

        public C0190u u(String[] strArr) {
            this.nr = strArr;
            return this;
        }

        public u u() {
            return new u(this);
        }
    }

    public String b() {
        return this.pn;
    }

    public String fx() {
        return this.b;
    }

    public String[] nr() {
        return this.nr;
    }

    public String u() {
        return this.u;
    }

    private u(C0190u c0190u) {
        this.u = c0190u.u;
        this.nr = c0190u.nr;
        this.fx = c0190u.fx;
        this.b = c0190u.b;
        this.pn = c0190u.pn;
        this.iz = c0190u.iz;
        this.x = c0190u.x;
    }

    public static u u(int i) {
        return nr.u(i);
    }
}
