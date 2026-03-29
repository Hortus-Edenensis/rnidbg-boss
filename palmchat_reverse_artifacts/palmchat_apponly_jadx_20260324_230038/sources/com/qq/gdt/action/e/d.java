package com.qq.gdt.action.e;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.qq.gdt.action.j.o;
import com.tencent.turingfd.sdk.ams.ad.ITuringDID;
import com.tencent.turingfd.sdk.ams.ad.ITuringDeviceInfoProvider;
import com.tencent.turingfd.sdk.ams.ad.ITuringPrivacyPolicy;
import com.tencent.turingfd.sdk.ams.ad.TuringIDService;
import com.tencent.turingfd.sdk.ams.ad.TuringSDK;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f10483a;
    private static Handler b;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10487a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10488a;
        public String b;
        public String c;
        public int d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("actionSetId", com.qq.gdt.action.d.a().h());
            jSONObject.put("deviceId", com.qq.gdt.action.d.a().q());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static a a(Context context, boolean z) {
        a aVar = new a();
        if (context == null) {
            return aVar;
        }
        com.qq.gdt.action.d.a();
        boolean zW = com.qq.gdt.action.d.w();
        aVar.f10487a = c.a(com.qq.gdt.action.e.b.a(context, zW));
        aVar.b = c.a(com.qq.gdt.action.e.b.a(context, 0, zW));
        aVar.c = c.a(com.qq.gdt.action.e.b.a(context, 1, zW));
        aVar.d = c.a(com.qq.gdt.action.e.b.b(context, zW));
        aVar.e = c.a(com.qq.gdt.action.e.b.b(context, 0, zW));
        aVar.f = c.a(com.qq.gdt.action.e.b.b(context, 1, zW));
        aVar.g = c.a(com.qq.gdt.action.e.b.c(context, zW));
        aVar.h = c.a(com.qq.gdt.action.e.b.c(context, 0, zW));
        aVar.i = c.a(com.qq.gdt.action.e.b.c(context, 1, zW));
        aVar.j = com.qq.gdt.action.e.a.a(com.qq.gdt.action.e.b.a(context));
        aVar.k = i.a(context, z, zW);
        return aVar;
    }

    public static b b(Context context) {
        b bVar = new b();
        if (context == null) {
            return bVar;
        }
        ITuringDID turingDIDCached = TuringIDService.getTuringDIDCached(context.getApplicationContext());
        if (turingDIDCached == null) {
            o.a("fillAidTicketAndTaid TuringDIDService.getTuringDIDCached return null", new Object[0]);
            return bVar;
        }
        o.a(String.format("fillAidTicketAndTaid errorCode:%d aidTicket:%s, taidTicket:%s, expiredTimestamp:%d", Integer.valueOf(turingDIDCached.getErrorCode()), turingDIDCached.getAIDTicket(), "", Long.valueOf(turingDIDCached.getExpiredTimestamp())), new Object[0]);
        bVar.f10488a = turingDIDCached.getAIDTicket();
        bVar.b = "";
        bVar.c = turingDIDCached.getTAIDTicket();
        bVar.d = turingDIDCached.getErrorCode();
        if (turingDIDCached.getErrorCode() != 0) {
            JSONObject jSONObjectD = d();
            try {
                jSONObjectD.put("errorCode", turingDIDCached.getErrorCode());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.qq.gdt.action.h.a.a(3503, jSONObjectD);
        }
        return bVar;
    }

    private static void c(final Context context) {
        try {
            o.a(String.format("initTAIDSDK versionInfo:%s", TuringSDK.getVersionInfo()), new Object[0]);
            if (context == null) {
                o.c("init aid context is null");
            }
            int iInit = TuringSDK.createConf(context, new ITuringPrivacyPolicy() { // from class: com.qq.gdt.action.e.d.3
                @Override // com.tencent.turingfd.sdk.ams.ad.ITuringPrivacyPolicy, com.tencent.turingfd.sdk.ams.ad.Cassiopeia
                public boolean userAgreement() {
                    return true;
                }
            }).turingDeviceInfoProvider(new ITuringDeviceInfoProvider() { // from class: com.qq.gdt.action.e.d.2
                @Override // com.tencent.turingfd.sdk.ams.ad.ITuringDeviceInfoProvider
                public String getAndroidId() {
                    return com.qq.gdt.action.e.b.a(context);
                }

                @Override // com.tencent.turingfd.sdk.ams.ad.ITuringDeviceInfoProvider
                public String getImei() {
                    return com.qq.gdt.action.j.h.b();
                }

                @Override // com.tencent.turingfd.sdk.ams.ad.ITuringDeviceInfoProvider
                public String getImsi() {
                    return g.a();
                }
            }).channel(105548).build().init();
            if (iInit != 0) {
                JSONObject jSONObjectD = d();
                jSONObjectD.put("errorCode", iInit);
                com.qq.gdt.action.h.a.a(com.heytap.mcssdk.a.f, jSONObjectD);
            }
        } catch (Throwable unused) {
            o.c("GDTAction初始化失败，ErrorCode:02，请联系广点通运营");
            com.qq.gdt.action.h.a.a(com.heytap.mcssdk.a.f, d());
        }
    }

    private static void d(Context context) {
        if (context == null) {
            o.a("create error", new Object[0]);
        } else {
            a(context, true);
            b(context);
        }
    }

    public static void a(Context context) {
        new HandlerThread("appwaid").start();
        c(context);
        HandlerThread handlerThread = new HandlerThread("oaid");
        handlerThread.start();
        f10483a = new Handler(handlerThread.getLooper());
        b(context, 0L);
        HandlerThread handlerThread2 = new HandlerThread("openDeviceIdentifier");
        handlerThread2.start();
        b = new Handler(handlerThread2.getLooper());
        a(context, 0L);
        d(context);
    }

    private static void b(final Context context, long j) {
        if (context == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(context.getApplicationContext());
        f10483a.postDelayed(new Runnable() { // from class: com.qq.gdt.action.e.d.4
            @Override // java.lang.Runnable
            public void run() {
                Handler handler;
                int iX;
                o.a(String.format("updateForAidTicketAndTaidTicket", new Object[0]), new Object[0]);
                ITuringDID turingDID = TuringIDService.getTuringDID((Context) weakReference.get());
                if (turingDID == null) {
                    o.a("updateForAidTicketAndTaidTicket TuringDIDService.getTuringDID return null", new Object[0]);
                    return;
                }
                o.a(String.format("updateForAidTicketAndTaidTicket errorCode:%d, aidTicket:%s, taid:%s, expiredTimestamp:%d", Integer.valueOf(turingDID.getErrorCode()), turingDID.getAIDTicket(), "", Long.valueOf(turingDID.getExpiredTimestamp())), new Object[0]);
                if (turingDID.getErrorCode() == 0) {
                    if (com.qq.gdt.action.b.a(context).f() > 0) {
                        handler = d.f10483a;
                        iX = com.qq.gdt.action.b.a(context).f();
                        handler.postDelayed(this, iX);
                    }
                } else if (turingDID.getErrorCode() == -10004 || turingDID.getErrorCode() == -10012 || turingDID.getErrorCode() == -21052 || turingDID.getErrorCode() == -22056) {
                    handler = d.f10483a;
                    iX = com.qq.gdt.action.b.a(context).x();
                    handler.postDelayed(this, iX);
                }
                if (turingDID.getErrorCode() != 0) {
                    JSONObject jSONObjectD = d.d();
                    try {
                        jSONObjectD.put("errorCode", turingDID.getErrorCode());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    com.qq.gdt.action.h.a.a(3504, jSONObjectD);
                }
            }
        }, j);
    }

    public static void a(final Context context, long j) {
        if (context == null) {
            return;
        }
        b.postDelayed(new Runnable() { // from class: com.qq.gdt.action.e.d.1
            @Override // java.lang.Runnable
            public void run() {
                o.a(String.format("updateForOpenDeviceIdentifier", new Object[0]), new Object[0]);
                if (!com.qq.gdt.action.a.c.a(context).isEmpty()) {
                    com.qq.gdt.action.a.a.a(context);
                }
                d.b.postDelayed(this, com.qq.gdt.action.b.a(context).w());
            }
        }, j);
    }
}
