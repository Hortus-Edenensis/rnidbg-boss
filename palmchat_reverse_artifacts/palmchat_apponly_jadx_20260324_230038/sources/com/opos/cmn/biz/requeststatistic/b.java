package com.opos.cmn.biz.requeststatistic;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.envdev.api.EnvDevConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {
    public static String a(Context context) {
        String reportErrorUrl = "";
        if (context == null) {
            return "";
        }
        try {
            reportErrorUrl = EnvDevConfig.getReportErrorUrl(context);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(reportErrorUrl)) {
            return com.opos.cmn.biz.c.b.a.a(context);
        }
        com.opos.cmn.an.f.a.b("Utils", "getReportUrl pub=" + com.opos.cmn.biz.c.b.a.a(context));
        return reportErrorUrl;
    }

    public static boolean b(Context context) {
        return com.opos.cmn.biz.c.b.a.a();
    }
}
