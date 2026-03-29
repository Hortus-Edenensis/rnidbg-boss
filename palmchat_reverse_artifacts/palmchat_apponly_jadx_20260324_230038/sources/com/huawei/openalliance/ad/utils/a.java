package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.fh;
import com.huawei.hms.analytics.HiAnalytics;
import defpackage.Task;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {
    private static final String Code = "AaidUtil";

    public static String Code(final Context context) {
        if (!Code()) {
            return "";
        }
        final at atVarCode = at.Code(context);
        String strD = atVarCode.D();
        if (TextUtils.isEmpty(strD)) {
            i.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Task aaid = HiAnalytics.getInstance(context).getAAID();
                        if (aaid != null) {
                            atVarCode.I((String) aaid.e());
                        }
                    } catch (Throwable th) {
                        fh.I(a.Code, "error getAgcAaid: " + th.getClass().getSimpleName());
                    }
                }
            });
        }
        return strD;
    }

    public static boolean Code() {
        return au.B(com.huawei.openalliance.ad.constant.x.bZ);
    }
}
