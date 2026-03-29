package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class dm {
    private static dm I;
    private static final byte[] V = new byte[0];
    private BroadcastReceiver B;
    private Context Z;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("com.huawei.hms.pps.action.PPS_SPLASH_INTERACT_CLOSE_CONFIG_CHANGED".equals(intent.getAction())) {
                    eh.Code(context).B(intent.getStringExtra("splash_interact_close_expiretime"));
                }
            } catch (Throwable th) {
                fh.I("SplashAdInteractConfigHandler", "SplashAdBroadcastReceiver error: %s", th.getClass().getSimpleName());
            }
            dm.I.V();
        }
    }

    private dm(Context context) {
        if (context != null) {
            this.Z = context.getApplicationContext();
        }
    }

    private static synchronized dm V(Context context) {
        dm dmVar;
        synchronized (V) {
            if (I == null) {
                I = new dm(context);
            }
            dmVar = I;
        }
        return dmVar;
    }

    public static dm Code(Context context) {
        return V(context);
    }

    public void V() {
        if (this.B != null) {
            com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.dm.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        fh.V("SplashAdInteractConfigHandler", "unregisterPpsReceiver");
                        dm.this.Z.unregisterReceiver(dm.this.B);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }
    }

    public void Code() {
        Code(new a());
    }

    public void Code(final BroadcastReceiver broadcastReceiver) {
        fh.Code("SplashAdInteractConfigHandler", "registerPpsReceiver ");
        if (this.B != null) {
            V();
        }
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.dm.1
            @Override // java.lang.Runnable
            public void run() {
                IntentFilter intentFilter = new IntentFilter("com.huawei.hms.pps.action.PPS_SPLASH_INTERACT_CLOSE_CONFIG_CHANGED");
                dm.this.B = broadcastReceiver;
                if (com.huawei.openalliance.ad.utils.z.B(dm.this.Z)) {
                    com.huawei.openalliance.ad.utils.z.Code(dm.this.Z, dm.this.B, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
                } else {
                    com.huawei.openalliance.ad.msgnotify.b.Code(dm.this.Z, com.huawei.openalliance.ad.constant.bp.Z, new NotifyCallback() { // from class: com.huawei.hms.ads.dm.1.1
                        @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
                        public void onMessageNotify(String str, Intent intent) {
                            if (dm.this.B != null) {
                                dm.this.B.onReceive(dm.this.Z, intent);
                            }
                        }
                    });
                }
                fh.V("SplashAdInteractConfigHandler", "registerPpsReceiver");
            }
        });
    }
}
