package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;
import defpackage.m37;
import defpackage.xa7;
import defpackage.xu6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class g {
    public static synchronized String a(Context context, String str) {
        String strA = xa7.a(context, "openapi_file_pri", "openApi" + str, "");
        if (xu6.c(strA)) {
            return "";
        }
        String strE = m37.e(m37.a(), strA);
        return xu6.c(strE) ? "" : strE;
    }

    public static synchronized void a() {
    }

    public static synchronized void a(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("openapi_file_pri", 0).edit();
        if (editorEdit != null) {
            editorEdit.clear();
            editorEdit.commit();
        }
    }

    public static synchronized void a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("openapi_file_pri", 0).edit();
            if (editorEdit != null) {
                editorEdit.putString("openApi" + str, m37.b(m37.a(), str2));
                editorEdit.commit();
            }
        } catch (Throwable unused) {
        }
    }
}
