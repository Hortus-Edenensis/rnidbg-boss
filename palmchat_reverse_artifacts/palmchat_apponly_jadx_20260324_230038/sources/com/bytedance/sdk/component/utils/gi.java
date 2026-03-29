package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class gi {
    private static final Object u = new Object();
    private static final Map<u, Object> nr = new ConcurrentHashMap();
    private static AtomicBoolean fx = new AtomicBoolean(false);
    private static volatile int b = -1;
    private static volatile long pn = 0;
    private static volatile int iz = 60000;
    private static sx x = null;
    private static final AtomicBoolean n = new AtomicBoolean(false);

    /* JADX INFO: compiled from: SearchBox */
    public static class nr extends BroadcastReceiver {
        private nr() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            if (gi.nr != null && gi.nr.size() > 0) {
                z = true;
            }
            gi.nr(context, intent, z, booleanExtra);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(Context context, Intent intent, boolean z, int i);
    }

    private static int fx(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 1 : 4;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 3;
                    case 13:
                    case 18:
                    case 19:
                        sx sxVar = x;
                        return (sxVar == null || !sxVar.u(context, telephonyManager)) ? 5 : 6;
                    case 20:
                        return 6;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        return (TextUtils.isEmpty(subtypeName) || !(subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) ? 1 : 3;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(final Context context, final Intent intent, final boolean z, final boolean z2) {
        if (!z && z2) {
            b = 0;
        } else if (n.compareAndSet(false, true)) {
            com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("getNetworkType") { // from class: com.bytedance.sdk.component.utils.gi.1
                @Override // java.lang.Runnable
                public void run() {
                    int unused = gi.b = z2 ? 0 : gi.nr(context);
                    if (z) {
                        gi.nr(context, intent, gi.b, z2);
                    }
                    gi.n.set(false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(Context context, Intent intent, int i, boolean z) {
        Map<u, Object> map = nr;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (u uVar : map.keySet()) {
            if (uVar != null) {
                uVar.u(context, intent, !z, i);
            }
        }
    }

    public static void u(sx sxVar) {
        x = sxVar;
    }

    public static int u(Context context, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (pn + j <= jElapsedRealtime) {
            return nr(context);
        }
        if (b == -1) {
            return nr(context);
        }
        if (jElapsedRealtime - pn >= iz) {
            nr(context, (Intent) null, false, false);
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int nr(Context context) {
        b = fx(context);
        pn = SystemClock.elapsedRealtime();
        return b;
    }

    public static void u(u uVar, Context context) {
        if (uVar == null) {
            return;
        }
        if (!fx.get()) {
            try {
                context.registerReceiver(new nr(), new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
                fx.set(true);
            } catch (Throwable unused) {
            }
        }
        nr.put(uVar, u);
    }

    public static void u(u uVar) {
        if (uVar == null) {
            return;
        }
        nr.remove(uVar);
    }
}
