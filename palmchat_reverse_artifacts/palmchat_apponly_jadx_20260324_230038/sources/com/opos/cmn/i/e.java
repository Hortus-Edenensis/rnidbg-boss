package com.opos.cmn.i;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e {
    public static String a() {
        String property;
        try {
            property = System.getProperty("http.agent");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("DeviceUtils", "getUserAgent()", e);
            property = "";
        }
        Object[] objArr = new Object[2];
        objArr[0] = "getUserAgent() result=";
        objArr[1] = property != null ? property : com.igexin.push.core.b.m;
        com.opos.cmn.an.f.a.b("DeviceUtils", objArr);
        return property;
    }
}
