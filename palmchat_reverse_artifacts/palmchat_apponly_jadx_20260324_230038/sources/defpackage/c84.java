package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.lantern.daemon.op.OPActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c84 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c84 f1916a;

    public static void a(Context context) {
        if (f1916a == null) {
            f1916a = new c84();
        }
        context.registerReceiver(f1916a, new IntentFilter("android.intent.action.SCREEN_OFF"));
        context.registerReceiver(f1916a, new IntentFilter("android.intent.action.SCREEN_ON"));
    }

    public static void b(Context context) {
        context.unregisterReceiver(f1916a);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                context.sendBroadcast(new Intent("ONEPIXEL_ACTION_FINISH_ACTIVITY"));
                Log.d(pt0.f20091a, "1px--screen on-");
                Intent intent2 = new Intent("ONEPIXEL_ACTION_LOG");
                intent2.putExtra("funId", "1px_finish");
                context.sendBroadcast(intent2);
                return;
            }
            return;
        }
        try {
            Intent intent3 = new Intent(context, (Class<?>) OPActivity.class);
            intent3.addFlags(268435456);
            context.startActivity(intent3);
            Log.i(pt0.f20091a, "1px--screen off-");
            Intent intent4 = new Intent("ONEPIXEL_ACTION_LOG");
            intent4.putExtra("funId", "1px_start");
            context.sendBroadcast(intent4);
        } catch (Exception unused) {
        }
    }
}
