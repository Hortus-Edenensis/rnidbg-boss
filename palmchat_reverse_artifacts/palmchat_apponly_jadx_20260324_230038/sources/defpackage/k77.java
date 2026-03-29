package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.igexin.sdk.PushConsts;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class k77 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k87 f18592a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (k77.this.f18592a != null) {
                k77.this.f18592a.b(new m17("Network_Info", g47.c(), (byte) 4, null, null));
            }
        }
    }

    public k77(k87 k87Var) {
        this.f18592a = k87Var;
    }

    public final void b(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            context.registerReceiver(this, intentFilter);
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        new Thread(new a()).start();
    }
}
