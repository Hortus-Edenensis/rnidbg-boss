package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import com.xiaomi.push.ae;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.dv;
import com.xiaomi.push.dw;
import com.xiaomi.push.g;
import com.xiaomi.push.gf;
import com.xiaomi.push.gs;
import com.xiaomi.push.hb;
import com.xiaomi.push.service.ae;
import j$.util.Objects;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f11784a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static volatile ab f1025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final LinkedList<Pair<Integer, hb>> f1026a = new LinkedList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ExecutorService f1027a = Executors.newCachedThreadPool();

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Callable<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f11786a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f1030a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f1031a;

        public a(String str, Context context, boolean z) {
            this.f11786a = context;
            this.f1030a = str;
            this.f1031a = z;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap call() throws Throwable {
            if (TextUtils.isEmpty(this.f1030a)) {
                com.xiaomi.channel.commonutils.logger.b.m74a("Failed get online picture/icon resource cause picUrl is empty");
                return null;
            }
            if (this.f1030a.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                ae.b bVarA = ae.a(this.f11786a, this.f1030a, this.f1031a);
                if (bVarA != null) {
                    return bVarA.f915a;
                }
                com.xiaomi.channel.commonutils.logger.b.m74a("Failed get online picture/icon resource");
                return null;
            }
            Bitmap bitmapA = ae.a(this.f11786a, this.f1030a);
            if (bitmapA != null) {
                return bitmapA;
            }
            com.xiaomi.channel.commonutils.logger.b.m74a("Failed get online picture/icon resource");
            return bitmapA;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f11787a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        Notification f1032a;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f1033a;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f11788a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f1034a = false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m779a(Context context, String str) {
        return com.xiaomi.push.g.m480b(context, str);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private static boolean m786b(Map<String, String> map) {
        if (map != null) {
            return "6".equals(map.get("notification_style_type"));
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("meta extra is null");
        return false;
    }

    public static void c(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    public static boolean d(hb hbVar) {
        return hbVar.a() == gf.Registration;
    }

    public static boolean e(hb hbVar) {
        return m781a(hbVar) || c(hbVar) || m785b(hbVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m780a(Context context, String str, boolean z) {
        return com.xiaomi.push.j.m650a() && !z && m779a(context, str);
    }

    public static boolean c(hb hbVar) {
        gs gsVarM553a = hbVar.m553a();
        return a(gsVarM553a) && gsVarM553a.f572b == 0 && !m781a(hbVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static c m777a(Context context, hb hbVar, byte[] bArr) {
        int iC;
        Map<String, String> mapM520a;
        int i;
        c cVar = new c();
        g.b bVarA = com.xiaomi.push.g.a(context, a(hbVar), true);
        gs gsVarM553a = hbVar.m553a();
        if (gsVarM553a != null) {
            iC = gsVarM553a.c();
            mapM520a = gsVarM553a.m520a();
        } else {
            iC = 0;
            mapM520a = null;
        }
        final int iB = com.xiaomi.push.s.b(a(hbVar), iC);
        if (com.xiaomi.push.j.m651a(context) && bVarA == g.b.NOT_ALLOWED) {
            if (gsVarM553a != null) {
                dt.a(context.getApplicationContext()).a(hbVar.b(), b(hbVar), gsVarM553a.m519a(), "10:" + a(hbVar));
            }
            com.xiaomi.channel.commonutils.logger.b.m74a("Do not notify because user block " + a(hbVar) + "‘s notification");
            return cVar;
        }
        if (com.xiaomi.push.j.m651a(context) && f1025a != null && f1025a.m694a(context, iB, a(hbVar), mapM520a)) {
            if (gsVarM553a != null) {
                dt.a(context.getApplicationContext()).a(hbVar.b(), b(hbVar), gsVarM553a.m519a(), "14:" + a(hbVar));
            }
            com.xiaomi.channel.commonutils.logger.b.m74a("Do not notify because card notification is canceled or sequence incorrect");
            return cVar;
        }
        RemoteViews remoteViewsA = a(context, hbVar, bArr);
        PendingIntent pendingIntentA = a(context, hbVar, hbVar.b(), bArr, iB);
        if (pendingIntentA == null) {
            if (gsVarM553a != null) {
                dt.a(context.getApplicationContext()).a(hbVar.b(), b(hbVar), gsVarM553a.m519a(), "11");
            }
            com.xiaomi.channel.commonutils.logger.b.m74a("The click PendingIntent is null. ");
            return cVar;
        }
        b bVarA2 = a(context, hbVar, bArr, remoteViewsA, pendingIntentA, iB);
        cVar.f11788a = bVarA2.f11787a;
        cVar.f1033a = a(hbVar);
        Notification notification = bVarA2.f1032a;
        if (com.xiaomi.push.j.m650a()) {
            if (!TextUtils.isEmpty(gsVarM553a.m519a())) {
                notification.extras.putString("message_id", gsVarM553a.m519a());
            }
            notification.extras.putString("local_paid", hbVar.m554a());
            ag.a(mapM520a, notification.extras, "msg_busi_type");
            ag.a(mapM520a, notification.extras, "disable_notification_flags");
            String str = gsVarM553a.m525b() == null ? null : gsVarM553a.m525b().get("score_info");
            if (!TextUtils.isEmpty(str)) {
                notification.extras.putString("score_info", str);
            }
            notification.extras.putString("pushUid", a(gsVarM553a.f570a, "n_stats_expose"));
            if (c(hbVar)) {
                i = 1000;
            } else {
                i = m781a(hbVar) ? 3000 : -1;
            }
            notification.extras.putString("eventMessageType", String.valueOf(i));
            notification.extras.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, a(hbVar));
        }
        String str2 = gsVarM553a.m520a() != null ? gsVarM553a.m520a().get("message_count") : null;
        if (com.xiaomi.push.j.m650a() && str2 != null) {
            try {
                ag.a(notification, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                dt.a(context.getApplicationContext()).b(hbVar.b(), b(hbVar), gsVarM553a.m519a(), "8");
                com.xiaomi.channel.commonutils.logger.b.d("fail to set message count. " + e);
            }
        }
        String strA = a(hbVar);
        ag.m712a(notification, strA);
        final af afVarA = af.a(context, strA);
        if (com.xiaomi.push.j.m651a(context) && f1025a != null) {
            f1025a.a(hbVar, gsVarM553a.m520a(), iB, notification);
        }
        if (com.xiaomi.push.j.m651a(context) && f1025a != null && f1025a.a(gsVarM553a.m520a(), iB, notification)) {
            com.xiaomi.channel.commonutils.logger.b.b("consume this notificaiton by agent");
        } else {
            afVarA.a(iB, notification);
            cVar.f1034a = true;
            com.xiaomi.channel.commonutils.logger.b.m74a("notification: " + gsVarM553a.m519a() + " is notifyied");
        }
        if (com.xiaomi.push.j.m650a() && com.xiaomi.push.j.m651a(context)) {
            ad.a().a(context, iB, notification);
            bb.m737a(context, strA, iB, gsVarM553a.m519a(), notification);
        }
        if (m781a(hbVar)) {
            dt.a(context.getApplicationContext()).a(hbVar.b(), b(hbVar), gsVarM553a.m519a(), 3002, null);
        }
        if (c(hbVar)) {
            dt.a(context.getApplicationContext()).a(hbVar.b(), b(hbVar), gsVarM553a.m519a(), 1002, null);
        }
        if (Build.VERSION.SDK_INT < 26) {
            String strM519a = gsVarM553a.m519a();
            com.xiaomi.push.ae aeVarA = com.xiaomi.push.ae.a(context);
            int iA = a(gsVarM553a.m520a());
            if (iA > 0 && !TextUtils.isEmpty(strM519a)) {
                final String str3 = "n_timeout_" + strM519a;
                aeVarA.m155a(str3);
                aeVarA.b(new ae.a() { // from class: com.xiaomi.push.service.x.1
                    @Override // com.xiaomi.push.ae.a
                    /* JADX INFO: renamed from: a */
                    public String mo207a() {
                        return str3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        afVarA.a(iB);
                    }
                }, iA);
            }
        }
        Pair<Integer, hb> pair = new Pair<>(Integer.valueOf(iB), hbVar);
        LinkedList<Pair<Integer, hb>> linkedList = f1026a;
        synchronized (linkedList) {
            linkedList.add(pair);
            if (linkedList.size() > 100) {
                linkedList.remove();
            }
        }
        return cVar;
    }

    private static int b(Context context, String str) {
        int iA = a(context, str, "mipush_notification");
        int iA2 = a(context, str, "mipush_small_notification");
        if (iA <= 0) {
            iA = iA2 > 0 ? iA2 : context.getApplicationInfo().icon;
        }
        return iA == 0 ? context.getApplicationInfo().logo : iA;
    }

    private static int c(Map<String, String> map) {
        if (map == null) {
            return 0;
        }
        String str = map.get("notification_priority");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.c("priority=" + str);
            return Integer.parseInt(str);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("parsing notification priority error: " + e);
            return 0;
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static void m783b(Context context, String str) {
        if (!com.xiaomi.push.j.m651a(context) || f1025a == null || TextUtils.isEmpty(str)) {
            return;
        }
        f1025a.a(str);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static boolean m784b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    public static void b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static boolean m785b(hb hbVar) {
        gs gsVarM553a = hbVar.m553a();
        return a(gsVarM553a) && gsVarM553a.f572b == 1 && !m781a(hbVar);
    }

    public static String b(hb hbVar) {
        return m781a(hbVar) ? "E100002" : c(hbVar) ? "E100000" : m785b(hbVar) ? "E100001" : d(hbVar) ? "E100003" : "";
    }

    private static int b(Map<String, String> map) {
        if (map == null) {
            return 3;
        }
        String str = map.get("channel_importance");
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.c("importance=" + str);
            return Integer.parseInt(str);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("parsing channel importance error: " + e);
            return 3;
        }
    }

    public static Intent b(Context context, String str, Map<String, String> map, int i) {
        Intent launchIntentForPackage;
        String str2;
        Intent intent;
        String protocol;
        Intent uri;
        if (map == null) {
            return null;
        }
        if (i != 0) {
            return m776a(context, str, map, i);
        }
        if (!map.containsKey("notify_effect")) {
            return null;
        }
        String str3 = map.get("notify_effect");
        String str4 = map.get("intent_flag");
        int i2 = -1;
        try {
            if (!TextUtils.isEmpty(str4)) {
                i2 = Integer.parseInt(str4);
            }
        } catch (NumberFormatException e) {
            com.xiaomi.channel.commonutils.logger.b.d("Cause by intent_flag: " + e.getMessage());
        }
        if (an.f11726a.equals(str3)) {
            try {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e2.getMessage());
                launchIntentForPackage = null;
            }
        } else if (an.b.equals(str3)) {
            if (map.containsKey("intent_uri")) {
                String str5 = map.get("intent_uri");
                if (str5 != null) {
                    try {
                        uri = Intent.parseUri(str5, 1);
                    } catch (URISyntaxException e3) {
                        e = e3;
                        uri = null;
                    }
                    try {
                        uri.setPackage(str);
                    } catch (URISyntaxException e4) {
                        e = e4;
                        com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                    }
                    launchIntentForPackage = uri;
                }
            } else if (map.containsKey("class_name")) {
                String str6 = map.get("class_name");
                intent = new Intent();
                intent.setComponent(new ComponentName(str, str6));
                launchIntentForPackage = intent;
            }
            launchIntentForPackage = null;
        } else {
            if (an.c.equals(str3) && (str2 = map.get("web_uri")) != null) {
                String strTrim = str2.trim();
                if (!strTrim.startsWith("http://") && !strTrim.startsWith("https://")) {
                    strTrim = "http://" + strTrim;
                }
                try {
                    protocol = new URL(strTrim).getProtocol();
                } catch (MalformedURLException e5) {
                    e = e5;
                    intent = null;
                }
                if (HttpHost.DEFAULT_SCHEME_NAME.equals(protocol) || BaseConstants.SCHEME_HTTPS.equals(protocol)) {
                    intent = new Intent("android.intent.action.VIEW");
                    try {
                        intent.setData(Uri.parse(strTrim));
                        ag.a(context, str, intent);
                    } catch (MalformedURLException e6) {
                        e = e6;
                        com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                    }
                    launchIntentForPackage = intent;
                }
            }
            launchIntentForPackage = null;
        }
        if (launchIntentForPackage != null) {
            if (i2 >= 0) {
                launchIntentForPackage.setFlags(i2);
            }
            a(launchIntentForPackage);
            launchIntentForPackage.addFlags(268435456);
            try {
                if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                    return launchIntentForPackage;
                }
                if (Build.VERSION.SDK_INT >= 30 && !com.xiaomi.push.j.m651a(context) && an.c.equals(str3)) {
                    return launchIntentForPackage;
                }
                com.xiaomi.channel.commonutils.logger.b.m74a("not resolve activity:" + launchIntentForPackage);
            } catch (Exception e7) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e7.getMessage());
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void b(Context context, String str, dv dvVar, Map<String, String> map) {
        boolean z;
        int iA;
        if (!com.xiaomi.push.j.m651a(context)) {
            String strA = a(map, "fcm_icon_uri");
            String strA2 = a(map, "fcm_icon_color");
            if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strA2) || (iA = a(context, str, strA)) <= 0) {
                z = false;
            } else {
                dvVar.setSmallIcon(iA);
                dvVar.mo386a(strA2);
                z = true;
            }
        }
        if (z) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            dvVar.setSmallIcon(Icon.createWithResource(str, ag.a(context, str)));
        } else {
            dvVar.setSmallIcon(b(context, str));
        }
    }

    private static PendingIntent a(Context context, hb hbVar, String str, byte[] bArr, int i) {
        return a(context, hbVar, str, bArr, i, 0, a(context, hbVar, str));
    }

    private static PendingIntent a(Context context, hb hbVar, String str, byte[] bArr, int i, int i2, boolean z) {
        int i3;
        Intent intent;
        if (c(hbVar)) {
            i3 = 1000;
        } else {
            i3 = m781a(hbVar) ? 3000 : -1;
        }
        gs gsVarM553a = hbVar.m553a();
        String strM519a = gsVarM553a != null ? gsVarM553a.m519a() : "";
        boolean zM781a = m781a(hbVar);
        if (gsVarM553a != null && !TextUtils.isEmpty(gsVarM553a.f579e)) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(gsVarM553a.f579e));
            try {
                String protocol = new URL(gsVarM553a.f579e).getProtocol();
                if (!HttpHost.DEFAULT_SCHEME_NAME.equals(protocol) && !BaseConstants.SCHEME_HTTPS.equals(protocol)) {
                    intent2.setPackage(str);
                } else {
                    ag.a(context, str, intent2);
                }
            } catch (MalformedURLException unused) {
                com.xiaomi.channel.commonutils.logger.b.m74a("meet URL exception : " + gsVarM553a.f579e);
                intent2.setPackage(str);
            }
            intent2.addFlags(268435456);
            intent2.putExtra("messageId", strM519a);
            intent2.putExtra("eventMessageType", i3);
            if (Build.VERSION.SDK_INT >= 31) {
                return PendingIntent.getActivity(context, 0, intent2, 167772160);
            }
            return PendingIntent.getActivity(context, 0, intent2, 134217728);
        }
        if (zM781a) {
            intent = new Intent();
            intent.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(i));
            intent.addCategory(String.valueOf(strM519a));
        } else {
            intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.setComponent(new ComponentName(str, "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(i));
            intent.addCategory(String.valueOf(strM519a));
        }
        intent.putExtra("notification_click_button", i2);
        intent.putExtra("messageId", strM519a);
        intent.putExtra("eventMessageType", i3);
        if (!zM781a && z) {
            Intent intent3 = new Intent();
            intent3.setComponent(a(str));
            intent3.addFlags(276824064);
            intent3.putExtra("mipush_serviceIntent", intent);
            intent3.addCategory(String.valueOf(i));
            intent3.addCategory(String.valueOf(strM519a));
            intent3.addCategory(String.valueOf(i2));
            a(context, intent3, hbVar, gsVarM553a, strM519a, i2);
            if (Build.VERSION.SDK_INT >= 31) {
                return PendingIntent.getActivity(context, 0, intent3, 167772160);
            }
            return PendingIntent.getActivity(context, 0, intent3, 134217728);
        }
        a(context, intent, hbVar, gsVarM553a, strM519a, i2);
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getService(context, 0, intent, 167772160);
        }
        return PendingIntent.getService(context, 0, intent, 134217728);
    }

    private static void a(Context context, Intent intent, hb hbVar, gs gsVar, String str, int i) {
        if (hbVar == null || gsVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        String strA = a(gsVar.m520a(), i);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        if (an.f11726a.equals(strA) || an.b.equals(strA) || an.c.equals(strA)) {
            intent.putExtra("messageId", str);
            intent.putExtra("local_paid", hbVar.f658a);
            if (!TextUtils.isEmpty(hbVar.f662b)) {
                intent.putExtra(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, hbVar.f662b);
            }
            intent.putExtra("job_key", a(gsVar.m520a(), "jobkey"));
            intent.putExtra(i + "_target_component", a(context, hbVar.f662b, gsVar.m520a(), i));
        }
    }

    private static boolean a(Context context, hb hbVar, String str) {
        if (hbVar != null && hbVar.m553a() != null && hbVar.m553a().m520a() != null && !TextUtils.isEmpty(str)) {
            return Boolean.parseBoolean(hbVar.m553a().m520a().get("use_clicked_activity")) && j.a(context, a(str));
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("should clicked activity params are null.");
        return false;
    }

    public static ComponentName a(String str) {
        return new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0072 A[PHI: r0 r3
      0x0072: PHI (r0v4 java.lang.String) = (r0v2 java.lang.String), (r0v5 java.lang.String) binds: [B:18:0x0070, B:10:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x0072: PHI (r3v14 java.lang.String) = (r3v13 java.lang.String), (r3v20 java.lang.String) binds: [B:18:0x0070, B:10:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String[] a(Context context, gs gsVar) {
        String str;
        String strM527c = gsVar.m527c();
        String strD = gsVar.d();
        Map<String, String> mapM520a = gsVar.m520a();
        if (mapM520a != null) {
            int iIntValue = Float.valueOf((context.getResources().getDisplayMetrics().widthPixels / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
            if (iIntValue <= 320) {
                String str2 = mapM520a.get("title_short");
                if (!TextUtils.isEmpty(str2)) {
                    strM527c = str2;
                }
                str = mapM520a.get("description_short");
                if (!TextUtils.isEmpty(str)) {
                    strD = str;
                }
            } else if (iIntValue > 360) {
                String str3 = mapM520a.get("title_long");
                if (!TextUtils.isEmpty(str3)) {
                    strM527c = str3;
                }
                str = mapM520a.get("description_long");
                if (!TextUtils.isEmpty(str)) {
                }
            }
        }
        return new String[]{strM527c, strD};
    }

    private static String a(Map<String, String> map, String str) {
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    private static int a(Context context, String str, Map<String, String> map, int i) {
        ComponentName componentNameA;
        Intent intentB = b(context, str, map, i);
        if (intentB == null || (componentNameA = j.a(context, intentB)) == null) {
            return 0;
        }
        return componentNameA.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0280  */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v29 */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static b a(Context context, hb hbVar, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent, int i) throws Throwable {
        dv dvVar;
        boolean z;
        String strA;
        boolean z2;
        boolean z3;
        long jCurrentTimeMillis;
        String str;
        boolean z4;
        b bVar;
        int iA;
        String str2;
        Notification notification;
        Bitmap bitmapA;
        int i2;
        Bitmap bitmapA2;
        b bVar2 = new b();
        gs gsVarM553a = hbVar.m553a();
        String strA2 = a(hbVar);
        Map<String, String> mapM520a = gsVarM553a.m520a();
        String[] strArrA = a(context, gsVarM553a);
        if (remoteViews != null) {
            dvVar = new dv(context);
            dvVar.setCustomContentView(remoteViews);
        } else if (mapM520a != null && mapM520a.containsKey("notification_style_type")) {
            dvVar = a(context, hbVar, bArr, strArrA[1], i);
        } else {
            dvVar = new dv(context);
        }
        dv dvVar2 = dvVar;
        a(dvVar2, context, hbVar.b(), hbVar, bArr, i);
        dvVar2.setContentTitle(strArrA[0]);
        dvVar2.setContentText(strArrA[1]);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        dvVar2.setWhen(jCurrentTimeMillis2);
        String strA3 = a(mapM520a, "notification_show_when");
        if (TextUtils.isEmpty(strA3)) {
            if (Build.VERSION.SDK_INT >= 24) {
                dvVar2.setShowWhen(true);
            }
        } else {
            dvVar2.setShowWhen(Boolean.parseBoolean(strA3));
        }
        dvVar2.setContentIntent(pendingIntent);
        a(context, strA2, dvVar2, mapM520a);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            if (mapM520a == null) {
                i2 = 1;
                bitmapA2 = null;
            } else {
                i2 = 1;
                bitmapA2 = a(context, mapM520a.get("notification_small_icon_uri"), true);
            }
            if (bitmapA2 != null) {
                Object[] objArr = new Object[i2];
                objArr[0] = bitmapA2;
                Object objA = com.xiaomi.push.aw.a("android.graphics.drawable.Icon", "createWithBitmap", objArr);
                if (objA != null) {
                    Object[] objArr2 = new Object[i2];
                    objArr2[0] = objA;
                    com.xiaomi.push.aw.a((Object) dvVar2, "setSmallIcon", objArr2);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("miui.isGrayscaleIcon", i2);
                    dvVar2.addExtras(bundle);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m74a("failed te get small icon with url:" + mapM520a.get("notification_small_icon_uri"));
                }
            } else {
                com.xiaomi.channel.commonutils.logger.b.m74a("failed to get small icon url:" + a(mapM520a, "notification_small_icon_uri"));
            }
            dvVar2.mo386a(a(mapM520a, "notification_small_icon_color"));
        }
        String strA4 = a(mapM520a, "__dynamic_icon_uri");
        boolean z5 = Boolean.parseBoolean(a(mapM520a, "__adiom")) || !com.xiaomi.push.j.m650a();
        if (TextUtils.isEmpty(strA4) || !z5) {
            z = false;
        } else {
            if (strA4.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                ae.b bVarA = ae.a(context, strA4, true);
                if (bVarA != null) {
                    bitmapA = bVarA.f915a;
                    bVar2.f11787a = bVarA.f11709a;
                } else {
                    bitmapA = null;
                }
            } else {
                bitmapA = ae.a(context, strA4);
            }
            if (bitmapA != null) {
                dvVar2.setLargeIcon(bitmapA);
                z = true;
            }
        }
        Bitmap bitmapA3 = mapM520a == null ? null : a(context, mapM520a.get("notification_large_icon_uri"), true);
        if (bitmapA3 != null) {
            dvVar2.setLargeIcon(bitmapA3);
        }
        if (mapM520a == null || i3 < 24) {
            strA = null;
            z2 = false;
        } else {
            String strA5 = mapM520a.get("notification_group");
            z2 = Boolean.parseBoolean(mapM520a.get("notification_is_summary"));
            boolean z6 = Boolean.parseBoolean(mapM520a.get("notification_group_disable_default"));
            if (TextUtils.isEmpty(strA5) && (com.xiaomi.push.j.m650a() || !z6)) {
                strA5 = a(hbVar);
            }
            String str3 = strA5;
            com.xiaomi.push.aw.a((Object) dvVar2, "setGroupSummary", Boolean.valueOf(z2));
            String str4 = mapM520a.get("notification_style_type");
            if ("com.xiaomi.xmsf".equals(context.getPackageName()) && ("4".equals(str4) || "3".equals(str4))) {
                strA = a(hbVar) + "_custom_" + jCurrentTimeMillis2;
                z3 = true;
                dvVar2.setAutoCancel(true);
                jCurrentTimeMillis = System.currentTimeMillis();
                if (mapM520a != null && mapM520a.containsKey(RemoteMessageConst.Notification.TICKER)) {
                    dvVar2.setTicker(mapM520a.get(RemoteMessageConst.Notification.TICKER));
                }
                if (jCurrentTimeMillis - f11784a <= 10000) {
                    f11784a = jCurrentTimeMillis;
                    iA = gsVarM553a.f566a;
                    if (m784b(context, strA2)) {
                        iA = a(context, strA2);
                    }
                    dvVar2.setDefaults(iA);
                    if (mapM520a == null || (iA & 1) == 0) {
                        str = "com.xiaomi.xmsf";
                        z4 = z;
                        bVar = bVar2;
                    } else {
                        bVar = bVar2;
                        String str5 = mapM520a.get("sound_uri");
                        if (TextUtils.isEmpty(str5)) {
                            str = "com.xiaomi.xmsf";
                            z4 = z;
                        } else {
                            z4 = z;
                            StringBuilder sb = new StringBuilder();
                            str = "com.xiaomi.xmsf";
                            sb.append("android.resource://");
                            sb.append(strA2);
                            if (str5.startsWith(sb.toString())) {
                                dvVar2.setDefaults(iA ^ 1);
                                dvVar2.setSound(Uri.parse(str5));
                            }
                        }
                    }
                } else {
                    str = "com.xiaomi.xmsf";
                    z4 = z;
                    bVar = bVar2;
                    iA = -100;
                }
                if (mapM520a != null || i3 < 26) {
                    str2 = "0";
                    if (mapM520a != null && i3 < 26) {
                        com.xiaomi.push.aw.a((Object) dvVar2, "setPriority", Integer.valueOf(c(mapM520a)));
                    }
                } else {
                    af afVarA = af.a(context, strA2);
                    if (a(mapM520a) > 0) {
                        str2 = "0";
                        com.xiaomi.push.aw.a((Object) dvVar2, "setTimeoutAfter", Long.valueOf(r0 * 1000));
                    } else {
                        str2 = "0";
                    }
                    ac.a(gsVarM553a);
                    String str6 = mapM520a.get("channel_id");
                    if (!TextUtils.isEmpty(str6) || context.getApplicationInfo().targetSdkVersion >= 26) {
                        String strA6 = a(context, strA2, mapM520a);
                        int iB = b(mapM520a);
                        int i4 = gsVarM553a.f566a;
                        String str7 = mapM520a.get("channel_description");
                        String str8 = mapM520a.get("sound_uri");
                        String str9 = mapM520a.get("channel_perm");
                        bb.a(context, mapM520a, dvVar2, jCurrentTimeMillis2);
                        com.xiaomi.push.aw.a((Object) dvVar2, "setChannelId", ac.a(afVarA, str6, strA6, str7, i4, iB, str8, str9));
                        if (iA == -100 && ag.a(mapM520a)) {
                            ag.a(dvVar2, z2);
                        }
                        if ("pulldown".equals(ag.a((Object) mapM520a)) && ag.a(mapM520a) && Objects.equals(mapM520a.get("pull_down_pop_type"), str2)) {
                            ag.a(dvVar2, z2);
                        }
                        if ("tts".equals(ag.a((Object) mapM520a)) && ag.a(mapM520a)) {
                            ag.a(dvVar2, z2);
                        }
                    }
                    String str10 = mapM520a.get("background_color");
                    if (!TextUtils.isEmpty(str10)) {
                        try {
                            int i5 = Integer.parseInt(str10);
                            dvVar2.setOngoing(true);
                            dvVar2.setColor(i5);
                            com.xiaomi.push.aw.a((Object) dvVar2, "setColorized", Boolean.TRUE);
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                        }
                    }
                }
                if (strA != null) {
                    if (!z3) {
                        strA = ad.a().a(context, dvVar2, strA);
                    }
                    com.xiaomi.push.aw.a((Object) dvVar2, "setGroup", strA);
                }
                if (com.xiaomi.push.j.m655c() && str.equals(context.getPackageName())) {
                    com.xiaomi.push.aw.a("miui.util.NotificationHelper", "setTargetPkg", context, dvVar2, a(hbVar));
                }
                notification = dvVar2.getNotification();
                if (z4 && com.xiaomi.push.j.m650a()) {
                    a(notification);
                }
                if (mapM520a != null) {
                    if (notification.extras == null) {
                        notification.extras = new Bundle();
                    }
                    if (!TextUtils.isEmpty(mapM520a.get("enable_keyguard"))) {
                        ag.b(notification, Boolean.parseBoolean(mapM520a.get("enable_keyguard")));
                    }
                    if (!TextUtils.isEmpty(mapM520a.get("enable_float"))) {
                        ag.a(notification, Boolean.parseBoolean(mapM520a.get("enable_float")));
                    }
                    if (!TextUtils.isEmpty(mapM520a.get("float_small_win")) && str2.equals(mapM520a.get("float_small_win")) && com.xiaomi.push.g.d(context, strA2)) {
                        ag.a(notification, false);
                    }
                    int iA2 = com.xiaomi.push.s.a(mapM520a.get("section_is_prr"), -1);
                    int iA3 = com.xiaomi.push.s.a(mapM520a.get("section_prr_cl"), -1);
                    if (iA2 >= 0 && iA3 >= 0) {
                        ag.a(notification, iA2, iA3);
                    }
                }
                b bVar3 = bVar;
                bVar3.f1032a = notification;
                return bVar3;
            }
            strA = str3;
        }
        z3 = false;
        dvVar2.setAutoCancel(true);
        jCurrentTimeMillis = System.currentTimeMillis();
        if (mapM520a != null) {
            dvVar2.setTicker(mapM520a.get(RemoteMessageConst.Notification.TICKER));
        }
        if (jCurrentTimeMillis - f11784a <= 10000) {
        }
        if (mapM520a != null) {
            str2 = "0";
            if (mapM520a != null) {
                com.xiaomi.push.aw.a((Object) dvVar2, "setPriority", Integer.valueOf(c(mapM520a)));
            }
        }
        if (strA != null) {
        }
        if (com.xiaomi.push.j.m655c()) {
            com.xiaomi.push.aw.a("miui.util.NotificationHelper", "setTargetPkg", context, dvVar2, a(hbVar));
        }
        notification = dvVar2.getNotification();
        if (z4) {
            a(notification);
        }
        if (mapM520a != null) {
        }
        b bVar32 = bVar;
        bVar32.f1032a = notification;
        return bVar32;
    }

    @TargetApi(16)
    private static void a(dv dvVar, Context context, String str, hb hbVar, byte[] bArr, int i) {
        PendingIntent pendingIntentA;
        PendingIntent pendingIntentA2;
        PendingIntent pendingIntentA3;
        PendingIntent pendingIntentA4;
        Map<String, String> mapM520a = hbVar.m553a().m520a();
        if (TextUtils.equals("3", mapM520a.get("notification_style_type")) || TextUtils.equals("4", mapM520a.get("notification_style_type"))) {
            return;
        }
        if (m786b(mapM520a)) {
            for (int i2 = 1; i2 <= 3; i2++) {
                String str2 = mapM520a.get(String.format("cust_btn_%s_n", Integer.valueOf(i2)));
                if (!TextUtils.isEmpty(str2) && (pendingIntentA4 = a(context, str, hbVar, bArr, i, i2)) != null) {
                    dvVar.addAction(0, str2, pendingIntentA4);
                }
            }
            return;
        }
        if (!TextUtils.isEmpty(mapM520a.get("notification_style_button_left_name")) && (pendingIntentA3 = a(context, str, hbVar, bArr, i, 1)) != null) {
            dvVar.addAction(0, mapM520a.get("notification_style_button_left_name"), pendingIntentA3);
        }
        if (!TextUtils.isEmpty(mapM520a.get("notification_style_button_mid_name")) && (pendingIntentA2 = a(context, str, hbVar, bArr, i, 2)) != null) {
            dvVar.addAction(0, mapM520a.get("notification_style_button_mid_name"), pendingIntentA2);
        }
        if (TextUtils.isEmpty(mapM520a.get("notification_style_button_right_name")) || (pendingIntentA = a(context, str, hbVar, bArr, i, 3)) == null) {
            return;
        }
        dvVar.addAction(0, mapM520a.get("notification_style_button_right_name"), pendingIntentA);
    }

    private static PendingIntent a(Context context, String str, hb hbVar, byte[] bArr, int i, int i2) {
        Map<String, String> mapM520a = hbVar.m553a().m520a();
        if (mapM520a == null) {
            return null;
        }
        boolean zA = a(context, hbVar, str);
        if (zA) {
            return a(context, hbVar, str, bArr, i, i2, zA);
        }
        Intent intentM776a = m776a(context, str, mapM520a, i2);
        if (intentM776a == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getActivity(context, 0, intentM776a, 167772160);
        }
        return PendingIntent.getActivity(context, 0, intentM776a, 134217728);
    }

    public static String a(Map<String, String> map, int i) {
        String str;
        if (i == 0) {
            str = "notify_effect";
        } else {
            str = m786b(map) ? String.format("cust_btn_%s_ne", Integer.valueOf(i)) : i == 1 ? "notification_style_button_left_notify_effect" : i == 2 ? "notification_style_button_mid_notify_effect" : i == 3 ? "notification_style_button_right_notify_effect" : i == 4 ? "notification_colorful_button_notify_effect" : null;
        }
        if (map == null || str == null) {
            return null;
        }
        return map.get(str);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Intent m776a(Context context, String str, Map<String, String> map, int i) {
        if (m786b(map)) {
            return a(context, str, map, String.format("cust_btn_%s_ne", Integer.valueOf(i)), String.format("cust_btn_%s_iu", Integer.valueOf(i)), String.format("cust_btn_%s_ic", Integer.valueOf(i)), String.format("cust_btn_%s_wu", Integer.valueOf(i)));
        }
        if (i == 1) {
            return a(context, str, map, "notification_style_button_left_notify_effect", "notification_style_button_left_intent_uri", "notification_style_button_left_intent_class", "notification_style_button_left_web_uri");
        }
        if (i == 2) {
            return a(context, str, map, "notification_style_button_mid_notify_effect", "notification_style_button_mid_intent_uri", "notification_style_button_mid_intent_class", "notification_style_button_mid_web_uri");
        }
        if (i == 3) {
            return a(context, str, map, "notification_style_button_right_notify_effect", "notification_style_button_right_intent_uri", "notification_style_button_right_intent_class", "notification_style_button_right_web_uri");
        }
        if (i != 4) {
            return null;
        }
        return a(context, str, map, "notification_colorful_button_notify_effect", "notification_colorful_button_intent_uri", "notification_colorful_button_intent_class", "notification_colorful_button_web_uri");
    }

    private static Intent a(Context context, String str, Map<String, String> map, String str2, String str3, String str4, String str5) {
        Intent launchIntentForPackage;
        Intent intent;
        String protocol;
        Intent uri;
        String str6 = map.get(str2);
        if (TextUtils.isEmpty(str6)) {
            return null;
        }
        if (an.f11726a.equals(str6)) {
            try {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                launchIntentForPackage = null;
            }
        } else if (an.b.equals(str6)) {
            if (map.containsKey(str3)) {
                String str7 = map.get(str3);
                if (str7 != null) {
                    try {
                        uri = Intent.parseUri(str7, 1);
                    } catch (URISyntaxException e2) {
                        e = e2;
                        uri = null;
                    }
                    try {
                        uri.setPackage(str);
                    } catch (URISyntaxException e3) {
                        e = e3;
                        com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                    }
                    launchIntentForPackage = uri;
                }
            } else if (map.containsKey(str4)) {
                String str8 = map.get(str4);
                intent = new Intent();
                intent.setComponent(new ComponentName(str, str8));
                launchIntentForPackage = intent;
            }
            launchIntentForPackage = null;
        } else {
            if (an.c.equals(str6)) {
                String str9 = map.get(str5);
                if (!TextUtils.isEmpty(str9)) {
                    String strTrim = str9.trim();
                    if (!strTrim.startsWith("http://") && !strTrim.startsWith("https://")) {
                        strTrim = "http://" + strTrim;
                    }
                    try {
                        protocol = new URL(strTrim).getProtocol();
                    } catch (MalformedURLException e4) {
                        e = e4;
                        intent = null;
                    }
                    if (HttpHost.DEFAULT_SCHEME_NAME.equals(protocol) || BaseConstants.SCHEME_HTTPS.equals(protocol)) {
                        intent = new Intent("android.intent.action.VIEW");
                        try {
                            intent.setData(Uri.parse(strTrim));
                            ag.a(context, str, intent);
                        } catch (MalformedURLException e5) {
                            e = e5;
                            com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                        }
                        launchIntentForPackage = intent;
                    }
                }
            }
            launchIntentForPackage = null;
        }
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(268435456);
            try {
                if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                    return launchIntentForPackage;
                }
                if (Build.VERSION.SDK_INT >= 30 && !com.xiaomi.push.j.m651a(context) && an.c.equals(str6)) {
                    return launchIntentForPackage;
                }
                com.xiaomi.channel.commonutils.logger.b.m74a("not resolve activity:" + launchIntentForPackage + "for buttons");
            } catch (Exception e6) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e6.getMessage());
            }
        }
        return null;
    }

    @TargetApi(16)
    private static dv a(Context context, hb hbVar, byte[] bArr, String str, int i) {
        PendingIntent pendingIntentA;
        String strA = a(hbVar);
        Map<String, String> mapM520a = hbVar.m553a().m520a();
        String str2 = mapM520a.get("notification_style_type");
        dv dvVarA = (!com.xiaomi.push.j.m651a(context) || f1025a == null) ? null : f1025a.a(context, i, strA, mapM520a);
        if (dvVarA != null) {
            dvVarA.a(mapM520a);
            return dvVarA;
        }
        if ("2".equals(str2)) {
            dv dvVar = new dv(context);
            Bitmap bitmapA = TextUtils.isEmpty(mapM520a.get("notification_bigPic_uri")) ? null : a(context, mapM520a.get("notification_bigPic_uri"), false);
            if (bitmapA == null) {
                com.xiaomi.channel.commonutils.logger.b.m74a("can not get big picture.");
                return dvVar;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(dvVar);
            bigPictureStyle.bigPicture(bitmapA);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            dvVar.setStyle(bigPictureStyle);
            return dvVar;
        }
        if ("1".equals(str2)) {
            dv dvVar2 = new dv(context);
            dvVar2.setStyle(new Notification.BigTextStyle().bigText(str));
            return dvVar2;
        }
        if ("4".equals(str2) && com.xiaomi.push.j.m650a()) {
            du duVar = new du(context, strA);
            if (!TextUtils.isEmpty(mapM520a.get("notification_banner_image_uri"))) {
                duVar.setLargeIcon(a(context, mapM520a.get("notification_banner_image_uri"), false));
            }
            if (!TextUtils.isEmpty(mapM520a.get("notification_banner_icon_uri"))) {
                duVar.b(a(context, mapM520a.get("notification_banner_icon_uri"), false));
            }
            duVar.a(mapM520a);
            return duVar;
        }
        if ("3".equals(str2) && com.xiaomi.push.j.m650a()) {
            dw dwVar = new dw(context, i, strA);
            if (!TextUtils.isEmpty(mapM520a.get("notification_colorful_button_text")) && (pendingIntentA = a(context, strA, hbVar, bArr, i, 4)) != null) {
                dwVar.a(mapM520a.get("notification_colorful_button_text"), pendingIntentA).mo386a(mapM520a.get("notification_colorful_button_bg_color"));
            }
            if (!TextUtils.isEmpty(mapM520a.get("notification_colorful_bg_color"))) {
                dwVar.b(mapM520a.get("notification_colorful_bg_color"));
            } else if (!TextUtils.isEmpty(mapM520a.get("notification_colorful_bg_image_uri"))) {
                dwVar.setLargeIcon(a(context, mapM520a.get("notification_colorful_bg_image_uri"), false));
            }
            dwVar.a(mapM520a);
            return dwVar;
        }
        return new dv(context);
    }

    private static int a(Map<String, String> map) {
        String str = map == null ? null : map.get(WkAdConfigModel.TAG_TIMEOUT);
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    private static RemoteViews a(Context context, hb hbVar, byte[] bArr) {
        gs gsVarM553a = hbVar.m553a();
        String strA = a(hbVar);
        if (gsVarM553a != null && gsVarM553a.m520a() != null) {
            Map<String, String> mapM520a = gsVarM553a.m520a();
            String str = mapM520a.get("layout_name");
            String str2 = mapM520a.get("layout_value");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(strA);
                    int identifier = resourcesForApplication.getIdentifier(str, "layout", strA);
                    if (identifier == 0) {
                        return null;
                    }
                    RemoteViews remoteViews = new RemoteViews(strA, identifier);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.has("text")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                            Iterator<String> itKeys = jSONObject2.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                String string = jSONObject2.getString(next);
                                int identifier2 = resourcesForApplication.getIdentifier(next, "id", strA);
                                if (identifier2 > 0) {
                                    remoteViews.setTextViewText(identifier2, string);
                                }
                            }
                        }
                        if (jSONObject.has("image")) {
                            JSONObject jSONObject3 = jSONObject.getJSONObject("image");
                            Iterator<String> itKeys2 = jSONObject3.keys();
                            while (itKeys2.hasNext()) {
                                String next2 = itKeys2.next();
                                String string2 = jSONObject3.getString(next2);
                                int identifier3 = resourcesForApplication.getIdentifier(next2, "id", strA);
                                int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", strA);
                                if (identifier3 > 0) {
                                    remoteViews.setImageViewResource(identifier3, identifier4);
                                }
                            }
                        }
                        if (jSONObject.has("time")) {
                            JSONObject jSONObject4 = jSONObject.getJSONObject("time");
                            Iterator<String> itKeys3 = jSONObject4.keys();
                            while (itKeys3.hasNext()) {
                                String next3 = itKeys3.next();
                                String string3 = jSONObject4.getString(next3);
                                if (string3.length() == 0) {
                                    string3 = "yy-MM-dd hh:mm";
                                }
                                int identifier5 = resourcesForApplication.getIdentifier(next3, "id", strA);
                                if (identifier5 > 0) {
                                    remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                                }
                            }
                        }
                        return remoteViews;
                    } catch (JSONException e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        return null;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
        }
        return null;
    }

    private static Bitmap a(Context context, int i) {
        return a(context.getResources().getDrawable(i));
    }

    private static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight > 0 ? intrinsicHeight : 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private static Notification a(Notification notification) {
        Object objA = com.xiaomi.push.aw.a(notification, "extraNotification");
        if (objA != null) {
            com.xiaomi.push.aw.a(objA, "setCustomizedIcon", Boolean.TRUE);
        }
        return notification;
    }

    public static String a(hb hbVar) {
        gs gsVarM553a;
        if ("com.xiaomi.xmsf".equals(hbVar.f662b) && (gsVarM553a = hbVar.m553a()) != null && gsVarM553a.m520a() != null) {
            String str = gsVarM553a.m520a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return hbVar.f662b;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m778a(Context context, String str) {
        a(context, str, -1);
    }

    public static void a(Context context, String str, int i) {
        a(context, str, i, -1);
    }

    public static void a(Context context, String str, int i, int i2) {
        int iHashCode;
        if (context == null || TextUtils.isEmpty(str) || i < -1) {
            return;
        }
        af afVarA = af.a(context, str);
        List<StatusBarNotification> listM711b = afVarA.m711b();
        if (com.xiaomi.push.s.a(listM711b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        if (i == -1) {
            iHashCode = 0;
            z = true;
        } else {
            iHashCode = ((str.hashCode() / 10) * 10) + i;
        }
        Iterator<StatusBarNotification> it = listM711b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            StatusBarNotification next = it.next();
            if (!TextUtils.isEmpty(String.valueOf(next.getId()))) {
                int id = next.getId();
                if (z) {
                    linkedList.add(next);
                    afVarA.a(id);
                } else if (iHashCode == id) {
                    d.a(context, next, i2);
                    linkedList.add(next);
                    afVarA.a(id);
                    break;
                }
            }
        }
        a(context, (LinkedList<? extends Object>) linkedList);
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        af afVarA = af.a(context, str);
        List<StatusBarNotification> listM711b = afVarA.m711b();
        if (com.xiaomi.push.s.a(listM711b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (StatusBarNotification statusBarNotification : listM711b) {
            Notification notification = statusBarNotification.getNotification();
            if (notification != null && !TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                int id = statusBarNotification.getId();
                String strA = ag.a(notification);
                String strB = ag.b(notification);
                if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strB) && a(strA, str2) && a(strB, str3)) {
                    linkedList.add(statusBarNotification);
                    afVarA.a(id);
                }
            }
        }
        a(context, (LinkedList<? extends Object>) linkedList);
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        az.a(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
    }

    public static int a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m782a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    private static boolean a(gs gsVar) {
        if (gsVar == null) {
            return false;
        }
        String strM519a = gsVar.m519a();
        return !TextUtils.isEmpty(strM519a) && strM519a.length() == 22 && "satuigmo".indexOf(strM519a.charAt(0)) >= 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m781a(hb hbVar) {
        gs gsVarM553a = hbVar.m553a();
        return a(gsVarM553a) && gsVarM553a.l();
    }

    private static Bitmap a(Context context, String str, boolean z) {
        Future futureSubmit = f1027a.submit(new a(str, context, z));
        try {
            try {
                try {
                    Bitmap bitmap = (Bitmap) futureSubmit.get(180L, TimeUnit.SECONDS);
                    return bitmap == null ? bitmap : bitmap;
                } catch (ExecutionException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    futureSubmit.cancel(true);
                    return null;
                }
            } catch (InterruptedException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                futureSubmit.cancel(true);
                return null;
            } catch (TimeoutException e3) {
                com.xiaomi.channel.commonutils.logger.b.a(e3);
                futureSubmit.cancel(true);
                return null;
            }
        } finally {
            futureSubmit.cancel(true);
        }
    }

    private static String a(Context context, String str, Map<String, String> map) {
        if (map != null && !TextUtils.isEmpty(map.get("channel_name"))) {
            return map.get("channel_name");
        }
        return com.xiaomi.push.g.m479b(context, str);
    }

    private static void a(Intent intent) {
        if (intent == null) {
            return;
        }
        intent.setFlags(intent.getFlags() & (-2) & (-3) & (-65) & (-129));
    }

    private static void a(Context context, String str, dv dvVar, Map<String, String> map) {
        int iA = a(context, str, "mipush_small_notification");
        int iA2 = a(context, str, "mipush_notification");
        if (com.xiaomi.push.j.m651a(context)) {
            if (iA > 0 && iA2 > 0) {
                dvVar.setSmallIcon(iA);
                dvVar.setLargeIcon(a(context, iA2));
                return;
            } else {
                b(context, str, dvVar, map);
                return;
            }
        }
        if (iA > 0) {
            dvVar.setSmallIcon(iA);
        } else {
            b(context, str, dvVar, map);
        }
        if (iA2 > 0) {
            dvVar.setLargeIcon(a(context, iA2));
        }
    }
}
