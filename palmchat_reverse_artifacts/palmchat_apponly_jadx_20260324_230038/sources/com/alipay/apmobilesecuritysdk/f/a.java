package com.alipay.apmobilesecuritysdk.f;

import android.content.Context;
import android.os.Environment;
import defpackage.a47;
import defpackage.m37;
import defpackage.o07;
import defpackage.xa7;
import defpackage.xu6;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        if (context == null || xu6.c(str) || xu6.c(str2)) {
            return null;
        }
        try {
            String strA = xa7.a(context, str, str2, "");
            if (xu6.c(strA)) {
                return null;
            }
            return m37.e(m37.a(), strA);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str, String str2) {
        synchronized (a.class) {
            if (xu6.c(str) || xu6.c(str2)) {
                return null;
            }
            try {
                String strA = o07.a(str);
                if (xu6.c(strA)) {
                    return null;
                }
                String string = new JSONObject(strA).getString(str2);
                if (xu6.c(string)) {
                    return null;
                }
                return m37.e(m37.a(), string);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (xu6.c(str) || xu6.c(str2) || context == null) {
            return;
        }
        try {
            String strB = m37.b(m37.a(), str3);
            HashMap map = new HashMap();
            map.put(str2, strB);
            xa7.b(context, str, map);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, String str3) {
        synchronized (a.class) {
            if (xu6.c(str) || xu6.c(str2)) {
                return;
            }
            try {
                String strA = o07.a(str);
                JSONObject jSONObject = new JSONObject();
                if (xu6.f(strA)) {
                    try {
                        jSONObject = new JSONObject(strA);
                    } catch (Exception unused) {
                        jSONObject = new JSONObject();
                    }
                }
                jSONObject.put(str2, m37.b(m37.a(), str3));
                jSONObject.toString();
                try {
                    System.clearProperty(str);
                } catch (Throwable unused2) {
                }
                if (a47.b()) {
                    String str4 = ".SystemConfig" + File.separator + str;
                    if (a47.b()) {
                        File file = new File(Environment.getExternalStorageDirectory(), str4);
                        if (file.exists() && file.isFile()) {
                            file.delete();
                        }
                    }
                }
            } catch (Throwable unused3) {
            }
        }
    }
}
