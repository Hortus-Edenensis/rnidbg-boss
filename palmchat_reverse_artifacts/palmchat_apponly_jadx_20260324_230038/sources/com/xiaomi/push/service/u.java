package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.ads.ex;
import com.xiaomi.push.cs;
import com.xiaomi.push.dt;
import com.xiaomi.push.er;
import com.xiaomi.push.fi;
import com.xiaomi.push.fl;
import com.xiaomi.push.fn;
import com.xiaomi.push.fo;
import com.xiaomi.push.fz;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.gs;
import com.xiaomi.push.gv;
import com.xiaomi.push.gw;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.hg;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.hu;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class u {
    private static void b(Context context, hb hbVar, byte[] bArr) {
        if (x.m781a(hbVar)) {
            return;
        }
        String strA = x.a(hbVar);
        if (TextUtils.isEmpty(strA) || a(context, strA, bArr)) {
            return;
        }
        dt.a(context).b(strA, x.b(hbVar), hbVar.m553a().m519a(), "1");
    }

    private static boolean c(hb hbVar) {
        if (hbVar.m553a() == null || hbVar.m553a().m520a() == null) {
            return false;
        }
        return "1".equals(hbVar.m553a().m520a().get("obslete_ads_message"));
    }

    private static void d(final XMPushService xMPushService, final hb hbVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.4
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for unrecognized new miui message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo403a() {
                try {
                    hb hbVarA = u.a((Context) xMPushService, hbVar);
                    hbVarA.m553a().a("miui_message_unrecognized", "1");
                    w.a(xMPushService, hbVarA);
                } catch (fi e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    xMPushService.a(10, e);
                }
            }
        });
    }

    public void a(Context context, am.b bVar, boolean z, int i, String str) {
        p pVarM765a;
        if (z || (pVarM765a = q.m765a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        q.a(context, pVarM765a.f, pVarM765a.d, pVarM765a.e);
    }

    private static void c(final XMPushService xMPushService, final hb hbVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.3
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for obsleted message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo403a() {
                try {
                    hb hbVarA = u.a((Context) xMPushService, hbVar);
                    hbVarA.m553a().a("message_obsleted", "1");
                    w.a(xMPushService, hbVarA);
                } catch (fi e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    xMPushService.a(10, e);
                }
            }
        });
    }

    public void a(XMPushService xMPushService, fo foVar, am.b bVar) {
        if (foVar instanceof fn) {
            fn fnVar = (fn) foVar;
            fl flVarA = fnVar.a("s");
            if (flVarA != null) {
                try {
                    a(xMPushService, ar.a(ar.a(bVar.h, fnVar.j()), flVarA.c()), fz.a(foVar.mo455a()));
                    return;
                } catch (IllegalArgumentException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    return;
                }
            }
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("not a mipush message");
    }

    private static boolean b(hb hbVar) {
        Map<String, String> mapM520a = hbVar.m553a().m520a();
        return mapM520a != null && mapM520a.containsKey("notify_effect");
    }

    private static void b(final XMPushService xMPushService, final hb hbVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.2
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo403a() {
                Map<String, String> mapA;
                try {
                    if (com.xiaomi.push.j.m651a((Context) xMPushService)) {
                        try {
                            mapA = v.a((Context) xMPushService, hbVar);
                        } catch (Throwable th) {
                            com.xiaomi.channel.commonutils.logger.b.d("error creating params for ack message :" + th);
                            mapA = null;
                        }
                    } else {
                        mapA = null;
                    }
                    w.a(xMPushService, u.a(xMPushService, hbVar, mapA));
                } catch (fi e) {
                    com.xiaomi.channel.commonutils.logger.b.d("error sending ack message :" + e);
                    xMPushService.a(10, e);
                }
            }
        });
    }

    public void a(XMPushService xMPushService, er erVar, am.b bVar) {
        HashMap map;
        try {
            byte[] bArrM419a = erVar.m419a(bVar.h);
            if (e.b(erVar)) {
                map = new HashMap();
                map.put("t_im", String.valueOf(erVar.m420b()));
                map.put("t_rt", String.valueOf(erVar.m413a()));
            } else {
                map = null;
            }
            a(xMPushService, bArrM419a, erVar.c(), map);
        } catch (IllegalArgumentException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j) {
        a(xMPushService, bArr, j, (Map<String, String>) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(XMPushService xMPushService, byte[] bArr, long j, Map<String, String> map) {
        byte[] bArr2;
        String str;
        Map<String, String> mapM520a;
        Map<String, String> mapM520a2;
        byte[] bArrA;
        hb hbVarA = a(bArr);
        if (hbVarA == null) {
            return;
        }
        if (TextUtils.isEmpty(hbVarA.f662b)) {
            com.xiaomi.channel.commonutils.logger.b.m74a("receive a mipush message without package name");
            return;
        }
        gs gsVarM553a = hbVarA.m553a();
        if (gsVarM553a == null || map == null || map.isEmpty() || (mapM520a2 = gsVarM553a.m520a()) == null || mapM520a2.isEmpty()) {
            bArr2 = bArr;
        } else {
            boolean z = false;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (mapM520a2.containsKey(entry.getKey())) {
                    mapM520a2.put(entry.getKey(), entry.getValue());
                    z = true;
                }
            }
            if (z && (bArrA = hp.a(hbVarA)) != null && bArrA.length > 0) {
                bArr2 = bArrA;
            }
        }
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        Intent intentA = a(bArr2, lValueOf.longValue());
        String strA = x.a(hbVarA);
        fz.a(xMPushService, strA, j, true, true, System.currentTimeMillis());
        if (gsVarM553a != null && gsVarM553a.m519a() != null) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", hbVarA.m554a(), aj.a(gsVarM553a.m519a()), hbVarA.a()));
        }
        if (gsVarM553a != null) {
            gsVarM553a.a("mrt", Long.toString(lValueOf.longValue()));
        }
        gf gfVar = gf.SendMessage;
        String strM519a = "";
        if (gfVar == hbVarA.a() && r.a(xMPushService).m769a(hbVarA.f662b) && !x.m781a(hbVarA)) {
            if (gsVarM553a != null) {
                strM519a = gsVarM553a.m519a();
                if (x.e(hbVarA)) {
                    dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), strM519a, "1");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m74a("Drop a message for unregistered, msgid=" + strM519a);
            a(xMPushService, hbVarA, hbVarA.f662b);
            return;
        }
        if (gfVar == hbVarA.a() && r.a(xMPushService).m771c(hbVarA.f662b) && !x.m781a(hbVarA)) {
            if (gsVarM553a != null) {
                strM519a = gsVarM553a.m519a();
                if (x.e(hbVarA)) {
                    dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), strM519a, "2");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m74a("Drop a message for push closed, msgid=" + strM519a);
            a(xMPushService, hbVarA, hbVarA.f662b);
            return;
        }
        if (gfVar == hbVarA.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), hbVarA.f662b)) {
            com.xiaomi.channel.commonutils.logger.b.m74a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + hbVarA.f662b);
            a(xMPushService, hbVarA, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + hbVarA.f662b);
            if (gsVarM553a == null || !x.e(hbVarA)) {
                return;
            }
            dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM553a.m519a(), "3");
            return;
        }
        if (gfVar == hbVarA.a() && com.xiaomi.push.i.a() == 999) {
            str = strA;
            if (com.xiaomi.push.i.m642a((Context) xMPushService, str)) {
                com.xiaomi.channel.commonutils.logger.b.m74a("Receive the uninstalled dual app message");
                try {
                    w.a(xMPushService, w.a(str, hbVarA.m554a()));
                    com.xiaomi.channel.commonutils.logger.b.m74a("uninstall " + str + " msg sent");
                } catch (fi e) {
                    com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e.getMessage());
                    xMPushService.a(10, e);
                }
                x.m778a((Context) xMPushService, str);
                return;
            }
        } else {
            str = strA;
        }
        if (gsVarM553a != null && (mapM520a = gsVarM553a.m520a()) != null && mapM520a.containsKey("hide") && ex.Code.equalsIgnoreCase(mapM520a.get("hide"))) {
            b(xMPushService, hbVarA);
        } else {
            a(xMPushService, str, bArr2, intentA);
        }
    }

    public static Intent a(byte[] bArr, long j) {
        hb hbVarA = a(bArr);
        if (hbVarA == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(hbVarA.f662b);
        return intent;
    }

    public static hb a(byte[] bArr) {
        hb hbVar = new hb();
        try {
            hp.a(hbVar, bArr);
            return hbVar;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0448  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(XMPushService xMPushService, String str, byte[] bArr, Intent intent) {
        boolean z;
        hb hbVarA = a(bArr);
        gs gsVarM553a = hbVarA.m553a();
        hq hqVarA = null;
        if (bArr != null) {
            cs.a(hbVarA.b(), xMPushService.getApplicationContext(), null, hbVarA.a(), bArr.length);
        }
        if (c(hbVarA) && a(xMPushService, str)) {
            if (x.e(hbVarA)) {
                dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM553a.m519a(), "5");
            }
            c(xMPushService, hbVarA);
            return;
        }
        if (a(hbVarA) && !a(xMPushService, str) && !b(hbVarA)) {
            if (x.e(hbVarA)) {
                dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM553a.m519a(), "6");
            }
            d(xMPushService, hbVarA);
            return;
        }
        if ((x.m781a(hbVarA) && com.xiaomi.push.g.c(xMPushService, hbVarA.f662b)) || a(xMPushService, intent)) {
            boolean z2 = false;
            if (gf.Registration == hbVarA.a()) {
                String strB = hbVarA.b();
                SharedPreferences.Editor editorEdit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                editorEdit.putString(strB, hbVarA.f658a);
                editorEdit.commit();
                hg hgVarA = l.a(hbVarA);
                if (hgVarA.a() == 0 && !TextUtils.isEmpty(hgVarA.b())) {
                    l.a(xMPushService, strB, hgVarA.b());
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("read regSecret failed");
                }
                r.a(xMPushService).e(strB);
                r.a(xMPushService).f(strB);
                dt.a(xMPushService.getApplicationContext()).a(strB, "E100003", gsVarM553a.m519a(), 6003, null);
                if (!TextUtils.isEmpty(gsVarM553a.m519a())) {
                    intent.putExtra("messageId", gsVarM553a.m519a());
                    intent.putExtra("eventMessageType", 6000);
                }
            }
            if (x.c(hbVarA)) {
                dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM553a.m519a(), 1001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(gsVarM553a.m519a())) {
                    intent.putExtra("messageId", gsVarM553a.m519a());
                    intent.putExtra("eventMessageType", 1000);
                }
            }
            if (x.m785b(hbVarA)) {
                dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM553a.m519a(), 2001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(gsVarM553a.m519a())) {
                    intent.putExtra("messageId", gsVarM553a.m519a());
                    intent.putExtra("eventMessageType", 2000);
                }
            }
            if (x.m781a(hbVarA)) {
                dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM553a.m519a(), 3001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(gsVarM553a.m519a())) {
                    intent.putExtra("messageId", gsVarM553a.m519a());
                    intent.putExtra("eventMessageType", 3000);
                }
            }
            if (gsVarM553a != null && !TextUtils.isEmpty(gsVarM553a.m527c()) && !TextUtils.isEmpty(gsVarM553a.d()) && gsVarM553a.f572b != 1 && !x.m780a((Context) xMPushService, hbVarA.f662b, x.m782a(gsVarM553a.m520a()))) {
                Map<String, String> map = gsVarM553a.f570a;
                String strM519a = map != null ? map.get("jobkey") : null;
                if (TextUtils.isEmpty(strM519a)) {
                    strM519a = gsVarM553a.m519a();
                }
                if (y.a(xMPushService, hbVarA.f662b, strM519a)) {
                    dt.a(xMPushService.getApplicationContext()).c(hbVarA.b(), x.b(hbVarA), gsVarM553a.m519a(), "1:" + strM519a);
                    com.xiaomi.channel.commonutils.logger.b.m74a("drop a duplicate message, key=" + strM519a);
                } else if (com.xiaomi.push.j.m651a((Context) xMPushService) && v.m773a(hbVarA)) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("receive pull down message");
                } else {
                    a(xMPushService, hbVarA, bArr);
                }
                b(xMPushService, hbVarA);
            } else if ("com.xiaomi.xmsf".contains(hbVarA.f662b) && !hbVarA.m561b() && gsVarM553a != null && gsVarM553a.m520a() != null && gsVarM553a.m520a().containsKey("ab")) {
                b(xMPushService, hbVarA);
                com.xiaomi.channel.commonutils.logger.b.c("receive abtest message. ack it." + gsVarM553a.m519a());
            } else if (a(xMPushService, str, hbVarA, gsVarM553a)) {
                if (gsVarM553a != null && !TextUtils.isEmpty(gsVarM553a.m519a())) {
                    if (x.m785b(hbVarA)) {
                        dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM553a.m519a(), 2002, null);
                    } else if (x.m781a(hbVarA)) {
                        dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM553a.m519a(), "7");
                    } else if (x.c(hbVarA)) {
                        dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM553a.m519a(), "8");
                    } else if (x.d(hbVarA)) {
                        dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), "E100003", gsVarM553a.m519a(), 6004, null);
                    }
                }
                if (gf.Notification == hbVarA.f655a) {
                    try {
                        hqVarA = bc.a(xMPushService, hbVarA);
                    } catch (hu e) {
                        com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. " + e);
                    }
                    if (hqVarA == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized notification message. " + hbVarA.f655a);
                    } else {
                        z = true;
                        if (z || !(hqVarA instanceof he)) {
                            z2 = true;
                            if (z2) {
                                com.xiaomi.channel.commonutils.logger.b.m74a("broadcast passthrough message.");
                                xMPushService.sendBroadcast(intent, w.a(hbVarA.f662b));
                            }
                        } else {
                            he heVar = (he) hqVarA;
                            if (gp.CancelPushMessage.f535a.equals(heVar.f679d) && heVar.m569a() != null) {
                                String str2 = heVar.m569a().get(an.Q);
                                int i = -2;
                                if (!TextUtils.isEmpty(str2)) {
                                    try {
                                        i = Integer.parseInt(str2);
                                    } catch (NumberFormatException e2) {
                                        com.xiaomi.channel.commonutils.logger.b.m74a("parse notifyId from STRING to INT failed: " + e2);
                                    }
                                }
                                if (i >= -1) {
                                    com.xiaomi.channel.commonutils.logger.b.m74a("try to retract a message by notifyId=" + i);
                                    x.a(xMPushService, hbVarA.f662b, i);
                                } else {
                                    String str3 = heVar.m569a().get(an.O);
                                    String str4 = heVar.m569a().get(an.P);
                                    com.xiaomi.channel.commonutils.logger.b.m74a("try to retract a message by title&description.");
                                    x.a(xMPushService, hbVarA.f662b, str3, str4);
                                }
                                if (gsVarM553a != null && gsVarM553a.m520a() != null && com.xiaomi.push.j.m651a((Context) xMPushService) && "pulldown".equals(ag.a((Object) gsVarM553a.m520a()))) {
                                    v.a(hbVarA);
                                }
                                a(xMPushService, hbVarA, heVar);
                            } else if (gp.SettingAppNotificationPermission.f535a.equals(heVar.c())) {
                                if (com.xiaomi.push.j.m651a((Context) xMPushService)) {
                                    v.a(xMPushService, hbVarA, heVar);
                                }
                            }
                            if (z2) {
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        z2 = true;
                        if (z2) {
                        }
                    }
                }
            } else {
                dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM553a.m519a(), "9");
            }
            if (hbVarA.a() != gf.UnRegistration || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                return;
            }
            xMPushService.stopSelf();
            return;
        }
        if (!com.xiaomi.push.g.c(xMPushService, hbVarA.f662b)) {
            if (x.e(hbVarA)) {
                dt.a(xMPushService.getApplicationContext()).b(hbVarA.b(), x.b(hbVarA), gsVarM553a.m519a(), "2");
            }
            a(xMPushService, hbVarA);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m74a("receive a mipush message, we can see the app, but we can't see the receiver.");
            if (x.e(hbVarA)) {
                dt.a(xMPushService.getApplicationContext()).b(hbVarA.b(), x.b(hbVarA), gsVarM553a.m519a(), "3");
            }
        }
    }

    public static void a(Context context, hb hbVar, byte[] bArr) {
        try {
            x.c cVarM777a = x.m777a(context, hbVar, bArr);
            if (cVarM777a.f11788a > 0 && !TextUtils.isEmpty(cVarM777a.f1033a)) {
                fz.a(context, cVarM777a.f1033a, cVarM777a.f11788a, true, false, System.currentTimeMillis());
            }
            if (com.xiaomi.push.j.m651a(context) && v.a(context, hbVar, cVarM777a.f1034a)) {
                v.m772a(context, hbVar);
                com.xiaomi.channel.commonutils.logger.b.m74a("consume this broadcast by tts");
            } else {
                b(context, hbVar, bArr);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m74a("notify push msg error " + e);
            e.printStackTrace();
        }
    }

    public static boolean a(Context context, String str, byte[] bArr) {
        if (!com.xiaomi.push.g.m478a(context, str)) {
            return false;
        }
        Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
        intent.putExtra("mipush_payload", bArr);
        intent.setPackage(str);
        try {
            if (context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty()) {
                return false;
            }
            com.xiaomi.channel.commonutils.logger.b.m74a("broadcast message arrived.");
            context.sendBroadcast(intent, w.a(str));
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m74a("meet error when broadcast message arrived. " + e);
            return false;
        }
    }

    private static boolean a(XMPushService xMPushService, String str, hb hbVar, gs gsVar) {
        boolean z = true;
        if (gsVar != null && gsVar.m520a() != null && gsVar.m520a().containsKey("__check_alive") && gsVar.m520a().containsKey("__awake")) {
            he heVar = new he();
            heVar.b(hbVar.m554a());
            heVar.d(str);
            heVar.c(gp.AwakeSystemApp.f535a);
            heVar.a(gsVar.m519a());
            heVar.f674a = new HashMap();
            boolean zM478a = com.xiaomi.push.g.m478a(xMPushService.getApplicationContext(), str);
            heVar.f674a.put("app_running", Boolean.toString(zM478a));
            if (!zM478a) {
                boolean z2 = Boolean.parseBoolean(gsVar.m520a().get("__awake"));
                heVar.f674a.put("awaked", Boolean.toString(z2));
                if (!z2) {
                    z = false;
                }
            }
            try {
                w.a(xMPushService, w.a(hbVar.b(), hbVar.m554a(), heVar, gf.Notification));
            } catch (fi e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        return z;
    }

    private static void a(final XMPushService xMPushService, final hb hbVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.1
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send app absent message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo403a() {
                try {
                    w.a(xMPushService, w.a(hbVar.b(), hbVar.m554a()));
                } catch (fi e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    xMPushService.a(10, e);
                }
            }
        });
    }

    private static boolean a(hb hbVar) {
        return "com.xiaomi.xmsf".equals(hbVar.f662b) && hbVar.m553a() != null && hbVar.m553a().m520a() != null && hbVar.m553a().m520a().containsKey("miui_package_name");
    }

    private static boolean a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (listQueryBroadcastReceivers.isEmpty()) {
                if (listQueryIntentServices.isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    private static void a(final XMPushService xMPushService, final hb hbVar, final String str) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.5
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send app absent ack message for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo403a() {
                try {
                    hb hbVarA = u.a((Context) xMPushService, hbVar);
                    hbVarA.m553a().a("absent_target_package", str);
                    w.a(xMPushService, hbVarA);
                } catch (fi e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    xMPushService.a(10, e);
                }
            }
        });
    }

    private static void a(final XMPushService xMPushService, final hb hbVar, final String str, final String str2) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.6
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send wrong message ack for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo403a() {
                try {
                    hb hbVarA = u.a((Context) xMPushService, hbVar);
                    hbVarA.f656a.a("error", str);
                    hbVarA.f656a.a("reason", str2);
                    w.a(xMPushService, hbVarA);
                } catch (fi e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    xMPushService.a(10, e);
                }
            }
        });
    }

    private static void a(final XMPushService xMPushService, final hb hbVar, final he heVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.7
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for clear push message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo403a() {
                try {
                    gw gwVar = new gw();
                    gwVar.c(gp.CancelPushMessageACK.f535a);
                    gwVar.a(heVar.m568a());
                    gwVar.a(heVar.a());
                    gwVar.b(heVar.b());
                    gwVar.e(heVar.d());
                    gwVar.a(0L);
                    gwVar.d("success clear push message.");
                    w.a(xMPushService, w.b(hbVar.b(), hbVar.m554a(), gwVar, gf.Notification));
                } catch (fi e) {
                    com.xiaomi.channel.commonutils.logger.b.d("clear push message. " + e);
                    xMPushService.a(10, e);
                }
            }
        });
    }

    public static hb a(Context context, hb hbVar) {
        return a(context, hbVar, (Map<String, String>) null);
    }

    public static hb a(Context context, hb hbVar, Map<String, String> map) {
        gv gvVar = new gv();
        gvVar.b(hbVar.m554a());
        gs gsVarM553a = hbVar.m553a();
        if (gsVarM553a != null) {
            gvVar.a(gsVarM553a.m519a());
            gvVar.a(gsVarM553a.m517a());
            if (!TextUtils.isEmpty(gsVarM553a.m524b())) {
                gvVar.c(gsVarM553a.m524b());
            }
        }
        gvVar.a(hp.a(context, hbVar));
        hb hbVarA = w.a(hbVar.b(), hbVar.m554a(), gvVar, gf.AckMessage);
        gs gsVarM553a2 = hbVar.m553a();
        if (gsVarM553a2 != null) {
            gsVarM553a2 = au.a(gsVarM553a2.m518a());
            Map<String, String> mapM520a = gsVarM553a2.m520a();
            String str = mapM520a != null ? mapM520a.get("channel_id") : null;
            gsVarM553a2.a("mat", Long.toString(System.currentTimeMillis()));
            gsVarM553a2.a(OapsKey.KEY_CHECKSUM, String.valueOf(f.a(context, hbVar.f662b, str)));
        }
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (String str2 : map.keySet()) {
                        gsVarM553a2.a(str2, map.get(str2));
                    }
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("error adding params to ack message :" + th);
            }
        }
        hbVarA.a(gsVarM553a2);
        return hbVarA;
    }

    private static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (listQueryBroadcastReceivers != null) {
                if (!listQueryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }
}
