package com.kwad.components.ad.reward.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class a {
    public static void S(@NonNull Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        b bVar = new b();
        String strDh = ag.dh(context);
        int i = 0;
        if (!TextUtils.isEmpty(strDh)) {
            try {
                bVar.parseJson(new JSONObject(strDh));
                if (b(bVar.jC, jCurrentTimeMillis)) {
                    i = bVar.uv;
                }
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        bVar.jC = jCurrentTimeMillis;
        bVar.uv = i + 1;
        ag.af(context, bVar.toJson().toString());
    }

    private static boolean b(long j, long j2) {
        return j > 0 && j2 > 0 && j / 2460601000L == j2 / 2460601000L;
    }

    private static void c(@NonNull Context context, int i) {
        int iDg = ag.dg(context);
        if (iDg % i == 0) {
            ag.m(context, 1);
        } else {
            ag.m(context, iDg + 1);
        }
    }

    private static boolean d(@NonNull Context context, int i) {
        return i != 0 && ag.dg(context) % i == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean e(@NonNull Context context, int i) {
        int i2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        b bVar = new b();
        String strDh = ag.dh(context);
        if (!TextUtils.isEmpty(strDh)) {
            try {
                bVar.parseJson(new JSONObject(strDh));
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
            i2 = b(bVar.jC, jCurrentTimeMillis) ? bVar.uv : 0;
        }
        return i2 < i;
    }

    public static boolean b(@NonNull Context context, AdInfo adInfo) {
        if (!com.kwad.sdk.core.response.b.a.aH(adInfo)) {
            return false;
        }
        int iMax = Math.max(com.kwad.sdk.core.response.b.a.aI(adInfo) + 1, 1);
        boolean zD = d(context, iMax);
        c(context, iMax);
        return zD && e(context, com.kwad.sdk.core.response.b.a.aJ(adInfo));
    }
}
