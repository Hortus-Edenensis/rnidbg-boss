package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.fh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class x {
    private static final String Code = "HarmonyUtils";
    private static final int V = 1048576;

    private static boolean Code(int i) {
        return (i & 1048576) != 0;
    }

    public static boolean Code(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            boolean zCode = Code(new s().Code(h.C(context.getApplicationContext(), str), context));
            fh.V(Code, "isHarmonyApp: %s", Boolean.valueOf(zCode));
            return zCode;
        } catch (Throwable unused) {
            fh.I(Code, "isHarmonyApp exception");
            return false;
        }
    }
}
