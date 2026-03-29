package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.hms.ads.ex;
import com.igexin.assist.sdk.AssistPushConsts;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.bb;
import com.xiaomi.push.bn;
import com.xiaomi.push.cs;
import com.xiaomi.push.ds;
import com.xiaomi.push.dt;
import com.xiaomi.push.ed;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.gr;
import com.xiaomi.push.gs;
import com.xiaomi.push.gt;
import com.xiaomi.push.gv;
import com.xiaomi.push.gw;
import com.xiaomi.push.ha;
import com.xiaomi.push.hb;
import com.xiaomi.push.hc;
import com.xiaomi.push.hd;
import com.xiaomi.push.he;
import com.xiaomi.push.hg;
import com.xiaomi.push.hi;
import com.xiaomi.push.hk;
import com.xiaomi.push.hm;
import com.xiaomi.push.ho;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.hu;
import com.xiaomi.push.service.ag;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.ai;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.au;
import com.xiaomi.push.service.x;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static t f11385a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Object f68a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Queue<String> f69a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f70a;

    /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.t$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11386a;

        static {
            int[] iArr = new int[gf.values().length];
            f11386a = iArr;
            try {
                iArr[gf.SendMessage.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11386a[gf.Registration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11386a[gf.UnRegistration.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11386a[gf.Subscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11386a[gf.UnSubscription.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11386a[gf.Command.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11386a[gf.Notification.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private t(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f70a = applicationContext;
        if (applicationContext == null) {
            this.f70a = context;
        }
    }

    public static t a(Context context) {
        if (f11385a == null) {
            f11385a = new t(context);
        }
        return f11385a;
    }

    private void b(gw gwVar) {
        com.xiaomi.channel.commonutils.logger.b.c("ASSEMBLE_PUSH : " + gwVar.toString());
        String strA = gwVar.a();
        Map<String, String> mapM534a = gwVar.m534a();
        if (mapM534a != null) {
            String str = mapM534a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("brand:" + q.FCM.name())) {
                com.xiaomi.channel.commonutils.logger.b.m74a("ASSEMBLE_PUSH : receive fcm token sync ack");
                Context context = this.f70a;
                d dVar = d.ASSEMBLE_PUSH_FCM;
                f.b(context, dVar, str);
                a(strA, gwVar.f613a, dVar);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("brand:");
            q qVar = q.HUAWEI;
            sb.append(qVar.name());
            if (!str.contains(sb.toString())) {
                if (!str.contains("channel:" + qVar.name())) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("brand:");
                    q qVar2 = q.OPPO;
                    sb2.append(qVar2.name());
                    if (!str.contains(sb2.toString())) {
                        if (!str.contains("channel:" + qVar2.name())) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("brand:");
                            q qVar3 = q.VIVO;
                            sb3.append(qVar3.name());
                            if (!str.contains(sb3.toString())) {
                                if (!str.contains("channel:" + qVar3.name())) {
                                    return;
                                }
                            }
                            com.xiaomi.channel.commonutils.logger.b.m74a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                            Context context2 = this.f70a;
                            d dVar2 = d.ASSEMBLE_PUSH_FTOS;
                            f.b(context2, dVar2, str);
                            a(strA, gwVar.f613a, dVar2);
                            return;
                        }
                    }
                    com.xiaomi.channel.commonutils.logger.b.m74a("ASSEMBLE_PUSH : receive COS token sync ack");
                    Context context3 = this.f70a;
                    d dVar3 = d.ASSEMBLE_PUSH_COS;
                    f.b(context3, dVar3, str);
                    a(strA, gwVar.f613a, dVar3);
                    return;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m74a("ASSEMBLE_PUSH : receive hw token sync ack");
            Context context4 = this.f70a;
            d dVar4 = d.ASSEMBLE_PUSH_HUAWEI;
            f.b(context4, dVar4, str);
            a(strA, gwVar.f613a, dVar4);
        }
    }

    public PushMessageHandler.a a(Intent intent) {
        String action = intent.getAction();
        com.xiaomi.channel.commonutils.logger.b.m74a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an empty message, drop");
                dt.a(this.f70a).a(this.f70a.getPackageName(), intent, BaseWrapper.ENTER_ID_MARKET);
                return null;
            }
            hb hbVar = new hb();
            try {
                hp.a(hbVar, byteArrayExtra);
                b bVarM99a = b.m99a(this.f70a);
                gs gsVarM553a = hbVar.m553a();
                gf gfVarA = hbVar.a();
                gf gfVar = gf.SendMessage;
                if (gfVarA == gfVar && gsVarM553a != null && !bVarM99a.m110e() && !booleanExtra) {
                    gsVarM553a.a("mrt", stringExtra);
                    gsVarM553a.a("mat", Long.toString(System.currentTimeMillis()));
                    if (!m131a(hbVar)) {
                        b(hbVar);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                        gsVarM553a.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(gsVarM553a.m517a()));
                        gsVarM553a.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) hp.a(this.f70a, hbVar)));
                    }
                }
                if (hbVar.a() == gfVar && !hbVar.m561b()) {
                    if (x.m781a(hbVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = hbVar.b();
                        objArr[1] = gsVarM553a != null ? gsVarM553a.m519a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m74a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                        dt.a(this.f70a).a(this.f70a.getPackageName(), intent, String.format("13: %1$s", hbVar.b()));
                    } else {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = hbVar.b();
                        objArr2[1] = gsVarM553a != null ? gsVarM553a.m519a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m74a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        dt.a(this.f70a).a(this.f70a.getPackageName(), intent, String.format("14: %1$s", hbVar.b()));
                    }
                    j.a(this.f70a, hbVar, booleanExtra);
                    return null;
                }
                if (hbVar.a() == gfVar && hbVar.m561b() && x.m781a(hbVar) && (!booleanExtra || gsVarM553a == null || gsVarM553a.m520a() == null || !gsVarM553a.m520a().containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = hbVar.b();
                    objArr3[1] = gsVarM553a != null ? gsVarM553a.m519a() : "";
                    com.xiaomi.channel.commonutils.logger.b.m74a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    dt.a(this.f70a).a(this.f70a.getPackageName(), intent, String.format("25: %1$s", hbVar.b()));
                    j.b(this.f70a, hbVar, booleanExtra);
                    return null;
                }
                if (!bVarM99a.m108c() && hbVar.f655a != gf.Registration) {
                    if (x.m781a(hbVar)) {
                        return a(hbVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    }
                    j.e(this.f70a, hbVar, booleanExtra);
                    boolean zM109d = bVarM99a.m109d();
                    com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!registered?" + zM109d);
                    dt.a(this.f70a).a(this.f70a.getPackageName(), intent, "15");
                    if (zM109d) {
                        a();
                    }
                } else if (bVarM99a.m108c() && bVarM99a.m111f()) {
                    if (hbVar.f655a == gf.UnRegistration) {
                        if (hbVar.m561b()) {
                            bVarM99a.m101a();
                            MiPushClient.clearExtras(this.f70a);
                            PushMessageHandler.a();
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt unregistration message");
                        }
                    } else {
                        j.e(this.f70a, hbVar, booleanExtra);
                        MiPushClient.unregisterPush(this.f70a);
                    }
                } else {
                    return a(hbVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                }
            } catch (hu e) {
                dt.a(this.f70a).a(this.f70a.getPackageName(), intent, "16");
                com.xiaomi.channel.commonutils.logger.b.a(e);
            } catch (Exception e2) {
                dt.a(this.f70a).a(this.f70a.getPackageName(), intent, BaseWrapper.ENTER_ID_17);
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        } else {
            if ("com.xiaomi.mipush.ERROR".equals(action)) {
                MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
                hb hbVar2 = new hb();
                try {
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                    if (byteArrayExtra2 != null) {
                        hp.a(hbVar2, byteArrayExtra2);
                    }
                } catch (hu unused) {
                }
                miPushCommandMessage.setCommand(String.valueOf(hbVar2.a()));
                miPushCommandMessage.setResultCode(intent.getIntExtra("mipush_error_code", 0));
                miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
                com.xiaomi.channel.commonutils.logger.b.d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
                return miPushCommandMessage;
            }
            if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
                byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra3 == null) {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an empty message, drop");
                    return null;
                }
                hb hbVar3 = new hb();
                try {
                    hp.a(hbVar3, byteArrayExtra3);
                    b bVarM99a2 = b.m99a(this.f70a);
                    if (x.m781a(hbVar3)) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive ignore reg message, ignore!");
                    } else if (!bVarM99a2.m108c()) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive message without registration. need unregister or re-register!");
                    } else if (bVarM99a2.m108c() && bVarM99a2.m111f()) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: app info is invalidated");
                    } else {
                        return a(hbVar3, byteArrayExtra3);
                    }
                } catch (Exception e3) {
                    com.xiaomi.channel.commonutils.logger.b.d("fail to deal with arrived message. " + e3);
                }
            }
        }
        return null;
    }

    private void b(hb hbVar) {
        gs gsVarM553a = hbVar.m553a();
        if (gsVarM553a != null) {
            gsVarM553a = au.a(gsVarM553a.m518a());
        }
        gv gvVar = new gv();
        gvVar.b(hbVar.m554a());
        gvVar.a(gsVarM553a.m519a());
        gvVar.a(gsVarM553a.m517a());
        if (!TextUtils.isEmpty(gsVarM553a.m524b())) {
            gvVar.c(gsVarM553a.m524b());
        }
        gvVar.a(hp.a(this.f70a, hbVar));
        u.a(this.f70a).a(gvVar, gf.AckMessage, false, gsVarM553a);
    }

    private void b(he heVar) {
        Map<String, String> mapM569a = heVar.m569a();
        if (mapM569a == null) {
            com.xiaomi.channel.commonutils.logger.b.m74a("detect failed because null");
            return;
        }
        String str = (String) ag.a(mapM569a, "pkgList", (Object) null);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m74a("detect failed because empty");
            return;
        }
        Map<String, String> mapM476a = com.xiaomi.push.g.m476a(this.f70a, str);
        if (mapM476a != null) {
            String str2 = mapM476a.get("alive");
            String str3 = mapM476a.get("notAlive");
            if (!TextUtils.isEmpty(str2)) {
                he heVar2 = new he();
                heVar2.a(heVar.m568a());
                heVar2.b(heVar.b());
                heVar2.d(heVar.d());
                heVar2.c(gp.DetectAppAliveResult.f535a);
                HashMap map = new HashMap();
                heVar2.f674a = map;
                map.put("alive", str2);
                if (Boolean.parseBoolean((String) ag.a(mapM569a, "reportNotAliveApp", ex.V)) && !TextUtils.isEmpty(str3)) {
                    heVar2.f674a.put("notAlive", str3);
                }
                u.a(this.f70a).a(heVar2, gf.Notification, false, (gs) null);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("detect failed because no alive process");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("detect failed because get status illegal");
    }

    private PushMessageHandler.a a(hb hbVar, byte[] bArr) {
        String str = null;
        try {
            hq hqVarA = r.a(this.f70a, hbVar);
            if (hqVarA == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + hbVar.f655a);
                return null;
            }
            gf gfVarA = hbVar.a();
            com.xiaomi.channel.commonutils.logger.b.m74a("message arrived: processing an arrived message, action=" + gfVarA);
            if (AnonymousClass1.f11386a[gfVarA.ordinal()] != 1) {
                return null;
            }
            if (!hbVar.m561b()) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-encrypt message(SendMessage).");
                return null;
            }
            hi hiVar = (hi) hqVarA;
            gr grVarA = hiVar.a();
            if (grVarA == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive an empty message without push content, drop it");
                return null;
            }
            gs gsVar = hbVar.f656a;
            if (gsVar != null && gsVar.m520a() != null) {
                str = hbVar.f656a.f570a.get("jobkey");
            }
            MiPushMessage miPushMessageGenerateMessage = PushMessageHelper.generateMessage(hiVar, hbVar.m553a(), false);
            miPushMessageGenerateMessage.setArrivedMessage(true);
            com.xiaomi.channel.commonutils.logger.b.m74a("message arrived: receive a message, msgid=" + grVarA.m511a() + ", jobkey=" + str);
            return miPushMessageGenerateMessage;
        } catch (l e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive a message but decrypt failed. report when click.");
            return null;
        } catch (hu e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive a message which action string is not valid. is the reg expired?");
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private PushMessageHandler.a a(hb hbVar, boolean z, byte[] bArr, String str, int i, Intent intent) {
        gs gsVar;
        MiPushMessage miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        miPushMessage = null;
        ArrayList arrayList3 = null;
        miPushMessage = null;
        try {
            hq hqVarA = r.a(this.f70a, hbVar);
            if (hqVarA == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + hbVar.f655a);
                dt.a(this.f70a).b(this.f70a.getPackageName(), ds.m381a(i), str, BaseWrapper.ENTER_ID_18);
                j.c(this.f70a, hbVar, z);
                return null;
            }
            gf gfVarA = hbVar.a();
            com.xiaomi.channel.commonutils.logger.b.m76a("processing a message, action=", gfVarA, ", hasNotified=", Boolean.valueOf(z));
            switch (AnonymousClass1.f11386a[gfVarA.ordinal()]) {
                case 1:
                    if (!hbVar.m561b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    }
                    if (b.m99a(this.f70a).m110e() && !z) {
                        com.xiaomi.channel.commonutils.logger.b.m74a("receive a message in pause state. drop it");
                        dt.a(this.f70a).a(this.f70a.getPackageName(), ds.m381a(i), str, BaseWrapper.ENTER_ID_MARKET);
                        return null;
                    }
                    hi hiVar = (hi) hqVarA;
                    gr grVarA = hiVar.a();
                    if (grVarA == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                        dt.a(this.f70a).b(this.f70a.getPackageName(), ds.m381a(i), str, BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING);
                        j.d(this.f70a, hbVar, z);
                        return null;
                    }
                    int intExtra = intent.getIntExtra("notification_click_button", 0);
                    if (z) {
                        if (x.m781a(hbVar)) {
                            MiPushClient.reportIgnoreRegMessageClicked(this.f70a, grVarA.m511a(), hbVar.m553a(), hbVar.f662b, grVarA.b());
                        } else {
                            if (hbVar.m553a() != null) {
                                gsVar = new gs(hbVar.m553a());
                            } else {
                                gsVar = new gs();
                            }
                            if (gsVar.m520a() == null) {
                                gsVar.a(new HashMap());
                            }
                            gsVar.m520a().put("notification_click_button", String.valueOf(intExtra));
                            MiPushClient.reportMessageClicked(this.f70a, grVarA.m511a(), gsVar, grVarA.b());
                        }
                    }
                    if (!z) {
                        if (!TextUtils.isEmpty(hiVar.d()) && MiPushClient.aliasSetTime(this.f70a, hiVar.d()) < 0) {
                            MiPushClient.addAlias(this.f70a, hiVar.d());
                        } else if (!TextUtils.isEmpty(hiVar.c()) && MiPushClient.topicSubscribedTime(this.f70a, hiVar.c()) < 0) {
                            MiPushClient.addTopic(this.f70a, hiVar.c());
                        }
                    }
                    gs gsVar2 = hbVar.f656a;
                    String strM511a = (gsVar2 == null || gsVar2.m520a() == null) ? null : hbVar.f656a.f570a.get("jobkey");
                    String str2 = strM511a;
                    if (TextUtils.isEmpty(strM511a)) {
                        strM511a = grVarA.m511a();
                    }
                    if (!z && m130a(this.f70a, strM511a)) {
                        com.xiaomi.channel.commonutils.logger.b.m74a("drop a duplicate message, key=" + strM511a);
                        dt.a(this.f70a).c(this.f70a.getPackageName(), ds.m381a(i), str, "2:" + strM511a);
                    } else {
                        MiPushMessage miPushMessageGenerateMessage = PushMessageHelper.generateMessage(hiVar, hbVar.m553a(), z);
                        if (miPushMessageGenerateMessage.getPassThrough() == 0 && !z && x.m782a(miPushMessageGenerateMessage.getExtra())) {
                            x.m777a(this.f70a, hbVar, bArr);
                            return null;
                        }
                        String strA = x.a(miPushMessageGenerateMessage.getExtra(), intExtra);
                        com.xiaomi.channel.commonutils.logger.b.m76a("receive a message, msgid=", grVarA.m511a(), ", jobkey=", strM511a, ", btn=", Integer.valueOf(intExtra), ", typeId=", strA, ", hasNotified=", Boolean.valueOf(z));
                        if (z && miPushMessageGenerateMessage.getExtra() != null && !TextUtils.isEmpty(strA)) {
                            Map<String, String> extra = miPushMessageGenerateMessage.getExtra();
                            if (intExtra != 0 && hbVar.m553a() != null) {
                                u.a(this.f70a).a(hbVar.m553a().c(), intExtra);
                            }
                            if (x.m781a(hbVar)) {
                                Intent intentA = a(this.f70a, hbVar.f662b, extra, intExtra);
                                intentA.putExtra("eventMessageType", i);
                                intentA.putExtra("messageId", str);
                                intentA.putExtra("jobkey", str2);
                                String strC = grVarA.c();
                                if (!TextUtils.isEmpty(strC)) {
                                    intentA.putExtra(AssistPushConsts.MSG_TYPE_PAYLOAD, strC);
                                }
                                this.f70a.startActivity(intentA);
                                j.a(this.f70a, hbVar);
                                dt.a(this.f70a).a(this.f70a.getPackageName(), ds.m381a(i), str, 3006, strA);
                                com.xiaomi.channel.commonutils.logger.b.m75a("PushMessageProcessor", "start business activity succ");
                            } else {
                                Context context = this.f70a;
                                Intent intentA2 = a(context, context.getPackageName(), extra, intExtra);
                                if (intentA2 != null) {
                                    if (!strA.equals(an.c)) {
                                        intentA2.putExtra(PushMessageHelper.KEY_MESSAGE, miPushMessageGenerateMessage);
                                        intentA2.putExtra("eventMessageType", i);
                                        intentA2.putExtra("messageId", str);
                                        intentA2.putExtra("jobkey", str2);
                                    }
                                    this.f70a.startActivity(intentA2);
                                    j.a(this.f70a, hbVar);
                                    com.xiaomi.channel.commonutils.logger.b.m75a("PushMessageProcessor", "start activity succ");
                                    dt.a(this.f70a).a(this.f70a.getPackageName(), ds.m381a(i), str, 1006, strA);
                                    if (strA.equals(an.c)) {
                                        dt.a(this.f70a).a(this.f70a.getPackageName(), ds.m381a(i), str, BaseWrapper.ENTER_ID_GAME_CENTER);
                                    }
                                } else {
                                    com.xiaomi.channel.commonutils.logger.b.d("PushMessageProcessor", "missing target intent for message: " + grVarA.m511a() + ", typeId=" + strA);
                                }
                            }
                            com.xiaomi.channel.commonutils.logger.b.m75a("PushMessageProcessor", "pre-def msg process done.");
                            return null;
                        }
                        miPushMessage = miPushMessageGenerateMessage;
                    }
                    if (hbVar.m553a() == null && !z) {
                        a(hiVar, hbVar);
                    }
                    return miPushMessage;
                case 2:
                    hg hgVar = (hg) hqVarA;
                    String str3 = b.m99a(this.f70a).f46a;
                    if (!TextUtils.isEmpty(str3) && TextUtils.equals(str3, hgVar.m583a())) {
                        long jM140a = u.a(this.f70a).m140a();
                        if (jM140a > 0 && SystemClock.elapsedRealtime() - jM140a > 900000) {
                            com.xiaomi.channel.commonutils.logger.b.m74a("The received registration result has expired.");
                            dt.a(this.f70a).b(this.f70a.getPackageName(), ds.m381a(i), str, "26");
                            return null;
                        }
                        b.m99a(this.f70a).f46a = null;
                        if (hgVar.f718a == 0) {
                            b.m99a(this.f70a).b(hgVar.f730e, hgVar.f731f, hgVar.f737l);
                            FCMPushHelper.persistIfXmsfSupDecrypt(this.f70a);
                            dt.a(this.f70a).a(this.f70a.getPackageName(), ds.m381a(i), str, 6006, "1");
                        } else {
                            dt.a(this.f70a).a(this.f70a.getPackageName(), ds.m381a(i), str, 6006, "2");
                        }
                        if (!TextUtils.isEmpty(hgVar.f730e)) {
                            arrayList3 = new ArrayList();
                            arrayList3.add(hgVar.f730e);
                        }
                        MiPushCommandMessage miPushCommandMessageGenerateCommandMessage = PushMessageHelper.generateCommandMessage(ed.COMMAND_REGISTER.f362a, arrayList3, hgVar.f718a, hgVar.f729d, null, hgVar.m584a());
                        u.a(this.f70a).m149d();
                        return miPushCommandMessageGenerateCommandMessage;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m74a("bad Registration result:");
                    dt.a(this.f70a).b(this.f70a.getPackageName(), ds.m381a(i), str, "21");
                    return null;
                case 3:
                    if (!hbVar.m561b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(UnRegistration).");
                        return null;
                    }
                    if (((hm) hqVarA).f796a == 0) {
                        b.m99a(this.f70a).m101a();
                        MiPushClient.clearExtras(this.f70a);
                    }
                    PushMessageHandler.a();
                    return miPushMessage;
                case 4:
                    hk hkVar = (hk) hqVarA;
                    if (hkVar.f771a == 0) {
                        MiPushClient.addTopic(this.f70a, hkVar.b());
                    }
                    if (!TextUtils.isEmpty(hkVar.b())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(hkVar.b());
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("resp-cmd:");
                    ed edVar = ed.COMMAND_SUBSCRIBE_TOPIC;
                    sb.append(edVar);
                    sb.append(", ");
                    sb.append(hkVar.a());
                    com.xiaomi.channel.commonutils.logger.b.e(sb.toString());
                    return PushMessageHelper.generateCommandMessage(edVar.f362a, arrayList2, hkVar.f771a, hkVar.f777d, hkVar.c(), null);
                case 5:
                    ho hoVar = (ho) hqVarA;
                    if (hoVar.f816a == 0) {
                        MiPushClient.removeTopic(this.f70a, hoVar.b());
                    }
                    if (!TextUtils.isEmpty(hoVar.b())) {
                        arrayList = new ArrayList();
                        arrayList.add(hoVar.b());
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("resp-cmd:");
                    ed edVar2 = ed.COMMAND_UNSUBSCRIBE_TOPIC;
                    sb2.append(edVar2);
                    sb2.append(", ");
                    sb2.append(hoVar.a());
                    com.xiaomi.channel.commonutils.logger.b.e(sb2.toString());
                    return PushMessageHelper.generateCommandMessage(edVar2.f362a, arrayList, hoVar.f816a, hoVar.f822d, hoVar.c(), null);
                case 6:
                    cs.a(this.f70a.getPackageName(), this.f70a, hqVarA, gf.Command, bArr.length);
                    ha haVar = (ha) hqVarA;
                    String strB = haVar.b();
                    List<String> listM547a = haVar.m547a();
                    if (haVar.f643a == 0) {
                        if (TextUtils.equals(strB, ed.COMMAND_SET_ACCEPT_TIME.f362a) && listM547a != null && listM547a.size() > 1) {
                            MiPushClient.addAcceptTime(this.f70a, listM547a.get(0), listM547a.get(1));
                            if ("00:00".equals(listM547a.get(0)) && "00:00".equals(listM547a.get(1))) {
                                b.m99a(this.f70a).a(true);
                            } else {
                                b.m99a(this.f70a).a(false);
                            }
                            listM547a = a(DesugarTimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), listM547a);
                        } else if (TextUtils.equals(strB, ed.COMMAND_SET_ALIAS.f362a) && listM547a != null && listM547a.size() > 0) {
                            MiPushClient.addAlias(this.f70a, listM547a.get(0));
                        } else if (TextUtils.equals(strB, ed.COMMAND_UNSET_ALIAS.f362a) && listM547a != null && listM547a.size() > 0) {
                            MiPushClient.removeAlias(this.f70a, listM547a.get(0));
                        } else if (TextUtils.equals(strB, ed.COMMAND_SET_ACCOUNT.f362a) && listM547a != null && listM547a.size() > 0) {
                            MiPushClient.addAccount(this.f70a, listM547a.get(0));
                        } else if (TextUtils.equals(strB, ed.COMMAND_UNSET_ACCOUNT.f362a) && listM547a != null && listM547a.size() > 0) {
                            MiPushClient.removeAccount(this.f70a, listM547a.get(0));
                        } else if (TextUtils.equals(strB, ed.COMMAND_CHK_VDEVID.f362a)) {
                            return null;
                        }
                    }
                    List<String> list = listM547a;
                    com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + strB + ", " + haVar.a());
                    return PushMessageHelper.generateCommandMessage(strB, list, haVar.f643a, haVar.f651d, haVar.c(), null);
                case 7:
                    cs.a(this.f70a.getPackageName(), this.f70a, hqVarA, gf.Notification, bArr.length);
                    if (hqVarA instanceof gw) {
                        gw gwVar = (gw) hqVarA;
                        String strA2 = gwVar.a();
                        com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + gwVar.b() + ", code:" + gwVar.f613a + ", " + strA2);
                        if (gp.DisablePushMessage.f535a.equalsIgnoreCase(gwVar.f620d)) {
                            if (gwVar.f613a == 0) {
                                synchronized (p.class) {
                                    if (p.a(this.f70a).m129a(strA2)) {
                                        p.a(this.f70a).c(strA2);
                                        p pVarA = p.a(this.f70a);
                                        v vVar = v.DISABLE_PUSH;
                                        if ("syncing".equals(pVarA.a(vVar))) {
                                            p.a(this.f70a).a(vVar, "synced");
                                            MiPushClient.clearNotification(this.f70a);
                                            MiPushClient.clearLocalNotificationType(this.f70a);
                                            PushMessageHandler.a();
                                            u.a(this.f70a).m146b();
                                        }
                                    }
                                }
                            } else if ("syncing".equals(p.a(this.f70a).a(v.DISABLE_PUSH))) {
                                synchronized (p.class) {
                                    if (p.a(this.f70a).m129a(strA2)) {
                                        if (p.a(this.f70a).a(strA2) < 10) {
                                            p.a(this.f70a).b(strA2);
                                            u.a(this.f70a).a(true, strA2);
                                        } else {
                                            p.a(this.f70a).c(strA2);
                                        }
                                    }
                                }
                            } else {
                                p.a(this.f70a).c(strA2);
                            }
                            break;
                        } else if (gp.EnablePushMessage.f535a.equalsIgnoreCase(gwVar.f620d)) {
                            if (gwVar.f613a == 0) {
                                synchronized (p.class) {
                                    if (p.a(this.f70a).m129a(strA2)) {
                                        p.a(this.f70a).c(strA2);
                                        p pVarA2 = p.a(this.f70a);
                                        v vVar2 = v.ENABLE_PUSH;
                                        if ("syncing".equals(pVarA2.a(vVar2))) {
                                            p.a(this.f70a).a(vVar2, "synced");
                                        }
                                    }
                                }
                            } else if ("syncing".equals(p.a(this.f70a).a(v.ENABLE_PUSH))) {
                                synchronized (p.class) {
                                    if (p.a(this.f70a).m129a(strA2)) {
                                        if (p.a(this.f70a).a(strA2) < 10) {
                                            p.a(this.f70a).b(strA2);
                                            u.a(this.f70a).a(false, strA2);
                                        } else {
                                            p.a(this.f70a).c(strA2);
                                        }
                                    }
                                }
                            } else {
                                p.a(this.f70a).c(strA2);
                            }
                            break;
                        } else if (gp.ThirdPartyRegUpdate.f535a.equalsIgnoreCase(gwVar.f620d)) {
                            b(gwVar);
                        } else if (gp.UploadTinyData.f535a.equalsIgnoreCase(gwVar.f620d)) {
                            a(gwVar);
                        }
                    } else if (hqVarA instanceof he) {
                        he heVar = (he) hqVarA;
                        if ("registration id expired".equalsIgnoreCase(heVar.f679d)) {
                            List<String> allAlias = MiPushClient.getAllAlias(this.f70a);
                            List<String> allTopic = MiPushClient.getAllTopic(this.f70a);
                            List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f70a);
                            String acceptTime = MiPushClient.getAcceptTime(this.f70a);
                            com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + heVar.f679d + ", " + heVar.m568a());
                            MiPushClient.reInitialize(this.f70a, gt.RegIdExpired);
                            for (String str4 : allAlias) {
                                MiPushClient.removeAlias(this.f70a, str4);
                                MiPushClient.setAlias(this.f70a, str4, null);
                            }
                            for (String str5 : allTopic) {
                                MiPushClient.removeTopic(this.f70a, str5);
                                MiPushClient.subscribe(this.f70a, str5, null);
                            }
                            for (String str6 : allUserAccount) {
                                MiPushClient.removeAccount(this.f70a, str6);
                                MiPushClient.setUserAccount(this.f70a, str6, null);
                            }
                            String[] strArrSplit = acceptTime.split(",");
                            if (strArrSplit.length == 2) {
                                MiPushClient.removeAcceptTime(this.f70a);
                                MiPushClient.addAcceptTime(this.f70a, strArrSplit[0], strArrSplit[1]);
                            }
                        } else if (gp.ClientInfoUpdateOk.f535a.equalsIgnoreCase(heVar.f679d)) {
                            if (heVar.m569a() != null && heVar.m569a().containsKey("app_version")) {
                                b.m99a(this.f70a).m102a(heVar.m569a().get("app_version"));
                            }
                        } else {
                            try {
                                if (gp.NormalClientConfigUpdate.f535a.equalsIgnoreCase(heVar.f679d)) {
                                    hd hdVar = new hd();
                                    hp.a(hdVar, heVar.m574a());
                                    ai.a(ah.a(this.f70a), hdVar);
                                } else if (gp.CustomClientConfigUpdate.f535a.equalsIgnoreCase(heVar.f679d)) {
                                    hc hcVar = new hc();
                                    hp.a(hcVar, heVar.m574a());
                                    ai.a(ah.a(this.f70a), hcVar);
                                } else if (gp.SyncInfoResult.f535a.equalsIgnoreCase(heVar.f679d)) {
                                    w.a(this.f70a, heVar);
                                } else if (gp.ForceSync.f535a.equalsIgnoreCase(heVar.f679d)) {
                                    com.xiaomi.channel.commonutils.logger.b.m74a("receive force sync notification");
                                    w.a(this.f70a, false);
                                } else if (gp.CancelPushMessage.f535a.equals(heVar.f679d)) {
                                    com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + heVar.f679d + ", " + heVar.m568a());
                                    if (heVar.m569a() != null) {
                                        int i2 = -2;
                                        if (heVar.m569a().containsKey(an.Q)) {
                                            String str7 = heVar.m569a().get(an.Q);
                                            if (!TextUtils.isEmpty(str7)) {
                                                try {
                                                    i2 = Integer.parseInt(str7);
                                                } catch (NumberFormatException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                        if (i2 >= -1) {
                                            MiPushClient.clearNotification(this.f70a, i2);
                                        } else {
                                            MiPushClient.clearNotification(this.f70a, heVar.m569a().containsKey(an.O) ? heVar.m569a().get(an.O) : "", heVar.m569a().containsKey(an.P) ? heVar.m569a().get(an.P) : "");
                                        }
                                    }
                                    a(heVar);
                                    break;
                                } else if (gp.HybridRegisterResult.f535a.equals(heVar.f679d)) {
                                    try {
                                        hg hgVar2 = new hg();
                                        hp.a(hgVar2, heVar.m574a());
                                        MiPushClient4Hybrid.onReceiveRegisterResult(this.f70a, hgVar2);
                                    } catch (hu e2) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                                    }
                                    break;
                                } else if (gp.HybridUnregisterResult.f535a.equals(heVar.f679d)) {
                                    try {
                                        hm hmVar = new hm();
                                        hp.a(hmVar, heVar.m574a());
                                        MiPushClient4Hybrid.onReceiveUnregisterResult(this.f70a, hmVar);
                                    } catch (hu e3) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e3);
                                    }
                                    break;
                                } else if (!gp.PushLogUpload.f535a.equals(heVar.f679d)) {
                                    if (gp.DetectAppAlive.f535a.equals(heVar.f679d)) {
                                        com.xiaomi.channel.commonutils.logger.b.b("receive detect msg");
                                        b(heVar);
                                    } else if (com.xiaomi.push.service.g.a(heVar)) {
                                        com.xiaomi.channel.commonutils.logger.b.b("receive notification handle by cpra");
                                    }
                                }
                                break;
                            } catch (hu unused) {
                            }
                        }
                    }
                    return miPushMessage;
                default:
                    return miPushMessage;
            }
        } catch (l e4) {
            com.xiaomi.channel.commonutils.logger.b.a(e4);
            a(hbVar);
            dt.a(this.f70a).b(this.f70a.getPackageName(), ds.m381a(i), str, BaseWrapper.ENTER_ID_19);
            j.c(this.f70a, hbVar, z);
            return null;
        } catch (hu e5) {
            com.xiaomi.channel.commonutils.logger.b.a(e5);
            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
            dt.a(this.f70a).b(this.f70a.getPackageName(), ds.m381a(i), str, BaseWrapper.ENTER_ID_SYSTEM_HELPER);
            j.c(this.f70a, hbVar, z);
            return null;
        }
    }

    private void a(String str, long j, d dVar) {
        v vVarM125a = g.m125a(dVar);
        if (vVarM125a == null) {
            return;
        }
        if (j == 0) {
            synchronized (p.class) {
                if (p.a(this.f70a).m129a(str)) {
                    p.a(this.f70a).c(str);
                    if ("syncing".equals(p.a(this.f70a).a(vVarM125a))) {
                        p.a(this.f70a).a(vVarM125a, "synced");
                    }
                }
            }
            return;
        }
        if ("syncing".equals(p.a(this.f70a).a(vVarM125a))) {
            synchronized (p.class) {
                if (p.a(this.f70a).m129a(str)) {
                    if (p.a(this.f70a).a(str) < 10) {
                        p.a(this.f70a).b(str);
                        u.a(this.f70a).a(str, vVarM125a, dVar, "retry");
                    } else {
                        p.a(this.f70a).c(str);
                    }
                }
            }
            return;
        }
        p.a(this.f70a).c(str);
    }

    private void a(gw gwVar) {
        String strA = gwVar.a();
        com.xiaomi.channel.commonutils.logger.b.b("receive ack " + strA);
        Map<String, String> mapM534a = gwVar.m534a();
        if (mapM534a != null) {
            String str = mapM534a.get("real_source");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("receive ack : messageId = " + strA + "  realSource = " + str);
            bn.a(this.f70a).a(strA, str, Boolean.valueOf(gwVar.f613a == 0));
        }
    }

    public List<String> a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = ((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60;
        long j = ((((Long.parseLong(list.get(0).split(":")[0]) * 60) + Long.parseLong(list.get(0).split(":")[1])) - rawOffset) + 1440) % 1440;
        long j2 = ((((Long.parseLong(list.get(1).split(":")[0]) * 60) + Long.parseLong(list.get(1).split(":")[1])) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        return arrayList;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f70a.getSharedPreferences("mipush_extra", 0);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > 1800000) {
            MiPushClient.reInitialize(this.f70a, gt.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, jCurrentTimeMillis).commit();
        }
    }

    private void a(hb hbVar) {
        com.xiaomi.channel.commonutils.logger.b.m74a("receive a message but decrypt failed. report now.");
        he heVar = new he(hbVar.m553a().f568a, false);
        heVar.c(gp.DecryptMessageFail.f535a);
        heVar.b(hbVar.m554a());
        heVar.d(hbVar.f662b);
        HashMap map = new HashMap();
        heVar.f674a = map;
        map.put("regid", MiPushClient.getRegId(this.f70a));
        u.a(this.f70a).a(heVar, gf.Notification, false, (gs) null);
    }

    private void a(hi hiVar, hb hbVar) {
        gs gsVarM553a = hbVar.m553a();
        if (gsVarM553a != null) {
            gsVarM553a = au.a(gsVarM553a.m518a());
        }
        gv gvVar = new gv();
        gvVar.b(hiVar.b());
        gvVar.a(hiVar.m592a());
        gvVar.a(hiVar.a().a());
        if (!TextUtils.isEmpty(hiVar.c())) {
            gvVar.c(hiVar.c());
        }
        if (!TextUtils.isEmpty(hiVar.d())) {
            gvVar.d(hiVar.d());
        }
        gvVar.a(hp.a(this.f70a, hbVar));
        u.a(this.f70a).a(gvVar, gf.AckMessage, gsVarM553a);
    }

    private void a(he heVar) {
        gw gwVar = new gw();
        gwVar.c(gp.CancelPushMessageACK.f535a);
        gwVar.a(heVar.m568a());
        gwVar.a(heVar.a());
        gwVar.b(heVar.b());
        gwVar.e(heVar.d());
        gwVar.a(0L);
        gwVar.d("success clear push message.");
        u.a(this.f70a).a(gwVar, gf.Notification, false, true, null, false, this.f70a.getPackageName(), b.m99a(this.f70a).m100a(), false);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m130a(Context context, String str) {
        synchronized (f68a) {
            b.m99a(context);
            SharedPreferences sharedPreferencesA = b.a(context);
            if (f69a == null) {
                String[] strArrSplit = sharedPreferencesA.getString("pref_msg_ids", "").split(",");
                f69a = new LinkedList();
                for (String str2 : strArrSplit) {
                    f69a.add(str2);
                }
            }
            if (f69a.contains(str)) {
                return true;
            }
            f69a.add(str);
            if (f69a.size() > 25) {
                f69a.poll();
            }
            String strA = bb.a(f69a, ",");
            SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
            editorEdit.putString("pref_msg_ids", strA);
            com.xiaomi.push.p.a(editorEdit);
            return false;
        }
    }

    public static void a(Context context, String str) {
        synchronized (f68a) {
            f69a.remove(str);
            b.m99a(context);
            SharedPreferences sharedPreferencesA = b.a(context);
            String strA = bb.a(f69a, ",");
            SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
            editorEdit.putString("pref_msg_ids", strA);
            com.xiaomi.push.p.a(editorEdit);
        }
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i) {
        return x.b(context, str, map, i);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m131a(hb hbVar) {
        Map<String, String> mapM520a = hbVar.m553a() == null ? null : hbVar.m553a().m520a();
        if (mapM520a == null) {
            return false;
        }
        String str = mapM520a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
        return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
    }
}
