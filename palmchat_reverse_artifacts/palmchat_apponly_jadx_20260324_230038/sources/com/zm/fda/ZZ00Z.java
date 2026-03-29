package com.zm.fda;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Message;
import androidx.media3.common.C;
import com.igexin.sdk.PushConsts;
import com.zm.fda.O52OZ.Z200O;
import com.zm.fda.Z200O.ZZ00Z;
import com.zm.fda.Z2500.Z0225;
import com.zm.fda.busi.IPubParams;
import com.zm.fda.utils.EventLog;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ00Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16701a = "fda_crash_FOB";
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 15000;
    public static Context e;
    public static BroadcastReceiver f;
    public static C1172ZZ00Z g;
    public static O022Z h;
    public static AtomicBoolean i = new AtomicBoolean(false);
    public static CopyOnWriteArrayList<FobEventClient> j = new CopyOnWriteArrayList<>();
    public static volatile Map<String, Object> k;

    /* JADX INFO: compiled from: SearchBox */
    @SuppressLint({"HandlerLeak"})
    public static class O022Z extends Handler {
        public void a() {
            if (hasMessages(0)) {
                removeMessages(0);
            }
            sendEmptyMessage(0);
        }

        public void b() {
            if (hasMessages(1)) {
                removeMessages(1);
            }
            sendEmptyMessage(1);
        }

        public void c() {
            removeMessages(0);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                EventLog.d(ZZ00Z.f16701a, "定时触发上报");
                ZZ00Z.f();
                sendEmptyMessageDelayed(0, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class OO22Z extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            EventLog.d(ZZ00Z.f16701a, "收到消息触发上报 action = ", intent.getAction());
            ZZ00Z.f();
            com.zm.fda.Z2500.OO22Z.a().d();
        }
    }

    /* JADX INFO: renamed from: com.zm.fda.ZZ00Z$ZZ00Z, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(21)
    public static class C1172ZZ00Z extends ConnectivityManager.NetworkCallback {
        public C1172ZZ00Z() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            ZZ00Z.f();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
        }

        public /* synthetic */ C1172ZZ00Z(OO22Z oo22z) {
            this();
        }
    }

    public static Context b() {
        return e;
    }

    public static void c() {
        if (h != null) {
            return;
        }
        O022Z o022z = new O022Z();
        h = o022z;
        o022z.a();
        h.b();
    }

    public static void d() {
        if (g != null) {
            return;
        }
        g = new C1172ZZ00Z(null);
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().build();
        ConnectivityManager connectivityManager = (ConnectivityManager) e.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                connectivityManager.registerNetworkCallback(networkRequestBuild, g);
                EventLog.d(f16701a, "Register ConnectivityManager");
            } catch (Throwable th) {
                EventLog.d(f16701a, "Register ConnectivityManager error:", th.getMessage());
            }
        }
    }

    public static void e() {
        if (f != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_USER_PRESENT);
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        OO22Z oo22z = new OO22Z();
        f = oo22z;
        try {
            e.registerReceiver(oo22z, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void f() {
        com.zm.fda.Z0225.O022Z.a().c();
    }

    public static void a(FobEventClient fobEventClient) {
        if (fobEventClient == null) {
            return;
        }
        try {
            CopyOnWriteArrayList<FobEventClient> copyOnWriteArrayList = j;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.contains(fobEventClient)) {
                return;
            }
            j.add(fobEventClient);
            if (k != null) {
                fobEventClient.track(ZZ00Z.OO22Z.d, k);
                k = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Map<String, Object> map) {
        CopyOnWriteArrayList<FobEventClient> copyOnWriteArrayList = j;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            j.get(r0.size() - 1).track(ZZ00Z.OO22Z.d, map);
        } else {
            k = map;
        }
    }

    public static synchronized void a(Context context, final IPubParams iPubParams) {
        if (context == null) {
            return;
        }
        if (i.get()) {
            return;
        }
        i.set(true);
        e = context;
        Z200O.a().b(new Runnable() { // from class: mq6
            @Override // java.lang.Runnable
            public final void run() {
                com.zm.fda.ZZ00Z.a(iPubParams);
            }
        });
    }

    public static void a(IPubParams iPubParams) {
        c();
        e();
        d();
        a(iPubParams != null ? iPubParams.collectCrash() : true);
    }

    public static void a(boolean z) {
        if (!z) {
            EventLog.d(f16701a, "CrashCollector switch off");
        } else {
            com.zm.fda.Z2500.OO22Z.a().a(e, new Z0225() { // from class: iq6
                @Override // com.zm.fda.Z2500.Z0225
                public final void a(Throwable th) {
                    com.zm.fda.ZZ00Z.a(th);
                }
            });
        }
    }

    public static /* synthetic */ void a(Throwable th) {
        CopyOnWriteArrayList<FobEventClient> copyOnWriteArrayList = j;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < j.size(); i2++) {
            FobEventClient fobEventClient = j.get(i2);
            if (fobEventClient != null && com.zm.fda.Z2500.OO22Z.a().a(th, fobEventClient.getPubParamsImp())) {
                com.zm.fda.Z2500.OO22Z.a().b(th, fobEventClient.getPubParamsImp());
            }
        }
    }
}
