package com.xiaomi.push.service;

import android.content.Context;
import android.util.Log;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.he;
import com.xiaomi.push.hp;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class bd implements XMPushService.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f11748a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final boolean f975a = Log.isLoggable("UNDatas", 3);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Map<Integer, Map<String, List<String>>> f974a = new HashMap();

    public bd(Context context) {
        f11748a = context;
    }

    private static void b() {
        HashMap map = new HashMap();
        map.putAll(f974a);
        if (map.size() > 0) {
            for (Integer num : map.keySet()) {
                Map map2 = (Map) map.get(num);
                if (map2 != null && map2.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : map2.keySet()) {
                        sb.append(str);
                        sb.append(":");
                        List list = (List) map2.get(str);
                        if (!com.xiaomi.push.s.a(list)) {
                            for (int i = 0; i < list.size(); i++) {
                                if (i != 0) {
                                    sb.append(",");
                                }
                                sb.append((String) list.get(i));
                            }
                        }
                        sb.append(com.huawei.openalliance.ad.constant.x.aQ);
                    }
                    he heVarA = a(null, aj.a(), gp.NotificationRemoved.f535a, null);
                    heVarA.a("removed_reason", String.valueOf(num));
                    heVarA.a("all_delete_msgId_appId", sb.toString());
                    com.xiaomi.channel.commonutils.logger.b.b("UNDatas upload all removed messages reason: " + num + " allIds: " + sb.toString());
                    a(f11748a, heVarA);
                }
                f974a.remove(num);
            }
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    /* JADX INFO: renamed from: a */
    public void mo482a() {
        Map<Integer, Map<String, List<String>>> map = f974a;
        if (map.size() > 0) {
            synchronized (map) {
                b();
            }
        }
    }

    private static void a(Context context, final he heVar) {
        if (f975a) {
            com.xiaomi.channel.commonutils.logger.b.b("UNDatas upload message notification:" + heVar);
        }
        com.xiaomi.push.ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.service.bd.1
            @Override // java.lang.Runnable
            public void run() {
                byte[] bArrA = hp.a(w.a(heVar.d(), heVar.b(), heVar, gf.Notification));
                if (bd.f11748a instanceof XMPushService) {
                    ((XMPushService) bd.f11748a).a(heVar.d(), bArrA, true);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m74a("UNDatas UploadNotificationDatas failed because not xmsf");
                }
            }
        });
    }

    private static he a(String str, String str2, String str3, String str4) {
        he heVar = new he();
        if (str3 != null) {
            heVar.c(str3);
        }
        if (str != null) {
            heVar.b(str);
        }
        if (str2 != null) {
            heVar.a(str2);
        }
        if (str4 != null) {
            heVar.d(str4);
        }
        heVar.a(false);
        return heVar;
    }
}
