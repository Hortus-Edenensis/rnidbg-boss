package com.amap.api.col.p0002sl;

import android.content.Context;
import android.util.Log;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.efs.sdk.base.Constants;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public final class ft {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f2800a = -1;
    public static String b = "";
    private static gd c = null;
    private static String d = "http://apiinit.amap.com/v3/log/init";
    private static String e;

    @Deprecated
    public static synchronized boolean a(Context context, gd gdVar) {
        return b(context, gdVar);
    }

    private static boolean b(Context context, gd gdVar) {
        c = gdVar;
        try {
            String str = d;
            HashMap map = new HashMap();
            map.put("Content-Type", "application/x-www-form-urlencoded");
            map.put(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
            map.put("Connection", HTTP.CONN_KEEP_ALIVE);
            map.put("User-Agent", c.d());
            map.put("X-INFO", fu.b(context));
            map.put("logversion", "2.1");
            map.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", c.b(), c.a()));
            hx hxVarA = hx.a();
            gf gfVar = new gf();
            gfVar.a(gc.a(context));
            gfVar.a((Map<String, String>) map);
            gfVar.b(a(context));
            gfVar.a(str);
            return a(hxVarA.b(gfVar));
        } catch (Throwable th) {
            ha.a(th, "Auth", "getAuth");
            return true;
        }
    }

    public static void a(String str) {
        fr.b(str);
    }

    private static boolean a(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(ge.a(bArr));
            if (jSONObject.has("status")) {
                int i = jSONObject.getInt("status");
                if (i == 1) {
                    f2800a = 1;
                } else if (i == 0) {
                    f2800a = 0;
                }
            }
            if (jSONObject.has("info")) {
                b = jSONObject.getString("info");
            }
            if (f2800a == 0) {
                Log.i("AuthFailure", b);
            }
            return f2800a == 1;
        } catch (JSONException e2) {
            ha.a(e2, "Auth", "lData");
            return false;
        } catch (Throwable th) {
            ha.a(th, "Auth", "lData");
            return false;
        }
    }

    private static Map<String, String> a(Context context) {
        HashMap map = new HashMap();
        try {
            map.put("resType", BodyData.TYPE_JSON);
            map.put("encode", "UTF-8");
            String strA = fu.a();
            map.put("ts", strA);
            map.put("key", fr.f(context));
            map.put("scode", fu.a(context, strA, ge.d("resType=json&encode=UTF-8&key=" + fr.f(context))));
        } catch (Throwable th) {
            ha.a(th, "Auth", "gParams");
        }
        return map;
    }
}
