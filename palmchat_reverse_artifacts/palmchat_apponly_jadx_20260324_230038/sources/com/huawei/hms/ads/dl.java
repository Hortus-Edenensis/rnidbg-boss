package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class dl {
    private static dl V;
    private static final byte[] Z = new byte[0];
    private BroadcastReceiver B;
    private Context I;

    /* JADX INFO: renamed from: com.huawei.hms.ads.dl$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IntentFilter intentFilter = new IntentFilter("com.huawei.hms.pps.action.PPS_REWARD_STATUS_CHANGED");
            dl.this.B = new a(null);
            if (com.huawei.openalliance.ad.utils.z.B(dl.this.I)) {
                com.huawei.openalliance.ad.utils.z.Code(dl.this.I, dl.this.B, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            } else {
                com.huawei.openalliance.ad.msgnotify.b.Code(dl.this.I, com.huawei.openalliance.ad.constant.bp.Code, new NotifyCallback() { // from class: com.huawei.hms.ads.dl.1.1
                    @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
                    public void onMessageNotify(String str, final Intent intent) {
                        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.dl.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (dl.this.B != null) {
                                    dl.this.B.onReceive(dl.this.I, intent);
                                }
                            }
                        });
                    }
                });
            }
            fh.V("RewardAdStatusHandler", "registerPPSReceiver");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends BroadcastReceiver {
        private a() {
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        private boolean Code(int i, com.huawei.openalliance.ad.inter.listeners.h hVar) {
            if (hVar == null) {
                return false;
            }
            if (8 == i) {
                hVar.S();
                return true;
            }
            if (9 != i) {
                return false;
            }
            hVar.C();
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb;
            com.huawei.openalliance.ad.inter.data.i iVarCode;
            fh.V("RewardAdStatusHandler", "onReceive:" + intent.getAction());
            if ("com.huawei.hms.pps.action.PPS_REWARD_STATUS_CHANGED".equals(intent.getAction())) {
                try {
                    iVarCode = dj.Code();
                } catch (Exception e) {
                    e = e;
                    sb = new StringBuilder();
                    sb.append("handler reward status changed error,");
                    sb.append(e.getClass().getSimpleName());
                    fh.Z("RewardAdStatusHandler", sb.toString());
                    return;
                } catch (Throwable th) {
                    e = th;
                    sb = new StringBuilder();
                    sb.append("handler reward status changed error,");
                    sb.append(e.getClass().getSimpleName());
                    fh.Z("RewardAdStatusHandler", sb.toString());
                    return;
                }
                if (iVarCode != null && (iVarCode instanceof com.huawei.openalliance.ad.inter.data.q)) {
                    com.huawei.openalliance.ad.inter.data.q qVar = (com.huawei.openalliance.ad.inter.data.q) iVarCode;
                    com.huawei.openalliance.ad.inter.listeners.g gVarZ = qVar.Z();
                    com.huawei.openalliance.ad.inter.listeners.h hVarI = qVar.I();
                    int intExtra = intent.getIntExtra("reward_ad_status", -1);
                    String stringExtra = intent.getStringExtra("show_id");
                    fh.V("RewardAdStatusHandler", "status:" + intExtra);
                    if (Code(intExtra, hVarI)) {
                        return;
                    }
                    if (gVarZ == null) {
                        fh.I("RewardAdStatusHandler", "there is no status listener");
                        return;
                    }
                    switch (intExtra) {
                        case 1:
                            gVarZ.Code();
                            qVar.Z(true);
                            break;
                        case 2:
                            gVarZ.V();
                            break;
                        case 3:
                            gVarZ.I();
                            break;
                        case 4:
                            gVarZ.Z();
                            break;
                        case 5:
                            if (!qVar.F()) {
                                gVarZ.B();
                                qVar.I(true);
                                AdContentData adContentDataQ = qVar.q();
                                adContentDataQ.I(stringExtra);
                                jk.Code(context, adContentDataQ, qVar.N(), qVar.O(), "");
                            }
                            break;
                        case 6:
                            gVarZ.Code(intent.getIntExtra("reward_ad_error", -1), intent.getIntExtra("reward_ad_extra", -1));
                            break;
                        case 7:
                            if (dl.V != null) {
                                dl.V.V();
                            }
                            break;
                    }
                    return;
                }
                fh.I("RewardAdStatusHandler", "can not get reward");
            }
        }
    }

    private dl(Context context) {
        this.I = context.getApplicationContext();
    }

    private static dl V(Context context) {
        dl dlVar;
        synchronized (Z) {
            if (V == null) {
                V = new dl(context);
            }
            dlVar = V;
        }
        return dlVar;
    }

    public static dl Code(Context context) {
        return V(context);
    }

    public void V() {
        if (this.B != null) {
            com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.dl.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        fh.V("RewardAdStatusHandler", "unregisterPPSReceiver");
                        dl.this.I.unregisterReceiver(dl.this.B);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }
        com.huawei.openalliance.ad.msgnotify.b.Code(this.I, com.huawei.openalliance.ad.constant.bp.Code);
    }

    public void Code() {
        if (this.B != null) {
            V();
        }
        com.huawei.openalliance.ad.utils.bj.Code(new AnonymousClass1());
    }
}
