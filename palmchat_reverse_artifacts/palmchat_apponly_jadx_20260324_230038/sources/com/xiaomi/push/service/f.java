package com.xiaomi.push.service;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.push.C1401r;
import com.xiaomi.push.service.ag;
import defpackage.i04;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseArray<ag.a<String, String, String>> f11753a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final int[] f980a = {1, 2, 4, 8, 16};
    private static final SparseArray<Integer> b;

    static {
        int i = 5;
        f11753a = new SparseArray<ag.a<String, String, String>>(i) { // from class: com.xiaomi.push.service.f.1
            {
                put(1, ag.b);
                put(2, ag.c);
                put(4, ag.d);
                put(8, ag.f);
                put(16, ag.e);
            }
        };
        b = new SparseArray<Integer>(i) { // from class: com.xiaomi.push.service.f.2
            {
                put(1, 32);
                put(2, 16);
                put(4, 8);
                put(8, 4);
                put(16, 2);
            }
        };
    }

    private static boolean a(int i, int i2) {
        return i >= 4 || (i2 & 2) > 0 || (i2 & 1) > 0 || (i2 & 8) > 0 || (i2 & 16) > 0;
    }

    public static int a(String str, String str2) {
        int i = m740a(str, str2, 8) ? 8 : 0;
        if (m740a(str, str2, 16)) {
            i |= 16;
        }
        if (m740a(str, str2, 1)) {
            i |= 1;
        }
        if (m740a(str, str2, 2)) {
            i |= 2;
        }
        return m740a(str, str2, 4) ? i | 4 : i;
    }

    public static void a(Context context, String str, String str2, int i, String str3, boolean z, int i2) {
        if (com.xiaomi.push.j.m651a(context) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            int iA = com.xiaomi.push.s.a(str3, 0);
            boolean zA = a(i, iA);
            if (z) {
                a(str, str2, iA, i2);
                if (zA) {
                    synchronized (f.class) {
                        a(a(context), iA, str2);
                    }
                    return;
                }
                return;
            }
            synchronized (f.class) {
                SharedPreferences sharedPreferencesA = a(context);
                if (zA || sharedPreferencesA.contains(str2)) {
                    a(sharedPreferencesA, iA, str, str2, i2);
                    if (zA) {
                        a(sharedPreferencesA, iA, str2);
                    } else {
                        a(sharedPreferencesA, str2);
                    }
                }
            }
            return;
        }
        if (com.xiaomi.push.j.m651a(context)) {
            com.xiaomi.channel.commonutils.logger.b.m74a("ChannelPC: can`t setup permission with permissionCode:" + String.valueOf(str3) + " channelId:" + String.valueOf(str2) + " targetPkg:" + str);
        }
    }

    public static void a(Context context, String str) {
        List<NotificationChannel> listM709a;
        if (!com.xiaomi.push.j.m651a(context) || TextUtils.isEmpty(str) || (listM709a = af.a(context, str).m709a()) == null) {
            return;
        }
        synchronized (f.class) {
            SharedPreferences sharedPreferencesA = a(context);
            ArrayList arrayList = new ArrayList();
            Iterator<NotificationChannel> it = listM709a.iterator();
            while (it.hasNext()) {
                String str2 = (String) com.xiaomi.push.aw.a(i04.a(it.next()), "mId");
                if (!TextUtils.isEmpty(str2) && sharedPreferencesA.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            if (arrayList.size() > 0) {
                a(sharedPreferencesA, arrayList);
            }
        }
    }

    public static void a(String str, String str2, int i, int i2) {
        for (int i3 : f980a) {
            if ((b.get(i3).intValue() & i2) == 0) {
                a(str, str2, i3, (i & i3) > 0);
            } else {
                com.xiaomi.channel.commonutils.logger.b.m74a("ChannelPermissions.grantPermission:" + str + ":" + str2 + ": <" + i3 + "> :stoped by userLock");
            }
        }
    }

    private static void a(String str, String str2, int i, boolean z) {
        com.xiaomi.channel.commonutils.logger.b.m74a("ChannelPermissions.grantPermission:" + str + ":" + str2 + ": <" + i + ContainerUtils.KEY_VALUE_DELIMITER + z + "> :" + ag.a(C1401r.m660a(), str, str2, f11753a.get(i), z));
    }

    public static int a(String str, String str2, int i) {
        return ag.a(C1401r.m660a(), str, str2, f11753a.get(i));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Bundle m739a(String str, String str2) {
        return ag.a(C1401r.m660a(), str, str2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m740a(String str, String str2, int i) {
        boolean z = ag.a(C1401r.m660a(), str, str2, f11753a.get(i)) == 1;
        com.xiaomi.channel.commonutils.logger.b.m74a("ChannelPermissions.checkPermission:" + str + ":" + str2 + ": <" + i + ContainerUtils.KEY_VALUE_DELIMITER + z + ">");
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context, String str, NotificationChannel notificationChannel) {
        int iA;
        if (Build.VERSION.SDK_INT >= 26 && context != null && !TextUtils.isEmpty(str) && notificationChannel != null) {
            int i = (notificationChannel.getImportance() != 0 ? 1 : 2) | 0;
            if (ag.a()) {
                Bundle bundleM739a = m739a(str, notificationChannel.getId());
                ag.a<String, String, String> aVar = ag.f;
                if (bundleM739a.containsKey(aVar.c)) {
                    i |= (!bundleM739a.getBoolean(aVar.c) || notificationChannel.getImportance() < 4) ? 8 : 4;
                }
                ag.a<String, String, String> aVar2 = ag.e;
                if (bundleM739a.containsKey(aVar2.c)) {
                    i |= bundleM739a.getBoolean(aVar2.c) ? 16 : 32;
                }
            } else {
                int iA2 = a(str, notificationChannel.getId(), 8);
                if (iA2 == 1) {
                    i = notificationChannel.getImportance() >= 4 ? i | 4 : i | 8;
                    iA = a(str, notificationChannel.getId(), 16);
                    if (iA != 1) {
                        i |= 16;
                    } else if (iA == 0) {
                        i |= 32;
                    }
                } else {
                    if (iA2 == 0) {
                    }
                    iA = a(str, notificationChannel.getId(), 16);
                    if (iA != 1) {
                    }
                }
            }
            return (notificationChannel.getSound() != null ? i | 64 : i | 128) | (notificationChannel.shouldVibrate() ? 256 : 512);
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("context|packageName|channel must not be null ");
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context, String str, String str2) {
        int i;
        if (Build.VERSION.SDK_INT >= 26 && context != null && !TextUtils.isEmpty(str)) {
            af afVarA = af.a(context, str);
            if (afVarA != null) {
                NotificationChannel notificationChannelM705a = afVarA.m705a(afVarA.m708a(str2));
                if (notificationChannelM705a != null) {
                    int i2 = (notificationChannelM705a.getImportance() != 0 ? 1 : 2) | 0;
                    int iA = a(str, notificationChannelM705a.getId(), 8);
                    if (iA == 1) {
                        i2 = notificationChannelM705a.getImportance() >= 4 ? i2 | 4 : i2 | 8;
                    } else if (iA == 0) {
                    }
                    int iA2 = a(str, notificationChannelM705a.getId(), 16);
                    if (iA2 == 1) {
                        i = i2 | 16;
                    } else {
                        if (iA2 != 0) {
                            return i2;
                        }
                        i = i2 | 32;
                    }
                    return i;
                }
                com.xiaomi.channel.commonutils.logger.b.m74a("Channel must not be null");
                return 0;
            }
            com.xiaomi.channel.commonutils.logger.b.m74a("create NMHelper error");
            return 0;
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("Must greater than or equal android O and context|packageName not be null");
        return 0;
    }

    private static void a(SharedPreferences sharedPreferences, int i, String str, String str2, int i2) {
        if (sharedPreferences.getInt(str2, 0) != i) {
            a(str, str2, i, i2);
        }
    }

    private static void a(SharedPreferences sharedPreferences, int i, String str) {
        sharedPreferences.edit().putInt(str, i).commit();
    }

    private static void a(SharedPreferences sharedPreferences, String str) {
        a(sharedPreferences, new ArrayList<String>(str) { // from class: com.xiaomi.push.service.f.3

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f11754a;

            {
                this.f11754a = str;
                add(str);
            }
        });
    }

    private static void a(SharedPreferences sharedPreferences, List<String> list) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            editorEdit.remove(it.next());
        }
        editorEdit.commit();
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("ch_permission_cache_file", 0);
    }
}
