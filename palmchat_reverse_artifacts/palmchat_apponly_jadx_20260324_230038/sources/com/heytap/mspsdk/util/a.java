package com.heytap.mspsdk.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.heytap.mspsdk.constants.Constants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {
    public static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.htms", 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ApplicationInfo b(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(Constants.MCS_APP_PACK_NAME, 128);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
