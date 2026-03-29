package com.cdo.oaps.ad;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.compatible.base.launcher.OapsLog;
import com.cdo.oaps.ad.wrapper.VerifyWrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class j implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5455a = "Y29tLm9wcG8ubWFpbi5BQ1RJT05fTEFVTkNI";
    private static final String b = "b3Bwby9sYXVuY2g=";
    private static final String c = "com.nearme.gamecenter";
    private static final String d = "com.heytap.market";

    private static String a(Context context, OapsWrapper oapsWrapper) {
        String host = oapsWrapper.getHost();
        if (Launcher.Host.GC.equals(host)) {
            return c;
        }
        if (Launcher.Host.MK.equals(host)) {
            return p.b(context, "com.heytap.market") ? "com.heytap.market" : a.b();
        }
        if (Launcher.Host.MK_OP.equals(host)) {
            return a.a();
        }
        return null;
    }

    public static boolean b(Context context, Uri uri, String str) {
        if (OapsLog.isDebugable()) {
            OapsLog.i("Uri = " + uri);
        }
        try {
            Intent intent = new Intent();
            intent.setAction(a.b("Y29tLm9wcG8ubWFpbi5BQ1RJT05fTEFVTkNI"));
            intent.setFlags(268435456);
            intent.setDataAndType(uri, a.b("b3Bwby9sYXVuY2g="));
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 32);
            if (listQueryIntentActivities == null || listQueryIntentActivities.size() <= 0) {
                return false;
            }
            for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                String str2 = resolveInfo.activityInfo.packageName;
                if (!TextUtils.isEmpty(str)) {
                    if (str.equals(str2)) {
                        ComponentName componentName = new ComponentName(str2, resolveInfo.activityInfo.name);
                        Intent intent2 = new Intent(intent);
                        intent2.setComponent(componentName);
                        context.startActivity(intent2);
                        return true;
                    }
                } else if (!c.equals(str2) && !a.b().equals(str2) && !"com.heytap.market".equalsIgnoreCase(str2)) {
                    ComponentName componentName2 = new ComponentName(str2, resolveInfo.activityInfo.name);
                    Intent intent22 = new Intent(intent);
                    intent22.setComponent(componentName2);
                    context.startActivity(intent22);
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static Map<String, Object> c(Context context, Map<String, Object> map) {
        String strValueOf = String.valueOf(System.currentTimeMillis());
        VerifyWrapper verifyWrapperWrapper = VerifyWrapper.wrapper((Map<String, Object>) new HashMap());
        verifyWrapperWrapper.setId(context.getPackageName());
        verifyWrapperWrapper.setTimestamp(strValueOf);
        OapsWrapper oapsWrapperWrapper = OapsWrapper.wrapper(map);
        verifyWrapperWrapper.setChecksum(a(verifyWrapperWrapper.getId(), verifyWrapperWrapper.getTimestamp()));
        for (Map.Entry<String, Object> entry : verifyWrapperWrapper.getParams().entrySet()) {
            oapsWrapperWrapper.set(entry.getKey(), entry.getValue());
        }
        return map;
    }

    public static String a(String str, String str2) {
        return i.a(str + str2);
    }

    private static boolean c(Context context, Uri uri, String str) {
        if (OapsLog.isDebugable()) {
            OapsLog.i("simple dp, Uri = " + uri);
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setFlags(268435456);
            intent.setData(uri);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.cdo.oaps.ad.l
    public boolean b(Context context, Map<String, Object> map) {
        OapsWrapper oapsWrapperWrapper = OapsWrapper.wrapper(map);
        if ("oaps".equals(oapsWrapperWrapper.getScheme())) {
            map = c(context, map);
        }
        return a(context, Uri.parse(OapsParser.encode(map)), a(context, oapsWrapperWrapper));
    }

    public static boolean a(Context context, Uri uri, String str) {
        if (OapsLog.isDebugable()) {
            OapsLog.i("Uri = " + uri);
        }
        try {
            Intent intent = new Intent();
            intent.setAction(a.b("Y29tLm9wcG8ubWFpbi5BQ1RJT05fTEFVTkNI"));
            intent.setDataAndType(uri, a.b("b3Bwby9sYXVuY2g="));
            List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 32);
            if (listQueryIntentServices == null || listQueryIntentServices.size() <= 0) {
                return false;
            }
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                String str2 = resolveInfo.serviceInfo.packageName;
                if (!TextUtils.isEmpty(str)) {
                    if (str.equals(str2)) {
                        ComponentName componentName = new ComponentName(str2, resolveInfo.serviceInfo.name);
                        Intent intent2 = new Intent(intent);
                        intent2.setComponent(componentName);
                        context.startService(intent2);
                        return true;
                    }
                } else if (!c.equals(str2) && !a.b().equals(str2) && !"com.heytap.market".equalsIgnoreCase(str2)) {
                    ComponentName componentName2 = new ComponentName(str2, resolveInfo.serviceInfo.name);
                    Intent intent22 = new Intent(intent);
                    intent22.setComponent(componentName2);
                    context.startService(intent22);
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static boolean a(Context context, String str) {
        if ("com.heytap.market".equalsIgnoreCase(str) || a.b().equalsIgnoreCase(str)) {
            return p.a(context, str) >= 7200;
        }
        if (c.equalsIgnoreCase(str)) {
            return p.a(context, str) >= 8300;
        }
        a.a().equalsIgnoreCase(str);
        return false;
    }

    @Override // com.cdo.oaps.ad.l
    public boolean a(Context context, Map<String, Object> map) {
        OapsWrapper oapsWrapperWrapper = OapsWrapper.wrapper(map);
        String strA = a(context, oapsWrapperWrapper);
        if ("oaps".equals(oapsWrapperWrapper.getScheme())) {
            map = c(context, map);
        }
        return b(context, Uri.parse(OapsParser.encode(map)), strA);
    }
}
