package com.bytedance.sdk.component.adexpress.nr;

import android.view.View;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class mv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5097a;
    private a b;
    private final boolean bf;
    private int bg;
    private int bq;
    private int c;
    private JSONObject d;
    private int dw;
    private String fx;
    private JSONObject gi;
    private JSONObject h;
    private String iz;
    private String ja;
    private int jk;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private boolean f5098jp;
    private int k;
    private int kj;
    private int l;
    private int m;
    private String mv;
    private boolean my;
    private String n;
    private pn nr;
    private String o;
    private View pb;
    private int pn;
    private String q;
    private double qq;
    private boolean rh;
    private Map<String, String> s;
    private int sx;
    private long t;
    private JSONObject u;
    private boolean wq;
    private String x;
    private String xg;
    private boolean z;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f5099a;
        private a b;
        private int bg;
        private int bq;
        private int c;
        private JSONObject d;
        private int dw;
        private String fx;
        private JSONObject gi;
        private JSONObject h;
        private String iz;
        private String ja;
        private int jk;

        /* JADX INFO: renamed from: jp, reason: collision with root package name */
        private boolean f5100jp;
        private int k;
        private int kj;
        private int l;
        private String m;
        private String mv;
        private boolean my;
        private String n;
        private pn nr;
        private String o;
        private int pb;
        private int pn;
        private String q;
        private double qq;
        private boolean rh;
        private Map<String, String> s;
        private int sx;
        private long t;
        private JSONObject u;
        private String x;
        private View xg;
        private boolean z = true;
        private boolean bf = true;
        private boolean wq = true;

        public u a(int i) {
            this.c = i;
            return this;
        }

        public u b(String str) {
            this.n = str;
            return this;
        }

        public u fx(String str) {
            this.x = str;
            return this;
        }

        public u iz(String str) {
            this.o = str;
            return this;
        }

        public u jk(int i) {
            this.pb = i;
            return this;
        }

        public u n(int i) {
            this.dw = i;
            return this;
        }

        public u nr(String str) {
            this.iz = str;
            return this;
        }

        public u pn(String str) {
            this.mv = str;
            return this;
        }

        public u u(boolean z) {
            this.wq = z;
            return this;
        }

        public u x(int i) {
            this.bq = i;
            return this;
        }

        public u a(String str) {
            this.m = str;
            return this;
        }

        public u b(int i) {
            this.k = i;
            return this;
        }

        public u fx(int i) {
            this.l = i;
            return this;
        }

        public u iz(int i) {
            this.bg = i;
            return this;
        }

        public u n(String str) {
            this.ja = str;
            return this;
        }

        public u nr(boolean z) {
            this.f5099a = z;
            return this;
        }

        public u pn(int i) {
            this.sx = i;
            return this;
        }

        public u u(JSONObject jSONObject) {
            this.u = jSONObject;
            return this;
        }

        public u x(String str) {
            this.q = str;
            return this;
        }

        public u b(JSONObject jSONObject) {
            this.h = jSONObject;
            return this;
        }

        public u fx(boolean z) {
            this.rh = z;
            return this;
        }

        public u nr(int i) {
            this.jk = i;
            return this;
        }

        public u u(String str) {
            this.fx = str;
            return this;
        }

        public u b(boolean z) {
            this.f5100jp = z;
            return this;
        }

        public u fx(JSONObject jSONObject) {
            this.d = jSONObject;
            return this;
        }

        public u nr(JSONObject jSONObject) {
            this.gi = jSONObject;
            return this;
        }

        public u u(a aVar) {
            this.b = aVar;
            return this;
        }

        public u u(int i) {
            this.pn = i;
            return this;
        }

        public u u(Map<String, String> map) {
            this.s = map;
            return this;
        }

        public mv u() {
            return new mv(this);
        }

        public u u(View view) {
            this.xg = view;
            return this;
        }
    }

    public mv(u uVar) {
        this.wq = true;
        this.u = uVar.u;
        this.nr = uVar.nr;
        this.fx = uVar.fx;
        this.b = uVar.b;
        this.pn = uVar.pn;
        this.iz = uVar.iz;
        this.x = uVar.x;
        this.n = uVar.n;
        this.f5097a = uVar.f5099a;
        this.jk = uVar.jk;
        this.t = uVar.t;
        this.l = uVar.l;
        this.mv = uVar.mv;
        this.s = uVar.s;
        this.k = uVar.k;
        this.my = uVar.my;
        this.o = uVar.o;
        this.sx = uVar.sx;
        this.bg = uVar.bg;
        this.bq = uVar.bq;
        this.dw = uVar.dw;
        this.c = uVar.c;
        this.q = uVar.q;
        this.qq = uVar.qq;
        this.kj = uVar.kj;
        this.z = uVar.z;
        this.gi = uVar.gi;
        this.d = uVar.d;
        this.h = uVar.h;
        this.rh = uVar.rh;
        this.ja = uVar.ja;
        this.bf = uVar.bf;
        this.wq = uVar.wq;
        this.m = uVar.pb;
        this.xg = uVar.m;
        this.pb = uVar.xg;
        this.f5098jp = uVar.f5100jp;
    }

    public boolean a() {
        return this.wq;
    }

    public double b() {
        return this.qq;
    }

    public int bg() {
        return this.bg;
    }

    public int bq() {
        return this.bq;
    }

    public JSONObject c() {
        return this.d;
    }

    public boolean d() {
        return this.bf;
    }

    public JSONObject dw() {
        return this.gi;
    }

    public boolean fx() {
        return this.z;
    }

    public String gi() {
        return this.ja;
    }

    public int h() {
        return this.m;
    }

    public String iz() {
        return this.fx;
    }

    public int jk() {
        return this.kj;
    }

    public int k() {
        return this.k;
    }

    public int kj() {
        return this.c;
    }

    public long l() {
        return this.t;
    }

    public int mv() {
        return this.l;
    }

    public boolean my() {
        return this.my;
    }

    public int n() {
        return this.pn;
    }

    public View nr() {
        return this.pb;
    }

    public String o() {
        return this.o;
    }

    public JSONObject pn() {
        pn pnVar;
        if (this.u == null && (pnVar = this.nr) != null) {
            this.u = pnVar.u();
        }
        return this.u;
    }

    public JSONObject q() {
        return this.h;
    }

    public int qq() {
        return this.dw;
    }

    public boolean rh() {
        return this.f5098jp;
    }

    public Map<String, String> s() {
        return this.s;
    }

    public int sx() {
        return this.sx;
    }

    public boolean t() {
        return this.f5097a;
    }

    public String u() {
        return this.xg;
    }

    public a x() {
        return this.b;
    }

    public boolean z() {
        return this.rh;
    }

    public void u(int i) {
        this.pn = i;
    }
}
