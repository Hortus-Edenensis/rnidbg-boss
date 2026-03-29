package com.zm.fda.Z0O00.Z2500;

import com.lantern.auth.server.WkParams;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OO22Z {
    public String A;
    public String B;
    public String C;
    public String D;
    public long E;
    public int F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16672a;
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

    /* JADX INFO: compiled from: SearchBox */
    public static class ZZ00Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OO22Z f16673a = new OO22Z();

        public ZZ00Z A(String str) {
            this.f16673a.h = str;
            return this;
        }

        public ZZ00Z B(String str) {
            this.f16673a.f = str;
            return this;
        }

        public ZZ00Z C(String str) {
            this.f16673a.c = str;
            return this;
        }

        public ZZ00Z D(String str) {
            this.f16673a.e = str;
            return this;
        }

        public ZZ00Z a(long j) {
            this.f16673a.E = j;
            return this;
        }

        public ZZ00Z b(String str) {
            this.f16673a.d = str;
            return this;
        }

        public ZZ00Z c(String str) {
            this.f16673a.g = str;
            return this;
        }

        public ZZ00Z d(String str) {
            this.f16673a.q = str;
            return this;
        }

        public ZZ00Z e(String str) {
            this.f16673a.x = str;
            return this;
        }

        public ZZ00Z f(String str) {
            this.f16673a.w = str;
            return this;
        }

        public ZZ00Z g(String str) {
            this.f16673a.v = str;
            return this;
        }

        public ZZ00Z h(String str) {
            this.f16673a.i = str;
            return this;
        }

        public ZZ00Z i(String str) {
            this.f16673a.C = str;
            return this;
        }

        public ZZ00Z j(String str) {
            this.f16673a.b = str;
            return this;
        }

        public ZZ00Z k(String str) {
            this.f16673a.r = str;
            return this;
        }

        public ZZ00Z l(String str) {
            this.f16673a.s = str;
            return this;
        }

        public ZZ00Z m(String str) {
            this.f16673a.t = str;
            return this;
        }

        public ZZ00Z n(String str) {
            this.f16673a.f16672a = str;
            return this;
        }

        public ZZ00Z o(String str) {
            this.f16673a.z = str;
            return this;
        }

        public ZZ00Z p(String str) {
            this.f16673a.y = str;
            return this;
        }

        public ZZ00Z q(String str) {
            this.f16673a.u = str;
            return this;
        }

        public ZZ00Z r(String str) {
            this.f16673a.A = str;
            return this;
        }

        public ZZ00Z s(String str) {
            this.f16673a.p = str;
            return this;
        }

        public ZZ00Z t(String str) {
            this.f16673a.D = str;
            return this;
        }

        public ZZ00Z u(String str) {
            this.f16673a.B = str;
            return this;
        }

        public ZZ00Z v(String str) {
            this.f16673a.k = str;
            return this;
        }

        public ZZ00Z w(String str) {
            this.f16673a.j = str;
            return this;
        }

        public ZZ00Z x(String str) {
            this.f16673a.m = str;
            return this;
        }

        public ZZ00Z y(String str) {
            this.f16673a.n = str;
            return this;
        }

        public ZZ00Z z(String str) {
            this.f16673a.o = str;
            return this;
        }

        public ZZ00Z a(int i) {
            this.f16673a.F = i;
            return this;
        }

        public ZZ00Z a(String str) {
            this.f16673a.l = str;
            return this;
        }

        public OO22Z a() {
            return this.f16673a;
        }
    }

    public OO22Z() {
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(WkParams.LANG, this.f16672a);
            jSONObject.put("dhid", this.b);
            jSONObject.put(WkParams.UHID, this.c);
            jSONObject.put("app_id", this.d);
            jSONObject.put("ver_code", this.e);
            jSONObject.put("project_ver_code", this.f);
            jSONObject.put("app_name", this.g);
            jSONObject.put("project_id", this.h);
            jSONObject.put("chan_id", this.i);
            jSONObject.put("orig_chan_id", this.j);
            jSONObject.put(WkParams.IMEI, this.t);
            jSONObject.put("mac", this.u);
            jSONObject.put("cap_ssid", this.v);
            jSONObject.put("cap_bssid", this.w);
            jSONObject.put("cap_ap_ref_id", this.x);
            jSONObject.put(WkParams.LONGI, this.y);
            jSONObject.put(WkParams.LATI, this.z);
            jSONObject.put("map_sp", this.A);
            jSONObject.put("net_model", this.B);
            jSONObject.put("dc_type", this.C);
            jSONObject.put("msg", this.D);
            jSONObject.put("ts", this.E);
            jSONObject.put("type", this.F);
            jSONObject.put("os", this.m);
            jSONObject.put("os_api", this.n);
            jSONObject.put("os_name", this.o);
            jSONObject.put(WkParams.MODEL, this.p);
            jSONObject.put("brand", this.q);
            jSONObject.put("harmony_os", this.r);
            jSONObject.put("harmony_os_name", this.s);
            jSONObject.put("oaid", this.k);
            jSONObject.put("android_id", this.l);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
