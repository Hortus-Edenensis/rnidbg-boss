package com.opos.cmn.an.b;

import java.net.URLDecoder;
import java.net.URLEncoder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d {
    public static String a(String str) {
        return a(str, "UTF-8");
    }

    public static String b(String str) {
        return b(str, "UTF-8");
    }

    public static String a(String str, String str2) {
        if (!com.opos.cmn.an.d.b.a(str) && !com.opos.cmn.an.d.b.a(str2)) {
            try {
                return URLEncoder.encode(str, str2);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("UrlCoderTool", "encode", e);
            }
        }
        return "";
    }

    public static String b(String str, String str2) {
        if (!com.opos.cmn.an.d.b.a(str) && !com.opos.cmn.an.d.b.a(str2)) {
            try {
                return URLDecoder.decode(str, str2);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("UrlCoderTool", "decode", e);
            }
        }
        return "";
    }
}
