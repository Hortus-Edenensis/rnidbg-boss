package defpackage;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.Toast;
import cn.jpush.android.service.PushReceiver;
import com.kuaishou.weapon.p0.g;
import com.oplus.tblplayer.misc.MediaInfo;
import com.zenmen.palmchat.privinfo.PrivInfoManager;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1196a = null;
    public static String b = "";
    public static int c;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends xw2 {
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Context context, String str2) {
            super(str);
            this.c = context;
            this.d = str2;
        }

        @Override // defpackage.xw2
        public void a() {
            try {
                Toast.makeText(this.c, this.d, 0).show();
            } catch (Throwable unused) {
            }
        }
    }

    public static List<String> A(Context context, List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!s(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static void B(Context context, Intent intent) {
        try {
            context.sendBroadcast(intent);
        } catch (Throwable unused) {
            D(context, intent);
        }
    }

    public static void C(Context context, String str, int i) {
        int i2;
        if (!x(context)) {
            k63.a("AndroidUtil", "not debuggable");
            return;
        }
        if (!u(context, PushReceiver.class)) {
            a(context, str);
            return;
        }
        k63.a("AndroidUtil", "action:showPermanentNotification");
        Intent intent = new Intent(context, (Class<?>) PushReceiver.class);
        intent.setAction("noti_open_proxy");
        intent.addCategory(context.getPackageName());
        intent.putExtra("debug_notification", true);
        intent.putExtra("toastText", str);
        intent.putExtra("type", i);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        try {
            i2 = context.getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 0).icon;
        } catch (Throwable th) {
            k63.f("AndroidUtil", "failed to get application info and icon.", th);
            i2 = R.drawable.ic_menu_share;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i3 = Build.VERSION.SDK_INT;
        Notification.Builder when = new Notification.Builder(context.getApplicationContext()).setContentTitle("Jiguang提示：包名和AppKey不匹配").setContentText("请到 Portal 上获取您的包名和AppKey并更新AndroidManifest相应字段").setContentIntent(broadcast).setSmallIcon(i2).setTicker(str).setWhen(jCurrentTimeMillis);
        if (i3 >= 26) {
            if (notificationManager.getNotificationChannel("JPush_Notification") == null) {
                notificationManager.createNotificationChannel(sz3.a("JPush_Notification", "JPush_Notification", 3));
            }
            when.setChannelId("JPush_Notification");
        }
        Notification notification = when.getNotification();
        notification.flags = 34;
        c = 10000;
        notificationManager.notify(10000, notification);
    }

    public static void D(Context context, Intent intent) {
        try {
            List<String> listO = o(context, intent, null);
            if (listO == null || listO.isEmpty()) {
                k63.n("AndroidUtil", "sendBroadcast failed again: receiver not found, action:" + intent.getAction());
                return;
            }
            for (String str : listO) {
                try {
                    Intent intent2 = (Intent) intent.clone();
                    intent2.setComponent(new ComponentName(context.getPackageName(), str));
                    context.sendBroadcast(intent2);
                } catch (Exception e) {
                    k63.n("AndroidUtil", "sendBroadcast failed again:" + e.getMessage() + ", action:" + intent.getAction());
                }
            }
        } catch (Throwable th) {
            k63.n("AndroidUtil", "tryAgainSendBrocast failed:" + th.getMessage());
        }
    }

    public static void a(Context context, String str) {
        new Handler(Looper.getMainLooper()).post(new a("AndroidUtils#ShowToast", context, str));
    }

    public static void b(Context context) {
        try {
            if (c != 0) {
                ((NotificationManager) context.getSystemService("notification")).cancel(c);
            }
        } catch (Throwable th) {
            k63.l("AndroidUtil", "[canclePermanentNotification] failed:" + th.getMessage());
        }
    }

    public static String c(Context context) {
        String androidID;
        try {
            androidID = PrivInfoManager.INSTANCE.getAndroidID();
        } catch (Throwable unused) {
            androidID = "";
        }
        return nl5.k(androidID) ? androidID : "";
    }

    public static int d(Context context) {
        if (context == null) {
            return -1;
        }
        Intent intentRegisterReceiver = null;
        try {
            intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), context.getPackageName() + wv2.f21809a, null);
        } catch (SecurityException unused) {
            k63.l("AndroidUtil", "getChargedStatus SecurityException");
        } catch (Exception e) {
            k63.l("AndroidUtil", "getChargedStatus unkown exception:" + e.getMessage());
        }
        if (intentRegisterReceiver == null) {
            return -1;
        }
        int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            return intentRegisterReceiver.getIntExtra("plugged", -1);
        }
        return -1;
    }

    public static List<String> e(Context context, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null) {
                    String str2 = serviceInfo.name;
                    if (!TextUtils.isEmpty(str2)) {
                        if (TextUtils.isEmpty(str) || packageManager.checkPermission(str, resolveInfo.activityInfo.packageName) == 0) {
                            arrayList.add(str2);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static String f(Context context, String str) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), 128).processName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static ComponentInfo g(Context context, String str, Class<?> cls) {
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            k63.l("AndroidUtil", "Action - hasComponent, invalide param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            int i = Service.class.isAssignableFrom(cls) ? 4 : BroadcastReceiver.class.isAssignableFrom(cls) ? 2 : Activity.class.isAssignableFrom(cls) ? 1 : ContentProvider.class.isAssignableFrom(cls) ? 8 : 0;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, i);
            ComponentInfo[] componentInfoArr = i != 1 ? i != 2 ? i != 4 ? i != 8 ? null : packageInfo.providers : packageInfo.services : packageInfo.receivers : packageInfo.activities;
            if (componentInfoArr == null) {
                return null;
            }
            for (ComponentInfo componentInfo : componentInfoArr) {
                if (cls.isAssignableFrom(Class.forName(componentInfo.name))) {
                    return componentInfo;
                }
            }
        } catch (Throwable th) {
            k63.n("AndroidUtil", "hasComponent error:" + th);
        }
        return null;
    }

    @SuppressLint({"WrongConstant"})
    public static String h(Context context) {
        Object objInvoke;
        String str = null;
        int iIntValue = -1;
        if (context != null) {
            try {
                Object systemService = context.getApplicationContext().getSystemService("country_detector");
                if (systemService != null) {
                    Method declaredMethod = systemService.getClass().getDeclaredMethod("detectCountry", new Class[0]);
                    if (declaredMethod != null && (objInvoke = declaredMethod.invoke(systemService, new Object[0])) != null) {
                        String str2 = (String) objInvoke.getClass().getDeclaredMethod("getCountryIso", new Class[0]).invoke(objInvoke, new Object[0]);
                        try {
                            iIntValue = ((Integer) objInvoke.getClass().getDeclaredMethod("getSource", new Class[0]).invoke(objInvoke, new Object[0])).intValue();
                            str = str2;
                        } catch (Throwable th) {
                            th = th;
                            str = str2;
                            k63.c("AndroidUtil", "getCountryCode failed, error :" + th);
                        }
                    }
                } else {
                    k63.a("AndroidUtil", "country_detector is null");
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        k63.a("AndroidUtil", "get CountCode = " + str + " source = " + iIntValue);
        return (iIntValue == 0 || iIntValue == 1) ? str : "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        defpackage.ad.f1196a = r1.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String i(Context context) {
        if (!TextUtils.isEmpty(f1196a)) {
            return f1196a;
        }
        try {
            Context contextA = tv2.a(context);
            ActivityManager activityManager = contextA != null ? (ActivityManager) contextA.getSystemService("activity") : null;
            if (activityManager != null) {
                int iMyPid = Process.myPid();
                Iterator<ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == iMyPid) {
                        break;
                    }
                }
            }
        } catch (Throwable th) {
            k63.n("AndroidUtil", "#unexcepted - getCurProcessName failed:" + th.getMessage());
        }
        return f1196a;
    }

    public static String j() {
        String path;
        try {
            path = Environment.getExternalStorageDirectory().getPath();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            path = null;
        } catch (Exception unused) {
            path = null;
        }
        if (TextUtils.isEmpty(path)) {
            return path;
        }
        return path + "/data/";
    }

    public static String k(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return MediaInfo.RENDERER_TYPE_UNKNOWN;
            }
            String typeName = activeNetworkInfo.getTypeName();
            String subtypeName = activeNetworkInfo.getSubtypeName();
            if (typeName == null) {
                return MediaInfo.RENDERER_TYPE_UNKNOWN;
            }
            if (nl5.i(subtypeName)) {
                return typeName;
            }
            return typeName + "," + subtypeName;
        } catch (Exception e) {
            e.printStackTrace();
            return MediaInfo.RENDERER_TYPE_UNKNOWN;
        }
    }

    public static String l(Context context) {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String packageName = context.getPackageName();
        b = packageName;
        return packageName;
    }

    public static ProviderInfo m(Context context, String str, Class<? extends ContentProvider> cls) {
        try {
            return context.getPackageManager().getProviderInfo(new ComponentName(str, cls.getName()), 65536);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static ProviderInfo n(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                ProviderInfo[] providerInfoArr = context.getPackageManager().getPackageInfo(str, 8).providers;
                if (providerInfoArr != null && providerInfoArr.length != 0) {
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        if (str2.equals(providerInfo.authority)) {
                            return providerInfo;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static List<String> o(Context context, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            for (ResolveInfo resolveInfo : listQueryBroadcastReceivers) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null) {
                    String str2 = activityInfo.name;
                    if (!TextUtils.isEmpty(str2)) {
                        if (TextUtils.isEmpty(str) || packageManager.checkPermission(str, resolveInfo.activityInfo.packageName) == 0) {
                            arrayList.add(str2);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static String p(Context context, String str) {
        try {
            return context.getPackageManager().getReceiverInfo(new ComponentName(context.getPackageName(), str), 128).processName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String q(Context context, String str, String str2) throws IllegalArgumentException {
        try {
            return (String) pu4.d(context.getClassLoader().loadClass("android.os.SystemProperties"), "get", new Object[]{str, str2}, new Class[]{String.class, String.class});
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String r(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return "0*0";
        }
        return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
    }

    public static boolean s(Context context, String str) {
        try {
            boolean z = true;
            if (Build.VERSION.SDK_INT >= 23) {
                if (context.getApplicationInfo().targetSdkVersion < 23) {
                    String strPermissionToOp = AppOpsManager.permissionToOp(str);
                    if (strPermissionToOp != null) {
                        z = ((AppOpsManager) context.getSystemService("appops")).noteProxyOpNoThrow(strPermissionToOp, context.getPackageName()) == 0;
                    }
                    return z;
                }
                if (context.checkSelfPermission(str) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            k63.l("AndroidUtil", "checkPermission error:" + th.getMessage());
            return false;
        }
    }

    public static boolean t(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("empty params");
        }
        try {
            context.getPackageManager().getPermissionInfo(str, 128);
            return true;
        } catch (Throwable th) {
            k63.n("AndroidUtil", "hasPermissionDefined error:" + th.getMessage());
            return false;
        }
    }

    public static boolean u(Context context, Class<?> cls) {
        boolean z;
        boolean z2 = false;
        try {
            z = !context.getPackageManager().queryBroadcastReceivers(new Intent(context, cls), 0).isEmpty();
        } catch (Throwable unused) {
        }
        if (z) {
            return z;
        }
        try {
            if (g(context, context.getPackageName(), cls) != null) {
                z2 = true;
            }
        } catch (Throwable unused2) {
            z2 = z;
        }
        return z2;
    }

    public static boolean v(Context context, String str) {
        if (nl5.i(str)) {
            return false;
        }
        return context.getPackageManager().getPackageInfo(str, 0) != null;
    }

    public static boolean w(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            if (!s(context, g.b) || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public static boolean x(Context context) {
        String name;
        boolean z = false;
        try {
            boolean z2 = (context.getApplicationInfo().flags & 2) != 0;
            k63.a("AndroidUtil", "isDebug:" + z2);
            if (tv2.f && tv2.e) {
                return z2;
            }
            X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
            String[] strArr = {"CN=Android Debug", "O=Android", "C=US"};
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            boolean zEquals = false;
            for (Signature signature : signatureArr) {
                try {
                    X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
                    zEquals = x509Certificate.getSubjectX500Principal().equals(x500Principal);
                    k63.a("AndroidUtil", "debuggable :" + zEquals);
                    if (zEquals) {
                        break;
                    }
                    try {
                        name = x509Certificate.getSubjectX500Principal().getName();
                    } catch (Exception unused) {
                        name = null;
                    }
                    k63.a("AndroidUtil", "certName:" + name);
                    if (name != null && name.contains(strArr[0]) && name.contains(strArr[1]) && name.contains(strArr[2])) {
                        return true;
                    }
                } catch (Throwable unused2) {
                    z = zEquals;
                }
            }
            return zEquals;
        } catch (Throwable unused3) {
        }
        return z;
    }

    public static boolean y() {
        boolean zEquals;
        try {
            zEquals = Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            k63.l("AndroidUtil", "isSdcardExist exception: " + th);
            zEquals = false;
        }
        if (!zEquals) {
            k63.a("AndroidUtil", "SDCard is not mounted");
        }
        return zEquals;
    }

    public static boolean z(Context context) {
        String str = context.getApplicationInfo().sourceDir;
        if (nl5.i(str)) {
            k63.c("AndroidUtil", "Unexpected: cannot get pk installed path");
            return false;
        }
        k63.a("AndroidUtil", "Current pk installed path: " + str);
        if (str.startsWith("/system/app/")) {
            return true;
        }
        if (str.startsWith("/data/app/")) {
            return false;
        }
        k63.g("AndroidUtil", "NOTE: the pk does not installed in system/data. ");
        return false;
    }
}
