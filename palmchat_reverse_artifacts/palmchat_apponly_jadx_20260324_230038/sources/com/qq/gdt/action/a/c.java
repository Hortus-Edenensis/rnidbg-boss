package com.qq.gdt.action.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.qq.gdt.action.j.o;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c {
    public static String a(Context context) {
        return a(context, "com.huawei.hwid") ? "com.huawei.hwid" : a(context, "com.huawei.hms") ? "com.huawei.hms" : a(context, "com.huawei.hwid.tv") ? "com.huawei.hwid.tv" : "";
    }

    private static PackageInfo b(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(str, 128);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            o.a("getPackageInfo NameNotFoundException", new Object[0]);
            return null;
        } catch (Exception unused2) {
            o.a("getPackageInfo Exception", new Object[0]);
            return null;
        }
    }

    private static boolean a(Context context, String str) {
        return b(context, str) != null;
    }
}
