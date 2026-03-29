package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.constant.bq;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class g {
    private static final String B = "com.huawei.hwid";
    public static final long Code = 1;
    private static final long I = 30476310;
    private static final String V = "AgentUtil";
    private static final String Z = "hwpps://ad";

    public static boolean Code(Context context, long j) {
        if (j < 1) {
            fh.I(V, "can't jump agent, agent id is invalid, cur agent id: %s", Long.valueOf(j));
            return false;
        }
        int iCode = o.Code(context);
        fh.V(V, "cur dc version is %d", Integer.valueOf(iCode));
        if (iCode >= I) {
            return true;
        }
        fh.I(V, "can't jump agent, dc version is invalid");
        return false;
    }

    public static boolean Code(Context context, String str, long j) {
        fh.V(V, "start jump agent");
        try {
            SafeIntent safeIntent = new SafeIntent(Intent.parseUri("hwpps://ad", 1));
            safeIntent.setFlags(335544320);
            safeIntent.setPackage("com.huawei.hwid");
            safeIntent.putExtra(bq.f.ah, j);
            safeIntent.putExtra(bq.f.ai, true);
            safeIntent.putExtra("clickUrl", str);
            context.startActivity(safeIntent);
            return true;
        } catch (Throwable th) {
            fh.I(V, "start agent err: %s", th.getClass().getSimpleName());
            return false;
        }
    }
}
