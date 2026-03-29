package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import defpackage.c97;
import defpackage.o27;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class d {
    public static synchronized Map<String, String> a() {
        HashMap map;
        map = new HashMap();
        try {
            new com.alipay.apmobilesecuritysdk.c.b();
            map.put("AE16", "");
        } catch (Throwable unused) {
        }
        return map;
    }

    public static synchronized Map<String, String> a(Context context) {
        HashMap map;
        c97.a();
        o27.e();
        map = new HashMap();
        map.put("AE1", c97.d());
        StringBuilder sb = new StringBuilder();
        sb.append(c97.e() ? "1" : "0");
        map.put("AE2", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(c97.c(context) ? "1" : "0");
        map.put("AE3", sb2.toString());
        map.put("AE4", c97.f());
        map.put("AE5", c97.g());
        map.put("AE6", c97.h());
        map.put("AE7", c97.i());
        map.put("AE8", c97.j());
        map.put("AE9", c97.k());
        map.put("AE10", c97.l());
        map.put("AE11", c97.m());
        map.put("AE12", c97.n());
        map.put("AE13", c97.o());
        map.put("AE14", c97.p());
        map.put("AE15", c97.q());
        map.put("AE21", o27.o());
        return map;
    }
}
