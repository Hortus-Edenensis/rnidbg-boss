package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.p0002sl.eh;
import com.amap.api.col.p0002sl.fs;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.huawei.openalliance.ad.constant.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class dr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static gd f2694a;
    private static dr b;
    private static Context c;
    private a d;
    private HandlerThread e = new HandlerThread("manifestThread") { // from class: com.amap.api.col.2sl.dr.1
        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            Thread.currentThread().setName("ManifestConfigThread");
            gd gdVarA = dh.a(false);
            dr.c(dr.c);
            fs.a(dr.c, gdVarA, "11K" + x.aQ + PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY + x.aQ + "184" + x.aQ + "185", new fs.a() { // from class: com.amap.api.col.2sl.dr.1.1
                @Override // com.amap.api.col.2sl.fs.a
                public final void a(fs.b bVar) {
                    a aVar;
                    JSONObject jSONObject;
                    JSONObject jSONObjectOptJSONObject;
                    JSONObject jSONObject2;
                    JSONObject jSONObjectOptJSONObject2;
                    Message message = new Message();
                    if (bVar != null) {
                        try {
                            fs.b.a aVar2 = bVar.g;
                            if (aVar2 != null) {
                                message.obj = new ds(aVar2.b, aVar2.f2794a);
                            }
                        } catch (Throwable th) {
                            try {
                                di.a(th, "ManifestConfig", "run");
                                if (aVar == null) {
                                    return;
                                }
                            } finally {
                                message.what = 3;
                                if (dr.this.d != null) {
                                    dr.this.d.sendMessage(message);
                                }
                            }
                        }
                    }
                    if (bVar != null && (jSONObject2 = bVar.f) != null && (jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("184")) != null) {
                        dr.d(jSONObjectOptJSONObject2);
                        eq.a(dr.c, "amap_search", "cache_control", jSONObjectOptJSONObject2.toString());
                    }
                    if (bVar != null && (jSONObject = bVar.f) != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("185")) != null) {
                        dr.c(jSONObjectOptJSONObject);
                        eq.a(dr.c, "amap_search", "parm_control", jSONObjectOptJSONObject.toString());
                    }
                    message.what = 3;
                    if (dr.this.d == null) {
                    }
                }
            });
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f2697a;

        public a(Looper looper) {
            super(looper);
            this.f2697a = "handleMessage";
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message != null && message.what == 3) {
                try {
                    ds dsVar = (ds) message.obj;
                    if (dsVar == null) {
                        dsVar = new ds(false, false);
                    }
                    hd.a(dr.c, dh.a(dsVar.a()));
                    dr.f2694a = dh.a(dsVar.a());
                } catch (Throwable th) {
                    di.a(th, "ManifestConfig", this.f2697a);
                }
            }
        }
    }

    private dr(Context context) {
        c = context;
        f2694a = dh.a(false);
        try {
            b();
            this.d = new a(Looper.getMainLooper());
            this.e.start();
        } catch (Throwable th) {
            di.a(th, "ManifestConfig", "ManifestConfig");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        try {
            String str = (String) eq.b(context, "amap_search", "cache_control", "");
            if (!TextUtils.isEmpty(str)) {
                d(new JSONObject(str));
            }
            String str2 = (String) eq.b(context, "amap_search", "parm_control", "");
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            c(new JSONObject(str2));
        } catch (Throwable th) {
            di.a(th, "ManifestConfig", "ManifestConfig-readAuthFromCache");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("able")) {
                    eh.a aVarA = a(jSONObject, true, (eh.a) null);
                    eh.a().a(aVarA);
                    if (aVarA.a()) {
                        a("regeo", jSONObject, aVarA);
                        a(MapBundleKey.MapObjKey.OBJ_GEO, jSONObject, aVarA);
                        a("placeText", jSONObject, aVarA);
                        a("placeAround", jSONObject, aVarA);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void b() {
        eg.a();
    }

    public static dr a(Context context) {
        if (b == null) {
            b = new dr(context);
        }
        return b;
    }

    private static void a(String str, JSONObject jSONObject, eh.a aVar) {
        if (jSONObject != null && jSONObject.has(str)) {
            eh.a().a(str, a(jSONObject.optJSONObject(str), false, aVar));
        }
    }

    private static eh.a a(JSONObject jSONObject, boolean z, eh.a aVar) {
        boolean zOptBoolean;
        eh.a aVar2 = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            eh.a aVar3 = new eh.a();
            try {
                if (z) {
                    zOptBoolean = fs.a(jSONObject.optString("able"), aVar == null || aVar.a());
                } else {
                    zOptBoolean = jSONObject.optBoolean("able", aVar == null || aVar.a());
                }
                int iOptInt = jSONObject.optInt("timeoffset", aVar != null ? (int) aVar.b() : 86400);
                int iOptInt2 = jSONObject.optInt("num", aVar != null ? aVar.c() : 10);
                double dOptDouble = jSONObject.optDouble("limitDistance", aVar != null ? aVar.d() : 0.0d);
                aVar3.a(zOptBoolean);
                aVar3.a(iOptInt);
                aVar3.a(iOptInt2);
                aVar3.a(dOptDouble);
                return aVar3;
            } catch (Throwable th) {
                th = th;
                aVar2 = aVar3;
                th.printStackTrace();
                return aVar2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                boolean zA = fs.a(jSONObject.optString("passAreaAble"), true);
                boolean zA2 = fs.a(jSONObject.optString("truckAble"), true);
                boolean zA3 = fs.a(jSONObject.optString("poiPageAble"), true);
                boolean zA4 = fs.a(jSONObject.optString("rideAble"), true);
                boolean zA5 = fs.a(jSONObject.optString("walkAble"), true);
                boolean zA6 = fs.a(jSONObject.optString("passPointAble"), true);
                boolean zA7 = fs.a(jSONObject.optString("keyWordLenAble"), true);
                int iOptInt = jSONObject.optInt("poiPageMaxSize", 25);
                int iOptInt2 = jSONObject.optInt("passAreaMaxCount", 100);
                int iOptInt3 = jSONObject.optInt("walkMaxLength", 100);
                int iOptInt4 = jSONObject.optInt("passPointMaxCount", 6);
                int iOptInt5 = jSONObject.optInt("poiPageMaxNum", 100);
                int iOptInt6 = jSONObject.optInt("truckMaxLength", 5000);
                int iOptInt7 = jSONObject.optInt("rideMaxLength", 1200);
                int iOptInt8 = jSONObject.optInt("passAreaMaxArea", 100000000);
                int iOptInt9 = jSONObject.optInt("passAreaPointCount", 16);
                int iOptInt10 = jSONObject.optInt("keyWordLenMaxNum", 100);
                ek.a().a(zA);
                ek.a().c(iOptInt2);
                ek.a().i(iOptInt8);
                ek.a().j(iOptInt9);
                ek.a().b(zA2);
                ek.a().g(iOptInt6);
                ek.a().c(zA3);
                ek.a().f(iOptInt5);
                ek.a().a(iOptInt);
                ek.a().b(iOptInt10);
                ek.a().g(zA7);
                ek.a().d(zA4);
                ek.a().h(iOptInt7);
                ek.a().e(zA5);
                ek.a().d(iOptInt3);
                ek.a().f(zA6);
                ek.a().e(iOptInt4);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
