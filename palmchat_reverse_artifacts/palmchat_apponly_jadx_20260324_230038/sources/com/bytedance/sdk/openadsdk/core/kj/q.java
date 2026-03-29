package com.bytedance.sdk.openadsdk.core.kj;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.nr.b;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class q implements com.bytedance.sdk.component.adexpress.fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5320a;
    public final float b;
    public int bg;
    private JSONObject bq;
    public final float fx;
    public final long iz;
    public final int jk;
    public final boolean k;
    public final String l;
    public final String mv;
    public final byte my;
    public final int n;
    public final float nr;
    public SparseArray<b.u> o;
    public final long pn;
    public final String s;
    public String sx;
    public final String t;
    public final float u;
    public final int x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5321a;
        private float b;
        private long fx;
        private float iz;
        private int jk;
        private String k;
        private String l;
        private String mv;
        private boolean my;
        private int n;
        private long nr;
        private JSONObject o;
        private float pn;
        private String s;
        private String sx;
        private int t;
        private float x;
        protected SparseArray<b.u> u = new SparseArray<>();
        private int bg = -1;
        private byte bq = 0;

        public u b(float f) {
            this.x = f;
            return this;
        }

        public u fx(float f) {
            this.iz = f;
            return this;
        }

        public u nr(long j) {
            this.fx = j;
            return this;
        }

        public u pn(String str) {
            this.sx = str;
            return this;
        }

        public u u(byte b) {
            this.bq = b;
            return this;
        }

        public u b(int i) {
            this.t = i;
            return this;
        }

        public u fx(int i) {
            this.jk = i;
            return this;
        }

        public u nr(float f) {
            this.pn = f;
            return this;
        }

        public u pn(int i) {
            this.bg = i;
            return this;
        }

        public u u(boolean z) {
            this.my = z;
            return this;
        }

        public u b(String str) {
            this.k = str;
            return this;
        }

        public u fx(String str) {
            this.s = str;
            return this;
        }

        public u nr(int i) {
            this.f5321a = i;
            return this;
        }

        public u u(long j) {
            this.nr = j;
            return this;
        }

        public u nr(String str) {
            this.mv = str;
            return this;
        }

        public u u(float f) {
            this.b = f;
            return this;
        }

        public u u(int i) {
            this.n = i;
            return this;
        }

        public u u(String str) {
            this.l = str;
            return this;
        }

        public u u(SparseArray<b.u> sparseArray) {
            this.u = sparseArray;
            return this;
        }

        public u u(JSONObject jSONObject) {
            this.o = jSONObject;
            return this;
        }

        public q u() {
            return new q(this);
        }
    }

    public JSONObject u() {
        if (this.bq == null) {
            this.bq = new JSONObject();
        }
        return this.bq;
    }

    private q(u uVar) {
        this.bg = -1;
        this.u = uVar.x;
        this.nr = uVar.iz;
        this.fx = uVar.pn;
        this.b = uVar.b;
        this.pn = uVar.fx;
        this.iz = uVar.nr;
        this.x = uVar.n;
        this.n = uVar.f5321a;
        this.f5320a = uVar.jk;
        this.jk = uVar.t;
        this.t = uVar.l;
        this.o = uVar.u;
        this.k = uVar.my;
        this.bq = uVar.o;
        this.l = uVar.mv;
        this.mv = uVar.s;
        this.s = uVar.k;
        this.sx = uVar.sx;
        this.bg = uVar.bg;
        this.my = uVar.bq;
    }
}
