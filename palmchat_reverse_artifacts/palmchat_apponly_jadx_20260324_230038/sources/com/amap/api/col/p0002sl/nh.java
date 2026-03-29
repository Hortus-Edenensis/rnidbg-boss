package com.amap.api.col.p0002sl;

import android.content.Context;
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
public final class nh {
    private static nh b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    hx f3034a;
    private Context c;
    private int d = 0;
    private int e = nl.f;
    private boolean f = false;
    private int g = 0;

    private nh(Context context) {
        this.f3034a = null;
        this.c = null;
        try {
            fx.a().a(context);
        } catch (Throwable unused) {
        }
        this.c = context;
        this.f3034a = hx.a();
    }

    public final ie a(ni niVar) throws Throwable {
        long jB = np.b();
        ie ieVarA = hx.a(niVar, this.f || np.e(this.c));
        this.d = Long.valueOf(np.b() - jB).intValue();
        return ieVarA;
    }

    public static nh a(Context context) {
        if (b == null) {
            b = new nh(context);
        }
        return b;
    }

    public final ni a(Context context, byte[] bArr, String str) {
        String str2;
        try {
            HashMap map = new HashMap(16);
            ni niVar = new ni(context, nl.b());
            try {
                map.put("Content-Type", "application/octet-stream");
                map.put(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
                map.put("gzipped", "1");
                map.put("Connection", HTTP.CONN_KEEP_ALIVE);
                map.put("User-Agent", "AMAP_Location_SDK_Android 4.7.0");
                map.put("KEY", fr.f(context));
                map.put("enginever", "5.1");
                String strA = fu.a();
                String strA2 = fu.a(context, strA, "key=" + fr.f(context));
                map.put("ts", strA);
                map.put("scode", strA2);
                map.put("encr", "1");
                niVar.b(map);
                niVar.D();
                niVar.a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "4.7.0", "loc", 3));
                niVar.C();
                niVar.b(str);
                niVar.b(np.a(bArr));
                niVar.a(gc.a(context));
                HashMap map2 = new HashMap(16);
                map2.put("output", "bin");
                map2.put(bt.bn, "3103");
                int i = this.g;
                if (i == 0) {
                    map2.remove(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
                } else {
                    if (i != 1) {
                        str2 = i == 2 ? "language:en" : "language:cn";
                        map2.remove(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
                    }
                    map2.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, str2);
                }
                niVar.a((Map<String, String>) map2);
                niVar.a(this.e);
                niVar.b(this.e);
                if ((!this.f && !np.e(context)) || !str.startsWith("http:")) {
                    return niVar;
                }
                niVar.b(niVar.f().replace("https:", "https:"));
                return niVar;
            } catch (Throwable unused) {
                return niVar;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final void a(long j, boolean z) {
        try {
            this.f = z;
            try {
                fx.a().a(z);
            } catch (Throwable unused) {
            }
            this.e = Long.valueOf(j).intValue();
            this.g = 0;
        } catch (Throwable th) {
            nl.a(th, "LocNetManager", "setOption");
        }
    }
}
