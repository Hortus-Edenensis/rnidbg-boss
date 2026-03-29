package com.bytedance.sdk.openadsdk.iz.fx;

import com.bytedance.sdk.openadsdk.core.kj.bc;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class o {
    private com.bykv.vk.openvk.component.video.api.fx.iz b;
    private int fx;
    private String nr;
    private bc pn;
    private long u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5418a;
        private int jk;
        private Map<String, Object> k;
        private int l;
        private int n;
        private JSONArray s;
        private int t;
        private long u = 0;
        private long nr = 0;
        private long fx = 0;
        private boolean b = false;
        private boolean pn = false;
        private int iz = 0;
        private int x = 0;
        private boolean mv = false;

        public int a() {
            long j = this.fx;
            if (j <= 0) {
                return 0;
            }
            return Math.min((int) ((this.u * 100) / j), 100);
        }

        public long b() {
            return this.fx;
        }

        public long fx() {
            return this.nr;
        }

        public int iz() {
            return this.x;
        }

        public int jk() {
            return this.jk;
        }

        public boolean k() {
            return this.pn;
        }

        public int l() {
            return this.l;
        }

        public boolean mv() {
            return this.mv;
        }

        public Map<String, Object> my() {
            return this.k;
        }

        public int n() {
            return this.f5418a;
        }

        public long nr() {
            return this.u;
        }

        public int pn() {
            return this.iz;
        }

        public boolean s() {
            return this.b;
        }

        public int t() {
            return this.t;
        }

        public void u(JSONArray jSONArray) {
            this.s = jSONArray;
        }

        public int x() {
            return this.n;
        }

        public void b(int i) {
            this.f5418a = i;
        }

        public void fx(long j) {
            this.fx = j;
        }

        public void iz(int i) {
            this.l = i;
        }

        public void nr(long j) {
            this.nr = j;
        }

        public void pn(int i) {
            this.jk = i;
        }

        public JSONArray u() {
            return this.s;
        }

        public void fx(int i) {
            this.n = i;
        }

        public void nr(int i) {
            this.x = i;
        }

        public void u(long j) {
            this.u = j;
        }

        public void fx(boolean z) {
            this.pn = z;
        }

        public void nr(boolean z) {
            this.b = z;
        }

        public void u(int i) {
            this.iz = i;
        }

        public void u(boolean z) {
            this.mv = z;
        }

        public void u(Map<String, Object> map) {
            this.k = map;
        }
    }

    public o(long j, String str, int i, com.bykv.vk.openvk.component.video.api.fx.iz izVar, bc bcVar) {
        this.u = j;
        this.nr = str;
        this.fx = i;
        this.b = izVar;
        this.pn = bcVar;
    }

    public com.bykv.vk.openvk.component.video.api.fx.iz b() {
        return this.b;
    }

    public int fx() {
        return this.fx;
    }

    public String nr() {
        return this.nr;
    }

    public bc pn() {
        return this.pn;
    }

    public long u() {
        return this.u;
    }
}
