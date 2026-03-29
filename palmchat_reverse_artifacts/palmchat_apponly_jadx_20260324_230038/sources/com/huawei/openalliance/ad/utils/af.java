package com.huawei.openalliance.ad.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.hms.ads.fh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class af extends BroadcastReceiver {
    private static final String Code = "KitPreloadReceiver";
    private static volatile af V;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (com.huawei.openalliance.ad.constant.x.dp.equalsIgnoreCase(new SafeIntent(intent).getAction())) {
                fh.Code(Code, "onReceive kit preload");
                ae.Code(context.getApplicationContext());
            }
        } catch (Throwable th) {
            fh.I(Code, "onReceive Exception: %s", th.getClass().getSimpleName());
        }
    }

    public static void Code(final Context context) {
        i.Z(new Runnable() { // from class: com.huawei.openalliance.ad.utils.af.1
            @Override // java.lang.Runnable
            public void run() {
                if (context != null) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(com.huawei.openalliance.ad.constant.x.dp);
                    if (af.V == null) {
                        af unused = af.V = new af();
                    }
                    z.Code(context, af.V, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
                }
            }
        });
    }
}
