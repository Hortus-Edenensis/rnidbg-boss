package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.igexin.sdk.PushConsts;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ww3 {

    @Nullable
    public static ww3 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f21821a = new Handler(Looper.getMainLooper());
    public final CopyOnWriteArrayList<WeakReference<c>> b = new CopyOnWriteArrayList<>();
    public final Object c = new Object();

    @GuardedBy("networkTypeLock")
    public int d = 0;

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(31)
    public static final class b {

        /* JADX INFO: compiled from: SearchBox */
        public static final class a extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ww3 f21822a;

            public a(ww3 ww3Var) {
                this.f21822a = ww3Var;
            }

            @Override // android.telephony.TelephonyCallback.DisplayInfoListener
            public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
                int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
                this.f21822a.k(overrideNetworkType == 3 || overrideNetworkType == 4 || overrideNetworkType == 5 ? 10 : 5);
            }
        }

        public static void a(Context context, ww3 ww3Var) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) vh.e((TelephonyManager) context.getSystemService("phone"));
                a aVar = new a(ww3Var);
                telephonyManager.registerTelephonyCallback(context.getMainExecutor(), aVar);
                telephonyManager.unregisterTelephonyCallback(aVar);
            } catch (RuntimeException unused) {
                ww3Var.k(5);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void onNetworkTypeChanged(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int iG = ww3.g(context);
            if (g86.f17680a < 31 || iG != 5) {
                ww3.this.k(iG);
            } else {
                b.a(context, ww3.this);
            }
        }
    }

    public ww3(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        context.registerReceiver(new d(), intentFilter);
    }

    public static synchronized ww3 d(Context context) {
        if (e == null) {
            e = new ww3(context);
        }
        return e;
    }

    public static int e(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
                return 5;
            case 16:
            case 19:
            default:
                return 6;
            case 18:
                return 2;
            case 20:
                return g86.f17680a >= 29 ? 9 : 0;
        }
    }

    public static int g(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i = 0;
        if (connectivityManager == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (type != 4 && type != 5) {
                        if (type != 6) {
                            return type != 9 ? 8 : 7;
                        }
                        return 5;
                    }
                }
                return e(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(c cVar) {
        cVar.onNetworkTypeChanged(f());
    }

    public int f() {
        int i;
        synchronized (this.c) {
            i = this.d;
        }
        return i;
    }

    public void i(final c cVar) {
        j();
        this.b.add(new WeakReference<>(cVar));
        this.f21821a.post(new Runnable() { // from class: uw3
            @Override // java.lang.Runnable
            public final void run() {
                this.f21307a.h(cVar);
            }
        });
    }

    public final void j() {
        for (WeakReference<c> weakReference : this.b) {
            if (weakReference.get() == null) {
                this.b.remove(weakReference);
            }
        }
    }

    public final void k(int i) {
        synchronized (this.c) {
            if (this.d == i) {
                return;
            }
            this.d = i;
            for (WeakReference<c> weakReference : this.b) {
                c cVar = weakReference.get();
                if (cVar != null) {
                    cVar.onNetworkTypeChanged(i);
                } else {
                    this.b.remove(weakReference);
                }
            }
        }
    }
}
