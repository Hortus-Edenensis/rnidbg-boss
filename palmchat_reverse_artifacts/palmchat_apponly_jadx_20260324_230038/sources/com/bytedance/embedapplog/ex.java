package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ex {
    private static volatile String u;

    public static String u(Context context, mh mhVar) {
        AdvertisingIdClient.Info advertisingIdInfo;
        if (TextUtils.isEmpty(u)) {
            synchronized (ex.class) {
                if (!TextUtils.isEmpty(u)) {
                    return u;
                }
                try {
                    advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                } catch (Throwable unused) {
                }
                String id = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
                if (TextUtils.isEmpty(id)) {
                    id = mhVar.pn().getString("google_aid", null);
                } else if (!TextUtils.equals(mhVar.pn().getString("google_aid", null), id)) {
                    u(context, id, mhVar);
                }
                u = id;
            }
        }
        return u;
    }

    private static void u(Context context, String str, mh mhVar) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        mhVar.pn().edit().putString("google_aid", str).apply();
    }
}
