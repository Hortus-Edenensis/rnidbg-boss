package com.huawei.openalliance.ad.utils;

import android.content.Context;
import com.huawei.hms.ads.db;
import com.huawei.hms.ads.kw;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class av {
    public static void Code(final Context context, final kw kwVar, final String str) {
        if (kwVar == null) {
            return;
        }
        i.Code(new Runnable() { // from class: com.huawei.openalliance.ad.utils.av.1
            @Override // java.lang.Runnable
            public void run() {
                db.Code(context, kwVar, str);
            }
        });
    }
}
