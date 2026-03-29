package defpackage;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.wifi.adsdk.utils.LxAdMiuiDevice;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class to {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static uo f21028a;

    public static uo a() {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        return (lowerCase.equals("huawei") || lowerCase.equals("honor")) ? new wj2() : (!lowerCase.equals("xiaomi") || TextUtils.isEmpty(c(LxAdMiuiDevice.PROP_VERSION))) ? lowerCase.contains("samsung") ? new e25() : lowerCase.contains("oppo") ? new i94() : lowerCase.contains("vivo") ? new jg6() : lowerCase.contains("lenovo") ? new c23() : lowerCase.contains("htc") ? new zi2() : new u31() : new cp3();
    }

    public static uo b() {
        if (f21028a == null) {
            f21028a = a();
        }
        return f21028a;
    }

    public static String c(String str) {
        return sb1.c(str);
    }

    public static void d(Context context, int i) {
        b().a(context, i);
    }

    public static void e(Context context, Notification notification, int i) {
        b().b(context, notification, i);
    }
}
