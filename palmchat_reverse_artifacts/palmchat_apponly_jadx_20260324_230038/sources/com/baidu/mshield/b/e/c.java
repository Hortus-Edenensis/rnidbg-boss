package com.baidu.mshield.b.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c {
    public static PackageInfo a(Context context, String str, int i) {
        try {
            com.baidu.mshield.b.c.a.a("---privacy getPackageInfo---" + System.currentTimeMillis());
            return com.baidu.sec.privacy.e.c.a(context).a(str, i);
        } catch (PackageManager.NameNotFoundException e) {
            com.baidu.mshield.b.c.a.a(e);
            return null;
        }
    }
}
