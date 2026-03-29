package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class rh {
    private double b;
    private int fx;
    private String iz;
    private int nr;
    private boolean pn;
    private String u;

    /* JADX INFO: compiled from: SearchBox */
    public static final class u extends com.bytedance.sdk.openadsdk.my.fx.nr.l {
        private double b;
        private String fx;
        private int nr;
        private int u;

        public u(int i, int i2, String str, double d) {
            this.u = i;
            this.nr = i2;
            this.fx = str;
            this.b = d;
        }

        @Override // com.bytedance.sdk.openadsdk.my.fx.nr.l
        public double b() {
            return this.b;
        }

        @Override // com.bytedance.sdk.openadsdk.my.fx.nr.l
        public String fx() {
            return this.fx;
        }

        @Override // com.bytedance.sdk.openadsdk.my.fx.nr.l
        public int nr() {
            return this.nr;
        }

        @Override // com.bytedance.sdk.openadsdk.my.fx.nr.l
        public boolean pn() {
            String str;
            return this.u > 0 && this.nr > 0 && (str = this.fx) != null && str.length() > 0;
        }

        @Override // com.bytedance.sdk.openadsdk.my.fx.nr.l
        public int u() {
            return this.u;
        }
    }

    public double b() {
        return this.b;
    }

    public int fx() {
        return this.fx;
    }

    public boolean iz() {
        return this.pn;
    }

    public int nr() {
        return this.nr;
    }

    public boolean pn() {
        return !TextUtils.isEmpty(this.u) && this.nr > 0 && this.fx > 0;
    }

    public String u() {
        return this.u;
    }

    public String x() {
        return this.iz;
    }

    public void nr(int i) {
        this.fx = i;
    }

    public void u(String str) {
        this.u = str;
    }

    public void nr(String str) {
        this.iz = str;
    }

    public void u(int i) {
        this.nr = i;
    }

    public void u(double d) {
        this.b = d;
    }

    public void u(boolean z) {
        this.pn = z;
    }

    public static com.bytedance.sdk.openadsdk.my.fx.nr.l u(rh rhVar) {
        if (rhVar == null || !rhVar.pn()) {
            return null;
        }
        return new u(rhVar.fx(), rhVar.nr(), rhVar.u(), rhVar.b());
    }

    public static final com.bytedance.sdk.openadsdk.my.fx.nr.l u(int i, int i2, String str, double d) {
        return new u(i, i2, str, d);
    }
}
