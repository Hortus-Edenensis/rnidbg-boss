package com.zm.fda.Z0O00.Z0O00;

import com.lantern.auth.server.WkParams;
import com.umeng.analytics.pro.bt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ00Z {
    public String A;
    public String B;
    public long C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16669a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    /* JADX INFO: renamed from: com.zm.fda.Z0O00.Z0O00.ZZ00Z$ZZ00Z, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C1167ZZ00Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ZZ00Z f16670a = new ZZ00Z();

        public C1167ZZ00Z A(String str) {
            this.f16670a.b = str;
            return this;
        }

        public C1167ZZ00Z B(String str) {
            this.f16670a.g = str;
            return this;
        }

        public C1167ZZ00Z C(String str) {
            this.f16670a.h = str;
            return this;
        }

        public C1167ZZ00Z a(long j) {
            this.f16670a.C = j;
            return this;
        }

        public C1167ZZ00Z b(String str) {
            this.f16670a.k = str;
            return this;
        }

        public C1167ZZ00Z c(String str) {
            this.f16670a.e = str;
            return this;
        }

        public C1167ZZ00Z d(String str) {
            this.f16670a.v = str;
            return this;
        }

        public C1167ZZ00Z e(String str) {
            this.f16670a.n = str;
            return this;
        }

        public C1167ZZ00Z f(String str) {
            this.f16670a.i = str;
            return this;
        }

        public C1167ZZ00Z g(String str) {
            this.f16670a.f16669a = str;
            return this;
        }

        public C1167ZZ00Z h(String str) {
            this.f16670a.w = str;
            return this;
        }

        public C1167ZZ00Z i(String str) {
            this.f16670a.x = str;
            return this;
        }

        public C1167ZZ00Z j(String str) {
            this.f16670a.j = str;
            return this;
        }

        public C1167ZZ00Z k(String str) {
            this.f16670a.d = str;
            return this;
        }

        public C1167ZZ00Z l(String str) {
            this.f16670a.l = str;
            return this;
        }

        public C1167ZZ00Z m(String str) {
            this.f16670a.m = str;
            return this;
        }

        public C1167ZZ00Z n(String str) {
            this.f16670a.f = str;
            return this;
        }

        public C1167ZZ00Z o(String str) {
            this.f16670a.u = str;
            return this;
        }

        public C1167ZZ00Z p(String str) {
            this.f16670a.o = str;
            return this;
        }

        public C1167ZZ00Z q(String str) {
            this.f16670a.c = str;
            return this;
        }

        public C1167ZZ00Z r(String str) {
            this.f16670a.r = str;
            return this;
        }

        public C1167ZZ00Z s(String str) {
            this.f16670a.t = str;
            return this;
        }

        public C1167ZZ00Z t(String str) {
            this.f16670a.s = str;
            return this;
        }

        public C1167ZZ00Z u(String str) {
            this.f16670a.y = str;
            return this;
        }

        public C1167ZZ00Z v(String str) {
            this.f16670a.B = str;
            return this;
        }

        public C1167ZZ00Z w(String str) {
            this.f16670a.A = str;
            return this;
        }

        public C1167ZZ00Z x(String str) {
            this.f16670a.z = str;
            return this;
        }

        public C1167ZZ00Z y(String str) {
            this.f16670a.p = str;
            return this;
        }

        public C1167ZZ00Z z(String str) {
            this.f16670a.q = str;
            return this;
        }

        public C1167ZZ00Z a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f16670a.f16669a = jSONObject.getString("dhid");
                this.f16670a.b = jSONObject.getString(com.zm.fda.Z200O.ZZ00Z.l);
                this.f16670a.c = jSONObject.getString("oaid");
                this.f16670a.d = jSONObject.getString(WkParams.LANG);
                this.f16670a.e = jSONObject.getString("app_id");
                this.f16670a.g = jSONObject.getString("ver_code");
                this.f16670a.h = jSONObject.getString("ver_name");
                this.f16670a.i = jSONObject.getString("chan_id");
                this.f16670a.j = jSONObject.getString(WkParams.IMEI);
                this.f16670a.f = jSONObject.getString("mac");
                this.f16670a.m = jSONObject.getString(WkParams.LONGI);
                this.f16670a.l = jSONObject.getString(WkParams.LATI);
                this.f16670a.n = jSONObject.getString(bt.P);
                this.f16670a.o = jSONObject.getString("net_model");
                this.f16670a.p = jSONObject.getString("sdk_ver_code");
                this.f16670a.q = jSONObject.getString("sdk_ver_name");
                this.f16670a.r = jSONObject.getString("os");
                this.f16670a.s = jSONObject.getString("os_name");
                this.f16670a.t = jSONObject.getString("os_api");
                this.f16670a.u = jSONObject.getString(WkParams.MODEL);
                this.f16670a.v = jSONObject.getString("brand");
                this.f16670a.w = jSONObject.getString("harmony_os");
                this.f16670a.x = jSONObject.getString("harmony_os_name");
                this.f16670a.y = jSONObject.getString("package_name");
                this.f16670a.z = jSONObject.getString("project_ver_name");
                this.f16670a.A = jSONObject.getString("project_ver_code");
                this.f16670a.B = jSONObject.getString("project_id");
                this.f16670a.k = jSONObject.getString("android_id");
                this.f16670a.C = jSONObject.getLong("evt_ts");
            } catch (Exception unused) {
            }
            return this;
        }

        public ZZ00Z a() {
            return this.f16670a;
        }
    }

    public ZZ00Z() {
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dhid", this.f16669a);
            jSONObject.put(com.zm.fda.Z200O.ZZ00Z.l, this.b);
            jSONObject.put("oaid", this.c);
            jSONObject.put(WkParams.LANG, this.d);
            jSONObject.put("app_id", this.e);
            jSONObject.put("mac", this.f);
            jSONObject.put("ver_code", this.g);
            jSONObject.put("ver_name", this.h);
            jSONObject.put("chan_id", this.i);
            jSONObject.put(WkParams.IMEI, this.j);
            jSONObject.put("android_id", this.k);
            jSONObject.put(WkParams.LONGI, this.m);
            jSONObject.put(WkParams.LATI, this.l);
            jSONObject.put(bt.P, this.n);
            jSONObject.put("net_model", this.o);
            jSONObject.put("sdk_ver_code", this.p);
            jSONObject.put("sdk_ver_name", this.q);
            jSONObject.put("os", this.r);
            jSONObject.put("os_name", this.s);
            jSONObject.put("os_api", this.t);
            jSONObject.put(WkParams.MODEL, this.u);
            jSONObject.put("brand", this.v);
            jSONObject.put("harmony_os", this.w);
            jSONObject.put("harmony_os_name", this.x);
            jSONObject.put("package_name", this.y);
            jSONObject.put("project_ver_name", this.z);
            jSONObject.put("project_id", this.B);
            jSONObject.put("project_ver_code", this.A);
            jSONObject.put("evt_ts", this.C);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
