package com.beizi.ad.lance.a;

import android.content.Context;
import android.text.TextUtils;
import com.wifi.adsdk.entity.LxEventReplace;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class n {
    public static String a(Context context) {
        String strB;
        if (context == null) {
            return "";
        }
        String strD = com.beizi.ad.b.a() != null ? com.beizi.ad.b.a().d() : null;
        return !TextUtils.isEmpty(strD) ? strD : ((com.beizi.ad.b.a() == null || (!com.beizi.ad.b.b() && com.beizi.ad.b.a().c())) && (strB = com.beizi.ad.internal.e.l.b(context, LxEventReplace.__OAID__)) != null) ? strB : "";
    }

    public static String b(Context context) {
        String strB;
        return context == null ? "" : ((com.beizi.ad.b.a() == null || (!com.beizi.ad.b.b() && com.beizi.ad.b.a().c())) && (strB = com.beizi.ad.internal.e.l.b(context, "__HONOROAID__")) != null) ? strB : "";
    }
}
