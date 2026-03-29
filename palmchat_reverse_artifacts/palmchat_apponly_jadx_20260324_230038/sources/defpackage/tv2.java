package defpackage;

import android.content.Context;
import cn.jiguang.api.JAnalyticsAction;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class tv2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f21077a = "";
    public static JAnalyticsAction b = null;
    public static String c = "wifi";
    public static int d = 247;
    public static boolean e = false;
    public static boolean f = false;
    public static boolean g = true;
    public static int l;
    public static AtomicBoolean h = new AtomicBoolean();
    public static int i = MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL;
    public static int j = MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL + 5;
    public static byte k = 1;
    public static boolean m = false;
    public static String n = "";
    public static boolean o = false;
    public static Context p = null;

    public static Context a(Context context) {
        if (p == null && context != null) {
            p = context.getApplicationContext();
        }
        return p;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0029, code lost:
    
        if (r3.getApplicationInfo().targetSdkVersion <= 28) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context, boolean z, String str) {
        boolean z2 = true;
        if (!z) {
            z2 = o ? false : false;
        } else if (o) {
        }
        if (z2) {
            k63.a("JConstants", "is Android Q, msg: " + str);
        }
        return z2;
    }

    public static boolean c() {
        return false;
    }

    public static void d() {
        k63.a("JConstants", "call testAndroidQ");
        o = true;
    }
}
