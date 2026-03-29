package defpackage;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bw2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1842a = false;

    public static void a(Context context, Bundle bundle) {
        if (bundle != null) {
            f1842a = bundle.getBoolean("foreground");
            k63.a("JCoreManagerInternal", "changeForeGroundStat:" + f1842a);
            if (f1842a) {
                if (tt5.u().t() >= 120) {
                    tt5.u().K();
                }
                o75.m().c(context);
            }
            qv2.a(context, "foreground_state_change", bundle);
        }
    }

    public static void b(Context context) {
        JCoreManager.onEvent(context, "JCore", 38, null, null, new Object[0]);
    }

    public static void c(Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 76, null, null, runnable);
    }

    public static Map d(Context context) {
        Object objOnEvent = JCoreManager.onEvent(context, "JCore", 45, null, null, new Object[0]);
        if (objOnEvent instanceof Map) {
            return (Map) objOnEvent;
        }
        return null;
    }

    public static int e(Context context) {
        Object objOnEvent = JCoreManager.onEvent(context, "JCore", 47, null, null, new Object[0]);
        if (objOnEvent instanceof Integer) {
            return ((Integer) objOnEvent).intValue();
        }
        return 0;
    }

    public static void f(Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 75, null, null, runnable);
    }

    public static void g(Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 77, null, null, runnable);
    }

    public static void h(String str) {
        JCoreManager.onEvent(null, null, 13, str, null, new Object[0]);
    }

    public static void i(Context context, Object obj) {
        JCoreManager.onEvent(context, "JCore", 39, null, null, obj);
    }

    public static void j(Context context, String str) {
        JCoreManager.onEvent(context, "JCore", 36, null, null, str);
    }

    public static void k(Context context, int i) {
        JCoreManager.onEvent(context, "JCore", 51, "", null, Integer.valueOf(i));
    }

    public static void l(Context context, String str, long j) {
        JCoreManager.onEvent(context, "JCore", 44, null, null, str, Long.valueOf(j));
    }

    public static void m(Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 78, null, null, runnable);
    }

    public static void n(Context context, String str, int i, int i2, long j, long j2, byte[] bArr, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("cmd", i);
        bundle.putInt("ver", i2);
        bundle.putLong("rid", j);
        bundle.putLong(WkAdConfigModel.TAG_TIMEOUT, j2);
        bundle.putByteArray("body", bArr);
        JCoreManager.onEvent(context, str, z ? 17 : 16, null, bundle, new Object[0]);
    }

    public static void o(Context context, String str, int i, int i2, long j, long j2, byte[] bArr) {
        n(context, str, i, i2, j, j2, bArr, true);
    }

    public static void p(Context context, String str, int i, int i2, long j, long j2, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putInt("cmd", i);
        bundle.putInt("ver", i2);
        bundle.putLong("rid", j);
        bundle.putLong(WkAdConfigModel.TAG_TIMEOUT, 0L);
        bundle.putByteArray("body", bArr);
        bundle.putLong(DeviceInfoUtil.UID_TAG, j2);
        JCoreManager.onEvent(context, str, 59, null, bundle, new Object[0]);
    }

    public static void q(Context context, long j) {
        if (j > 0) {
            JCoreManager.onEvent(context, "JCore", 37, null, null, Long.valueOf(j));
        }
    }

    public static void r(Context context, int i) {
        JCoreManager.onEvent(context, "JCore", 57, null, null, Integer.valueOf(i));
    }

    public static void s(Context context, long j, String str, String str2) {
        JCoreManager.onEvent(context, "JCore", 35, null, null, Long.valueOf(j), str, str2);
    }

    public static void t(Context context) {
        JCoreManager.onEvent(context, "JCore", 48, null, null, new Object[0]);
    }
}
