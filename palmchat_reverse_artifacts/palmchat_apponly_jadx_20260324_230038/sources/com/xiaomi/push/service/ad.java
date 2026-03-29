package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import com.xiaomi.push.gk;
import defpackage.l24;
import defpackage.m24;
import defpackage.sz3;
import defpackage.tz3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
@TargetApi(24)
class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ad f11704a = new ad();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SpannableString f909a;

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        List<b> f910a;
        List<b> b;

        private a() {
            this.f910a = new ArrayList();
            this.b = new ArrayList();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11706a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        Notification f911a;

        public b(int i, Notification notification) {
            this.f11706a = i;
            this.f911a = notification;
        }

        public String toString() {
            return "id:" + this.f11706a;
        }
    }

    private ad() {
    }

    public static ad a() {
        return f11704a;
    }

    private boolean b(Context context) {
        return ah.a(context).a(gk.NotificationAutoGroupSwitch.a(), true);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m697a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    private boolean a(Context context) {
        if (b(context) && af.m703a(context)) {
            return ah.a(context).a(gk.LatestNotificationNotIntoGroupSwitch.a(), false);
        }
        return false;
    }

    private String b(Notification notification) {
        if (notification == null) {
            return null;
        }
        return m699b(notification) ? a(notification) : notification.getGroup();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private boolean m699b(Notification notification) {
        Bundle bundle;
        if (notification == null || notification.getGroup() == null || (bundle = notification.extras) == null) {
            return false;
        }
        return notification.getGroup().equals(String.format("pushmask_%s_%s", Long.valueOf(bundle.getLong("push_src_group_time")), a(notification)));
    }

    private String a(Notification notification) {
        Bundle bundle;
        if (notification == null || (bundle = notification.extras) == null) {
            return null;
        }
        return bundle.getString("push_src_group_name");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m698a(Notification notification) {
        if (notification == null) {
            return false;
        }
        Object objA = com.xiaomi.push.aw.a((Object) notification, "isGroupSummary", (Object[]) null);
        if (objA instanceof Boolean) {
            return ((Boolean) objA).booleanValue();
        }
        return false;
    }

    private void b(Context context, int i, Notification notification) {
        String strC = ag.c(notification);
        if (TextUtils.isEmpty(strC)) {
            com.xiaomi.channel.commonutils.logger.b.m74a("group restore not extract pkg from notification:" + i);
            return;
        }
        af afVarA = af.a(context, strC);
        List<StatusBarNotification> listA = a(afVarA);
        if (listA == null) {
            com.xiaomi.channel.commonutils.logger.b.m74a("group restore not get notifications");
            return;
        }
        for (StatusBarNotification statusBarNotification : listA) {
            Notification notification2 = statusBarNotification.getNotification();
            if (notification2 != null && m699b(notification2) && statusBarNotification.getId() != i) {
                Notification.Builder builderRecoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                builderRecoverBuilder.setGroup(a(notification2));
                ag.a(builderRecoverBuilder, m698a(notification2));
                afVarA.a(statusBarNotification.getId(), builderRecoverBuilder.build());
                com.xiaomi.channel.commonutils.logger.b.b("group restore notification:" + statusBarNotification.getId());
            }
        }
    }

    public String a(Context context, Notification.Builder builder, String str) {
        if (!m697a() || !a(context)) {
            return str;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Bundle extras = builder.getExtras();
        extras.putString("push_src_group_name", str);
        extras.putLong("push_src_group_time", jCurrentTimeMillis);
        return String.format("pushmask_%s_%s", Long.valueOf(jCurrentTimeMillis), str);
    }

    public void a(Context context, int i, Notification notification) {
        if (m697a()) {
            if (a(context)) {
                try {
                    b(context, i, notification);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("group notify handle restore error " + e);
                }
            }
            if (b(context)) {
                try {
                    a(context, i, notification, true);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("group notify handle auto error " + e2);
                }
            }
        }
    }

    private void a(Context context, int i, Notification notification, boolean z) {
        Notification notification2;
        String strC = ag.c(notification);
        if (TextUtils.isEmpty(strC)) {
            com.xiaomi.channel.commonutils.logger.b.m74a("group auto not extract pkg from notification:" + i);
            return;
        }
        List<StatusBarNotification> listA = a(af.a(context, strC));
        if (listA == null) {
            com.xiaomi.channel.commonutils.logger.b.m74a("group auto not get notifications");
            return;
        }
        String strB = b(notification);
        HashMap map = new HashMap();
        for (StatusBarNotification statusBarNotification : listA) {
            if (statusBarNotification.getNotification() != null && statusBarNotification.getId() != i) {
                a(map, statusBarNotification);
            }
        }
        for (Map.Entry<String, a> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                a value = entry.getValue();
                if (z && key.equals(strB) && !m699b(notification)) {
                    b bVar = new b(i, notification);
                    if (m698a(notification)) {
                        value.b.add(bVar);
                    } else {
                        value.f910a.add(bVar);
                    }
                }
                int size = value.f910a.size();
                if (value.b.size() <= 0) {
                    if (z && size >= 2) {
                        a(context, strC, key, value.f910a.get(0).f911a);
                    }
                } else if (size <= 0) {
                    a(context, strC, key);
                } else if (ah.a(context).a(gk.NotificationGroupUpdateTimeSwitch.a(), false) && (notification2 = value.b.get(0).f911a) != null) {
                    notification2.when = System.currentTimeMillis();
                    a(context, strC, key, notification2);
                }
            }
        }
    }

    private void a(Map<String, a> map, StatusBarNotification statusBarNotification) {
        String strB = b(statusBarNotification.getNotification());
        a aVar = map.get(strB);
        if (aVar == null) {
            aVar = new a();
            map.put(strB, aVar);
        }
        b bVar = new b(statusBarNotification.getId(), statusBarNotification.getNotification());
        if (m698a(statusBarNotification.getNotification())) {
            aVar.b.add(bVar);
        } else {
            aVar.f910a.add(bVar);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private SpannableString m696a(Context context, String str) {
        Resources resources;
        DisplayMetrics displayMetrics;
        int iMax;
        if (this.f909a == null) {
            int i = (context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null || (iMax = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels)) <= 0) ? 200 : iMax / 16;
            if (TextUtils.isEmpty(str)) {
                str = "新消息";
            }
            StringBuilder sb = new StringBuilder(str.length() + i + 12);
            sb.append(str);
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(' ');
            }
            sb.append("GroupSummary");
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(0), str.length(), sb.length(), 33);
            this.f909a = spannableString;
        }
        return this.f909a;
    }

    private void a(Context context, String str, String str2, Notification notification) {
        Notification.Builder defaults;
        try {
            if (TextUtils.isEmpty(str2)) {
                com.xiaomi.channel.commonutils.logger.b.m74a("group show summary group is null");
                return;
            }
            int iA = ag.a(context, str);
            if (iA == 0) {
                com.xiaomi.channel.commonutils.logger.b.m74a("group show summary not get icon from " + str);
                return;
            }
            af afVarA = af.a(context, str);
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                String strC = afVarA.c(notification.getChannelId(), "groupSummary");
                NotificationChannel notificationChannelM705a = afVarA.m705a(strC);
                if ("groupSummary".equals(strC) && notificationChannelM705a == null) {
                    tz3.a();
                    afVarA.a(sz3.a(strC, "group_summary", 3));
                }
                m24.a();
                defaults = l24.a(context, strC);
            } else {
                defaults = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            ag.a(defaults, true);
            Notification notificationBuild = defaults.setContentTitle(m696a(context, "新消息")).setContentText("你有一条新消息").setSmallIcon(Icon.createWithResource(str, iA)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (i >= 31) {
                notificationBuild.contentIntent = a(context, str);
            }
            if (!com.xiaomi.push.j.m655c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                ag.m712a(notificationBuild, str);
            }
            int iA2 = a(str, str2);
            afVarA.a(iA2, notificationBuild);
            com.xiaomi.channel.commonutils.logger.b.b("group show summary notify:" + iA2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m74a("group show summary error " + e);
        }
    }

    private PendingIntent a(Context context, String str) {
        PendingIntent activity;
        if (context == null && TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m74a("ctx or pkg must not be null in getting launch intent");
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                com.xiaomi.channel.commonutils.logger.b.m74a("pm must not be null in getting launch intent");
                return null;
            }
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                com.xiaomi.channel.commonutils.logger.b.m74a("targetIntent must not be null in getting launch intent");
                return null;
            }
            launchIntentForPackage.addFlags(268435456);
            if (Build.VERSION.SDK_INT >= 31) {
                activity = PendingIntent.getActivity(context, 0, launchIntentForPackage, 33554432);
            } else {
                activity = PendingIntent.getActivity(context, 0, launchIntentForPackage, 0);
            }
            return activity;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d("error occurred during getting launch pendingIntent. exception:" + th);
            return null;
        }
    }

    private void a(Context context, String str, String str2) {
        com.xiaomi.channel.commonutils.logger.b.b("group cancel summary:" + str2);
        af.a(context, str).a(a(str, str2));
    }

    private int a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    private List<StatusBarNotification> a(af afVar) {
        List<StatusBarNotification> listM711b = afVar != null ? afVar.m711b() : null;
        if (listM711b == null || listM711b.size() == 0) {
            return null;
        }
        return listM711b;
    }
}
