package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ez {
    private static final String Code = "LinkedAdStatusHandler";
    private static final int I = 0;
    private static final byte[] V = new byte[0];
    private static ez Z;
    private Context B;
    private BroadcastReceiver C;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (fa.Code.equals(intent.getAction())) {
                    boolean booleanExtra = intent.getBooleanExtra(fa.I, false);
                    int intExtra = intent.getIntExtra(fa.Z, 0);
                    fh.V(ez.Code, "LinkedAdBroadcastReceiver playProgress " + intExtra);
                    ex exVar = new ex();
                    exVar.V(booleanExtra);
                    exVar.Code(intExtra);
                    ey.Code(exVar);
                }
            } catch (Throwable th) {
                fh.I(ez.Code, "LinkedAdBroadcastReceiver error: %s", th.getClass().getSimpleName());
            }
        }
    }

    private ez(Context context) {
        if (context != null) {
            this.B = context.getApplicationContext();
        }
    }

    private static synchronized ez V(Context context) {
        ez ezVar;
        synchronized (V) {
            if (Z == null) {
                Z = new ez(context);
            }
            ezVar = Z;
        }
        return ezVar;
    }

    public static ez Code(Context context) {
        return V(context);
    }

    public void V() {
        if (this.C != null) {
            com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ez.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        fh.V(ez.Code, "unregisterPpsReceiver");
                        ez.this.B.unregisterReceiver(ez.this.C);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }
        com.huawei.openalliance.ad.msgnotify.b.Code(this.B, com.huawei.openalliance.ad.constant.bp.I);
    }

    public void Code() {
        Code(new a());
    }

    public void Code(final BroadcastReceiver broadcastReceiver) {
        fh.Code(Code, "registerPpsReceiver ");
        if (this.C != null) {
            V();
        }
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ez.1
            @Override // java.lang.Runnable
            public void run() {
                IntentFilter intentFilter = new IntentFilter(fa.Code);
                intentFilter.addAction(fa.V);
                ez.this.C = broadcastReceiver;
                if (com.huawei.openalliance.ad.utils.z.B(ez.this.B)) {
                    com.huawei.openalliance.ad.utils.z.Code(ez.this.B, ez.this.C, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
                } else {
                    com.huawei.openalliance.ad.msgnotify.b.Code(ez.this.B, com.huawei.openalliance.ad.constant.bp.I, new NotifyCallback() { // from class: com.huawei.hms.ads.ez.1.1
                        @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
                        public void onMessageNotify(String str, Intent intent) {
                            if (ez.this.C != null) {
                                ez.this.C.onReceive(ez.this.B, intent);
                            }
                        }
                    });
                }
                fh.V(ez.Code, "registerPpsReceiver");
            }
        });
    }
}
