package com.zm.fda.oaid.Z2500;

import android.util.Base64;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OO22Z {
    public static String a(String str) {
        try {
            String str2 = new String(Base64.decode(str, 0), StandardCharsets.UTF_8);
            Z25O0.a("Base64Util", "decodeStr:" + str2);
            return str2;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
