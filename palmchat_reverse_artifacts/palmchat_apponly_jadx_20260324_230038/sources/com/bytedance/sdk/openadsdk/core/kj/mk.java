package com.bytedance.sdk.openadsdk.core.kj;

import android.graphics.Color;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class mk {
    private int b;
    private int iz;
    private int k;
    private nr l;
    private int mv;
    private int n;
    private String nr;
    private int pn;
    private u s;
    private nr t;
    private int u;
    private int x;
    private boolean fx = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5313a = "#008DEA";
    private String jk = "点击查看";
    private float my = 0.0f;
    private int o = 0;
    private int sx = 0;
    private int bg = 55;
    private int bq = 0;
    private float dw = 0.0f;
    private int c = 100;
    private int q = 0;
    private int qq = 0;
    private int kj = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class nr {
        int u;

        public nr(JSONObject jSONObject, int i) {
            this.u = 14;
            if (jSONObject == null) {
                return;
            }
            this.u = jSONObject.optInt("font_size", i);
        }

        public int nr() {
            return this.u;
        }

        public JSONObject u() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("font_size", this.u);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u {
        int b;
        int fx;
        int nr;
        int u;

        public u(JSONObject jSONObject, int i) {
            this.u = 30;
            this.nr = 30;
            this.fx = 150;
            this.b = 40;
            if (jSONObject == null) {
                if (i == 2) {
                    this.fx = 40;
                    this.b = 20;
                    return;
                }
                return;
            }
            int iOptInt = jSONObject.optInt("left_margin", 30);
            this.u = iOptInt;
            if (iOptInt < 0 || iOptInt > mk.this.gi()) {
                this.u = 30;
            }
            int iOptInt2 = jSONObject.optInt("right_margin", 30);
            this.nr = iOptInt2;
            if (iOptInt2 < 0 || iOptInt2 > mk.this.gi()) {
                this.nr = 30;
            }
            if (i == 2) {
                int iOptInt3 = jSONObject.optInt("top_margin", 40);
                this.fx = iOptInt3;
                if (iOptInt3 < 0 || iOptInt3 > mk.this.z()) {
                    this.fx = 40;
                }
                int iOptInt4 = jSONObject.optInt("bottom_margin", 20);
                this.b = iOptInt4;
                if (iOptInt4 < 0 || iOptInt4 > mk.this.z()) {
                    this.b = 20;
                    return;
                }
                return;
            }
            int iOptInt5 = jSONObject.optInt("top_margin", 150);
            this.fx = iOptInt5;
            if (iOptInt5 < 0 || iOptInt5 > mk.this.z()) {
                this.fx = 150;
            }
            int iOptInt6 = jSONObject.optInt("bottom_margin", 40);
            this.b = iOptInt6;
            if (iOptInt6 < 0 || iOptInt6 > mk.this.z()) {
                this.b = 40;
            }
        }

        public int b() {
            return this.b;
        }

        public int fx() {
            return this.fx;
        }

        public int nr() {
            return this.nr;
        }

        public JSONObject pn() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("left_margin", 30);
                jSONObject.put("right_margin", 30);
                jSONObject.put("top_margin", 150);
                jSONObject.put("bottom_margin", 40);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public int u() {
            return this.u;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int gi() {
        return com.bytedance.sdk.openadsdk.core.y.y.b(com.bytedance.sdk.openadsdk.core.dw.getContext(), com.bytedance.sdk.openadsdk.core.y.y.b(com.bytedance.sdk.openadsdk.core.dw.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int z() {
        return com.bytedance.sdk.openadsdk.core.y.y.b(com.bytedance.sdk.openadsdk.core.dw.getContext(), com.bytedance.sdk.openadsdk.core.y.y.pn(com.bytedance.sdk.openadsdk.core.dw.getContext()));
    }

    public int a() {
        if (this.b == 4 && !com.bytedance.sdk.openadsdk.core.n.o().u(com.bytedance.sdk.openadsdk.core.dw.getContext())) {
            this.b = 0;
        } else if (this.b == 7 && !com.bytedance.sdk.openadsdk.core.n.o().nr(com.bytedance.sdk.openadsdk.core.dw.getContext())) {
            this.b = 0;
        }
        return this.b;
    }

    public int b() {
        return this.pn;
    }

    public int bg() {
        return this.bg;
    }

    public int bq() {
        return this.bq;
    }

    public int c() {
        return this.q;
    }

    public int dw() {
        return this.c;
    }

    public boolean fx() {
        return this.fx;
    }

    public int iz() {
        return this.x;
    }

    public String jk() {
        return this.f5313a;
    }

    public int k() {
        return this.mv;
    }

    public float kj() {
        return this.dw;
    }

    public nr l() {
        return this.t;
    }

    public nr mv() {
        return this.l;
    }

    public float my() {
        return this.my;
    }

    public int n() {
        return this.k;
    }

    public int o() {
        return this.o;
    }

    public int pn() {
        return this.iz;
    }

    public int q() {
        return this.qq;
    }

    public int qq() {
        return this.kj;
    }

    public u s() {
        return this.s;
    }

    public int sx() {
        return this.sx;
    }

    public String t() {
        return this.jk;
    }

    public int x() {
        return this.n;
    }

    public void b(int i) {
        this.x = i;
    }

    public void fx(int i) {
        this.iz = i;
    }

    public void iz(int i) {
        this.k = i;
    }

    public void jk(int i) {
        this.sx = i;
    }

    public void k(int i) {
        this.qq = i;
    }

    public void l(int i) {
        this.bq = i;
    }

    public void mv(int i) {
        this.c = i;
    }

    public void my(int i) {
        this.kj = i;
    }

    public void n(int i) {
        if (i <= 0 || i >= z()) {
            this.mv = 5;
        } else {
            this.mv = i;
        }
    }

    public String nr() {
        if (this.b == 4 && !com.bytedance.sdk.openadsdk.core.n.o().u(com.bytedance.sdk.openadsdk.core.dw.getContext())) {
            this.nr = "点击跳转至详情页或第三方应用";
        } else if (this.b == 7 && !com.bytedance.sdk.openadsdk.core.n.o().nr(com.bytedance.sdk.openadsdk.core.dw.getContext())) {
            this.nr = "点击跳转至详情页或第三方应用";
        }
        return this.nr;
    }

    public void pn(int i) {
        this.n = i;
    }

    public void s(int i) {
        this.q = i;
    }

    public void t(int i) {
        this.bg = i;
    }

    public int u() {
        return this.u;
    }

    public void x(int i) {
        this.b = i;
    }

    public void fx(String str) {
        if (TextUtils.isEmpty(str)) {
            int i = this.b;
            if (i == 7) {
                this.jk = "扭动手机";
                return;
            } else if (i == 5) {
                this.jk = "向上滑动";
                return;
            } else {
                if (i == 4) {
                    this.jk = "摇一摇";
                    return;
                }
                return;
            }
        }
        this.jk = str;
    }

    public void u(int i) {
        this.u = i;
    }

    public void u(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fx = true;
            int i = this.b;
            if (i == 3) {
                this.nr = "跳转至详情页或第三方应用";
                return;
            }
            if (i == 4) {
                this.nr = "前往详情页或第三方应用";
                return;
            } else if (i != 5 && i != 7) {
                this.nr = "点击跳转至详情页或第三方应用";
                return;
            } else {
                this.nr = "前往详情页或第三方应用";
                return;
            }
        }
        this.nr = str;
    }

    public void a(int i) {
        this.o = i;
    }

    public void nr(int i) {
        this.pn = i;
    }

    public void nr(String str) {
        try {
            Color.parseColor(str);
            this.f5313a = str;
        } catch (Throwable unused) {
            this.f5313a = "#008DEA";
        }
    }

    public void nr(JSONObject jSONObject) {
        this.l = new nr(jSONObject, 20);
    }

    public void nr(float f) {
        this.dw = f;
    }

    public void u(JSONObject jSONObject) {
        this.t = new nr(jSONObject, 14);
    }

    public void u(JSONObject jSONObject, int i) {
        this.s = new u(jSONObject, i);
    }

    public void u(float f) {
        this.my = f;
    }
}
