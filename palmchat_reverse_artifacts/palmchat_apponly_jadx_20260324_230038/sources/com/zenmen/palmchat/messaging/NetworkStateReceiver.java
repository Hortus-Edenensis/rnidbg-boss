package com.zenmen.palmchat.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.RemoteException;
import com.igexin.sdk.PushConsts;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.modulemanager.LXModuleInitManager;
import com.zenmen.palmchat.privinfo.PrivInfoManager;
import com.zenmen.palmchat.update.UpdateManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ch;
import defpackage.hx3;
import defpackage.ia3;
import defpackage.iq5;
import defpackage.ir5;
import defpackage.it0;
import defpackage.r75;
import defpackage.sk5;
import defpackage.zh6;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class NetworkStateReceiver extends BroadcastReceiver {
    public static final String b = "NetworkStateReceiver";
    public static long c = 0;
    public static long d = 5000;
    public static long e;
    public static int f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f14691a = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("action", "vpn_connected");
            put("status", "start");
            put("detail", "disconnect current connection");
        }
    }

    public final boolean a() {
        if (!r75.l()) {
            return false;
        }
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.isUp() && networkInterface.getInterfaceAddresses().size() != 0 && networkInterface.getName().equals("tun0")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) AppContext.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            int type = activeNetworkInfo.getType();
            if (type != f) {
                it0.k().e("network changed to " + hx3.h());
            } else if (jCurrentTimeMillis - e > d) {
                it0.k().s("network changed to " + hx3.h());
            }
            e = jCurrentTimeMillis;
            f = type;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
            LogUtil.e("NetworkStateReceiver", "onReceive CONNECTIVITY_ACTION" + this.f14691a);
            if (this.f14691a == 0) {
                this.f14691a = System.currentTimeMillis();
                return;
            }
            hx3.o();
            boolean zM = hx3.m(context);
            zh6.c().h();
            if (zM) {
                b();
                if (a() && ch.s().t() == 1 && Math.abs(c - ir5.b()) > 5000) {
                    LogUtil.i(b, 3, new a(), (Throwable) null);
                    try {
                        ch.s().u().E();
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                    c = ir5.b();
                }
                AppContext.getContext().initMessagingService("STASRT_REASON_NET_AVAILABLE");
                iq5.j(false, new String[0]);
                UpdateManager.G().w();
                LXModuleInitManager.getInstance().onNetAvailable();
            } else {
                f = -1;
            }
            ch.s().I0(zM ? 1 : 0, true);
            sk5.c(zM);
            PrivInfoManager.INSTANCE.onNetStateChange();
            ia3.d().g();
        }
    }
}
