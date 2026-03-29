package defpackage;

import android.content.Context;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class sk5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f20771a = c.d;
    public static final String b = nl0.v + "/logs/v2/realtime";
    public static final String c = nl0.v + "/logs/v2/file";

    public static void a(Context context) {
        d63.a().c(context);
        d(false);
    }

    public static void b(LogUtil.LogType logType, String str, boolean z) {
        if (f20771a) {
            d63.a().d(logType, str, z);
        }
    }

    public static void c(boolean z) {
        if (z) {
            d(false);
        }
    }

    public static void d(boolean z) {
        d63.a().f(z);
    }
}
