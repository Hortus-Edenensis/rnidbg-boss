package com.opos.cmn.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {
    public static String a(String str) {
        return !com.opos.cmn.an.d.b.a(str) ? com.opos.cmn.an.b.c.a(str) : "";
    }

    public static boolean a(String str, String str2) {
        boolean zEquals = com.opos.cmn.an.e.b.a.a(str) ? !com.opos.cmn.an.d.b.a(str2) ? com.opos.cmn.an.b.c.b(str).equals(str2) : true : false;
        StringBuilder sb = new StringBuilder();
        sb.append("verifyFileIntegrity filePath=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",md5=");
        if (str2 == null) {
            str2 = com.igexin.push.core.b.m;
        }
        sb.append(str2);
        sb.append(",result=");
        sb.append(zEquals);
        com.opos.cmn.an.f.a.b("FileVerifier", sb.toString());
        return zEquals;
    }
}
