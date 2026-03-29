package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.igexin.sdk.PushConsts;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class s35 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f20657a;
    public a b = new a();
    public b c;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                s35.this.c.a();
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                s35.this.c.c();
            } else if (PushConsts.ACTION_BROADCAST_USER_PRESENT.equals(intent.getAction())) {
                s35.this.c.b();
            }
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a();

        void b();

        void c();
    }

    public s35(Context context) {
        this.f20657a = context;
    }

    public void b(b bVar) {
        this.c = bVar;
        c();
    }

    public final void c() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_USER_PRESENT);
            this.f20657a.registerReceiver(this.b, intentFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void d() {
        try {
            this.f20657a.unregisterReceiver(this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
