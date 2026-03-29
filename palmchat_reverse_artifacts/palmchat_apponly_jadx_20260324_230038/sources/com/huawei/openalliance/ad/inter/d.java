package com.huawei.openalliance.ad.inter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.utils.z;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class d {
    private static d I;
    private static final byte[] Z = new byte[0];
    private Context B;
    private a S;
    private boolean V = false;
    private CopyOnWriteArrayList<WeakReference<b>> C = new CopyOnWriteArrayList<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            fh.V("ExSplashStartReceiver", "onReceive");
            if (intent == null) {
                return;
            }
            try {
                if (x.bw.equals(intent.getAction())) {
                    d.this.V = true;
                    d.this.Z();
                    context.removeStickyBroadcast(intent);
                }
            } catch (Throwable th) {
                fh.I("ExSplashStartReceiver", "ExSplashBeginReceiver err: %s", th.getClass().getSimpleName());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void Code();
    }

    private d(Context context) {
        this.B = context.getApplicationContext();
    }

    public static d Code(Context context) {
        d dVar;
        synchronized (Z) {
            if (I == null) {
                I = new d(context);
            }
            dVar = I;
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        if (this.C.isEmpty()) {
            return;
        }
        for (WeakReference<b> weakReference : this.C) {
            if (weakReference.get() != null) {
                weakReference.get().Code();
            }
        }
    }

    public void I() {
        String str;
        try {
            fh.V("ExSplashStartReceiver", "unregister receiver");
            a aVar = this.S;
            if (aVar != null) {
                this.B.unregisterReceiver(aVar);
                this.S = null;
            }
        } catch (IllegalStateException unused) {
            str = "unregisterReceiver IllegalStateException";
            fh.I("ExSplashStartReceiver", str);
        } catch (Throwable unused2) {
            str = "unregisterReceiver exception";
            fh.I("ExSplashStartReceiver", str);
        }
    }

    public void V() {
        String str;
        try {
            I();
            if (!cn.B(this.B)) {
                fh.I("ExSplashStartReceiver", "not inner device, no need to register");
                return;
            }
            IntentFilter intentFilter = new IntentFilter(x.bw);
            Intent intentCode = z.Code(this.B, null, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            if (intentCode != null && intentCode.getAction() != null && intentCode.getAction().equals(x.bw)) {
                fh.V("ExSplashStartReceiver", "isExSplashStart");
                this.V = true;
                this.B.removeStickyBroadcast(intentCode);
            }
            if (this.S == null) {
                this.S = new a();
            }
            fh.V("ExSplashStartReceiver", "register receiver");
            z.Code(this.B, this.S, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
        } catch (IllegalStateException unused) {
            str = "registerReceiver IllegalStateException";
            fh.I("ExSplashStartReceiver", str);
        } catch (Throwable unused2) {
            str = "registerReceiver Exception";
            fh.I("ExSplashStartReceiver", str);
        }
    }

    public void Code(b bVar) {
        if (bVar != null) {
            this.C.add(new WeakReference<>(bVar));
        }
    }

    public void V(b bVar) {
        try {
            CopyOnWriteArrayList<WeakReference<b>> copyOnWriteArrayList = this.C;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                for (WeakReference<b> weakReference : this.C) {
                    b bVar2 = weakReference.get();
                    if (bVar2 == null || bVar2 == bVar) {
                        this.C.remove(weakReference);
                    }
                }
            }
        } catch (Throwable th) {
            fh.V("ExSplashStartReceiver", "removeStartListener err: %s", th.getClass().getSimpleName());
        }
    }

    public void Code(boolean z) {
        this.V = z;
    }

    public boolean Code() {
        return this.V;
    }
}
