package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.hms.ads.inter.data.IInterstitialAd;
import com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener;
import com.huawei.hms.ads.reward.RewardAdListener;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class f {
    private static final byte[] V = new byte[0];
    private static f Z;
    private Context B;
    private BroadcastReceiver C;

    /* JADX INFO: renamed from: com.huawei.hms.ads.f$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IntentFilter intentFilter = new IntentFilter("com.huawei.hms.pps.action.PPS_INTERSTITIAL_STATUS_CHANGED");
            f.this.C = new a(null);
            if (com.huawei.openalliance.ad.utils.z.B(f.this.B)) {
                com.huawei.openalliance.ad.utils.z.Code(f.this.B, f.this.C, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            } else {
                com.huawei.openalliance.ad.msgnotify.b.Code(f.this.B, com.huawei.openalliance.ad.constant.bp.V, new NotifyCallback() { // from class: com.huawei.hms.ads.f.1.1
                    @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
                    public void onMessageNotify(String str, final Intent intent) {
                        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.f.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (f.this.C != null) {
                                    f.this.C.onReceive(f.this.B, intent);
                                }
                            }
                        });
                    }
                });
            }
            fh.V("InterstitialAdStatusHandler", "registerPpsReceiver");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends BroadcastReceiver {
        private a() {
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        private boolean Code(int i, RewardAdListener rewardAdListener) {
            if (rewardAdListener == null) {
                return false;
            }
            if (i == 8) {
                rewardAdListener.onRewardAdLeftApp();
                return false;
            }
            if (i != 9) {
                return false;
            }
            rewardAdListener.onRewardAdStarted();
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb;
            IInterstitialAd iInterstitialAdCode;
            fh.V("InterstitialAdStatusHandler", "onReceive:" + intent.getAction());
            if ("com.huawei.hms.pps.action.PPS_INTERSTITIAL_STATUS_CHANGED".equals(intent.getAction())) {
                try {
                    iInterstitialAdCode = g.Code();
                } catch (Exception e) {
                    e = e;
                    sb = new StringBuilder();
                    sb.append("handler interstitial status changed error,");
                    sb.append(e.getClass().getSimpleName());
                    fh.Z("InterstitialAdStatusHandler", sb.toString());
                } catch (Throwable th) {
                    e = th;
                    sb = new StringBuilder();
                    sb.append("handler interstitial status changed error,");
                    sb.append(e.getClass().getSimpleName());
                    fh.Z("InterstitialAdStatusHandler", sb.toString());
                }
                if (!(iInterstitialAdCode instanceof com.huawei.hms.ads.inter.data.a)) {
                    fh.I("InterstitialAdStatusHandler", "can not get interstitial ad.");
                    return;
                }
                com.huawei.hms.ads.inter.data.a aVar = (com.huawei.hms.ads.inter.data.a) iInterstitialAdCode;
                IInterstitialAdStatusListener iInterstitialAdStatusListenerI = aVar.I();
                RewardAdListener rewardAdListenerCode = aVar.Code();
                int intExtra = intent.getIntExtra("interstitial_ad_status", -1);
                fh.V("InterstitialAdStatusHandler", "status:" + intExtra);
                if (Code(intExtra, rewardAdListenerCode)) {
                    return;
                }
                if (iInterstitialAdStatusListenerI == null) {
                    fh.I("InterstitialAdStatusHandler", "there is no status listener");
                    return;
                }
                switch (intExtra) {
                    case 1:
                        iInterstitialAdStatusListenerI.onAdShown();
                        aVar.Z(true);
                        break;
                    case 2:
                        iInterstitialAdStatusListenerI.onAdClicked();
                        break;
                    case 3:
                        iInterstitialAdStatusListenerI.onAdCompleted();
                        break;
                    case 4:
                        iInterstitialAdStatusListenerI.onAdClosed();
                        break;
                    case 5:
                        if (!aVar.F()) {
                            iInterstitialAdStatusListenerI.onRewarded();
                            aVar.I(true);
                            jk.Code(context, aVar.q(), aVar.N(), aVar.O(), "");
                        }
                        break;
                    case 6:
                        iInterstitialAdStatusListenerI.onAdError(intent.getIntExtra("interstitial_ad_error", -1), intent.getIntExtra("interstitial_ad_extra", -1));
                        break;
                    case 7:
                        if (f.Z != null) {
                            f.Z.I();
                        }
                        break;
                    case 8:
                        iInterstitialAdStatusListenerI.onLeftApp();
                        break;
                }
            }
        }
    }

    private f(Context context) {
        if (context != null) {
            this.B = context.getApplicationContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        if (this.C != null) {
            com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.f.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        fh.V("InterstitialAdStatusHandler", "unregisterPpsReceiver");
                        f.this.B.unregisterReceiver(f.this.C);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }
        com.huawei.openalliance.ad.msgnotify.b.Code(this.B, com.huawei.openalliance.ad.constant.bp.V);
    }

    public static f Code(Context context) {
        return V(context);
    }

    private static synchronized f V(Context context) {
        f fVar;
        synchronized (V) {
            if (Z == null) {
                Z = new f(context);
            }
            fVar = Z;
        }
        return fVar;
    }

    public void Code() {
        if (this.C != null) {
            I();
        }
        com.huawei.openalliance.ad.utils.bj.Code(new AnonymousClass1());
    }
}
