package com.alipay.apmobilesecuritysdk.c;

import android.content.Context;
import android.os.Build;
import defpackage.mv6;
import defpackage.o87;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static synchronized void a(Context context, String str, String str2, String str3) {
        mv6 mv6VarB = b(context, str, str2, str3);
        o87.b(context.getFilesDir().getAbsolutePath() + "/log/ap", new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log", mv6VarB.toString());
    }

    public static mv6 b(Context context, String str, String str2, String str3) {
        String packageName;
        try {
            packageName = context.getPackageName();
        } catch (Throwable unused) {
            packageName = "";
        }
        return new mv6(Build.MODEL, packageName, "APPSecuritySDK-ALIPAYSDK", "3.4.0.202203211140", str, str2, str3);
    }

    public static synchronized void a(String str) {
        o87.a(str);
    }

    public static synchronized void a(Throwable th) {
        o87.c(th);
    }
}
