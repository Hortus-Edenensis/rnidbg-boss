package cn.jiguang.api;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.g;
import defpackage.ad;
import defpackage.aw2;
import defpackage.fv2;
import defpackage.k63;
import defpackage.m50;
import defpackage.tv2;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class JCoreManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f2448a = new AtomicBoolean();

    public static void addDispatchAction(String str, String str2) {
        fv2.a(str, str2);
    }

    public static Context getAppContext(Context context) {
        return tv2.a(context);
    }

    @Deprecated
    public static boolean getConnectionState(Context context) {
        Object objE = aw2.c().e(context, "JCore", 67, false, null, null, new Object[0]);
        if (objE instanceof Boolean) {
            return ((Boolean) objE).booleanValue();
        }
        return false;
    }

    public static boolean getDebugMode() {
        return tv2.e;
    }

    public static void init(Context context) {
        Context contextA = tv2.a(context);
        if (contextA == null) {
            return;
        }
        tv2.h.set(true);
        AtomicBoolean atomicBoolean = f2448a;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        fv2.o(contextA);
        aw2.c().e(contextA, "JCore", 10, true, "tcp_a1", null, new Object[0]);
    }

    public static void initCrashHandler(Context context) {
        onEvent(context, "JCore", 70, true, null, null, new Object[0]);
    }

    public static boolean isInternal() {
        return tv2.f;
    }

    public static boolean isTestEnv() {
        return tv2.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x003b A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object onEvent(Context context, String str, int i, String str2, Bundle bundle, Object... objArr) {
        boolean z;
        if (i != 13 && i != 49 && i != 53 && i != 60 && i != 63 && i != 25 && i != 26 && i != 42 && i != 43 && i != 67 && i != 68) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case 45:
                                        case 46:
                                        case 47:
                                            break;
                                        default:
                                            z = true;
                                            break;
                                    }
                                case 32:
                                case 33:
                                case 34:
                                    break;
                            }
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                            break;
                    }
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    break;
            }
        } else {
            z = false;
        }
        return onEvent(context, str, i, z, str2, bundle, objArr);
    }

    public static void register(Context context, String str) {
        try {
            tv2.h.set(true);
            fv2.o(context);
            String strG = m50.g(context);
            if (TextUtils.isEmpty(strG) || strG.equals(str)) {
                tv2.f21077a = str;
            } else {
                k63.n("JCoreManager", "[register] not same appkey with manifest,please check it");
            }
            Bundle bundle = new Bundle();
            bundle.putString("appkey", str);
            aw2.c().e(context, "JCore", 10, true, "a5", bundle, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void reportWakedData(Context context, Bundle bundle, int i) {
        if (context == null) {
            k63.n("JCoreManager", "[reportWakedData] context was null");
            return;
        }
        if (bundle == null) {
            k63.n("JCoreManager", "[reportWakedData] bundle was null");
            return;
        }
        int i2 = bundle.getInt("type", -1);
        if (i2 != -1) {
            i = i2;
        }
        if (i != 8 && i != 16) {
            k63.n("JCoreManager", "[reportWakedData] wrong type:" + i);
            return;
        }
        bundle.putInt("type", i);
        k63.a("JCoreManager", "action - reportWakedData" + bundle.toString());
        onEvent(context, null, 74, null, bundle, new Object[0]);
    }

    public static void requestPermission(Context context) {
        if (context == null) {
            k63.n("JCoreManager", "[requestPermission] context was null");
            return;
        }
        if (!(context instanceof Activity)) {
            k63.n("JCoreManager", "[requestPermission] context must instanceof Activity");
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 23) {
            k63.n("JCoreManager", "[requestPermission] android.os.Build.VERSION.SDK_INT<23");
            return;
        }
        if (context.getApplicationInfo().targetSdkVersion < 23) {
            k63.n("JCoreManager", "[requestPermission] app targetSdkVersion<23");
            return;
        }
        if (i < 23 || context.getApplicationInfo().targetSdkVersion < 23) {
            return;
        }
        try {
            LinkedList linkedList = new LinkedList();
            linkedList.add(g.j);
            linkedList.add(g.i);
            linkedList.add(g.c);
            List<String> listA = ad.A(context, linkedList);
            if (listA != null && !listA.isEmpty()) {
                k63.j("JCoreManager", "lackPermissions:" + listA);
                Class.forName("android.app.Activity").getDeclaredMethod("requestPermissions", String[].class, Integer.TYPE).invoke(context, listA.toArray(new String[listA.size()]), 1);
            }
        } catch (Exception e) {
            k63.n("JCoreManager", "#unexcepted - requestPermission e:" + e);
        }
    }

    public static void setAnalysisAction(JAnalyticsAction jAnalyticsAction) {
        tv2.b = jAnalyticsAction;
    }

    public static void setDebugMode(boolean z) {
        tv2.e = z;
    }

    public static void setSDKConfigs(Context context, Bundle bundle) {
        aw2.c().e(context, "JCore", 55, true, null, bundle, new Object[0]);
    }

    public static void stopCrashHandler(Context context) {
        onEvent(context, "JCore", 71, true, null, null, new Object[0]);
    }

    public static void unRegister(Context context) {
        tv2.h.set(true);
        fv2.o(context);
        aw2.c().e(context, "JCore", 10, true, "tcp_a23", null, new Object[0]);
    }

    public static Object onEvent(Context context, String str, int i, boolean z, String str2, Bundle bundle, Object... objArr) {
        if (i != 18 && i != 13) {
            init(context);
        }
        return aw2.c().e(context, str, i, z, str2, bundle, objArr);
    }

    public static void changeLiveStatus(boolean z) {
    }
}
