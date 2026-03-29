package com.zx.a.I8b7;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.zx.module.annotation.Java2C;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class x1 {
    @Java2C.Method2C
    public static native String a(String str) throws NoSuchAlgorithmException, InvalidKeyException;

    public static JSONArray a() {
        JSONArray jSONArray = new JSONArray();
        try {
            Bundle bundleB = b(m3.f16830a);
            if (bundleB == null) {
                return jSONArray;
            }
            for (String str : bundleB.keySet()) {
                if (str.startsWith("ZX_APPID_")) {
                    String string = bundleB.getString(str);
                    if (!TextUtils.isEmpty(string)) {
                        jSONArray.put(string);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            r2.a(e);
        }
        return jSONArray;
    }

    public static Bundle b(Context context) throws PackageManager.NameNotFoundException {
        if (m3.J == null) {
            m3.J = w3.c(context.getApplicationContext()).getApplicationInfo(c(context), 128).metaData;
        }
        return m3.J;
    }

    @Java2C.Method2C
    private static native String b();

    public static String c(Context context) {
        if (TextUtils.isEmpty(m3.g)) {
            m3.g = context.getPackageName();
        }
        return m3.g;
    }

    public static void d(Context context) {
        try {
            m3.e = b(context).getString("ZX_CHANNEL_ID");
            r2.a("initChannelId: , channelId = '" + m3.e + "'");
        } catch (Exception e) {
            r2.a(e);
        }
    }

    public static String a(Context context) throws Exception {
        String strA;
        if (!TextUtils.isEmpty(m3.f)) {
            return m3.f.trim();
        }
        if (context != null) {
            try {
                strA = b(context).getString("ZX_APPID");
            } catch (Exception e) {
                r2.a(e);
                strA = null;
            }
            if (TextUtils.isEmpty(strA)) {
                if (m3.e == null) {
                    d(context);
                }
                if (!TextUtils.isEmpty(m3.e)) {
                    strA = a(c(context));
                } else {
                    throw new IllegalStateException("ZX_APPID not found");
                }
            }
            return strA.trim();
        }
        throw new RuntimeException("context not provided, cannot be null");
    }
}
