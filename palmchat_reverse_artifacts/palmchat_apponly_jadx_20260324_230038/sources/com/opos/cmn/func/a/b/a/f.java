package com.opos.cmn.func.a.b.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class f {
    public static String a() {
        try {
            return System.getProperty("http.agent");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("Utils", "getUA", e);
            return "";
        }
    }
}
