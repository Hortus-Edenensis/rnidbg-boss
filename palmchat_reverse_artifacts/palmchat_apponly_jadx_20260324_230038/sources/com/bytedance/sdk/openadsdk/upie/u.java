package com.bytedance.sdk.openadsdk.upie;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private int b;
    private String fx;
    private long iz;
    private String nr;
    private int pn;
    private String u;
    private JSONObject x;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.upie.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0317u {
        private int b;
        private String fx;
        private long iz;
        private String nr;
        private int pn;
        private String u;
        private JSONObject x;

        public C0317u fx(String str) {
            this.fx = str;
            return this;
        }

        public C0317u nr(String str) {
            this.nr = str;
            return this;
        }

        public C0317u u(String str) {
            this.u = str;
            return this;
        }

        public C0317u nr(int i) {
            this.pn = i;
            return this;
        }

        public C0317u u(int i) {
            this.b = i;
            return this;
        }

        public C0317u u(long j) {
            this.iz = j;
            return this;
        }

        public C0317u u(JSONObject jSONObject) {
            this.x = jSONObject;
            return this;
        }

        public u u() {
            u uVar = new u();
            uVar.u = this.u;
            uVar.nr = this.nr;
            uVar.fx = this.fx;
            uVar.b = this.b;
            uVar.pn = this.pn;
            uVar.iz = this.iz;
            uVar.x = this.x;
            return uVar;
        }
    }

    public int b() {
        return this.b;
    }

    public long iz() {
        return this.iz;
    }

    public int pn() {
        return this.pn;
    }

    public JSONObject x() {
        return this.x;
    }

    public String fx() {
        return this.fx;
    }

    public String nr() {
        return this.nr;
    }

    public String u() {
        return this.u;
    }
}
