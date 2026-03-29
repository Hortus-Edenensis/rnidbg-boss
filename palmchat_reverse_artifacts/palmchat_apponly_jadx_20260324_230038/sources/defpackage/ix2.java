package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import cn.jpush.android.service.DActivity;
import cn.jpush.android.service.DaemonService;
import cn.jpush.android.service.DownloadProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ix2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<String> f18284a;
    public static Boolean b;
    public static Boolean c;
    public static final String d;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f18284a = arrayList;
        arrayList.add(bf2.b(new byte[]{122, 103, 123, Utf8.REPLACEMENT_BYTE, 67, 79, 113, 125, 56, ByteCompanionObject.MAX_VALUE, 85, 87, 106, 107, 122, 120, 85, 78, 109}));
        d = "Xiaomi".toLowerCase();
    }

    public static boolean a(Context context, String str, Intent intent, boolean z) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            intent.setPackage(str);
            if (!z) {
                intent.setAction("cn.jpush.android.intent.DActivity");
                intent.addCategory(str);
            }
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
            if (resolveInfoResolveActivity == null) {
                p63.f("JWakeComponentHelper", "getDActivity resolveInfo was null from:" + str);
                return false;
            }
            p63.a("JWakeComponentHelper", "target actvity name:" + resolveInfoResolveActivity.activityInfo.name + ", theme:" + resolveInfoResolveActivity.activityInfo.theme + ", exported:" + resolveInfoResolveActivity.activityInfo.exported + ", enable: " + resolveInfoResolveActivity.activityInfo.enabled);
            if (resolveInfoResolveActivity.activityInfo.exported && (!k(str) || resolveInfoResolveActivity.activityInfo.enabled)) {
                if (!z && !"jpush.custom".equals(resolveInfoResolveActivity.activityInfo.taskAffinity)) {
                    p63.f("JWakeComponentHelper", "activity taskAffinity must be jpush.custom");
                    return false;
                }
                if (resolveInfoResolveActivity.activityInfo.theme != 16973840) {
                    p63.f("JWakeComponentHelper", resolveInfoResolveActivity.activityInfo.name + "activity theme must config as @android:style/Theme.Translucent.NoTitleBar");
                    return false;
                }
                p63.a("JWakeComponentHelper", "dIntent:" + intent);
                return true;
            }
            p63.f("JWakeComponentHelper", "activity muse be exported and enabled");
            return false;
        } catch (Throwable th) {
            p63.f("JWakeComponentHelper", "get deeplink activity error#" + th);
            return false;
        }
    }

    public static rx2 b(Context context, PackageManager packageManager, String str, String str2) {
        if (packageManager != null && !TextUtils.isEmpty(str)) {
            try {
                int iCheckPermission = packageManager.checkPermission(str + ".permission.JPUSH_MESSAGE", str);
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    String strE = rv2.e(context);
                    Intent intent = new Intent();
                    intent.setClassName(str, "cn.jpush.android.service.PushService");
                    boolean z = false;
                    List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
                    if (listQueryIntentServices != null && listQueryIntentServices.size() != 0) {
                        z = true;
                    }
                    if (iCheckPermission == 0 && z && !TextUtils.isEmpty(strE) && strE.length() == 24) {
                        rx2 rx2Var = new rx2(str, str2, applicationInfo.targetSdkVersion);
                        ComponentInfo componentInfoG = rv2.g(context, str, DownloadProvider.class);
                        if (componentInfoG instanceof ProviderInfo) {
                            ProviderInfo providerInfo = (ProviderInfo) componentInfoG;
                            if (providerInfo.exported && providerInfo.enabled && providerInfo.authority != null) {
                                if (TextUtils.equals(str + ".DownloadProvider", providerInfo.authority)) {
                                    rx2Var.d = providerInfo.authority;
                                }
                            }
                        }
                        return rx2Var;
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                p63.f("JWakeComponentHelper", "checkWhetherToStart exception:" + e.toString());
            } catch (Throwable th) {
                p63.f("JWakeComponentHelper", "checkWhetherToStart throwable:" + th.getMessage());
            }
        }
        return null;
    }

    public static boolean c(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            new Intent(str).addCategory(context.getPackageName());
            return !packageManager.queryIntentActivities(r2, 0).isEmpty();
        } catch (Throwable th) {
            p63.g("JWakeComponentHelper", "hasActivityIntentFilter error:" + th.getMessage());
            return false;
        }
    }

    public static boolean d(Context context) {
        Boolean bool = b;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (c(context, "cn.jpush.android.intent.DActivity")) {
            b = Boolean.TRUE;
        } else {
            b = Boolean.FALSE;
        }
        return b.booleanValue();
    }

    public static boolean e(Context context) {
        Boolean bool = c;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (f(context)) {
            c = Boolean.TRUE;
        } else {
            c = Boolean.FALSE;
        }
        return c.booleanValue();
    }

    public static boolean f(Context context) {
        try {
            String str = lv2.b;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return TextUtils.equals(d, str.toLowerCase());
        } catch (Throwable th) {
            p63.g("JWakeComponentHelper", "get MANUFACTURER failed - error:" + th);
            return false;
        }
    }

    public static void g(Context context, boolean z, Class cls) {
        try {
            if (context == null) {
                p63.g("JWakeComponentHelper", "context is null, give up setComponentEnabled");
                return;
            }
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            if (packageManager == null) {
                p63.g("JWakeComponentHelper", "PackageManager is null, give up setComponentEnabled");
                return;
            }
            int i = z ? 1 : 2;
            ComponentName componentName = new ComponentName(context, (Class<?>) cls);
            if (packageManager.getComponentEnabledSetting(componentName) == i) {
                p63.a("JWakeComponentHelper", componentName.getClassName() + " enabled is :" + z + ", no need repeat set.");
                return;
            }
            p63.a("JWakeComponentHelper", componentName + " setActivityEnabledSetting newState: " + i);
            packageManager.setComponentEnabledSetting(componentName, i, 1);
        } catch (Throwable th) {
            p63.f("JWakeComponentHelper", "setActivityEnabled throwable:" + th.getMessage());
        }
    }

    public static void h(Context context, boolean z) {
        j(context, z, "cn.jpush.android.intent.DaemonService", DaemonService.class);
        i(context, z, DownloadProvider.class);
        if (d(context)) {
            g(context, z, DActivity.class);
        }
    }

    public static void i(Context context, boolean z, Class cls) {
        try {
            if (context == null) {
                p63.g("JWakeComponentHelper", "context is null, give up setComponentEnabled");
                return;
            }
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            if (packageManager == null) {
                p63.g("JWakeComponentHelper", "PackageManager is null, give up setComponentEnabled");
                return;
            }
            int i = z ? 1 : 2;
            ComponentName componentName = new ComponentName(context, (Class<?>) cls);
            if (packageManager.getComponentEnabledSetting(componentName) == i) {
                p63.a("JWakeComponentHelper", componentName.getClassName() + " enabled is :" + z + ", no need repeat set.");
                return;
            }
            p63.a("JWakeComponentHelper", componentName + " setDownloadProviderEnabledSetting newState: " + i);
            packageManager.setComponentEnabledSetting(componentName, i, 1);
        } catch (Throwable th) {
            p63.f("JWakeComponentHelper", "setContentProviderEnabled throwable:" + th.getMessage());
        }
    }

    public static void j(Context context, boolean z, String str, Class cls) {
        ServiceInfo serviceInfo;
        try {
            if (context == null) {
                p63.g("JWakeComponentHelper", "context is null, give up setComponentEnabled");
                return;
            }
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            if (packageManager == null) {
                p63.g("JWakeComponentHelper", "PackageManager is null, give up setComponentEnabled");
                return;
            }
            String packageName = context.getPackageName();
            int i = z ? 1 : 2;
            Intent intent = new Intent();
            intent.setPackage(packageName);
            intent.setAction(str);
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 512);
            if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                p63.f("JWakeComponentHelper", "cant't find DaemonService");
                return;
            }
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                    String str2 = serviceInfo.name;
                    if (TextUtils.isEmpty(str2)) {
                        continue;
                    } else {
                        try {
                            if (cls.isAssignableFrom(Class.forName(str2))) {
                                ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                                p63.a("JWakeComponentHelper", componentName + " setComponentEnabledSetting newState: " + i);
                                if (packageManager.getComponentEnabledSetting(componentName) == i) {
                                    p63.a("JWakeComponentHelper", "DaemonService  enabled is :" + z + ", no need repeat set.");
                                    return;
                                }
                                packageManager.setComponentEnabledSetting(componentName, i, 1);
                            } else {
                                p63.g("JWakeComponentHelper", "give up setting, as " + str2 + " is not extend from: " + cls.getName());
                            }
                        } catch (ClassNotFoundException unused) {
                            p63.f("JWakeComponentHelper", "cant't find service class:" + str2);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            p63.f("JWakeComponentHelper", "setServiceEnabled throwable:" + th.getMessage());
        }
    }

    public static boolean k(String str) {
        boolean zContains = f18284a.contains(str);
        StringBuilder sb = new StringBuilder();
        sb.append("package[");
        sb.append(str);
        sb.append("] need check activity enable state, ");
        sb.append(!zContains);
        p63.d("JWakeComponentHelper", sb.toString());
        return !zContains;
    }
}
