package com.opos.mobad.service.e;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {
    private static String a(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 0) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static String a(String str, String str2, String str3) {
        return str.replace(str2, a(str3));
    }
}
