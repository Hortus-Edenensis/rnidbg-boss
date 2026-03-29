package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.analytics.pro.ca;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.net.URL;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class by {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10895a = "resolve.umeng.com";
    public static final int b = 15000;
    private static cc c = null;
    private static volatile int d = -1;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final by f10896a = new by();

        private a() {
        }
    }

    public static by a() {
        return a.f10896a;
    }

    private String c() {
        if (c == null) {
            c = cc.b();
        }
        ca caVar = new ca("https://resolve.umeng.com/resolve", ca.a.GET, null, c);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 发送domain下发请求。");
        return caVar.a(15000, "");
    }

    public synchronized boolean b() {
        if (d < 0) {
            String strImprintProperty = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), "cj_domain", "0");
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> cj_domain读取值：" + strImprintProperty);
            if ("1".equalsIgnoreCase(strImprintProperty)) {
                d = 1;
            } else {
                d = 0;
            }
        }
        return d <= 0;
    }

    private by() {
    }

    public synchronized String a(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        c();
        String strC = cc.b().c();
        if (!TextUtils.isEmpty(strC)) {
            str2 = "https://" + strC + "/" + str;
        }
        return str2;
    }

    private static String c(String str) {
        try {
            return new URL(str).getHost();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        return "https://" + str + "/" + str2;
    }

    public static String b(String str) {
        try {
            String strC = c(str);
            return str.substring(str.indexOf(strC) + strC.length() + 1);
        } catch (Throwable unused) {
            return "";
        }
    }
}
