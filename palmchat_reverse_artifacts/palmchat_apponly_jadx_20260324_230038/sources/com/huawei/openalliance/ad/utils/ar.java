package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.text.TextUtils;
import com.huawei.hms.ads.fh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ar {
    private static final String Code = "PackageNameUtil";

    public static String Code(Context context) {
        if (context.getPackageManager() != null) {
            return Code(context, Binder.getCallingUid(), Binder.getCallingPid());
        }
        fh.I(Code, "pm is null");
        return "";
    }

    private static String Code(Context context, int i) {
        return null;
    }

    private static String Code(Context context, int i, int i2) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return "";
        }
        try {
            String nameForUid = packageManager.getNameForUid(i);
            if (!TextUtils.isEmpty(nameForUid) && nameForUid.contains(":")) {
                fh.V(Code, "pkg=" + nameForUid);
                nameForUid = Code(context, i2);
            }
            if (!TextUtils.isEmpty(nameForUid)) {
                return nameForUid;
            }
            String[] packagesForUid = packageManager.getPackagesForUid(i);
            return !ag.Code(packagesForUid) ? packagesForUid[0] : nameForUid;
        } catch (Throwable unused) {
            fh.I(Code, "get name for uid error");
            return "";
        }
    }
}
