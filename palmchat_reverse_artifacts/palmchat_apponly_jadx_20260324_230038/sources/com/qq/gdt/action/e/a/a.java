package com.qq.gdt.action.e.a;

import com.qq.gdt.action.j.o;
import com.umeng.analytics.pro.bt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10478a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("add_time", this.f10478a);
            jSONObject.put("boot_time", this.b);
            jSONObject.put("boot_time_fix", this.c);
            jSONObject.put("bootid", this.d);
            jSONObject.put("build_board", this.e);
            jSONObject.put("build_brand", this.f);
            jSONObject.put("build_device", this.g);
            jSONObject.put("build_time", this.h);
            jSONObject.put("build_model", this.i);
            jSONObject.put("build_incremental", this.j);
            jSONObject.put("build_release", this.k);
            jSONObject.put("build_manufacturer", this.l);
            jSONObject.put("country", this.m);
            jSONObject.put(bt.M, this.n);
            jSONObject.put("language", this.o);
            jSONObject.put("node_md5", this.p);
            jSONObject.put("node_detail", this.q);
            jSONObject.put("last_md5", this.r);
        } catch (JSONException e) {
            o.c("getACaidObj e: " + e);
        }
        return jSONObject;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.d = str;
    }

    public void e(String str) {
        this.e = str;
    }

    public void f(String str) {
        this.f = str;
    }

    public void g(String str) {
        this.g = str;
    }

    public void h(String str) {
        this.h = str;
    }

    public void i(String str) {
        this.i = str;
    }

    public void j(String str) {
        this.j = str;
    }

    public void k(String str) {
        this.k = str;
    }

    public void l(String str) {
        this.l = str;
    }

    public void m(String str) {
        this.m = str;
    }

    public void n(String str) {
        this.n = str;
    }

    public void o(String str) {
        this.o = str;
    }

    public void p(String str) {
        this.p = str;
    }

    public void q(String str) {
        this.q = str;
    }

    public void r(String str) {
        this.r = str;
    }

    public String toString() {
        return "ACaidInfo{addTime='" + this.f10478a + "', bootTime='" + this.b + "', bootTimeFix='" + this.c + "', bootid='" + this.d + "', buildBoard='" + this.e + "', buildBrand='" + this.f + "', buildDevice='" + this.g + "', buildTime='" + this.h + "', buildModel='" + this.i + "', buildIncremental='" + this.j + "', buildRelease='" + this.k + "', buildManufacturer='" + this.l + "', country='" + this.m + "', timezone='" + this.n + "', language='" + this.o + "', nodeMd5='" + this.p + "', nodeDetail='" + this.q + "', lastMd5='" + this.r + "'}";
    }

    public void a(String str) {
        this.f10478a = str;
    }
}
