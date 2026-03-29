package com.beizi.ad.lance.a;

import android.util.Base64;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {
    public static String a(String str) {
        try {
            return Base64.encodeToString(str.getBytes(), 2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String b(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
