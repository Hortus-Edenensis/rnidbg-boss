package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.push.gs;
import defpackage.sz3;
import defpackage.tz3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f11703a = Log.isLoggable("NCHelper", 3);

    @TargetApi(26)
    private static void a(af afVar, NotificationChannel notificationChannel, String str) {
        int i;
        char c;
        int iA;
        Context contextM706a = afVar.m706a();
        String id = notificationChannel.getId();
        String strA = af.a(id, afVar.m707a());
        boolean z = f11703a;
        if (z) {
            a("appChannelId:" + id + " oldChannelId:" + strA);
        }
        if (!com.xiaomi.push.j.m651a(contextM706a) || TextUtils.equals(id, strA)) {
            NotificationChannel notificationChannelM705a = afVar.m705a(id);
            if (z) {
                a("elseLogic getNotificationChannel:" + notificationChannelM705a);
            }
            if (notificationChannelM705a == null) {
                afVar.a(notificationChannel);
            }
            i = 0;
            c = 0;
        } else {
            NotificationManager notificationManager = (NotificationManager) contextM706a.getSystemService("notification");
            NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(strA);
            NotificationChannel notificationChannelM705a2 = afVar.m705a(id);
            if (z) {
                a("xmsfChannel:" + notificationChannel2);
                a("appChannel:" + notificationChannelM705a2);
            }
            if (notificationChannel2 != null) {
                NotificationChannel notificationChannelA = a(id, notificationChannel2);
                if (z) {
                    a("copyXmsf copyXmsfChannel:" + notificationChannelA);
                }
                if (notificationChannelM705a2 != null) {
                    iA = a(notificationChannelM705a2);
                    afVar.a(notificationChannelA, iA == 0);
                    c = 3;
                } else {
                    iA = a(notificationChannel2);
                    a(contextM706a, afVar, notificationChannelA, iA, notificationChannel2.getId());
                    c = 4;
                }
                b(contextM706a, id);
                notificationManager.deleteNotificationChannel(strA);
            } else if (notificationChannelM705a2 == null) {
                if (z) {
                    a("appHack createNotificationChannel:" + notificationChannel);
                }
                afVar.a(notificationChannel);
                iA = 0;
                c = 1;
            } else if (m695a(contextM706a, id) || !a(notificationChannel, notificationChannelM705a2)) {
                iA = 0;
                c = 0;
            } else {
                if (z) {
                    a("appHack updateNotificationChannel:" + notificationChannel);
                }
                iA = a(notificationChannelM705a2);
                afVar.a(notificationChannel, iA == 0);
                c = 2;
            }
            i = iA;
        }
        f.a(afVar.m706a(), afVar.m707a(), id, notificationChannel.getImportance(), str, c == 1 || c == 4 || c == 3, i);
    }

    private static void b(Context context, String str) {
        if (f11703a) {
            a("recordCopiedChannel:" + str);
        }
        a(context).edit().putBoolean(str, true).apply();
    }

    private static void c(Context context, String str) {
        try {
            af afVarA = af.a(context, str);
            Set<String> setKeySet = a(context).getAll().keySet();
            ArrayList arrayList = new ArrayList();
            for (String str2 : setKeySet) {
                if (afVarA.m710a(str2)) {
                    arrayList.add(str2);
                    if (f11703a) {
                        a("delete channel copy record:" + str2);
                    }
                }
            }
            a(context, arrayList);
        } catch (Exception unused) {
        }
    }

    @TargetApi(26)
    private static boolean a(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        boolean z;
        if (notificationChannel == null || notificationChannel2 == null) {
            return false;
        }
        boolean z2 = true;
        if (TextUtils.equals(notificationChannel.getName(), notificationChannel2.getName())) {
            z = false;
        } else {
            if (f11703a) {
                a("appHack channelConfigLowerCompare:getName");
            }
            z = true;
        }
        if (!TextUtils.equals(notificationChannel.getDescription(), notificationChannel2.getDescription())) {
            if (f11703a) {
                a("appHack channelConfigLowerCompare:getDescription");
            }
            z = true;
        }
        if (notificationChannel.getImportance() != notificationChannel2.getImportance()) {
            notificationChannel.setImportance(Math.min(notificationChannel.getImportance(), notificationChannel2.getImportance()));
            if (f11703a) {
                a("appHack channelConfigLowerCompare:getImportance  " + notificationChannel.getImportance() + " " + notificationChannel2.getImportance());
            }
            z = true;
        }
        if (notificationChannel.shouldVibrate() != notificationChannel2.shouldVibrate()) {
            notificationChannel.enableVibration(false);
            if (f11703a) {
                a("appHack channelConfigLowerCompare:enableVibration");
            }
            z = true;
        }
        if (notificationChannel.shouldShowLights() != notificationChannel2.shouldShowLights()) {
            notificationChannel.enableLights(false);
            if (f11703a) {
                a("appHack channelConfigLowerCompare:enableLights");
            }
            z = true;
        }
        if ((notificationChannel.getSound() != null) != (notificationChannel2.getSound() != null)) {
            notificationChannel.setSound(null, null);
            if (f11703a) {
                a("appHack channelConfigLowerCompare:setSound");
            }
        } else {
            z2 = z;
        }
        if (f11703a) {
            a("appHack channelConfigLowerCompare:isDifferent:" + z2);
        }
        return z2;
    }

    private static int a(NotificationChannel notificationChannel) {
        int iIntValue = 0;
        try {
            iIntValue = ((Integer) com.xiaomi.push.aw.b((Object) notificationChannel, "getUserLockedFields", new Object[0])).intValue();
            if (f11703a) {
                a("isUserLockedChannel:" + iIntValue + " " + notificationChannel);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m75a("NCHelper", "is user locked error" + e);
        }
        return iIntValue;
    }

    @TargetApi(26)
    private static NotificationChannel a(String str, NotificationChannel notificationChannel) {
        tz3.a();
        NotificationChannel notificationChannelA = sz3.a(str, notificationChannel.getName(), notificationChannel.getImportance());
        notificationChannelA.setDescription(notificationChannel.getDescription());
        notificationChannelA.enableVibration(notificationChannel.shouldVibrate());
        notificationChannelA.enableLights(notificationChannel.shouldShowLights());
        notificationChannelA.setSound(notificationChannel.getSound(), notificationChannel.getAudioAttributes());
        notificationChannelA.setLockscreenVisibility(notificationChannel.getLockscreenVisibility());
        return notificationChannelA;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m695a(Context context, String str) {
        if (f11703a) {
            a("checkCopeidChannel:newFullChannelId:" + str + "  " + a(context).getBoolean(str, false));
        }
        return a(context).getBoolean(str, false);
    }

    private static void a(Context context, List<String> list) {
        if (f11703a) {
            a("deleteCopiedChannelRecord:" + list);
        }
        if (list.isEmpty()) {
            return;
        }
        SharedPreferences.Editor editorEdit = a(context).edit();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            editorEdit.remove(it.next());
        }
        editorEdit.apply();
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush_channel_copy_sp", 0);
    }

    @TargetApi(26)
    public static String a(af afVar, String str, CharSequence charSequence, String str2, int i, int i2, String str3, String str4) {
        String strM708a = afVar.m708a(str);
        boolean z = f11703a;
        if (z) {
            a("createChannel: appChannelId:" + strM708a + " serverChannelId:" + str + " serverChannelName:" + ((Object) charSequence) + " serverChannelDesc:" + str2 + " serverChannelNotifyType:" + i + " serverChannelName:" + ((Object) charSequence) + " serverChannelImportance:" + i2 + " channelSoundStr:" + str3 + " channelPermissions:" + str4);
        }
        NotificationChannel notificationChannelA = sz3.a(strM708a, charSequence, i2);
        notificationChannelA.setDescription(str2);
        notificationChannelA.enableVibration((i & 2) != 0);
        notificationChannelA.enableLights((i & 4) != 0);
        if ((i & 1) == 0) {
            notificationChannelA.setSound(null, null);
        } else if (!TextUtils.isEmpty(str3)) {
            if (str3.startsWith("android.resource://" + afVar.m707a())) {
                notificationChannelA.setSound(Uri.parse(str3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        }
        if (z) {
            a("create channel:" + notificationChannelA);
        }
        a(afVar, notificationChannelA, str4);
        return strM708a;
    }

    private static void a(String str) {
        com.xiaomi.channel.commonutils.logger.b.m75a("NCHelper", str);
    }

    public static void a(Context context, String str) {
        if (!com.xiaomi.push.j.m651a(context) || TextUtils.isEmpty(str)) {
            return;
        }
        c(context, str);
        f.a(context, str);
    }

    public static void a(gs gsVar) {
        Map<String, String> map;
        if (gsVar == null || (map = gsVar.f570a) == null || !map.containsKey("REMOVE_CHANNEL_MARK")) {
            return;
        }
        gsVar.f566a = 0;
        gsVar.f570a.remove("channel_id");
        gsVar.f570a.remove("channel_importance");
        gsVar.f570a.remove("channel_name");
        gsVar.f570a.remove("channel_description");
        gsVar.f570a.remove("channel_perm");
        com.xiaomi.channel.commonutils.logger.b.m74a("delete channel info by:" + gsVar.f570a.get("REMOVE_CHANNEL_MARK"));
        gsVar.f570a.remove("REMOVE_CHANNEL_MARK");
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(26)
    public static void a(Context context, af afVar, NotificationChannel notificationChannel, int i, String str) {
        if (i > 0) {
            int iA = com.xiaomi.push.g.a(context) >= 2 ? f.a(context.getPackageName(), str) : 0;
            NotificationChannel notificationChannelA = a(notificationChannel.getId(), notificationChannel);
            if ((i & 32) != 0) {
                if (notificationChannel.getSound() != null) {
                    notificationChannelA.setSound(null, null);
                } else {
                    notificationChannelA.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
            }
            if ((i & 16) != 0) {
                if (notificationChannel.shouldVibrate()) {
                    notificationChannelA.enableVibration(false);
                } else {
                    notificationChannelA.enableVibration(true);
                }
            }
            if ((i & 8) != 0) {
                if (notificationChannel.shouldShowLights()) {
                    notificationChannelA.enableLights(false);
                } else {
                    notificationChannelA.enableLights(true);
                }
            }
            if ((i & 4) != 0) {
                int importance = notificationChannel.getImportance() - 1;
                if (importance <= 0) {
                    importance = 2;
                }
                notificationChannelA.setImportance(importance);
            }
            if ((i & 2) != 0) {
                notificationChannelA.setLockscreenVisibility(notificationChannel.getLockscreenVisibility() - 1);
            }
            afVar.a(notificationChannelA);
            afVar.a(notificationChannel, true);
            f.a(afVar.m707a(), notificationChannel.getId(), iA, 0);
            return;
        }
        afVar.a(notificationChannel);
    }
}
