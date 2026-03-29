package com.opos.cmn.func.dl.base.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.igexin.sdk.PushConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {
    private static volatile a d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7978a;
    public BroadcastReceiver b;
    public List<c> c = new ArrayList();
    private Handler e = new HandlerC0669a();

    /* JADX INFO: renamed from: com.opos.cmn.func.dl.base.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class HandlerC0669a extends Handler {
        public HandlerC0669a() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public final void handleMessage(final Message message) {
            try {
                com.opos.cmn.func.dl.base.b.a().execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.d.a.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i = message.what;
                        if (i == 0) {
                            Iterator it = a.this.c.iterator();
                            while (it.hasNext()) {
                                ((c) it.next()).b();
                            }
                        } else if (i == 1) {
                            Iterator it2 = a.this.c.iterator();
                            while (it2.hasNext()) {
                                ((c) it2.next()).a();
                            }
                        } else {
                            if (i != 2) {
                                return;
                            }
                            Iterator it3 = a.this.c.iterator();
                            while (it3.hasNext()) {
                                ((c) it3.next()).c();
                            }
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            try {
                com.opos.cmn.func.dl.base.b.a().execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.d.a.b.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        NetworkInfo activeNetworkInfo;
                        try {
                            ConnectivityManager connectivityManager = (ConnectivityManager) a.this.f7978a.getSystemService("connectivity");
                            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                                int type = activeNetworkInfo.getType();
                                boolean z = type == 0;
                                boolean z2 = type == 1;
                                if (z) {
                                    a.a(a.this, 1);
                                } else if (z2) {
                                    a.a(a.this, 0);
                                }
                                com.opos.cmn.an.f.a.a("NetworkState", "download net change to type:".concat(String.valueOf(type)));
                                return;
                            }
                            a.a(a.this, 2);
                        } catch (Throwable th) {
                            com.opos.cmn.an.f.a.c("NetworkState", "onReceive", th);
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a();

        void b();

        void c();
    }

    private a(Context context) {
        this.f7978a = context;
    }

    public static a a(Context context) {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a(context);
                }
            }
        }
        return d;
    }

    public final void a() {
        this.e.removeCallbacksAndMessages(null);
    }

    public final synchronized void a(c cVar) {
        if (this.b == null) {
            this.b = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            intentFilter.setPriority(Integer.MAX_VALUE);
            this.f7978a.registerReceiver(this.b, intentFilter);
        }
        if (cVar != null) {
            this.c.add(cVar);
        }
    }

    public static /* synthetic */ void a(a aVar, int i) {
        aVar.a();
        aVar.e.sendEmptyMessageDelayed(i, 3000L);
    }
}
