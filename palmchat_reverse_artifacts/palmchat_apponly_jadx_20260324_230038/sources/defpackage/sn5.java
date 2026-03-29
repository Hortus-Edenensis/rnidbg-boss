package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class sn5 implements p16 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f20793a;
    public final BroadcastReceiver b = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            v.f(action);
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                v.d("screen off");
                sn5.this.b();
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                v.d("screen on");
            }
        }
    }

    public sn5(Context context) {
        this.f20793a = context;
    }

    public final void a() {
        if (this.f20793a == null) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            this.f20793a.registerReceiver(this.b, intentFilter);
        } catch (Throwable th) {
            v.d(th.getMessage());
        }
    }

    public void b() {
        xn1.h().o();
    }

    @Override // defpackage.p16
    public void register() {
        a();
    }
}
