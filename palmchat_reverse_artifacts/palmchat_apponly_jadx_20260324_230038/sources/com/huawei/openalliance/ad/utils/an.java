package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.huawei.hms.ads.fh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class an {
    private static final String Code = "MetaDataUtils";

    public static Integer Code(Context context, String str, String str2) {
        try {
            Object objI = I(context, str, str2);
            if (objI != null) {
                return bc.F(objI.toString());
            }
            return null;
        } catch (Throwable th) {
            fh.I(Code, "getIntegerMetaData %s err: %s", str2, th.getClass().getSimpleName());
            return null;
        }
    }

    private static Object I(Context context, String str, String str2) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return null;
            }
            return bundle.get(str2);
        } catch (Throwable th) {
            fh.I(Code, "getMetaData %d err: %s", str2, th.getClass().getSimpleName());
            return null;
        }
    }

    public static String V(Context context, String str, String str2) {
        try {
            Object objI = I(context, str, str2);
            if (objI != null) {
                return objI.toString();
            }
            return null;
        } catch (Throwable th) {
            fh.I(Code, "getIntegerMetaData %s err: %s", str2, th.getClass().getSimpleName());
            return null;
        }
    }
}
