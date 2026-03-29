package com.zm.adxsdk.tools;

import android.util.Base64;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class i {
    public static String a(String str) {
        try {
            return new String(Base64.decode(str, 0), StandardCharsets.UTF_8);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
