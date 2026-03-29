package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import com.xiaomi.push.gk;
import defpackage.i04;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f11710a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Object f916a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static WeakHashMap<Integer, af> f917a = new WeakHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f918a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f919a;
    private String b;

    private af(String str) {
        this.f919a = str;
    }

    public static String b(String str, String str2) {
        return a(m702a() ? "mipush|%s|%s" : "mipush_%s_%s", str, str2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Context m706a() {
        return f11710a;
    }

    public String c(String str, String str2) {
        return m702a() ? str : str2;
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f919a + "}";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m707a() {
        return this.f919a;
    }

    public static af a(Context context, String str) {
        a(context);
        int iHashCode = str.hashCode();
        af afVar = f917a.get(Integer.valueOf(iHashCode));
        if (afVar != null) {
            return afVar;
        }
        af afVar2 = new af(str);
        f917a.put(Integer.valueOf(iHashCode), afVar2);
        return afVar2;
    }

    private String b(String str) {
        return b(this.f919a, str);
    }

    public String b() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = b(MapController.DEFAULT_LAYER_TAG);
        }
        return this.b;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public List<StatusBarNotification> m711b() {
        StatusBarNotification[] statusBarNotificationArrM704a;
        String str = this.f919a;
        NotificationManager notificationManagerA = a();
        ArrayList arrayList = null;
        try {
            if (m702a()) {
                int iA = com.xiaomi.push.i.a();
                if (iA != -1) {
                    return (List) a(com.xiaomi.push.aw.a(f916a, "getAppActiveNotifications", str, Integer.valueOf(iA)));
                }
                return null;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                statusBarNotificationArrM704a = notificationManagerA.getActiveNotifications();
            } else {
                statusBarNotificationArrM704a = m704a();
            }
            if (statusBarNotificationArrM704a == null || statusBarNotificationArrM704a.length <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (StatusBarNotification statusBarNotification : statusBarNotificationArrM704a) {
                    if (str.equals(ag.c(statusBarNotification.getNotification()))) {
                        arrayList2.add(statusBarNotification);
                    }
                }
                return arrayList2;
            } catch (Throwable th) {
                th = th;
                arrayList = arrayList2;
                m701a("getActiveNotifications error " + th);
                return arrayList;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m703a(Context context) {
        a(context);
        return m702a();
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strA = a("mipush|%s|%s", str2, "");
        return str.startsWith(strA) ? a("mipush_%s_%s", str2, str.replace(strA, "")) : str;
    }

    private static void a(Context context) {
        if (f11710a == null) {
            f11710a = context.getApplicationContext();
            NotificationManager notificationManagerA = a();
            Boolean bool = (Boolean) com.xiaomi.push.aw.a((Object) notificationManagerA, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            m701a("fwk is support.init:" + bool);
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            f918a = zBooleanValue;
            if (zBooleanValue) {
                f916a = com.xiaomi.push.aw.a((Object) notificationManagerA, "getService", new Object[0]);
            }
        }
    }

    private static NotificationManager a() {
        return (NotificationManager) f11710a.getSystemService("notification");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m702a() {
        if (com.xiaomi.push.j.m650a() && ah.a(f11710a).a(gk.NotificationBelongToAppSwitch.a(), true)) {
            return f918a;
        }
        return false;
    }

    private static int a(String str) {
        if (Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        try {
            return f11710a.getPackageManager().getPackageUid(str, 0);
        } catch (Exception unused) {
            return -1;
        }
    }

    private static Object a(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list);
    }

    private static <T> T a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (T) obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String a(String str, String str2, String str3) {
        return TextUtils.isEmpty(str) ? "" : String.format(str, str2, str3);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m710a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(b(""));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m708a(String str) {
        if (TextUtils.isEmpty(str)) {
            return b();
        }
        return com.xiaomi.push.j.m651a(m706a()) ? b(str) : str;
    }

    @TargetApi(26)
    public void a(NotificationChannel notificationChannel) {
        String str = this.f919a;
        try {
            if (!m702a()) {
                a().createNotificationChannel(notificationChannel);
            } else {
                int iA = a(str);
                if (iA != -1) {
                    com.xiaomi.push.aw.b(f916a, "createNotificationChannelsForPackage", str, Integer.valueOf(iA), a(Arrays.asList(notificationChannel)));
                }
            }
        } catch (Exception e) {
            m701a("createNotificationChannel error" + e);
        }
    }

    @TargetApi(26)
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public NotificationChannel m705a(String str) {
        NotificationChannel notificationChannel = null;
        try {
            if (!m702a()) {
                notificationChannel = a().getNotificationChannel(str);
            } else {
                List<NotificationChannel> listM709a = m709a();
                if (listM709a != null) {
                    Iterator<NotificationChannel> it = listM709a.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            NotificationChannel notificationChannelA = i04.a(it.next());
                            if (str.equals(notificationChannelA.getId())) {
                                notificationChannel = notificationChannelA;
                                break;
                            }
                        }
                    }
                }
            }
            break;
        } catch (Exception e) {
            m701a("getNotificationChannel error" + e);
        }
        return notificationChannel;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @TargetApi(26)
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public List<NotificationChannel> m709a() {
        String str;
        String str2 = this.f919a;
        List<NotificationChannel> notificationChannels = null;
        try {
            if (!m702a()) {
                notificationChannels = a().getNotificationChannels();
                str = "mipush_%s_%s";
            } else {
                int iA = a(str2);
                if (iA != -1) {
                    Object obj = f916a;
                    Object[] objArr = {str2, Integer.valueOf(iA), Boolean.FALSE};
                    str = "mipush|%s|%s";
                    notificationChannels = (List) a(com.xiaomi.push.aw.a(obj, "getNotificationChannelsForPackage", objArr));
                } else {
                    str = null;
                }
            }
            if (!com.xiaomi.push.j.m650a() || notificationChannels == null) {
                return notificationChannels;
            }
            ArrayList arrayList = new ArrayList();
            String strA = a(str, str2, "");
            Iterator<NotificationChannel> it = notificationChannels.iterator();
            while (it.hasNext()) {
                NotificationChannel notificationChannelA = i04.a(it.next());
                if (notificationChannelA.getId().startsWith(strA)) {
                    arrayList.add(notificationChannelA);
                }
            }
            return arrayList;
        } catch (Exception e) {
            m701a("getNotificationChannels error " + e);
            return notificationChannels;
        }
    }

    public void a(NotificationChannel notificationChannel, boolean z) {
        String str = this.f919a;
        try {
            if (z) {
                int iA = a(str);
                if (iA != -1) {
                    com.xiaomi.push.aw.b(f916a, "updateNotificationChannelForPackage", str, Integer.valueOf(iA), notificationChannel);
                }
            } else {
                a(notificationChannel);
            }
        } catch (Exception e) {
            m701a("updateNotificationChannel error " + e);
        }
    }

    public void a(int i, Notification notification) {
        String str = this.f919a;
        NotificationManager notificationManagerA = a();
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (m702a()) {
                notification.extras.putString("xmsf_target_package", str);
                if (i2 >= 29) {
                    notificationManagerA.notifyAsPackage(str, null, i, notification);
                } else {
                    notificationManagerA.notify(i, notification);
                }
            } else {
                notificationManagerA.notify(i, notification);
            }
        } catch (Exception unused) {
        }
    }

    public void a(int i) {
        String str = this.f919a;
        try {
            if (m702a()) {
                int iA = com.xiaomi.push.i.a();
                String packageName = m706a().getPackageName();
                if (Build.VERSION.SDK_INT >= 30) {
                    com.xiaomi.push.aw.b(f916a, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i), Integer.valueOf(iA));
                } else {
                    com.xiaomi.push.aw.b(f916a, "cancelNotificationWithTag", str, null, Integer.valueOf(i), Integer.valueOf(iA));
                }
                m701a("cancel succ:" + i);
                return;
            }
            a().cancel(i);
        } catch (Exception e) {
            m701a("cancel error" + e);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private StatusBarNotification[] m704a() {
        if (!com.xiaomi.push.j.m651a(m706a())) {
            return null;
        }
        try {
            Object objA = com.xiaomi.push.aw.a(f916a, "getActiveNotifications", m706a().getPackageName());
            if (objA instanceof StatusBarNotification[]) {
                return (StatusBarNotification[]) objA;
            }
            return null;
        } catch (Throwable th) {
            m701a("getAllNotifications error " + th);
            return null;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m701a(String str) {
        com.xiaomi.channel.commonutils.logger.b.m74a("NMHelper:" + str);
    }
}
