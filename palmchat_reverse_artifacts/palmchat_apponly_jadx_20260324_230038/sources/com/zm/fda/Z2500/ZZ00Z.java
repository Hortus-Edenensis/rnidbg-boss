package com.zm.fda.Z2500;

import android.app.ApplicationErrorReport;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.zm.fda.O52OZ.OOZ20;
import com.zm.fda.Z0225.Z200O;
import com.zm.fda.busi.IPubParams;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ00Z {
    public static final String A = "netModel";
    public static final String B = "005011";
    public static final String e = "1";
    public static final String f = "0";
    public static final String g = "a";
    public static final String h = "m";
    public static final String i = "ed";
    public static final String j = "B64";
    public static final String k = "ev";
    public static final String l = "et";
    public static final String m = "st";
    public static final String n = "ts";
    public static final String o = "sign";
    public static final String p = "dcType";
    public static final String q = "msg";
    public static final String r = "dhid";
    public static final String s = "verName";
    public static final String t = "verCode";
    public static final String u = "sdkId";
    public static final String v = "sdkVersionCode";
    public static final String w = "sdkVersionName";
    public static final String x = "appId";
    public static final String y = "chanId";
    public static final String z = "mac";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ApplicationErrorReport f16700a;
    public String b;
    public Z200O c;
    public IPubParams d;

    public ZZ00Z(Throwable th, int i2, Context context, Z200O z200o) {
        ApplicationErrorReport applicationErrorReport = new ApplicationErrorReport();
        this.f16700a = applicationErrorReport;
        applicationErrorReport.packageName = context.getPackageName();
        this.f16700a.processName = com.zm.fda.O52OZ.ZZ00Z.b(context);
        this.f16700a.time = System.currentTimeMillis();
        ApplicationErrorReport applicationErrorReport2 = this.f16700a;
        applicationErrorReport2.type = i2;
        applicationErrorReport2.crashInfo = new ApplicationErrorReport.CrashInfo(th);
        this.b = new com.zm.fda.Z2500.Z0O00.ZZ00Z.Z0225(context, z200o, this.f16700a).toString();
        this.c = z200o;
        if (z200o != null) {
            this.d = z200o.i();
        }
    }

    private String a() {
        if (TextUtils.isEmpty(this.b) || this.c == null || this.d == null) {
            return "";
        }
        HashMap map = new HashMap();
        String strB = com.zm.fda.OOZ20.ZZ00Z.b();
        map.put("appId", strB);
        map.put("chanId", this.d.getChanId());
        map.put("verName", this.c.p());
        map.put("verCode", String.valueOf(this.c.p()));
        map.put(u, this.d.getProjectId());
        map.put(w, this.d.getProjectVerName());
        map.put(v, String.valueOf(this.d.getProjectVerCode()));
        String dhid = this.d.getDHID();
        if (TextUtils.isEmpty(dhid)) {
            dhid = a(strB, this.d.getAndroidId());
        }
        map.put("dhid", dhid);
        map.put("mac", this.d.getMac());
        map.put("netModel", this.c.f());
        map.put("ts", String.valueOf(System.currentTimeMillis()));
        map.put("dcType", "005011");
        map.put("msg", this.b);
        return a(map, com.zm.fda.OOZ20.ZZ00Z.d(), com.zm.fda.OOZ20.ZZ00Z.c());
    }

    private Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("ed", a());
        if (this.d != null) {
            map.put("appId", com.zm.fda.OOZ20.ZZ00Z.b());
        }
        map.put("et", "a");
        map.put(j, "1");
        map.put(k, "0");
        map.put("st", "m");
        if (this.d != null) {
            map.put("sign", OOZ20.a(map, com.zm.fda.OOZ20.ZZ00Z.e()));
        }
        return map;
    }

    public ApplicationErrorReport b() {
        return this.f16700a;
    }

    public byte[] d() {
        return com.zm.fda.OOZ20.OO22Z.a(c());
    }

    private String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        return OOZ20.a(str + str2);
    }

    private String a(Map<String, String> map, String str, String str2) {
        try {
            return com.zm.fda.O52OZ.OO22Z.b(new String(Base64.encode(new JSONObject(map).toString().getBytes("UTF-8"), 0), "UTF-8"), "AES/CBC/NoPadding", str, str2);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
