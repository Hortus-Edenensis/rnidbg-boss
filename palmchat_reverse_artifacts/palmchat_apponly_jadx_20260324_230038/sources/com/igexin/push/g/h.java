package com.igexin.push.g;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.igexin.push.config.SDKUrlConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f7363a = 10000;
    private static final String b = "ErrorReport";

    /* JADX INFO: renamed from: com.igexin.push.g.h$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7364a;
        final /* synthetic */ a b;

        public AnonymousClass1(Context context, a aVar) {
            this.f7364a = context;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z = false;
            try {
                if (h.a()) {
                    com.igexin.push.core.d.d.a().a("s", Long.valueOf(System.currentTimeMillis()));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "upload_BI");
                    jSONObject.put("BIType", "25");
                    jSONObject.put("cid", "0");
                    jSONObject.put("BIData", new String(com.igexin.c.a.b.g.c(h.a(this.f7364a).getBytes()), "UTF-8"));
                    byte[] bArrA = r.a(SDKUrlConfig.getBiUploadServiceUrl(), com.igexin.c.b.a.b(jSONObject.toString().getBytes()));
                    if (bArrA != null) {
                        new String(bArrA);
                    }
                    z = true;
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
                com.igexin.c.a.c.a.a("ErrorReport|report 25 ex = " + th.toString(), new Object[0]);
            }
            a aVar = this.b;
            if (aVar != null) {
                aVar.a(z);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(boolean z);
    }

    public static String a(Context context) {
        String packageName = context.getPackageName();
        String strA = null;
        try {
            ApplicationInfo applicationInfoB = n.b(context);
            if (applicationInfoB != null && applicationInfoB.metaData != null) {
                strA = d.a(applicationInfoB);
                if (TextUtils.isEmpty(strA)) {
                    strA = applicationInfoB.metaData.getString(com.igexin.push.core.b.b);
                }
                if (TextUtils.isEmpty(strA)) {
                    strA = applicationInfoB.metaData.getString("GETUI_APPID");
                }
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        String str = Build.VERSION.SDK;
        String str2 = Build.VERSION.RELEASE;
        StringBuilder sb = new StringBuilder();
        sb.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append(strA);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("3.3.7.0");
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append(true);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append(n.g() == null ? "" : n.g());
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append(n.e());
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append(str);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append(str2);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append(n.a(context));
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append(n.k());
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append(packageName);
        if (g.d != null) {
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(g.d);
        }
        com.igexin.c.a.c.a.a("ErrorReport|" + sb.toString(), new Object[0]);
        return sb.toString();
    }

    private static void a(a aVar, Context context) {
        com.igexin.b.a.a().f7007a.execute(new AnonymousClass1(context, aVar));
    }

    public static boolean a() {
        try {
            return System.currentTimeMillis() - com.igexin.push.core.d.d.a().a("s", new long[0]) > 86400000;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return false;
        }
    }
}
