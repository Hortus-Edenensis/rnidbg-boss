package com.amap.api.col.p0002sl;

import android.content.Context;
import com.amap.api.col.p0002sl.id;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.efs.sdk.base.Constants;
import com.umeng.analytics.pro.bt;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class lz {
    private static lz b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    hx f2986a;
    private Context c;
    private int d = me.i;
    private boolean e = false;
    private int f = 0;

    private lz(Context context) {
        this.f2986a = null;
        this.c = null;
        try {
            fx.a().a(context);
        } catch (Throwable unused) {
        }
        this.c = context;
        this.f2986a = hx.a();
    }

    public static lz a(Context context) {
        if (b == null) {
            b = new lz(context);
        }
        return b;
    }

    public final void a(long j, boolean z, int i) {
        try {
            this.e = z;
            this.d = Long.valueOf(j).intValue();
            this.f = i;
        } catch (Throwable th) {
            me.a(th, "LocNetManager", "setOption");
        }
    }

    public final ma a(Context context, byte[] bArr, String str, String str2, boolean z) {
        try {
            HashMap map = new HashMap(16);
            ma maVar = new ma(context, me.c());
            try {
                map.put("Content-Type", "application/octet-stream");
                map.put(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
                map.put("gzipped", "1");
                map.put("Connection", HTTP.CONN_KEEP_ALIVE);
                map.put("User-Agent", "AMAP_Location_SDK_Android 6.4.5");
                map.put("KEY", fr.f(context));
                map.put("enginever", me.f2999a);
                String strA = fu.a();
                String strA2 = fu.a(context, strA, "key=" + fr.f(context));
                map.put("ts", strA);
                map.put("scode", strA2);
                if (Double.valueOf(me.f2999a).doubleValue() >= 5.3d) {
                    map.put("aps_s_src", "openapi");
                }
                map.put("encr", "1");
                maVar.b(map);
                String str3 = z ? "loc" : "locf";
                maVar.c(true);
                maVar.a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.4.5", str3, 3));
                maVar.b(z);
                maVar.b(str);
                maVar.c(str2);
                maVar.c(mm.a(bArr));
                maVar.a(gc.a(context));
                HashMap map2 = new HashMap(16);
                map2.put("output", "bin");
                map2.put(bt.bn, "3103");
                int i = this.f;
                if (i == 0) {
                    map2.remove(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
                } else if (i == 1) {
                    map2.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, "language:cn");
                } else if (i != 2) {
                    map2.remove(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
                } else {
                    map2.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, "language:en");
                }
                maVar.a((Map<String, String>) map2);
                maVar.a(this.d);
                maVar.b(this.d);
                if (!this.e) {
                    return maVar;
                }
                maVar.a(id.c.HTTPS);
                return maVar;
            } catch (Throwable unused) {
                return maVar;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final ie a(ma maVar) throws Throwable {
        if (this.e) {
            maVar.a(id.c.HTTPS);
        }
        return hx.c(maVar);
    }

    public final String a(Context context, double d, double d2) {
        try {
            HashMap map = new HashMap(16);
            ma maVar = new ma(context, me.c());
            map.clear();
            map.put("Content-Type", "application/x-www-form-urlencoded");
            map.put("Connection", HTTP.CONN_KEEP_ALIVE);
            map.put("User-Agent", "AMAP_Location_SDK_Android 6.4.5");
            HashMap map2 = new HashMap(16);
            map2.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, "26260A1F00020002");
            map2.put("key", fr.f(context));
            int i = this.f;
            if (i == 0) {
                map2.remove("language");
            } else if (i == 1) {
                map2.put("language", "zh-CN");
            } else if (i != 2) {
                map2.remove("language");
            } else {
                map2.put("language", "en");
            }
            map2.put("curLocationType", mm.m(this.c) ? "coarseLoc" : "fineLoc");
            String strA = fu.a();
            String strA2 = fu.a(context, strA, ge.b(map2));
            map2.put("ts", strA);
            map2.put("scode", strA2);
            maVar.b(("output=json&radius=1000&extensions=all&location=" + d2 + "," + d).getBytes("UTF-8"));
            maVar.c(false);
            maVar.b(true);
            maVar.a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.4.5", "loc", 3));
            maVar.a((Map<String, String>) map2);
            maVar.b(map);
            maVar.a(gc.a(context));
            maVar.a(me.i);
            maVar.b(me.i);
            try {
                maVar.c("http://dualstack-arestapi.amap.com/v3/geocode/regeo");
                maVar.b("http://restsdk.amap.com/v3/geocode/regeo");
                if (this.e) {
                    maVar.a(id.c.HTTPS);
                }
                return new String(hx.c(maVar).f2902a, "utf-8");
            } catch (Throwable th) {
                me.a(th, "LocNetManager", "post");
                return null;
            }
        } catch (Throwable unused) {
        }
    }
}
