package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.zenmen.media.roomchat.RTCParameters;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class t35 {
    public static t35 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BroadcastReceiver f20893a = null;
    public boolean b = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.intent.action.SCREEN_OFF")) {
                t35.this.b = false;
            } else if (action.equals("android.intent.action.SCREEN_ON")) {
                t35.this.b = true;
            }
        }
    }

    public static t35 a() {
        if (c == null) {
            c = new t35();
        }
        return c;
    }

    public void b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        this.f20893a = new a();
        if (RTCParameters.c() != null) {
            RTCParameters.c().registerReceiver(this.f20893a, intentFilter);
        }
    }

    public void c() {
        if (this.f20893a != null && RTCParameters.c() != null) {
            RTCParameters.c().unregisterReceiver(this.f20893a);
        }
        c = null;
    }
}
