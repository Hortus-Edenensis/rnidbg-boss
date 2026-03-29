package com.qq.gdt.action.j;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class i {
    public static String a(String str) {
        return a(str, "UTF-8");
    }

    public static byte[] b(String str) {
        return Base64.decode(str, 2);
    }

    private static String a(String str, String str2) {
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }
}
