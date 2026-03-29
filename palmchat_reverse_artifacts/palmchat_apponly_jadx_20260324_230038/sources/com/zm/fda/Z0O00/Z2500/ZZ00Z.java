package com.zm.fda.Z0O00.Z2500;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ00Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16674a;
    public String b;
    public com.zm.fda.Z0O00.Z2500.OO22Z c;
    public int d;
    public long e;

    /* JADX INFO: renamed from: com.zm.fda.Z0O00.Z2500.ZZ00Z$ZZ00Z, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C1169ZZ00Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ZZ00Z f16675a = new ZZ00Z();

        public C1169ZZ00Z a(String str) {
            this.f16675a.b = str;
            return this;
        }

        public C1169ZZ00Z b(String str) {
            this.f16675a.f16674a = str;
            return this;
        }

        public C1169ZZ00Z a(com.zm.fda.Z0O00.Z2500.OO22Z oo22z) {
            this.f16675a.c = oo22z;
            return this;
        }

        public C1169ZZ00Z a(long j) {
            this.f16675a.e = j;
            return this;
        }

        public C1169ZZ00Z a(int i) {
            this.f16675a.d = i;
            return this;
        }

        public ZZ00Z a() {
            return this.f16675a;
        }
    }

    public ZZ00Z() {
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", this.f16674a);
            jSONObject.put("appId", this.b);
            jSONObject.put("crashInfo", this.c.a());
            jSONObject.put("type", this.d);
            jSONObject.put("ts", this.e);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
