package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.cs;
import com.xiaomi.push.er;
import com.xiaomi.push.fa;
import com.xiaomi.push.fi;
import com.xiaomi.push.fo;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.gs;
import com.xiaomi.push.gu;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.hu;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.ay;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
final class w {
    public static void a(XMPushService xMPushService) {
        p pVarM765a = q.m765a(xMPushService.getApplicationContext());
        if (pVarM765a != null) {
            am.b bVarA = q.m765a(xMPushService.getApplicationContext()).a(xMPushService);
            com.xiaomi.channel.commonutils.logger.b.m74a("prepare account. " + bVarA.f936a);
            a(xMPushService, bVarA);
            am.a().a(bVarA);
            a(xMPushService, pVarM765a, 172800);
        }
    }

    public static <T extends hq<T, ?>> hb b(String str, String str2, T t, gf gfVar) {
        return a(str, str2, t, gfVar, false);
    }

    public static hb b(String str, String str2) {
        he heVar = new he();
        heVar.b(str2);
        heVar.c(gp.AppDataCleared.f535a);
        heVar.a(aj.a());
        heVar.a(false);
        return a(str, str2, heVar, gf.Notification);
    }

    private static void a(final XMPushService xMPushService, final p pVar, int i) {
        ay.a(xMPushService).a(new ay.a("MSAID", i) { // from class: com.xiaomi.push.service.w.1
            @Override // com.xiaomi.push.service.ay.a
            public void a(ay ayVar) {
                com.xiaomi.push.an anVarA = com.xiaomi.push.an.a(xMPushService);
                String strA = ayVar.a("MSAID", "msaid");
                String strMo160a = anVarA.mo160a();
                if (TextUtils.isEmpty(strMo160a) || TextUtils.equals(strA, strMo160a)) {
                    return;
                }
                ayVar.a("MSAID", "msaid", strMo160a);
                he heVar = new he();
                heVar.b(pVar.d);
                heVar.c(gp.ClientInfoUpdate.f535a);
                heVar.a(aj.a());
                heVar.a(new HashMap());
                anVarA.a(heVar.m569a());
                byte[] bArrA = hp.a(w.a(xMPushService.getPackageName(), pVar.d, heVar, gf.Notification));
                XMPushService xMPushService2 = xMPushService;
                xMPushService2.a(xMPushService2.getPackageName(), bArrA, true);
            }
        });
    }

    private static String a(hb hbVar) {
        Map<String, String> map;
        gs gsVar = hbVar.f656a;
        if (gsVar != null && (map = gsVar.f574b) != null) {
            String str = map.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return hbVar.f662b;
    }

    public static er a(p pVar, Context context, hb hbVar) {
        try {
            er erVar = new er();
            erVar.a(5);
            erVar.c(pVar.f1005a);
            erVar.b(a(hbVar));
            erVar.a("SECMSG", "message");
            String str = pVar.f1005a;
            hbVar.f657a.f584a = str.substring(0, str.indexOf("@"));
            hbVar.f657a.f588c = str.substring(str.indexOf("/") + 1);
            erVar.a(hp.a(hbVar), pVar.c);
            erVar.a((short) 1);
            com.xiaomi.channel.commonutils.logger.b.m74a("try send mi push message. packagename:" + hbVar.f662b + " action:" + hbVar.f655a);
            return erVar;
        } catch (NullPointerException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    public static er a(XMPushService xMPushService, byte[] bArr) {
        hb hbVar = new hb();
        try {
            hp.a(hbVar, bArr);
            return a(q.m765a((Context) xMPushService), xMPushService, hbVar);
        } catch (hu e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    public static <T extends hq<T, ?>> hb a(String str, String str2, T t, gf gfVar) {
        return a(str, str2, t, gfVar, true);
    }

    private static <T extends hq<T, ?>> hb a(String str, String str2, T t, gf gfVar, boolean z) {
        byte[] bArrA = hp.a(t);
        hb hbVar = new hb();
        gu guVar = new gu();
        guVar.f583a = 5L;
        guVar.f584a = "fakeid";
        hbVar.a(guVar);
        hbVar.a(ByteBuffer.wrap(bArrA));
        hbVar.a(gfVar);
        hbVar.b(z);
        hbVar.b(str);
        hbVar.a(false);
        hbVar.a(str2);
        return hbVar;
    }

    public static hb a(String str, String str2) {
        he heVar = new he();
        heVar.b(str2);
        heVar.c("package uninstalled");
        heVar.a(fo.i());
        heVar.a(false);
        return a(str, str2, heVar, gf.Notification);
    }

    public static void a(final XMPushService xMPushService, am.b bVar) {
        bVar.a((Messenger) null);
        bVar.a(new am.b.a() { // from class: com.xiaomi.push.service.w.2
            @Override // com.xiaomi.push.service.am.b.a
            public void a(am.c cVar, am.c cVar2, int i) {
                if (cVar2 == am.c.binded) {
                    t.a(xMPushService, true);
                    t.a(xMPushService);
                } else if (cVar2 == am.c.unbind) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("onChange unbind");
                    t.a(xMPushService, ErrorCode.ERROR_SERVICE_UNAVAILABLE, " the push is not connected.");
                }
            }
        });
    }

    public static void a(XMPushService xMPushService, String str, byte[] bArr) {
        cs.a(str, xMPushService.getApplicationContext(), bArr);
        fa faVarM684a = xMPushService.m684a();
        if (faVarM684a != null) {
            if (faVarM684a.mo431a()) {
                er erVarA = a(xMPushService, bArr);
                if (erVarA != null) {
                    faVarM684a.b(erVarA);
                    return;
                } else {
                    t.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
                    return;
                }
            }
            throw new fi("Don't support XMPP connection.");
        }
        throw new fi("try send msg while connection is null.");
    }

    public static void a(XMPushService xMPushService, hb hbVar) {
        cs.a(hbVar.b(), xMPushService.getApplicationContext(), hbVar, -1);
        fa faVarM684a = xMPushService.m684a();
        if (faVarM684a != null) {
            if (faVarM684a.mo431a()) {
                er erVarA = a(q.m765a((Context) xMPushService), xMPushService, hbVar);
                if (erVarA != null) {
                    faVarM684a.b(erVarA);
                    return;
                }
                return;
            }
            throw new fi("Don't support XMPP connection.");
        }
        throw new fi("try send msg while connection is null.");
    }

    public static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }
}
