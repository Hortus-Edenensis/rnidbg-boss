package defpackage;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.service.DataShare;
import cn.jpush.android.service.JCommonService;
import cn.jpush.android.service.PushReceiver;
import com.baidu.location.LocationConst;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class rw2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static rw2 f20595a;
    public static Map<String, String> b = new HashMap();

    public static rw2 c() {
        if (f20595a == null) {
            synchronized (rw2.class) {
                if (f20595a == null) {
                    f20595a = new rw2();
                }
            }
        }
        return f20595a;
    }

    public static String d(Context context, String str) {
        String str2 = b.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String str3 = context.getPackageName() + ".DataProvider";
        ProviderInfo providerInfoN = ad.n(context, context.getPackageName(), str3);
        if (str.equals(providerInfoN != null ? providerInfoN.processName : null)) {
            String str4 = "content://" + str3 + "/";
            b.put(str, str4);
            return str4;
        }
        String str5 = context.getPackageName() + ".DownloadProvider";
        ProviderInfo providerInfoN2 = ad.n(context, context.getPackageName(), str5);
        if (!str.equals(providerInfoN2 != null ? providerInfoN2.processName : null)) {
            return "";
        }
        String str6 = "content://" + str5 + "/";
        b.put(str, str6);
        return str6;
    }

    public Bundle a(Context context, String str, String str2, Bundle bundle, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        String strI = ad.i(context);
        if (TextUtils.isEmpty(strI)) {
            return null;
        }
        if (strI.equals(str3)) {
            return b(context, str, str2, bundle);
        }
        Bundle bundleF = f(str, str2, bundle, str3);
        if (bundleF != null) {
            return bundleF;
        }
        Bundle bundleH = h(context, str, str2, bundle, str3);
        if (bundleH != null) {
            return bundleH;
        }
        return null;
    }

    public Bundle b(Context context, String str, String str2, Bundle bundle) {
        try {
            k63.a("JMessenger", "directHandle, " + str + "." + str2);
            if ("INTERNAL_API".equals(str)) {
                if (str2.equals("isTcpLoggedIn")) {
                    boolean zC = tt5.u().C();
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean(LocationConst.HDYawConst.KEY_HD_YAW_STATE, zC);
                    return bundle2;
                }
                k63.c("JMessenger", "directHandle, not support " + str + "." + str2);
                return null;
            }
            Class<?> cls = Class.forName(str);
            if (!BroadcastReceiver.class.isAssignableFrom(cls) && !Service.class.isAssignableFrom(cls)) {
                k63.c("JMessenger", "directHandle, not support " + str + "." + str2);
                return null;
            }
            if (JCommonService.class.isAssignableFrom(cls)) {
                k63.a("JMessenger", "JCommonService handle succeed," + str + "." + str2);
                aw2.c().e(context, "JCore", 2, true, str2, bundle, new Object[0]);
                return new Bundle();
            }
            Intent intent = new Intent(str2);
            intent.setClass(context, cls);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            intent.setPackage(context.getPackageName());
            intent.addCategory(context.getPackageName());
            if (PushReceiver.class.isAssignableFrom(cls)) {
                k63.a("JMessenger", "PushReceiver handle succeed," + str + "." + str2);
                f5.c().d(context, bundle != null ? bundle.getString("sdktype") : null, intent);
            } else if (BroadcastReceiver.class.isAssignableFrom(cls)) {
                k63.a("JMessenger", "Receiver onReceive," + str + "." + str2);
                ((BroadcastReceiver) cls.newInstance()).onReceive(context, intent);
            } else {
                k63.a("JMessenger", "Service onStartCommand," + str + "." + str2);
                ((Service) cls.newInstance()).onStartCommand(intent, 0, 0);
            }
            return new Bundle();
        } catch (Throwable th) {
            k63.c("JMessenger", "directHandle e:" + th);
            return null;
        }
    }

    public boolean e(Context context, String str, String str2, Bundle bundle) {
        Class<?> cls;
        String str3 = str + "." + str2;
        String strP = null;
        try {
            cls = Class.forName(str);
            try {
                if (Service.class.isAssignableFrom(cls)) {
                    strP = ad.f(context, str);
                } else if (BroadcastReceiver.class.isAssignableFrom(cls)) {
                    strP = ad.p(context, str);
                }
            } catch (Throwable th) {
                th = th;
                k63.a("JMessenger", str3 + " meet e:" + th);
            }
        } catch (Throwable th2) {
            th = th2;
            cls = null;
        }
        Class<?> cls2 = cls;
        try {
            if (a(context, str, str2, bundle, strP) != null) {
                return true;
            }
            if (g(context, cls2, str2, bundle)) {
                return true;
            }
        } catch (Throwable th3) {
            k63.l("JMessenger", "send, " + str3 + " meet e:" + th3);
        }
        k63.c("JMessenger", "send all failed, " + str3);
        return false;
    }

    public final Bundle f(String str, String str2, Bundle bundle, String str3) {
        String str4 = str + "." + str2;
        try {
            ll2 dataShare = DataShare.getInstance(str3);
            if (dataShare == null) {
                k63.a("JMessenger", str3 + "'s aidl not found, " + str4);
                return null;
            }
            k63.a("JMessenger", "sendByAidl, " + str4);
            if ("INTERNAL_API".equals(str)) {
                return dataShare.execute(str, str2, bundle);
            }
            dataShare.onAction(str, str2, bundle);
            return new Bundle();
        } catch (Throwable th) {
            k63.l("JMessenger", "sendByAidl, " + str4 + ", e=" + th);
            return null;
        }
    }

    public final boolean g(Context context, Class cls, String str, Bundle bundle) {
        Intent intent;
        if (cls == null) {
            return false;
        }
        String str2 = cls.getName() + "." + str;
        try {
            intent = new Intent();
            intent.setClass(context, cls);
            intent.setAction(str);
            intent.setPackage(context.getPackageName());
            if (bundle != null) {
                intent.putExtras(bundle);
            }
        } catch (Throwable th) {
            k63.l("JMessenger", "sendByComponent, " + str2 + " e=" + th);
        }
        if (BroadcastReceiver.class.isAssignableFrom(cls)) {
            context.sendBroadcast(intent);
            k63.a("JMessenger", "sendByReceiver, " + str2);
            return true;
        }
        if (Service.class.isAssignableFrom(cls)) {
            if (context.startService(intent) != null) {
                k63.a("JMessenger", "sendByService, " + str2);
                return true;
            }
            k63.l("JMessenger", "startService, " + str2 + ", can't find component");
        }
        return false;
    }

    public final Bundle h(Context context, String str, String str2, Bundle bundle, String str3) {
        String str4 = str + "." + str2;
        try {
            String strD = d(context, str3);
            if (TextUtils.isEmpty(strD)) {
                k63.a("JMessenger", "uri is null, check provider config");
                return null;
            }
            Uri uri = Uri.parse(strD);
            k63.a("JMessenger", "sendByProvider, uri=" + strD + ", " + str4);
            return context.getContentResolver().call(uri, str, str2, bundle);
        } catch (Throwable th) {
            k63.l("JMessenger", "provider call:" + th);
            return null;
        }
    }
}
