package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.bb;
import com.xiaomi.push.ed;
import com.xiaomi.push.g;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.gs;
import com.xiaomi.push.gt;
import com.xiaomi.push.gv;
import com.xiaomi.push.he;
import com.xiaomi.push.hf;
import com.xiaomi.push.hg;
import com.xiaomi.push.hl;
import com.xiaomi.push.hm;
import com.xiaomi.push.hp;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.au;
import com.xiaomi.push.service.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class MiPushClient4Hybrid {
    private static MiPushCallback sCallback;
    private static Map<String, b.a> dataMap = new HashMap();
    private static Map<String, Long> sRegisterTimeMap = new HashMap();

    private static void addPullNotificationTime(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_pull_notification_" + str, System.currentTimeMillis()).commit();
    }

    private static short getDeviceStatus(MiPushMessage miPushMessage, boolean z) {
        String str = miPushMessage.getExtra() == null ? "" : miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
        int iIntValue = !TextUtils.isEmpty(str) ? Integer.valueOf(str).intValue() : 0;
        if (!z) {
            iIntValue = (iIntValue & (-4)) + g.b.NOT_ALLOWED.a();
        }
        return (short) iIntValue;
    }

    public static boolean isRegistered(Context context, String str) {
        return b.m99a(context).a(str) != null;
    }

    public static void onReceiveRegisterResult(Context context, hg hgVar) {
        ArrayList arrayList;
        b.a aVar;
        String strC = hgVar.c();
        if (hgVar.a() == 0 && (aVar = dataMap.get(strC)) != null) {
            aVar.a(hgVar.f730e, hgVar.f731f);
            b.m99a(context).a(strC, aVar);
        }
        if (TextUtils.isEmpty(hgVar.f730e)) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            arrayList.add(hgVar.f730e);
        }
        MiPushCommandMessage miPushCommandMessageGenerateCommandMessage = PushMessageHelper.generateCommandMessage(ed.COMMAND_REGISTER.f362a, arrayList, hgVar.f718a, hgVar.f729d, null, null);
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveRegisterResult(strC, miPushCommandMessageGenerateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(Context context, hm hmVar) {
        MiPushCommandMessage miPushCommandMessageGenerateCommandMessage = PushMessageHelper.generateCommandMessage(ed.COMMAND_UNREGISTER.f362a, null, hmVar.f796a, hmVar.f804d, null, null);
        String strA = hmVar.a();
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveUnregisterResult(strA, miPushCommandMessageGenerateCommandMessage);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        if (b.m99a(context).m104a(str2, str3, str)) {
            ArrayList arrayList = new ArrayList();
            b.a aVarA = b.m99a(context).a(str);
            if (aVarA != null) {
                arrayList.add(aVarA.c);
                MiPushCommandMessage miPushCommandMessageGenerateCommandMessage = PushMessageHelper.generateCommandMessage(ed.COMMAND_REGISTER.f362a, arrayList, 0L, null, null, null);
                MiPushCallback miPushCallback = sCallback;
                if (miPushCallback != null) {
                    miPushCallback.onReceiveRegisterResult(str, miPushCommandMessageGenerateCommandMessage);
                }
            }
            if (shouldPullNotification(context, str)) {
                he heVar = new he();
                heVar.b(str2);
                heVar.c(gp.PullOfflineMessage.f535a);
                heVar.a(aj.a());
                heVar.a(false);
                u.a(context).a(heVar, gf.Notification, false, true, null, false, str, str2);
                com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid pull offline pass through message");
                addPullNotificationTime(context, str);
                return;
            }
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - (sRegisterTimeMap.get(str) != null ? sRegisterTimeMap.get(str).longValue() : 0L)) < 5000) {
            com.xiaomi.channel.commonutils.logger.b.m74a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        sRegisterTimeMap.put(str, Long.valueOf(jCurrentTimeMillis));
        String strA = bb.a(6);
        b.a aVar = new b.a(context);
        aVar.c(str2, str3, strA);
        dataMap.put(str, aVar);
        hf hfVar = new hf();
        hfVar.a(aj.a());
        hfVar.b(str2);
        hfVar.e(str3);
        hfVar.d(str);
        hfVar.f(strA);
        hfVar.c(com.xiaomi.push.g.m475a(context, context.getPackageName()));
        hfVar.b(com.xiaomi.push.g.a(context, context.getPackageName()));
        hfVar.h(BuildConfig.VERSION_NAME);
        hfVar.a(BuildConfig.VERSION_CODE);
        hfVar.a(gt.Init);
        if (!com.xiaomi.push.j.m656d()) {
            String strD = com.xiaomi.push.i.d(context);
            if (!TextUtils.isEmpty(strD)) {
                hfVar.i(bb.a(strD));
            }
        }
        int iA = com.xiaomi.push.i.a();
        if (iA >= 0) {
            hfVar.c(iA);
        }
        he heVar2 = new he();
        heVar2.c(gp.HybridRegister.f535a);
        heVar2.b(b.m99a(context).m100a());
        heVar2.d(context.getPackageName());
        heVar2.a(hp.a(hfVar));
        heVar2.a(aj.a());
        u.a(context).a(heVar2, gf.Notification, (gs) null);
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String messageId = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
        if (TextUtils.isEmpty(messageId)) {
            messageId = miPushMessage.getMessageId();
        }
        t.a(context, messageId);
    }

    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            com.xiaomi.channel.commonutils.logger.b.m74a("do not ack message, message is null");
            return;
        }
        try {
            gv gvVar = new gv();
            gvVar.b(b.m99a(context).m100a());
            gvVar.a(miPushMessage.getMessageId());
            gvVar.a(Long.valueOf(miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS)).longValue());
            gvVar.a(getDeviceStatus(miPushMessage, z));
            if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                gvVar.c(miPushMessage.getTopic());
            }
            u.a(context).a(gvVar, gf.AckMessage, false, au.a(PushMessageHelper.generateMessage(miPushMessage)));
            com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid ack mina message, messageId is " + miPushMessage.getMessageId());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        MiPushClient.reportMessageClicked(context, miPushMessage);
    }

    public static void setCallback(MiPushCallback miPushCallback) {
        sCallback = miPushCallback;
    }

    private static boolean shouldPullNotification(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder sb = new StringBuilder();
        sb.append("last_pull_notification_");
        sb.append(str);
        return Math.abs(System.currentTimeMillis() - sharedPreferences.getLong(sb.toString(), -1L)) > 300000;
    }

    public static void unregisterPush(Context context, String str) {
        sRegisterTimeMap.remove(str);
        b.a aVarA = b.m99a(context).a(str);
        if (aVarA == null) {
            return;
        }
        hl hlVar = new hl();
        hlVar.a(aj.a());
        hlVar.d(str);
        hlVar.b(aVarA.f49a);
        hlVar.c(aVarA.c);
        hlVar.e(aVarA.b);
        he heVar = new he();
        heVar.c(gp.HybridUnregister.f535a);
        heVar.b(b.m99a(context).m100a());
        heVar.d(context.getPackageName());
        heVar.a(hp.a(hlVar));
        heVar.a(aj.a());
        u.a(context).a(heVar, gf.Notification, (gs) null);
        b.m99a(context).b(str);
    }

    public static void uploadClearMessageData(Context context, LinkedList<? extends Object> linkedList) {
        x.a(context, linkedList);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class MiPushCallback {
        public void onCommandResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveRegisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveUnregisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }
    }
}
