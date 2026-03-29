package defpackage;

import android.content.Context;
import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class dt1 {
    public static long a() {
        return go.e("daemon_farmore_config", "account_auto_open", 14400L) * 1000;
    }

    public static long b(Context context) {
        long j = context.getSharedPreferences("daemon_farmore_config", 0).getBoolean("taichi_sync", false) ? r5.getInt("sync_interval", 14400) : 900L;
        long j2 = Build.VERSION.SDK_INT < 24 ? 3600L : 900L;
        return j < j2 ? j2 : j;
    }

    public static boolean c(Context context) {
        return context.getSharedPreferences("daemon_farmore_config", 0).getBoolean("taichi_auto_open", true);
    }
}
